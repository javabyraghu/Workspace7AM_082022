package com.app.raghu;

public class Employee {

	private String name;
	
	private Project pob;
	
	public Employee() {
		super();
		System.out.println("EMPLOYEE OBJ");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project getPob() {
		return pob;
	}

	public void setPob(Project pob) {
		this.pob = pob;
		System.out.println("EMPLOYEE.setProject ");
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", pob=" + pob + "]";
	}

	
	
}
