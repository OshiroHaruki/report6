package jp.ac.uryukyu.ie.e205721;
public class GameMaster{
    //プレイヤーのインスタンス
    //ディーラーのインスタンス
    //山札のインスタンス
    
    //ターン回しをするメソッド
    //プレイヤーターンに行うメソッド
    //ディーラーターンに行うメソッド
    //勝利判定を行うメソッド
    //21を超えた時に行うメソッド


    //実験用コード
    public void prepareDeck(){
        CardManagement newDeck = new CardManagement();
        newDeck.Shahhuru();

        System.out.println(newDeck.deck);
    }
}
