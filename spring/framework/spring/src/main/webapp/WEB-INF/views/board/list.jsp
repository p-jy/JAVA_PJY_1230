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
			<c:forEach items="${list}" var="board">
				<tr>
					<td>${board.bo_num}</td>
					<td>
						<a href="#">${board.bo_title}</a>
					</td>
					<td>${board.bo_me_id}</td>
					<td> <fmt:formatDate value="${board.bo_date}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
					<td>${board.bo_view}</td>
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