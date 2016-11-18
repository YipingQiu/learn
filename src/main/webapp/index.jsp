<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/1
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    request.setAttribute("basePath", basePath);
%>

<html lang="zh-cn">
<head>
    <base href="${basePath}/"/>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Jack邱个人学习网</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/css/index.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <%--<script src="../../assets/js/ie-emulation-modes-warning.js"></script>--%>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="masthead clearfix">
                <div class="inner">
                    <h3 class="masthead-brand">Self Learning</h3>
                    <%--<ul class="nav masthead-nav">--%>
                        <%--<li class="active"><a href="#">Home</a></li>--%>
                        <%--<li><a href="#">Features</a></li>--%>
                        <%--<li><a href="#">Contact</a></li>--%>
                    <%--</ul>--%>
                </div>
            </div>

            <div class="inner cover">
                <h1 class="cover-heading">A handsome paragraph.</h1>
                <p class="lead">Keep on going never give up. If I had not been born Napoleon, I would have liked to have been born Alexander.</p>
                <p class="lead">
                    <a href="example/index" class="btn btn-lg btn-default">Start to Learn</a>
                </p>
            </div>

            <div class="mastfoot">
                <div class="inner">
                    <p>Cover template for <a href="http://getbootstrap.com">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p>
                </div>
            </div>

        </div>

    </div>

</div>

<iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=330 height=450 src="http://music.163.com/outchain/player?type=1&id=3109634&auto=1&height=430"></iframe>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="assets/jquery-3.1.1/jquery-3.1.1.min.js"></script>
<script src="assets/bootstrap-3.3.0/js/bootstrap.min.js"></script>
<%--<script src="../../assets/js/docs.min.js"></script>--%>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<%--<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>--%>
</body>
</html>

