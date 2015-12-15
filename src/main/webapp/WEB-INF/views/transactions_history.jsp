<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="utf-8">
<title><fmt:message key="transactions_history.title"/></title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>"/>
</head>
<body>
<div class="container">
	<section id="content">
		<%@ include file="/WEB-INF/views/top.jsp" %>
		<form:form method="post" commandName="backButton">
			<h1><fmt:message key="transactions_history.heading"/></h1>
			<table class="reference">
				<tr>
					<th>Type</th>
					<th>Amount</th>
					<th>Date</th>
					<th>Status</th>		
				</tr>
				
			    <c:forEach items="${transactions}" var="transaction">    
					<tr>
						<td><c:out value="${transaction.type}"/></td>
						<td><c:out value="${transaction.amount}"/></td>							
						<td><c:out value="${transaction.date}"/></td>
						<td><c:out value="${transaction.status}"/></td>
					</tr>		    
			    </c:forEach>			
			</table>
		</form:form><!-- form -->
		<div>
			<a href="<c:url value="transactions_panel.htm"/>"><fmt:message key="back.link"/></a>
		</div>		
	</section><!-- content -->
</div><!-- container -->
</body>
</html>

