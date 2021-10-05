package HibernateHW.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class UserServletAction
 */
@WebServlet("/LogoutServletAction.do")
public class LogoutServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);//����إ�Session
		Object data = session.getAttribute("user");
		if (data!= null) {
			session.removeAttribute("user");
			response.sendRedirect("./beforeloginhome.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession(true);//����إ�Session
//		Object data = session.getAttribute("user");
//		if (data!= null) {
//			session.removeAttribute("user");
//			response.sendRedirect("./home2.jsp");
//		}
	}
	

}
