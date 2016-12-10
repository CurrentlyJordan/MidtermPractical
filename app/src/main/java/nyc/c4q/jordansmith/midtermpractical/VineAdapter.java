package nyc.c4q.jordansmith.midtermpractical;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nyc.c4q.jordansmith.midtermpractical.Model.Record;

/**
 * Created by jordansmith on 12/10/16.
 */

public class VineAdapter extends RecyclerView.Adapter<VineAdapter.VineViewHolder> {

    private List<Record> recordList;

    public VineAdapter(List<Record> recordList){
        this.recordList = recordList;

    }


    @Override
    public VineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);

        return new VineViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(VineViewHolder holder, int position) {
        String userName;

        if(recordList.get(position).getRepost() == null){
            userName = "no available username";
        }
        else{ userName = recordList.get(position).getRepost().getUser().getUsername();}

        holder.UserNameTextView.setText(userName);

    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }

    public class VineViewHolder extends RecyclerView.ViewHolder {
        TextView UserNameTextView;


        public VineViewHolder(View itemView) {
            super(itemView);
            UserNameTextView = (TextView) itemView.findViewById(R.id.username_textview);
        }
    }
}
