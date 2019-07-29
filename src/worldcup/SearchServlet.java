package worldcup;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

			String id  = request.getParameter("player_id");
			int plid = Integer.valueOf(id);

			Player player = new Player();

			PlayerBean bean = player.getPlayer(plid);

			if(bean != null) {
				rd = request.getRequestDispatcher("./PlayerServlet");
			} else {
				rd = request.getRequestDispatcher("./WorldCup/searchid.jsp");
			}
			rd.forward(request, response);

		} else if("国指定検索".equals(btn)) {

			String id  = request.getParameter("country_id");
			int coid = Integer.valueOf(id);

			Country country = new Country();

			ArrayList<PlayerBean> beanList = country.getCountry(coid);

			if(beanList != null) {
				rd = request.getRequestDispatcher("./CountryServlet");
			} else {
				rd = request.getRequestDispatcher("./WorldCup/searchid.jsp");
			}
			rd.forward(request, response);

		}
	}

	/**
	 * GETメソッドでリクエストされた場合の処理.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 今回はdoPostで処理
		doPost(request, response);
	}
}