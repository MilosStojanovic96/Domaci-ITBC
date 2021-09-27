package skup.mset;


import java.util.*;

public class HashMSet<E> extends HashSet<E> {

    private HashMap<E, Integer> map;

    public HashMSet() {
        super();
        populate();
    }

    public HashMSet(Collection<? extends E> c) {
        super(c);
        populate();
    }

    public HashMSet(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
        populate();
    }

    public HashMSet(int initialCapacity) {
        super(initialCapacity);
        populate();
    }

    private void populate(){
        map = new HashMap<>();
        Iterator<E> it = super.iterator();
        while(it.hasNext())
            map.put(it.next(), 1);
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean add(E e) {
        if (map.containsKey(e))
            map.put(e, map.get(e) + 1);
        else
            map.put(e, 1);
        return true;
    }

    public boolean add(E e, int count){
        if (map.containsKey(e))
            map.put(e, map.get(e) + count);
        else
            map.put(e, count);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (map.containsKey(o)){
            if (map.get(o) > 1)
                map.put((E)o, map.get(o) - 1);
            else
                map.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        map.clear();
    }

    public String toStringMath() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(Map.Entry<E, Integer> e : map.entrySet())
            for (int i = 0; i < e.getValue(); i++)
                sb.append(e.getKey()).append(", ");

        String res = sb.substring(0, sb.length() - 2);
        return res.concat("}");
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
