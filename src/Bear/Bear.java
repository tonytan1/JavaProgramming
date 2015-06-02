package Bear;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * Created by tony.tan on 5/20/2015.
 */
public class Bear {
    private final String MAKER;
    private final String TYPE;

    public Bear(String maker, String type){
        MAKER =maker;
        TYPE = type;
    }

    public void display(){
        System.out.println(MAKER + " " + TYPE);
    }

}
