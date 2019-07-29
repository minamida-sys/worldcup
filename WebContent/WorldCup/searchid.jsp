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
	<div>
		<h1>ようこそワールドカップ検索サイトへ！</h1>
		<p>プレイヤーIDまたは国IDを入力して下さい</p>
		<form action="../SearchServlet" method="post">
			<table border="1">
				<tr>
					<th>プレイヤーID</th>
					<td><input type="number" name="player_id"></td>
					<td><input class="search_btn" type="submit" name="submit"
						value="選手検索"></td>
				</tr>
				<tr>
					<th>国ID</th>
					<td><input type="number" name="country_id"></td>
					<td><input class="search_btn" type="submit" name="submit"
						value="国指定検索"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>