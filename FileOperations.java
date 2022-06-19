import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class FileOperations{





    public void writeToFile(Admin s){
        try {
            File f = new File("Admin.txt");
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

    





    public void readFromFile(){
        try {
            ObjectInputStream redFile = new ObjectInputStream(new FileInputStream("Admin.txt"));
            try {
                while(true){
                    Admin s = (Admin) redFile.readObject();
                    System.out.println(s.getName());
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
    }






    public String searchByName(String name){
        String str = "";
        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Admin.txt"));
            try {
                while(true){
                    Admin s = (Admin) obj.readObject();
                    if(s.getName().equals(name)){
                        str  += "\n"+s.toString();
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
        return str==""? "NOT found": str;
    }







    public String removeByName(String name){

        ArrayList<Admin> list = new ArrayList<Admin>();
        boolean flag = false;
        try{
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Admin.txt"));
            try {
                while(true){
                    Admin s = (Admin) obj.readObject();
                    if(name.equals(s.getName())){
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

            try {
                File f = new File("Admin.txt");
                f.delete();
                int loopcount = list.size();
                for(int i = 0; i<loopcount; i++){
                    writeToFile(list.remove(0));
                }
            }catch(SecurityException e){
                System.out.println("Security");
            }catch (Exception e) {
                System.out.println("Some error occured while removing by name : "+e.getMessage());
            }
        }catch (IOException e){
            System.out.println("Some file error occured");
        }
        return flag? "Removed successfully!" : "Cannot found";
    }






    public boolean readPasswordsAndValidate(String id , String password){
        try {
            ObjectInputStream redFile = new ObjectInputStream(new FileInputStream("IdAndPasswords.txt"));
            try {
                while(true){
                    IDAndPassword s = (IDAndPassword) redFile.readObject();
                    if(s.getId().equals(id)){
                        if(s.getPassword().equals(password)){
                            redFile.close();
                            return true;
                        }
                    }
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
            System.out.println("some error occured : "+e.getMessage());
        }
        return false;
    }





    public boolean isAdmin(String id, String password){
        try {
            ObjectInputStream redFile = new ObjectInputStream(new FileInputStream("IdAndPasswords.txt"));
            try {
                while(true){
                    IDAndPassword s = (IDAndPassword) redFile.readObject();
                    if(s.getId().equals(id)){
                        if(s.getPassword().equals(password)){
                            if(s.getRole().equals("admin")){
                                redFile.close();
                                return true;
                            }
                        }
                    }
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
            System.out.println("some error occured in admin reading : "+e.getMessage());
        }
        return false;
    }





    void writePasswordsAndUserNames(IDAndPassword s){
        try {
            File f = new File("IdAndPasswords.txt");
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


    String updatePasswords(String email, IDAndPassword d){
        ArrayList<IDAndPassword> list = new ArrayList<IDAndPassword>();
        boolean flag = false;
        try{

            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("IdAndPasswords.txt"));
            try {
                while(true){
                    IDAndPassword s = (IDAndPassword) obj.readObject();
                    if(s.getId().equals(email)){
                        s = d;
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
                File f = new File("IdAndPasswords.txt");
                f.delete();
                int loopsize = list.size();
                for(int i = 0; i<loopsize; i++){
                    writePasswordsAndUserNames(list.remove(0));
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