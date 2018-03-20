package com.devdev.azalius.endruid;

        import android.content.Context;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
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

        evr = new Environnement(context);
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
    }
}

