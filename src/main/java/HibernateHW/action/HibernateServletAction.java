package HibernateHW.action;

import java.io.IOException;
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
		 

		if (request.getParameter("select") != null)
			gotoSelect(request, response);
		else if (request.getParameter("deleteByName") != null)
			gotoDeleteByName(request, response);
		else if (request.getParameter("deleteById") != null)
			gotoDeleteById(request, response);
		else if (request.getParameter("update") != null)
			gotoUpdate(request, response);
		else if (request.getParameter("insert") != null)
			gotoInsert(request, response);
	}

	public void gotoSelect(HttpServletRequest request, HttpServletResponse response) {	
		
	}

	public void gotoDeleteById(HttpServletRequest request, HttpServletResponse response) {		
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 Session session = factory.getCurrentSession();		 
		 int id = Integer.parseInt(request.getParameter("bookid").trim());
		 request.getSession(true).setAttribute("delete", id);		 
		
		 try {
			 BookDao bDao = new BookDao(session);
			 //開始山
			 bDao.deleteById(id);
			  
			 //刪掉session
			request.getSession(true).invalidate();
			request.getRequestDispatcher("/deleteSuccess.jsp").forward(request, response);
		 }catch (Exception e) {
			e.printStackTrace();
		}finally {
//			HibernateUtil.closeSessionFactory();   先不關 不然不能回首頁
		}
	}
	
	public void gotoDeleteByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		BookDao bDao = new BookDao(session);
		String bookname = request.getParameter("bookname");
		System.out.println("準備開始執行Delete By Name方法");
		List<Book> resultBean = bDao.deleteByName(bookname);
		System.out.println("執行完畢");
		request.getSession(true).setAttribute("resultBean", resultBean);
		request.getRequestDispatcher("/deleteSuccess.jsp").forward(request, response);
	}

	public void gotoUpdate(HttpServletRequest request, HttpServletResponse response) {

	}

	public void gotoInsert(HttpServletRequest request, HttpServletResponse response) {
		 response.setContentType("text/html;charset=UTF-8");

		 System.out.println("開始新增資料");
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
