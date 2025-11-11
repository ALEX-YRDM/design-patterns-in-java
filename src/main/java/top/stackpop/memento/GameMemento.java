package top.stackpop.memento;

public class GameMemento {
    
    private final String playername;

    private final int level;

    private final int hp;
    private final int mp;
    private final String position;
    private final long timestamp;
    public GameMemento(String playername, int level, int hp, int mp, String position, long timestamp) {
        this.playername = playername;
        this.level = level;
        this.hp = hp;
        this.mp = mp;
        this.position = position;
        this.timestamp = timestamp;
    }
    public String getPlayername() {
        return playername;
    }
    public int getLevel() {
        return level;
    }
    public int getHp() {
        return hp;
    }
    public int getMp() {
        return mp;
    }
    public String getPosition() {
        return position;
    }
    public long getTimestamp() {
        return timestamp;
    }

    

    

}
