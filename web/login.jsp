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
    <script src="js/modal.js"></script>
    <link rel="stylesheet" href="css/modal.css">
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
                <form action="login" method="post">
                    <p class="label">用户名</p>
                    <input class="input" id="username" type="text" name="username"/>
                    <br/><br/>
                    <p class="label">密码</p>
                    <input class="input" id="password" type="password" name="password"/>
                    <br/><br/>
                    <input type="checkbox" id="remind" name="remind" value="remind">记录一周<br/>
                    <input class="button" id="login" type="button" value="登录" style="background-color: #0f9ae0"/>
                    <input class="button" id="noPassword" type="button" value="忘记密码^_^" style="float: right"/>
                </form>
            </div>
        </td>
    </tr>
</table>
<div id="modal"></div>
</body>
<script>
    $("#login").click(function () {
        url = "login?username=" + $("#username").val() + "&password=" + $("#password").val() + "&remind=no";
        $.getJSON(url,function(req){
if(req["code"]===1){
                tit = createAlert("ok","登录成功！");
                tit.show();
            }else{
                tit = createAlert("no","登录失败！");
                tit.show();
            }
        });
    });
</script>
</html>
