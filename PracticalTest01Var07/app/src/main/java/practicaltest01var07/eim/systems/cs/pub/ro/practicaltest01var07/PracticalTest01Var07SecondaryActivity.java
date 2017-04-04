package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    private String expressionToCompute = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        Intent intent = getIntent();

        if (intent != null && intent.getExtras().containsKey("expression")) {
            expressionToCompute = intent.getStringExtra("expression");
            expressionToCompute = expressionToCompute.replaceAll("\\+", " +");
            int expressionresult = 0;
            String[] expressionTokens = expressionToCompute.split(" +");
            for (int i = 0; i < expressionTokens.length; i ++) {
                expressionresult += Integer.parseInt(expressionTokens[i]);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
