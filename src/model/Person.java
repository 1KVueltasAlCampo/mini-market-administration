package model;

public class Person {
	private IDType type;
	private String idNumber;
	
	public Person(int typeIndicator,String idNumber) {
		type = IDType.values()[typeIndicator-1];
		this.idNumber = idNumber;
	}
	
	public String getType() {
		return type.toString();
	}
	
	public String getIdNumber() {
		return idNumber;
	}
}
