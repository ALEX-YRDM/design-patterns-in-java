package top.stackpop.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class PagedIterable<T> implements Iterable<T> {

    private final int pageSize;

    private final BiFunction<Integer,Integer,List<T>> pageFetcher;

    public PagedIterable(int pageSize, BiFunction<Integer, Integer, List<T>> pageFetcher) {
        this.pageSize = pageSize;
        this.pageFetcher = pageFetcher;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int pageNo = 1;
            List<T> current = List.of();
            int idx = 0;
            boolean end  = false;

            @Override
            public boolean hasNext() {

                if(idx<current.size()) return true;
                if(end) return false;
                current = pageFetcher.apply(pageNo,pageSize);
                pageNo++;
                idx = 0;
                if(current == null || current.isEmpty()){
                    end = true;
                    return false;
                }
                return true;
            }

            @Override
            public T next() {
                if(!hasNext()) throw new NoSuchElementException();
                return current.get(idx++);
            }
            
            
        };
    }

    
    
    
}
