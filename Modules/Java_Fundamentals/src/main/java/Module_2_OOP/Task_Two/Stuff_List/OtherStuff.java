package Module_2_OOP.Task_Two.Stuff_List;

import java.util.Arrays;


@SuppressWarnings({"unchecked"})
public class OtherStuff <T> {

    private T[] otherStuffs;

    private int capacity;

    private int size = 0;

    int standard_size = 10;

    public OtherStuff(int size) {

        otherStuffs = (T[]) new Object[size];
        capacity = size;
    }


    public OtherStuff() {

        otherStuffs = (T[]) new Object[standard_size];
        capacity = standard_size;
    }






    public void add(T otherStuff) {

        check_capacity();
        this.otherStuffs[this.size++] = otherStuff;
    }


    public void add(T[] newStuffs) {

        if ((getCapacity() - getSize()) - newStuffs.length < 0) {

            ensure_capacity((newStuffs.length - getCapacity() - getSize()) + 1);
        }

        for (T newStuff : newStuffs) {
            this.otherStuffs[this.size++] = newStuff;
        }

    }


    public T get(int index) {

        if (index > size || index >= capacity) {
            throw new NullPointerException("Out of bounds exception");
        }

        return otherStuffs[index];
    }

    public T[] get(int start, int end) {
        if (start > size || end >= getCapacity()) {
            throw new NullPointerException("Out of bounds exception");
        }
        return Arrays.copyOfRange(otherStuffs, start, end);
    }


    private void ensure_capacity() {
        this.capacity = (this.capacity*3)/2 + 1;
        otherStuffs = Arrays.copyOf(otherStuffs, capacity);
    }

    private void ensure_capacity(int len) {
        this.capacity = getCapacity() + len + 1;
        otherStuffs =  Arrays.copyOf(otherStuffs, capacity);
    }

    private void check_capacity() {

        if (getSize() >= getCapacity()) {
           ensure_capacity();
        }

    }


    public int getSize() {
        return size;
    }


    public int getCapacity() {
        return capacity;
    }


    public <T extends Stuff> T[] getOtherStuffs() {
        return (T[]) this.otherStuffs;
    }

    public void add(OtherStuff<T> otherStuff) {

        for (int i =0; i<otherStuff.getSize(); i++) {
            add(otherStuff.get(i));
        }
    }
}
