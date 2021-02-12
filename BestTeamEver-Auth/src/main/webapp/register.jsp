<%--
  Created by IntelliJ IDEA.
  User: bbq59
  Date: 1/1/2021
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./css/addStudent.css">
    <script type="text/javascript" src="./js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="./js/validation.js"></script>
    <script>
        function onCheckSubmit() {
            var r1 = checkEmpty('#username','#errname');
            var r2 = checkLength('#password','#errpassword');
            var r3 = checkPassword('#password2','#password','#errpassword2');
            var r4 = checkDateOfBirth('#dateofbirth','#errdate');
            var r5 = checkEmail('#email','#erremail');
            var r6 = checkPhoneNumber('#phonenumber','#errphone');
            console.log(r1);
            console.log(r2);
            console.log(r3);
            console.log(r4);
            console.log(r5);
            console.log(r6);
            if (r1 & r2 & r3 & r4 & r5 & r6) {
                console.log('true');
                return true;
            }else {
                console.log('false');
                return false;
            }
        }
    </script>
</head>
<body>
<div id="form1">
    <form class="form-horizontal" action="user?method=register" onsubmit="return onCheckSubmit()" role="form" method="post">
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">User Name</label>
            <div class="col-sm-10">
                <span style="color:red">${err}</span>
                <span id="errname" style="color:red">${errmessage }</span>
                <input type="text" name="username" class="form-control" id="username" onblur="checkEmpty('#username','#errname')" placeholder="Please Enter Your User Name">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <span id="errpassword" style="color:red"></span>
                <input type="password" name="password" class="form-control" id="password" onblur="checkLength('#password','#errpassword')" placeholder="Please Enter Your Password">
            </div>
        </div>
        <div class="form-group">
            <label for="password2" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-10">
                <span id="errpassword2" style="color:red"></span>
                <input type="password" name="password2" class="form-control" id="password2" onblur="checkPassword('#password2','#password','#errpassword2')" placeholder="Please Enter Password Again">
            </div>
        </div>
        <div class="form-group">
            <label for="dateofbirth" class="col-sm-2 control-label">Birth Date</label>
            <div class="col-sm-10">
                <span id="errdate" style="color:red"></span>
                <input type="text" name="dateofbirth" class="form-control" id="dateofbirth" onblur="checkDateOfBirth('#dateofbirth','#errdate')" placeholder="Please Enter Date of Birth, DD/MM/YYYY">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <span id="erremail" style="color:red"></span>
                <input type="text" name="email" class="form-control" id="email" onblur="checkEmail('#email','#erremail')" placeholder="Please Enter Your Email">
            </div>
        </div>
        <div class="form-group">
            <label for="phonenumber" class="col-sm-2 control-label">Phone Number</label>
            <div class="col-sm-10">
                <span id="errphone" style="color:red"></span>
                <input type="text" name="phonenumber" class="form-control" id="phonenumber" onblur="checkPhoneNumber('#phonenumber','#errphone')" placeholder="Please Enter Your Phone Number">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Register</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
