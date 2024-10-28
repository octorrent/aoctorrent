package com.octorrent.android.ui.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.octorrent.android.R;
import com.octorrent.android.handlers.Torrent;

import java.util.List;

public class TorrentAdapter extends RecyclerView.Adapter<TorrentAdapter.RecyclerViewAdapter> {

    private Context context;
    private List<Torrent> torrents;

    //LETS JUST USE PARENTS JSON... - SAVE MEMORY...

    public TorrentAdapter(Context context, List<Torrent> torrents){
        this.context = context;
        this.torrents = torrents;
    }

    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_torrent, parent, false);
        return new RecyclerViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, @SuppressLint("RecyclerView") int position){
        holder.icon.setImageResource(R.drawable.ic_file_iso);

        holder.title.setText(torrents.get(position).getTitle());
        holder.progress.setProgress(50);

        holder.status.setText("624 MB of 3.12 GB - 2 min, 13 secs left");
        holder.description.setText("Downloading from 45 of 50 connected peers");
    }

    @Override
    public int getItemCount(){
        return torrents.size();
    }

    public static class RecyclerViewAdapter extends RecyclerView.ViewHolder {

        public View view;
        public ImageView icon;
        public ProgressBar progress;
        public TextView title, status, description;

        public RecyclerViewAdapter(View view){
            super(view);
            this.view = view;
            icon = view.findViewById(R.id.icon);
            title = view.findViewById(R.id.title);
            status = view.findViewById(R.id.status);
            progress = view.findViewById(R.id.progress);
            description = view.findViewById(R.id.description);
        }
    }
}
