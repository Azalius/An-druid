package com.devdev.azalius.endruid;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

/**
 * Created by Azalius on 12-Mar-18.
 */

public class Dossier implements Gelement {
    private final FileExplorer fp;
    private File fic;
    private Context ct;

    public Dossier(File fic, Context ct, FileExplorer fp) {
        this.fic = fic;
        this.ct = ct;
        this.fp = fp;
    }

    @Override
    public View toDisplay() {
        LinearLayout aRet = new LinearLayout(ct);

        TextView tv = new TextView(this.ct);
        tv.setText(this.fic.getName());
        aRet.addView(tv);

        return aRet;
    }

}
