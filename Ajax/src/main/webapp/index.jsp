<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>
    <style>
        .div1{
            margin: 100px 100px;
            background: url("statics/image/1.jpg") 0 0 no-repeat;
            opacity: 0.7;
            text-align: center;
        }
        .div2{
            width: 200px;
            height: 100px;
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
            $.ajax({
              url: "${pageContext.request.contextPath}/ajax/a1",
              data: {"name":$("#txtName").val()},
              success:function (data){
                  console.log(data);
              }
            });

        }
    </script>

    <div class="div1">
        <div class="div2">
            <p>
                <span>用户名：</span>
                <label>
                    <%-- 失去焦点产生时间--%>
                    <input type="text" name="username" id="txtName" onblur="a1()">
                </label>
            </p>
            <p>
                <input type="button" value="提交">
            </p>
        </div>
    </div>
</body>
</html>
