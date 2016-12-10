package nyc.c4q.jordansmith.midtermpractical;

import android.graphics.Color;
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
        else{ userName = "Username " + recordList.get(position).getRepost().getUser().getUsername();}

        holder.userNameTextView.setText(userName);
        int liked = recordList.get(position).getLiked();
        String likedString ="Liked: " + Integer.toString(liked);
        holder.likedTextView.setText(likedString);
        if(recordList.get(position).getProfileBackground() != null){
            String color = recordList.get(position).getProfileBackground();
            String newColor = "";
            for(int i = 2; i < color.length(); i++){
                newColor = newColor + color.charAt(i);
            }
            newColor = "#" + newColor;
            String finalColor = newColor;

            holder.itemView.setBackgroundColor(Color.parseColor(finalColor));
        }



    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }

    public class VineViewHolder extends RecyclerView.ViewHolder {
        TextView userNameTextView;
        TextView likedTextView;



        public VineViewHolder(View itemView) {
            super(itemView);
            userNameTextView = (TextView) itemView.findViewById(R.id.username_textview);
            likedTextView = (TextView) itemView.findViewById(R.id.liked_Textview);
        }


    }
}
