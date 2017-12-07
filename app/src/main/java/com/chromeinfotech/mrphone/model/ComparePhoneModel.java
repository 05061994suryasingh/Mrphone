package com.chromeinfotech.mrphone.model;

import android.graphics.drawable.Drawable;

/**
 * Created by user on 7/9/17.
 */

public class ComparePhoneModel {
    public String Phonename ;

    public Drawable getPhoneimage() {
        return phoneimage;
    }

    public void setPhoneimage(Drawable phoneimage) {
        this.phoneimage = phoneimage;
    }

    public String getPhonename() {
        return Phonename;
    }

    public void setPhonename(String phonename) {
        Phonename = phonename;
    }

    public Drawable phoneimage ;
}
