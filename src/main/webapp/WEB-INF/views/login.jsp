<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta charset="utf-8">
  <title><fmt:message key="login.title"/></title>
<link rel="stylesheet" type="text/css" href="<c:url value="resources/style.css"/>"/>
</head>
<body>
<div class="container">
	<section id="content">
		<form:form method="post" commandName="connection">
			<h1><fmt:message key="login.heading"/></h1>
			<div>
				<form:input  class="connection" placeholder="CardNumber"  id="cardNumber" path="cardNumber" required="true"/>
			</div>
			<div>
				<form:input  type="password" placeholder="Nip"  id="nip" path="nip" required="true"/>
			</div>
			<div>
				<form:errors path="cardNumber" cssClass="error"/>
			</div>			
			<div>
				<form:errors path="nip" cssClass="error"/>
			</div>			
			<div>
				<input type="submit" value="Log in" />
			</div>
		</form:form><!-- form -->
	</section><!-- content -->
</div><!-- container -->
</body>
</html>