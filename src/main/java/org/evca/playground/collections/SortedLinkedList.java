package org.evca.playground.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SortedLinkedList implements Collection<Integer> {

    private final LinkedList<Integer> data;

    public SortedLinkedList() {
        this.data = new LinkedList<>();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return data.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return data.iterator();
    }

    @Override
    public Object[] toArray() {
        return data.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return data.toArray(a);
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return data.toArray(generator);
    }

    @Override
    public boolean add(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Only not null elements are supported");
        }
        if (data.isEmpty() || data.getLast().compareTo(item) <= 0) {
            return data.add(item);
        }

        int position = 0;
        Iterator<Integer> iterator = data.iterator();
        while (iterator.hasNext()) {
            Integer node = iterator.next();
            if (node.compareTo(item) > 0) {
                data.add(position, item);
                return true;
            }
            position++;
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        return data.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return data.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> items) {
        if (items.isEmpty()) {
            return false;
        }
        items.forEach(this::add);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return data.removeAll(c);
    }

    @Override
    public boolean removeIf(Predicate<? super Integer> filter) {
        return data.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return data.retainAll(c);
    }

    @Override
    public void clear() {
        data.clear();
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return data.spliterator();
    }

    @Override
    public Stream<Integer> stream() {
        return data.stream();
    }

    @Override
    public Stream<Integer> parallelStream() {
        return data.parallelStream();
    }

    @Override
    public String toString() {
        return "SortedLinkedList{" +
                "data=" + data +
                '}';
    }

}
