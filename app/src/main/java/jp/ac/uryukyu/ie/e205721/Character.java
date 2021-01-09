package jp.ac.uryukyu.ie.e205721;
import java.util.ArrayList;
/**
 * キャラクタークラス.
 * ArrayList haveCard; //持ち札
 */
public class Character {
    private ArrayList<String> haveCard = new ArrayList<String>();
    /**
     * 持ち札を返すメソッド.
     * @return haveCard 持ち札
     */
    public ArrayList getHaveCard(){
        return haveCard;
    }
    /**
     * カードを追加するメソッド.
     * @param _card 引いたカード
     */
    public void addCard(String _card){
        haveCard.add(_card);
    }
}
