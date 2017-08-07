package com.varuchin.training.services;

import com.varuchin.training.beans.ThemeMessage;
import com.varuchin.training.dao.ThemeMessageDataAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeMessageService {

    @Autowired
    private ThemeMessageDataAccessor themeMessageDataAccessor;

    public void add(ThemeMessage themeMessage) {
        themeMessageDataAccessor.add(themeMessage);
    }

    public ThemeMessage getById(long id) {
        return themeMessageDataAccessor.getById(id);
    }

    public List<ThemeMessage> getThemeMessages(Integer page, Integer pageSize, long themeId) {
        return themeMessageDataAccessor.getThemeMessages(page, pageSize, themeId);
    }
}
