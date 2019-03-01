<%--
  Created by IntelliJ IDEA.
  User: LYcreate
  Date: 2019/3/1
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"
            +request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <title>LYcreate Blog</title>
    <script src="<%=path%>/js/jquery.min.js"></script>
    <link rel="stylesheet" href="<%=path%>/layui/css/layui.css">
</head>
<body class="layui-layout-body" style="overflow: auto">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" style="color: #ffffff"><i class="layui-icon layui-icon-home" style="color: #ffffff;"></i><a href="<%=basePath%>index" style="color: #F8F8F8">LYcreate</a></div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left" id="navheader">
        </ul>
    </div>
</div>
<div class="layui-container">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
        <legend>${blog.title}</legend>
    </fieldset>
    <div class="layui-word-aux">
        ${blog.createTime}
    </div>
    <div style="padding: 20px"></div>
    <div>
        ${blog.content}
    </div>
</div>
<div style="padding: 20px auto"></div>
<%@ include file="template/foot.jsp"%>
