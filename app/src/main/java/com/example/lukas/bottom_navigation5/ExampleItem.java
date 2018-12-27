package com.example.lukas.bottom_navigation5;


public class ExampleItem {
    private int mImageResource; //Variable vom Drawable ist als string abgespeichert
    private String mText1;
    private String mText2;

    //----------------------------------------Konstruktor-----------------------------
    public ExampleItem(int imageResource, String text1, String text2)
    {
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
    }

    //-----------------------------------------get----------------------------------------

    public int getmImageResource()
    {
        return mImageResource;
    }
    public String getmText1()
    {
        return mText1;
    }
    public String getmText2()
    {
        return mText2;
    }
}
