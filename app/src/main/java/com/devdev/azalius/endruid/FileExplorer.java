package com.devdev.azalius.endruid;


import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Azalius on 12-Mar-18.
 */

public class FileExplorer {
    private final LinearLayout aFill;
    private String path;
    private String copyPath;
    private ArrayList<Gelement> aAfficher;
    private Environnement envi;
    private Context ct;
    private PathManager pm;
    private Button btnColler;

    public static void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    public FileExplorer(Environnement evr, LinearLayout aFill, PathManager pm, Context ct, Button coller){
        this.envi = evr;
        this.pm = pm;
        this.path = evr.getStartPath();
        this.copyPath = null;
        this.aAfficher = new ArrayList<>();
        this.aFill = aFill;
        this.ct = ct;
        this.btnColler = coller;

        this.refresh();
    }

    public void setPath(String path){
        this.path = path;
        this.refresh();
    }

    public void setCopy(String patth){
        this.copyPath = patth;
        this.refresh();
    }

    public void coller(){
        if (copyPath != null){
            File src = new File(copyPath);
            File dest = new File(path);
            try{
                copy(src, dest);
                copyPath = null;
            }
            catch (Exception e){
            }
            refresh();
        }
    }

    private void refresh(){
        File enCours = new File (path);
        this.aAfficher.clear();

        if (enCours == null){
            this.aAfficher.add(new ErrorsDisplay(ct, ct.getString(R.string.wrongPath) + "  : " + path));
        }
        else if (!enCours.exists()){
            this.aAfficher.add(new ErrorsDisplay(ct, ct.getString(R.string.wrongPath )+ " : "+ path));
        }
        else if (!enCours.isDirectory()){
            this.aAfficher.add(new ErrorsDisplay(ct, ct.getString(R.string.notAFolder )+ " : "+ path));
        }
        else if (enCours.listFiles() == null){
            this.aAfficher.add(new ErrorsDisplay(ct, ct.getString(R.string.emptyFolder )+ " : "+ path));
        }
        else{
            for (File fic : enCours.listFiles()){
                if (fic.isDirectory()){
                    this.aAfficher.add(new Dossier(fic, this.ct, this.pm, this));
                }
                if (fic.isFile()){
                    this.aAfficher.add(new Fichier(fic, this.ct, this.pm, this));
                }
            }
        }
        fillArea();
        if (this.copyPath == null){
            btnColler.setVisibility(View.INVISIBLE);
        }
        else{
            btnColler.setVisibility(View.VISIBLE);
        }
    }

    private void fillArea() {
        aFill.removeAllViews();
        aFill.removeAllViewsInLayout();
        for (final Gelement ge : this.aAfficher){
            this.aFill.addView(ge.toDisplay());
        }
    }

    private void clickPath(String path) { // sur click d'un element, le faire remonter au pathManager
        this.pm.setPath(path);
    }
}
