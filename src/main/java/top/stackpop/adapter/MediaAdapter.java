package top.stackpop.adapter;

/**
 * 解耦： 将客户端和适配者解耦
 * 复用：让现有类在不修改的情况下被使用
 * 扩展：添加新的适配器来支持新的接口
 * 单一职责：适配器只负责接口转换
 */
public class MediaAdapter implements MediaPlayer{

    private AdvancedMediaPlayer advancedMediaPlayer;

    /**
     * 将以实现的Mkv和mp4 播放器适配到MediaPlayer客户端要使用的接口
     */
    public MediaAdapter(String mediaType) {
        if(mediaType.equalsIgnoreCase("mkv")){
            advancedMediaPlayer = new MkvPlayer();
        }else if(mediaType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new Mp4Player();
        }else{
            throw new IllegalArgumentException("unsupported mediatype: "+mediaType);
        }
    }


    @Override
    public void play(String mediaType, String filename) {
        if(mediaType.equalsIgnoreCase("mkv")){
            advancedMediaPlayer.playMkv(filename);
        }else if(mediaType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(filename);
        }
    }
    
}
