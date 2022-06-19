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
            String str = "";
            if(buttonResponse == 1){
                ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Residential.ser"));
                try {
                    while(true){
                        CommercialPlot s = (CommercialPlot) obj.readObject();
                        if(s.getOwner().equals(name)){
                            JOptionPane.showMessageDialog(null, "Yes! a Commercial plot is present!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Yes! a Commercial plot is present!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                        }
                    }

                }catch (ClassNotFoundException e) {
                    System.out.println("Sorry! the targetted class is not Found\n");
                }catch(EOFException e){
                    obj.close();
                    System.out.println("Reached end of file\n");
                }catch(IOException e){
                    System.out.println("Couldn't perform operation due to some error");
                }

            }   
            else if(buttonResponse == 0){
                ObjectInputStream obj = new ObjectInputStream(new FileInputStream("Residential.ser"));
                try {
                    while(true){
                        ResidentialPlot s = (ResidentialPlot) obj.readObject();
                        if(s.getOwner().equals(name)){
                            JOptionPane.showMessageDialog(null, "Yes! a Residential plot is present!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Yes! a Residential plot is present!!", "Update", JOptionPane.INFORMATION_MESSAGE );
                        }
                    }

                }catch (ClassNotFoundException e) {
                    System.out.println("Sorry! the targetted class is not Found\n");
                }catch(EOFException e){
                    obj.close();
                    System.out.println("Sorry! the targetted file has ended\n");
                }catch(IOException e){
                    System.out.println("Couldn't perform operation due to some error");
                }

            }
            else{
                System.out.println("Invalid Input!!!");
            }
            
        }
        catch(IOException e){
            System.out.println("Any error");
        }
		
	}

}