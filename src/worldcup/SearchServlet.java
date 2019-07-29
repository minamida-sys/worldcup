package worldcup;

import java.io.IOException;

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

		HttpSession session = request.getSession();
		RequestDispatcher rd;

		if("選手検索".equals(btn)) {

			String id  = request.getParameter("player_id");
			int plid = Integer.valueOf(id);

			Player player = new Player();

			PlayerBean bean = player.getPlayer(plid);

			if(bean != null) {
				session.setAttribute("user_db", bean);
				rd = request.getRequestDispatcher("./PlayerServlet");
			} else {
				rd = request.getRequestDispatcher("./WorldCup/searchid.jsp");
			}
			rd.forward(request, response);

		} else if("国指定検索".equals(btn)) {

			session.removeAttribute("login_db");
			session.removeAttribute("user_db");
			response.sendRedirect("./WEB-sample13_14/login.jsp");
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