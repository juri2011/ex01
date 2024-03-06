<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
</head>
<body>
	<form action="/member/update" method="post" name="updateForm">
		<!-- DB와 컬럼명과 맞췄다. (DTO, VO와도 이름을 맞출 에정이다.) -->
		<p>아이디 : <input type="text" name="id" value="${member.id}" readonly /></p>
		<p>이메일 : <input type="text" name="memberEmail" value="${member.memberEmail}" readonly /></p>
		<p>비밀번호 : <input type="password" name="memberPassword" id="memberPassword" /></p>
		<p>이름 : <input type="text" name="memberName" value="${member.memberName}" readonly /></p>
		<p>나이 : <input type="text" name="memberAge" value="${member.memberAge}" /></p>
		<p>전화번호 : <input type="text" name="memberMobile" value="${member.memberMobile}" /></p>
		
		<input type="button" value="회원수정" onclick="update()"/>
	</form>
</body>
<script>
	const update = () => {
		//소스보기로 확인할 수 있으므로 보안성 측면에서 좋은 방법은 아니다.
		const passwordDB = '${member.memberPassword}';
		const password = document.getElementById('memberPassword').value;
		
		if(passwordDB == password){
			//위에서 form에 이름을 준 이유는 여기서 사용하기 위해서이다.
			document.updateForm.submit();
		}else{
			alert("비밀번호가 일치하지 않습니다!");
		}
	}
</script>
</html>