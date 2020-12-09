package com.zh.courseDesign.web.dao.bean;

import com.zh.courseDesign.web.bean.News;
import com.zh.courseDesign.web.dao.BaseDAO;
import com.zh.courseDesign.web.dao.inter.INews;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * @author MaCode
 * @date 2020-12-01
 * @github HappyOnion801
 */
public class NewsDAO extends BaseDAO<News> implements INews {

    private static Properties properties = null;

    static {
        properties = new Properties();
        try {
            properties.load(NewsDAO.class.getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getLimit(){
        return Integer.parseInt(properties.getProperty("NewsLimit"));
    }

    @Override
    public List<News> newsAllList(int page) {
        int limit = getLimit();
        return super.select("select * from news limit ?,?", (page - 1) * limit, limit);
    }

    @Override
    public List<News> newsAllList(String title, int page) {
        int limit = getLimit();
        return super.select("select * from news where title=? limit ?,?", title, (page - 1) * limit, limit);
    }

    @Override
    public int newsAdd(News news) {
        return super.insert("insert news(`title`,`content`,`publisher`,`updated_at`) values(?,?,?,?)", news.getTitle(), news.getContent(), news.getPublisher(), news.getUpdated_at());
    }

    @Override
    public boolean newsDelete(int id) {
        return super.delete("delete from news where id=?", id) == 1;
    }

    @Override
    public boolean newsUpdate(News news) {
        return super.update("update news set title=?,content=?,publisher=?,updated_at=? where id=?", news.getTitle(), news.getContent(), news.getPublisher(), news.getUpdated_at(), news.getId()) == 1;
    }

    @Override
    public News newsDisplay(int id) {
        List<News> res = super.select("select * from news where id=?", id);
        if (res != null && res.size() == 1) return res.get(0);
        return null;
    }

    @Override
    public boolean newsExists(int id) {
        return newsDisplay(id) != null;
    }

    @Override
    public int newsAllCount() {
        return super.getInt("select count(*) from news");
    }
}
