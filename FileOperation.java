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
            File f = new File("Residential.txt");
            if(f.exists()){
                myObjectOutputStream myObject = new myObjectOutputStream(new FileOutputStream(f, true));
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
            File f = new File("Commercial.txt");
            if(f.exists()){
                myObjectOutputStream myObject = new myObjectOutputStream(new FileOutputStream(f, true));
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
        String str = "";
        System.out.println();
        System.out.println("RESIDENTIAL PLOT RECORDS");
        try {
            ObjectInputStream redFile = new ObjectInputStream(new FileInputStream("Residential.txt"));
            try {
                while(true){
                    ResidentialPlot s = (ResidentialPlot) redFile.readObject();
                    str += s.toString();

                }
            }catch (ClassNotFoundException e) {
                System.out.println("Targetted class not found!!");
            }catch(EOFException e){
                redFile.close();
                System.out.println("Reached End of file!!");
            }
        }catch(FileNotFoundException e){
            System.out.println("No Such Record found!! ");
        }
        catch(IOException e){
            System.out.println("Any Input/Output Exception occured!!");
        }

        System.out.println("\n");

        new Details(str);

    }

    //Read/View a commercial plot file
    public void viewACommercialPlot(){
        System.out.println();
        System.out.println("COMMERCIAL PLOT RECORDS");
        String str = "";

        try {
            ObjectInputStream redFile = new ObjectInputStream(new FileInputStream("Commercial.txt"));
            try {
                while(true){
                    CommercialPlot s = (CommercialPlot) redFile.readObject();
                    str += s.toString();
                }
            }catch (ClassNotFoundException e) {
                System.out.println("Targetted class not found!!");
            }catch(EOFException e){
                redFile.close();
                System.out.println("End of file");
            }
        }catch(FileNotFoundException e){
            System.out.println("No such record exists!! ");
        }
        catch(IOException e){
            System.out.println("Input Output Exception");
        }

        new Details(str);

    }


    public boolean UpdateResidentialPlot(String oldOwner, String newOwner, int price) {
        boolean flag = false;
        ArrayList<ResidentialPlot> list = new ArrayList<ResidentialPlot>();
        try{
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Residential.txt"));
            try {
                while(true){
                    ResidentialPlot s = (ResidentialPlot) obj.readObject();
                    if(s.getOwner().equals(oldOwner)){
                        s.setOwner(newOwner);
                        s.setPrice(price);
                        flag = true;
                    }
                    list.add(s);
                }
            }
            catch(FileNotFoundException e){
                System.out.println("The targetted file is not found!!\n");
            }
            catch(EOFException e){
                obj.close();
            }
            catch(IOException e){
                System.out.println("Input Output Exception\n");
            }
            catch(ClassNotFoundException e){
                System.out.println("Sorry! the targetted class is not found\n");
            }
            
            try {
                File f = new File("Residential.txt");
                f.delete();
                
                if(f.exists()){
                    System.out.println("File");
                }else{
                    System.out.println("File didn't found");
                }

                int sizelist = list.size();
                for(int i = 0; i<sizelist; i++){
                    addAResidentialPlot(list.remove(0));
                }
            }
            catch (Exception e) {
                System.out.println("Some error occured");
            }

        }
        catch(IOException e){
            System.out.print("Any error while working!!!");
        }
        return flag;

    }

    public boolean UpdateCommercialPlot(String oldOwner, String newOwner, int price) {
        boolean flag = false;
        ArrayList<CommercialPlot> list = new ArrayList<CommercialPlot>();
        try{
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Commercial.txt"));
            try {
                while(true){
                    CommercialPlot s = (CommercialPlot) obj.readObject();
                    if(s.getOwner().equals(oldOwner)){
                        s.setOwner(newOwner);
                        s.setPrice(price);
                        flag = true;
                    }
                    list.add(s);
                }
            }
            catch(FileNotFoundException e){
                System.out.println("The targetted file is not found!!\n");
            }
            catch(EOFException e){
                obj.close();
            }
            catch(IOException e){
                System.out.println("Input Output Exception\n");
            }
            catch(ClassNotFoundException e){
                System.out.println("Sorry! the targetted class is not found\n");
            }
            
            try {
                File f = new File("Commercial.txt");
                f.delete();
                
                if(f.exists()){
                    System.out.println("File");
                }else{
                    System.out.println("File didn't found");
                }

                int sizelist = list.size();
                for(int i = 0; i<sizelist; i++){
                    addACommercialPlot(list.remove(0));
                }
            }
            catch (Exception e) {
                System.out.println("Some error occured");
            }

        }
        catch(IOException e){
            System.out.print("Any error while working!!!");
        }
        return flag;

    }

     public void deleteAResidentialPlot(String name){

         ArrayList<ResidentialPlot> list = new ArrayList<ResidentialPlot>();
         boolean flag = false;
        try{
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Residential.txt"));
            try {
                while(true){
                    ResidentialPlot s = (ResidentialPlot) obj.readObject();
                    if(s.getOwner().equals(name)){
                        flag = true;
                    }else{
                        list.add(s);
                    }
                }
            }
            catch(SecurityException e){
                System.out.println("Security Exception");
            }
            catch(FileNotFoundException e){
                System.out.println("File not found");
            }
            catch(EOFException e){
                obj.close();
                System.out.println("End of file");
            }
            catch(IOException e){
                System.out.println("Io exception");
            }
            catch (Exception e) {
                System.out.println("Some error occured");
            }

            try {
                File f = new File("Residential.txt");
                f.delete();
                int sizeList = list.size();
                for(int i = 0; i<sizeList; i++){
                    addAResidentialPlot(list.remove(0));
                }
            }catch(SecurityException e){
                System.out.println("Security");
            }catch (Exception e) {
                System.out.println("Some error occured");
            }
            if(flag){
                System.out.println("Removed record successfully ");
            }else{
                System.out.println("Couldn't remove the record!");
            }
        }
        catch(IOException e){
            System.out.print("Any random error occured");
        }
    }


    public void deleteACommercialPlot(String name){

         ArrayList<CommercialPlot> list = new ArrayList<CommercialPlot>();
         boolean flag = false;
        try{
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Commercial.txt"));
            try {
                while(true){
                    CommercialPlot s = (CommercialPlot) obj.readObject();
                    if(s.getOwner().equals(name)){
                        flag = true;
                    }else{
                        list.add(s);
                    }
                }
            }
            catch(SecurityException e){
                System.out.println("Security Exception");
            }
            catch(FileNotFoundException e){
                System.out.println("File not found");
            }
            catch(EOFException e){
                obj.close();
                System.out.println("End of file");
            }
            catch(IOException e){
                System.out.println("Io exception");
            }
            catch (Exception e) {
                System.out.println("Some error occured");
            }

            try {
                File f = new File("Commercial.txt");
                f.delete();
                int sizeList = list.size();
                for(int i = 0; i<sizeList; i++){
                    addACommercialPlot(list.remove(0));
                }
            }catch(SecurityException e){
                System.out.println("Security Exception");
            }catch (Exception e) {
                System.out.println("Some error occured");
            }
            if(flag){
                System.out.println("Removed record successfully ");
            }else{
                System.out.println("Couldn't remove the record!");
            }
        }
        catch(IOException e){
            System.out.print("Any random error occured");
        }
    }
}