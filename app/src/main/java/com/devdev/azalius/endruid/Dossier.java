package com.devdev.azalius.endruid;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.io.File;

/**
 * Created by Azalius on 12-Mar-18.
 */

public class Dossier implements Gelement {
    private File fic;
    private Context ct;

    public Dossier(File fic, Context ct) {
        this.fic = fic;
        this.ct = ct;
    }

    @Override
    public View toDisplay() {
        TextView tv = new TextView(this.ct);
        tv.setText(this.fic.getName());
        return tv;
    }
}
