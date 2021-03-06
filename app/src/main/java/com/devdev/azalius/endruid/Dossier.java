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
    private FileExplorer fe;

    public Dossier(File fic, Context ct, PathManager fp, FileExplorer fileExplorer) {
        this.fic = fic;
        this.ct = ct;
        this.fp = fp;
        this.fe = fileExplorer;
    }

    @Override
    public View toDisplay() {
        /*
        exemple
        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               fp.setPath(fic.getAbsolutePath());
            }
        });
        */

        LinearLayout aRet = new LinearLayout(this.ct);
        aRet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fp.setPath(fic.getAbsolutePath());
            }
        });
        aRet.setOnLongClickListener(new View.OnLongClickListener() {
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
