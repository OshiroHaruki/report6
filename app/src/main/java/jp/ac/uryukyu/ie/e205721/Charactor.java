package jp.ac.uryukyu.ie.e205721;
import java.util.ArrayList;

public class Charactor {
    private ArrayList<String> haveCard = new ArrayList<String>();
    public ArrayList getHaveCard(){
        return haveCard;
    }
    public void addCard(String _card){
        haveCard.add(_card);
    }
}
