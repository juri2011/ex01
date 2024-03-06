<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<h2>${sessionScope.loginEmail}님 환영합니다.</h2>
	<button onclick="update()">내 정보 수정하기</button>
	<button onclick="logout()">로그아웃</button>
</body>
<!-- 
	리액트로 자바스크립트 소스를 작성하면 컴파일러가 소스를 컴파일하므로 소스 보기로 확인 할 수 없다.
	리액트의 단점 : 소스를 컴파일 하는 동안 검색엔진이 인식을 할 수 없음 -> 이 문제를 해결하기 위해 SEO도입
	리액트의 컴파일 시간 문제를 확인할 수 있는 예시로 에어비앤비 홈페이지가 있다.
-->
<script>
	const update = () => {
		//location 의 부모 BOM - Browser Object Model
		location.href = "/member/update";
	}
	const logout = () => {
		location.href = "/member/logout";
	}
	
</script>
</html>