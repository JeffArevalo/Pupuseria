package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
import java.util.Locale;

public class VentaInsertarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIdVenta, editMontoVenta, editFechaVenta, editHoraVenta;
    Spinner spinnerIdPedido, spinnerIdDireccion, spinnerIdFormaPago;
    List<Pedido> listaPedidos = new ArrayList<>();
    List<Direccion> listaDirecciones = new ArrayList<>();
    List<FormaPago> listaFormaPagos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta_insertar);

        helper = new ControlDBPupuseria(this);

        editIdVenta = (EditText) findViewById(R.id.editIdVenta);
        editMontoVenta = (EditText) findViewById(R.id.editMonto);
        editFechaVenta = (EditText) findViewById(R.id.editFecha);
        editHoraVenta = (EditText) findViewById(R.id.editHora);

        spinnerIdPedido = findViewById(R.id.spinnerIdPedido);
        spinnerIdDireccion = findViewById(R.id.spinnerIdDireccion);
        spinnerIdFormaPago = findViewById(R.id.spinnerIdFormaPago);

        helper.abrir();
        listaPedidos = helper.mostrarPedidos();
        listaDirecciones = helper.mostrarDirecciones();
        listaFormaPagos = helper.mostrarFormaPagos();
        helper.cerrar();

        //establece valores al spinner
        ArrayAdapter<Pedido> adapterPedido = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaPedidos);
        adapterPedido.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdPedido.setAdapter(adapterPedido);

        //establece valores al spinner
        ArrayAdapter<Direccion> adapterDireccion = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaDirecciones);
        adapterDireccion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdDireccion.setAdapter(adapterDireccion);

        //establece valores al spinner
        ArrayAdapter<FormaPago> adapterFormaPago = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaFormaPagos);
        adapterFormaPago.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdFormaPago.setAdapter(adapterFormaPago);
    }

    public void insertarVenta(View v) {
        if (editIdVenta.getText().toString().isEmpty()||editMontoVenta.getText().toString().isEmpty()||
                editFechaVenta.getText().toString().isEmpty()||editHoraVenta.getText().toString().isEmpty()) {

            Toast.makeText(this, "Campos Vacios", Toast.LENGTH_SHORT).show();
        } else {
            int id_venta = Integer.valueOf(editIdVenta.getText().toString());
            String fechaVenta = editFechaVenta.getText().toString();
            String horaVenta = editHoraVenta.getText().toString();

            int seleccionPedido = spinnerIdPedido.getSelectedItemPosition();
            int id_pedido = listaPedidos.get(seleccionPedido).getIdPedido();

            int seleccionDireccion = spinnerIdDireccion.getSelectedItemPosition();
            int id_direccion = listaDirecciones.get(seleccionDireccion).getId();

            int seleccionFormaPago = spinnerIdFormaPago.getSelectedItemPosition();
            int id_formapago = listaFormaPagos.get(seleccionFormaPago).getIdFormaPago();

            String regInsertados;

            Venta venta = new Venta();
            venta.setIdVenta(id_venta);
            venta.setFecha(fechaVenta);
            venta.setHora(Time.valueOf(horaVenta));
            venta.setMonto(Double.valueOf(editMontoVenta.getText().toString()));
            venta.setIdPedido(id_pedido);
            venta.setIdDireccion(id_direccion);
            venta.setIdFormaPago(id_formapago);

            helper.abrir();
            regInsertados = helper.insertarVenta(venta);
            helper.cerrar();

            if (regInsertados.contains("Err")) {
                Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }



    public void limpiarTexto(View v) {
        editIdVenta.setText("");
        editMontoVenta.setText("");
        editFechaVenta.setText("");
        editHoraVenta.setText("");
    }
}