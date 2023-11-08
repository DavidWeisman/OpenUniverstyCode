/*
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
        
        CityNode cityNode1 = new CityNode(getCityNodeByName(city1));
        CityNode cityNode2 = new CityNode(getCityNodeByName(city2));
        Date d1 = new Date(cityNode1.getCity().getDateEstablished());
        Date d2 = new Date(cityNode2.getCity().getDateEstablished());
        if(d1.after(d2))
        {
            cityNode1 = new CityNode(getCityNodeByName(city2));
            cityNode2 = new CityNode(getCityNodeByName(city1));
        }
        String name = cityNode1.getCity().getCityName() + " - " + cityNode2.getCity().getCityName();
        
        long numOfResidents = cityNode1.getCity().getNumOfResidents() + cityNode2.getCity().getNumOfResidents();
    
        int numOfNeighborhoods = cityNode1.getCity().getNumOfNeighborhoods() + cityNode2.getCity().getNumOfNeighborhoods();
        
        Point cityCenter = new Point(cityNode1.getCity().getCityCenter().middle(cityNode2.getCity().getCityCenter()));
        
        Point centralStation;
        if(cityNode1.getCity().getCentralStation().equals(cityNode1.getCity().getCentralStation()))
        {
            centralStation = new Point(cityNode2.getCity().getCentralStation());
        }
        else if(cityNode1.getCity().getCentralStation().isLeft(cityNode1.getCity().getCentralStation()))
        {
            centralStation = new Point(cityNode1.getCity().getCentralStation());
        }
        else
        {
            centralStation = new Point(cityNode2.getCity().getCentralStation());
        }
        
        int day = cityNode1.getCity().getDateEstablished().getDay();
        int year = cityNode1.getCity().getDateEstablished().getYear();
        int month = cityNode1.getCity().getDateEstablished().getMonth();
        City newCity = new City(name,day, month, year, cityCenter.getX(), cityCenter.getY(), centralStation.getX(), centralStation.getY(), numOfResidents, numOfNeighborhoods);
        CityNode newOne= new CityNode(newCity);
        
        
        CityNode temp= _head;
        while(temp.getNext() != null || temp.getNext().getCity().getCityName() != cityNode1.getCity().getCityName())
        {
            temp = temp.getNext();
        }
        newOne.setNext(temp.getNext().getNext());
        temp.setNext(newOne);
        while(temp.getNext() != null)
        {
            if(temp.getNext().getCity().getCityName() == cityNode2.getCity().getCityName())
            {
                temp.setNext(temp.getNext().getNext());
            }
            else
            {
                temp = temp.getNext();
            }
        }
        
    }
*/