package lesson09;

import java.util.*;

public class ListC<E> implements List<E> {

    //Создайте аналог списка БЕЗ использования других классов СТАНДАРТНОЙ БИБЛИОТЕКИ

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Обязательные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    private E[] elements= (E[]) new Object[]{};
    private int size=0;
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        String delimiter="";
        for (int i=0;i<size;i++){
            stringBuilder.append(delimiter).append(elements[i]);
            delimiter=", ";
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public boolean add(E e) {
        if (size==elements.length)
            elements= Arrays.copyOf(elements, (size * 3)/2+1);
        elements[size++]=e;
        return true;
    }

    @Override
    public E remove(int index) {
        E delete=elements[index];
        System.arraycopy(elements,index+1,elements,index,size-1-index);
        size--;
        return delete;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, E element) {
        if (size==elements.length)
            elements= Arrays.copyOf(elements, (size * 3)/2+1);
        System.arraycopy(elements,index,elements,index+1,size-index);
        elements[index]=element;
        size++;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > -1)
            remove(index);
        return (index > -1);
    }

    @Override
    public E set(int index, E element) {
        if (index>-1 && size>index) {
            E el = elements[index];
            elements[index] = element;
            return el;
        }
        return null;
    }


    @Override
    public boolean isEmpty() {
        return (size==0);
    }


    @Override
    public void clear() {
        for(int i=0;i<size;i++){
            elements[i]=null;
        }
        size=0;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null){
            for (int i = 0; i < size; i++) {
                if (elements[i]==null)
                    return i;
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i]))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public boolean contains(Object o) {
        for(int i=0;i<size;i++){
            if(elements[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex=-1;
        for(int i=0;i<size;i++){
            if(elements[i].equals(o)){
                lastIndex=i;
            }
        }
        return lastIndex;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for(Object el:c){
            if(!this.contains(el)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if(c.size()==0){
            return false;
        }
        for(Object el:c){
            this.add((E) el);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if(c.size()==0){
            return false;
        }
        for(Object el:c){
            this.add(index++,(E) el);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed=false;
        for(Object el:c){
            while (this.contains(el)){
                this.remove((E) el);
                changed=true;
            }
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean changed=false;
        for(int i=size-1;i>-1;i--){
            Object el=this.get(i);
            if(!c.contains(el)){
                this.remove(i);
                changed=true;
            }
        }
        return changed;
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Опциональные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    ////////        Эти методы имплементировать необязательно    ////////////
    ////////        но они будут нужны для корректной отладки    ////////////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public Iterator<E> iterator() {
        return null;
    }


}