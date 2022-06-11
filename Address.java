public class Address {
    private String country;
    private String city;
    private  String street;

    public Address(){
    //Default Argument Constructor
    }


    //Full-Argument Constructor
    public Address(String street, String city, String country){
        if(street != ""){
            this.street = street;
        }
        if(city != ""){
            this.city = city;
        }
        if(country != ""){
            this.country = country;
        }
    }

    //Setters
    public void setCountry(String country){
        if(country != ""){
            this.country = country;
        }
    }
    public void setCity(String city){
        if(city != ""){
            this.city = city;
        }
    }
    public void setStreet(String street){
        if(street != ""){
            this.street = street;
        }
    }

    //Getters
    public String getCountry(){
        return country;
    }
    public String getCity(){
        return city;
    }
    public String getStreet(){
        return street;
    }
}