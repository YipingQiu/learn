<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/1
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    request.setAttribute("basePath", basePath);
%>
<head>
    <title>Jack邱学习网</title>
    <base href="${basePath}/"/>
    <!-- Bootstrap core CSS -->
    <link href="assets/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet">

    <link rel="stylesheet" href="assets/css/example/index.css">
</head>
<body>

<div class="pull-right">
    <input type="button" class="btn-lg" value="新增" id="example-learn-add"/>
</div>
<div class="content">
    <table id="example-table"></table>
</div>

<!-- 新增范例 模态框（Modal） -->
<div class="modal fade" id="add-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">新增范例</h4>
            </div>
            <div class="modal-body">
                <label id="chapter-lbl" for="chapter">章节</label>
                <input id="chapter-id" type="hidden">
                <input id="chapter" type="text">
                <label for="example">范例标题</label>
                <input id="example" type="text">
            </div>
            <div id="chapter-tree" style="display: none"></div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="modal-submit">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 章节 模态框（Modal） -->
<div class="modal fade" id="chapter-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">章节</h4>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="modal-chapter-submit">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 范例详情 模态框（Modal） -->
<div class="modal fade" id="detail-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">范例详情</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <label class="col-lg-2">id</label>
                    <label class="col-lg-4"></label>
                </div>
                <div class="row">
                    <label class="col-lg-2">ChapterId</label>
                    <label class="col-lg-4"></label>
                </div>
                <div class="row">
                    <label class="col-lg-2">ExampleId</label>
                    <label class="col-lg-4" id="example-id"></label>
                </div>
                <div class="row">
                    <label class="col-lg-2">title</label>
                    <label class="col-lg-4"></label>
                </div>
                <div class="row">
                    <label class="col-lg-2">content</label>
                    <textarea class="col-lg-9" id="content"></textarea>
                </div>
                <div class="row">
                    <label class="col-lg-2">translation</label>
                    <textarea class="col-lg-9" id="translation"></textarea>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="detail-submit">提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script src="assets/jquery-3.1.1/jquery-3.1.1.min.js"></script>
<script src="assets/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<script src="assets/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>
<script src="assets/bootstrap-table-1.11.0/local/bootstrap-table-zh-cn.js"></script>
<script src="assets/js/example/index.js"></script>
</body>
</html>