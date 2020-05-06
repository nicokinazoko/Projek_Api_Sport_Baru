package com.example.projek_api_sport.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.projek_api_sport.Model.Team.TeamsDiscoverResultItem;
import com.example.projek_api_sport.R;

import java.util.ArrayList;

public class TeamDiscoverAdapter extends RecyclerView.Adapter<TeamDiscoverAdapter.ViewHolder> {

    private ArrayList<TeamsDiscoverResultItem> teamsDiscoverResultItems         =   new ArrayList<>();

    private Context context;

    private static String BASE_IMAGE_URL                                               =   "";

    public TeamDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<TeamsDiscoverResultItem> items)
    {
        teamsDiscoverResultItems.clear();
        teamsDiscoverResultItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view                                                               = LayoutInflater.
                from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .load(teamsDiscoverResultItems
                        .get(position)
                        .getStrTeamBadge())
                .into(holder.imageViewThumbnail);

        holder.textViewTeamTitle.setText(teamsDiscoverResultItems.get(position).getStrTeam().toString());

        holder.textViewTeamAbb.setText(teamsDiscoverResultItems.get(position).getStrStadium());
    }

    @Override
    public int getItemCount() {
        return teamsDiscoverResultItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewThumbnail;
        TextView textViewTeamTitle, textViewTeamAbb;
        CardView cardViewItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardViewItem                                                        =   itemView.findViewById(R.id.itemlist_cardview);
            imageViewThumbnail                                                  =   itemView.findViewById(R.id.itemlist_imageview_thumbnail);
            textViewTeamTitle                                                   =   itemView.findViewById(R.id.itemlist_team_title);
            textViewTeamAbb                                                     =   itemView.findViewById(R.id.itemlist_team_abb);
        }
    }
}
