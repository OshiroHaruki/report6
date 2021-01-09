package jp.ac.uryukyu.ie.e205721;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * プレイヤークラス.
 * Characterクラスを継承
 * boolean isEndTurn; //ターンを終了するかどうか。true=ターン終了,false=ターン続行.
 */
public class Player extends Character{
    private boolean isEndTurn = false;
    
    /**
     * 自分の番で行う行動を選択するメソッド.
     * 選択肢を表示して、数字の入力を求める
     * @return selectedNumber 選択した数字
     */
    public int selectAction(){
        System.out.println("0 : カードを引く");
        System.out.println("1 : ターンを終了");
        Scanner action = new Scanner(System.in);
        int selectedNumber = action.nextInt();
        return selectedNumber;
    }
    /**
     * スタンド(ターン終了)するメソッド
     */
    public void stand(){
        isEndTurn = true;
    }
    /**
     * isEndTurnの値を返すgetterメソッド
     * @return isEndTurn ターン終了をするかどうか.
     */
    public boolean getIsEndTurn(){
        return isEndTurn;
    }
    
}
