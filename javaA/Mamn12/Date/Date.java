/**
 * This class represents a Date object
 * 
 * @author course staff
 * @version (2023a)
 */

public class Date
{
    private int _day;       
    private int _month;     
    private int _year;      

    //constructor:
    /** 
     * @param day the day in the month (1-31)
     * @param month the month in the year (1-12)
     * @param year the year (4 digits)
     */
    public Date(int day, int month, int year) {
            _day = day;
            _month = month;
            _year = year;
    }

    /** 
     * Gets the year 
     * @return the year
     */
    public int getYear(){
        return _year;
    }

    /** 
     * Gets the month 
     * @return the month
     */
    public int getMonth(){
        return _month;
    }

    /** 
     * Gets the day
     * @return the day
     */
    public int getDay(){
        return _day;
    }

    /** 
     * Sets the year
     * @param yearToSet the year value to be set
     */
    public void setYear(int yearToSet){
            _year = yearToSet;
    }

    /** 
     * Set the month 
     * @param monthToSet the month value to be set
     */
    public void setMonth(int monthToSet){
            _month = monthToSet;
    }

    /** 
     * Set the day
     * @param dayToSet the day value to be set
     */
    public void setDay(int dayToSet){
            _day = dayToSet;
    }

    /** 
     *  Check if 2 dates are the same
     *  @param other the date to compare this date to
     *  @return true if the dates are the same
     */
    public boolean equals(Date other){
        if(_day == other._day && _month == other._month && _year == other._year)
            return true;
        return false;
    }

    /** 
     *  Check if this date is before other date
     *  @param other date to compare this date to
     *  @return true if this date is before other date
     */
    public boolean before(Date other){

        if ((_year < other._year || (_year == other._year && _month < other._month) || 
            (_year == other._year && _month == other._month && _day < other._day)))
            return true;
        return false;
    }
            
    /**
     * Returns a  String that represents this date
     *
     * @return String that represents this date
     * in the following format:
     * day (2 digits) / month(2 digits) / year (4 digits) for example: 05/04/2019
     */
   public String toString() {
        String s = "";
        if(_day < 10)
            s = s + "0" + _day + "/";
        else 
            s = s + _day + "/";
        if(_month < 10)
            s = s + "0" + _month + "/";
        else 
            s = s + _month + "/";
        return s + _year;
    }    
}

