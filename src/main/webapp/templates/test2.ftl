
<html>  
  <head>  
        <title>freemarker</title>  
    </head>  
    <body>  
          <h1>世界</h1> 
        <h1>${message},${name}</h1>  
        <h2>
        	<#if Session.scheme?exists>
        		 ${Session.scheme}
        	</#if>
        </h2>
    </body>  
</html>