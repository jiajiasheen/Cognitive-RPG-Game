package tongzou.cognitivegame.Activity.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import tongzou.cognitivegame.Activity.Activity.MainInterface;
import tongzou.cognitivegame.R;

/**
 * Created by Draco on 2016-11-01.
 */

public class StoryInterface extends Fragment{
    String userName = MainInterface.userName;
    Integer hour = MainInterface.hour_left;
    private View resultView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        resultView = inflater.inflate(R.layout.story_layout, container, false);

        TextView uName = (TextView) resultView.findViewById(R.id.uName);
        uName.setText(userName);
        TextView hours = (TextView) resultView.findViewById(R.id.hours);
        hours.setText(hour.toString() + " hours before dawn");

        Button tmp_button = (Button) resultView.findViewById(R.id.tmp_btn);
        tmp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                QuestionInterface qi = new QuestionInterface();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.main_interface, qi);
                //ft.addToBackStack(null);
                ft.commit();
            }
        });

        return resultView;
    }
}
