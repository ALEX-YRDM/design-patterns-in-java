package top.stackpop.mediator;

import org.junit.Test;

public class MediatorTest {
    
    @Test
    public void test(){
        ChatMediator mediator=new ChatMediatorImpl();
        User user1 = new ChatUser("咲太");

        User user2 = new ChatUser("双叶");

        User user3 = new ChatUser("花枫");

        User user4 = new ChatUser("麻衣");

        User bot = new Bot("机器人🤖");
        mediator.register(user1);
        mediator.register(user2);
        mediator.register(user3);
        mediator.register(user4);
        mediator.register(bot);

        user1.send("今天麻衣学姐又穿着兔女郎服出现在图书馆了，差点吓到我。");
        user4.send("咲太，不过是想引起你的注意而已，别大惊小怪。");
        user2.send("别光看热闹，记得把实验报告交给我，我要用思春期症候群的数据。");
        user3.send("哥哥，我已经帮你把笔记准备好了，加油。");
        user1.send("谢谢花枫。顺便一提，麻衣学姐说需要帮忙的话得先报名排队。");
        user4.send("我可不会让你排到别人后面，乖乖先来找我。");
        user4.send("@bot,test");
        
    }
}
