/**
 * This class represents a Date object
 * @author David Weisman
 * @version 30-12-2022
 */
public class Date
{
    private int _day;
    private int _month;
    private int _year;
    
    final int JANUARY = 1;
    final int FEBRUARY = 2;
    final int MARCH = 3;
    final int MAY = 5;
    final int JULY = 7;
    final int AUGUST = 8;
    final int OCTOBER = 10;
    final int DECEMBER = 12; 
    final int MAXYEAR = 9999;
    final int MINYEAR = 1000;
    
    //Checks whether a date is a valid date
    private boolean isValidDate(int day, int month, int year)
    {
        if (year < MINYEAR || year >  MAXYEAR)
        {
            return false;
        } 
        
        if (month < 0 || month > 12)
        {
            return false;
        }
        
        if (day < 0)
        {
            return false;
        }
        //Checks all months except February
        switch(month)
        {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                if(day > 31)
                {
                    return false;  
                }
            default:
                if(day > 30)
                {
                    return false;
                }
        }
        
        if (month == FEBRUARY)
        {
            if(isLeapYear(year))
            {
                if(day > 29)
                {
                    return false;   
                }
            }
            else
            {
                if(day > 28)
                {
                    return false;   
                }
            }
        }
        return true;
    }
    //Checks whether the year is a leap year
    private boolean isLeapYear(int year)
    {
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }
    
    /**
     * If the given date is valid - creates a new Date object, otherwise creates the date 1/1/2000
     * @param day the day in the month (1-31)
     * @param month the month in the year (1-12)
     * @param year the year (4 digits)
     */
    public Date(int day, int month, int year)
    {
        if (isValidDate(day ,month ,year))
        {
            _day = day;
            _month = month;
            _year = year;
        }
        else
        {
            _day = 1;
            _month = 1;
            _year = 2000;
        }
    }
    /**
     * Copy constructor
     * @param other the date to be copied
     */
    public Date (Date other)
    {
        _day = other._day;
        _month = other._month;
        _year = other._year;
    }
    /**
     * Gets the day
     * @return the day
     */
    public int getDay()
    {
        return _day;
    }
    /**
     * Gets the month
     * @return the month
     */
    public int getMonth()
    {
        return _month;
    }
    /**
     * Gets the year
     * @return the year
     */
    public int getYear()
    {
        return _year;
    }
    /**
     * Set the day (only if date remains valid)
     * @param dayToSet the day value to be set
     */
    public void setDay(int dayToSet)
    {
        if(isValidDate(dayToSet, _month, _year))
        {
            _day = dayToSet;
        }
    }
    /**
     * Set the month  (only if date remains valid)
     * @param monthToSet the month  value to be set
     */
    public void setMonth(int monthToSet)
    {
        if(isValidDate(_day, monthToSet, _year))
        {
            _month = monthToSet;
        }   
    }
    /**
     * Set the year  (only if date remains valid)
     * @param yearToSet the year value to be set
     */
    public void setYear(int yearToSet)
    {
        if(isValidDate(_day, _month, yearToSet))
        {
            _year = yearToSet;
        }   
    }
    /**
     * Check if 2 dates are the same
     * @param other the date to compare this date to
     * @return true if the dates are the same, otherwise false
     */
    public boolean equals (Date other)
    {
        return (_day == other._day && _month == other._month && _year == other._year);      
    }
    /**
     * Check if this date is before other date
     * @param other date to compare this date to
     * @return true if this date is before other date, otherwise false
     */
    public boolean before (Date other)
    {
        return ((_year < other._year || (_year == other._year && _month < other._month) || (_year == other._year && _month == other._month && _day < other._day)));
    }
    /**
     * Check if this date is after other date
     * @param other date to compare this date to
     * @return true if this date is before other date, otherwise false
     */
    public boolean after (Date other)
    {
        return other.before(this);
    }
    /**
     * Calculates the difference in days between two dates
     * @param other  the date to calculate the difference between
     * @return the number of days between the dates (non negative value)
     */
    public int difference (Date other)
    {
        if(other.after(this))
        {
            return calculateDate(other.getDay(), other.getMonth(), other.getYear()) - calculateDate(_day, _month, _year);
        }
        
        return (calculateDate(_day, _month, _year) - calculateDate(other.getDay(), other.getMonth(), other.getYear()));
    }
    //Calculates the number of days that have passed since the beginning counting (according to the Gregorian calendar)
    private int calculateDate ( int day, int month, int year)
    {
        if (month < 3) 
        {
         year--;
         month = month + 12;
         }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
     }  
    /**
     * Returns a String that represents this date
     * @return String that represents this date in the following format: day (2 digits) / month(2 digits) / year (4 digits) for example: 02/03/1998
     */
    public String toString()
    {
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
    /**
     * Calculate the date of tomorrow
     * @return the date of tomorrow
     */
    public Date tomorrow()
    {
        switch(_month)
        {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            {
                if(_day == 31)
                {
                    return new Date(1,_month + 1,_year); 
                }
                else
                {
                    return new Date(_day + 1,_month,_year); 
                }
            }   
            
            case DECEMBER:
            {
                if (_day == 31)
                {
                    return new Date(1,1,_year + 1); 
                }
                else
                {
                    return new Date(_day + 1,_month,_year); 
                }
            }   
            
            case FEBRUARY:
            {
                if (_day == 29)
                {
                    return new Date(1, 3, _year); 
                }
                else if (_day == 28 && isLeapYear(_year))
                {
                    return new Date(29, 2, _year);
                }
                else if (_day == 28 && !isLeapYear(_year))
                {
                    return new Date(1, 3 ,_year);
                }
                else
                {
                    return new Date(_day + 1, _month, _year);   
                } 
            }
            
            default:
                if (_day == 30)
                {
                    return new Date(1, _month + 1, _year); 
                }
                else
                {
                    return new Date(_day + 1, _month, _year); 
                }  
        }
    }
}
