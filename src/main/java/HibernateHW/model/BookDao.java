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
	public Book selectById(int bookid) {
		
		return session.get(Book.class, bookid);
		
	}

	@Override
	public List<Book> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book update(Book book) {
		
		
		String hql="update Book set bookname=:bname,author=:bauthor,price=:bprice where id=:bid";

		Query query = session.createQuery(hql);
		query.setParameter("bname", book.getBookname());
		query.setParameter("bauthor", book.getAuthor());
		query.setParameter("bprice", book.getPrice());
		query.setParameter("bid", book.getId());
		
		int count = query.executeUpdate();
		if(count>0) {
			return book;
		}
			return null;
		
		
	}

	@Override
	public boolean deleteById(int bookid) {
		// TODO Auto-generated method stub
		return false;
	}

}
