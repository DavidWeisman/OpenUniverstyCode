/**
 * This class represents a Rent object
 * @author David Weisman
 * @version 30-12-2022
 */
public class Rent
{
    private String _name;
    private Car _car;
    private Date _pickDate;
    private Date _returnDate;
    
    final int PRICES_TYPE_A = 100;
    final int PRICES_TYPE_B = 150;
    final int PRICES_TYPE_C = 180;
    final int PRICES_TYPE_D = 240;
    final int DAYS_PER_WEEK = 7;
    
    /**
     * Creates a new Rent object
     * The return date must be at least one day after the pick up date, otherwise set it to one day after the pick up date.
     * @param name the client name
     * @param car the rented car
     * @param pick the pickup date
     * @param ret the return date
     */
    public Rent (String name, Car car, Date pick, Date ret)
    {
        _name = name;
        _car = new Car(car);
        _pickDate = new Date(pick);
        _returnDate = new Date(ret); 
        
        if (!_returnDate.after(_pickDate))
        {
            _returnDate = new Date(_pickDate.tomorrow());
        }
    }
    
    /**
     * Copy constructor
     * @param other the rent to be copied
     */
    public Rent (Rent other)
    {
        _name = other._name;
        _car = new Car(other._car);
        _pickDate = new Date(other._pickDate);
        _returnDate = new Date(other._returnDate);
    }
    
    /**
     * Gets the name
     * @return the name
     */
    public String getName()
    {
        return _name;
    }
    
    /**
     * Gets the car
     * @return the car
     */
    public Car getCar()
    {
        return new Car(_car);
    }
    
    /**
     * Gets the return date
     * @return the return date
     */
    public Date getReturnDate()
    {
        return new Date(_returnDate);
    }
    
    /**
     * Gets the pick up date
     * @return the pick up date
     */
    public Date getPickDate()
    {
        return new Date(_pickDate);
    }
    
    /**
     * Sets the client name
     * @param name the client name (You can assume that the name is a valid name)
     */
    public void setName(String name)
    {
        _name = name;
    }
    
    /**
     * Sets the rented car
     * @param car the rented car (You can assume that car is not null)
     */
    public void setCar(Car car)
    {
        _car = new Car(car);
    }
    
    /**
     * Sets the pick up date
     * The pick up date must be at least one day before the return date, otherwise - don't change the pick up date
     * @param pickDate the pick up date (You can assume that pick up date is not null)
     */
    public void setPickDate(Date pick)
    {
        _pickDate = new Date(pick);
    }
    
    /**
     * Sets the return date
     * The return date must be at least one day after the pick up date, otherwise - don't change the return date
     * @param returnDate the return date (You can assume that return date is not null)
     */
    public void setReturnDate(Date ret)
    {
        _returnDate = new Date(ret);
    }
    
    /**
     * Check if 2 rents are the same
     * @param other the rent to compare this rent to
     * @return true if the rents are the same
     */
    public boolean equals(Rent other)
    {
        return(_name == other.getName() && _pickDate.equals(other.getPickDate()) && _returnDate.equals(other.getReturnDate())) && _car.equals(other.getCar());
    }
    
    /**
     * Returns the number of rent days
     * @return the number of rent days
     */
    public int howManyDays()
    {
        return _pickDate.difference(_returnDate);
    }
    
    //Calculates the payment by price per day
    private int totalPrice(int prisePerDay)
    {
        int rentalTermDays = howManyDays();
        
        int weeks = rentalTermDays / DAYS_PER_WEEK;
        int days_left = rentalTermDays % DAYS_PER_WEEK;
        
        double weekly_price = DAYS_PER_WEEK * prisePerDay - ((DAYS_PER_WEEK * prisePerDay / 100.0) * 10);
        
        int sum = (int)weekly_price * weeks + days_left * prisePerDay;
        
        return sum;
    }
    
    /**
     * Returns the rent total price
     * @return the rent total price
     */
    public int getPrice()
    {
        switch(_car.getType())
        {
            case 'A':
                return totalPrice(PRICES_TYPE_A);                
            case 'B':
                return totalPrice(PRICES_TYPE_B);   
            case 'C':
                return totalPrice(PRICES_TYPE_C);
            default:
                return totalPrice(PRICES_TYPE_D);
        }
    }
    
    /**
     * Try to upgrade the car to a better car
     * If the given car is better than the current car of the rent, upgrade it and return the upgrade additional cost, otherwise - don't upgrade
     * @param car the car to upgrade to
     * @return the upgrade cost
     */
    public int upgrade (Car newCar)
    {
        if (!newCar.better(_car))
        {
            return 0;
        }
        int first_prise = getPrice();
        _car = new Car(newCar);
        return (getPrice() - first_prise);
    }
    
    /**
     * Returns a String that represents this rent
     * @return String that represents this rent in the following format: Name:Rama From:30/10/2022 To:12/11/2022 Type:B Days:13 Price:1845
     */
    public String toString()
    {
        return ("Name:" + getName() + " From:" + getPickDate() + " To:" + getReturnDate() + " Type:" + _car.getType() + " Days:" + howManyDays() + " Price:" + getPrice());
    }
}
