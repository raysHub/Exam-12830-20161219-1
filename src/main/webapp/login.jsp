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
<title>登录</title>

<script type="text/javascript">
	/*在输入的时候做空值校验，但是觉得总是弹出提示框太烦，还是用ajax做好，就没用这个了
	function check(){
		if(document.forms.loginForm.userName.value == ""){
			alert("请输入用户名");
			document.forms.loginForm.userName.focus();
		}
		if(document.forms.loginForm.password.value == ""){
			alert("密码不能为空");
		}
	} */

</script>

</head>
<body>
  <div style="text-align: center; margin-top: 15%">
  <%if(request.getAttribute("msg") != null){%>
	  <div id="msg" style="font: italic bold 18px 宋体;"><%= request.getAttribute("msg") %></div>
   <%}%>
   
	<form action="loginServlet" method="post" name="loginForm">
  	<% if(request.getAttribute("returnUri") != null){ %>
  		<input type="hidden" name="returnUri" value="<%=request.getAttribute("returnUri")%>">
  	<%}%>
		userName : <input type="text" name="userName" onblur="check()"><br/><br/>
		&nbsp;&nbsp;<input type="submit" value="提交">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="清空">
	</form>
  </div>
  
</body>
</html>