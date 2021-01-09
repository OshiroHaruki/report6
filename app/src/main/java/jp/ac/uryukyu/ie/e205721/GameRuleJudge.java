package jp.ac.uryukyu.ie.e205721;
import java.util.ArrayList;
/**
 * ゲームルールの判定を行うメソッド.
 * int JUDGE_NUMBER=21; 21の定数.
 * boolean isBurst; バーストしたか. true=バースト,false=バーストしてない
 */
public class GameRuleJudge{
    private int JUDGE_NUMBER = 21;
    private boolean isBurst = false;
    /**
     * 持ち札から、現在の合計点数を出すメソッド.
     * 処理簡略化で、Aは11として計算(余裕があれば1or11で計算できるようにしたい)
     * @param haveCard 持ち札
     * @return havePoint 合計点数
     */
    public int calcPoint(ArrayList<String> haveCard){
        int havePoint = 0;
        for(var s : haveCard){
            if(s == "A"){
                havePoint += 11;
            }
            else if(s == "J" || s == "Q" || s == "K"){
                havePoint += 10;
            }
            else{
                havePoint += Integer.parseInt(s);
            }
        }
        return havePoint;
    }
    /**
     * バーストしたか判定する.
     * @param point 持ち点.これが21を超えるか判定する
     * @return isBurst バーストしたかどうか.
     */
    public boolean judgeBurst(int point){
        if(point > JUDGE_NUMBER){
            isBurst = true;
        }
        return isBurst;
    }
    /**
     * どちらが21に近いか判定する.
     * @param player プレイヤー
     * @param dealer ディーラー
     */
    public void judgeWhichNear(Player player, Dealer dealer){
        int playerScore = JUDGE_NUMBER - calcPoint(player.getHaveCard());
        int dealerScore = JUDGE_NUMBER - calcPoint(dealer.getHaveCard());
        if(playerScore < dealerScore){
            System.out.println("あなたの勝ちです！");
        }
        else if(dealerScore < playerScore){
            System.out.println("YOU LOSE...");
        }
        else if(playerScore == dealerScore){
            System.out.println("引き分け");
        }
    }
}