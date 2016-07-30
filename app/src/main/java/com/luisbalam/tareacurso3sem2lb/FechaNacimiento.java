package com.luisbalam.tareacurso3sem2lb;

import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class FechaNacimiento extends AppCompatActivity {

    DatePicker dateContacto;
    Button botonGuardar;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nacimiento_fecha);

        dateContacto=(DatePicker) findViewById(R.id.dateContacto);

    }

    public void presionarBotonGuardar(View v){

        botonGuardar=(Button) findViewById(R.id.botonGuardar);
        extras=getIntent().getExtras();

        Intent irMain=new Intent(FechaNacimiento.this,MainActivity.class);

        irMain.putExtra(getResources().getString(R.string.dia_nacimiento),dateContacto.getDayOfMonth());
        irMain.putExtra(getResources().getString(R.string.mes_nacimiento),dateContacto.getMonth());
        irMain.putExtra(getResources().getString(R.string.año_nacimiento),dateContacto.getYear());

        if(extras!=null) {
            irMain.putExtras(extras);
        }

        startActivity(irMain);

        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK){
            extras=getIntent().getExtras();
            Intent irMain=new Intent(FechaNacimiento.this,MainActivity.class);

            irMain.putExtra(getResources().getString(R.string.dia_nacimiento),dateContacto.getDayOfMonth());
            irMain.putExtra(getResources().getString(R.string.mes_nacimiento),dateContacto.getMonth());
            irMain.putExtra(getResources().getString(R.string.año_nacimiento),dateContacto.getYear());

            if(extras!=null) {
                irMain.putExtras(extras);
            }

            startActivity(irMain);

            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
