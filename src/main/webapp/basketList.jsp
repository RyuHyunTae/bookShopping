<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.List"%>
<%@page import="com.shopping.biz.book.BookVO"%>
<%@page import="com.shopping.biz.basket.BasketVO"%>
<%
	List<BookVO> allBook = (List) request.getAttribute("allBook");
	List<BasketVO> listBasket = (List) request.getAttribute("listBasket");
%>
<%
	String id = (String) session.getAttribute("id");
	String grade = (String) session.getAttribute("grade");
	Integer admin = (Integer) session.getAttribute("admin");
	int sum = 0;
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
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
	background: #efefef;
}

table.type05 td {
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

	<div style="margin: 0 auto;" align="center">
		<h3>장바구니</h3>
		<table class="type05">
			<tr>
				<td width="70">사진</td>
				<td width="500">물품명</td>
				<td width="100">가격</td>
				<td width="100">수량</td>
				<td></td>
			</tr>
			<%
				for (BasketVO basket : listBasket) {
			%>
			<tr>
				<%
					for (BookVO book : allBook) {
				%>
				<%
					if (basket.getBookNum() == book.getBookNum()) {
				%>
				<td><img
					src="http://localhost:8080\biz\img\<%=book.getBookPicture()%>"
					width="70" height="70"
					onclick="location.href='oneBook.do?bookNum=<%=book.getBookNum()%>'"></td>
				<td><%=book.getBookName()%></td>
				<%if(grade.equals("a")){
					double a=book.getBookPrice()*0.8;
					int b=(int)a;
					sum = sum + (b * basket.getCount());
					%>
				<td><%=b* basket.getCount()%></td>
				<%} else if(grade.equals("b")){ 
					double a=book.getBookPrice()*0.9;
					int b=(int)a;
					sum = sum + (b * basket.getCount());
					%>
				<td><%=b* basket.getCount()%></td>
				<%} else if(grade.equals("c")){ 
					double a=book.getBookPrice();
					int b=(int)a;
					sum = sum + (b * basket.getCount());
					%>
				<td><%=b* basket.getCount()%></td>
				<%} %>
				<td><a
					href="updateCountUp.do?bookNum=<%=basket.getBookNum()%>&id=<%=id%>">▲</a>
					<%=basket.getCount()%>
					<%
						if (basket.getCount() > 1) {
					%> <a
					href="updateCountDown.do?bookNum=<%=basket.getBookNum()%>&id=<%=id%>">▼</a>
					<%
						}
					%></td>

				<td><button class="btn btn-outline-secondary"
						onclick="location.href='deleteBasket.do?basketNum=<%=basket.getBasketNum()%>&id=<%=id%>'">삭제</button></td>
				<%
					}
				%>
				<%
					}
				%>
			</tr>
			<%
				}
			%>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td style="text-align: right;">합계</td>
				<td><%=sum%></td>
			</tr>
		</table>
		<button class="btn btn-outline-secondary"
			onclick="location.href='listOrder.do?id=<%=id%>'">구매</button>
	</div>
</body>
</html>