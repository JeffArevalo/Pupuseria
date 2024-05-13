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
    List<Integer> listIDRepartidor = new ArrayList<>();
    List<Integer> listIDUsuario = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_actualizar);

        helper = new ControlDBPupuseria(this);
        editIDPedido = (EditText) findViewById(R.id.editIDPedido);
        spinnerUsuario = findViewById(R.id.spinnerUsuario);
        spinnerRepartidor = findViewById(R.id.spinnerRepartidor);

        SpinnerRepartidor();
        SpinnerUsuario();
    }

    public void editarPedido(View v) {
        if(editIDPedido.getText().toString().isEmpty() ) {
            Toast.makeText(this, "No ha ingresado ningun ID de pedido", Toast.LENGTH_SHORT).show();
        }
        else{
            helper.abrir();
            Pedido pedido = helper.consultarPedido(Integer.parseInt(editIDPedido.getText().toString()));
            helper.cerrar();
            if (pedido == null)
                Toast.makeText(this, "El pedido con ID " + Integer.parseInt(editIDPedido.getText().toString()) +
                        " no fue encontrado", Toast.LENGTH_LONG).show();
            else {
                editIDPedido2.setText(String.valueOf(pedido.getIdPedido()));
                spinnerRepartidor.setOnClickListener(null);
                spinnerUsuario.setOnClickListener(null);
            }
        }
    }

    public void actualizarPedido(View v) {
        if(editIDPedido.getText().toString().isEmpty() ||
                listIDRepartidor.size() == 0 || listIDUsuario.size() == 0){
            Toast.makeText(this, "Esta vacio", Toast.LENGTH_SHORT).show();
        }
        else {
            Pedido pedido = new Pedido();

            int idRepartidor, idUsuario;
            idRepartidor =listIDRepartidor.get(spinnerRepartidor.getSelectedItemPosition());
            idUsuario = listIDUsuario.get(spinnerUsuario.getSelectedItemPosition());

            int idpedido = Integer.valueOf(editIDPedido.getText().toString());
            pedido.setIdPedido(idpedido);
            pedido.setIdRepartidor(idRepartidor);
            pedido.setIdUsuario(idUsuario);

            helper.abrir();
            String estado = helper.actualizarPedido(pedido);
            helper.cerrar();
            Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
        }

    }

    public void SpinnerRepartidor(){
        String sql = "SELECT ID_REPARTIDOR FROM REPARTIDOR";
        Cursor cursor = helper.llenarSpinner(sql);
        while (cursor.moveToNext()) {
            @SuppressLint("Range")
            int idRepartidor = cursor.getInt(cursor.getColumnIndex("ID_PEDIDO"));
            listIDRepartidor.add(idRepartidor);
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listIDRepartidor);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRepartidor.setAdapter(adapter);
    }

    public void SpinnerUsuario(){
        String sql = "SELECT ID_USUARIO FROM USUARIO";
        Cursor cursor = helper.llenarSpinner(sql);
        while (cursor.moveToNext()) {
            @SuppressLint("Range")
            int idUsuario = cursor.getInt(cursor.getColumnIndex("ID_USUARIO"));
            listIDUsuario.add(idUsuario);
        }
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listIDUsuario);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUsuario.setAdapter(adapter);
    }

    public void limpiarTexto(View v) {
        editIDPedido.setText("");
        editIDPedido2.setText("");
        spinnerUsuario.isEnabled();
        spinnerRepartidor.isEnabled();
    }
}