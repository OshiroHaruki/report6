package jp.ac.uryukyu.ie.e205721;
public class GameMaster{
    //プレイヤーのインスタンス
    Player player;
    //ディーラーのインスタンス
    //山札のインスタンス
    CardManagement deck;

    //コンストラクタ
    public GameMaster(){
        player = new Player();
        prepareDeck();
        player.addCard(deck.drawCard());
        //山札からカードがちゃんとひけたか確認
        System.out.println(deck.deck);
        System.out.println(player.haveCard);
    }
    
    //ターン回しをするメソッド
    //プレイヤーターンに行うメソッド
    //ディーラーターンに行うメソッド
    //勝利判定を行うメソッド
    //21を超えた時に行うメソッド


    //実験用コード
    public void prepareDeck(){
        deck = new CardManagement();
        deck.Shahhuru();
        //山札を用意できたか確認
        System.out.println(deck.deck);
    }
}
