package com.example.second.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.second.R;
import com.example.second.model.Progress;

import java.util.Arrays;
import java.util.List;

public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.ViewHolder> {

    private List<Progress> progressList;

    public ProgressAdapter() {
        this.progressList = progresses();
    }

    private List<Progress> progresses() {
        return Arrays.asList(new Progress(40, "уравнения"), new Progress(65, "неравенства"), new Progress(34, "система уравнений"));
    }

    @NonNull
    @Override
    public ProgressAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.progress_bar_items, parent, false);
        return new ProgressAdapter.ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgressAdapter.ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        ProgressBar progressBar = (ProgressBar) cardView.findViewById(R.id.progressBar);
        TextView textView = (TextView) cardView.findViewById(R.id.percentage);
        Progress progress = progressList.get(position);
        progressBar.setProgress(progress.getPercentage());
        textView.setText(progress.getPercentage() + "%");
        TextView title = (TextView) cardView.findViewById(R.id.progressTitle);
        title.setText(progress.getTitle());
    }

    @Override
    public int getItemCount() {
        return progressList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }
}
