package DesignPattern.BuilderPattern;

/**
 *
 * Created by tonytan on 17/4/2017.
 */
public class TextBuilder extends Buidler {
    private StringBuffer buffer = new StringBuffer();

    @Override
    public void makeTitle(String title) {
        buffer.append("[");
        buffer.append(title);
        buffer.append("]\n");
    }

    @Override
    public void makeString(String str) {
        buffer.append("=========================\n");
        buffer.append(str);
        buffer.append("\n=========================\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (int i = 0; i < items.length; i++) {
            buffer.append("-" + items[i] + "\n");
        }
    }

    @Override
    public void close() {
        buffer.append("=========================");
    }

    public String getResult() {
        return buffer.toString();
    }
}
