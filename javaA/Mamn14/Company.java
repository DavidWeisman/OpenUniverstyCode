/**
 * This class represents a Company object
 * @author David Weisman
 * @version 19-01-2023
 */
public class Company
{
    private Rent[] _rents;
    private int _noOfRents;
    final int MAX = 1000;
    
    /**
     * Creates a new Company object
     * The number of rents starts from 0.
     */
    public Company()
    {
        _rents = new Rent[MAX];
        _noOfRents = 0;
    }
    
    /**
     * Add rent to the company
     * @param name the client name
     * @param car the rented car
     * @param pick the pickup date
     * @param ret the return date
     * @return true if a rent has been entered, otherwise false
     */
    public boolean addRent(String name, Car car, Date pick, Date ret) 
    {
        Rent r1 = new Rent(name, car, pick, ret);
        if(_noOfRents == 0)
        {
            _rents[_noOfRents] = r1;
            _noOfRents++;
            return true;
        }
        
        if(_noOfRents < MAX)
        {
            int index = 0;
            for(int e = 1; e <= _noOfRents; e++)
            {
                if(pick.before(_rents[index].getPickDate()))
                {
                    Rent[] tmp = new Rent[MAX];
                    
                    //Copying the rents as they were until the index
                    for(int i = 0; i < index; i++)
                    {
                        tmp[i] = _rents[i];
                    }
                    
                    //Enters the new rent
                    tmp[index] = r1;
                    
                    //Copying the rents as they were after the index
                    for(int i = index; i <_noOfRents; i ++)
                    {
                        if (i < MAX)
                        {
                            tmp[i + 1] = _rents[i];
                        }
                    }
                    _rents = tmp;
                    _noOfRents++;
                    return true;
                }
                index++;
            }
            _rents[_noOfRents] = r1;
            _noOfRents++;
        }
        return false;
    }
    
    /**
     * Remove rent for the company
     * @param ret the date of the rent that want to remove
     * @return true if has been remove of rent, otherwise false
     */
    public boolean removeRent(Date ret)
    {
        int index = 0;
        for(int e = 1; e <= _noOfRents; e++)
            {
                if(ret.equals(_rents[index].getReturnDate()))
                {
                    Rent[] tmp = new Rent[MAX];
                    
                    //Copying the rents as they were until the index
                    for(int i = 0; i < index; i++)
                    {
                        tmp[i] = _rents[i];
                    }
                    
                    //Copying the rents as they were after the index
                    for(int i = index; i <_noOfRents; i ++)
                    {
                        if (i < MAX)
                        {
                            tmp[i] = _rents[i + 1];
                        }
                    }
                    _rents = tmp;
                    _noOfRents--;
                    return true;
                }
                index++;
            }
        return false;
    }
    
    /**
     * Get the price of all rents
     * @return price of all rents
     */
    public int getSumOfPrices()
    {
        int sum = 0;
        for(int i = 0; i < _noOfRents; i++)
        {
            sum += _rents[i].getPrice();
        }
        return sum;
    }
    
    /**
     * Get the number of days of all rents 
     * @return number of days of all rents 
     */
    public int getSumOfDays()
    {
        int sum = 0;
        for(int i = 0; i < _noOfRents; i++)
        {
            sum += _rents[i].howManyDays();
        }
        return sum; 
    }
    
    /**
     * Get the average of the all rents days
     * If ther is no rents returns 0
     * @return average of the all rents days
     */
    public double averageRent()
    {
        if(_noOfRents == 0)
        {
            return 0;
        }
        return (getSumOfDays() / _noOfRents);    
    }
    
    /**
     * Returns the car with the latest return date
     * If ther is no rents returns null
     * @ return car with the latest return date
     */
    public Car lastCarRent()
    {
        if(_noOfRents == 0)
        {
            return null;
        }
        Date latestDate = _rents[0].getReturnDate();
        Car car = _rents[0].getCar();
        for(int i = 1; i <_noOfRents; i++)
        {
            if((_rents[i].getReturnDate()).after(latestDate))
            {
                latestDate = _rents[i].getReturnDate();
                car = _rents[i].getCar();
            }
        }
        return car;
    }
    
    /**
     * Returns the rent with longest rent
     * If ther is no rents returns null
     * @return the rent with longest rent
     */
    public Rent longestRent()
    {
        if(_noOfRents == 0)
        {
            return null;
        }
        int longestRent = _rents[0].howManyDays();
        Rent rent = _rents[0];
        for(int i = 1; i <_noOfRents; i++)
        {
            if(_rents[i].howManyDays() > longestRent)
            {
                longestRent = _rents[i].howManyDays();
                rent = _rents[i];
            }
        }
        return rent;
    }
    
    /**
     * Returns the most common type of car in the company
     * If ther is no rents returns N
     * @return the most common type of car in the company
     */
    public char mostCommonRate()
    {
        // counters of the types 
        int counterOfA = 0;
        int counterOfB = 0;
        int counterOfC = 0;
        int counterOfD = 0;
        
        // most common type
        int NumOfCommonType = 0;
        char TheCommonType  = 'N';
        for(int i = 0; i < _noOfRents; i++)
        {
            switch(_rents[i].getCar().getType())
            {
                case 'A':
                    counterOfA += 1;
                    break;
                case 'B':
                    counterOfB += 1;
                    break;
                case 'C':
                    counterOfC += 1;
                    break;
                case 'D':
                    counterOfD += 1;
                    break;
            }
        }
        if (counterOfD > NumOfCommonType)
        {
            NumOfCommonType = counterOfD;
            TheCommonType = 'D';
        }
        
        if (counterOfC > NumOfCommonType)
        {
            NumOfCommonType = counterOfC;
            TheCommonType = 'C';
        }
        
        if (counterOfB > NumOfCommonType)
        {
            NumOfCommonType = counterOfB;
            TheCommonType = 'B';
        }
        
        if (counterOfA > NumOfCommonType)
        {
            NumOfCommonType = counterOfA;
            TheCommonType = 'A';
        }
        
        return TheCommonType;
    }
    
    /**
     * Returns a String that represents the rents in the campany
     * If ther is no rents returns The company has 0 rents
     * @return String that represents the rents in the campany
     */
    public String toString ()
    {
        if (_noOfRents == 0)
        {
            return ("The company has 0 rents.");
        }
        
        String str = "The company has " + _noOfRents + " rents: \n";
        for(int i = 0; i < _noOfRents; i++)
            str+= _rents[i] + "\n";
        return str;
        
    }
}
