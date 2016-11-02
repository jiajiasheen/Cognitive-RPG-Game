package tongzou.cognitivegame.Activity.Activity;

import android.content.Context;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import tongzou.cognitivegame.R;

public class MainActivity extends AppCompatActivity {
    String userName;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;


        Button loginBtn = (Button) findViewById(R.id.login_btn);
        final EditText mEditTxt = (EditText) findViewById(R.id.login_input);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = mEditTxt.getText().toString();
                Intent main_ui = new Intent(context, QuestionInterface.class);
                startActivity(main_ui);
                finish();
            }
        });

    }
}
