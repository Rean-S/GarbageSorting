package com.example.garbagesorting;

public class Contact {
    int _id;
    String garbage;
    String sorting;
    public Contact(){   }
    public Contact(int id, String garbage, String sorting){
        this._id = id;
        this.garbage = garbage;
        this.sorting = sorting;
    }

    public Contact(String garbage, String sorting){
        this.garbage = garbage;
        this.sorting = sorting;
    }
    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getGarbage(){
        return this.garbage;
    }

    public void setGarbage(String word_en){
        this.garbage = word_en;
    }

    public String getSorting(){
        return this.sorting;
    }

    public void setSorting(String sorting){
        this.sorting = sorting;
    }
}