package com.devdev.azalius.endruid;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    FileExplorer fe;

    public Fichier(File fic, Context ct, PathManager fp, FileExplorer fileExplorer) {
        this.fp = fp;
        this.fic = fic;
        this.ct = ct;
        this.fe  = fileExplorer;
    }

    @Override
    public View toDisplay() {

        /*exemple
        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               fe.setCopy(fic.getAbsolutePath());
            }
        });
        */


        LinearLayout ll = new LinearLayout(this.ct);
        ll.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                fe.setCopy(fic.getAbsolutePath());
                return true;
            }
        });

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
