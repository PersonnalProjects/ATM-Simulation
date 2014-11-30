<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="utf-8">
<title><fmt:message key="deposit.title"/></title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<div class="container">
	<section id="content">
		<%@ include file="/WEB-INF/jsp/top.jsp" %>	
		<form:form method="post" commandName="depositForm">
	
			<h1><fmt:message key="deposit.heading"/></h1>
			
			<table class="reference">
				<tr>
					<td>Deposit Amount : </td>
					<td> <form:input path="amount"/></td>					
				</tr>			
			</table>	
			<div>
				<form:errors path="amount" cssClass="error"/>
			</div>
			<div>
				<input type="submit" value="Execute" />
			</div>	
		</form:form><!-- form -->
		<div>
			<a href="<c:url value="transactions_panel.htm"/>">Back</a>
		</div>
	</section><!-- content -->
</div><!-- container -->
</body>
</html>