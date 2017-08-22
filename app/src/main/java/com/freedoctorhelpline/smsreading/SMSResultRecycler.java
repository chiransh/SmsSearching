package com.freedoctorhelpline.smsreading;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 8/6/2017.
 */

public class SMSResultRecycler extends RecyclerView.Adapter<SMSResultRecycler.MyViewHolder> {
    ArrayList arradress=new ArrayList();
    ArrayList arrbody=new ArrayList();
    Context context;

    public SMSResultRecycler(Context context,ArrayList<String> arradress, ArrayList<String> arrbody){
        this.arradress=arradress;
        this.arrbody=arrbody;
        this.context=context;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.smsresult_recycler, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.body.setText(arrbody.get(position).toString());
        holder.adress.setText(arradress.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return arradress.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView adress,body;
        public MyViewHolder(View itemView) {
            super(itemView);
            adress=(TextView)itemView.findViewById(R.id.adress);
            body=(TextView)itemView.findViewById(R.id.body);
        }
    }
}
