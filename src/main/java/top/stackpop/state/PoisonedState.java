package top.stackpop.state;

public class PoisonedState implements CharacterState{
    private  int poisonTurns = 3;
    @Override
    public void attack(GameCharacter character) {
        
        int damage = (int)(character.getBaseAttack()*0.8);
        System.out.println("[中毒状态] " + character.getName() + " 攻击力下降，造成 " + damage + " 点伤害");
   
    }

    @Override
    public String getStateName() {
        return "poisoned";
    }

    @Override
    public void heal(GameCharacter character, int amount) {
        int newHp = Math.min(character.getHp()+amount, character.getMaxHp());
        character.setHp(newHp);
        System.out.println("[中毒状态] " + character.getName() + " 恢复 " + amount + " 点 HP，当前 HP：" + character.getHp());
        
        if(amount>=20){
            character.setState(new NormalState());
            System.out.println("[中毒状态] 使用解毒剂，解除中毒状态");
        }
        
    }

    @Override
    public void move(GameCharacter character) {
        int speed = (int)(character.getBaseSpeed() * 0.6); // 移动速度降低40%
        System.out.println("[中毒状态] " + character.getName() + " 移动速度下降，当前速度：" + speed);
    
        
    }

    @Override
    public void takeDamage(GameCharacter character, int damage) {
        character.setHp(character.getHp()-damage);
        System.out.println("[中毒状态] " + character.getName() + " 受到 " + damage + " 点伤害，剩余 HP：" + character.getHp());
        
        poisonTurns--;
        if(poisonTurns>0){
            int poisonDamage = 5;
            character.setHp(character.getHp()-poisonDamage);
            System.out.println("[中毒状态] 中毒效果：持续掉血 " + poisonDamage + " 点，剩余 " + poisonTurns + " 回合，当前 HP：" + character.getHp());
        }else{
            character.setState(new NormalState());
            System.out.println("[中毒状态] 中毒效果结束，回到正常状态");
        }
        if(character.getHp()<=0){
            character.setState(new DeadState());
            System.out.println("[中毒状态] " + character.getName() + " 死亡！");
        }
        
    }

    

    
    
}
