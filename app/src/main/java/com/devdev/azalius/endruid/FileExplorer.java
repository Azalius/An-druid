package com.devdev.azalius.endruid;


import android.content.Context;
import android.text.Layout;
import android.widget.LinearLayout;

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

    public FileExplorer(Environnement evr, LinearLayout aFill, Context ct){
        this.envi = evr;
        this.path = this.envi.getStartPath();
        this.copyPath = null;
        this.aAfficher = new ArrayList<>();
        this.aFill = aFill;
        this.ct = ct;

        this.refresh();
    }

    public void setPath(String path){
        this.path = path;
    }

    public void retour(){
        if (!"/".equals(path)){
            File fic = new File(path);
            path = fic.getParent();
            refresh();
        }
    }

    public void coller(){
        if (copyPath != null){
            File src = new File(copyPath);
            File dest = new File(path);
            try{
                copy(src, dest);
            }
            catch (Exception e){
                //TODO
            }
            refresh();
        }
    }

    private void refresh(){
        File enCours = new File (path);
        if (enCours == null || enCours.listFiles() == null){
            this.aAfficher.add(new ErrorsDisplay(ct, "Dossier vide"));
        }
        else{
            for (File fic : enCours.listFiles()){
                if (fic.isDirectory()){
                    this.aAfficher.add(new Dossier(fic, this.ct));
                }
                if (fic.isFile()){
                    this.aAfficher.add(new Fichier(fic, this.ct));
                }
            }
        }
        fillArea();
    }

    private void fillArea() {
        aFill.removeAllViews();
        for (Gelement ge : this.aAfficher){
            this.aFill.addView(ge.toDisplay());
        }
    }
}
