/**
 * Created by tony.tan on 5/22/2015.
 */

import java.util.Scanner;
import java.util.Map;
import java.util.Set;

public class CommunityDriver {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        Community community;
        Map<Integer, Citizen> citizens;
        Set<Integer> informedCitizens;

        //create the network
        System.out.print("Enter citizen and relation quantities:");
        community = new Community(stdIn.nextInt(),stdIn.nextInt());
        citizens = community.getCitizens();
        System.out.println("Citizen\tFriends");
        for(Integer id: citizens.keySet()){
            //use Citizen's toString method to display citizen info.
            System.out.println(citizens.get(id));
        }

        //propagate a message through it
        System.out.print("Enter information source ID:");
        informedCitizens = community.spreadWord(stdIn.nextInt());
        System.out.println("Citizen\tDelay");
        for(Integer citizenID: informedCitizens){
            System.out.printf("%d\t%d\n",
                    citizenID, citizens.get(citizenID).getDelay());
        }
    }
}
