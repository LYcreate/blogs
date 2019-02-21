<%--
  Created by IntelliJ IDEA.
  User: LYcreate
  Date: 2019/2/20
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"
            +request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>个人博客后台管理</title>
    <link rel="stylesheet" href="<%=path%>/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" style="color: #ffffff"><i class="layui-icon layui-icon-home" style="color: #ffffff;"></i>LYcreate</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">写博客</a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">文章管理</a>
                </li>
                <li class="layui-nav-item"><a href="">评论管理</a></li>
                <li class="layui-nav-item"><a href="">分类管理</a></li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">内容主体区域</div>
    </div>

    <div class="layui-footer" style="position: fixed;bottom: 0px;margin:0 auto">
        <div></div>
        <div style="font-family: '微软雅黑 Light';text-align: center;margin:0 auto">Copyright © 2019 Designed By Yi Lu</div>
    </div>
</div>
<script src="<%=path%>/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
