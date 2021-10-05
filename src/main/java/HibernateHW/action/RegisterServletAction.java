package HibernateHW.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import HibernateHW.model.Member;
import HibernateHW.model.MemberDao;
import HibernateHW.util.HibernateUtil;


/**
 * Servlet implementation class UserServletAction
 */
@WebServlet("/RegisterServletAction.do")
public class RegisterServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String account = request.getParameter("account");
		String password = request.getParameter("password2");
		String emailAddress = request.getParameter("emailAddress");
		String phone = request.getParameter("phone");
		String status = "一般會員";
//		String msg = String.format("名稱:%s,帳號:%s, 密碼:%s,信箱:%s,電話:%s,狀態:%s",username,account,password,emailAddress,phone,status);
//		out.write(msg);
		
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		MemberDao mdao=new MemberDao(session);
		if(mdao.checkAccount(account)) {
			request.getRequestDispatcher("/registerfailure.jsp").forward(request, response);
//			out.write("帳號重複");
		}else {
			Member mber=new Member(username,account,password,emailAddress,phone,status);
			mdao.insert(mber);
			request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
		}
//		Query<Member> query = session.createQuery("from Member", Member.class);
//		List<Member> lists = query.list();
		
//		for(Member mBean:lists) {
//			if((account.equals(mBean.getAccount()))&&(password.equals(mBean.getPassword())) ){
//				out.write("登入成功");
//			}else {
//				out.write("登入失敗");
//			}
//			out.write("House ID:" + mBean.getUserid() + "<br/>");
//			out.write("House Name:" + mBean.getUsername() + "<br/>");
//		}
		
//		out.close();
	}

}
