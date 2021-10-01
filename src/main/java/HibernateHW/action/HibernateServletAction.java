package HibernateHW.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import HibernateHW.model.Book;
import HibernateHW.model.BookDao;
import HibernateHW.util.HibernateUtil;




@WebServlet("/HibernateServletAction.do")
public class HibernateServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 

		if (request.getParameter("select") != null)
			gotoSelect(request, response);
		else if (request.getParameter("selectALL")!=null)
			gotoSelectAll(request,response);
		else if (request.getParameter("delete") != null)
			gotoDelete(request, response);
		else if (request.getParameter("update") != null)
			gotoUpdate(request, response);
		else if (request.getParameter("insert") != null)
			gotoInsert(request, response);
	}

	public void gotoSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		BookDao bDao = new BookDao(session);
		String bookname = request.getParameter("bookname");
		List<Book> resultBean = bDao.selectLikeName(bookname);
		request.getSession(true).setAttribute("resultBean", resultBean);
		request.getRequestDispatcher("/select.jsp").forward(request, response);
	}
	
	public void gotoSelectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		BookDao bDao = new BookDao(session);
		List<Book> resultList = bDao.selectAll();
		request.getSession(true).setAttribute("resultList", resultList);
		request.getRequestDispatcher("/select.jsp").forward(request, response);
	}


	public void gotoDelete(HttpServletRequest request, HttpServletResponse response) {

	}

	public void gotoUpdate(HttpServletRequest request, HttpServletResponse response) {

	}

	public void gotoInsert(HttpServletRequest request, HttpServletResponse response) {
		 response.setContentType("text/html;charset=UTF-8");

		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 Session session = factory.getCurrentSession();
		 String bookname;
		 String author;
		 String price;	
		 bookname = request.getParameter("bookname").trim();
		 author = request.getParameter("author").trim();
		 price = request.getParameter("price").trim();
		 
	
		 int Price = Integer.parseInt(price);
		 Book book =new Book();
		 book.setBookname(bookname);
		 book.setAuthor(author);
		 book.setPrice(Price);
		 request.getSession(true).setAttribute("select", book);
		 try {
			 BookDao bDao = new BookDao(session);
			 bDao .insert(book);
			 System.out.println("success");
			 
			request.getSession(true).invalidate();
			request.getRequestDispatcher("/insertsuccess.jsp").forward(request, response);
		 
		 }catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		 
		 
	}

}
