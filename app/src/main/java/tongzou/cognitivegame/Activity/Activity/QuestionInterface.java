package tongzou.cognitivegame.Activity.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;

import tongzou.cognitivegame.Activity.Class.QuestionRandomGenerator;
import tongzou.cognitivegame.R;

/**
 * Created by Draco on 2016-11-01.
 */

public class QuestionInterface extends AppCompatActivity {
    public int[] numbers;
    public int pos = 0;
    public Context context;
    public Integer correct = 0;
    public int nBack = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);
        context = this;

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
               //if(pos < numbers.length) {
                if(numbers[pos] == numbers[pos - nBack]) {
                    correct++;
                    Log.i("===correct", correct+"" + " numbers last: " + numbers[pos - nBack] + " number this: " + numbers[pos] +"");
                }
                Log.i("correct", correct+"" + " numbers last: " + numbers[pos - nBack] + " number this: " + numbers[pos] +"");
                updateTextView(nText);
                //}else
                //    FinishQuiz();
            }
        });

        wron_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numbers[pos] != numbers[pos - nBack]) {
                    correct++;
                    Log.i("===correct", correct+"" + " numbers last: " + numbers[pos - nBack] + " number this: " + numbers[pos] +"");
                }
                Log.i("correct", correct+"" + " numbers last: " + numbers[pos - nBack] + " number this: " + numbers[pos] +"");
                updateTextView(nText);
            }
        });
    }

    public void updateTextView(TextView textView){
        pos++;
        if(pos < numbers.length)
            textView.setText(Integer.toString(numbers[pos]));
        else
            FinishQuiz();
    }

    public void FinishQuiz(){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(correct.toString() + " correct among " + (numbers.length - nBack) + "");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent back_to_story = new Intent(context, StoryInterface.class);
                startActivity(back_to_story);
                ((Activity)context).finish();
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }
}
