<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- cdn방식 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="/member/save" method="post">
		<!-- DB와 컬럼명과 맞췄다. (DTO, VO와도 이름을 맞출 에정이다.) -->
		<p>이 메 일 : <input type="text" name="memberEmail" placeholder="이메일" id="memberEmail" onblur="emailCheck()"/></p>
		<p id="check-result"></p>
		<p>비밀번호 : <input type="password" name="memberPassword" placeholder="비밀번호" /></p>
		<p>이름 : <input type="text" name="memberName" placeholder="이름" /></p>
		<p>나이 : <input type="text" name="memberAge" placeholder="나이" /></p>
		<p>전화번호 : <input type="text" name="memberMobile" placeholder="전화번호" /></p>
		<input type="submit" value="회원가입" />
	</form>
</body>
<script>

// 이메일 입력값을 가져오고,
// 입력값을 서버로 전송하고 똑같은 이메일이 있는지 체크한 후
// 사용 가능 여부를 이메일 입력창 아래에 표시
    const emailCheck = () => {
    	const email = document.getElementById("memberEmail").value;
    	const checkResult = document.getElementById("check-result");
    	
    	$.ajax({
    		type: "post",
    		url: "/member/email-check",
    		data: {
    			"memberEmail": email
    		},
    		//java의 try-catch문에 해당함
    		//javascript 오류를 edge보다 chrome이 더 잘 잡음...
    		
    		success: function(res){
    			//성공했을 시 res에 'ok'가 들어옴
    			if(res == 'ok'){
	    			console.log("사용 가능한 이메일");
	    			checkResult.style.color = "green";
	    			checkResult.innerHTML = "사용가능한 이메일";
    			}else{
    				console.log("이미 사용중인 이메일");
	    			checkResult.style.color = "red";
	    			checkResult.innerHTML = "이미 사용중인 이메일";
    			}
    		},
    		error: function(err){
    			console.log("에러발생", err);
    		}
    	});
    }
    
</script>
</html>