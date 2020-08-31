<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.List"%>
<%@page import="com.shopping.biz.book.BookVO"%>
<%
	String url = (String) request.getAttribute("url");
%>
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
	<!-- ��� ��  -->
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
						<li><a href="orderConfirmation.do?id=<%=id%>">�ֹ� Ȯ��</a></li>
						<li><a href="userInfo.do?id=<%=id%>">������������</a></li>
						<li><a href="listBasket.do?id=<%=id%>">��ٱ���</a></li>
						<li><a href="creditcardList.do?id=<%=id%>">�ſ�ī������</a></li>
						<li><a href="addressList.do?id=<%=id%>">�ּ�����</a></li>
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
						<li><a href="allOrder.do">�� �ֹ� Ȯ��</a></li>
						<li><a href="insertBook.jsp">��ǰ ���</a></li>
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
	<!-- ��� �� �� -->
	
	<div style="margin: 0 auto;" align="center">
	<table class="type05">
		<form action="upload.do" method="post" enctype="multipart/form-data">
		<tr>
			<td>����</td>
			<td><input type="file" name="file1"></td>
			<td><input type="submit" value="�������" class="btn btn-outline-secondary"></td>
		</tr>
		</form>
		<form action="insertBook.do" method="post">
		<tr>
			<td>å�̸�</td>
			<td><input type="text" name="bookName" class="form-control"></td>
		</tr>
		<tr>
			<td>å����</td>
			<td><input type="text" name="bookPrice" class="form-control"></td>
		</tr>
		<tr>
			<td>å����</td>
			<td><textarea cols="50" rows="15" name="bookComment"></textarea></td>
		</tr>
		<tr>
			<td>å����</td>
			<td><input type="text" name="bookCount" class="form-control"></td>
		</tr>
		<tr>
			<td>å����</td>
			<td><input type="hidden" name="bookPicture" value="<%=url%>"><%=url%></td>
		</tr>
		
	</table>
	<input type="submit" value="���" class="btn btn-outline-secondary">
	</form>
	</div>
</body>
</html>