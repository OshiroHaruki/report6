package jp.ac.uryukyu.ie.e205721;

import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Charactor{
    //カードを所有
    //public ArrayList<String> haveCard = new ArrayList<String>();
    private boolean isEndTurn = false;
    //カードを引くメソッド(引数: カード)
    /*
    public void addCard(String _card){
        haveCard.add(_card);
    }*/
    //自分の番で行う行動を選択するメソッド
    public int selectAction(){
        System.out.println("0 : カードを引く");
        System.out.println("1 : ターンを終了");
        Scanner action = new Scanner(System.in);
        int selectedNumber = action.nextInt();
        return selectedNumber;
    }
    //コールするメソッド
    public void call(){
        isEndTurn = true;
    }

    //isEndTurnの値を返すgetterメソッド
    public boolean getIsEndTurn(){
        return isEndTurn;
    }
    
}
