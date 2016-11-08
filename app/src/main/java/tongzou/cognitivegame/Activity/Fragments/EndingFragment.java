package tongzou.cognitivegame.Activity.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import tongzou.cognitivegame.Activity.Activity.MainInterface;
import tongzou.cognitivegame.Activity.Class.RecyclerViewAdapter;
import tongzou.cognitivegame.R;

/**
 * Created by Draco on 2016-11-07.
 */

public class EndingFragment extends Fragment {
    ArrayList<Double> result_list = MainInterface.accuracy_list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View resultView = inflater.inflate(R.layout.ending_layout, container, false);

        RecyclerView mRecyclerView = (RecyclerView) resultView.findViewById(R.id.ending_recycler);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(getActivity(), result_list);
        mRecyclerView.setAdapter(mAdapter);

        return resultView;
    }
}
