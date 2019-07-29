<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="worldcup.PlayerBean"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>国別選手検索結果</title>
</head>
<body>
	<div>
		<h1>国別選手一覧</h1>
		<%
			ArrayList<PlayerBean> playerList = (ArrayList<PlayerBean>) request.getAttribute("playerList");
		%>
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
			<%
				for (PlayerBean bean : playerList) {
			%>
			<tr>
				<td><%=bean.getPlayerid()%></td>
				<td><%=bean.getCountry()%></td>
				<td><%=bean.getUni_num()%></td>
				<td><%=bean.getPosition()%></td>
				<td><%=bean.getPlayername()%></td>
				<td><%=bean.getClub()%></td>
				<td><%=bean.getBirth()%></td>
				<td><%=bean.getHeight()%></td>
				<td><%=bean.getWeight()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<input class="back_btn" type="submit" onclick="location.href='./WorldCup/searchid.jsp'" value="検索に戻る">
	</div>

</body>
</html>