package FileBufferChannelPath;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by tonytan on 13/6/15.
 *
 * This channel buffered data to and from a file's table.
 */
public class ChanneledFileAccess {
    public final static int TEXT =12;
    public final static int RECORD = 4 +TEXT+8;

    //This adds one buffered record to a file channel.
    public void writeRecord(FileChannel channel,
                            int id, String string, double value) throws IOException
    {
        byte[] strBytes =
                Arrays.copyOfRange(string.getBytes(),0,TEXT);//if range beyond TEXT, discard. In case of too long....
        ByteBuffer buffer = ByteBuffer.allocate(RECORD);

        buffer.putInt(id).put(strBytes).putDouble(value);
        buffer.rewind();
        channel.write(buffer);
    }

    //this reads a specified record from a file channel.
    public void readRecord(FileChannel channel, int recordIndex) throws IOException
    {
        ByteBuffer buffer = ByteBuffer.allocate(RECORD);

        channel.read(buffer, recordIndex*RECORD);
        buffer.rewind();// delete mark and reset buffer's position to zero
        dispalyRecord(buffer);
    }

    private static void dispalyRecord(ByteBuffer buffer){
        int id;
        byte[] strBytes = new byte[TEXT];
        double value;

        id = buffer.getInt();
        buffer.get(strBytes);
        value = buffer.getDouble();
        System.out.printf("%4d %10s %6.1f\n",
                id, new String(strBytes),value);
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        ChanneledFileAccess cio = new ChanneledFileAccess();
        ByteBuffer mappedBuffer = ByteBuffer.allocate(3*RECORD);

        System.out.print("Enter filename: ");
        Path path = Paths.get(stdIn.nextLine());
        try (FileChannel channel = FileChannel.open(
                path, StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,StandardOpenOption.READ))
        {
            cio.writeRecord(channel, 1, "first", 1.0);
            cio.writeRecord(channel, 2, "second", 2.0);
            cio.writeRecord(channel, 3, "third", 3.0);
            System.out.print("Enter file record index(0,1,2): ");
            cio.readRecord(channel, stdIn.nextInt());
            mappedBuffer = channel.map(
                    FileChannel.MapMode.READ_WRITE, 0, channel.size());
        }
        catch (IOException e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
        //now channel is gone, but mappedBuffer still exists.
        System.out.print("Enter map's record index(0,1,2): ");
        dispalyRecord(mappedBuffer);
    }
}

/**
 * mark: to work with file channels, include these imports.
 */
//import java.nio.channels.FileChannel
//import java.nio.file.*;// Path, Paths, Files, StandardOpenOption
/**
 * mark: to specify the file you want, create a new Path.
 */
// System.out.print("Enter filename: ");
//Path path = Paths.get(stdIn.nextLine);
/**
 * mark: to open the file for either reading or writing(over any pre-existing data),
 * in a try-with-resource header
 */
//try(FileChannel channel = FileChannel.open
//        (Path, StandardOpenOption.CREATE,
//        StandardOpenOption.WRITE,
//        StandardOpenOption.Read))
//{
// .....
//}