package top.stackpop.state;

public class DeadState implements CharacterState{

    @Override
    public void attack(GameCharacter character) {
        System.out.println("[死亡状态] " + character.getName() + " 已死亡，无法攻击");
        
    }

    @Override
    public String getStateName() {
        return "dead";
    }

    @Override
    public void heal(GameCharacter character, int amount) {
        if(amount>=50){
            character.setHp(amount);
            character.setState(new NormalState());
            System.out.println("[死亡状态] " + character.getName() + " 被复活，HP：" + character.getHp());
        
        }else {
            System.out.println("[死亡状态] " + character.getName() + " 已死亡，需要更强的治疗才能复活");
        }
        
    }

    @Override
    public void move(GameCharacter character) {
        System.out.println("[死亡状态] " + character.getName() + " 已死亡，无法移动");
        
    }

    @Override
    public void takeDamage(GameCharacter character, int damage) {
        System.out.println("[死亡状态] " + character.getName() + " 已死亡，无法受到伤害");
        
    }

    
    
}
