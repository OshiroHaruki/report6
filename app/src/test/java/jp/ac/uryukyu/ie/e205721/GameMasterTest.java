package jp.ac.uryukyu.ie.e205721;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameMasterTest {
    /**
     * GameMasterクラスのテスト
     * プレイヤーがバーストしたとき、ちゃんと21点を超えているか検証
     * 検証手順
     * (1)プレイヤーバーストするまでカードをドロー
     * (2)プレイヤーの点数が21点を超えているか(点数>21か)検証
     * 以上を検証。
     */
    @Test
    void burstTest(){
        Player demoPlayer = new Player();
        CardManagement deck = new CardManagement();
        deck.shuffle();
        GameRuleJudge gameRuleJudge = new GameRuleJudge();
        int playerPoint = 0; //この値が
        int JUDGE_NUMBER = 21;//この値を超えるか検証
        while (true){
            demoPlayer.addCard(deck.drawCard());
            playerPoint = gameRuleJudge.calcPoint(demoPlayer.getHaveCard());
            if(gameRuleJudge.judgeBurst(playerPoint)){
                break;
            }
        }
        assertTrue(playerPoint > JUDGE_NUMBER);
    }
}
