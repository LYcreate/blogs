<%--
  Created by IntelliJ IDEA.
  User: LYcreate
  Date: 2019/3/3
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"
            +request.getServerPort()+path+"/";
%>
<div class="layui-form-item">
    <div class="layui-inline">
        <label class="layui-form-label">主目录</label>
        <div class="layui-input-inline">
            <select id="mainCatalog" onchange="uploadSubCatalog()">

            </select>
        </div>
        <label class="layui-form-label">子目录</label>
        <div class="layui-input-inline">
            <select id="subCatalog">
            </select>
        </div>
    </div>
</div>
<script src="<%=path%>/js/template-web.js"></script>
<script type="text/html" id="mainCataglogTemplate">
    <option value="">请选择</option>
    {{each array as value index}}
    <option value="{{value.mainCatalogId}}">{{value.name}}</option> <a name="{{value.name}}" class="{{value.mainCatalogId}}" onclick="editMainCatalog(this)">编辑</a>|<a name="{{value.name}}" class="{{value.mainCatalogId}}" onclick="deleteMain(this)">删除</a>
    {{/each}}
</script>
    <script type="text/html" id="subCataglogTemplate">
        <option value="">请选择</option>
        {{each array as value index}}
        <option value="{{value.subCatalogId}}">{{value.name}}</option>
        {{/each}}
    </script>
<script type="text/html" id="editMain">
    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label">名称</label>
            <div class="layui-input-block">
                <input id="mainName" type="text"  required  lay-verify="required" placeholder={{name}} autocomplete="off" class="layui-input">
            </div>
            <button name="{{mainCatalogId}}" class="layui-btn layui-btn-sm" onclick="verifyEditMain(this)">提交</button>
        </div>
    </form>
</script>
<script src="<%=path%>/layui/layui.js"></script>
<script>
    $.ajax({
        type:"GET",
        url:"<%=basePath%>manage/getMainCatalog",
        data:{},
        dataType:"json",
        success:function (result) {
            console.log(result);
            var data={
                array:result
            }
            var html=template("mainCataglogTemplate",data);
            $("#mainCatalog").html(html);
        }
    })
    function uploadSubCatalog() {
        var mainOption=$("#mainCatalog option:selected").val();
        $.ajax({
            type:"GET",
            url:"<%=basePath%>manage/getSubCatalog",
            data:{
                "mainCatalogId":mainOption
            },
            dataType:"json",
            success:function (result) {
                var data={
                    array:result
                }
                var html=template("subCataglogTemplate",data);
                $("#subCatalog").html(html);
            }
        })
    }
    function editMainCatalog(obj) {
        var data={
            mainCatalogId:obj.className,
            name:obj.name
        };
        var html=template("editMain",data);
        layui.use(['layer','jquery'],function () {
            var layer=layui.layer;
            layer.open({
                    type: 1,
                    area: ['600px', '360px'],
                    shadeClose: true, //点击遮罩关闭
                    content:html
            }
            )
        })
    }
    function verifyEditMain(obj) {
        $.ajax({
            type:"GET",
            url:"<%=basePath%>manage/updateMainCatalog",
            data:{
                "mainCatalogId":obj.name,
                "name":$("#mainName").val()
            },
            dataType:"json",
            success:function (result) {
                if (result==1){
                    layui.use("layer",function () {
                        var layer=layui.layer;
                        layer.msg("修改成功！");
                    })
                }else {
                    layui.use("layer",function () {
                        var layer=layui.layer;
                        layer.msg("修改失败！");
                    }
                    )
                }
            }
        }
        )
    }
    function deleteMain(obj) {
        $.ajax({
                type:"GET",
                url:"<%=basePath%>manage/deleteMainCatalog",
                data:{
                    "mainCatalogId":obj.name
                },
                dataType:"json",
                success:function (result) {
                    if (result==1){
                        layui.use("layer",function () {
                            var layer=layui.layer;
                            layer.msg("修改成功！");
                        })
                    }else {
                        layui.use("layer",function () {
                                var layer=layui.layer;
                                layer.msg("修改失败！");
                            }
                        )
                    }
                }
            }
        )
    }
</script>
