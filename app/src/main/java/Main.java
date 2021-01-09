import java.util.NoSuchElementException;

import jp.ac.uryukyu.ie.e205721.*;
/**
 * 実行のためのMainクラス.
 */
public class Main {
    /**
     * メインメソッド.
     */
    public static void main(String[] args){
        try{
            System.out.println("Let's Play Game!");
            
            GameMaster Oshiro = new GameMaster();//GameMasterを召喚
            Oshiro.playGame();
        }
        catch (NoSuchElementException e){
            System.out.println("error: NoSuchElementException");
            System.out.println("半角で'0'か'1'を入力してください!");
            //System.out.println(e.getMessage());
        } 
    }
}
