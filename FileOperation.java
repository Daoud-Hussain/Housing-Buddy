import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileOperation{

    public void writeAFile(Plot s){
        try {
            File f = new File("Plot.ser");
            if(f.exists()){
                MyObjectOutputStream myObject = new MyObjectOutputStream(new FileOutputStream(f, true));
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
    public void readAFile(){
        try {
            ObjectInputStream redFile = new ObjectInputStream(new FileInputStream("Plot.ser"));
            try {
                while(true){
                    Plot s = (Plot) redFile.readObject();
                    System.out.println(s.toString());
                }
            }catch (ClassNotFoundException e) {
                System.out.println("Object not found");
            }catch(EOFException e){
                System.out.println("End of file");
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found ");
        }
        catch(IOException e){
            System.out.println("some error occured");
        }
    }

    

}