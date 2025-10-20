<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#wrap {
	width: 1200px;
	border: 1px solid lightgray;
	margin: auto;
	text-align: center;
}

table {
	box-shadow: 1px 1px 1px rgba(0, 0, 0, 0.4);
}
</style>
</head>
<body>
	<div id="wrap">

		<h1>직장 회사원 정보</h1>

		<table>


			<tr>
				<th>사원번호</th>
				<th>직원명</th>
				<th>주민등록번호</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>부서코드</th>
				<th>직급코드</th>
				<th>급여등급</th>
				<th>급여</th>
				<th>보너스율</th>
				<th>관리자사번</th>
				<th>입사일</th>
				<th>퇴사일</th>
				<th>재직여부</th>
			</tr>
			<c:choose>
				<c:when test="${empty employeeList }">
					<tr>
						<th colspan="14">조회결과가 존재하지 않습니다.</th>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${employeeList}" var="employee">
						<tr>
							<td>${employee.empId}</td>
							<td>${employee.empName}</td>
							<td>${employee.empNo}</td>
							<td>${employee.email}</td>
							<td>${employee.phone}</td>
							<td>${employee.deptCode}</td>
							<td>${employee.jobCode}</td>
							<td>${employee.salLevel}</td>
							<td>${employee.salary}</td>
							<td>${employee.bonus}</td>
							<td>${employee.managerId}</td>
							<td>${employee.hireDate}</td>
							<td>${employee.entDate}</td>
							<td>${employee.entYn}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>

	</div>
</body>
</html>