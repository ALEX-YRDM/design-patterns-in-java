package top.stackpop.adapter;

public class MkvPlayer implements AdvancedMediaPlayer{

    /**
     * MKv播放器具体实现
     */
    @Override
    public void playMkv(String filename) {
        // TODO Auto-generated method stub
        System.out.println("start mkv player to play "+filename);
        
    }

    @Override
    public void playMp4(String filename) {
        // can not play
        
    }
    
    
}
