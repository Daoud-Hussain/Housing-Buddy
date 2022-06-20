import java.io.Serializable;

public class Plot implements Serializable{
    protected String owner;
    protected int size;
    protected Address plotAddress;

    public Plot(){
        //Default Argument Constructor
        plotAddress = new Address();
    }

    //Full-Argument Constructor
    public Plot(String owner, int size, Address myAddress){
        if(owner != ""){
            this.owner = owner;
        }
        if(size > 0){
            this.size = size;
        }
        this.plotAddress = myAddress;
    }


    //Setters
    public void setOwner(String owner){
        if(owner != ""){
            this.owner = owner;
        }
    }

    public void setSize(int size){
        if(size > 0){
            this.size = size;
        }
    }


    //Getters
	public int getSize(){
		return size;
	}

	public String getOwner(){
		return owner;
	}


    public String toString(){
        String text = "Owner Name: " + owner + "\nSize: " + size + "\nSector: "
        + plotAddress.getSector() + "\nStreet Number: " + plotAddress.getStreet() + "\nPlot Number: " + plotAddress.getPlotNo();
        return text;
    }

}