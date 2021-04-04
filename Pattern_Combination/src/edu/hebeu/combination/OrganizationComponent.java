package edu.hebeu.combination;

/*
 *  这个类相当于Component类，用来存放和抽取叶子节点和非叶子节点的共性
 */
public abstract class OrganizationComponent {
	
	private String name; // 名字
	private String desc; // 描述
	
	public OrganizationComponent(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	protected void add(OrganizationComponent organizationComponent) {
		/*默认实现该方法，因为Department类是不会有add()方法的，所有在这里进行默认实现，让需要用
		 * 到这个方法的类去重新，不需要的就不用关注
		 */
		new UnsupportedOperationException(); // 抛出一个不支持操作的异常
	}
	
	protected void remove(OrganizationComponent organizationComponent) {
		/*默认实现该方法，因为Department类是不会有remove()方法的，所有在这里进行默认实现，让需要
		 * 用到这个方法的类去重新，不需要的就不用关注
		 */
		new UnsupportedOperationException(); // 抛出一个不支持操作的异常		
	}
	
	/**
	 * 将这个方法做成抽象的，因为所有的类都有这个方法去打印信息，所以将这个方法定义为抽象的，让
	 * 相应的子类去实现该方法
	 */
	protected abstract void print();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
