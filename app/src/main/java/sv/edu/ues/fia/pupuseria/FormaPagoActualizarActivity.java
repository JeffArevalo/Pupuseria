package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormaPagoActualizarActivity extends AppCompatActivity {

    ControlDBPupuseria helper;
    EditText editIDFormaPago;
    EditText editIDFormaPago2;
    EditText editnomFormaPago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forma_pago_actualizar);
        helper = new ControlDBPupuseria(this);
        editIDFormaPago= (EditText) findViewById(R.id.editIDFormaPago);
        editnomFormaPago = (EditText) findViewById(R.id.editnomFormaPago);
        editIDFormaPago2 = (EditText) findViewById(R.id.editIDFormaPago2);
    }

    public void editarFormaPago(View v) {
        helper.abrir();
        FormaPago formaPago = helper.consultarFormaPago(Integer.parseInt(editIDFormaPago.getText().toString()));
        helper.cerrar();

        if (formaPago == null)
            Toast.makeText(this, "La forma de pago con ID " + Integer.parseInt(editIDFormaPago.getText().toString()) +
                    " no fue encontrado", Toast.LENGTH_LONG).show();
        else {
            editIDFormaPago2.setText(String.valueOf(formaPago.getIdFormaPago()));
            editnomFormaPago.setText(formaPago.getFormaPago());
        }
    }
    public void actualizarFormaPago(View v) {
        FormaPago formaPago = new FormaPago();
        formaPago.setIdFormaPago(Integer.parseInt(editIDFormaPago2.getText().toString()));
        formaPago.setFormaPago(editnomFormaPago.getText().toString());
        helper.abrir();
        String estado = helper.actualizarFormaPago(formaPago);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editIDFormaPago.setText("");
        editIDFormaPago2.setText("");
        editnomFormaPago.setText("");
    }
}

