<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Add</title>
</head>
<body>
<form action="${springMacroRequestContext.contextPath}/user/add" method="POST">
    <label>
        Username: <input type="text" name="username">
    </label><br/>
    <label>
        Password: <input type="password" name="password">
    </label>
    <input type="submit" value="提交">
</form>
</body>
</html>