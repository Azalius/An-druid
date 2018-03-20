package com.devdev.azalius.endruid;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

/**
 * Created by Azalius on 12-Mar-18.
 */

public class Dossier implements Gelement {
    private final PathManager fp;
    private File fic;
    private Context ct;

    public Dossier(File fic, Context ct, PathManager fp) {
        this.fic = fic;
        this.ct = ct;
        this.fp = fp;
    }

    @Override
    public View toDisplay() {
        LinearLayout aRet = new LinearLayout(this.ct);

        TextView tv = new TextView(this.ct);
        tv.setText(this.fic.getName());
        tv.setTextSize(26);


        ImageView iv = new ImageView(this.ct);
        iv.setImageResource(R.mipmap.folder);
        iv.setAdjustViewBounds(true);
        iv.setMaxHeight(100);
        iv.setMaxWidth(100);

        aRet.addView(iv);
        aRet.addView(tv);

        aRet.setMinimumHeight(200);

        return aRet;
    }

}
