<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>login page</title>
    <script type="text/javascript" src="/static/js/login.js"></script>
</head>
<body>
<#if error??>
<span style="color: red">Username or Password Error!</span>
</#if>
<form action="/login" method="post">
    <label>用户名：<input type="text" name="username"></label><br/>
    <label>密码：<input type="password" name="password"></label><br/>
    <button type="submit" value="submit">提交</button>
</form>
</body>
</html>