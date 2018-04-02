<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>login page</title>
    <script type="text/javascript" src="/static/js/login.js"></script>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="20">
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>password</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
        </tr>
    </#list>
</table>
</body>
</html>