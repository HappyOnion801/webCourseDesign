<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
		<script src="assets/js/jquery.min.js">
</script>
		<script src="assets/js/tab.js">
</script>
	</head>

	<body>
		<%@ include file="header.jsp" %>

		<!--banner-->
		<div class="second_banner">
			<img src="assets/img/4.gif" alt="">
		</div>
		<!--//banner-->
		<!--新闻-->
		<div class="container">
	<div class="left">
        <div class="menu_plan">
            <div class="menu_title">公司动态<br><span>news of company</span></div>
			 <ul id="tab">
                <li ><a href="#">公司新闻</a></li>
            </ul>
        </div>
     </div>
     <div class="right">
            <div class="location">
                <span>当前位置：<a href="javascript:void(0)" id="a"><a href="#">公司新闻</a></a></span>
                <div class="brief" id="b"><a href="#">公司新闻</a></div>
            </div>
				<div style="font-size: 14px; margin-top: 53px; line-height: 36px;">
					<div id="tab_con">
						<div id="tab_con_2" class="dis-n" style="display: none;">
							<div class="content_main">
								 
								<br><h2 style="font-size:28px;margin-left:30%">新闻标题</h2>
								<p>新闻内容新闻内容新闻内容新闻内容新闻内容 新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</p>
							</div>
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


	
</script>

</html>