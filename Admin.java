import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Admin extends Person {
    private String password;

    public Admin() {
    }

    public Admin(String name, Address address, String phoneNo, String email,String pasword){
        super(name, address, phoneNo, email);
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void addMemberRecord(Member s){
        



        
        try {
            File f = new File("Members.txt");
            if(f.exists()){
                myObjectOutputStream myObject = new myObjectOutputStream(new FileOutputStream(f, true));
                myObject.writeObject(s);
                myObject.close();
            }else{
                ObjectOutputStream myObject = new ObjectOutputStream(new FileOutputStream(f));
                myObject.writeObject(s);
                myObject.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    public ArrayList<Member> checkAllRecords(){
        ArrayList<Member> list = new ArrayList<Member>();
        try {
            ObjectInputStream redFile = new ObjectInputStream(new FileInputStream("Members.txt"));
            try {
                while(true){
                    Member s = (Member) redFile.readObject();
                    System.out.println(s.getName());
                    list.add(s);
                }
            }catch (ClassNotFoundException e) {
                System.out.println("Object not found");
            }catch(EOFException e){
                redFile.close();
                System.out.println("End of file");
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found ");
        }
        catch(IOException e){
            System.out.println("some error occured while reading "+ e.getMessage());
        }
        return list;
    }





    public String deleteRecordByEmail(String email){
        ArrayList<Member> list = new ArrayList<Member>();
        boolean flag = false;
        try{
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Members.txt"));
            try {
                while(true){
                    Member s = (Member) obj.readObject();
                    
                    if(email.equals(s.getEmail())){
                        flag = true;
                    }else{
                        list.add(s);
                    }
                }
            }catch(SecurityException e){
                System.out.println("Security 1");
            }catch(FileNotFoundException e){
                System.out.println("File not found 1");
            }catch(EOFException e){
                obj.close();
                System.out.println("End of file 1");
            }catch(IOException e){
                System.out.println("Io exception 1");
            }catch (Exception e) {
                System.out.println("Some error occured 1");
            }
        }catch (IOException e){
            System.out.println("Some file error occured");
        }
        
        try {
            File f = new File("Members.txt");
            f.delete();
            int loopcount = list.size();
            for(int i = 0; i<loopcount; i++){
                addMemberRecord(list.remove(0));
            }
        }catch(SecurityException e){
            System.out.println("Security");
        }catch (Exception e) {
            System.out.println("Some error occured while removing by name : "+e.getMessage());
        }
    
        return flag? "Removed successfully!" : "Cannot found";
    }





    public Member searchRecordByEmail(String email){
        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Members.txt"));
            try {
                while(true){
                    Member s = (Member) obj.readObject();
                    if(s.getEmail().equals(email)){
                        obj.close();
                        return s;
                    }
                }
            }catch (ClassNotFoundException e) {
                System.out.println("Object not found");
            }catch(EOFException e){
                obj.close();
                System.out.println("End of file");
            }catch(IOException e){
                System.out.println("End of file");
            }
        }catch (IOException e) {
            System.out.println("Some I/O error occured");
        }catch(Exception e){
            System.out.println("Some error occured");
        }
        return null;
    }






    public String updateMemberRecord(String email, Member ms){
        ArrayList<Member> list = new ArrayList<Member>();
        boolean flag = false;
        try{

            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Members.txt"));
            try {
                while(true){
                    Member s = (Member) obj.readObject();
                    if(s.getEmail().equals(email)){
                        s = ms;
                        flag = true;
                    }
                    list.add(s);
                }
            }catch(FileNotFoundException e){
                System.out.println("File not found");
            }catch(ClassNotFoundException e){
                System.out.println("Object not found");
            }catch(EOFException e){
                obj.close();
                System.out.println("End of file");
            }catch (Exception e) {
                System.out.println("Some error occured");
                e.printStackTrace();
            }
            
            try {
                File f = new File("Members.txt");
                f.delete();
                int loopsize = list.size();
                for(int i = 0; i<loopsize; i++){
                    addMemberRecord(list.remove(0));
                }

            }catch(SecurityException e){
                System.out.println("Security");
            }catch (Exception e) {
                System.out.println("S0me error occured + ");
                e.printStackTrace();
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found Exception");
        }catch(EOFException e){
            System.out.println("End of file Exception");
        }catch(IOException e){
            System.out.println("File I/O Exception");
        }catch(Exception e){
            System.out.println("SOme error occured "+e.getMessage());
        }
        return flag ? "Udpated seccessfully" : "Cannot update";
    }

}
