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
            File f = new File("Commercial.txt");
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
            ObjectInputStream redFile = new ObjectInputStream(new FileInputStream("Residential.txt"));
            try {
                while(true){
                    ResidentialPlot s = (ResidentialPlot) redFile.readObject();
                    System.out.println("\n\n"+s.toString());
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
        System.out.println();
    }

    //Read/View a commercial plot file
    public void viewACommercialPlot(){
        try {
            ObjectInputStream redFile = new ObjectInputStream(new FileInputStream("Commercial.txt"));
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
        System.out.println();
    }


    public boolean UpdateResidentialPlot(String oldOwner, String newOwner, int price) {
        ArrayList<ResidentialPlot> list = new ArrayList<ResidentialPlot>();
        boolean flag = false;
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
                System.out.println("Sorry! the targetted file is not found\n");
            }
            catch(EOFException e){
                System.out.println("End of file Exception");
                obj.close();
            }
            catch(ClassNotFoundException e){
                System.out.println("Sorry! the targetted class is not found\n");
            }
            catch(IOException e){
                System.out.println("Input Output Exception\n");
            }


            try {
                File f = new File("Residential.txt");
                f.delete();
                if(f.exists()){
                    System.out.println("Yes");
                }else{
                    System.out.println("NO");
                }
                int sizelist = list.size();
                for(int i = 0; i<sizelist; i++){
                    addAResidentialPlot(list.remove(0));
                }
            }

            catch (Exception e) {
                System.out.println("Some error occured");
            }

        } catch(IOException e){
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
                System.out.println("Security");
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
                if(f.exists()){
                    System.out.println("is");
                }
                int sizelist = list.size();
                for(int i = 0; i<sizelist; i++){
                    // if(name.equals(list.get(i).getOwner())){
                    //     list.remove(i);
                        // System.out.println("iNside loop if");
                    // }else{
                        addAResidentialPlot(list.remove(0));
                    // }
                }
            }catch(SecurityException e){
                System.out.println("Security");
            }catch (Exception e) {
                System.out.println("Some error occured");
            }
        }
        catch(IOException e){
            System.out.print("Any random error occured");
        }
        if(flag){
               System.out.print("Removed successfully!");
                
            }
            else{
                System.out.print("Couldn't remove successfully!");
            }
    }


}