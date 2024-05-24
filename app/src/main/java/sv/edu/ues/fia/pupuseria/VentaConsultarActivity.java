package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;

public class VentaConsultarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIdVenta,editIdVenta2 ,editMontoVenta, editFechaVenta, editHoraVenta,editIDPedido, editIDDireccion, editFormaPago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta_consultar);

        helper = new ControlDBPupuseria(this);

        editIdVenta = (EditText) findViewById(R.id.editIDVenta);
        editIdVenta2 = (EditText) findViewById(R.id.editIDVenta2);
        editIDPedido = (EditText) findViewById(R.id.editIDPedido);
        editIDDireccion = (EditText) findViewById(R.id.editIDDireccion);
        editFormaPago = (EditText) findViewById(R.id.editFormaPago);
        editMontoVenta = (EditText) findViewById(R.id.editMonto);
        editFechaVenta = (EditText) findViewById(R.id.editFecha);
        editHoraVenta = (EditText) findViewById(R.id.editHora);
    }

    public void consultarVenta(View v) {
        if (editIdVenta.getText().toString().isEmpty()) {
            Toast.makeText(this, "Campo Vacio", Toast.LENGTH_SHORT).show();
        } else {
            helper.abrir();
            Venta venta = helper.consultarVenta(Integer.parseInt(editIdVenta.getText().toString()));
            helper.cerrar();
            if (venta == null)
                Toast.makeText(this, "La venta con ID " + Integer.parseInt(editIdVenta.getText().toString()) +
                        " no fue encontrado", Toast.LENGTH_LONG).show();
            else {
                editIdVenta2.setText(String.valueOf(venta.getIdVenta()));
                editIDPedido.setText(String.valueOf(venta.getIdPedido()));
                editFormaPago.setText(String.valueOf(venta.getIdFormaPago()));
                editIDDireccion.setText(String.valueOf(venta.getIdDireccion()));
                editMontoVenta.setText(String.valueOf(venta.getMonto()));
                editFechaVenta.setText(String.valueOf(venta.getFecha()));
                editHoraVenta.setText(String.valueOf(venta.getHora()));
            }
        }
    }

    public void limpiarTexto(View v) {
        editIdVenta.setText("");
        editIdVenta2.setText("");
        editIDDireccion.setText("");
        editIDPedido.setText("");
        editFormaPago.setText("");
        editMontoVenta.setText("");
        editFechaVenta.setText("");
        editHoraVenta.setText("");
    }

}