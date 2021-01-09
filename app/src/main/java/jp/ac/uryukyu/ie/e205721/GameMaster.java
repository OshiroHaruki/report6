package jp.ac.uryukyu.ie.e205721;
public class GameMaster{
    //プレイヤーのインスタンス
    Player player;
    //ディーラーのインスタンス
    Dealer dealer;
    //山札のインスタンス
    CardManagement deck;
    //ゲームのルールのインスタンス
    GameRuleJudge gameRuleJudge;
    //途中でバーストしたかどうか
    private boolean isBurstPlayer = false;
    //コンストラクタ
    public GameMaster(){
        player = new Player();
        prepareDeck();
        player.addCard(deck.drawCard());
        //山札からカードがちゃんとひけたか確認
        //System.out.println(deck.deck);
        System.out.println(player.getHaveCard());

        //ゲームルールのインスタンス生成
        gameRuleJudge = new GameRuleJudge();

        //ディーラのインスタンス生成、最初にカードを２枚引かせる
        dealer = new Dealer();
        for(int i=0; i < 2; i++){
            dealer.addCard(deck.drawCard());
        }
        dealer.showCard();
    }
    
    //ターン回しをするメソッド
    public void playGame(){
        playerTurn();
        if(!isBurstPlayer){
            dealerTurn();
            judgeWin();
        }
    }
    //プレイヤーターンに行うメソッド
    public void playerTurn(){
        int playerPoint = gameRuleJudge.calcPoint(player.getHaveCard());
        System.out.println("あなたのターン");
        while(!player.getIsEndTurn()){//isEndTurnがfalseの間繰り返す
            System.out.println("あなたの手札: " + player.getHaveCard());
            //手札をポイントに変換できているかのテスト
            System.out.println("あなたの点数: " + playerPoint);
            int selectNumber = player.selectAction();
            if(selectNumber == 0){
                player.addCard(deck.drawCard());
                playerPoint = gameRuleJudge.calcPoint(player.getHaveCard());
                if(gameRuleJudge.judgeBurst(playerPoint)){
                    System.out.println(player.getHaveCard());
                    System.out.println(playerPoint);
                    System.out.println("YOU LOSE...");
                    isBurstPlayer = true;
                    break;
                }
            }
            else if(selectNumber == 1){
                player.call();
            }
        }
    }
    //ディーラーターンに行うメソッド
    public void dealerTurn(){
        dealer.showAllCard();
        int dealerPoint = gameRuleJudge.calcPoint(dealer.getHaveCard());
        System.out.println("ディーラーの点数: " + dealerPoint);
    }
    //勝利判定を行うメソッド
    public void judgeWin(){
        gameRuleJudge.judgeWhichNear(player, dealer);
    }

    //山札を用意するメソッド
    public void prepareDeck(){
        deck = new CardManagement();
        deck.Shahhuru();
        //山札を用意できたか確認
        //System.out.println(deck.deck);
    }
}
