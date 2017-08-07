package com.varuchin.training.dao;

import com.varuchin.training.beans.ThemeMessage;

import java.util.List;

public interface ThemeMessageDataAccessor {

    void add(ThemeMessage themeMessage);

    ThemeMessage getById(long id);

    List<ThemeMessage> getThemeMessages(Integer page, Integer pageSize, long themeId);
}
