<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/18 0018
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>
<script type="text/javascript" src="${pageContext.request.contentType}js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#btn").click(function () {
            $.getJSON(
                "${pageContext.request.contextPath}/empfind.do",
                {"time": new Date().getTime()},
                function (emps) {
                    //[{},{},{}]
                    var html = "<table border='2'>" +
                        "<tr>" +
                        "<th>序号</th>" +
                        "<th>员工编号</th>" +
                        "<th>员工名字</th>" +
                        "<th colspan=\"3\">操作</th>" +
                        "</tr>";
                    $.each(emps, function (i, emp) {
                        html += "<tr>" +
                            "<td>" + (i + 1) + "</td>" +
                            "<td>" + emp.empno + "</td>" +
                            "<td>" + emp.ename + "</td>" +
                            "<td><input type='button' value='修改' ></td>" +
                            "<td><input type='button' value='删除'></td>" +
                            "<td><input type='button' value='详情'></td>" +
                            "</tr>";
                    });
                    html += "</table>";

                    $("#empfindspan").html(html);

                }
            )
        })
    })


</script>

<input type="button" id="btn" value="查询全部员工信息">
<span id="empfindspan"></span>
</body>
</html>
