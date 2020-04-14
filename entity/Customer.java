package entity;

import java.lang.*;


public class Customer
{
	private String name;
	private String customerId;
	private String phoneNumber;
	
	public Customer(){}
	
	public Customer(String name, String customerId, String phoneNumber)
	{
		
		this.name=name;
		this.customerId=customerId;
		this.phoneNumber=phoneNumber;
		
		
	}
	
	public void setCustomerId(String customerId){this.customerId = customerId;}
	public void setName(String name){this.name = name;}
	public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}
	
	
	public String getCustomerId(){return customerId;}
	public String getName(){return name;}
	public String getPhoneNumber(){return phoneNumber;}
	
	
}
		