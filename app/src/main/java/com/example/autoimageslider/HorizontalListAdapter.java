package com.example.autoimageslider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalListAdapter extends RecyclerView.Adapter<HorizontalListAdapter.MyViewHolder> {

    Context context;
    String[] title;
    int[] image;

    public HorizontalListAdapter(Context context, String[] title, int[] image) {
        this.context = context;
        this.title = title;
        this.image = image;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.horizontal_list_sample,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {

        holder.imageitem.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_scale_animation));
        holder.textitem.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_scale_animation));



        holder.textitem.setText(title[i]);
        holder.imageitem.setImageResource(image[i]);

    }

    @Override
    public int getItemCount() {


        return title.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textitem;
        ImageView imageitem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textitem=itemView.findViewById(R.id.itemtext_id);
            imageitem=itemView.findViewById(R.id.circularimage_id);

        }
    }
}
