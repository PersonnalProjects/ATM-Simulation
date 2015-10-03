<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta charset="utf-8">
<title><fmt:message key="transactions_panel.title"/></title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>"/>
</head>
<body>
<div class="container">
	<section id="content">	
	<%@ include file="/WEB-INF/views/top.jsp" %>
	<form method="post" action="">
			<h1><fmt:message key="transactions_panel.heading"/></h1>
			
			<ul class="menu">
				<li class="radius" ><a   href="<c:url value="/deposit.htm"/>" >Deposit</a> </li  >
				<li class="radius"><a  href="<c:url value="/withdrawal.htm"/>" >Withdrawal</a></li>
				<li class="radius"><a href="<c:url value="/transactions_history.htm"/>" >History</a></li>
				<li class="radius"><a href="<c:url value="/balance.htm"/>" >Balance</a></li>	
			<ul>	
		</form><!-- form -->		
	</section><!-- content -->
</div><!-- container -->
</body>
</html>