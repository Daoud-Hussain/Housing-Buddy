import java.io.Serializable;

public class Address implements Serializable{
    private String plotNo;
    private String street;
    private String sector;

    public Address(){
        plotNo = "";
        street = "";
        sector = "";
    }

    public Address(String plotNo, String street , String  sector){
        this.plotNo  = plotNo;
        this. street = street;
        this.sector  = sector;
    }

    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public void setSector(String sector){
        this.sector = sector;
    }

    public String getStreet(){
        return street;
    }

    public String getSector(){
        return sector;
    }

    
    public String getPlotNo() {
        return plotNo;
    }

    public String toString(){
        return "\nPlot no is : "+plotNo+"\nStreet no is : "+street+"\nsector is : "+sector;
    }
}