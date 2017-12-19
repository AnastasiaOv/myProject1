package ru.javawebinar.topjava.web.Statistic;

import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import ru.javawebinar.topjava.model.Process;
import ru.javawebinar.topjava.to.DateTimeFilter;
import ru.javawebinar.topjava.web.process.AbstractProcessController;

import javax.validation.Valid;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static ru.javawebinar.topjava.util.TimeUtil.*;

/**
 * Created by Анастасия on 17.12.2017.
 */
@RestController
@RequestMapping("/ajax/profile/cancelled_processes")
public class CancelledProcessAjaxController extends AbstractProcessController {
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Process> getAllWithExceed() {
        return getAllCancelled(super.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void update(@Valid Process process, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            throw LOG.getValidationException(result);
        } else {
            status.setComplete();
            if (process.getId() == null || process.getId() == 0) {
                super.create(process);
            } else {
                super.update(process, process.getId());
            }
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Process get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Process> filterWithExceed(DateTimeFilter filter) {
        return filterWithExceed(super.getBetween(dateTimeFromString(filter.getStartDate(), filter.getStartTime()), dateTimeFromString(filter.getEndDate(), filter.getEndTime())));
    }

    private List<Process> filterWithExceed(List<Process> processList) {
        List<Process> list = new ArrayList<>();
        for (Process process : processList) {
            if (process.getEnd_time()!=null) {
                list.add(process);
            }
        }
        return list;
    }

    private List<Process> getAllCancelled(List<Process> processList) {
        List<Process> list = new ArrayList<>();
        for (Process process : processList) {
            if (process.getEnd_time() != null)
                list.add(process);
        }
        return list;
    }
}
