package ru.mephi.qualityManagement.web.Statistic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import ru.mephi.qualityManagement.model.Process;
import ru.mephi.qualityManagement.model.Rate;
import ru.mephi.qualityManagement.model.User;
import ru.mephi.qualityManagement.service.ProcessService;
import ru.mephi.qualityManagement.service.RateService;
import ru.mephi.qualityManagement.service.UserService;
import ru.mephi.qualityManagement.to.RateTo;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Анастасия on 06.01.2018.
 */
@RestController
@RequestMapping("/ajax/profile/responsibles")
public class ResponsibleAjaxController {
    @Autowired
    private ProcessService processService;
    @Autowired
    private RateService rateService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllWithExceed() {
        return getAllResponsibles(userService.getAll(), processService.getAll());
    }


    @RequestMapping(method = RequestMethod.POST)
    public void update(@Valid Process process, BindingResult result, SessionStatus status) {

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Process get(@PathVariable("id") int id) {
        return get(id);
    }

    private List<Process> filterWithExceed(List<Process> processList) {
        List<Process> list = new ArrayList<>();
        for (Process process : processList) {
            if (process.getEnd_time() != null) {
                list.add(process);
            }
        }
        return list;
    }

    private List<User> getAllResponsibles(List<User> userList, List<Process> processList) {
        List<Rate> result = new ArrayList<>();
        List<User> returns = new ArrayList<>();
        for (Process process : processList) {
            for (User user : userList) {
                List<Rate> list = user.getRates();
                list.retainAll(RateToToRatesList(process.getRatesList()));
                if (!list.isEmpty())
                    result.addAll(list);
            }
        }
        for (Rate rate : result) {
            returns.add(rate.getUser());
        }
        return returns;
    }

    private List<Rate> RateToToRatesList(List<RateTo> rateToList) {
        List<Rate> result = new ArrayList<>();
        for (RateTo rateTo : rateToList) {
            result.add(rateService.get(rateTo.getRateId()));
        }
        return result;
    }

}
