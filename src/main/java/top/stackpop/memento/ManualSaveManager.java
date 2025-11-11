package top.stackpop.memento;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ManualSaveManager {
    
    private final Map<String,GameMemento> slots = new LinkedHashMap<>();

    private int maxSlots = 30;

    public ManualSaveManager(){}

    public ManualSaveManager(int maxSlots) {
        this.maxSlots = maxSlots;
    }

    public boolean save(String slotName,GameMemento memento){
        if (slotName == null || slotName.isBlank() || memento == null) return false;
        if(!slots.containsKey(slotName) && slots.size()>=maxSlots){
            String oldest = slots.keySet().iterator().next();
            slots.remove(oldest);
            System.out.println("[ManualSaveManager] capacity full, evict oldest: " + oldest);
        }
        slots.put(slotName, memento);
        System.out.println("[ManualSaveManager] save slot='" + slotName + "', ts=" + memento.getTimestamp()
                + ", pos=" + memento.getPosition() + ", total=" + slots.size());
        return true;
    }
    public GameMemento load(String slotName) {
        GameMemento m = slots.get(slotName); // 读档不移除
        System.out.println("[ManualSaveManager] load slot='" + slotName + "' -> "
                + (m == null ? "null" : ("ts=" + m.getTimestamp() + ", pos=" + m.getPosition())));
        return m;
    }

    public boolean remove(String slotName) {
        boolean ok = slots.remove(slotName) != null;
        System.out.println("[ManualSaveManager] remove slot='" + slotName + "' -> " + ok + ", total=" + slots.size());
        return ok;
    }
    
    public Map<String, GameMemento> all() {
        System.out.println("[ManualSaveManager] list all -> total=" + slots.size());
        return Collections.unmodifiableMap(slots);
    }
}
