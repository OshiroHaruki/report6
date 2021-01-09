package jp.ac.uryukyu.ie.e205721;
/**
 * ゲームの進行等を行うクラス.
 * Player player; プレイヤーのインスタンス
 * Dealer dealer; ディーラーのインスタンス
 * CardManagement; カードマネジメントのインスタンス
 * GameRuleJudge; ゲームルールジャッジのインスタンス
 * boolean isBurstPlayer; プレイヤーがバーストしたかどうか. true=バースト、false=バーストしてない
 * boolean isBurstDealer; ディーラーがバーストしたかどうか. true=バースト、false=バーストしてない
 */
public class GameMaster{
    private Player player = new Player();
    private Dealer dealer = new Dealer();;
    private CardManagement deck = new CardManagement();
    private GameRuleJudge gameRuleJudge = new GameRuleJudge();
    private boolean isBurstPlayer = false;
    private boolean isBurstDealer = false;
    /**コンストラクタ.山札を用意して、初期手札を配る
     * 
    */
    public GameMaster(){
        prepareDeck();//山札を用意
        for(int i=0; i < 2; i++){//ディーラーにカードを二枚配る
            dealer.addCard(deck.drawCard());
        }
        player.addCard(deck.drawCard());//プレイヤーに一枚カードを配る
    }
    
    /**
     * ターン回しをするメソッド.
     */
    public void playGame(){
        dealer.showCard();
        playerTurn();
        if(!isBurstPlayer){
            dealerTurn();
            if(!isBurstDealer){
                judgeWin();
            }
        }
    }
    /**
     * プレイヤーターンに行うメソッド.
     * スタンドするまでカードを引ける
     * バーストしたらその時点で負け
     */
    public void playerTurn(){
        int playerPoint = gameRuleJudge.calcPoint(player.getHaveCard());
        System.out.println("あなたのターン");
        while(!player.getIsEndTurn()){//isEndTurnがfalseの間繰り返す
            System.out.println("あなたの手札: " + player.getHaveCard());
            System.out.println("あなたの点数: " + playerPoint);

            int selectNumber = player.selectAction();
            if(selectNumber == 0){//カードを引くを選択したとき
                player.addCard(deck.drawCard());
                playerPoint = gameRuleJudge.calcPoint(player.getHaveCard());

                if(gameRuleJudge.judgeBurst(playerPoint)){//バースト
                    System.out.println("あなたの手札: " + player.getHaveCard());
                    System.out.println("あなたの点数: " + playerPoint);
                    System.out.println("バーストです");
                    System.out.println("YOU LOSE...");
                    isBurstPlayer = true;
                    break;
                }
            }
            else if(selectNumber == 1){//スタンドを選択したとき
                player.stand();
                System.out.println("あなたの手札は"+ player.getHaveCard() + "で");
                System.out.println("点数は"+ playerPoint + "です");
            }
        }
    }
    /**
     * ディーラーターンに行うメソッド
     */
    public void dealerTurn(){
        dealer.showAllCard();
        int dealerPoint = gameRuleJudge.calcPoint(dealer.getHaveCard());
        while(dealerPoint < 17){
            System.out.println("ディーラーのカードの合計が17より小さいのでカードを引きます.");
            dealer.addCard(deck.drawCard());
            dealer.showAllCard();
            dealerPoint = gameRuleJudge.calcPoint(dealer.getHaveCard());
        }
        System.out.println("ディーラーの点数: " + dealerPoint);
        if(gameRuleJudge.judgeBurst(dealerPoint)){
            isBurstDealer = true;
            System.out.println("ディーラーがバーストしました");
            System.out.println("あなたの勝ちです！");
        }
    }
    /**
     * 勝利判定を行うメソッド
     */
    public void judgeWin(){
        gameRuleJudge.judgeWhichNear(player, dealer);
    }
    /**
     * 山札を用意するメソッド
     */
    public void prepareDeck(){
        deck.shuffle();
    }
}
