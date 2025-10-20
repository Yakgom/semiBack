<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>
<body>
	<h1>Employee 추가</h1>
	<form action="ep.do" method="get">
	사원 번호 : <input type="text" name="empId"/><br>
	사원 명 : <input type="text"/ name="empName"><br>
	주민등록번호 : <input type="text" name="empNo"/><br>
	이메일 : <input type="text" name="email"/><br>
	전화번호 : <input type="text" name="phone"/><br>
	부서코드 : <input type="text" name="deptCode"/><br>
	직급코드 : <input type="text" name="jobCode"/><br>
	급여등급 : <input type="text" name="salLevel"/><br>
	급여 : <input type="number" name="salary"/><br>
	보너스율 : <input type="number" name="bonus"/><br>
	관리자사번 : <input type="text" name="managerId"/><br>
	<button type="submit">추가</button>
	</form>
<a href="findAll.do">조회 페이지로</a>
</body>
</html>