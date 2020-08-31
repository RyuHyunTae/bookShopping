<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.List"%>
<%@page import="java.text.*"%>
<%@page import="com.shopping.biz.basket.BasketVO"%>
<%@page import="com.shopping.biz.book.BookVO"%>
<%@page import="com.shopping.biz.user.AddressVO" %>
<%@page import="com.shopping.biz.user.CreditcardVO" %>
<%
	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String today = formatter.format(new java.util.Date());

	String id = (String) session.getAttribute("id");
	String grade = (String) session.getAttribute("grade");
	Integer admin = (Integer) session.getAttribute("admin");
	List<AddressVO> addressList = (List) request.getAttribute("addressList");
	List<CreditcardVO> creditcardList = (List) request.getAttribute("creditcardList");
	List<BasketVO> listBasket = (List) request.getAttribute("basketList");
	List<BookVO> allCloth = (List) request.getAttribute("allCloth");

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
	<h3>����ȭ��</h3>
	<table class="type05">
		<tr>
			<td width="70">����</td>
			<td width="500">��ǰ��</td>
			<td width="100">����</td>
			<td>����</td>
		</tr>
		<%for(BasketVO basket : listBasket){ %>
		<tr>
			<td><img
				src="http://localhost:8080\biz\img\<%=basket.getBookPicture()%>"
				width="70" height="70"></td>
			<td width="500" cellpadding="5" cellspacing="2"
				style="table-layout: fixed; word-break: break-all;"><%=basket.getBookName()%></td>
			<td width="100">
			<%if(grade.equals("a")){
					double a=basket.getBookPrice()*0.8;
					int b=(int)a;
					sum = sum + (b * basket.getCount());
					%>
				<td><%=b%></td>
				<%} else if(grade.equals("b")){ 
					double a=basket.getBookPrice()*0.9;
					int b=(int)a;
					sum = sum + (b * basket.getCount());
					%>
				<td><%=b%></td>
				<%} else if(grade.equals("c")){ 
					double a=basket.getBookPrice();
					int b=(int)a;
					sum = sum + (b * basket.getCount());
					%>
				<td><%=b%></td>
				<%} %>
				</td>
			<td><%=basket.getCount() %></td>
			</tr>
			<%} %>
		<tr>
			<td></td>
			<td></td>
			<td style="text-align: right;">�հ�</td>
			<td><%=sum%></td>
		</tr>
	</table>
			<form action="insertListOrder.do" method="post"><div>
		<input type="radio" name="addressCheck" value="1" checked>�� �ּ�
		<input type="radio" name="addressCheck" value="0">���� �ּ�
		<script>$(document).ready(function(){
			 
		    // ������ư Ŭ���� �̺�Ʈ �߻�
		    $("input:radio[name=addressCheck]").click(function(){
		 
		    	if($("input[name=addressCheck]:checked").val() == "1"){
		    		$("input:radio[name=deliverAddress]").attr("disabled",true);
		            // radio ��ư�� value ���� 1�̶�� Ȱ��ȭ
		        }else if($("input[name=addressCheck]:checked").val() == "0"){
		        	$("input:radio[name=deliverAddress]").attr("disabled",false);
		            //
		        }
		    	
		        if($("input[name=addressCheck]:checked").val() == "1"){
		        	 $("input:text[name=deliverAddress]").attr("disabled",false);
		            // radio ��ư�� value ���� 1�̶�� Ȱ��ȭ
		        }else if($("input[name=addressCheck]:checked").val() == "0"){
		              $("input:text[name=deliverAddress]").attr("disabled",true);
		            // radio ��ư�� value ���� 0�̶�� ��Ȱ��ȭ
		        }
		    });
		});
</script></div>
		<input type="text" name="deliverAddress" id="test" style="width: 500px;"><br>
		<%for(AddressVO address : addressList){ %>
			<input type="radio" name="deliverAddress" value="<%=address.getAddress()%> <%=address.getAddressdetail()%>" disabled="disabled"><%=address.getAddress()%> <%=address.getAddressdetail()%><br>
		<%} %>
		<br>
		<h4>ī���ȣ</h4>
		<%for(CreditcardVO creditcard : creditcardList){ %>
			<input type="radio" name="creditcardNum" value="<%=creditcard.getCreditcardNum()%>"><%=creditcard.getCreditcardNum()%><br>
		<%} %>
		<input type="hidden" name="deliverState" value="�غ���">
		<input type="hidden" name="returnState" value="0">
		<input type="hidden" name="orderDate" value="<%=today%>">
		<input type="hidden" name="id" value="<%=id%>">
		<input type="hidden" name="grade" value="<%=grade%>">
		<input type="submit" value="����" class="btn btn-outline-secondary">
	</form>
	</div>

</body>
</html>