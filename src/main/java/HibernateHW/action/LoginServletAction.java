package HibernateHW.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import HibernateHW.model.Member;
import HibernateHW.model.MemberDao;
import HibernateHW.util.HibernateUtil;


/**
 * Servlet implementation class UserServletAction
 */
@WebServlet("/LoginServletAction.do")
public class LoginServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
//		String msg = String.format("帳號:%s, 密碼:%s", account,password);
//		out.write(msg);
		
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		MemberDao mdao=new MemberDao(session);
		if(mdao.checkUser(account, password)) {
			Member user=new Member(account, password);
			HttpSession session1 = request.getSession(true);
			session1.setAttribute("user", user);
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			out.write("登入成功");
		}else {
			request.getRequestDispatcher("/loginfailure.jsp").forward(request, response);
//			out.write("登入失敗");
		}
//		List<Member> lists=mdao.selectAll();
//		
//		for(Member mBean:lists) {
//			if((account.equals(mBean.getAccount()))&&(password.equals(mBean.getPassword())) ){
//				out.write("登入成功");
//			}else {
//				out.write("登入失敗");
//			}
//		}
		
		out.close();
	}

}
