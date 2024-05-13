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

public class PedidoInsertarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIDPedido;
    Spinner spinnerRepartidor;
    Spinner spinnerUsuario;

    List<Integer> listIDRepartidor = new ArrayList<>();
    List<Integer> listIDUsuario = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_insertar);

        helper = new ControlDBPupuseria(this);
        editIDPedido = (EditText) findViewById(R.id.editIDPedido);
        spinnerUsuario = findViewById(R.id.spinnerUsuario);
        spinnerRepartidor = findViewById(R.id.spinnerRepartidor);

        SpinnerRepartidor();
        SpinnerUsuario();
    }

    public void insertarPedido(View v) {
        String idpedido = editIDPedido.getText().toString();
        int idPedido = Integer.parseInt(idpedido);
        int idRepartidor = listIDRepartidor.get(spinnerRepartidor.getSelectedItemPosition());
        int idUsuario = listIDUsuario.get(spinnerUsuario.getSelectedItemPosition());
        String regInsertados;

        if (idpedido.isEmpty()) {
            Toast.makeText(PedidoInsertarActivity.this, "Ingresar datos obligatorios", Toast.LENGTH_SHORT).show();
        } else {
            Pedido ped = new Pedido();
            ped.setIdPedido(idPedido);
            ped.setIdRepartidor(idRepartidor);
            ped.setIdUsuario(idUsuario);

            helper.abrir();
            regInsertados=helper.insertarPedido(ped);
            helper.cerrar();

            Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
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
    }
}