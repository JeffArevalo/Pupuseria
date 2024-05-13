package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PedidoConsultarActivity extends AppCompatActivity {

    ControlDBPupuseria helper;
    EditText editIDPedido;
    EditText editIDPedido2;
    EditText editRepartidor;
    EditText editUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_consultar);

        helper = new ControlDBPupuseria(this);
        editIDPedido= (EditText) findViewById(R.id.editIDPedido);
        editIDPedido2 = (EditText) findViewById(R.id.editIDPedido2);
        editRepartidor = (EditText) findViewById(R.id.editRepartidor);
        editUsuario = (EditText) findViewById(R.id.editUsuario);
    }

    public void consultarPedido(View v) {
        helper.abrir();
        Pedido pedido = helper.consultarPedido(Integer.parseInt(editIDPedido.getText().toString()));
        helper.cerrar();
        if (pedido == null)
            Toast.makeText(this, "El pedido con ID " + Integer.parseInt(editIDPedido.getText().toString()) +
                    " no fue encontrado", Toast.LENGTH_LONG).show();
        else {
            editIDPedido2.setText(String.valueOf(pedido.getIdPedido()));
            editRepartidor.setText(pedido.getIdRepartidor());
            editUsuario.setText(pedido.getIdUsuario());
        }
    }

    public void limpiarTexto(View v) {
        editIDPedido.setText("");
        editIDPedido2.setText("");
        editRepartidor.setText("");
        editUsuario.setText("");
    }
}