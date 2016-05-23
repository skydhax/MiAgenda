package mx.skylabs.miagenda;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText tiNombre;
    private EditText  tiTelefono;
    private EditText  tiEmail;
    private EditText  tiDescripcion;

    private DatePicker datePicker;

    private Contacto nuevoContacto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiNombre = (EditText)findViewById(R.id.tiNombre);
        tiTelefono = (EditText)findViewById(R.id.tiTelefono);
        tiEmail = (EditText)findViewById(R.id.tiEmail);
        tiDescripcion = (EditText)findViewById(R.id.tiDescripcion);

        datePicker = (DatePicker)findViewById(R.id.datePicker);


        if(getIntent().getExtras()!=null) {

            Bundle parametros = getIntent().getExtras();

            if(getIntent().getExtras().containsKey("Nombre")) {
                tiNombre.setText(parametros.getString("Nombre"));
                //String  preview=getIntent().getExtras().getString("Sdacha");
            }
            if(getIntent().getExtras().containsKey("Telefono")) {
                tiTelefono.setText(parametros.getString("Telefono"));
            }
            if(getIntent().getExtras().containsKey("Email")) {
                tiEmail.setText(parametros.getString("Email"));
            }
            if(getIntent().getExtras().containsKey("Descripcion")) {
                tiDescripcion.setText(parametros.getString("Descripcion"));
            }
            if(getIntent().getExtras().containsKey("Year")) {


                int oldYear =  parametros.getInt("Year");
                int oldMonth =  parametros.getInt("Month");
                int oldDay =  parametros.getInt("Day");

                Log.e("ERROR", String.valueOf(oldYear));
                Log.e("ERROR",String.valueOf(oldMonth));
                Log.e("ERROR",String.valueOf(oldDay));



                datePicker.updateDate(oldYear,oldMonth,oldDay);


            }
        }





        //Contacto contacto = new Contacto()
    }


    public void siguiente(View view){

        String fecha = datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear();

        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();

        nuevoContacto = new Contacto(tiNombre.getText().toString(),fecha, tiTelefono.getText().toString(), tiEmail.getText().toString(), tiDescripcion.getText().toString());

        Log.e("TAG",tiNombre.getText().toString());
        Log.e("TAG",tiTelefono.getText().toString());
        Log.e("TAG",tiEmail.getText().toString());
        Log.e("TAG",tiDescripcion.getText().toString());
        //Log.e("TAG",datePicker.

        Intent intent = new Intent(MainActivity.this,ConfirmacionDatos.class);
        /*
        intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());
        intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(position).getTelefono());
        intent.putExtra(getResources().getString(R.string.pemail),contactos.get(position).getEmail());
        */
        intent.putExtra("Nombre",nuevoContacto.getNombre());
        intent.putExtra("Telefono",nuevoContacto.getTelefono());
        intent.putExtra("Email",nuevoContacto.getEmail());
        intent.putExtra("Descripcion",nuevoContacto.getDescripcion());
        intent.putExtra("Year",year);
        intent.putExtra("Month",month);
        intent.putExtra("Day",day);

        startActivity(intent);
        finish();
    }
}
