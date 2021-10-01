package HibernateHW.model;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity @Table(name = "book")
	public class Book {
		
		@Id @Column(name = "ID")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name = "BOOKNAME")
		private String bookname;
		
		@Column(name = "AUTHOR")
		private String author;
		
		@Column(name = "PRICE")
		private int price;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getBookname() {
			return bookname;
		}

		public void setBookname(String bookname) {
			this.bookname = bookname;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}
	
	
}
