package top.stackpop.state;

public interface CharacterState {
    
    void attack(GameCharacter character);

    void move(GameCharacter character);

    void  takeDamage(GameCharacter character, int damage);

    void heal(GameCharacter character, int amount);

    String getStateName();
}
