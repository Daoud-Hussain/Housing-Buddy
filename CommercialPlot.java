import java.io.Serializable;

public class CommercialPlot extends Plot implements Taxable, Serializable{
    private int price;

    public CommercialPlot(){
        //Default Argument Constructor
    }

    public CommercialPlot(String owner, int size, Address myAddress, int price){
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
        return (price*7)/100;
    }

    public String toString(){
        String text = super.toString() + "\nPrice: " + price + "\nTax Amount: " + getTaxAmount() ;
        return text;
    }
}