import javax.swing.JOptionPane;


public class DeleteRecordByOwner{

	DeleteRecordByOwner() {
		String[] responses = {"Residential", "Commercial"};
        int buttonResponse = JOptionPane.showOptionDialog(null,"Which type of plot you want to update","Confirm the type?",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
		responses,
		0);

		String ownerName = JOptionPane.showInputDialog("Enter the owner of the plot:");


        if(buttonResponse == 0){
   			FileOperation f= new FileOperation();
			f.deleteAResidentialPlot(ownerName);
        }
        else if(buttonResponse == 1){
          	FileOperation f= new FileOperation();
			// f.deleteACommercialPlot(ownerName);
		}
		else{
			System.out.println("No such record exists!!");
		}
	}
	
}