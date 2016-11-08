package tongzou.cognitivegame.Activity.Class;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import tongzou.cognitivegame.R;

/**
 * Created by Draco on 2016-11-07.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private ArrayList<Double> data;
    private Context context;

    public RecyclerViewAdapter(Context context, ArrayList<Double> data){
        this.data = data;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.ending_layout, null);
        RecyclerViewHolder rcv = new RecyclerViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Double ansAccur = data.get(position) * 100;
        holder.quesN.setText(context.getString(R.string.ending_question_number, position + 1));
        holder.ansAccur.setText(context.getString(R.string.ending_results, ansAccur));
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
