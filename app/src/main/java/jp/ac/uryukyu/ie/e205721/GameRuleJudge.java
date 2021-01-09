package jp.ac.uryukyu.ie.e205721;
import java.util.ArrayList;

public class GameRuleJudge{
    private int JUDGE_NUMBER = 21;
    private boolean isBurst = false;
    //持ち札から、現在の合計点数を出すメソッド
    public int calcPoint(ArrayList<String> haveCard){
        int havePoint = 0;
        for(var s : haveCard){
            if(s == "A"){
                havePoint += 11;//処理の簡略化のため、Aは11として計算する
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

    public boolean judgeBurst(int point){
        if(point > JUDGE_NUMBER){
            isBurst = true;
        }
        return isBurst;
    }

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