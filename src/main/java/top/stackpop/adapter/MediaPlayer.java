package top.stackpop.adapter;

/**
 * 客户端期望的接口
 */
public interface MediaPlayer {

    /**
     * 客户端只关心：媒体文件类型和文件名 不关心后台是如何实现的
     * @param mediaType
     * @param filename
     */
    void play(String mediaType, String filename);
} 
    
    


