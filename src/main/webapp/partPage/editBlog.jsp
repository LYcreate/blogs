<%--
  Created by IntelliJ IDEA.
  User: LYcreate
  Date: 2019/2/26
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"
            +request.getServerPort()+path+"/";
%>
<div class="layui-form-item">
    <label class="layui-form-label">标题</label>
    <div class="layui-input-block">
        <input type="text" id="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
    </div>
</div>
<div class="layui-form-item">
    <label class="layui-form-label">文章分类</label>
    <div class="layui-input-inline">
        <select id="quiz1" onchange="updateSubCatalog()">
            <option value="">请选择</option>
        </select>
    </div>
    <div class="layui-input-inline">
        <select id="quiz2">
            <option value="">请选择</option>
        </select>
    </div>
</div>
<div class="layui-form-item layui-form-text">
    <label class="layui-form-label">概要</label>
    <div class="layui-input-block">
        <textarea id="desc" placeholder="请输入概要" class="layui-textarea"></textarea>
    </div>
</div>
<div id="div1" class="text"> <!--可使用 min-height 实现编辑区域自动增加高度-->
    <p>请输入内容</p>
</div>
<button class="layui-btn" onclick="submitBlog()">提交</button>
<script type="text/javascript" src="<%=path%>/js/wangEditor.min.js"></script>
<script type="text/javascript" src="<%=path%>/layui/lay/modules/layer.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor1 = new E('#div1')  // 两个参数也可以传入 elem 对象，class 选择器
    editor1.customConfig.uploadImgShowBase64 = true;
    editor1.create();
    $.ajax({
        type:"POST",
        url:"<%=basePath%>manage/getMainCatalog",
        data:{},
        dataType:"json",
        success:function (dataArray) {
            for (var i=0;i<dataArray.length;i++){
                var mainCatalog=dataArray[i];
                $("#quiz1").append("<option value="+mainCatalog["mainCatalogId"]+">"+mainCatalog["name"]+"</option>");
            }
            console.log(dataArray);
        }
    });
    function updateSubCatalog() {
        var mainOption=$("#quiz1 option:selected").val();
        console.log(mainOption);
        $.ajax({
            type:"POST",
            url:"<%=basePath%>manage/getSubCatalog",
            data:{"mainCatalogId":mainOption},
            dataType:"json",
            success:function (dataArray) {
                for (var i=0;i<dataArray.length;i++){
                    var subCatalog=dataArray[i];
                    $("#quiz2").append("<option value="+subCatalog["subCatalogId"]+">"+subCatalog["name"]+"</option>");
                }
                console.log(dataArray);
            }
        })
    }
    function submitBlog() {
        var title=$("#title").val();
        var summary=$("#desc").val();
        var mainOption=$("#quiz1 option:selected").val();
        var subOption=$("#quiz2 option:selected").val();
        var blogHtml=editor1.txt.html();
        var data={"title":title,"summary":summary,"mainCatalogId":mainOption,"subCatalogId":subOption,"content":blogHtml};
        $.ajax({
            type:"POST",
            url:"<%=basePath%>manage/uploadBlog",
            data:data,
            dataType:"json",
            success:function (result) {
                console.log(result);
                if (result["status"]==1){
                    layer.msg("上传成功！");
                }
                else{
                    layer.alert(result["result"]);
                }
            }
        })
    }
</script>