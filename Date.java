public class Date{
	private int day;
	private int month;
	private int year;



	public Date(){
		//Default Argument Constructor
	}

	public Date(int day, int month, int year){
			this.day = day;
			this.month = month;
			this.year = year;
	}


	//Setters
    public void setDay(int day){
        if(day > 0){
            this.day = day;
        }
    }

    public void setMonth(int month){
        if(month > 0){
            this.month = month;
        }
    }

    public void setYear(int year){
        if(year > 0){
            this.year = year;
        }
    }


	//Getters
	public int getDay(){
		return day;
	}

	public int getMonth(){
		return month;
	}


	public int getYear(){
		return year;
	}

}