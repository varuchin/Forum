package com.varuchin.training.controllers;

import com.varuchin.training.dao.ThemeDataAccessor;
import com.varuchin.training.dao.ThemeMessageDataAccessor;
import com.varuchin.training.dao.UserDataAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThemeMessagesController {

    @Autowired
    private UserDataAccessor userDataAccessor;
    @Autowired
    private ThemeDataAccessor themeDataAccessor;
    @Autowired
    private ThemeMessageDataAccessor themeMessageDataAccessor;

//    @RequestMapping("/themes/{id}/")
//    public ModelAndView addMessage()
}
