package com.luisbalam.tareacurso3sem2lb;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionDatos extends AppCompatActivity {

    Bundle extras;
    TextView confirmacionDatos;
    TextView nombreConfirmacion;
    TextView nacimientoConfirmacion;
    TextView telefonoConfirmacion;
    TextView correoConfirmacion;
    TextView acercaConfirmacion;
    Button botonEditarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_confirmacion);

        extras=getIntent().getExtras();
        confirmacionDatos=(TextView) findViewById(R.id.confirmacionDatos);
        nombreConfirmacion=(TextView) findViewById(R.id.nombreConfirmacion);
        nacimientoConfirmacion=(TextView) findViewById(R.id.nacimientoConfirmacion);
        telefonoConfirmacion=(TextView) findViewById(R.id.telefonoConfirmacion);
        correoConfirmacion=(TextView) findViewById(R.id.correoConfirmacion);
        acercaConfirmacion=(TextView) findViewById(R.id.acercaConfirmacion);

        String nombreContacto=extras.getString(getResources().getString(R.string.nombre));
        String numeroContacto=extras.getString(getResources().getString(R.string.telefono));
        String correoContacto=extras.getString(getResources().getString(R.string.email));
        String descripcionContacto=extras.getString(getResources().getString(R.string.descripcion_contacto));
        int diaNacimientoContacto=extras.getInt(getResources().getString(R.string.dia_nacimiento));
        int mesNacimientoContacto=extras.getInt(getResources().getString(R.string.mes_nacimiento));
        int añoNacimientoContacto=extras.getInt(getResources().getString(R.string.año_nacimiento));

        nombreConfirmacion.setText("Nombre Contacto: "+nombreContacto);
        telefonoConfirmacion.setText("Teléfono: "+numeroContacto);
        correoConfirmacion.setText("Email: "+correoContacto);
        acercaConfirmacion.setText("Descripción: "+descripcionContacto);
        nacimientoConfirmacion.setText("Fecha Nacimiento: "+diaNacimientoContacto+"/"+mesNacimientoContacto+"/"+añoNacimientoContacto);

    }

    public void presionarBotonEditar(View v){

        botonEditarDatos=(Button) findViewById(R.id.botonEditarDatos);

        String nombreContacto=extras.getString(getResources().getString(R.string.nombre));
        String numeroContacto=extras.getString(getResources().getString(R.string.telefono));
        String correoContacto=extras.getString(getResources().getString(R.string.email));
        String descripcionContacto=extras.getString(getResources().getString(R.string.descripcion_contacto));
        int diaNacimientoContacto=extras.getInt(getResources().getString(R.string.dia_nacimiento));
        int mesNacimientoContacto=extras.getInt(getResources().getString(R.string.mes_nacimiento));
        int añoNacimientoContacto=extras.getInt(getResources().getString(R.string.año_nacimiento));

        Intent irMainEditar=new Intent(ConfirmacionDatos.this,MainActivity.class);
        irMainEditar.putExtra(getResources().getString(R.string.nombre),nombreContacto);
        irMainEditar.putExtra(getResources().getString(R.string.telefono),numeroContacto);
        irMainEditar.putExtra(getResources().getString(R.string.email),correoContacto);
        irMainEditar.putExtra(getResources().getString(R.string.descripcion_contacto),descripcionContacto);
        irMainEditar.putExtra(getResources().getString(R.string.dia_nacimiento),diaNacimientoContacto);
        irMainEditar.putExtra(getResources().getString(R.string.mes_nacimiento),mesNacimientoContacto);
        irMainEditar.putExtra(getResources().getString(R.string.año_nacimiento),añoNacimientoContacto);

        startActivity(irMainEditar);

        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_BACK){

            String nombreContacto=extras.getString(getResources().getString(R.string.nombre));
            String numeroContacto=extras.getString(getResources().getString(R.string.telefono));
            String correoContacto=extras.getString(getResources().getString(R.string.email));
            String descripcionContacto=extras.getString(getResources().getString(R.string.descripcion_contacto));
            int diaNacimientoContacto=extras.getInt(getResources().getString(R.string.dia_nacimiento));
            int mesNacimientoContacto=extras.getInt(getResources().getString(R.string.mes_nacimiento));
            int añoNacimientoContacto=extras.getInt(getResources().getString(R.string.año_nacimiento));

            Intent irMainEditar=new Intent(ConfirmacionDatos.this,MainActivity.class);
            irMainEditar.putExtra(getResources().getString(R.string.nombre),nombreContacto);
            irMainEditar.putExtra(getResources().getString(R.string.telefono),numeroContacto);
            irMainEditar.putExtra(getResources().getString(R.string.email),correoContacto);
            irMainEditar.putExtra(getResources().getString(R.string.descripcion_contacto),descripcionContacto);
            irMainEditar.putExtra(getResources().getString(R.string.dia_nacimiento),diaNacimientoContacto);
            irMainEditar.putExtra(getResources().getString(R.string.mes_nacimiento),mesNacimientoContacto);
            irMainEditar.putExtra(getResources().getString(R.string.año_nacimiento),añoNacimientoContacto);

            startActivity(irMainEditar);

            finish();
        }

        return super.onKeyDown(keyCode, event);
    }
}
