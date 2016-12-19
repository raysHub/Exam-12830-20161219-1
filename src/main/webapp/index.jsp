<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<div id="topic" style="margin: 5% 0 0 10% " >
		<h3>首页</h3><br/><br/>
		<%
			String flag = "";
			Object obj = session.getAttribute("flag");
			
			if(obj != null){
				flag = obj.toString();
			}
			if(flag.equals("login_success")){
		%>
		欢迎您,
		<%=request.getParameter("userName")
		%>
		<a href="<%= path %>/logoutServlet">退出</a><br/>
		<%} else{ %>
		请<a href="login.jsp">登录</a><br/>
		<%} %>
		<a href="<%= path %>/showFilmsServlet">查看已有的电影</a>
		<a href="#">新增电影（未实现）</a>
	</div>
</body>
</html>