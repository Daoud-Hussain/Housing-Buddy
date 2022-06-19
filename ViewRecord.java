import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;


public class ViewRecord{

	ViewRecord() {
		String[] responses = {"Residential", "Commercial"};
        int buttonResponse = JOptionPane.showOptionDialog(null,"Which type of plot you want to update","Confirm the type?",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
		responses,
		0);

        if(buttonResponse == 0){
   			FileOperation f= new FileOperation();
			f.viewAResidentialPlot();
        }
        else if(buttonResponse == 1){
          	FileOperation f= new FileOperation();
			f.viewACommercialPlot();
		}
		else{
			System.out.println("No such record exists!!");
		}
	}
	
}