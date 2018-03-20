package com.devdev.azalius.endruid;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.io.File;


/**
 * Created by Azalius on 12-Mar-18.
 */

public class Environnement {

    private final Activity act;

    public Environnement(Context cont, MainActivity mainActivity){
        this.act = mainActivity;
    }

    public String getStartPath() {
        SharedPreferences sharedPref = this.act.getPreferences(Context.MODE_PRIVATE);
        String path = sharedPref.getString(this.act.getString(R.string.saveName), this.act.getString(R.string.unSaved));
        if (this.act.getString(R.string.unSaved).equals(path)){
            return File.listRoots()[0].getAbsolutePath();
        }
        return path;
    }

    public void setUp() {
        /* modifie l'apparence grace aux params stockées */
    }
}
