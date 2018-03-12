package com.devdev.azalius.endruid;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Azalius on 12-Mar-18.
 */

public class ErrorsDisplay implements Gelement {

    private Context ct;
    private String message;

    public ErrorsDisplay(Context ct){
        this(ct, "une erreur est survenue");
    }

    public ErrorsDisplay(Context ct, String message){
        this.ct = ct;
        this.message = message;
    }

    @Override
    public View toDisplay() {
        TextView tv = new TextView(this.ct);
        tv.setText(this.message);
        return tv;
    }

}
