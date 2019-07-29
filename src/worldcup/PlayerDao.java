package worldcup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Java入門 ショッピング風DAOクラス.
 */
public class PlayerDao {

	private Connection con = null;
	private ResultSet  rs  = null;
	private PreparedStatement ps = null;

	/**
	 * データベースの選手情報を取得.
	 * @return	商品情報（ResultSet）
	 * @throws SQLException
	 */
	public ResultSet selectItem(String playerId) throws SQLException {

		try {

			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName("com.mysql.jdbc.Driver");

			// データベースと接続（本来はユーザやパスワードも別管理にしておくのが理想）
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldcup2014",
											  "root",
											  "");
			// SQL文を生成
			ps = con.prepareStatement("SELECT p.id, c.name, p.uniform_num, p.position, p.name, p.club, p.birth, p.height, p.weight FROM players p INNER JOIN countries c ON p.country_id = c.id WHERE p.id = ?");
			// SQL文に選手IDを設定
			ps.setString(1, playerId);
			// SQLを実行
			rs = ps.executeQuery();

		} catch(ClassNotFoundException ce) {

			// JDBCドライバが見つからなかった場合
			ce.printStackTrace();
		}

		return rs;
	}

	public void close() {

		try {

			// データベースとの接続を解除する
			if(con != null) {
				con.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(rs != null) {
				rs.close();
			}

		} catch (SQLException se) {

			// データベースとの接続解除に失敗した場合
			se.printStackTrace();
		}
	}
}