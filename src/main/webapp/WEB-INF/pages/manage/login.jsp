<%--
  Created by IntelliJ IDEA.
  User: LYcreate
  Date: 2019/2/20
  Time: 21:28
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
    <title>管理员登录</title>
    <script src="<%=path%>/js/jquery.min.js"></script>
    <link rel="stylesheet" href="<%=path%>/layui/css/layui.css">
</head>
<body>
<div style="position:center;margin:40px auto;width: 400px">
<fieldset class="layui-elem-field layui-field-title loginForm" style="position:center;margin:40px auto;bamargin-top:40px;border:1px solid #e2e2e2;padding:20px;max-width:480px;display:inline-block;background: #fff">
    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief" style="position: center;margin: 20px auto">
        <ul class="layui-tab-title">
            <li class="layui-this">用户登录</li>
        </ul>
    <form class="layui-form layui-form-pane" action="" style="position: center;margin: 20px auto">
        <div class="layui-form-item">
            <label class="layui-form-label">账号</label>
            <div class="layui-input-inline">
                <input type="text" name="title" placeholder="请输入账号" autocomplete="off" class="layui-input login_name">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input login_pwd">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn btn-login" lay-submit="" lay-filter="managerLogin">登录</button>
                <button type="reset" class="layui-btn layui-btn-primary btn-reset">重置</button>
            </div>
        </div>
    </form>
    </div>
</fieldset>
</div>
<script src="<%=path%>/layui/layui.js"></script>
<script>
    layui.use(['element','form','jquery','layer'], function(){
        var element = layui.element;
        var form=layui.form;
        var layer=layui.layer;
        var $ = layui.jquery;
        form.on("submit(managerLogin)",function (data) {
            var field=data.field;
            console.log(field);
            $.ajax({
                type:"POST",
                url:"<%=basePath%>manage/loginrequest",
                data:{
                    "userName":field.title,
                    "password":field.password
                },
                dataType:"json",
                success:function (result) {
                    console.log(result);
                    if (result["status"]==1){
                        layer.msg("登录成功！");
                        window.location.href="<%=basePath%>manage/";
                    }else{
                        layer.alert(result["result"]);
                    }
                }
            });
            return false;
        });
    });

</script>
</body>
</html>
