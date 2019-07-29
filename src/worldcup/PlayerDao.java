package worldcup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PlayerDao {

	private Connection con = null;
	private ResultSet  rs  = null;
	private PreparedStatement ps = null;

	/**
	 * 選手IDからデータベースの選手情報を取得.
	 * @return	選手情報（ResultSet）
	 * @throws SQLException
	 */
	public ResultSet selectPlayer(int playerId) throws SQLException {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/worldcup2014",
											  "root",
											  "");
			ps = con.prepareStatement("SELECT p.id, c.name AS cname, p.uniform_num, p.position, p.name AS pname, p.club, p.birth, p.height, p.weight FROM players p INNER JOIN countries c ON p.country_id = c.id WHERE p.id = ?");
			ps.setInt(1, playerId);
			rs = ps.executeQuery();

		} catch(ClassNotFoundException ce) {

			ce.printStackTrace();
		}

		return rs;
	}

	public void close() {

		try {

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

			se.printStackTrace();
		}
	}
}