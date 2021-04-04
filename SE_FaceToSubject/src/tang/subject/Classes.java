package tang.subject;

class Classes {
	private double r;
	
	/*一法1
	public Classes(double r) { 
	super(); 
	this.r = r;
 	}
	*/
	 
	/*一法2
 	public Classes() {
		public double getR() {
			return r;
		}

		public void setR(double r) {
			this.r = r;
		}
	}
	*/
	
	public void area(){
		System.out.println("面积是:"+3.14159*r*r);
	}

	public void zhouchang() {
		System.out.println("周长为:"+2*3.14159*r);
	}
}
