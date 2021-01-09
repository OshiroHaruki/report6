package jp.ac.uryukyu.ie.e205721;
import java.util.ArrayList;

public class GameRuleJudge{
    private int JUDGE_NUMBER = 21;
    public boolean isBurst = false;
    //カードから、現在の合計数を出すメソッド(引数 ArrayList: HaveCard)
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
}