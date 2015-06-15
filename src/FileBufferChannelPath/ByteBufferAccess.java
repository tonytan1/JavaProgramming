package FileBufferChannelPath;

import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;

/**
 * Created by tonytan on 13/6/15.
 *
 * This puts different primitive elements into one byte buffer.
 */
public class ByteBufferAccess {
    public static void main(String[] args){
        int bufLength = 4 + 7 + 8;//int + empty space + double
        ByteBuffer buffer1 = ByteBuffer.allocate(bufLength);
        ByteBuffer buffer2 = ByteBuffer.allocate(bufLength);

        //populate output buffer
        buffer1.putInt(2);
        System.out.println("afterIntPos= "+ buffer1.position());
        buffer1.putDouble(11, 2.0);
        System.out.println("afterDblPos= "+ buffer1.position());
        //Transfer everything to input buffer
        buffer1.rewind();//delete any mark and reset the buffer's position to zero.
        buffer2.put(buffer1);
        //display transferred data
        buffer2.flip();//set upper limit to the current position and then delete marks && set current position to zero.
        System.out.println(buffer2.getInt());
        System.out.println(buffer2.getDouble(11));
    }
}
