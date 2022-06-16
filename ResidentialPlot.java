public class ResidentialPlot extends Plot implements Taxable{
    private int price;

    public ResidentialPlot(){
        //Default Argument Constructor
    }

    public ResidentialPlot(String owner, int size, Address myAddress, int price){
        //Argumented Constructor
        super(owner, size, myAddress);
        if(price > 0){
            this.price = price;
        }
    }
   
    //Setter
    public void setPrice(int price){
        if(price > 0){
            this.price = price;
        }
    }


    //Getters
	public int getPrice(){
		return price;
	}

     public int getTaxAmount(){
        return (price*5)/100;
    }

    public String toString(){
        String text = super() + "\nPrice: " + price + "\nTax Amount: " + getTaxAmount() + "\nTotal Price: " + price+getTaxAmount();
        return text;
    }
}