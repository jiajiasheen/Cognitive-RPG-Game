package tongzou.cognitivegame.Activity.Class;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import tongzou.cognitivegame.R;

/**
 * Created by Draco on 2016-11-07.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView quesN;
    public TextView ansAccur;

    public RecyclerViewHolder(View itemView){
        super(itemView);
        quesN = (TextView) itemView.findViewById(R.id.questionN);
        ansAccur = (TextView) itemView.findViewById(R.id.question_accur);
    }
}
