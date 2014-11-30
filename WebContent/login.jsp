<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta charset="utf-8">
  <title><fmt:message key="login.title"/></title>
<link rel="stylesheet" type="text/css" href="<c:url value="/style.css"/>"/>
</head>
<body>
<div class="container">
	<section id="content">
		<form method="post" action="j_spring_security_check" >
			<h1><fmt:message key="login.heading"/></h1>
			<div>
				<input  name="j_username" class="connection" placeholder="CardNumber"  id="cardNumber" required="true"/>
			</div>
			<div>
				<input  name="j_password" type="password" placeholder="Nip"  id="nip"  required="true"/>
			</div>			
			<div>
				<input type="submit" value="Log in" />
			</div>
		</form><!-- form -->
	</section><!-- content -->
</div><!-- container -->
</body>
</html>