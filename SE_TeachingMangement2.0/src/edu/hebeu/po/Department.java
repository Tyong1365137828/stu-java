package edu.hebeu.po;

public class Department {

	private String depnum;
	private String depnam;
	private String depaddress;
	private String deptel;
	
	public Department(String depnum, String depnam, String depaddress, String deptel) {
		super();
		this.depnum = depnum;
		this.depnam = depnam;
		this.depaddress = depaddress;
		this.deptel = deptel;
	}
	
	public Department() {
		super();
	}

	public String getDepnum() {
		return depnum;
	}

	public void setDepnum(String depnum) {
		this.depnum = depnum;
	}

	public String getDepnam() {
		return depnam;
	}

	public void setDepnam(String depnam) {
		this.depnam = depnam;
	}
	
	
	public String getDepaddress() {
		return depaddress;
	}

	public void setDepaddress(String depaddress) {
		this.depaddress = depaddress;
	}

	public String getDeptel() {
		return deptel;
	}

	public void setDeptel(String deptel) {
		this.deptel = deptel;
	}


}
