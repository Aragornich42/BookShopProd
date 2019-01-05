package Server;

import java.util.regex.Pattern;

public class Customer implements WorkWithBaseClasses {

	private int id;
	private String fullName;
		private String contacts;
	private  String region;
	private String house;
	private String flat;
	private String phone;
	private String email;
	private String orders;
	
	public Customer() {
		id = 0;
		fullName = "";
			contacts = "";
		region = "";
		house = "";
		flat = "";
		phone = "";
		email = "";
		orders = "";
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getContacts() {
		return contacts;
	}
	
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getFlat() {
		return flat;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getOrders() {
		return orders;
	}
	
	public void setOrders(String orders) {
		this.orders = orders;
	}
	//TODO:
	@Override
	public String[] Parser(String prsStr) {
		return prsStr.split(Pattern.quote("|"));
	}
	
	public Customer(String prsStr) {
		String[] str = Parser(prsStr);
		fullName = str[0];
		contacts = str[1];
		orders = str[2];
	}

	public String CustomerToString() {
		String[] conts = ParseContacts();
		return "id = " + id + ", " + fullName + "; " + conts[0] + ", " + conts[1] + ", " 
				+ conts[2] + "; " + orders + ".\n";
	}
	
	public String[] ParseContacts() {
		return contacts.split(Pattern.quote(";"));
	}
	
}
