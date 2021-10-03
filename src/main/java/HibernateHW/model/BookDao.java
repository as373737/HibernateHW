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
	public boolean deleteById(int id,String bookname) {
		// 刪除
		
		
		//用ID刪
		System.out.println("ID = "+id);
		
//			Book bBean = new Book();
//			bBean.setId(id);
//			
//	
//			session.delete(bBean);
//			session.getTransaction().commit();
			
			
			//=============================================用名子刪
			System.out.println("ID = "+id);
			System.out.println("bookname = "+bookname);
			
			Book book=session.get(Book.class, bookname);
			if(book!=null){
				System.out.println("=====查找結果 : "+book.getId()+" : "+book.getBookname());		
			} else {
				System.out.println("No result");
			}
			

			
			
//			Book bBean2 = new Book();
//			bBean2.setBookname(bookname);
//			session.get("bookname", bookname);
//			System.out.println("bookname = "+bookname);
//	
//			session.delete(bBean);
			session.getTransaction().commit();
			
		return true;
	}

}
