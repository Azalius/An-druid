package com.devdev.azalius.endruid;

        import android.content.Context;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageButton;
        import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    private static Context context;
    Environnement evr;
    FileExplorer fe;
    PathManager pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.context = getApplicationContext();

        evr = new Environnement(context, this);
        pm = new PathManager(evr.getStartPath(), (EditText)findViewById(R.id.fname));
        fe = new FileExplorer(evr,(LinearLayout)findViewById(R.id.listeFic),pm, context);
        pm.start(fe);

        ImageButton retour = (ImageButton) findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pm.retour();
            }
        });

        ImageButton param = (ImageButton) findViewById(R.id.param);
        param.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, Param.class);
                MainActivity.this.startActivity(myIntent);
                evr.setUp();
            }
        });
        evr.setUp();

        Button coller = (Button)(findViewById(R.id.coller));
        coller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fe.coller();
            }
        });
    }
}

