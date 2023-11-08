/**
 * This class represents a Mamn14
 * @author David Weisman
 * @version 10-06-2023
 */
public class Country
{
    CityNode _head;
    private String _name;
    
    /**
     * Creates a new Country object
     * The head points to null
     * @param name the name of the country
     */
    public Country(String name)
    {
        _name = name;
        _head = null;
    }
    
    /**
     * Returns a String that represent the cities in the Country.
     * If there is no cities returns "There are no cities in this country."
     * @return String that represent the cities in the Country.
     */
    public String toString()
    {
        if (isEmpty())
        {
            return "There are no cities in this country.";
        }
        
        String result = "";
        
        result += "Cities of " + _name + ":";
        
        CityNode temp = _head;
        while (temp != null) {
            result += "\n\n" + temp.getCity().toString();
            temp = temp.getNext();
        }
        
        return result;
    }
    /**
     * Add city to the country.
     * @param name of the city.
     * @param day the day of date established.
     * @param month the month of date established.
     * @param year the year of date established.
     * @param xCityCenter the X coordinate of center of the city.
     * @param yCityCenter the Y coordinate of center of the city.
     * @param xCentralStation the X coordinate of CentralStation of the city.
     * @param yCentralStation the Y coordinate of CentralStation of the city.
     * @param numOfResidents the number of residents of the city.
     * @param numOfNeighborhoods the number of neighborhoods of the city.
     */
    public boolean addCity(String name,
                            int day, int month, int year,
                            int xCityCenter, int yCityCenter,
                            int xCentralStation, int yCentralStation,
                            long numOfResidents,
                            int numOfNeighborhoods)
    {
        City newCity = new City(name,
                                day, month, year,
                                xCityCenter, yCityCenter,
                                xCentralStation, yCentralStation,
                                numOfResidents,
                                numOfNeighborhoods);
        
        CityNode newNode = new CityNode(newCity);
        
        
        // if the list is empty -> this is the first city
        if (isEmpty())
        {
            _head = new CityNode(newCity);
            return true;
        }
        
        // if the city is already in the list
        if (isExists(newCity))
        {
            return false;
        }
        
        // Find the right place from data perspective
        // head of list - oldest city, end of list - newest
        CityNode cityNode = _head;
        CityNode lastNewerCity = findTheLastNewerCity(_head, newCity.getDateEstablished());
        if (lastNewerCity == null) {
            lastNewerCity = _head;
        }
        CityNode previousItem = findLexicalPlace(lastNewerCity, name, newCity.getDateEstablished());
        
        if (previousItem == null) {
            newNode.setNext(_head);
            _head = newNode;
            return true;
        }
        
        newNode.setNext(previousItem.getNext());
        previousItem.setNext(newNode);
        
        return true;
    }
    
    // this function receives the output of findTheLastNewerCity()
    // it moves forward in the list until it gets to the point a new item should get inserted
    private CityNode findLexicalPlace(CityNode startNode, String cityName, Date date)
    {
        CityNode previous = null;
        CityNode cityNode = startNode;
        
        if (startNode == null) {
            // add item to start of list
            return null;
        }
        
        // this is the last item in the list.
        if (cityNode.getNext() == null) {
            if ((cityNode.getCity().getDateEstablished().equals(date)) &&
            (cityNode.getCity().getCityName().compareTo(cityName) > 0))
            {
                return null;
            }
            return startNode;
        }
        
        previous = cityNode;
        cityNode = cityNode.getNext();
        while ((cityNode != null) && !(cityNode.getCity().getDateEstablished().after(date))) {
            if (cityNode.getCity().getCityName().compareTo(cityName) > 0)
            {
                return previous;
            }
            
            previous = cityNode;
            cityNode = cityNode.getNext();
        }
        
        return previous;
    }
    
    
    
    private CityNode findTheLastNewerCity(CityNode head, Date date)
    {
        CityNode cityNode = head;
        CityNode previous = null;
        
        if (head == null) {
            return null;
        }
        
        // only 1 item in list
        if (cityNode.getNext() == null) {
            if (!cityNode.getCity().getDateEstablished().after(date))
            {
                return null;
            } else {
                return cityNode;
            }
        }
        
        // previous = cityNode;
        // cityNode = cityNode.getNext();
        while (cityNode != null) {
            if (cityNode.getCity().getDateEstablished().before(date))
            {
                previous = cityNode;
                cityNode = cityNode.getNext();
            } else {
                break;
            }
        }
        
        return previous;
    }
    
    
    private boolean isExists(City city) {
        return isExists(_head, city);
    }
    
    private boolean isExists(CityNode head, City city)
    {
        if (head == null)
            return false;
        
        if (head.getCity().equals(city))
            return true;
        
        return isExists(head.getNext(), city);
    }
    
    private boolean sameDate(CityNode temp, CityNode newNode)
    {   
        if(temp.getNext() == null)
            return false;
        if(temp.getNext().getCity().getDateEstablished().equals(newNode.getCity().getDateEstablished()))
            return true;
        return sameDate(temp.getNext(), newNode);
    }
    /**
     * Calculating the number of residents.
     * @return the number of residents.
     */
    public long getNumOfResidents()
    {
        CityNode temp = _head;
        long sum = 0;
        
        while (temp != null)
        {
            sum += temp.getCity().getNumOfResidents();
            temp = temp.getNext();
        }
        
        return sum;
    }
    
    /**
     * Calculate the bigest distance between two cities.
     * @return the bigest distance between two cities.
     */
    public double longestDistance()
    {
        CityNode cityNode1 = _head;
        
        if (getNumOfCities() < 2)
        {
            return 0;
        }
        
        double max = 0;
        while (cityNode1 != null)
        {
            // cityNode2 is used to iterate on all cities in the country
            CityNode cityNode2 = _head;
            while (cityNode2 != null)
            {
                // calculate distance between city1 to city2
                double distance = cityNode1.getCity().getCityCenter().distance(
                    cityNode2.getCity().getCityCenter());
                if (distance > max)
                {
                    max = distance;
                }
                
                cityNode2 = cityNode2.getNext();
            }
            cityNode1 = cityNode1.getNext();
        }
        
        return max;
    }
    
    /**
     * Calculate how many cities are north of a certain city.
     * @param the certain city.
     * @return teh number of the cities that are north of a certain city.
     */
    public int numCitiesNorthOf(String city)
    {
        CityNode theCity = getCityNodeByName(city);
        if (theCity == null)
        {
            return -1;
        }
        
        CityNode temp = _head;
        int counter = 0;
        
        while (temp != null)
        {
            if (temp.getCity().getCityCenter().isAbove(theCity.getCity().getCityCenter()))
            {
                counter++;
            }
            
            temp = temp.getNext();
        }
        
        return counter; 
    }
    
    /**
     * Calculate the southernmost cityץ
     * @return the southernmost cityץ
     */
    public City southernmostCity()
    {
        CityNode temp = _head;
        
        if (getNumOfCities() == 1) {
            return _head.getCity();
        }
        
        int max = 0;
        City southernCity = null;
        
        while (temp != null)
        {
            int countSouthTo = numCitiesNorthOf(temp.getCity().getCityName());
            if (max < countSouthTo)
            {
                max = countSouthTo;
                southernCity = temp.getCity();
            }
            
            temp = temp.getNext();
        }
        
        return southernCity;
    }
    /**
     * Return the name of the country.
     * @return the name of the country.
     */
    public String getCountryName()
    {
        return _name;
    }
    
    /**
     * Return the numbere of citites in the country.
     * @return the numbere of citites in the country.
     */
    public int getNumOfCities()
    {
        return getNumOfCities(_head);
    }
    
    private int getNumOfCities(CityNode cityNode)
    {
        if (cityNode == null)
            return 0;
        return 1 + getNumOfCities(cityNode.getNext());
    }
    
    /**
     * Calculates if there is a city between the two given dates.
     * @param d1 the first date.
     * @param d2 the second date.
     * @return true or false if there is or there isn't a city between the two given dates.
     */
    public boolean wereCitiesEstablishedBeforeOrAfter(Date d1, Date d2)
    {
        CityNode temp = _head;
        
        while (temp != null)
        {
            if(!temp.getCity().cityEstablishedBetweenDates(d1, d2))
            {
                return true;
            }
            
            temp = temp.getNext();
        }
        
        return false;
    }
    /**
     * Connecting two cities into one city
     * @param city1 the first city.
     * @param city2 the second city.
     */
    public void unifyCities(String city1, String city2)
    {
        // New city
        // name: city1-city2
        // foundation date:  earlier(c1,c2)
        // residents: c1+c2
        // neighbourgoods: c1+c2
        // city center: in the middle of the 2 cities
        // central station: left most (c1,c2)
        //
        // remove the youngest city, update the old one details
        
        CityNode cityNode1 = getCityNodeByName(city1);
        CityNode cityNode2 = getCityNodeByName(city2);

        if ((cityNode1 == null) || (cityNode2 == null)) 
        {
            return;
        }
        
        City cityObj1 = cityNode1.getCity();
        City cityObj2 = cityNode2.getCity();
        
        CityNode oldCityNode;
        CityNode newCityNode;
        
        if (cityNode1.getCity().getDateEstablished().before(
                cityNode2.getCity().getDateEstablished()))
        {
            oldCityNode = cityNode1;
            newCityNode = cityNode2;
        } else {
            oldCityNode = cityNode2;
            newCityNode = cityNode1;
        }
        
        // now that we've found the oldest city, start making the changes to unify the cities
        City unifiedCity = oldCityNode.getCity();
        unifiedCity.setCityName(city1 + "-" + city2);
        
        unifiedCity.setDateEstablished(oldCityNode.getCity().getDateEstablished());
        unifiedCity.setNumOfResidents(cityObj1.getNumOfResidents() + cityObj2.getNumOfResidents());
        unifiedCity.setNumOfNeighborhoods(cityObj1.getNumOfNeighborhoods() + cityObj2.getNumOfNeighborhoods());
        unifiedCity.setCityCenter(cityObj1.getCityCenter().middle(
            cityObj2.getCityCenter()));
            
        if (cityObj1.getCentralStation().isLeft(cityObj2.getCentralStation())) {
            unifiedCity.setCentralStation(cityObj1.getCentralStation());
        } else {
            unifiedCity.setCentralStation(cityObj2.getCentralStation());
        }
        
        // UPDATE: old city with unified details
        oldCityNode.setCity(unifiedCity);

        // remove newer city from country
        removeCity(newCityNode.getCity().getCityName());
    }
    
    private void removeCity(String cityName)
    {
        CityNode cityNode = _head;
        
        if (cityNode == null) {
            return;
        }
        
        if (cityNode.getCity().getCityName() == cityName) {
            _head =  cityNode.getNext();
            return;
        }
        
        CityNode previous = cityNode;
        cityNode = cityNode.getNext();
        
        while (cityNode != null)
        {
            if (cityNode.getCity().getCityName() == cityName) {
                previous.setNext(cityNode.getNext());
                return;
            }
            
            previous = cityNode;
            cityNode = cityNode.getNext();
        }
    }
    
    private CityNode getCityNodeByName(String city)
    {
        CityNode cityNode = _head;
        
        while (cityNode != null)
        {
            if (cityNode.getCity().getCityName() == city)
            {
                return cityNode;
            }
            
            cityNode = cityNode.getNext();
        }
        
        return null;
    }
    
    
    private boolean isEmpty()
    {
       if (_head == null)
       {
            return true;
       }
       
       return false;
    }
    /**
     * Calculates the biggest difference in days between the dates of the establishment of any two cities in the country .
     * @return the biggest difference in days between the dates of the establishment of any two cities in the country .
     */
    public int establishMaxDiff()
    {
        if (getNumOfCities() == 0)
        {
            return -1;
        }
        else if (getNumOfCities() == 1)
        {
            return 0;
        }
        
        CityNode cityNode1 = _head;
        int max = 0;
        while(cityNode1 != null)
        {
            CityNode cityNode2 = _head;
            while(cityNode2 != null)
            {
                int diff = cityNode1.getCity().getDateEstablished().difference(
                    cityNode2.getCity().getDateEstablished());
                if (diff > max)
                {
                    max = diff;
                }
                
                cityNode2 = cityNode2.getNext();
            }
            cityNode1 = cityNode1.getNext();
        }
        
        return max;
    }
}
