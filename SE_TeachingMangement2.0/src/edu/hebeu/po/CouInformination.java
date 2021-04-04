package edu.hebeu.po;

public class CouInformination {

	private String couid;
	private String coures;
	private String period;
	private String place;
	private String test;
	private String tea_id;
	
	public CouInformination(String couid, String coures, String period, String place, String test, String tea_id) {
		super();
		this.couid = couid;
		this.coures = coures;
		this.period = period;
		this.place = place;
		this.test = test;
		this.tea_id = tea_id;
	}

	public CouInformination() {
		super();
	}

	public String getCouid() {
		return couid;
	}

	public void setCouid(String couid) {
		this.couid = couid;
	}

	public String getCoures() {
		return coures;
	}

	public void setCoures(String coures) {
		this.coures = coures;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getTea_id() {
		return tea_id;
	}

	public void setTea_id(String tea_id) {
		this.tea_id = tea_id;
	}

}
