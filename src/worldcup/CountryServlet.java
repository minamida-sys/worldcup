package worldcup;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountryServlet
 */
@WebServlet("/CountryServlet")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ
     */
    public CountryServlet() {
        super();
    }

	/**
	 * Getで呼ばれたとき
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Postで呼ばれたとき
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String id  = request.getParameter("country_id");
		int coid = Integer.valueOf(id);

		Country country = new Country();
		ArrayList<PlayerBean> playerList = country.getCountry(coid);

		request.setAttribute("playerList", playerList);


		RequestDispatcher rd = request.getRequestDispatcher("./WorldCup/country_result.jsp");
		rd.forward(request, response);
	}

}
