package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PedidoActualizarActivity extends AppCompatActivity {

    ControlDBPupuseria helper;
    EditText editIDPedido;
    EditText editIDPedido2;
    Spinner spinnerRepartidor;
    Spinner spinnerUsuario;
    List<Repartidor> listIDRepartidor = new ArrayList<>();
    List<Usuario> listIDUsuario = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_actualizar);

        helper = new ControlDBPupuseria(this);
        editIDPedido = (EditText) findViewById(R.id.editIDPedido);
        editIDPedido2 = (EditText) findViewById(R.id.editIDPedido2);
        spinnerUsuario = findViewById(R.id.spinnerUsuario);
        spinnerRepartidor = findViewById(R.id.spinnerRepartidor);

        helper.abrir();
        listIDUsuario = helper.mostrarUsuario();
        listIDRepartidor = helper.mostrarRepartidor();
        helper.cerrar();

        //establece valores al spinner
        ArrayAdapter<Usuario> adapterUsuario = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listIDUsuario);
        adapterUsuario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUsuario.setAdapter(adapterUsuario);

        //establece valores al spinner
        ArrayAdapter<Repartidor> adapterRepartidor = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listIDRepartidor);
        adapterRepartidor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRepartidor.setAdapter(adapterRepartidor);
    }


    public void editar(View v) {
        if (editIDPedido.getText().toString().isEmpty()){
            Toast.makeText(this, "Campos Vacios", Toast.LENGTH_SHORT).show();
        }else {
            helper.abrir();
            Pedido pedido = helper.consultarPedido(Integer.parseInt(editIDPedido.getText().toString()));
            helper.cerrar();
            if (pedido == null) {
                Toast.makeText(this, "El pedido con ID " + Integer.parseInt(editIDPedido.getText().toString()) +
                        " no fue encontrado", Toast.LENGTH_LONG).show();
            }else {
                editIDPedido2.setText(String.valueOf(pedido.getIdPedido()));
            }
        }
    }
    public void actualizarPedido(View v) {
        if(editIDPedido.getText().toString().isEmpty()){
             //   listIDRepartidor.size() == 0 || listIDUsuario.size() == 0){
            Toast.makeText(this, "Esta vacio", Toast.LENGTH_SHORT).show();
        }
        else {
            String estado;
            String id = editIDPedido.getText().toString();
            int idPedido = Integer.parseInt(id);
            int seleccionRepartidor = spinnerRepartidor.getSelectedItemPosition();
            int idRepartidor = listIDRepartidor.get(seleccionRepartidor).getIdRepartidor();
            int seleccionUsuario = spinnerUsuario.getSelectedItemPosition();
            int idUsuario = listIDUsuario.get(seleccionUsuario).getIdUsuario();

            Pedido ped = new Pedido();
            ped.setIdPedido(idPedido);
            ped.setIdRepartidor(idRepartidor);
            ped.setIdUsuario(idUsuario);

            helper.abrir();
            estado=helper.actualizarPedido(ped);
            helper.cerrar();

            Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
        }

    }


    public void limpiarTexto(View v) {
        editIDPedido.setText("");
        editIDPedido2.setText("");
    }
}