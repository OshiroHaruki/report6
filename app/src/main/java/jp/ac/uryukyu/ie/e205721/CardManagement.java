package jp.ac.uryukyu.ie.e205721;
import java.util.ArrayList;
public class CardManagement{
    //山札のリスト(あとで要素を削除したりするのでArrayList)
    public ArrayList<String> deck = new ArrayList<String>();
    //山札からカードを引くメソッド
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
}