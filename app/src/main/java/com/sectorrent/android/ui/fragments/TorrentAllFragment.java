package com.sectorrent.android.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.sectorrent.android.R;
import com.sectorrent.android.handlers.Torrent;
import com.sectorrent.android.ui.adapters.TorrentAdapter;

import java.util.ArrayList;
import java.util.List;

public class TorrentAllFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_torrents_page, parent, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        List<Torrent> torrents = new ArrayList<>();
        torrents.add(new Torrent("ubuntu-21.10-desktop-amd64.iso"));

        RecyclerView listView = view.findViewById(R.id.list_view);
        TorrentAdapter adapter = new TorrentAdapter(getContext(), torrents);
        listView.setAdapter(adapter);

        View loader = getView().findViewById(R.id.error);
        ((ViewGroup) loader.getParent()).removeView(loader);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}
