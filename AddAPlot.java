import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JOptionPane;

public class AddAPlot extends JFrame{
    AddAPlot(){

		String owner = JOptionPane.showInputDialog("Enter the owner name? ");
		String size = JOptionPane.showInputDialog("Enter the size of plot? ");
		String sector = JOptionPane.showInputDialog("Enter the Sector of plot? ");
		String street = JOptionPane.showInputDialog("Enter the Street of plot?");
		String plotNumber = JOptionPane.showInputDialog("Enter the number of plot? ");
		String price = JOptionPane.showInputDialog("Enter the price of plot? ");


        String responses = {"Residential", "Commercial"};
		JOptionPane.showOptionDialog(null,"Which type of plot you want to add","Confirm the type?",
        JOptionPane.YES_NO_CANCEL_OPTION,
         JOptionPane.INFORMATION_MESSAGE ,
         null,
         responses,
         0);

		Address myAddress = new Address(sector, street, plotNumber);
		ResidentialPlot plotObj = new ResidentialPlot(owner, size, myAddress, price);
		FileOperation myFile = new FileOperation();
		myFile.writeAFile(plotObj);

		JOptionPane.showMessageDialog(null, "Congratulations! Plot is added successfully", "Update", JOptionPane.INFORMATION_MESSAGE );

    }
}