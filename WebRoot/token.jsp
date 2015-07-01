<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Auth</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/auth/access_token" method="post">
<input type="hidden" value="token" name="response_type"/>
<input type="hidden" value="access_token" name="grant_type"/>
code: <input type="text" value="" name="code"/><br/>
scope: <input type="text" value="" name="scope"/><br/>
state: <input type="text" value="" name="state"/><br/>
client_id: <input type="text" value="" name="client_id"/><br/>
client_secret: <input type="text" value="" name="client_secret"/><br/>
username : <input type="text" value="" name="username"/> <br/>
password : <input type="text" value="" name="password"/> <br/>
<input type="submit" value="提交"/>
</form>
</body>
</html>