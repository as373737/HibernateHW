package HibernateHW.model;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import HibernateHW.util.HibernateUtil;





public class BookDao implements IBookDao {
	private Session session ;
	public BookDao(Session session) {
        this.session = session;
	}
	
	@Override
	public Book insert(Book book) {
	
	System.out.println("book = "+book.getBookname());
	try {
		Book bBean = new Book();
		bBean.setBookname(book.getBookname());
		bBean.setAuthor(book.getAuthor());
		bBean.setPrice(book.getPrice());
		session.save(bBean);
		session.getTransaction().commit();
		}catch (Exception e) {
		session.getTransaction().rollback();
		System.out.println("有錯");
	}finally {
//		HibernateUtil.closeSessionFactory();
	}
		
		
		return null;	
		
	}

	@Override
	public Book selectById(int bookid) {
		
		
		return null;
	}

	@Override
	public List<Book> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book update(int bookid, String bookname, int price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int bookid) {
		// TODO Auto-generated method stub
		return false;
	}

}
