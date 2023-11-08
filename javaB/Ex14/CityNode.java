/**
 * This class represents a Mamn14
 * @author David Weisman
 * @version 10-06-2023
 */
public class CityNode
{
    private City _city;
    private CityNode _next;
    
    /**
     * Creates a new CityNode object.
     * The next points to null.
     * @param c the first city of the city node.
     */
    public CityNode(City c)
    {
        _city = new City(c);
        _next = null;
    }
    /**
     * Creates a new CityNode object.
     * @param c the first city of the city node.
     * @param next the next city node.
     */
    public CityNode(City c, CityNode next)
    {
        _city = new City(c);
        _next = next;
    }
    /**
     * Creates a copy CityNode object.
     * @param c the city node the been coped.
     */
    public CityNode(CityNode c)
    {
        _city = new City(c._city);
        _next = c._next;
    }
    
    /**
     * Get the city of the city node
     * @return the city of the city node
     */
    public City getCity()
    {
        return new City(_city);
    }
    /**
     * Get the next city node of the city node
     * @return the next city node of the city node
     */
    public CityNode getNext()
    {
        return _next;
    }
    
    /**
     * Sets the city of the city node
     * @param city for set
     */
    public void setCity(City c)
    {
        _city = new City(c);
    }
    /**
     * Sets the new city node of the city node
     * @param city node for set
     */
    public void setNext(CityNode next)
    {
        _next = next;
    }    
}
