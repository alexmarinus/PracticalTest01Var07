package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    private EditText nextTermText = null, allTermsText = null;
    private Button addButton = null, computeButton = null;
    private String expression = "";

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                //Pentru caseta de text, golesc textul
                case R.id.editText:
                    nextTermText.setText("");
                    break;
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
                //Pentru butonul de compute, calculez expresia prin intentie
                case R.id.button2:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
                    expression = allTermsText.getText().toString();
                    intent.putExtra("expression", expression);
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }

}
