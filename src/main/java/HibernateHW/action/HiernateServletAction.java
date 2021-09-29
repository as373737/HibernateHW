package HibernateHW.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import HibernateHW.model.Book;
import HibernateHW.model.BookDao;
import HibernateHW.util.HibernateUtil;




@WebServlet("/HiernateServlet.do")
public class HiernateServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	

		if (request.getParameter("select") != null)
			gotoSelect(request, response);
		else if (request.getParameter("delete") != null)
			gotoDelete(request, response);
		else if (request.getParameter("update") != null)
			gotoUpdate(request, response);
		else if (request.getParameter("insert") != null)
			gotoInsert(request, response);
	}

	public void gotoSelect(HttpServletRequest request, HttpServletResponse response) {

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
		 Book saveBean =new Book(bookname,author,Price);
		 BookDao bDao= new BookDao(session);
		 request.getSession(true).setAttribute("select", saveBean);
		 try {
			 
			 factory = HibernateUtil.getSessionFactory();
			 session = factory.getCurrentSession();
			 System.out.println("QQ");
			saveBean.setBookname(bookname);
			saveBean.setAuthor(author);
			saveBean.setPrice(Price);
			bDao.insert(saveBean);
			 
			 
		 }catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		 
		 
	}

}
