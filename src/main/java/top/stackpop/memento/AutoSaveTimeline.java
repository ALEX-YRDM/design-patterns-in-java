package top.stackpop.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * 时间线式自动存档
 */
public class AutoSaveTimeline {
    
    private final List<GameMemento> timeline =new ArrayList<>();
    //指向当前所处快照索引 -1表示还没有读档
    private int cursor = -1;

    public void append(GameMemento memento){
        timeline.add(memento);
        System.out.println("[AutoSaveTimeline] append -> size=" + timeline.size()
                + ", lastTs=" + memento.getTimestamp()
                + ", lastPos=" + memento.getPosition()
                + ", cursor=" + cursor);
    }
    

    public boolean canStepBack() {
        if (timeline.isEmpty()) return false;
        if (cursor == -1) return true;            // 实时 -> 可回退到最新
        return cursor > 0;                         // 还有更早的
    }
    
    public boolean canStepForward() {
        if (timeline.isEmpty()) return false;
        if (cursor == -1) return false;            // 实时态不可前进
        return cursor < timeline.size() - 1;        // 还有更新的
    }
    
    public GameMemento stepBack() {
        if (!canStepBack()) {
            System.out.println("[AutoSaveTimeline] stepBack blocked -> size=" + timeline.size() + ", cursor=" + cursor);
            return null;
        }
        int before = cursor;
        if (cursor == -1) {
            cursor = timeline.size() - 1;          // 实时 -> 最新
        } else {
            cursor = cursor - 1;                   // 往更早移动
        }
        GameMemento m = timeline.get(cursor);
        System.out.println("[AutoSaveTimeline] stepBack: " + before + " -> " + cursor
                + ", ts=" + m.getTimestamp() + ", pos=" + m.getPosition());
        return m;
    }
    
    public GameMemento stepForward() {
        if (!canStepForward()) {
            System.out.println("[AutoSaveTimeline] stepForward blocked -> size=" + timeline.size() + ", cursor=" + cursor);
            return null;
        }
        int before = cursor;
        cursor = cursor + 1;                       // 往更新移动
        GameMemento m = timeline.get(cursor);
        System.out.println("[AutoSaveTimeline] stepForward: " + before + " -> " + cursor
                + ", ts=" + m.getTimestamp() + ", pos=" + m.getPosition());
        return m;
    }
    
    public GameMemento latest() {
        if (timeline.isEmpty()) {
            System.out.println("[AutoSaveTimeline] latest -> empty");
            return null;
        }
        cursor = timeline.size() - 1;
        GameMemento m = timeline.get(cursor);
        System.out.println("[AutoSaveTimeline] latest -> cursor=" + cursor
                + ", ts=" + m.getTimestamp() + ", pos=" + m.getPosition());
        return m;
    }

    public void resetCursor() {
        System.out.println("[AutoSaveTimeline] resetCursor: " + cursor + " -> -1");
        cursor = -1;
    }

    public int size() { return timeline.size(); }

    public GameMemento getAt(int index) {
        if (index < 0 || index >= timeline.size()) return null;
        return timeline.get(index);
    }
}
