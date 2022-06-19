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

    //Add/Write a residential plot
    public void addAResidentialPlot(ResidentialPlot rp){
        try {
            File f = new File("Residential.ser");
            if(f.exists()){
                MyObjectOutputStream myObject = new MyObjectOutputStream(new FileOutputStream(f, true));
                myObject.writeObject(rp);
                myObject.close();
            }else{
                ObjectOutputStream myObject = new ObjectOutputStream(new FileOutputStream(f));
                myObject.writeObject(rp);
                myObject.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Add/Write a commercial plot file
    public void addACommercialPlot(CommercialPlot cp){
        try {
            File f = new File("Commercial.ser");
            if(f.exists()){
                MyObjectOutputStream myObject = new MyObjectOutputStream(new FileOutputStream(f, true));
                myObject.writeObject(cp);
                myObject.close();
            }else{
                ObjectOutputStream myObject = new ObjectOutputStream(new FileOutputStream(f));
                myObject.writeObject(cp);
                myObject.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Read/View a residential plot file
    public void viewAResidentialPlot(){
        try {
            ObjectInputStream redFile = new ObjectInputStream(new FileInputStream("Residential.ser"));
            try {
                while(true){
                    ResidentialPlot s = (ResidentialPlot) redFile.readObject();
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

    //Read/View a commercial plot file
    public void viewACommercialPlot(){
        try {
            ObjectInputStream redFile = new ObjectInputStream(new FileInputStream("Commercial.ser"));
            try {
                while(true){
                    CommercialPlot s = (CommercialPlot) redFile.readObject();
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