<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zh.courseDesign.web.bean.News" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>明日科技有限公司</title>
    <link href="assets/css/main.css" rel="stylesheet" type="text/css">
    <link href="assets/css/container.css" rel="stylesheet" type="text/css">
    <link href="assets/css/reset.css" rel="stylesheet" type="text/css">
    <link href="assets/css/screen.css" rel="stylesheet" type="text/css">
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/tab.js"></script>
</head>

<body>

<%@ include file="header.jsp" %>
<!--banner-->
<!--banner-->
<div class="second_banner">
    <img src="assets/img/3.gif" alt="">
</div>
<!--//banner-->
<!--新闻-->
<div class="container">
    <div class="left">
        <div class="menu_plan">
            <div class="menu_title">公司动态<br><span>news of company</span></div>
            <ul id="tab">
                <li><a href="#">公司新闻</a></li>
            </ul>
        </div>
    </div>
    <div class="right">
        <div class="location">
            <span>当前位置：<a href="javascript:void(0)" id="a"><a href="#">公司新闻</a></a></span>
            <div class="brief" id="b"><a href="#">公司新闻</a></div>
        </div>
        <div style=" font-size:14px; margin-top:53px; line-height:36px;">
            <div id="tab_con">
                <div id="tab_con_2" class="dis-n" style="display: none;">
                    <table style="margin-top:70px">
                        <tbody>
                        <tr class="tt_bg">
                            <td>新闻标题</td>
                            <td>发布人</td>
                            <td>发布时间</td>
                            <td>详情</td>
                        </tr>
                        <%
                            List<News> list = (List<News>) request.getAttribute("newss");
                            if (list.size() != 0)
                                for (News u : list) {
                        %>
                        <tr>
                            <td><%=u.getTitle() %>
                            </td>
                            <td><%=u.getPublisher() %>
                            </td>
                            <td><%=u.getUpdated_at() %>
                            </td>
                            <td><a style="color:#3F862E" target="_blank" href="newsdetail.jsp?newsId=<%=u.getId()%>">详情</a>
                            </td>
                        </tr>
                        <%
                            }
                        else {
                        %>
                        <tr height="25" bgcolor="#d6dff7">
                            <td colspan="4" align="center">没有记录</td>
                        </tr>
                        <%} %>
                        </tbody>
                    </table>
                    <%if (list.size() != 0) {%>
                    <table width="90%" border="0" cellpadding="2" cellpacing="0">
                        <tr>
                            <td>
				<span>
				<%
                    int currpage = Integer.parseInt(request.getAttribute("currpage").toString());
                    int pages = Integer.parseInt(request.getAttribute("pages").toString());
                    int count = Integer.parseInt(request.getAttribute("count").toString());
                    int size = Integer.parseInt(request.getAttribute("isize").toString());
                %>
				当前第<%=currpage %>页/共<%=pages %>页， &nbsp;&nbsp;&nbsp;&nbsp;共<%=count %>条记录&nbsp;&nbsp;&nbsp;&nbsp;
				<%=size %>条/页&nbsp;&nbsp;&nbsp;&nbsp;
				<%
                    for (int i = 1; i <= pages; i++) {
                        if (i == currpage) {%>
					<%=i %>
					<%} else {%>
					<a style="color:#3F862E" href="newslist?page=<%=i%>"><%=i %></a>
				<%
                        }
                    }
                %>
				
				
				</span>
                            </td>
                        </tr>
                    </table>
                    <%} %>
                </div>
            </div>
        </div>
    </div>
</div>
<!--//新闻-->
<%@ include file="footer.jsp" %>
</body>
<script>
    tabs("#tab", "active", "#tab_con");
</script>
</html>

