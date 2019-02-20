package com.learn.growthcodelab.recycler;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learn.growthcodelab.R;

public class TextAdapter extends RecyclerView.Adapter<TextAdapter.TextViewHolder> {

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_text, parent, false);
        TextViewHolder viewHolder = new TextViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        String text = holder.itemView.getResources().getString(R.string.s_recycler_item_text, position);
        holder.tvText.setText(text);
    }

    @Override
    public int getItemCount() {
        return 128;
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder{

        public TextView tvText;

        public TextViewHolder(View itemView) {
            super(itemView);
            tvText = (TextView)itemView.findViewById(R.id.tv_text);
        }
    }
}
