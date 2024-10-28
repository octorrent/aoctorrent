package com.octorrent.android.ui.fragments;

import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.TooltipCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.octorrent.android.R;
import com.octorrent.android.ui.adapters.KeySlidePagerAdapter;

public class TorrentFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_torrents, parent, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        TabLayout tabs = getView().findViewById(R.id.tabs);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);

        ViewPager2 viewPager = getView().findViewById(R.id.view_pager);

        KeySlidePagerAdapter adapter = new KeySlidePagerAdapter(getChildFragmentManager(), getLifecycle());
        viewPager.setAdapter(adapter);

        adapter.addFragment("All", new TorrentAllFragment());
        adapter.addFragment("Downloading", new TorrentDownloadingFragment());
        adapter.addFragment("Completed", new TorrentCompletedFragment());

        new TabLayoutMediator(tabs, viewPager, new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position){
                tab.setText(adapter.getKey(position));
                TooltipCompat.setTooltipText(tab.view, null);
            }
        }).attach();

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab){
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab){
                tab.view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab){
            }
        });
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}