package top.stackpop.state;

public class InjuredState implements CharacterState{

    @Override
    public void attack(GameCharacter character) {
        int damage = (int)(character.getBaseAttack()*0.7);
        System.out.println("[受伤状态] "+character.getName()+ "攻击力下降，造成"+damage+"点伤害"+"（正常为 " + character.getBaseAttack() + "）");
        
    }

    @Override
    public String getStateName() {
        return "Injuired";
    }

    @Override
    public void heal(GameCharacter character, int amount) {
        int newHp = Math.min(character.getHp() + amount, character.getMaxHp());
        character.setHp(newHp);
        System.out.println("[受伤状态] " + character.getName() + " 恢复 " + amount + " 点 HP，当前 HP：" + character.getHp());
        if (character.getHp() >= character.getMaxHp() * 0.5) {
            character.setState(new NormalState());
            System.out.println("[受伤状态] " + character.getName() + " 恢复健康，回到正常状态");
        }
        
    }

    @Override
    public void move(GameCharacter character) {
        int speed = (int)(character.getBaseSpeed()*0.5);
        System.out.println("[受伤状态] " + character.getName() + " 移动速度下降，当前速度：" + speed + "（正常为 " + character.getBaseSpeed() + "）");
    
        
    }

    @Override
    public void takeDamage(GameCharacter character, int damage) {
        character.setHp(character.getHp()-damage);
        System.out.println("[受伤状态] " + character.getName() + " 受到 " + damage + " 点伤害，剩余 HP：" + character.getHp());
        
        if(character.getHp()<=0){
            character.setState(new DeadState());
            System.out.println("[受伤状态] " + character.getName() + " 死亡！");
        }
        
    }

    
    
}
