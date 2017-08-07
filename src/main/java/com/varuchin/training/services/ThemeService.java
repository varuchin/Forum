package com.varuchin.training.services;

import com.varuchin.training.beans.Theme;
import com.varuchin.training.dao.ThemeDataAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {

    @Autowired
    private ThemeDataAccessor themeDataAccessor;

    public void add(Theme theme) {
        themeDataAccessor.add(theme);
    }

    public Theme getById(long id) {
        return themeDataAccessor.getById(id);
    }

    public Theme getByName(String name) {
        return themeDataAccessor.getByName(name);
    }

    public List<String> getMessages(Integer page, Integer pageSize, long themeId) {
        return themeDataAccessor.getMessages(page, pageSize,  themeId);
    }

    public List<Theme> getForumThemes(Integer page, Integer pageSize) {
        return themeDataAccessor.getForumThemes(page, pageSize);
    }
}
