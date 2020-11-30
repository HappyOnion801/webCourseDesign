package com.zh.courseDesign.web.dao.inter;

import com.zh.courseDesign.web.bean.News;

import java.util.List;

/**
 * @author MaCode
 * @date 2020-11-30
 * @github HappyOnion801
 */
public interface INews {
    public List<News> newsAllList(int page);

    public List<News> newsAllList(String title, int page);

    public int newsAdd(News news);

    public boolean newsDelete(int id);

    public boolean newsUpdate(News news);

    public News newsDisplay(int id);

    public boolean newsExists(int id);

    public int newsAllCount();
}
