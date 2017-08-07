package com.varuchin.training.controllers;

import com.varuchin.training.beans.Theme;
import com.varuchin.training.beans.ThemeMessage;
import com.varuchin.training.exceptions.AuthorizationException;
import com.varuchin.training.security.SecurityManager;
import com.varuchin.training.services.ThemeMessageService;
import com.varuchin.training.services.ThemeService;
import com.varuchin.training.services.UserService;
import com.varuchin.training.views.Login;
import com.varuchin.training.views.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//security credentials must be provided in every http query from front-end
//and then validated using com.varuchin.training.utils.UserCredentialsValidator
@Controller
public class ForumController {

    @Autowired
    private UserService userService;
    @Autowired
    private ThemeService themeService;
    @Autowired
    private ThemeMessageService themeMessageService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) throws Exception {
        model.addAttribute("login", new Login());
        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("registration", new Registration());
        return "registration";
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String signIn(@ModelAttribute("login") Login login, Model model) throws AuthorizationException {
        SecurityManager.validateUserCredentials(login.getEmail(), login.getPassword());
        //page and page size must be received from front-end
        List<Theme> themes = themeService.getForumThemes(0, 10);
        model.addAttribute("themes", themes);
        return "homePage";
    }

    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    public String homePage(Model model) {
        model.addAttribute("many", themeService.getForumThemes(0, 10));
        return "homePage";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("signUp") Registration registration, Model model) throws Exception {
        userService.addAndValidateNewUser(registration);
        model.addAttribute("login", new Login());
        return "login";
    }

    @RequestMapping(value = "/newTheme", method = RequestMethod.GET)
    public String getTheme(Model model) {
        model.addAttribute("theme", new Theme());
        return "newtheme";
    }

    @RequestMapping(value = "/addTheme", method = RequestMethod.POST)
    public String addTheme(@ModelAttribute("theme") Theme theme, Model model) {
        themeService.add(theme);
        //page and page size must be received from front-end
        model.addAttribute("themes", themeService.getForumThemes(0, 10));
        return "homepage";
    }

    @RequestMapping(value = "/showTheme", method = RequestMethod.GET)
    public String showTheme(@ModelAttribute("theme") Theme theme, Model model) {
        Theme result = themeService.getByName(theme.getName());
        //page and page size must be received from front-end

        model.addAttribute("themeMessages", themeService.getMessages(0, 1, result.getId()));
        return "showTheme";
    }

    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    public String addMessage(@RequestHeader("themeId") long themeId, @ModelAttribute("message") ThemeMessage message, Model model) {
        themeMessageService.add(message);
        //page and page size must be received from front-end
        model.addAttribute("themes", themeMessageService.getThemeMessages(0, 10, themeId));
        return "homepage";
    }
}


