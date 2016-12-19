

<html>
	<title>所有电影</title>
	
<script type="text/javascript">
	function checkDelete(){
		if(request.getParameter("deleteFlag")){
			alert("删除失败");
		}
	}
</script>
	
	
<body onload="checkDelete()">
<div  style="margin: 30px 50px 0 50px">
 <form action="deleteFilmServlet" method="post">
	<table border=1>
		<tr><th>filmId</th><th>title</th><th>description</th><th>language</th><th style="width:50px; text-align: center;">操作</th></tr>
		<#list allFilms as film>
		<tr>
			<td><input type="text" name="filmId" value="${film.id}" readonly="readonly" style="width:50px; border: none;"></td>
			<td>${film.title}</td>
			<td>${film.description}</td>
			<td>${film.language}</td>
			<td style=" text-align: center;"><input type="submit" value="删除"><input type="submit" value="编辑（未实现）"></td>
		</tr>
		</#list>
	</table>
	<div style="margin: 20px 40%;">
		<#if pageNow gt 1>
			<a href="showFilmsServlet?pageNow=${pageNow-1}" style="margin-right:10px" >上一页</a>
		</#if>
		<#list 1..records as i>
			<#if i lt 10>
	  			<a href="showFilmsServlet?pageNow=${i}" style="margin-right:10px" >${i}</a>
	  		</#if>
		</#list>
		<a href="showFilmsServlet?pageNow=${pageNow+1}" style="margin-right:10px" >下一页</a>
	</div>
  </form>
</div>
</body>
</html>