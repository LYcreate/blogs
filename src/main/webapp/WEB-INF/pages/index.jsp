<%--
  Created by IntelliJ IDEA.
  User: LYcreate
  Date: 2019/2/5
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="template/head-nav.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="blank" style="width: 900px;height: 20px"></div>
<div id="content" style='width: 900px;margin:0 auto'>
<div id="messages" style="width: 900px;margin:0 auto">
</div>
<div id="page"></div>
</div>
<script>
    var pageNow=1;
    var totalMessage=0;
    var mainCatalogId="";
    var subCatalogId="";
    function showPage(json){
        var briefs=json["briefList"];
        console.log(briefs);
        totalMessage=json["totalMessage"];
        var html="";
        for (var key in briefs){
            html+="<div class=\"layui-card\" >\n" +
                "  <div class=\"layui-card-header\" style=\"font-family: '微软雅黑 Light';font-size:20px\"><a id='"+briefs[key]["messageId"]+"' href='"+"<%=basePath%>message/"+
                briefs[key]["messageId"]+"'>"+briefs[key]["title"]+
                "</div>\n" + "  <div class=\"layui-card-body\">"+briefs[key]["summary"]+
                "</div>\n" +
                "</div>"
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
    function getPageByMain(obj){
        pageNow=1;
        mainCatalogId=obj.id;
        subCatalogId="";
        $.ajax({
            type:"GET",
            url:"<%=basePath%>messageListByMain",
            data:{"pageNow":pageNow,"mainCatalogId":mainCatalogId},
            dataType:"json",
            success:function (json) {
                showPage(json);
            }
        });
    }
    function getPageBySub(obj){
        pageNow=1;
        mainCatalogId=obj.class;
        subCatalogId=obj.id;
        $.ajax({
            type:"GET",
            url:"<%=basePath%>messageListBySub",
            data:{"pageNow":pageNow,"subCatalogId":subCatalogId},
            success:function (json) {
                showPage(json);
            }
        });
    }
    getAllMessage();
    layui.use('element', function(){
        var element = layui.element;
    });
    layui.use(['laypage', 'layer','jquery'], function() {
        var laypage = layui.laypage
            , layer = layui.layer;
        laypage.render({
            elem: 'page'
            , count: totalMessage//数据总数
            , jump: function (obj) {
                pageNow=obj.curr;
                if($.isEmptyObject(mainCatalogId)){
                    $.ajax({
                        type:"GET",
                        url:"<%=basePath%>getAllMessage",
                        data:{"pageNow":pageNow},
                        dataType:"json",
                        success:function (json) {
                            showPage(json);
                        }
                    });
                }else if($.isEmptyObject(subCatalogId)){
                    $.ajax({
                        type:"GET",
                        url:"<%=basePath%>messageListByMain",
                        data:{"mainCatalogId":mainCatalogId,"pageNow":pageNow},
                        dataType:"json",
                        success:function (json) {
                            showPage(json);
                        }
                    });
                }else {
                    $.ajax({
                        type:"GET",
                        url:"<%=basePath%>messageListBySub",
                        data:{"subCatalogId":subCatalogId,"pageNow":pageNow},
                        dataType:"json",
                        success:function (json) {
                            showPage(json);
                        }
                    });
                }
            }
        });
    });
</script>
<%@include file="template/foot.jsp"%>