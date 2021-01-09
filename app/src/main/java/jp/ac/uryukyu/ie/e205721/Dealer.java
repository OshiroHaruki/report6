package jp.ac.uryukyu.ie.e205721;
import java.util.ArrayList;
/**
 * ディーラークラス.
 * Characterクラスを継承
 */
public class Dealer extends Character{
    /**
     * haveCardの内1枚だけ公開するメソッド
     */
    public void showCard(){
        System.out.println("ディーラーのカード:" + getHaveCard().get(0) + ",■");
    }
    /**
     * すべてのカードを公開するメソッド
     */
    public void showAllCard(){
        System.out.println(getHaveCard());
    }
}
