package com.luisbalam.tareacurso3sem2lb;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Bundle extras;
    Button botonFecha;
    Button botonSiguiente;
    TextInputEditText editText1;
    TextInputEditText editText2;
    TextInputEditText editText3;
    TextInputEditText editText4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        extras=getIntent().getExtras();
        if(extras!=null){
            datos();
            botonFecha=(Button) findViewById(R.id.botonFecha);
            botonFecha.setText(extras.getInt(getResources().getString(R.string.dia_nacimiento))+"/"+extras.getInt(getResources().getString(R.string.mes_nacimiento))+"/"+extras.getInt(getResources().getString(R.string.año_nacimiento)));
        }

    }

    public void presionarBotonFecha(View v){

        botonFecha=(Button) findViewById(R.id.botonFecha);
        extras=getIntent().getExtras();
        editText1=(TextInputEditText) findViewById(R.id.editText1);
        editText2=(TextInputEditText) findViewById(R.id.editText2);
        editText3=(TextInputEditText) findViewById(R.id.editText3);
        editText4=(TextInputEditText) findViewById(R.id.editText4);
        Intent irFecha=new Intent(MainActivity.this,FechaNacimiento.class);

        if(editText1.getText().toString().length()>0){
            irFecha.putExtra(getResources().getString(R.string.nombre),editText1.getText().toString());
        }
        if(editText2.getText().toString().length()>0){
            irFecha.putExtra(getResources().getString(R.string.telefono),editText2.getText().toString());
        }
        if(editText3.getText().toString().length()>0){
            irFecha.putExtra(getResources().getString(R.string.email),editText3.getText().toString());
        }
        if(editText4.getText().toString().length()>0){
            irFecha.putExtra(getResources().getString(R.string.descripcion_contacto),editText4.getText().toString());
        }

        startActivity(irFecha);

        finish();
    }

    public void presionarBotonSiguiente(View v){

        botonSiguiente=(Button) findViewById(R.id.botonSiguiente);
        botonFecha=(Button) findViewById(R.id.botonFecha);

        editText1=(TextInputEditText) findViewById(R.id.editText1);
        editText2=(TextInputEditText) findViewById(R.id.editText2);
        editText3=(TextInputEditText) findViewById(R.id.editText3);
        editText4=(TextInputEditText) findViewById(R.id.editText4);
        extras=getIntent().getExtras();

        if(editText1.getText().toString().length()<1 || editText2.getText().toString().length()<1 || editText3.getText().toString().length()<1 || editText4.getText().toString().length()<1 || botonFecha.getText().toString().length()==17){
            Snackbar.make(v,getResources().getString(R.string.mensaje_snackbar),Snackbar.LENGTH_SHORT).show();
        }

        if(editText1.getText().toString().length()>=1 && editText2.getText().toString().length()>=1 && editText3.getText().toString().length()>=1 && editText4.getText().toString().length()>=1 && botonFecha.getText().toString().length()<17) {
            int diaNacimiento=extras.getInt(getResources().getString(R.string.dia_nacimiento));
            int mesNacimiento=extras.getInt(getResources().getString(R.string.mes_nacimiento));
            int añoNacimiento=extras.getInt(getResources().getString(R.string.año_nacimiento));

            Intent irConfirmacionDatos = new Intent(MainActivity.this, ConfirmacionDatos.class);

            irConfirmacionDatos.putExtra(getResources().getString(R.string.nombre), editText1.getText().toString());
            irConfirmacionDatos.putExtra(getResources().getString(R.string.telefono), editText2.getText().toString());
            irConfirmacionDatos.putExtra(getResources().getString(R.string.email), editText3.getText().toString());
            irConfirmacionDatos.putExtra(getResources().getString(R.string.descripcion_contacto), editText4.getText().toString());
            irConfirmacionDatos.putExtra(getResources().getString(R.string.dia_nacimiento), diaNacimiento);
            irConfirmacionDatos.putExtra(getResources().getString(R.string.mes_nacimiento), mesNacimiento);
            irConfirmacionDatos.putExtra(getResources().getString(R.string.año_nacimiento), añoNacimiento);

            startActivity(irConfirmacionDatos);

            finish();
        }
    }

    public void datos(){
        extras=getIntent().getExtras();
        String nombreContacto=extras.getString(getResources().getString(R.string.nombre));
        String numeroContacto=extras.getString(getResources().getString(R.string.telefono));
        String correoContacto=extras.getString(getResources().getString(R.string.email));
        String descripcionContacto=extras.getString(getResources().getString(R.string.descripcion_contacto));
        int diaNacimientoContacto=extras.getInt(getResources().getString(R.string.dia_nacimiento));
        int mesNacimientoContacto=extras.getInt(getResources().getString(R.string.mes_nacimiento));
        int añoNacimientoContacto=extras.getInt(getResources().getString(R.string.año_nacimiento));

        editText1=(TextInputEditText) findViewById(R.id.editText1);
        editText2=(TextInputEditText) findViewById(R.id.editText2);
        editText3=(TextInputEditText) findViewById(R.id.editText3);
        editText4=(TextInputEditText) findViewById(R.id.editText4);

        editText1.setText(nombreContacto);
        editText2.setText(numeroContacto);
        editText3.setText(correoContacto);
        editText4.setText(descripcionContacto);
    }

}
