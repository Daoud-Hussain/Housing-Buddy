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

public class SearchBySector {
    SearchBySector() {
        try{
            String[] responses = {"Residential", "Commercial"};
            int buttonResponse = JOptionPane.showOptionDialog(null,"Which type of plot you want to search","Confirm the type?",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            responses,
            0);

            String sector = JOptionPane.showInputDialog("Enter the sector you want to search? ");
            if(buttonResponse == 0){
                boolean flag = false;
                try {
                    ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Residential.txt"));
                    try{

                        while(true){
                            ResidentialPlot s = (ResidentialPlot) obj.readObject();
                            if(s.plotAddress.getSector().equalsIgnoreCase(sector)){
                                flag = true;
                                new Details(s.toString());
                            }
                            
                        }
                    }catch(EOFException e){
                        obj.close();
                        System.out.println("The targetted file has ended Residential\n");
                    }
                }catch(FileNotFoundException e){
                    System.out.println("no file of Residential");
                    JOptionPane.showMessageDialog(null, "No such record found!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
                catch (ClassNotFoundException e) {
                    System.out.println("The targetted class is not Found\n");
                }catch(IOException e){
                    System.out.println("Couldn't perform operation due to some error Residential");
                }


                if(flag){
                    JOptionPane.showMessageDialog(null, "Yes! Residential plot of " + sector+ " is registered!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
                else{
                    JOptionPane.showMessageDialog(null, "No! Residential plot of " + sector+ " is not registered!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
            }
            else if(buttonResponse == 1){
                boolean flag = false;
                try {
                    ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Commercial.txt"));
                    try{    
                        while(true){
                            CommercialPlot s = (CommercialPlot) obj.readObject();
                            if(s.plotAddress.getSector().equalsIgnoreCase(sector)){
                                flag = true;
                                new Details(s.toString());
                            }    
                        }
                    }catch(EOFException e){
                        obj.close();
                        System.out.println("The targetted file has ended Residential\n");
                    }
                }catch(FileNotFoundException e){
                    JOptionPane.showMessageDialog(null, "No such record found!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
                catch (ClassNotFoundException e) {
                    System.out.println("The targetted class is not Found\n");
                }catch(IOException e){
                    System.out.println("Couldn't perform operation due to some error");
                }


                if(flag){
                    JOptionPane.showMessageDialog(null, "Yes! Commercial plot of " + sector+ " is registered!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
                else{
                    JOptionPane.showMessageDialog(null, "No! Commercial plot of " + sector+ " is not registered!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                }
            }
        }
        catch(Exception e){
            System.out.println("Any error "+e.getMessage());
        }
        
    }

}