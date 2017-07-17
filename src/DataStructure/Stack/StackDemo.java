package DataStructure.Stack;

/**
 * This is a stack demo implement by array.
 * Created by tonytan on 20/5/2017.
 */
public class StackDemo implements StackInterface{
    private int initCapacity = 10;
    private double increaseFactor = 2;
    private Object[] array = new Object[10];
    private int dataLength = 0;

    public StackDemo(){};

    public StackDemo(int capacity){
        this.initCapacity = capacity;
    }

    @Override
    public Object pop() {
        if (isEmpty()){
            throw new NullPointerException();
        }
        dataLength--;
        return array[dataLength];
    }

    @Override
    public Object peek() {
        return array[dataLength-1];
    }

    @Override
    public void push(Object object) {
        if (dataLength >= array.length){
            array = increaseCapacity();
        }
        array[dataLength] = object;
        dataLength++;
    }

    @Override
    public boolean isEmpty() {
        return dataLength == 0;
    }

    private Object[] increaseCapacity(){
        Object[] dest = new Object[(int)(array.length*increaseFactor)];
        System.arraycopy(array, 0, dest,0, array.length);

        return dest;
    }
}
