package tw.com.nec.justin_chen.the36questions;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // 首頁
    ConstraintLayout homepage;
    TextView firstParagraph;
    TextView secondParagraph;
    Button firstSetBtn;
    Button secondSetBtn;
    Button thirdSetBtn;

    // 問題頁
    ConstraintLayout questionsPage;
    TextView questionsTextView;
    Button nextQuestionButton;
    Button homeButton;
    Button previousQuestionButton;
    ImageView levelImageView;

    // 分三組，一組12個問題
    HashMap<Integer, String> allQuestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 首頁的那些
        homepage = (ConstraintLayout) findViewById(R.id.homePage);
        firstParagraph = (TextView) findViewById(R.id.firstParagraph);
        secondParagraph = (TextView) findViewById(R.id.secondParagraph);
        firstSetBtn = (Button) findViewById(R.id.firstSet);
        secondSetBtn = (Button) findViewById(R.id.secondSet);
        thirdSetBtn = (Button) findViewById(R.id.thirdSet);
        homepage.setVisibility(View.VISIBLE); // 載入時可見

        // 問題頁
        questionsPage = (ConstraintLayout) findViewById(R.id.questionsPage);
        questionsTextView = (TextView) findViewById(R.id.questionsTextView);
        nextQuestionButton = (Button) findViewById(R.id.nextQuestionButton);
        previousQuestionButton = (Button) findViewById(R.id.previousQuestionButton);
        homeButton = (Button) findViewById(R.id.homeButton);
        levelImageView = (ImageView) findViewById(R.id.LevelImageView);
        questionsPage.setVisibility(View.INVISIBLE); // 載入時不可見

        // 載入問題
        loadQuestions();

    }

    private int getCurrentNumber(){
        // 取得目前題號
        String currentText = questionsTextView.getText().toString();
        int currentNum = Integer.parseInt(currentText.substring(0,currentText.indexOf(".")));
        return currentNum;
    }

    // Previous
    public void previousQuestion(View view){
        Toast toast;

        // 取得目前題號
        int currentNum = getCurrentNumber();

        // 清空目前的 questionsTextView
        questionsTextView.setText("");

        if(currentNum==1){
            // 回第36題
            questionsTextView.setText(allQuestions.get(36));
        } else {
            // 把上一題的文字，填到畫面
            questionsTextView.setText(allQuestions.get(currentNum-1));
        }

        // 每組結束時的提示訊息
        if(currentNum==1){
            // 嵌入圖片 levelthree
            levelImageView.setImageResource(R.drawable.levelthree);
            toast = Toast.makeText(this, "Level 3", Toast.LENGTH_SHORT);
            toast.show();
        } else if (currentNum==13){
            // 嵌入圖片 levelone
            levelImageView.setImageResource(R.drawable.levelone);
            toast = Toast.makeText(this, "Level 1", Toast.LENGTH_SHORT);
            toast.show();
        } else if (currentNum==25){
            // 嵌入圖片 leveltwo
            levelImageView.setImageResource(R.drawable.leveltwo);
            toast = Toast.makeText(this, "Level 2", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    // 問題頁的「下一題」
    public void nextQuestion(View view){
//        Toast toast = Toast.makeText(this, "下一個按鈕已經被點擊", Toast.LENGTH_SHORT);
//        toast.show();
        Toast toast;

        // 取得目前題號
        int currentNum = getCurrentNumber();

        // 清空目前的 questionsTextView
        questionsTextView.setText("");

        if(currentNum==36){
            // 把第一題的文字，填到畫面
            questionsTextView.setText(allQuestions.get(1));
        } else {
            // 把下一題的文字，填到畫面
            questionsTextView.setText(allQuestions.get(currentNum+1));
        }

        // 每組結束時的提示訊息
        if(currentNum==12){
            // 嵌入圖片 leveltwo
            levelImageView.setImageResource(R.drawable.leveltwo);
            toast = Toast.makeText(this, "Level 2", Toast.LENGTH_SHORT);
            toast.show();
        } else if (currentNum==24){
            // 嵌入圖片 levelthree
            levelImageView.setImageResource(R.drawable.levelthree);
            toast = Toast.makeText(this, "Level 3", Toast.LENGTH_SHORT);
            toast.show();
        } else if (currentNum==36){
            // 嵌入圖片 levelone
            levelImageView.setImageResource(R.drawable.levelone);
            toast = Toast.makeText(this, "Level 1", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    // 問題頁的「回首頁」
    public void home(View view){
//        Toast toast = Toast.makeText(this, "home按鈕已經被點擊", Toast.LENGTH_SHORT);
//        toast.show();
        toHomePage();
    }

    // 首頁的三個按鈕(第一組、第二組、第三組)
    public void clickFirstSet(View view){
        // 切到問題頁
        toQuestionsPage();
        // 填入題組的第一題到 questionsTextView
        questionsTextView.setText(allQuestions.get(1));
        // 嵌入圖片 levelone
        levelImageView.setImageResource(R.drawable.levelone);

    }
    public void clickSecondSet(View view){
        // 切到問題頁
        toQuestionsPage();
        // 填入題組的第一題到 questionsTextView
        questionsTextView.setText(allQuestions.get(13));
        // 嵌入圖片 leveltwo
        levelImageView.setImageResource(R.drawable.leveltwo);
    }
    public void clickThirdSet(View view){
        // 切到問題頁
        toQuestionsPage();
        // 填入題組的第一題到 questionsTextView
        questionsTextView.setText(allQuestions.get(25));
        // 嵌入圖片 levelthree
        levelImageView.setImageResource(R.drawable.levelthree);
    }



    // 切到問題頁
    private void toQuestionsPage(){
        hideHomePage();
        showQuestionsPage();
    }
    private void hideHomePage(){
        homepage.setVisibility(View.INVISIBLE);
    }
    private void showQuestionsPage(){
        questionsPage.setVisibility(View.VISIBLE);
    }

    // 切到首頁
    private void toHomePage(){
        showHomePage();
        hideQuestionsPage();
    }
    private void showHomePage(){
        homepage.setVisibility(View.VISIBLE);
    }
    private void hideQuestionsPage(){
        questionsPage.setVisibility(View.INVISIBLE);
    }




    // 載入問題
    private void loadQuestions(){
        // 實體化 HashMap
        allQuestions = new HashMap<Integer, String>();
        allQuestions.put(1,"1. 如果可以在世界上所有人中任意選擇，你想邀請誰共進晚餐？");
        allQuestions.put(2,"2. 你想成名嗎？想以什麼方式成名？");
        allQuestions.put(3,"3. 打電話之前你會先排練一下要說什麼嗎，為什麼？");
        allQuestions.put(4,"4. 對你來說，「完美」的一天是什麼樣的？");
        allQuestions.put(5,"5. 你上次自己唱起歌來是在什麼時候，給別人唱呢？");
        allQuestions.put(6,"6. 如果你能活到90歲，同時可以一直保持30歲時的心智或身體，你會選擇保持哪一種呢，心智還是身體？");
        allQuestions.put(7,"7. 你是否曾經秘密地預感到自己會以怎樣的方式死去？");
        allQuestions.put(8,"8. 說出三件你和你的伴侶看上去相同的特徵。");
        allQuestions.put(9,"9. 人生中的什麼東西最令你感激？");
        allQuestions.put(10,"10. 如果你能改變被撫養成人過程中的一件事，會是哪一件。");
        allQuestions.put(11,"11. 花四分鐘時間，儘可能詳細告訴伴侶你的人生經歷。");
        allQuestions.put(12,"12.如果你明天一覺醒來就能擁有某種才能或能力，你希望那會是什麼能力呢？");
        allQuestions.put(13,"13. 如果有一個水晶球可以告訴你關於自己、人生，未來乃至任何事情的真相，你會想知道嗎？");
        allQuestions.put(14,"14. 有沒有什麼事是你一直夢想去做而沒有去做的，為什麼沒有做？");
        allQuestions.put(15,"15. 你人生中最大的成就是什麼？");
        allQuestions.put(16,"16. 在一段友誼之中你最珍視的是什麼？");
        allQuestions.put(17,"17. 你最寶貴的記憶是什麼？");
        allQuestions.put(18,"18. 你最糟糕的記憶是什麼？");
        allQuestions.put(19,"19. 假如你知道自己在一年內就會突然死去，你會改變現在的生活方式嗎？為什麼？");
        allQuestions.put(20,"20. 友誼對於你來說意味着什麼？");
        allQuestions.put(21,"21. 愛與情感在你生活中扮演着什麼樣的角色？");
        allQuestions.put(22,"22. 和你的伴侶輪流說出心目中對方的一個好品質，每人說五條。");
        allQuestions.put(23,"23. 你的家人之間關係是否親密而溫暖，你覺得自己的童年比其他人更快樂嗎？");
        allQuestions.put(24,"24. 你和母親之間的關係是怎樣的？");
        allQuestions.put(25,"25. 每人用「我們」造三個句子，並含有實際情況，比如「我們倆在屋子裡，感覺……」");
        allQuestions.put(26,"26. 補完這個句子：「我希望和某人在一起，分享……」");
        allQuestions.put(27,"27. 如果你想和對方成為親近的朋友，請告訴對方有什麼重要的事情是他或她需要知道的。");
        allQuestions.put(28,"28. 告訴對方你喜歡他或她身上的什麼東西，要非常誠實，說些你不會對萍水之交說的東西。");
        allQuestions.put(29,"29. 和對方分享生命中那些尷尬的時刻。");
        allQuestions.put(30,"30. 你上次在別人面前哭是什麼時候？自己哭呢？");
        allQuestions.put(31,"31. 告訴對方，你已經喜歡上了他或她身上的什麼品質。");
        allQuestions.put(32,"32. 你覺得什麼東西是嚴肅到不能開玩笑的，假如有的話。");
        allQuestions.put(33,"33. 如果你今晚就將死去，而且沒有機會同任何人聯絡，你會因為之前沒有對別人說什麼話而感到遺憾，你為什麼到現在都沒有對他們說這些話呢？");
        allQuestions.put(34,"34. 假設你擁有的全部東西都在你的房子里，現在房子着了火，救出家人和寵物之後，你還有機會安全地衝進去最後一次，取出最後一件東西，你會拿什麼，為什麼？");
        allQuestions.put(35,"35. 你的家人中，誰去世了會令你最難過，為什麼？");
        allQuestions.put(36,"36. 說出一件你的個人問題，問對方如果遇到此事要如何解決。另外，也要讓對方如實告訴你，在他或她眼中，你對於這個問題的感受是怎樣的。");
    }


}
