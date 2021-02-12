<%--
  Created by IntelliJ IDEA.
  User: bbq59
  Date: 12/28/2020
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/auth/css/login2.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/auth/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/auth/js/validation.js"></script>
    <script type="text/javascript">
        function checkSubmit(){
            var r1 = checkEmpty('#name','#errname');
             var r3 = checkLength('#pwd','#errpassword');
            if (r1 & r3 ){
                return true;
            }else{
                return false;
            }
        }

    </script>
</head>
<body>
<div class="login">
    <div class="header">
        <h1>
            <a href="#">login</a>&emsp;&emsp;&emsp;&emsp;
            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
            <a href="${pageContext.request.contextPath}/register.jsp" id="reg">register</a>
        </h1>
        <button></button>
    </div>
    <form action="${pageContext.request.contextPath}/auth/login?redirect=${param.redirect}" method="post" onsubmit="return checkSubmit()">
        <div class="name">
            <span style="color:red">${err}</span>
            <span id="errname" style="color:red">${errmessage }</span>
            <input type="text" id="name" name="username" onblur ="checkEmpty('#name','#errname')" placeholder="User Name" >
            <p></p>
        </div>
        <div class="pwd">
            <span id="errpassword" style="color:red"></span>
            <input type="password" id="pwd" name="password" onblur ="checkLength('#pwd','#errpassword')"placeholder="Password">
            <p></p>
        </div>

        <div class="btn-red">
            <input type="submit" value="Login" id="login-btn">
        </div>
    </form>

</div>
</body>
</html>
