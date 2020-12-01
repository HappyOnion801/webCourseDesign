package com.zh.courseDesign.web.Test;

import com.zh.courseDesign.web.bean.News;
import com.zh.courseDesign.web.dao.bean.NewsDAO;
import org.junit.Test;

import java.util.List;

/**
 * @author MaCode
 * @date 2020-12-01
 * @github HappyOnion801
 */
public class TestNewsDAO {
    @Test
    public void newsAdd() {
        News news = new News("zhanghao", "zhanghaozhenshuai", "zhanghao", "2020-01-01");
        NewsDAO newsDAO = new NewsDAO();
        System.out.print("添加新闻：");
        System.out.println(newsDAO.newsAdd(news));
    }

    @Test
    public void newsAllList() {
        NewsDAO newsDAO = new NewsDAO();
        List res = newsDAO.newsAllList(1);
        System.out.println("显示所有新闻：");
        for (Object o : res) {
            System.out.println(((News) o).toJson());
        }
    }

    @Test
    public void newsAllList2() {
        NewsDAO newsDAO = new NewsDAO();
        List res = newsDAO.newsAllList("zhanghao", 1);
        System.out.println("通过标题查找新闻：");
        for (Object o : res) {
            System.out.println(((News) o).toJson());
        }
    }

    @Test
    public void newsDelete(){
        NewsDAO newsDAO = new NewsDAO();
        System.out.print("通过id删除新闻：");
        System.out.println(newsDAO.newsDelete(1));
    }

    @Test
    public void newUpdate(){
        NewsDAO newsDAO = new NewsDAO();
        System.out.print("更新新闻：");
        System.out.println(newsDAO.newsUpdate(new News(3,"zhang","zhan","zhang","2025-02-02")));
    }

    @Test
    public void newsDisplay(){
        NewsDAO newsDAO = new NewsDAO();
        System.out.println("显示新闻：");
        System.out.println(newsDAO.newsDisplay(4));
    }

    @Test
    public void newsExists(){
        NewsDAO newsDAO = new NewsDAO();
        System.out.print("判断新闻是否存在：");
        System.out.println(newsDAO.newsExists(1));
    }

    @Test
    public void newsAllCount(){
        NewsDAO newsDAO = new NewsDAO();
        System.out.println("获取新闻总条目数：");
        System.out.println(newsDAO.newsAllCount());
    }
}
