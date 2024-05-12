package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormaPagoInsertarActivity extends AppCompatActivity {

    ControlDBPupuseria helper;
    EditText editIDFormaPago;
    EditText editnomFormaPago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forma_pago_insertar);
        helper = new ControlDBPupuseria(this);
        editIDFormaPago = (EditText) findViewById(R.id.editIDFormaPago2);
        editnomFormaPago = (EditText) findViewById(R.id.editnomFormaPago);
    }

    public void insertarFormaPago(View v) {
        String idformpago = editIDFormaPago.getText().toString();
        int idFormaPago = Integer.parseInt(idformpago);
        String nomformPago = editnomFormaPago.getText().toString();
        String regInsertados;

        FormaPago formaPago = new FormaPago();
        formaPago.setIdFormaPago(idFormaPago);
        formaPago.setFormaPago(nomformPago);
        helper.abrir();
        regInsertados = helper.insertarFormaPago(formaPago);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

    public void limpiarTexto(View v) {
        editIDFormaPago.setText("");
        editnomFormaPago.setText("");

    }
}