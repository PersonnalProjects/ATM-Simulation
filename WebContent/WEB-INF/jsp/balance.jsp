<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta charset="utf-8">
<title><fmt:message key="balance.title"/></title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<div class="container">
	<section id="content">
		<%@ include file="/WEB-INF/jsp/top.jsp" %>	
		<form method="post">
			<h1><fmt:message key="balance.heading"/></h1>
			
			<table class="reference">
				<tr>
					<td>The balance of account your is : </td>
					<td> <c:out value="${balance}"/></td>
				</tr>

			</table>	
		</form><!-- form -->
		<div>
			<br><a href="<c:url value="transactions_panel.htm"/>">Back</a>
		</div>		
	</section><!-- content -->
</div><!-- container -->
</body>
</html>
