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
    List<String> nomRepartidor = new ArrayList<>();
    List<String> spinnerListRepartidor = new ArrayList<>();
    List<Integer> listIDUsuario = new ArrayList<>();
    List<String> nomUsuario = new ArrayList<>();
    List<String> spinnerListUsuario = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_insertar);

        helper = new ControlDBPupuseria(this);
        editIDPedido = (EditText) findViewById(R.id.editIDPedido);
        spinnerUsuario = findViewById(R.id.spinnerUsuario);
        spinnerRepartidor = findViewById(R.id.spinnerRepartidor);

        String sql1 = "SELECT ID_USUARIO,NOMBRE_USUARIO, APELLIDO_USUARIO FROM USUARIO";
        Cursor cursor1 = helper.llenarSpinner(sql1);
        while (cursor1.moveToNext()) {
            @SuppressLint("Range")
            int idUs = cursor1.getInt(cursor1.getColumnIndex("ID_USUARIO"));
            listIDUsuario.add(idUs);

            @SuppressLint("Range")
            String nomUs = cursor1.getString(cursor1.getColumnIndex("NOMBRE_USUARIO")) + " " + cursor1.getString(cursor1.getColumnIndex("APELLIDO_USUARIO"));
            nomUsuario.add(nomUs);

            String itemSpinner = idUs + ": " + nomUs;
            spinnerListUsuario.add(itemSpinner);
        }

        //establece valores al spinner de Usuario
        ArrayAdapter<String> adapterUsuario = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerListUsuario);
        adapterUsuario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerUsuario.setAdapter(adapterUsuario);


        String sql2 = "SELECT ID_REPARTIDOR,NOMBRE_REPARTIDOR, APELLIDO_REPARTIDOR FROM REPARTIDOR";
        Cursor cursor2 = helper.llenarSpinner(sql2);
        while (cursor2.moveToNext()) {
            @SuppressLint("Range")
            int idRep = cursor2.getInt(cursor2.getColumnIndex("ID_REPARTIDOR"));
            listIDRepartidor.add(idRep);

            @SuppressLint("Range")
            String nom = cursor2.getString(cursor2.getColumnIndex("NOMBRE_REPARTIDOR")) + " " + cursor2.getString(cursor2.getColumnIndex("APELLIDO_REPARTIDOR"));
            nomRepartidor.add(nom);

            String itemSpinner = idRep + ": " + nom;
            spinnerListRepartidor.add(itemSpinner);
        }
        //establece valores al spinner de repartidor
        ArrayAdapter<String> adapterRepartidor = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerListRepartidor);
        adapterRepartidor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRepartidor.setAdapter(adapterRepartidor);



    }

    public void insertarPedido(View v) {
        if (editIDPedido.getText().toString().isEmpty()) {
            Toast.makeText(PedidoInsertarActivity.this, "Ingresar datos obligatorios", Toast.LENGTH_SHORT).show();
        } else {
            String regInsertados;
            String id = editIDPedido.getText().toString();
            int idPedido = Integer.parseInt(id);
            int idRepartidor = listIDRepartidor.get(spinnerRepartidor.getSelectedItemPosition());
            int idUsuario = listIDUsuario.get(spinnerUsuario.getSelectedItemPosition());

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

    public void limpiarTexto(View v) {
        editIDPedido.setText("");
    }
}