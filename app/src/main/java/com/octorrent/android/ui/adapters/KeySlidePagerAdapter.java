package com.octorrent.android.ui.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class KeySlidePagerAdapter extends FragmentStateAdapter {

    private List<String> keys;
    private List<Fragment> fragments;

    public KeySlidePagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle, List<String> keys, List<Fragment> fragments){
        super(fragmentManager, lifecycle);
        this.keys = keys;
        this.fragments = fragments;
    }

    public KeySlidePagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle){
        super(fragmentManager, lifecycle);
        keys = new ArrayList<>();
        fragments = new ArrayList<>();
    }

    public void addFragment(String key, Fragment fragment){
        keys.add(key);
        fragments.add(fragment);
        notifyItemInserted(fragments.size());
    }

    public String getKey(int position){
        return keys.get(position);
    }

    public Fragment getFragment(String key){
        return fragments.get(keys.indexOf(key));
    }

    public void removeFragment(String key){
        int index = keys.indexOf(key);
        fragments.remove(index);
        keys.remove(index);
        notifyItemRemoved(index);
    }

    public boolean containsKey(String key){
        return keys.contains(key);
    }

    public boolean containsValue(Fragment fragment){
        return fragments.contains(fragment);
    }

    public int indexOf(String key){
        return keys.indexOf(key);
    }

    public int indexOf(Fragment fragment){
        return fragments.indexOf(fragment);
    }

    public List<String> keySet(){
        List<String> r = new ArrayList();
        for(String k : keys){
            r.add(k);
        }
        return r;
    }

    public int size(){
        return fragments.size();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position){
        return fragments.get(position);
    }

    @Override
    public long getItemId(int position){
        return fragments.get(position).hashCode();
    }

    @Override
    public int getItemCount(){
        return fragments.size();
    }
}
