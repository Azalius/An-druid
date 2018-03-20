package com.devdev.azalius.endruid;

import android.view.View;
import android.widget.EditText;

import java.io.File;

/**
 * Created by Azalius on 20-Mar-18.
 */

public class PathManager {
    private final FileExplorer fe;
    String path;
    EditText et;
    public PathManager(String path, final EditText et, FileExplorer fe){
        this.fe = fe;
        this.path = path;
        this.et = et;
        this.et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    setPath(et.getText().toString());
                }
            }
        });
        this.setPath(this.path);
    }
    public void setPath(String path){
        this.path = path;
        this.et.setText(path);
        this.fe.setPath(path);
    }

    public void retour() {
        this.setPath(new File(path).getParentFile().getAbsolutePath());
    }
}
