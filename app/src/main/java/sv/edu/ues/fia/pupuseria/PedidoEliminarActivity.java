package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PedidoEliminarActivity extends AppCompatActivity {

    ControlDBPupuseria helper;
    EditText editIDPedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_eliminar);

        helper =new ControlDBPupuseria(this);
        editIDPedido=(EditText)findViewById(R.id.editIDPedido);
    }

    public void eliminarPedido(View v){
        String regEliminadas;
        Pedido pedido=new Pedido();
        pedido.setIdPedido(Integer.parseInt(editIDPedido.getText().toString()));
        helper.abrir();
        regEliminadas=helper.eliminarPedido(pedido);
        helper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}