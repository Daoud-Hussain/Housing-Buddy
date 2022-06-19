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


    // String searchPlotsByOwnerName(String name){
    //     String str = "";
    //     try {
    //         ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Plots.txt"));
    //         try {
    //             while(true){
    //                 Plots s = (Plots) obj.readObject();
    //                 if(s.getName().equals(name)){
    //                     str  += "\n"+s.toString();
    //                 }
    //             }
    //         }catch (ClassNotFoundException e) {
    //             System.out.println("Object not found");
    //         }catch(EOFException e){
    //             obj.close();
    //             System.out.println("End of file");
    //         }catch(IOException e){
    //             System.out.println("End of file");
    //         }
    //     }catch (IOException e) {
    //         System.out.println("Some I/O error occured");
    //     }catch(Exception e){
    //         System.out.println("Some error occured");
    //     }
    //     return str==""? "NOT found": str;
    // }







    // String checkAvailablePlots(){
    //     String str = "";
    //     try {
    //         ObjectInputStream redFile = new ObjectInputStream(new FileInputStream("Plots.txt"));
    //         try {
    //             while(true){
    //                 Plot s = (Plots) redFile.readObject();
    //                 if(s.getStatus().equals("unsold")){
    //                     str += s.toString();
    //                 }
                    
    //             }
    //         }catch (ClassNotFoundException e) {
    //             System.out.println("Object not found");
    //         }catch(EOFException e){
    //             redFile.close();
    //             System.out.println("End of file");
    //         }
    //     }catch(FileNotFoundException e){
    //         System.out.println("File not found ");
    //     }
    //     catch(IOException e){
    //         System.out.println("some error occured while reading "+ e.getMessage());
    //     }
    //     return str;
    // }



}