package com.sectorrent.android.handlers;

public class Torrent {

    private String title;
    private long started;
    private int peers, seeders, completed, total;

    public Torrent(String title){
        this.title = title;
        started = System.currentTimeMillis();
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public int getPeers(){
        return peers;
    }

    public int getSeeders(){
        return seeders;
    }

    public int getProgress(){
        return completed;
    }

    public int getTotal(){
        return total;
    }

    public int getLeft(){
        return total-completed;
    }

    public long getStarted(){
        return started;
    }
}
