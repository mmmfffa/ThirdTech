<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>
    <style>
        .div1{
            margin: 100px 100px;
            background: url("statics/image/1.jpg") 0 0 no-repeat;
            opacity: 0.7;
        }
        .div2{
            width: 400px;
            height: 150px;
            margin: 20px auto;
            background: #39e888;
            opacity: 0.6;
        }
    </style>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
</head>
<body>

<script>
    function a1(){
        //将文本框值发给服务器并接收服务器返回的数据
        //success:function (data)回调函数data封装了服务器返回数据和状态
        $.post({
            url: "${pageContext.request.contextPath}/ajax/a3",
            data: {"name":$("#txtName").val()},
            success:function (data){
                console.log("name:"+data.toString());
                if (data.toString()==="ok") $("#nameInfo").css("color","green");
                else $("#nameInfo").css("color","red");
                $("#nameInfo").html(data)
            }
        });
    }
    function a2(){
        $.post({
            url: "${pageContext.request.contextPath}/ajax/a3",
            data: {"pwd":$("#txtWord").val()},
            success:function (data){
                console.log("pwd:"+data.toString());
                if (data.toString()=="ok") $("#pwdInfo").css("color","yellow");
                else $("#pwdInfo").css("color","red");
                $("#pwdInfo").html(data)
            }
        });
    }
</script>

<div class="div1">
    <div class="div2">
        <p>
            <span>用户名：</span>
            <input type="text" name="username" id="txtName" onblur="a1()">
            <span id="nameInfo"></span>

        </p>
        <p>
            <span>密码：</span>
            <input type="text" name="password" id="txtWord" onblur="a2()">
            <span id="pwdInfo"></span>
        </p>
        <p>
            <input type="button" value="提交">
        </p>
    </div>
</div>
</body>
</html>
