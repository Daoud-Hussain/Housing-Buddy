public class Plot {
    private String owner;
    private int size;
    private Address plotAddress;

    public Plot(){
        //Default Argument Constructor
        Address myAddress = new Address();
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
        String text = "Owner Name: " + owner + "\nSize: " + size + "\nCity: "
        + plotAddress.getCity() + "\nStreet Number: " + plotAddress.getStreet() + "\nHouse: " + plotAddress.getPlot();
        return text;
    }

}