//package com.varuchin.training.controllers;
//
//import com.varuchin.training.beans.Theme;
//import com.varuchin.training.beans.User;
//import com.varuchin.training.dao.ThemeDataAccessor;
//import com.varuchin.training.dao.ThemeMessageDataAccessor;
//import com.varuchin.training.dao.UserDataAccessor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//public class ThemesManagementController {
//
//    @Autowired
//    private ThemeDataAccessor themeDataAccessor;
//    @Autowired
//    private ThemeMessageDataAccessor themeMessageDataAccessor;
//    @Autowired
//    private UserDataAccessor userDataAccessor;
//
//    @RequestMapping(value = "/users/{id}/addTheme", method = RequestMethod.GET)
//    public ModelAndView getForumThemes(@PathVariable("id") long id) {
//        User user = userDataAccessor.getById(id);
//
//
//        return null;
//    }
//
//    @RequestMapping(value = "/addTheme", method = RequestMethod.GET)
//    public String getTheme(Model model) {
//        model.addAttribute("theme", new Theme());
//        return "newtheme";
//    }
//}
