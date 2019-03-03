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
    <script src="<%=path%>/layui/layui.js"></script>
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
<div class="layui-container" style="width: 900px">
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
    <div class="layui-col-md10">
        <div class="layui-card">
            <div class="layui-card-header">评论</div>
            <div class="layui-card-body" id="comments">
            </div>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">您的评论</label>
        <div class="layui-input-block">
            <textarea id="commentContent" placeholder="请输入评论" class="layui-textarea"></textarea>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                    <input id="userName" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline" >
                <label class="layui-form-label">邮箱地址</label>
                <div class="layui-input-inline">
                    <input id="emailAddress" autocomplete="off" class="layui-input">
                </div>
            </div>
            <button class="layui-btn layui-btn-sm" onclick="submitComment()">提交评论</button>
        </div>
    </div>
</div>
</div>
</div>
<div style="padding: 20px auto"></div>
<script>
    $.ajax({
        type:"GET",
        url:"<%=basePath%>getComments",
        data:{"messageId":${blog.messageId}},
        dataType:"json",
        success:function (array) {
            console.log(array);
            var html="";
            for (var i=0;i<array.length;i++){
            html+="<div class=\"layui-card\" style=style=\"border-color:lightseagreen \">\n" +
                "                        <div class=\"layui-card-header\"><b>"+array[i]["userName"]+"</b></div>\n" +
                "                        <div class=\"layui-card-body\">\n" +array[i]["content"]+"</div>\n" +
                "                    </div>"
            }
            $("#comments").html(html);
        }
    })
    function submitComment() {
        $.ajax({
            type:"GET",
            url:"<%=basePath%>submitComment",
            dataType:"json",
            data:{
                "userName":$("#userName").val(),
                "emailAddress":$("#emailAddress").val(),
                "content":$("#commentContent").val(),
                "messageId":${blog.messageId}
            },
            success:function (netResult) {
                if(netResult["status"]==1){
                    layui.use('layer',function () {
                        var layer=layui.layer;
                        layer.msg("评论提交成功！");
                    })
                }else {
                    layui.use('layer',function () {
                        var layer=layui.layer;
                        layer.alert(netResult["result"]);
                    })
                }
            }
        })
    }
</script>
<%@ include file="template/foot.jsp"%>
