import java.util.ArrayList;
import java.util.HashMap;

public class main {


    public static void main(String[] args) {

        String socks = "1/blue/right,2/blue/right,3/red/right,4/blue/left,5/purple/left,6/red/left,7/green/left,8/red/left,9/blue/left";

        HashMap<String, ArrayList<Sock>> sockHashMap = new HashMap<>();
        ArrayList<SockPair> matchingSockList = new ArrayList<>();


        for (String splitSock : socks.split(",")) {

            boolean matchFound = false;
            String[] splitSockVars = splitSock.split("/");

            Sock sock = new Sock(Integer.valueOf(splitSockVars[0]), splitSockVars[1], splitSockVars[2].equals("left"));

            //checking to see if map has the pair
            if (sockHashMap.containsKey(sock.color)) {

                for (Sock tmpSock : sockHashMap.get(sock.color)) {

                    if (tmpSock.isLeft != sock.isLeft) {
                        //removing sock from map since pair was found, leaving only socks needing a pair in
                        matchingSockList.add(new SockPair(tmpSock, sock));
                        sockHashMap.get(sock.color).remove(tmpSock);

                        if (sockHashMap.get(sock.color).size() == 0)
                            sockHashMap.remove(sock.color);

                        matchFound = true;
                        break;
                    }
                }

            }
            //adding sock to map, since no pair was found
            if (!matchFound) {
                sockHashMap.computeIfAbsent(sock.color, k -> new ArrayList<>());
                sockHashMap.get(sock.color).add(sock);
            }
        }

        for (SockPair pair : matchingSockList) {
            System.out.println(pair.sockOne.id + " " + pair.sockTwo.id);
        }

    }

}
