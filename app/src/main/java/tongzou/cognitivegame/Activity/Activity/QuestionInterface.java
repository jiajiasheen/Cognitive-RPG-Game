package tongzou.cognitivegame.Activity.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tongzou.cognitivegame.Activity.Class.QuestionRandomGenerator;
import tongzou.cognitivegame.R;

/**
 * Created by Draco on 2016-11-01.
 */

public class QuestionInterface extends AppCompatActivity {
    public int[] numbers;
    int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        final TextView nText = (TextView) findViewById(R.id.N_Back_Number);
        numbers = new QuestionRandomGenerator().generator();

        nText.setText(Integer.toString(numbers[pos]));

        final Button nextNumBtn = (Button) findViewById(R.id.next_btn);
        final Button corr_btn = (Button) findViewById(R.id.Correct);
        final Button wron_btn = (Button) findViewById(R.id.Wrong);

        nextNumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos++;
                nText.setText(Integer.toString(numbers[pos]));
                if(pos == 2) {
                    nextNumBtn.setVisibility(View.GONE);
                    corr_btn.setVisibility(View.VISIBLE);
                    wron_btn.setVisibility(View.VISIBLE);
                }
            }
        });

        corr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pos < numbers.length) {
                    nText.setText(Integer.toString(numbers[pos]));
                }
            }
        });

        wron_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pos < numbers.length) {
                    pos++;
                    nText.setText(Integer.toString(numbers[pos]));
                }
            }
        });


    }
}
