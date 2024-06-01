package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;
public class FormaPagoEliminarActivity extends AppCompatActivity {

    ControlDBPupuseria helper;
    EditText editIDFormaPago;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forma_pago_eliminar);
        helper =new ControlDBPupuseria(this);
        editIDFormaPago=(EditText)findViewById(R.id.editIDFormaPago);
    }
    public void eliminarFormaPago(View v){
        if (editIDFormaPago.getText().toString().isEmpty()){
            Toast.makeText(this,getResources().getString(R.string.vacio) , Toast.LENGTH_SHORT).show();
        }else {
            String regEliminadas;
            FormaPago formaPago = new FormaPago();
            formaPago.setIdFormaPago(Integer.parseInt(editIDFormaPago.getText().toString()));
            helper.abrir();
            regEliminadas = helper.eliminarFormaPago(formaPago);
            helper.cerrar();
            Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
        }
    }

}