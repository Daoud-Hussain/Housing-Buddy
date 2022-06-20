import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SearchByName {
    SearchByName() {
        try{
            String[] responses = {"Residential", "Commercial"};
            int buttonResponse = JOptionPane.showOptionDialog(null,"Which type of plot you want to search","Confirm the type?",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            responses,
            0);

            String name = JOptionPane.showInputDialog("Enter the name you want to search? ");
            if(buttonResponse == 0){
                boolean flag = false;
                ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Residential.txt"));
                try {
                    while(true){
                        ResidentialPlot s = (ResidentialPlot) obj.readObject();
                        if(s.getOwner().equalsIgnoreCase(name)){
                            flag = true;
                        }
                        
                    }
                }catch (ClassNotFoundException e) {
                    System.out.println("The targetted class is not Found\n");
                }catch(EOFException e){
                    obj.close();
                    System.out.println("The targetted file has ended\n");
                }catch(IOException e){
                    System.out.println("Couldn't perform operation due to some error");
                }


                if(flag){
                    JOptionPane.showMessageDialog(null, "Yes! Residential plot of " + name+ " is registered!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
                else{
                    JOptionPane.showMessageDialog(null, "No! Residential plot of " + name+ " is not registered!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
            }
            else if(buttonResponse == 1){
                boolean flag = false;
                ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Commercial.txt"));
                try {
                    while(true){
                        CommercialPlot s = (CommercialPlot) obj.readObject();
                        if(s.getOwner().equalsIgnoreCase(name)){
                            flag = true;
                        }
                        
                    }
                }catch (ClassNotFoundException e) {
                    System.out.println("The targetted class is not Found\n");
                }catch(EOFException e){
                    obj.close();
                    System.out.println("The targetted file has ended\n");
                }catch(IOException e){
                    System.out.println("Couldn't perform operation due to some error");
                }


                if(flag){
                    JOptionPane.showMessageDialog(null, "Yes! Commercial plot of " + name+ " is registered!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
                else{
                    JOptionPane.showMessageDialog(null, "No! Commercial plot of " + name+ " is not registered!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
            }
        }
        catch(IOException e){
            System.out.println("Any error");
        }
        
    }

}