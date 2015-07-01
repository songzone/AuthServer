<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Auth</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/auth/authorize" method="post">
<input type="hidden" value="code" name="response_type"/>
scope: <input type="text" value="" name="scope"/><br/>
state: <input type="text" value="" name="state"/><br/>
client_id: <input type="text" value="" name="client_id"/><br/>
<input type="submit" value="提交"/>
</form>
</body>
</html>