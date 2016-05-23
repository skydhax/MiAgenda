package mx.skylabs.miagenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmacionDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTel;
    private TextView tvEmail;
    private TextView tvDescripcion;
    private TextView tvFechaNacimiento;

    private Bundle parametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_datos);


        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvTel = (TextView)findViewById(R.id.tvTel);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);
        tvFechaNacimiento = (TextView)findViewById(R.id.tvFechaNacimiento);

        parametros = getIntent().getExtras();
        //String stringPrueba = parametros.getString("Prueba");

        tvNombre.setText(parametros.getString("Nombre"));
        tvTel.setText(parametros.getString("Telefono"));
        tvEmail.setText(parametros.getString("Email"));
        tvDescripcion.setText(parametros.getString("Descripcion"));
        String fecha = parametros.getInt("Day") + "/" + parametros.getInt("Month") + "/" + parametros.getInt("Year");
        tvFechaNacimiento.setText(fecha);
    }



    public void editar(View view){
        Intent intent = new Intent(ConfirmacionDatos.this,MainActivity.class);

        Contacto contacto = new Contacto(tvNombre.getText().toString(), tvFechaNacimiento.getText().toString(),tvTel.getText().toString(),tvEmail.getText().toString(),tvDescripcion.getText().toString());
        intent.putExtra("Nombre",contacto.getNombre());
        intent.putExtra("Telefono",contacto.getTelefono());
        intent.putExtra("Email",contacto.getEmail());
        intent.putExtra("Descripcion",contacto.getDescripcion());
        intent.putExtra("Year",parametros.getInt("Year"));
        intent.putExtra("Month",parametros.getInt("Month"));
        intent.putExtra("Day",parametros.getInt("Day"));

        startActivity(intent);
    }
}
