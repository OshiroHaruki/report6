package jp.ac.uryukyu.ie.e205721;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Charactor{
    private boolean isEndTurn = false;
    
    //自分の番で行う行動を選択するメソッド
    public int selectAction(){
        System.out.println("0 : カードを引く");
        System.out.println("1 : ターンを終了");
        Scanner action = new Scanner(System.in);
        int selectedNumber = action.nextInt();
        return selectedNumber;
    }
    //スタンドするメソッド
    public void stand(){
        isEndTurn = true;
    }

    //isEndTurnの値を返すgetterメソッド
    public boolean getIsEndTurn(){
        return isEndTurn;
    }
    
}
