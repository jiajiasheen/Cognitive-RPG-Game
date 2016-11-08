package tongzou.cognitivegame.Activity.Activity;

import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import tongzou.cognitivegame.Activity.Fragments.MainStoryFragment;
import tongzou.cognitivegame.R;

/**
 * Created by Draco on 2016-11-07.
 */

public class MainInterface extends AppCompatActivity {
    public static String userName;
    public static Integer hour_left;
    public static int nBack;
    public static ArrayList<Integer> time_consump_list;
    public static ArrayList<Double> accuracy_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_interface);

        userName = getIntent().getStringExtra("uName");
        hour_left = 5;
        nBack = 2;
        time_consump_list = new ArrayList<>();
        accuracy_list = new ArrayList<>();

        if(savedInstanceState == null){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            MainStoryFragment storyFragment = new MainStoryFragment();
            fragmentTransaction.add(R.id.main_interface, storyFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() != 0)
            getFragmentManager().popBackStackImmediate();
        else
            super.onBackPressed();
    }
}
