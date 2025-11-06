package top.stackpop.adapter;


public class AudioPlayer implements MediaPlayer{

    /**
     * 原生支持mp3格式播放，对于mkv和mp4使用适配器支持
     */
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String mediaType, String filename) {
        if(mediaType.equalsIgnoreCase("mp3")){
            System.out.println("audio player is playing "+filename);
        }else if(mediaType.equalsIgnoreCase("mkv") || mediaType.equalsIgnoreCase("mp4")){
            mediaAdapter = new MediaAdapter(mediaType);
            mediaAdapter.play(mediaType, filename);
        }else {
            System.out.println("Invalid media. " + mediaType + " format not supported");
        }
    }

    
    
}
