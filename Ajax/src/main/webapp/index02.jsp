<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax02</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
    <style>
        div{
            width: 400px;
            height: 300px;
            margin: 20px auto;
            background: #39e888;
            opacity: 0.6;
            text-align: center;
        }
        table{
            margin-top: 25px;
            margin-left: 10%;
            width: 270px;
        }
        table,tr,td,th{
            border: 1px solid red;
            padding: 2px;
        }
    </style>
</head>
<body>
<script>
<%--  一进来就执行此函数--%>
    $(function (){
        $("#btn").click(function (){
            $.post({
                url: "${pageContext.request.contextPath}/ajax/a2",
                success: function (data){
                  console.log(data);
                  let html="";
                  for (let i=0;i<data.length;i++){
                      html+="<tr>"+
                               "<td>"+data[i].name+"</td>"+
                               "<td>"+data[i].age+"</td>"+
                               "<td>"+data[i].sex+"</td>"+
                            "</tr>"
                  }
                  $("#content").html(html);
                }
            })
        })
    })
</script>

<div>
    <input type="button" id="btn" value="加载数据">
    <table>
        <tr>
            <td>姓名</td>
            <td>年龄</td>
            <td>性别</td>
        </tr>
        <tbody id="content">

        </tbody>
    </table>
</div>
</body>
</html>
