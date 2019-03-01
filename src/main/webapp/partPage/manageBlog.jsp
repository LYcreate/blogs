<%--
  Created by IntelliJ IDEA.
  User: LYcreate
  Date: 2019/3/1
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"
            +request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="<%=path%>/js/wangEditor.min.js"></script>
<div id="messages" style="width: 900px;margin:0 auto">
</div>
<div id="page"></div>
</div>
<script>
    var pageNow=1;
    var totalMessage=0;
    function showPage(json){
        var briefs=json["briefList"];
        console.log(briefs);
        totalMessage=json["totalMessage"];
        var html="";
        for (var key in briefs){
            html+= "<div class=\"layui-card\" >\n" +
            "  <div class=\"layui-card-header\" style=\"font-family: '微软雅黑 Light';font-size:20px\">"+briefs[key]["title"]+
            "</div>\n" + "  <div class=\"layui-card-body\">"+briefs[key]["summary"]+"<div><a class=\"layui-btn layui-btn-sm\" href='#' " +
                "onclick='modifyBlog(this)' name='"+briefs[key]["messageId"]+"'>修改</a>" +
                "<a class=\"layui-btn layui-btn-sm\" href='#' onclick='deleteBlog(this)' id='"+briefs[key]["messageId"]+"'>删除</a></div>\n" + "</div></div>"
        }
        document.getElementById("messages").innerHTML=html;
    }
    function getAllMessage(){
        pageNow=1;
        mainCatalogId="";
        subCatalogId="";
        $.ajax({
            type:"GET",
            url:"<%=basePath%>getAllMessage",
            data:{"pageNow":pageNow},
            dataType:"json",
            success:function (json) {
                showPage(json);
            }
        });
    }
    getAllMessage();
    function modifyBlog(obj) {
        var messageId=obj.name;
        console.log(messageId);
        $("#mainContent").load("<%=path%>/partPage/editBlog.jsp");
        $.ajax({
            type:"GET",
            url:"<%=basePath%>getMessage",
            data:{"messageId":messageId},
            dataType:"json",
            success:function (json) {
                console.log(json["title"])
                $('#blogTitle').val(json["title"]);
                $('#quiz1').val(json["mainCatalogId"]);
                $('#quiz2').val(json['subCatalogId']);
                editor1.txt.html(json["content"]);
                $('#desc').val(json["summary"]);
            }
            }
        )
    }
    function deleteBlog(obj){
        $.ajax({
            type:"GET",
            url:"<%=basePath%>manage/deleteMessage",
            data:{
                "messageId":obj.id
            },
            dataType:"json",
            success:function (netResult) {
                if (netResult["status"]==1){
                    layui.use('layer',function () {
                        var layer=layui.layer;
                        layer.msg("删除成功！");
                    })
                    getAllMessage();
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