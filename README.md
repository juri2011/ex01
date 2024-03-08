# ex01
Spring Framework 기반으로 국비지원 수업 때 진행된 회원관리 CRUD 실습 예제 프로젝트입니다.

## :computer: 개발 환경
* `JAVA11`
* `javascript` `jQuery`
* `STS3`
* `MySql`
* `Spring` `MyBatis`

## :memo: 요구사항
### 회원가입
|주요기능(함수)|설명|SQL
|---|---|---|
|`saveForm()`|save.jsp 화면으로 이동|
|`save()`|사용자로부터 입력을 받아 회원을 등록|insert|
|`onclick=emailCheck()`<br>`findByMemberEmail()`|비동기로 이메일 중복 확인|selectOne|
### 로그인
|주요기능(함수)|설명|SQL
|---|---|---|
|`loginForm()`|login.jsp 화면으로 이동|
|`login()`|사용자가 입력한 정보가 DB에 있으면<br> session에 로그인 정보 저장, main 화면으로 이동 |select (selectOne)|
### 게시글 전체 리스트
|주요기능(함수)|설명|SQL
|---|---|---|
|`findAll()`|사용자로부터 입력을 받아 회원을 등록|select(selectList)|
### 상세 페이지 조회
|주요기능(함수)|설명|SQL
|---|---|---|
|`findById()`|아이디로 특정 사용자 정보를 얻음|select(selectOne)|
|`emailCheck()`<br>`findByMemberEmail()`|비동기로 이메일 중복 확인|selectOne|
### 삭제
|주요기능(함수)|설명|SQL
|---|---|---|
|`delete()`|상세페이지로부터 id값을 받아서 해당 게시물 삭제|delete|
### 수정
|주요기능(함수)|설명|SQL
|---|---|---|
|`updateForm()`|update.jsp로 이|
|`update()`|사용자로부터 입력한 값을 받아서 게시글 수정|update|
|`onclick=update()`|비밀번호 확인 : 맞는 경우만 수정|update|
## :open_file_folder: 구조
### 클래스
* HomeController
* ModelController
* ModelDTO
* ModelService
* ModelRepository
### views
* index.jsp
* save.jsp
* login.jsp
* main.jsp
* list.jsp
* detail.jsp
* update.jsp
* delete.jsp
## :wrench: 개선사항

## :bulb: 알게 된 점
* jsp와는 달리 view와 controller를 분리해서 작업했는데, 구조가 훨씬 깔끔하게 정리가 되었고 구현하고 싶은 부분만 집중해서 코딩할 수 있었다.
* MyBatis를 사용해서 훨씬 더 간편하게 CRUD 작업을 할 수 있었다.
* root-context.xml로 DB드라이버와 Connection Pool을 설정해놓으니 기존에 jsp에서 CRUD 작업 했을 때에 비해 코드가 훨씬 간결해졌다.
