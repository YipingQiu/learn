<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/1
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
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
    <%--<link href="assets/bootstrap-table-1.11.0/bootstrap-table.min.css" rel="stylesheet">--%>

    <%--<link rel="stylesheet" href="assets/css/chapter/index.css">--%>
</head>
<body>
    <div id="chapter-tree">
        <ul>
            <li>
                <span>白日依山尽</span>
                <ul>
                    <li>
                        <span>天涯若比邻</span>
                    </li>
                    <li>
                        <span>海内存知己</span>
                    </li>
                </ul>
            </li>
            <li>
                <span>黄河入海流</span>
                <ul>
                    <li>
                        <span>床前明月光</span>
                    </li>
                    <li>
                        <span>疑是地上霜</span>
                        <ul>
                            <li>
                                <span>孟浩然，我是李白</span>
                                <ul>
                                    <li>
                                        <span>我是文天祥</span>
                                        <ul>
                                            <li>
                                                <span>我是李清照</span>
                                                <ul>
                                                    <li>
                                                        <span>我是邱少云</span>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
    <%--<div class="zTreeDemoBackground left">--%>
        <%--<ul id="chapter-tree" class="ztree"></ul>--%>
    <%--</div>--%>
<script src="assets/jquery-3.1.1/jquery-3.1.1.min.js"></script>
    <%--<script src="assets/zTree/js/jquery.ztree.all.js"></script>--%>
<script src="assets/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<%--<script src="assets/bootstrap-table-1.11.0/bootstrap-table.min.js"></script>--%>
<%--<script src="assets/bootstrap-table-1.11.0/local/bootstrap-table-zh-cn.js"></script>--%>
<script src="assets/js/chapter/index.js"></script>
    <%--<!-- zTree -->--%>
    <%--<link href="assets/zTree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">--%>
</body>
</html>