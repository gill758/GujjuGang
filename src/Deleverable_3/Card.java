package Deleverable_3;

public class Card 
{
    private Suit s;
    private Value v;
    
    //constructor
    public Card(Suit su , Value va)
    {
        this.s = su;
        this.v = va;
    }
    
    //accessor and mutator methods
    public Suit getS()
    {
        return s;
    }
    
    public Value getv()
    {
        return v;
    }
    
    public void setS(Suit s)
    {
        this.s = s;
    }
    
    public void setV(Value v)
    {
        this.v = v;
    }
    
    @Override
    public String toString(){
        return v.toString() + " of " + s.toString();
    }

    
}
