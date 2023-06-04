package Prac3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyMap implements Map {
    Semaphore sem=new Semaphore(2);
    HashMap<Object,Object> hs;

    public MyMap() {
        this.hs = new HashMap<>();
    }

    @Override
    public int size() {
        try {
            sem.acquire();
            return hs.size();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            sem.release();
        }
    }

    @Override
    public boolean isEmpty() {
        try {
            sem.acquire();
            return hs.isEmpty();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            sem.release();
        }

    }

    @Override
    public boolean containsKey(Object key) {
        try {
            sem.acquire();
            return hs.containsKey(key);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            sem.release();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        try {
            sem.acquire();
            return hs.get(key);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            sem.release();
        }
    }

    @Override
    public Object put(Object key, Object value) {

        try {
            System.out.println(Thread.currentThread()+" ожидает");
            sem.acquire();
            System.out.println(Thread.currentThread()+" получил доступ");
            System.out.println(Thread.currentThread().getName()+" добавил: "+key+" "+value);
            return hs.put(key,value);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            sem.release();
            System.out.println(Thread.currentThread()+" освободил доступ");
        }
    }

    @Override
    public Object remove(Object key) {

        try {
            sem.acquire();
            return hs.remove(key);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            sem.release();
        }
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }

    @Override
    public String toString() {
        return "MyMap{" +
                "hs=" + hs +
                '}';
    }
}
