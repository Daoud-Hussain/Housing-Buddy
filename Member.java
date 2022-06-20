import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;

public class Member extends Person{
    String password;

    public Member() {
    }

    public Member(String name, Address address, String phoneNo, String email, String password){
        super(name, address, phoneNo, email);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

}