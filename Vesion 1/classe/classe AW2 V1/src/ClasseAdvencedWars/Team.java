package ClasseAdvencedWars;



/**
 * 
 */
public class Team {
    
    /**
     * 
     */
    private int money;

    /**
     * 
     */
    private int income;
    
    /**
     * 
     */
    private final String name;
    
    /**
     * Default constructor
     */
    public Team(String name){
        this.name = name;
        this.money = 0;
        this.income = 0;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }
    
    public void ChangeIncome(int i){
        this.income += i;
    }

}