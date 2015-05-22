/**
 * Created by tony.tan on 5/22/2015.
 *
 * this represents an element in a network of citizens.
 */

import java.util.Set;
import java.util.TreeSet;

public class Citizen {
    private static int nextID = 0;
    public final int ID = nextID++;
    private Set<Integer> friends = new TreeSet<>();
    private int delay;

    public void addFriend(int FriendID){
        this.friends.add(FriendID);
    }

    public Set<Integer> getFriends(){
        return this.friends;
    }

    public void setDelay (int delay){
        this.delay = delay;
    }

    public int getDelay(){
        return this.delay;
    }

    public String toString(){
        return String.format("%d\t%s", ID, friends);
    }
}
