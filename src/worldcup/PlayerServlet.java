package worldcup;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PlayerServlet")
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PlayerServlet() {
        super();
    }

	/**
	 * Get
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Post
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Player player = new Player();

		HttpSession session = request.getSession();
		String id  = request.getParameter("player_id");
		int plid = Integer.valueOf(id);

		PlayerBean pl = player.getPlayer(plid);

		session.setAttribute("user_db", pl);

		RequestDispatcher rd = request.getRequestDispatcher("./WorldCup/player_result.jsp");
		rd.forward(request, response);
	}

}
