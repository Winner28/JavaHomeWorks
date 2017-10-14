package Module_Two_OOP.Task_WWFive;


import java.util.Arrays;



@SuppressWarnings({"unchecked"})
public class MyList <T> {

    private Object[] elementData;
    private int size;
    private static final Object[] DEFAULT_Obj= new Object[0];

    public MyList(int capacity) {
        elementData = new Object[capacity];
    }


    public MyList() {
        this.elementData = DEFAULT_Obj;
    }


    public T get(int index) {
        checkIndex(index);
        return (T) elementData[index];
    }

    public void add(T object) {
       checkCapacity();
       this.elementData[size++] = object;
    }



    private void checkIndex(int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkCapacity() {
        if (this.size >= elementData.length-1) {
            this.elementData = Arrays.copyOf(this.elementData, (this.elementData.length*3)/2 + 1);
        }
    }

    public int getSize() {
        return size;
    }
}
