package ru.mephi.qualityManagement.web.Statistic;

import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import ru.mephi.qualityManagement.model.Process;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Анастасия on 17.12.2017.
 */
@RestController
@RequestMapping("/ajax/profile/statistics")
public class StatisticsAjaxController extends AbstractStatisticController {
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Process> getAllProcesses() {
        return getAll();
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

}
