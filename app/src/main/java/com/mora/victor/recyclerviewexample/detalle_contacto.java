package com.mora.victor.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class detalle_contacto extends AppCompatActivity {

    TextView tvNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle data = this.getIntent().getExtras();

        tvNumero = (TextView)findViewById(R.id.tvNumero);



    }
}
