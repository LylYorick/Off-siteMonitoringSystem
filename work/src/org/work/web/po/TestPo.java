/**
 * 
 */
package org.work.web.po;

@SuppressWarnings("serial")
public class TestPo implements java.io.Serializable{

	private String name;
	private String title;
	private String age;
	private String company;
	private String address;
	private String tel;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @param name
	 * @param title
	 * @param age
	 * @param company
	 * @param address
	 * @param tel
	 * @param email
	 */
	public TestPo(String name, String title, String age, String company,
			String address, String tel, String email) {
		this.name = name;
		this.title = title;
		this.age = age;
		this.company = company;
		this.address = address;
		this.tel = tel;
		this.email = email;
	}
	/**
	 * 
	 */
	public TestPo() {
		
	}
	
}
