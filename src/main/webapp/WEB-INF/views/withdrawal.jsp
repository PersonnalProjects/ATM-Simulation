<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="utf-8">
<title><fmt:message key="withdrawal.title"/></title>
<link rel="stylesheet" type="text/css" href="resources/style.css" />
</head>
<body>
<div class="container">
	<section id="content">
		<%@ include file="/WEB-INF/views/top.jsp" %>
		<form:form method="post" commandName="withdrawalForm">
			<h1><fmt:message key="withdrawal.heading"/></h1>
			
			<table class="reference">
				<tr>
					<td><fmt:message key="withdrawal.amount"/> : </td>
					<td> <form:input path="amount"/></td>					
				</tr>			
			</table>	
			<div>
				<form:errors path="amount" cssClass="error"/>
			</div>
			<div>
				<fmt:message key="execute.button" var="executeButton" />
				<input type="submit" value="${executeButton}" />
			</div>	
		</form:form><!-- form -->
		<div>
			<a href="<c:url value="transactions_panel.htm"/>"><fmt:message key="back.link"/></a>
		</div>
	</section><!-- content -->
</div><!-- container -->
</body>
</html>