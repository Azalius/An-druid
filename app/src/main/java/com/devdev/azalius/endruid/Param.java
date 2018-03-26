package com.devdev.azalius.endruid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Azalius on 20-Mar-18.
 */

public class Param extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle si){
        super.onCreate(si);
        setContentView(R.layout.param);
        Button btn = (Button)findViewById(R.id.valid);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
                Intent myIntent = new Intent(Param.this, MainActivity.class);
                Param.this.startActivity(myIntent);
            }
        });
        EditText et = findViewById(R.id.path);
        et.setText(this.getPath());
    }

    public String getPath(){
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        Log.e("je lis", sharedPref.getString(getString(R.string.saveName), getString(R.string.unSaved)));
        return sharedPref.getString(getString(R.string.saveName), getString(R.string.unSaved));
    }

    private void saveData() {
        EditText et = findViewById(R.id.path);
        String path = et.getText().toString();
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.saveName), path);
        editor.commit();
    }
}
