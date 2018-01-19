package ru.javawebinar.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.CriteriaService;
import ru.javawebinar.topjava.service.ProcessService;
import ru.javawebinar.topjava.service.TargetCriteriaService;
import ru.javawebinar.topjava.service.UserService;
import ru.javawebinar.topjava.to.DateTimeFilter;
import ru.javawebinar.topjava.to.UserTo;

import javax.validation.Valid;
import java.util.ArrayList;


@Controller
public class RootController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProcessService processService;

    @Autowired
    private CriteriaService criteriaService;

    @Autowired
    private TargetCriteriaService targetCriteriaService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:processes";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model,
                        @RequestParam(value = "error", required = false) boolean error,
                        @RequestParam(value = "message", required = false) String message) {

        model.put("error", error);
        model.put("message", message);
        return "login";
    }

    @RequestMapping(value = "/meals", method = RequestMethod.GET)
    public String mealList(Model model) {
        model.addAttribute("filter", new DateTimeFilter());
        return "mealList";
    }

    @RequestMapping(value = "/processes", method = RequestMethod.GET)
    public String processList(Model model) {
        model.addAttribute("filter", new DateTimeFilter());
        model.addAttribute("positions", processService.getAllPositions());
        return "processList";
    }

    //    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList() {
        return "userList";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(ModelMap model) {
        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String updateProfile(@Valid UserTo userTo, BindingResult result, SessionStatus status, ModelMap model) {
        if (result.hasErrors()) {
            return "profile";
        } else {
            status.setComplete();
            LoggedUser.get().updateUserTo(userTo);
            userService.update(userTo);
            return "redirect:processes";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("register", true);
        return "profile";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegister(@Valid User user, BindingResult result, SessionStatus status, ModelMap model) {
        if (result.hasErrors()) {
            model.addAttribute("register", true);
            return "profile";
        } else {
            status.setComplete();
            userService.save(user);
            return "redirect:login?message=app.registered";
        }
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public String statistics(Model model) {
        return "statistics";
    }

    @RequestMapping(value = "/responsibles", method = RequestMethod.GET)
    public String responsibles(Model model) {
        model.addAttribute("processes", processService.getAll());
        return "ResponsiblesList";
    }

    @RequestMapping(value = "/cancelled_processes", method = RequestMethod.GET)
    public String cancelledProcesses(Model model) {
        model.addAttribute("filter", new DateTimeFilter());
        model.addAttribute("positions", processService.getAllPositions());
        model.addAttribute("criterias", criteriaService.getAll());
        return "cancelledProcesses";
    }

    @RequestMapping(value = "/target_criteria", method = RequestMethod.GET)
    public String targetCriteria(Model model) {
        model.addAttribute("criterias", targetCriteriaService.getAll());
        return "targetCriteria";
    }

}
