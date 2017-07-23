<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>

    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script src="/js/jquery-3.2.1.min.js"></script>
    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
    <c:url value="/css/main.css" var="jstlCss"/>
    <link href="${jstlCss}" rel="stylesheet"/>

</head>
<body>

<%--<nav class="navbar navbar-inverse">--%>
<%--<div class="container">--%>
<%--<div class="navbar-header">--%>
<%--<a class="navbar-brand" href="#">Spring Boot</a>--%>
<%--</div>--%>
<%--<div id="navbar" class="collapse navbar-collapse">--%>
<%--<ul class="nav navbar-nav">--%>
<%--<li class="active"><a href="#">Home</a></li>--%>
<%--<li><a href="#about">About</a></li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</div>--%>
<%--</nav>--%>

<div class="container">



    <%--<button id="refresh" onclick="refresh()">refresh</button>--%>

    <div id="root" onclick="refresh()">root</div>
    <div id="tree"></div>

</div>
<!-- /.container -->

<script type="text/javascript">
    //      $(document).ready(function () {
    //          $.ajax({
    //              url: 'getChildren',
    //              success: function (response) {
    //
    //              }
    //          })
    //
    //      }

    $(document).ready(addRoot());


    function addRoot() {
        var data0 = {id: 0, name : "root", parentId : 0};

        var json = JSON.stringify(data0);
        $.ajax({
            type: "POST",
            url: '/add_node',
            data: json,
            contentType: "application/json; charset=utf-8",
            dataType: "json",

        })
    }

    function refresh() {
        $.ajax({
            url: '/get_nodes',
            success: function (response) {
                var list = response;
                console.log(response);
                $("#tree").html("");
                for (var k in list) {
                    $("#tree").append("<div><span>" +
                        ": " + list[k] +
                        "</span></div>");
                }

            }
        });

    }
</script>

</body>

</html>
