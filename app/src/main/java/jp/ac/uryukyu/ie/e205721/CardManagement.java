package jp.ac.uryukyu.ie.e205721;
import java.util.ArrayList;
import java.util.Random;
/**
 * 山札を管理するクラス.
 * ArrayList deck; 山札
 */
public class CardManagement{
    private ArrayList<String> deck = new ArrayList<String>();
    /**
     * 山札を用意するメソッド.
     */
    public void shuffle(){
        for(int i = 1; i < 14; i++){
            if (i == 1){
                deck.add("A");
            }
            else if (i < 11){
                deck.add(Integer.toString(i));
            }
            else if (i == 11){
                deck.add("J");
            }
            else if (i == 12){
                deck.add("Q");
            }
            else if (i == 13){
                deck.add("K");
            }
        }
    }
    /**
     * カードを引くメソッド.
     * 引いたカードは山札から削除
     * @return drawedCard 引いたカード
     */
    public String drawCard(){
        String drawedCard = "";
        Random randomInt = new Random();
        int numOfDecks = deck.size();
        int randomValue = randomInt.nextInt(numOfDecks);
        drawedCard = deck.get(randomValue);
        deck.remove(randomValue);
        return drawedCard;
    }
    /**
     * 山札を確認するメソッド
     * @return deck 山札
     */
    public ArrayList<String> getDeck(){
        return deck;
    }
}