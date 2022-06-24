import java.io.Serializable;

public class Person implements Serializable{
	private String name;
	private Address address;
	private String phoneNo;
	private String email;

    public Person(){
        address = new Address();
    }
	public Person(String name, Address address, String phoneNo, String email){
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.email = email;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setAddress(Address address){
		this.address = address;
	}
	
	public void setPhoneNO(String phoneNo){
		this.phoneNo = phoneNo;
	}

	public void setEmail(String email){
		this.email= email;
	}

	public String getName(){
		return name;
	}

	public Address getAddress(){
		return address;
	}

	public String getPhoneNo(){
		return phoneNo;
	}

	public String getEmail(){
		return email;
	}

    public String toString(){
        return "\nFull name : "+name+"\nAddress : "+address.toString()+"\nPhone no : "+phoneNo+"\nEmail : "+email + "\n\n";
    }
}
