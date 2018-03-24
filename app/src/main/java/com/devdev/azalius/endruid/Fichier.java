package com.devdev.azalius.endruid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

/**
 * Created by Azalius on 12-Mar-18.
 */

public class Fichier implements Gelement {
    private final PathManager fp;
    private File fic;
    private Context ct;

    public Fichier(File fic, Context ct, PathManager fp, FileExplorer fileExplorer) {
        this.fp = fp;
        this.fic = fic;
        this.ct = ct;
    }

    @Override
    public View toDisplay() {
        LinearLayout ll = new LinearLayout(this.ct);

        TextView tv = new TextView(this.ct);
        tv.setText(this.fic.getName());
        tv.setTextSize(26);


        ImageView iv = new ImageView(this.ct);
        iv.setImageResource(R.mipmap.file);
        iv.setAdjustViewBounds(true);
        iv.setMaxHeight(100);
        iv.setMaxWidth(100);

        ll.addView(iv);
        ll.addView(tv);

        ll.setMinimumHeight(200);

        return ll;
    }

}
