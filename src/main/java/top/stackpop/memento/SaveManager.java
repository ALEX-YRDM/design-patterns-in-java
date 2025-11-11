package top.stackpop.memento;

import java.util.ArrayDeque;
import java.util.Deque;

public class SaveManager {
    
    private final Deque<GameMemento> saves = new ArrayDeque<>();

    private final Deque<GameMemento> redo = new ArrayDeque<>();

    public void save(GameMemento m){
        saves.push(m);
        redo.clear();
        System.out.println("[SaveManager] save -> undoSize=" + saves.size() + ", redoCleared");
    }

    public GameMemento loadPrev(Game current){
        if(saves.isEmpty()) {
            System.out.println("[SaveManager] loadPrev blocked -> undoSize=0");
            return null;
        }

        redo.push(current.save());
        GameMemento m = saves.pop();
        System.out.println("[SaveManager] loadPrev -> undoSize=" + saves.size() + ", redoSize=" + redo.size());
        return m;
    }

    public GameMemento loadNext(Game current){
        if(redo.isEmpty()) {
            System.out.println("[SaveManager] loadNext blocked -> redoSize=0");
            return null;
        }
        saves.push(current.save());
        GameMemento m = redo.pop();
        System.out.println("[SaveManager] loadNext -> undoSize=" + saves.size() + ", redoSize=" + redo.size());
        return m;
    }

    public boolean hasPrev(){
        return !saves.isEmpty();
    }

    public boolean hasNext(){
        return !redo.isEmpty();
    }

    public int saveCount(){
        return saves.size();
    }
}
