package top.stackpop.state;

import org.junit.Test;

public class StateTest {
    
    @Test
    public void test(){
        GameCharacter role = new GameCharacter("神理绫华", 100, 20, 10);

        System.out.println("=== 角色状态 ===\n");
        role.showStatus();

        System.out.println("\n=== 正常状态下 ===\n");
        role.attack();
        role.move();

        System.out.println("\n=== 受伤状态 ===\n");
        role.takeDamage(80);
        role.showStatus();
        role.attack();
        role.move();

        System.out.println("\n=== 恢复生命值，回到正常状态 ===\n");
        role.heal(30);
        role.showStatus();
        role.attack();

        System.out.println("\n=== 中毒状态===\n");
        role.setState(new PoisonedState());
        role.showStatus();
        role.attack();
        role.move();
        role.takeDamage(10);

        System.out.println("\n=== 收到致命一击,死亡状态 ===\n");
        role.takeDamage(50);
        role.showStatus();
        role.attack();
        role.move();

        System.out.println("\n=== 尝试复活 ===\n");
        role.heal(30);
        role.heal(70);
        role.showStatus();

    }
}
