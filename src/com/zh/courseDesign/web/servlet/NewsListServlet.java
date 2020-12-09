package com.zh.courseDesign.web.servlet;

import com.zh.courseDesign.web.bean.News;
import com.zh.courseDesign.web.dao.bean.NewsDAO;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newslist")
public class NewsListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public NewsListServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int iCount = 0;
        int iPages = 0;
        int iCurrPage = 1;
        List<News> newss = null;
        NewsDAO newsDAO = new NewsDAO();
        int iSize = newsDAO.getLimit();
        try {
            if (request.getParameter("page") != null)
                iCurrPage = Integer.parseInt(request.getParameter("page"));
            newss = newsDAO.newsAllList(iCurrPage);
            request.setAttribute("newss", newss);
            iCount = newsDAO.newsAllCount();
            if (iCount % iSize == 0) {
                iPages = iCount / iSize;
            } else {
                iPages = (iCount / iSize) + 1;
            }
            request.setAttribute("count", iCount);
            request.setAttribute("pages", iPages);
            request.setAttribute("currpage", iCurrPage);
            request.setAttribute("isize", iSize);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher("newslist.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
