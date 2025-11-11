package top.stackpop.state;

public class GameCharacter {

    private CharacterState state;

    private final String name;

    private int hp;

    private final int maxHp;

    private final int baseAttack;

    private final int baseSpeed;

    public GameCharacter(String name, int maxHp, int baseAttack, int baseSpeed) {
        this.name = name;
        this.maxHp = maxHp;
        this.baseAttack = baseAttack;
        this.baseSpeed = baseSpeed;
        this.hp= maxHp;
        this.state = new NormalState();
    }

    public void attack(){
        state.attack(this);
    }

    public void move(){
        state.move(this);
    }

    public void takeDamage(int damage){
        state.takeDamage(this, damage);
    }

    public void heal(int amount){
        state.heal(this, amount);
    }

    public CharacterState getState() {
        return state;
    }

    public void setState(CharacterState state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public int getBaseSpeed() {
        return baseSpeed;
    }

    

    public void showStatus() {
        System.out.println(name + " - HP: " + hp + "/" + maxHp + ", 状态: " + state.getStateName());
    }

    
    
}
