package top.stackpop.state;

public class NormalState implements CharacterState{

    @Override
    public void attack(GameCharacter character) {
       int damage = character.getBaseAttack();
       System.out.println("[正常状态] "+character.getName()+"发起攻击，造成"+damage+"点伤害");
        
    }

    @Override
    public String getStateName() {
        
        return "normal";    }

    @Override
    public void heal(GameCharacter character, int amount) {
        
        int newHp = Math.min(character.getHp()+amount,character.getMaxHp());

        character.setHp(newHp);
        System.out.println("[正常状态] " + character.getName() + " 恢复 " + amount + " 点 HP，当前 HP：" + character.getHp());
   
        
    }

    @Override
    public void move(GameCharacter character) {
        System.out.println("[正常状态]"+character.getName()+" 正常移动，速度"+character.getBaseSpeed());
        
    }

    @Override
    public void takeDamage(GameCharacter character, int damage) {
        
        character.setHp(character.getHp()-damage);
        System.out.println("[正常状态] " + character.getName() + " 受到 " + damage + " 点伤害，剩余 HP：" + character.getHp());
        if(character.getHp()<=0){
            character.setState(new DeadState());
            System.out.println("[正常状态] " + character.getName() + " 死亡！");
        }
        else if(character.getHp()<character.getMaxHp()*0.3){
            character.setState(new InjuredState());
            System.out.println("[正常状态] "+character.getName()+" 进入受伤状态");
        }
        
    }

    
    
}
