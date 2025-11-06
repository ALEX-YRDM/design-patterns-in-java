package top.stackpop.adapter;

public class Mp4Player implements AdvancedMediaPlayer{
    /**
     * MP4播放器具体实现
     */
    @Override
    public void playMkv(String filename) {
    }

    @Override
    public void playMp4(String filename) {
        System.out.println("start mp4 player to play "+filename);
    }
    
}
