package com.codeinpython.codeinpython;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class cardviewAdapter extends RecyclerView.Adapter<cardviewAdapter.MyViewHolder> {
    private List<cardviewclass> cardviewclassList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        private CardView cardView;
        public MyViewHolder(View view)
        {
            super(view);
            textView = (TextView)view.findViewById(R.id.tv);
            imageView = (ImageView)view.findViewById(R.id.img);
            cardView = (CardView)view.findViewById(R.id.cardview);
        }
    }

    public cardviewAdapter(Context context,List<cardviewclass> cardviewclassList) {
        this.context =context;
        this.cardviewclassList = cardviewclassList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_element, parent, false);
        return new MyViewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        cardviewclass cardviewclass = cardviewclassList.get(position);
        holder.imageView.setImageResource(cardviewclass.getmImage());
        holder.textView.setText(cardviewclass.getmText());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position)
                {
                    case 0:
                        Intent intent = new Intent(v.getContext(),TopicMenuActivity.class);
                        v.getContext().startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardviewclassList.size();
    }
}
