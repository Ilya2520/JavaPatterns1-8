package Prac3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MySet implements Set {
    private Lock lock;
    private Set<Object> a;

    public MySet() {
        this.lock = new ReentrantLock();
        this.a = new HashSet<>();
    }

    @Override
    public int size() {
        lock.lock();
        try{
            return this.a.size();
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        try{
            return this.a.size()==0;
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public boolean contains(Object o) {
        lock.lock();
        try{
            return this.a.contains(o);
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public Iterator iterator() {
        lock.lock();
        try{
            return this.a.iterator();
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public Object[] toArray() {
        lock.lock();
        try{
            return this.a.toArray();
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        lock.lock();
        try{
            System.out.println(Thread.currentThread()+"добавил элемент "+o);
            return this.a.add(o);
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public boolean remove(Object o) {
        lock.lock();
        try{
            return this.a.remove(o);
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        lock.lock();
        try{
            return this.a.addAll(c);
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public String toString() {

        return "MySet{" +
                "a=" + a +
                '}';
    }
}
