<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
	String id = (String) session.getAttribute("id");
    String grade = (String) session.getAttribute("grade");
	Integer admin = (Integer) session.getAttribute("admin");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
</head>
<style>
.dropdown:hover>.dropdown-menu {
	display: block;
}

.a {
	font-family: corbel;
}

table.type05 {
	border-collapse: separate;
	border-spacing: 1px;
	text-align: left;
	line-height: 1.5;
	border-top: 1px solid #ccc;
	margin: 20px 10px;
}

table.type05 th {
	width: 150px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
	background: #efefef;
}
table.type05 td {
	width: 100px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}
</style>
<body
	style="margin-left: 50px; margin-right: 50px; margin-top: 40px; margin-bottom: 50px;">
	<!-- 상단 바  -->
	<nav class="navbar navbar-expand-sm navbar-dark bg-black">
		<a class="navbar-brand" href="main.do"><font size="50px"
			color="black">DN SHOP</font></a>
		<pre>        </pre>
		<div class="collapse navbar-collapse"
			style="float: auto; font-size: 20px;">
			<ul class="nav navbar-nav">
				<%
					if (id != null) {
				%>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown"><font color="black">MyPage</font></a>
					<ul class="dropdown-menu cust-drop">
						<li><a href="orderConfirmation.do?id=<%=id%>">주문 확인</a></li>
						<li><a href="userInfo.do?id=<%=id%>">개인정보수정</a></li>
						<li><a href="listBasket.do?id=<%=id%>">장바구니</a></li>
						<li><a href="creditcardList.do?id=<%=id%>">신용카드정보</a></li>
						<li><a href="addressList.do?id=<%=id%>">주소정보</a></li>
					</ul></li>
				<pre>        </pre>
				<%
					}
				%>
				<%
					if (admin != null && admin == 1) {
				%>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown"><font color="black">manager</font></a>
					<ul class="dropdown-menu cust-drop">
						<li><a href="allOrder.do">총 주문 확인</a></li>
						<li><a href="insertBook.jsp">물품 등록</a></li>
					</ul></li>
				<pre>        </pre>
				<%
					}
				%>
			</ul>
		</div>
		<div style="margin-right: 100px; font-size: 20px;">
			<%
				if (id == null) {
			%>
			<a href="login.jsp"><font color="black">Login</font></a>
			<%
				} else {
			%>
			<a href="logout.do"><font color="black">Logout</font></a>
			<%
				}
			%>
		</div>
	</nav>
	<!-- 상단 바 끝 -->
	
	<br><br><br>
	<div style="margin: 0 auto;" align="center">
<form action="login.do" method="post">
	<table style="border: 1px solid #444444;">
		<tr>
		<td>아이디</td>
		<td><input type="text" name="id" class="form-control"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password" class="form-control"></td>
		</tr>
		<tr>
		<td colspan="2"><input style="width: 200pt;" type="submit" class="btn btn-outline-secondary" value="로그인"></td>
		</tr>
		<tr>
		<td colspan="2"><input style="width: 200pt;" type="button" class="btn btn-outline-secondary" value="회원가입 " onclick="location.href='join.jsp'"></td>
		</tr>
	</table>
</form>
</div>
</body>
</html>