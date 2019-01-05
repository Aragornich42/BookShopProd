package Server;

import java.util.regex.Pattern;

public class Book implements WorkWithBaseClasses {

	private int id;
	private String name;
	private String authors;
	private String genre;
		private String info;
	private String publisher;
	private int year;
	private int pages;
	private String cover;
	private String price;
	private String count;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Book() {
		id = 0;
		name = "";
		authors = "";
		genre = "";
			info = "";
		publisher = "";
		year = 0;
		pages = 0;
		cover = "";
		price = "";
		count = "";
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthors() {
		return authors;
	}
	
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getCount() {
		return count;
	}
	
	public void setCount(String count) {
		this.count = count;
	}
	//TODO: Когда освою json, надо будет изменить конструктор. Не исключено, что перегруженный конструктор не нужен.
	@Override
	public String[] Parser(String prsStr) {
		return prsStr.split(Pattern.quote("|"));
	}
	
	public Book(String prsStr) {
		String[] str = Parser(prsStr);
		name = str[0];
		authors = str[1];
		genre = str[2];
		info = str[3];
		price = str[4];
		count = str[5];
	}

	public String BookToString() {
		String[] inf = ParseInfo();
		return "id = " + id + ", \"" + name + "\"; " + authors + "; " + genre + "; " + inf[0] 
				+ ", "  + inf[1] + ", " + inf[2] + ", " + inf[3] + "; " + price + "; " 
				+ count + ".\n";
	}
	
	public String[] ParseInfo() {
		return info.split(Pattern.quote(","));
	}
	
}
