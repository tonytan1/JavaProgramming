package ShowMeCode.Concurrency;

/**
 * Created by tony.tan on 6/24/2015.
 */
public class Producer1 implements Runnable{
    private FileMock mock;

    private Buffer buffer;

    public Producer1(FileMock mock, Buffer buffer){
        this.mock = mock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setPendingLines(true);
        while (mock.hasMoreLines()){
            String line=mock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
}
