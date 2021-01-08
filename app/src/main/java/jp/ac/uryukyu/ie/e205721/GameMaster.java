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
    public void playerTurn(){
        System.out.println("あなたのターン");
        while(!player.getIsEndTurn()){//isEndTurnがfalseの間繰り返す
            System.out.println("あなたの手札: " + player.haveCard);
            int selectNumber = player.selectAction();
            if(selectNumber == 0){
                player.addCard(deck.drawCard());
            }
            else if(selectNumber == 1){
                player.call();
            }
        }

        
    }
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
