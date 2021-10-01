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
		else if (request.getParameter("delete") != null)
			gotoDelete(request, response);
		else if (request.getParameter("update") != null)
			gotoDisplayUpdateData(request, response);
		else if (request.getParameter("insert") != null)
			gotoInsert(request, response);
		else if (request.getParameter("update2") != null)
			gotoUpdate(request, response);
	}

	public void gotoSelect(HttpServletRequest request, HttpServletResponse response) {	
		
	}

	public void gotoDelete(HttpServletRequest request, HttpServletResponse response) {

	}

	public void gotoDisplayUpdateData(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 Session session = factory.getCurrentSession();
		 
		 int bookId;
		 
		 bookId =Integer.parseInt(request.getParameter("updateid"));
		 
		  BookDao bDao = new BookDao(session);
		  Book book = bDao.selectById(bookId);
		  if(book!=null) {
			  request.getSession(true).setAttribute("update", book);
			  
			  try {
				  request.getRequestDispatcher("/beforeUpdateData.jsp").forward(request, response);
			  } catch (ServletException e) {
				  e.printStackTrace();
			  } catch (IOException e) {
				  e.printStackTrace();
			  }
			  
		  }else {
			  try {
				response.sendRedirect("failUpdate.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		  
		 
	}
	
	public void gotoUpdate(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		 Session session = factory.getCurrentSession();
		 
		 int bookId;
		 String bookname;
		 String author;
		 int price;	
		 
		  bookId = Integer.parseInt(request.getParameter("bookId"));
		  bookname = request.getParameter("bookname").trim();
		  author= request.getParameter("author").trim();
		  price = Integer.parseInt(request.getParameter("price"));
		  
		  Book book = new Book();
		  book.setId(bookId);
		  book.setBookname(bookname);
		  book.setAuthor(author);
		  book.setPrice(price);		
		  
		  BookDao bDao= new BookDao(session);
		   Book updateBook = bDao.update(book);
		  if(updateBook!=null) {
			  request.getSession(true).setAttribute("updateBook", updateBook);
			  try {
				request.getRequestDispatcher("./afterUpdateData.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		  }
		  
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
