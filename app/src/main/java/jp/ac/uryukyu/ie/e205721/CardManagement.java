package jp.ac.uryukyu.ie.e205721;
import java.util.ArrayList;
import java.util.Random;
public class CardManagement{
    //山札のリスト(あとで要素を削除したりするのでArrayList)
    private ArrayList<String> deck = new ArrayList<String>();
    //山札を用意するメソッド
    public void Shahhuru(){
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
    //カードを引くメソッド
    public String drawCard(){
        String drawedCard = "";
        Random randomInt = new Random();
        int numOfDecks = deck.size();//山札の枚数
        int randomValue = randomInt.nextInt(numOfDecks);//引くカードをランダムに決定
        drawedCard = deck.get(randomValue);//引いたカードを変数に代入
        deck.remove(randomValue);//引いたカードは山札から削除
        return drawedCard;
    }
}