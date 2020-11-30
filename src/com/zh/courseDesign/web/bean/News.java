package com.zh.courseDesign.web.bean;

/**
 * 这个一个bean对象，表示一条新闻记录，实现了实现了news表的ORM。
 * @author MaCode
 * @date 2020-11-30
 * @github HappyOnion801
 */
public class News {
    private Integer id;
    private String title;
    private String content;
    private String publisher;
    private String updated_at;

    /**
     * 创建一条新的新闻对象
     */
    public News() {
    }

    /**
     * 创建一个新闻对象，包括新闻的id，标题，内容，作者，更新事件等信息。
     * @param id
     * @param title
     * @param content
     * @param publisher
     * @param updated_at
     */
    public News(Integer id, String title, String content, String publisher, String updated_at) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.publisher = publisher;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public News(String title, String content, String publisher, String updated_at) {
        this.title = title;
        this.content = content;
        this.publisher = publisher;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publisher='" + publisher + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
