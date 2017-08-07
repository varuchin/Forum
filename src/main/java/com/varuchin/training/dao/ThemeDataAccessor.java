package com.varuchin.training.dao;

import com.varuchin.training.beans.Theme;

import java.util.List;

public interface ThemeDataAccessor {

    void add(Theme theme);

    Theme getById(long id);

    Theme getByName(String name);

    List<String> getMessages(Integer page, Integer pageSize, long themeId);

    List<Theme> getForumThemes(Integer page, Integer pageSize);
}
