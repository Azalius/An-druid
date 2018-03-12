package com.devdev.azalius.endruid;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.io.File;


/**
 * Created by Azalius on 12-Mar-18.
 */

public class Environnement {
    private String startPath;
    private int primary;
    private int secondary;

    public Environnement(Context cont){
        this.primary = ContextCompat.getColor(cont, R.color.colorPrimary);
        this.primary = ContextCompat.getColor(cont, R.color.colorAccent);
        this.startPath = File.listRoots()[0].getAbsolutePath();
    }

    public int getPrimary() {
        return primary;
    }

    public int getSecondary() {
        return secondary;
    }

    public String getStartPath() {
        return startPath;
    }

    public void setStartPath(String startPath) {
        this.startPath = startPath;
    }

    public void setPrimary(int primary) {
        this.primary = primary;
    }

    public void setSecondary(int secondary) {
        this.secondary = secondary;
    }

}
