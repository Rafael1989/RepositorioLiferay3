<%@ include file="init.jsp" %>
<html>
	<body>
		<h3>Login</h3>
		<p>Essa página tem como objetivo logar no sistema</p>
		<form action="${fazerLoginUrl}" method="post" id="formLogin">
			Login:<br/>
			<input type="text" name="<portlet:namespace/>login" id="login"><br/>
			Senha:<br/>
			<input type="password" name="<portlet:namespace/>senha" id="senha"><br/>
			<input type="button" onclick="fazerLogin();" value="Fazer Login"> 
		</form>
		${mensagem}
	</body>
</html>