package worldcup;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Player {

	public PlayerBean getPlayer(int id) {

		PlayerBean bean = new PlayerBean();
		PlayerDao dao = null;
		ResultSet rs = null;

		try {

			// DAOクラスをインスタンス化
			dao = new PlayerDao();
			// 画面で入力されたIDとパスワードを基にDB検索を実行
			rs  = dao.selectPlayer(id);

			while(rs.next()) {


				bean.setPlayerid(rs.getInt("id"));
				bean.setCountry(rs.getString("cname"));
				bean.setUni_num(rs.getInt("uniform_num"));
				bean.setPosition(rs.getString("position"));
				bean.setPlayername(rs.getString("pname"));
				bean.setClub(rs.getString("club"));
				String birth = String.valueOf(rs.getDate("birth"));
				bean.setBirth(birth);
				bean.setHeight(rs.getInt("height"));
				bean.setWeight(rs.getInt("Weight"));

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			// 処理終了時に各接続を解除
			dao.close();
		}

		return bean;
	}
}