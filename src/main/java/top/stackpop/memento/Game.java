package top.stackpop.memento;

public class Game {
    
    private String playerName;

    private int level;

    private int hp;

    private int mp;

    private String position;

    public Game(String playerName) {
        this.playerName = playerName;
        this.level = 1;
        this.hp = 100;
        this.mp = 50;
        this.position = "0,0";
    }

    public void levelUp(){
        level++;
        hp+=20;
        mp+=10;
    }

    public void moveTo(String pos){
        this.position = pos;
    }

    public void hurt(int damage){
        hp = Math.max(0,hp-damage);
    }

    public void recover(int amount){
        hp+=amount;
    }

    public GameMemento save(){
        GameMemento m = new GameMemento(playerName, level, hp, mp, position, System.currentTimeMillis());
        System.out.println("[Game] save -> " + this);
        return m;
    }

    public void load(GameMemento m){
        this.playerName=m.getPlayername();
        this.level=m.getLevel();
        this.hp = m.getHp();
        this.mp = m.getMp();
        this.position = m.getPosition();
        System.out.println("[Game] load -> " + this);
    }

    @Override
    public String toString() {
        return "Game{player='" + playerName + "', level=" + level + ", hp=" + hp + ", mp=" + mp + ", pos='" + position + "'}";
    }

    
}
