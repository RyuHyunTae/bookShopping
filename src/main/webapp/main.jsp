<%@page import="java.util.List"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="com.shopping.biz.book.BookVO" %>
<%
	List<BookVO> listBook = (List) request.getAttribute("listBook");

	String id = (String) session.getAttribute("id");
	String grade = (String) session.getAttribute("grade");
	Integer admin = (Integer) session.getAttribute("admin");
	int count = 0;
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
	<div align="right">
	<form action="search.do" method="post">
	<input type="text" name="bookName">
	<input type="submit" value="검색">
	</form>
	</div>
	<div style="margin: 0 auto;" align="center">
	
	<table style="border-collapse: separate; border-spacing: 10px 10px;">
		<tr>
			<%
				for (BookVO book : listBook) {
			%>
			<td><img
				src="http://localhost:8080\biz\img\<%=book.getBookPicture()%>"
				width="500" height="500"
				onclick="location.href='oneBook.do?bookNum=<%=book.getBookNum()%>'"></td>
			<%
				if (count == 2) {
			%>
		</tr>
		<tr>
			<%
				}
					count++;
				}
			%>
		</tr>
	</table>
	</div>
</body>
</html>