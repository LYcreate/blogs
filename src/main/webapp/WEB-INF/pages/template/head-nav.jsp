<%--
  Created by IntelliJ IDEA.
  User: LYcreate
  Date: 2019/2/6
  Time: 0:05
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
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo" style="color: #ffffff"><i class="layui-icon layui-icon-home" style="color: #ffffff;"></i><a href="#" style="color: #F8F8F8" onclick="getAllMessage()">LYcreate</a></div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left" id="navheader">
        </ul>
    </div>
</div>
<script src="<%=path%>/layui/layui.js"></script>
<script>
    $.ajax({
            type:"GET",
            url:"<%=basePath%>catalog",
            data:{
            },
            dataType:'json',
            success:function (json) {
                var content="";
                for(var key in json){
                    if(key!="result"){
                        content+="<li class=\"layui-nav-item\" ><a href=\"#\" id="+key+" onclick='getPageByMain(this)'>"+json[key]["name"]+"</a>";
                        if(!$.isEmptyObject(json[key]["subCatalog"])){
                            var subCatalog=json[key]["subCatalog"];
                            content+="<dl class=\"layui-nav-child\">";
                            for (var key2 in subCatalog){
                                content+="<dd><a href=\"#\" class="+key+" id="+key2+" onclick='getPageBySub(this)'>"+subCatalog[key2]+"</a><dd>";
                            }
                            content+="</dl>"
                        }else{
                        }
                        content+="</li>";
                    }
                }
                document.getElementById("navheader").innerHTML=content;
            }
    });
    layui.use('element', function(){
        var element = layui.element;
    });
</script>





