package cmsc256;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class ArrayBasedStack<T> implements StackInterface<T> {
    private T[] data;
    private int topOfStack;
    private static final int INITIAL_CAPACITY = 5;


    public ArrayBasedStack() {
        clear();
    }

    @SuppressWarnings("unchecked")
    public ArrayBasedStack(int capacity){

        if(capacity <= 0) {

            throw new IllegalArgumentException("Array initial size error.");

        }



        T[] tempStack = (T[])new Object[capacity];

        data = tempStack;

        topOfStack = -1;

    }


    private void expandArray() {
        int newLength = data.length * 2;

        T[] tempStack = Arrays.copyOf(data, newLength);
        data = tempStack;
    }

    private boolean isArrayFull() {
        if (topOfStack >= data.length - 1) {
            return true;
        }
        return false;
    }


    @Override
    public void push(T newEntry) {
        if (isArrayFull()) {
            expandArray();
            data[topOfStack + 1] = newEntry;
            topOfStack++;
        }

        data[topOfStack + 1] = newEntry;
        topOfStack++;
    }

    @Override
    public T pop()throws EmptyStackException{
        if (isEmpty()) {
            throw new EmptyStackException("Stack cannot be empty");
        }
        T temp = data[topOfStack];
        data[topOfStack] = null;
        topOfStack--;

        return temp;
    }

    @Override
    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Stack cannot be empty");
        }
        return data[topOfStack];
    }

    @Override
    public boolean isEmpty() {
        if (topOfStack < 0) {
            return true;
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {


        T[] tempStack = (T[])new Object[INITIAL_CAPACITY];

        data = tempStack;

        topOfStack = -1;
    }
}
