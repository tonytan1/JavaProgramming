package ShowMeCode; /**
 * Created by tony.tan on 5/22/2015.
 *
 * this describes community structure and behavior.
 */

import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.ArrayDeque;

public class Community {
    private Map<Integer, Citizen> citizens = new HashMap<>();

    //Postcondition: all connections are bidirectional(shuangxiang)

    public Community(int citizenQantity, int relationQuantity){
        Random random = new Random(0);// random generator; return a value of double [0.0,1.0)
        Citizen citizen;//any citizen object
        int self, other;//ID number

        for(int i=0; i<citizenQantity; i++){
            citizen = new Citizen();
            citizens.put(citizen.ID, citizen);
        }

        for(int j=0; j<relationQuantity; j++){
            self = random.nextInt(citizens.size());
            do {
                other = random.nextInt(citizens.size());//generate values 0< <size
            }while (other == self || citizens.get(self).getFriends().contains(other));
            citizens.get(self).addFriend(other);
            citizens.get(other).addFriend(self);
        }
    }

    public Map<Integer,Citizen> getCitizens(){
        return this.citizens;
    }

    //preconditon:sender is a part of an established network
    //postconditon: return set includes all connetctd citizens.

    public Set<Integer> spreadWord(int sender){
        Set<Integer> informedCitizens = new LinkedHashSet<>();
        Queue<Integer> senderQueue = new ArrayDeque<>();

        citizens.get(sender).setDelay(0);
        informedCitizens.add(sender);
        senderQueue.add(sender);
        do{
            sender = senderQueue.remove();
            for(Integer friend: citizens.get(sender).getFriends()){
                if(!informedCitizens.contains(friend)){
                    citizens.get(friend).setDelay(
                            citizens.get(sender).getDelay()+1
                    );
                    informedCitizens.add(friend);
                    senderQueue.add(friend);
                }
            }
        }while (!senderQueue.isEmpty());
        return informedCitizens;

    }
}
