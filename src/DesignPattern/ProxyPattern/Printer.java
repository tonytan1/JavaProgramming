package DesignPattern.ProxyPattern;

/**
 *
 * Created by tonytan on 7/5/2017.
 */
public class Printer implements Printable{
    private String name;

    public Printer(String name){
        this.name = name;
    }

    @Override
    public void setPrinterName(String name) {
        this.name = name;
    }

    @Override
    public String getPrinterName() {
        return name;
    }

    @Override
    public void print(String string) {
        System.out.println("===="+name+"=====");
        heavyJob(string);
    }

    private void heavyJob(String msg) {
        System.out.print(msg);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.print(".");
        }
        System.out.println("End");
    }
}
