package ClasseAdvencedWars;



/**
 * 
 */
public class Team {
    private TeamID teamID;
    
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
    public Team(String name, TeamID teamID){
        this.name = name;
        this.money = 0;
        this.income = 0;
        this.teamID = teamID;
    }

    public int getMoney() {
        return money;
    }
    
    public void pay(int price){
        this.money -= price;
    }
    
    public String getName() {
        return name;
    }
    
    public void ChangeIncome(int i){
        this.income += i;
    }
    
    public void onEndTurn(){
        this.money+=this.income;
    }

    public TeamID getTeamID() {
        return teamID;
    }

    //TEST PROVISIOIRE
    public int getIncome(){
        return this.income;
    }
}