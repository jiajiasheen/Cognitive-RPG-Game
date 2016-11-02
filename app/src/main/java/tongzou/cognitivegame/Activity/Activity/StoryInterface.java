package tongzou.cognitivegame.Activity.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tongzou.cognitivegame.R;

/**
 * Created by Draco on 2016-11-01.
 */

public class StoryInterface extends AppCompatActivity{
    String userName;
    Integer hour = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_layout);

        Bundle extras = getIntent().getExtras();
        userName = extras.getString("userName");

        TextView uName = (TextView) findViewById(R.id.uName);
        uName.setText(userName);
        TextView hours = (TextView) findViewById(R.id.hours);
        hours.setText(hour.toString());

        Button tmp_button = (Button) findViewById(R.id.tmp_btn);
        tmp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
