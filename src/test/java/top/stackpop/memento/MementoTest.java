package top.stackpop.memento;

import org.junit.Test;

public class MementoTest {
    @Test
    public void test(){
        Game game = new Game("yrdm");

        SaveManager manager = new SaveManager();

        // 初始进度
        System.out.println("初始: " + game);
        manager.save(game.save());

        // 推图升级
        game.levelUp();
        game.moveTo("10,5");
        manager.save(game.save());
        System.out.println("阶段1: " + game);

        // 受伤推进
        game.hurt(60);
        game.moveTo("15,9");
        manager.save(game.save());
        System.out.println("阶段2: " + game);

        // 再受重创，想“读档回退”
        game.hurt(80);
        System.out.println("意外: " + game);

        // 读档到上一次安全点
        if (manager.hasPrev()) {
            game.load(manager.loadPrev(game));
            System.out.println("读档1: " + game);
        }
        if (manager.hasPrev()) {
            game.load(manager.loadPrev(game));
            System.out.println("读档2: " + game);
        }

        // 觉得回退太多，再“重做读档”前进一步
        if (manager.hasNext()) {
            game.load(manager.loadNext(game));
            System.out.println("重做: " + game);
        }
    }

    @Test
    public void testTwoManager(){
        Game game = new Game("Arthur");
        AutoSaveTimeline timeline = new AutoSaveTimeline();

        // 到达营地自动存档
        timeline.append(game.save());

        // 升级后再次自动存档
        game.levelUp();
        timeline.append(game.save());

        // 突发战斗受重伤，想读到上一个安全点
        GameMemento safePoint = timeline.stepBack(); // 不会删除这份快照
        if (safePoint != null) game.load(safePoint);

        // 觉得回退太多，再前进一步
        GameMemento newer = timeline.stepForward();
        if (newer != null) game.load(newer);

        // 命名存档（开放世界）
        ManualSaveManager manual = new ManualSaveManager(50); // 50个槽位
        manual.save("主线-城镇前", game.save());  // 手动保存
        manual.save("支线-猎熊前", game.save());

        // 随时读取任意一个命名存档
        GameMemento m1 = manual.load("主线-城镇前");
        if (m1 != null) game.load(m1);

        // 删除某个存档位
        manual.remove("支线-猎熊前");
    }
}
