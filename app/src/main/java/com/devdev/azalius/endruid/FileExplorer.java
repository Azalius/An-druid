package com.devdev.azalius.endruid;


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

    public FileExplorer(Environnement evr, LinearLayout aFill){
        this.envi = evr;
        this.path = this.envi.getStartPath();
        this.copyPath = null;
        this.aAfficher = new ArrayList<>();
        this.aFill = aFill;

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
        for (File fic : enCours.listFiles()){
            if (fic.isDirectory()){
                this.aAfficher.add(new Dossier(fic));
            }
            if (fic.isFile()){
                this.aAfficher.add(new Fichier(fic));
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
