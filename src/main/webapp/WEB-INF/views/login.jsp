<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<form action="/member/login" method="post">
		<!-- DB와 컬럼명과 맞췄다. (DTO, VO와도 이름을 맞출 에정이다.) -->
		<p>아이디 : <input type="text" name="memberEmail" placeholder="이메일" /></p>
		<p>비밀번호 : <input type="password" name="memberPassword" placeholder="비밀번호" /></p>
		<input type="submit" value="로그인" />
	</form>
</body>
</html>