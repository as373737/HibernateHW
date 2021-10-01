package HibernateHW.model;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import HibernateHW.util.HibernateUtil;





public class BookDao implements IBookDao {
	private Session session ;
	public BookDao(Session session) {
        this.session = session;
	}
	
	@Override
	public Book insert(Book book) {
	
	System.out.println("book = "+book.getBookname());

		Book bBean = new Book();
		bBean.setBookname(book.getBookname());
		bBean.setAuthor(book.getAuthor());
		bBean.setPrice(book.getPrice());
		session.save(bBean);
		session.getTransaction().commit();

		
		return book;	
		
	}

	@Override
	public List<Book> selectAll() {
		Query<Book> query = session.createQuery("from Book", Book.class);
		return query.list();
	}

	@Override
	public List<Book> selectLikeName(String name) {
		Query<Book> query = session.createQuery("from Book where bookname like '%"+name+"%'", Book.class);
		return query.list();
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
