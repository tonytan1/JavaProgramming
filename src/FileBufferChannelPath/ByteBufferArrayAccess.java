package FileBufferChannelPath;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by tonytan on 13/6/15.
 *
 * This buffers: byte array, string, and double array.
 */
public class ByteBufferArrayAccess {
    public static void main(String[] args){
        int[] ints = new int[]{ 1,1,2,3,5,8};
        String str =
                "The purpose of computing is insight, not numbers.";
        double[] doubles = new double[] {1.0,2.0,1.5,1.67,1.6};
        byte[] strBytes = str.getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(
                4*ints.length + strBytes.length+8*doubles.length);

        //put to buffer
        buffer.asIntBuffer().put(ints);
        buffer.position(4*ints.length);
        buffer.put(strBytes).asDoubleBuffer().put(doubles);

        //fill working arrays with zeros and rewind buffer
        Arrays.fill(ints, 0);//initialization. zero.
        Arrays.fill(strBytes, (byte)0);//make sure the result is not
        Arrays.fill(doubles, 0.0);// the leftover initial value.
        str = "";
        buffer.rewind();

        //get from buffer
        buffer.asIntBuffer().get(ints);
        buffer.position(4*ints.length);
        buffer.get(strBytes).asDoubleBuffer().get(doubles);
        str = new String(strBytes);

        //display transferred data
        System.out.println(Arrays.toString(ints));
        System.out.println(str);
        System.out.println(Arrays.toString(doubles));
    }
}
