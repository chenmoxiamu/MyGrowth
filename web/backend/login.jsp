<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录界面</title>
<%--    <style>--%>
<%--        div{--%>
<%--            margin-left: 300px;--%>
<%--            padding-top: 100px;--%>
<%--            border: 10px solid green;--%>
<%--            width: 500px;--%>
<%--            height: 300px;--%>
<%--            text-align: center;--%>
<%--        }--%>
<%--    </style>--%>
    <style type="text/css">
        body{
            font-size:12px;
            font-family:"宋体";
        }
        body,form,input,p{
            padding:0px;
            margin:0px;
            border:0px;
        }
        form{
            width:320px;
            height:200px;
            padding-top:20px;
            margin:50px auto;
            background-color:#f5f8fd;
            border-radius:20px;
            border:3px solid #4faccb;
        }
        p{
            margin-top:15px;
            text-align:center;
        }
        p label{
            width:60px;
            display:inline-block;
            text-align:right;
        }
        .num,.pass{
            width:152px;
            height:25px;
            border:1px solid #38a1bf;
            padding:2px 2px 2px 22px;

        }
        .num{
            background:url(images/username.png) no-repeat 5px center #fff;
            color:#999;
        }
        .pass{
            background:url(images/password.png) no-repeat 5px center #fff;
        }
        .btn01,.btn02{
            width:60px;
            height:25px;
            border-radius:3px;
            border:1px solid #6b5d50;
            margin-left:30px;
        }
        .btn01{
            background:#3bb7ea;
        }
        .btn02{
            background:#fb8c16;
        }
        h2{
            text-align:center;
        }
    </style>
</head>
<body>

<%--    <div>--%>

<%--        <form action="/admin" method="post">--%>
<%--            <input type="hidden" name="method" value="login"/>--%>
<%--            <label for="adminName">用户名: </label><input type="text" name="adminName" id="adminName" /><br/>--%>
<%--            <label for="password">密码: </label><input type="password" name="password" id="password" /><br/>--%>
<%--            <input type="submit" value="登录" /><br/>--%>
<%--            <span style="color: red">${loginFailMsg}</span><br>--%>
<%--        </form>--%>
<%--    </div>--%>

    <div>

        <form action="/admin?method=login" method="post">
                <h2>用户登录</h2>
            <p>
                <label for="adminName">用户名：</label>
<%--                pattern="^[a-zA-Z][a-zA-Z0-9]{4,15}$"--%>
                <input type="text" name="adminName"  class="num" id="adminName" />
            </p>
            <p>
                <label for="password">密码：</label>
                <input type="password" name="password"  class="pass" id="password" />
            </p>
            <p>
                <input type="submit" class="btn01" value="登录" />
                <input type="button" class="btn02" value="注册"/></a>
            </p>
            <span style="color: red">${loginFailMsg}</span><br>
        </form>
    </div>
</body>
</html>
