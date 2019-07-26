<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%-- ID入力画面 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ワールドカップ検索サイト</title>
</head>
<body>
	<h1>ようこそワールドカップ検索サイトへ！</h1>
	<p>プレイヤーIDまたは国IDを入力して下さい</p>
	<table>
		<tr>
			<th>プレイヤーID</th>
			<form action="#" method="post">
				<td><input type="text" name="player_id"></td>
				<td><input class="search_btn" type="submit" name="pltest"
					value="選手検索"></td>
			</form>
		</tr>
		<tr>
			<th>国ID</th>
			<form action="#" method="post">
				<td><input type="text" name="countory_id"></td>
				<td><input class="search_btn" type="submit" name="cotest"
					value="国指定検索"></td>
			</form>
		</tr>
	</table>
</body>
</html>