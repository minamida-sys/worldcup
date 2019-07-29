package worldcup;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public SearchServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String btn = request.getParameter("submit");

		RequestDispatcher rd;




		if("選手検索".equals(btn)) {

			// 入力された選手IDの取得とInt変換
			String id  = request.getParameter("player_id");
			int plid = Integer.valueOf(id);

			// 入力されたIDをもとに選手情報をBeanクラスにセット
			Player player = new Player();
			PlayerBean bean = player.getPlayer(plid);

			// Beanクラスに選手情報がセットされたか確認。(されていない場合、検索ページに留まる)
			if(bean != null) {
//				Player player = new Player();

				HttpSession session = request.getSession();
//				String id  = request.getParameter("player_id");
//				int plid = Integer.valueOf(id);

				PlayerBean pl = player.getPlayer(plid);

				session.setAttribute("user_db", pl);

				rd = request.getRequestDispatcher("./WorldCup/player_result.jsp");
				rd.forward(request, response);



//				rd = request.getRequestDispatcher("./PlayerServlet");
			} else {
				rd = request.getRequestDispatcher("./WorldCup/searchid.jsp");
			}


		} else if("国指定検索".equals(btn)) {

			// 入力された国IDの取得とInt変換
			String id  = request.getParameter("country_id");
			int coid = Integer.valueOf(id);

			// 入力されたIDをもとに選手情報をBeanリストにセット
			Country country = new Country();
			ArrayList<PlayerBean> beanList = country.getCountry(coid);

			// Beanリストに選手情報がセットされたか確認。(されていない場合、検索ページに留まる)
			if(beanList != null) {
//				String id  = request.getParameter("country_id");
//				int coid = Integer.valueOf(id);

//				Country country = new Country();
//				ArrayList<PlayerBean> playerList = country.getCountry(coid);

				request.setAttribute("playerList", beanList);


				rd = request.getRequestDispatcher("./WorldCup/country_result.jsp");
				rd.forward(request, response);


//				rd = request.getRequestDispatcher("./CountryServlet");
			} else {
				rd = request.getRequestDispatcher("./WorldCup/searchid.jsp");
			}

		}
	}

	/**
	 * GETメソッドでリクエストされた場合の処理.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Getで呼び出されてもPostで再呼び出し
		doPost(request, response);
	}
}