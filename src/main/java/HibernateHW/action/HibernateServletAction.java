package HibernateHW.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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





@WebServlet("/HibernateServletAction.do")
public class HibernateServletAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		gotoSelectAll(request, response);

		if (request.getParameter("select") != null)
			gotoSelect(request, response);
		else if (request.getParameter("selectAll") != null)
			gotoSelectAll(request, response);
		else if (request.getParameter("delete") != null)
			gotoDelete(request, response);
		else if (request.getParameter("update") != null)
			gotoUpdate(request, response);
		else if (request.getParameter("insert") != null)
			gotoInsert(request, response);
		else if (request.getParameter("login") != null)
			gotoLogin(request, response);
	}

	private void gotoSelectAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		Query<Book> query = session.createQuery("from Book", Book.class);
		List<Book> lists = query.list();
		
		for(Book hBean:lists) {
			out.write("Book ID:" + hBean.getId() + "<br/>");
			out.write("Book Name:" + hBean.getBookname() + "<br/>");
			out.write("Book Author:" + hBean.getAuthor() + "<br/>");
			out.write("Book Price:" + hBean.getPrice() + "<br/>");
		}
		
		out.close();
	}
	

	private void gotoLogin(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
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
		 Book book =new Book();
		 book.setBookname(bookname);
		 book.setAuthor(author);
		 book.setPrice(Price);
		
		 try {
			 BookDao bDao = new BookDao(session);
			 bDao .insert(book);
			 System.out.println("success");
			 	 
		 }catch (Exception e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSessionFactory();
		}
		 
		 
	}

}
