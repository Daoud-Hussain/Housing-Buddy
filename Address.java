import java.io.Serializable;

public class Address implements Serializable{
    private String plotNo;
    private String street;
    private String city;

    public Address(){
        plotNo = "";
        street = "";
        city = "";
    }

    public Address(String plotNo, String street , String  city){
        this.plotNo  = plotNo;
        this. street = street;
        this.city  = city;
    }
    public String getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getStreet(){
        return street;
    }

    public String getCity(){
        return city;
    }

    public String toString(){
        return "\nPlot no is : "+plotNo+"\nStreet no is : "+street+"\nCity is : "+city;
    }
}