package DesignPattern.BuilderPattern;

/**
 *
 * Created by tonytan on 17/4/2017.
 */
public class MainTest {

    public static void main(String[] args) {
//        if (args.length != 1){
//            usage();
//            System.exit(0);
//        }
//
//        if (args[0].equals("text")) {
//            TextBuilder builder = new TextBuilder();
//            Director director = new Director(builder);
//            director.construct();
//            System.out.println(builder.getResult());
//        } else if (args[0].equals("html")) {
            HTMLBuilder builder = new HTMLBuilder();
            Director director = new Director(builder);
            director.construct();
            System.out.println(builder.getResult());
//        } else {
//            usage();
//            System.exit(0);
//
//        }
    }

    public static void usage() {
        System.out.println("Usage: java MainTest text");
        System.out.println("Usage: java MainTest html");
    }

}
