package ru.javawebinar.topjava.web.TargetCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import ru.javawebinar.topjava.model.TargetCriteria;
import ru.javawebinar.topjava.service.ProcessService;
import ru.javawebinar.topjava.service.TargetCriteriaService;
import ru.javawebinar.topjava.service.UserService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Анастасия on 18.01.2018.
 */
@RestController
@RequestMapping("/ajax/profile/targetCriteria")
public class TargetCriteriaAjaxController {
    @Autowired
    private ProcessService processService;
    @Autowired
    private TargetCriteriaService targetCriteriaService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TargetCriteria> getAllTargetCriteria() {
        return targetCriteriaService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        targetCriteriaService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void update(@Valid Process process, BindingResult result, SessionStatus status) {

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public TargetCriteria get(@PathVariable("id") int id) {
        return targetCriteriaService.get(id);
    }
}
