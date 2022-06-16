public class Plot {
    private String owner;
    private int size;
    private int plotNumber;
    private Address plotAddress;

    public Plot(){
        //Default Argument Constructor
        Address myAddress = new Address();
    }

    //Full-Argument Constructor
    public Plot(String owner, int plotNumber, int size, Address myAddress){
        if(owner != ""){
            this.owner = owner;
        }
        if(plotNumber > 0){
            this.plotNumber = plotNumber;
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
    public void setPlotNumber(int plotNumber){
        if(plotNumber > 0){
            this.plotNumber = plotNumber;
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

	public int getPlotNumber(){
		return plotNumber;
	}


	public String getOwner(){
		return owner;
	}


    public String toString(){
        String text = "Owner Name: " + owner + "\nPlot Number: " + plotNumber + "\nSize: " + size + "\nCity: "
        + plotAddress.getCity() + "\nStreet Number: " + plotAddress.getStreet() + "\nHouse: " + plotAddress.getHouse();
        return text;
    }

}