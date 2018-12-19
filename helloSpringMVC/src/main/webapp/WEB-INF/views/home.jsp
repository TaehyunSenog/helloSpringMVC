<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>HomePage</title>
</head>
<body>
	<h1>성태현 학생의 성적</h1>

	
		<!-- 학기별 이수학점 조회 -->
		<P><a href="${pageContext.request.contextPath}/semesterGrade ">
			학기 별 이수학점 조회</a></P>
			
		<!-- 수강 신청 하기-->	
		<P><a href="${pageContext.request.contextPath}/courseRegist ">
			 수강 신청 하기</a></P>
			
		<!-- 수강 신청 목록 조회 -->	
		<P><a href="${pageContext.request.contextPath}/searchCourse ">
			수강 신청 목록 조회</a></P>
</body>
</html>