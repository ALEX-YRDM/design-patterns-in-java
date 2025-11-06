package top.stackpop.adapter;

import org.junit.Test;

public class AdapterTest {
    
    @Test
    public void test(){
        /**
         * 客户端只管调用，不管各种格式是如何适配的
         * Audio本身支持音频播放，对于mkv和mp4 使用适配器调用高级已经实现的高级播放器
         */
        MediaPlayer player = new AudioPlayer();

        player.play("mp3", "record2023.mp3");

        player.play("mp4", "movie1.mp4");

        player.play("mkv", "yes primer minister.mkv");

        player.play("avi", "yes minister.avi");
    }
}
