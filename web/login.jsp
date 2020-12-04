<%--
  Created by IntelliJ IDEA.
  User: zhanghao
  Date: 2020/11/30
  Time: 上午8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <script src="js/jquery.min.3.5.1.js"></script>
    <link rel="stylesheet" href="css/modal.css">
    <script src="js/modal.js"></script>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        .main {
            width: 100vw;
            height: 100vh;
            border-collapse: collapse;
        }

        .header {
            height: 20%;
            font-weight: bold;
            font-size: 40px;
            text-align: center;
            border-bottom: 1px solid #eeeeee;
        }

        .form {
            width: 60%;
            margin-left: 20%;
            padding: 20px;
        }

        .label {
            height: 40px;
            line-height: 40px;
            font-size: 20px;
            color: #555555;
        }

        .input {
            height: 40px;
            width: 100%;
            border: 1px solid #dddddd;
        }

        .button {
            width: 100px;
            height: 40px;
            border: none;
        }
    </style>
</head>
<body>
<table class="main">
    <tr class="header">
        <td>明日科技后台管理新系统登录</td>
    </tr>
    <tr>
        <td>
            <div class="form">
                <form onsubmit="sub();return false" action="admin/admin.html" method="post">
                    <p class="label">用户名</p>
                    <input class="input" id="username" type="text"/>
                    <br/><br/>
                    <p class="label">密码</p>
                    <input class="input" id="password" type="password"/>
                    <br/><br/>
                    <input type="checkbox" id="remind" value="remind">记录一周<br/>
                    <input class="button" id="login" type="submit" value="登录" style="background-color: #0f9ae0"/>
                    <input class="button" id="noPassword" type="button" value="忘记密码^_^" style="float: right"/>
                </form>
            </div>
        </td>
    </tr>
</table>
</body>
<script>
    function check(){
        if($("#username").val().trim()===""){
            createAlert("no","请输入用户名").show();
            return false;
        }
        if($("#password").val().trim()===""){
            createAlert("no","请输入密码").show();
            return false;
        }
        return true;
    }
    function sub(){
        if(!check()) return false;
        url = "login?username=" + $("#username").val() + "&password=" + $("#password").val() + "&remind=no";
        $.getJSON(url, function (req) {
            var tit;
            if (req["code"] === "1") {
                tit = createAlert("ok", "登录成功！");
                window.open("admin/admin.html");
            } else if (req["code"] === "0") {
                tit = createAlert("no", "登录失败！");
            }else{
                tit = createAlert("no","返回值异常！").show();
            }
            tit.show();
        });
    }
</script>
</html>
