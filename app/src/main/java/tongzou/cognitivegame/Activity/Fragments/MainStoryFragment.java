package tongzou.cognitivegame.Activity.Fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import tongzou.cognitivegame.Activity.Activity.MainInterface;
import tongzou.cognitivegame.R;

/**
 * Created by Draco on 2016-11-01.
 */

public class MainStoryFragment extends Fragment{
    String userName = MainInterface.userName;
    Integer hour = MainInterface.hour_left;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View resultView = inflater.inflate(R.layout.story_layout, container, false);

        TextView uName = (TextView) resultView.findViewById(R.id.uName);
        TextView hours = (TextView) resultView.findViewById(R.id.hours);

        if(hour > 1 && hour <= 3)
            MainInterface.nBack = 3; //increase level of difficulty, god it's hard

        if(hour == 1)
            MainInterface.nBack = 4; //insane level, seriously?

        uName.setText(userName);
        hours.setText(getString(R.string.hour_hints, hour));

        Button tmp_button = (Button) resultView.findViewById(R.id.tmp_btn);
        Button tmp2_button = (Button) resultView.findViewById(R.id.tmp2_btn);
        final ImageView runningMan = (ImageView) resultView.findViewById(R.id.somepic);
        runningMan.post(new Runnable(){
            @Override
            public void run() {
                ((AnimationDrawable) runningMan.getBackground()).start();
            }
        });
        tmp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                NBackFragment qi = new NBackFragment();
                //VisualMemFragment qi = new VisualMemFragment();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.main_interface, qi);
                //ft.addToBackStack(null);
                ft.commit();
            }
        });
        tmp2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                //NBackFragment qi = new NBackFragment();
                VisualMemFragment vm = new VisualMemFragment();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.main_interface, vm);
                //ft.addToBackStack(null);
                ft.commit();
            }
        });

        return resultView;
    }
}
