package tang.subject;

class Classes {
	private double r;
	
	/*һ��1
	public Classes(double r) { 
	super(); 
	this.r = r;
 	}
	*/
	 
	/*һ��2
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
		System.out.println("�����:"+3.14159*r*r);
	}

	public void zhouchang() {
		System.out.println("�ܳ�Ϊ:"+2*3.14159*r);
	}
}
