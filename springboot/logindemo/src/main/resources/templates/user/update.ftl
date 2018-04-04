<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Update</title>
</head>
<body>
<form action="${springMacroRequestContext.contextPath}/user/update" method="POST">
    <input type="hidden" name="id" value="${user.id!}">
    <label>
        Username: <input type="text" name="username" value="${user.username!}">
    </label><br/>
    <label>
        Password: <input type="password" name="password" value="${user.password!}">
    </label>
    <input type="submit" value="提交">
</form>
</body>
</html>