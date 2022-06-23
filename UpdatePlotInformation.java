import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;


public class UpdatePlotInformation{

	UpdatePlotInformation(){
			String[] responses = {"Residential", "Commercial"};
            int buttonResponse = JOptionPane.showOptionDialog(null,"Which type of plot you want to update","Confirm the type?",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            responses,
            0);

			String oldName = JOptionPane.showInputDialog("Enter the owner of the plot:");
			String newName = JOptionPane.showInputDialog("Enter the new owner you want to update:");
			String priceStr = JOptionPane.showInputDialog("Enter the price you want to update:");
        	int price = Integer.parseInt(priceStr);


			FileOperation f= new FileOperation();

		if(buttonResponse == 0){
			if(f.UpdateResidentialPlot(oldName, newName, price)){
				JOptionPane.showMessageDialog(null, "Updated residential plot information Successfully!!", "Update", JOptionPane.INFORMATION_MESSAGE );
			}
			else{
				
				JOptionPane.showMessageDialog(null, "No such user exists in residential files", "Update", JOptionPane.INFORMATION_MESSAGE );
			}
		}
		else{
			if(f.UpdateCommercialPlot(oldName, newName, price)){
				JOptionPane.showMessageDialog(null, "Updated Commercial plot information Successfully!!", "Update", JOptionPane.INFORMATION_MESSAGE );
			}
			else{
				
				JOptionPane.showMessageDialog(null, "No such user exists in Commercial files", "Update", JOptionPane.INFORMATION_MESSAGE );
			}
		}
	}
	
}