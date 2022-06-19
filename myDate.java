public class myDate {
    private int month;
    private int day;
    private int year;

    public myDate(){
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }
    public myDate(int month, int day, int year){
        if(month < 1 || month > 12){
            System.out.println("Month number invalid! try again");
        }else{
            this.month = month;
        }
        if(day < 0 || day > 31){
            System.out.println("day of month is invalid! try again");
        }else{
            this.day = day;
        }
        if(year < 0){
            System.out.println("Year cannot be nagative");
        }else{   
            this.year = year;
        }
    }

    public void setMonth(int month){
        if(month < 1 || month > 12){
            System.out.println("Month number invalid! try again");
        }else{
            this.month = month;
        }
    }
    public void setDat(int day){
        if(day < 0 || day > 31){
            System.out.println("day of month is invalid! try again");
        }else{
            this.day = day;
        }
    }
    public void setYear(int year){
        if(year < 0){
            System.out.println("Year cannot be nagative");
        }else{   
            this.year = year;
        }
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public int getYear(){
        return year;
    }

    public void display(){
        System.out.println("Day = "+day);
        System.out.println("Month = "+month);
        System.out.println("Year = "+year);
        System.out.println(day + "/" + month + "/" + year);
    }

    public String toString(){
        return "\n"+day + "/" + month + "/" + year;
    }
}
