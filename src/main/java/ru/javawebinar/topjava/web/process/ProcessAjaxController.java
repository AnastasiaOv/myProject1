package ru.javawebinar.topjava.web.process;

import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.Process;
import ru.javawebinar.topjava.to.DateTimeFilter;
import ru.javawebinar.topjava.to.UserMealWithExceed;
import ru.javawebinar.topjava.util.TimeUtil;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ru.javawebinar.topjava.util.TimeUtil.endDateTime;
import static ru.javawebinar.topjava.util.TimeUtil.startDateTime;
import static ru.javawebinar.topjava.util.TimeUtil.toTime;

/**
 * Created by Анастасия on 27.11.2017.
 */
@RestController
@RequestMapping("/ajax/profile/processes")
public class ProcessAjaxController extends AbstractProcessController {
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Process> getAllWithExceed() {
        return filterWithExceed(super.getAll(), LocalTime.MIN, LocalTime.MAX);
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
            if (process.getId() == 0) {
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
        return filterWithExceed(super.getBetween(startDateTime(filter.getStartDate()), endDateTime(filter.getEndDate())),
                toTime(filter.getStartTime(), LocalTime.MIN), toTime(filter.getEndTime(), LocalTime.MAX));
    }

    public List<Process> filterWithExceed(List<Process> mealList, LocalTime startTime, LocalTime endTime) {
        int caloriesPerDay = LoggedUser.get().getUserTo().getCaloriesPerDay();
        Map<LocalDate, Integer> groupAndSumMap = mealList.stream().collect(Collectors.groupingBy(
                userMeal -> userMeal.getStart_time().toLocalDate(),
                Collectors.summingInt(Process::getLevel)
        ));
        List<Process> list = new ArrayList<>();
        for (Process meal : mealList) {
            if (TimeUtil.isBetween(meal.getStart_time().toLocalTime(), startTime, endTime)) {
                Process userMealWithExceed = new Process(meal.getId(), meal.getProcessName(),meal.getLevel(), meal.getStart_time(), meal.getEnd_time(), meal.getDefinition(),
                        meal.getPositionList());
                list.add(userMealWithExceed);
            }
        }
        return list;
    }
}
