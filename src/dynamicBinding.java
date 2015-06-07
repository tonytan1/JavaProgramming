
import java.util.Objects;

/**
 * Created by tonytan on 7/6/15.
 *
 * show the dynamic binding.
 */
public class dynamicBinding {
    public static void main(String[] args){
        Object obj = new Dog();
        System.out.println(obj.toString());
        //System.out.println(obj.display);
        // the Object does not contain a method of dispaly ,
        // so compiler error.
    }
}

