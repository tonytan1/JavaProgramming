package TypeAndASCIISet;

/**
 * Created by tonytan on 1/6/15.
 */
public class ASCIITest {
    public static void main(String[] args) {
        for (int code = 1; code < 27; code++) {
            char ch = (char) (code + '@');
            System.out.println(code + ". " + ch);
        }


    /*
    JVM operation form left to right, the type depends on the first converting.
    the following two cases show that.
     */

        char first = 'J';
        char last = 'D';

        System.out.println("Hello, "+first+last);//first convertin is String, so J&D are regard as String

        System.out.println(first+last+", hello!");//use ASCII to mathematical addition.

        System.out.println('A' - 'a');

    }

}
