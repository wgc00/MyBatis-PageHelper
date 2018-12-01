<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>通讯录</title>
</head>
<body>
<h1>联系人</h1>
<form name="form1">
    <input type="text"  name="name">
    <input type="text"  name="address">
    <input type="submit" id="addSub" value="添加">
</form>
<script>
    window.onload = function () {
        var name = document.getElementsByName("name");
        var address = document.getElementsByName("address");
        var form1 = document.getElementsByName("form1");
        var addSub = document.getElementById("addSub");

        addSub.onclick = function (e) {
            alert("");
            e.returnValue = false;
            if (name[0] != null && address[0] != null) {
                form1[0].action = "/insert";
                form1[0].method = "post";
                e.returnValue = true;
            } else {

                alert("输出的姓名或城市不能为空");
            }
        }
    }
</script>
<ul>
    <c:forEach items="${directoriesList}" var="directories">
        <li>${directories.id}, ${directories.name}, ${directories.address}, <span><a href="/del/${directories.id}">删除</a></span></li>
    </c:forEach>
</ul>
<div>
    <c:forEach begin="1" end="${pageInfo.pages}" var="page">
        <a href="/query?page= ${page}">第${page}页</a>
    </c:forEach>
</div>
</body>
</html>