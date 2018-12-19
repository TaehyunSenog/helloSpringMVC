<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수강 신청</title>
</head>
<body>

	<form method="get"
		action="${pageContext.request.contextPath}/doregister">

		<table class="formtable">
			<tr>
				<td class="label">과목코드 :</td>
				<td><input class="control" name="course_code" type="text" /></td>
			</tr>
			<tr>
				<td class="label">과목명 :</td>
				<td><input class="control" name="course_name" type="text" /></td>
			</tr>
			<tr>
				<td class="label">구분 :</td>
				<td><input class="control" name="course_value" type="text" /></td>
			</tr>
			<tr>
				<td class="label">학점 :</td>
				<td><input class="control" name="course_grades" type="text" /></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" value="Create Register" type="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>