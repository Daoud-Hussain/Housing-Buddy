import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JOptionPane;

public class AddAPlot extends JFrame implements Serializable{
    AddAPlot(){

        String[] responses = {"Residential", "Commercial"};
		int buttonResponse = JOptionPane.showOptionDialog(null,"Which type of plot you want to add","Confirm the type?",
        JOptionPane.YES_NO_CANCEL_OPTION,
         JOptionPane.INFORMATION_MESSAGE,
         null,
         responses,
         0);

		String owner = JOptionPane.showInputDialog("Enter the owner name? ");
		String sizeString = JOptionPane.showInputDialog("Enter the size of plot in Kanals? ");
        int size = Integer.parseInt(sizeString);
		String sector = JOptionPane.showInputDialog("Enter the Sector of plot? ");
		String street = JOptionPane.showInputDialog("Enter the Street of plot?");
		String plotNumber = JOptionPane.showInputDialog("Enter the number of plot? ");
		String priceStr = JOptionPane.showInputDialog("Enter the price of plot? ");
        int price = Integer.parseInt(priceStr);



		Address myAddress = new Address(sector, street, plotNumber);

		if(buttonResponse == 0){
			ResidentialPlot plotObj = new ResidentialPlot(owner, size, myAddress, price);
			FileOperation myFile = new FileOperation();
			myFile.addAResidentialPlot(plotObj);
			JOptionPane.showMessageDialog(null, "Congratulations! Residential Plot of size is added successfully",
			 "Update", JOptionPane.INFORMATION_MESSAGE );


		}
		else if(buttonResponse == 1){
			CommercialPlot plotObj = new CommercialPlot(owner, size, myAddress, price);
			FileOperation myFile = new FileOperation();
			myFile.addACommercialPlot(plotObj);
			JOptionPane.showMessageDialog(null, "Congratulations! Commercial Plot of size is added successfully",
			 "Update", JOptionPane.INFORMATION_MESSAGE );

			
		}
		else{
			System.out.println("Invalid input!!!");
		}




		
    }	
    //Adding event listeners
		// @Override
		// public void actionPerformed(ActionEvent e){
		// 	if(e.getSource() == buttonResponse){
		// 		System.out.println("Poo");
		// 	}
		// }

}