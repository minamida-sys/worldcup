<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="user_db" scope="session" class="worldcup.PlayerBean" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>選手検索結果</title>
</head>
<body>

	<div>
		<h1>選手検索結果</h1>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>国名</th>
				<th>背番号</th>
				<th>位置</th>
				<th>名前</th>
				<th>所属クラブ</th>
				<th>生年月日</th>
				<th>身長</th>
				<th>体重</th>
			</tr>
			<tr>
				<td><jsp:getProperty property="playerid" name="user_db"/></td>
				<td><jsp:getProperty property="country" name="user_db"/></td>
				<td><jsp:getProperty property="uni_num" name="user_db"/></td>
				<td><jsp:getProperty property="position" name="user_db"/></td>
				<td><jsp:getProperty property="playername" name="user_db"/></td>
				<td><jsp:getProperty property="club" name="user_db"/></td>
				<td><jsp:getProperty property="birth" name="user_db"/></td>
				<td><jsp:getProperty property="height" name="user_db"/></td>
				<td><jsp:getProperty property="weight" name="user_db"/></td>
			</tr>
		</table>
		<input class="back_btn" type="submit" onclick="location.href='./WorldCup/searchid.jsp'" value="検索に戻る">
	</div>

</body>
</html>