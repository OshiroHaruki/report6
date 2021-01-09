package jp.ac.uryukyu.ie.e205721;
import java.util.ArrayList;

public class Dealer extends Charactor{
    public void showCard(){//haveCardの内1枚公開するメソッド
        System.out.println("ディーラーのカード:" + getHaveCard().get(0) + ",■");
    }
    public void showAllCard(){//すべてのカードを公開するメソッド
        System.out.println(getHaveCard());
    }
}
