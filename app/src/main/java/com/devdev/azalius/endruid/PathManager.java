package com.devdev.azalius.endruid;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;

/**
 * Created by Azalius on 20-Mar-18.
 */

public class PathManager {
    private FileExplorer fe;
    String path;
    EditText et;
    public PathManager(String path, final EditText et){
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
        this.et.setOnEditorActionListener(
                new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                                actionId == EditorInfo.IME_ACTION_DONE ||
                                event != null &&
                                        event.getAction() == KeyEvent.ACTION_DOWN &&
                                        event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                            if (event == null || !event.isShiftPressed()) {
                                setPath(et.getText().toString());
                                return true; // consume.
                            }
                        }
                        return false; // pass on to other listeners.
                    }
                }
        );
    }
    public void setPath(String path){
        this.path = path;
        this.et.setText(path);
        this.fe.setPath(path);
    }

    public void retour() {
        this.setPath(new File(path).getParentFile().getAbsolutePath());
    }

    public void start(FileExplorer fe) {
        this.fe = fe;
        this.setPath(this.path);
    }
}
