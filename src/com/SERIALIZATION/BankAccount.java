package com.SERIALIZATION;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * note : whenever we serialize an object jvm creates an unique serial version id for it
 *  	  and save it alongside the persisted object. When we deserialize it looks for the 
 *  	  same class definition and again calculate the serial version id and matches it with 
 *  	  the serial version id of the persisted object. If matches true then it returns the object
 *  	  which has exactly the same state as object persisted.
 *       
 *        But if we change the class definition after persisting the object then while deserializing
 *        it will throw a class not found exception as the calculated serial version ID won't match with
 *        that of saved object since the code as changed.
 *        
 *        Thats why its better to have a generated serial version ID added explicitly to the Class definition
 *        so that any changes will not affect the deserialization. However if we add any instance variable after 
 *        persisting the object it will be assign default values sa they were not present in the saved object. 
 *        Similar is the case if a instance variable is deleted.
 *        
 * @author eccspro
 *
 */


public class BankAccount implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4630613433976670298L;
	private int amount;
	private String id;
	private String accountType ="salary";
	
	public BankAccount() {
		
	}
	
	public BankAccount(String id, int amount) {
		this.id = id;
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public synchronized void deposit(int amount) {
		this.amount += amount;
		accountType = "saving";
	}
	
	public synchronized int withdraw(int amount) {
		this.amount -= amount;
		
		return amount;
	}
	
	
	
	@Override
	public String toString() {
		return "BankAccount [amount=" + amount + ", id=" + id + ", accountType="+ accountType + "]";
	}

	public static void saveAccount(BankAccount acc, String filename) {
		
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)));
			objectOutputStream.writeObject(acc);
			
		}
		catch(IOException e) {
			System.out.println("File not found");
		}
		catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public static BankAccount loadAccount(String filename) {
		BankAccount ba = null;
		try {
			ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(filename)));
			ba = (BankAccount) in.readObject();
		}
		catch(IOException e) {
			System.out.println("Invalid file path");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Invalid class name");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ba;
	}
	
	public static void main(String[] args) {
		//BankAccount ba = new BankAccount("john", 13516);
		//saveAccount(ba, "rai.txt");
		
		BankAccount ba2 = loadAccount("rai.txt");
		System.out.println(ba2);
	}
}
