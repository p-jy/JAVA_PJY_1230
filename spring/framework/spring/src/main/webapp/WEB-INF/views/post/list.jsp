<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>�Խñ� ����Ʈ</h1>
	<table class="table table-hover table-warning">
		<thead>
			<tr>
				<th>��ȣ</th>
				<th>����</th>
				<th>�ۼ���</th>
				<th>�ۼ���</th>
				<th>��ȸ��</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="post">
				<tr>
					<td>${post.po_num}</td>
					<td>
						<a href="#">${post.po_title}</a>
					</td>
					<td>${post.po_me_id}</td>
					<td> <fmt:formatDate value="${post.po_date}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<td>${post.po_view}</td>
				</tr>
			</c:forEach>
			<c:if test="${list.size() eq 0}">
				<tr>
					<th colspan="5">��ϵ� �Խñ��� �����ϴ�.</th>
				</tr>
			</c:if>
		</tbody>
	</table>
</body>
</html>