public class Person {
    private String name;
    private String fatherName;
    private int age;
    private Address userAddress;

    public Person(){
        //Default Argument Constructor
        Address myAddress = new Address();
    }

    //Full-Argument Constructor
    public Person(String name, String fatherName, int age, Address userAddress){
        if(name != ""){
            this.name = name;
        }
        if(fatherName != ""){
            this.fatherName = fatherName;
        }
        if(age > 0){
            this.age = age;
        }
        this.userAddress = userAddress;
    }


    //Setters
    public void setName(String name){
        if(name != ""){
            this.name = name;
        }
    }
    public void setFatherName(String fatherName){
        if(fatherName != ""){
            this.fatherName = fatherName;
        }
    }






}
