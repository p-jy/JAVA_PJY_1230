<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<form action="<c:url value="/signup"/>" method="post">
		<div class="form-group  mt-3">
			<label for="id">아이디</label>
			<input type="text" class="form-control" id="id" name="me_id">
		</div>
		<div class="form-group mt-3">
			<label for="pw">비밀번호</label>
			<input type="password" class="form-control" id="pw" name="me_pw">
		</div>
		<div class="form-group mt-3">
			<label for="pw2">비번 확인</label>
			<input type="password" class="form-control" id="pw2">
		</div>
		<div class="form-group mt-3">
			<label for="email">이메일</label>
			<input type="email" class="form-control" id="email" name="me_email">
		</div>
		<button type="submit" class="btn btn-outline-success mt-3 col-12">회원가입</button>
	</form>
</body>
</html>