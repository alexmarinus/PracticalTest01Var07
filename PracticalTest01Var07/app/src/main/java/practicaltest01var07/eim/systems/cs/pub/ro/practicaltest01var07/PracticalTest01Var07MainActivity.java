package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    private EditText nextTermText = null, allTermsText = null;
    private Button addButton = null, computeButton = null;
    private String expression = "";

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                //Pentru caseta de text, golesc textul
                case R.id.editText:
                    nextTermText.setText("");
                    break;
                case R.id.editText2:

                //Pentru butonul de Add, preiau next term
                case R.id.button:
                    String nextTerm = nextTermText.getText().toString();
                    if (!nextTerm.isEmpty()) {
                        if (expression.isEmpty())
                            expression = nextTerm;
                        else
                            expression = expression + "+" + nextTerm;
                    }
                    allTermsText.setText (expression);
                    break;
                //Pentru butonul de compute, calculez expresia
                case R.id.button2:
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        nextTermText = (EditText) findViewById(R.id.editText);
        allTermsText = (EditText) findViewById(R.id.editText2);

        addButton = (Button) findViewById(R.id.button);
        computeButton = (Button) findViewById(R.id.button2);

        addButton.setOnClickListener(buttonClickListener);
        computeButton.setOnClickListener(buttonClickListener);
        nextTermText.setOnClickListener(buttonClickListener);
    }
}
