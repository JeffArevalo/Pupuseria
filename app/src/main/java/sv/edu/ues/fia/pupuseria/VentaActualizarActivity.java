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
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
//import java.sql.Date;

public class VentaActualizarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIdVenta,editIdVenta2, editMontoVenta, editFechaVenta, editHoraVenta;
    Spinner spinnerIdPedido, spinnerIdDireccion, spinnerIdFormaPago;
    List<Pedido> listaPedidos = new ArrayList<>();
    List<Direccion> listaDirecciones = new ArrayList<>();
    List<FormaPago> listaFormaPagos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta_actualizar);

        helper = new ControlDBPupuseria(this);

        editIdVenta = (EditText) findViewById(R.id.editIDVenta);
        editIdVenta2 = (EditText) findViewById(R.id.editIDVenta2);
        editMontoVenta = (EditText) findViewById(R.id.editMonto);
        editFechaVenta = (EditText) findViewById(R.id.editFecha);
        editHoraVenta = (EditText) findViewById(R.id.editHora);

        spinnerIdPedido = findViewById(R.id.spinnerIDPedido);
        spinnerIdDireccion = findViewById(R.id.spinnerIDDireccion);
        spinnerIdFormaPago = findViewById(R.id.spinnerFormaPago);

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

    public void editar(View v) {
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
                editMontoVenta.setText(String.valueOf(venta.getMonto()));
                editFechaVenta.setText(String.valueOf(venta.getFecha()));
                editHoraVenta.setText(String.valueOf(venta.getHora()));
            }
        }
    }

    public void actualizarVenta(View v) {
        if (editIdVenta.getText().toString().isEmpty()||editMontoVenta.getText().toString().isEmpty()||
                editFechaVenta.getText().toString().isEmpty()||editHoraVenta.getText().toString().isEmpty()) {

            Toast.makeText(this, "Campos Vacios", Toast.LENGTH_SHORT).show();
        } else {
            Venta venta = new Venta();

            String fechaVenta = editFechaVenta.getText().toString();
            String horaVenta = editHoraVenta.getText().toString();


            int seleccionPedido = spinnerIdPedido.getSelectedItemPosition();
            int id_pedido = listaPedidos.get(seleccionPedido).getIdPedido();

            int seleccionDireccion = spinnerIdDireccion.getSelectedItemPosition();
            int id_direccion = listaDirecciones.get(seleccionDireccion).getId();

            int seleccionFormaPago = spinnerIdFormaPago.getSelectedItemPosition();
            int id_formapago = listaFormaPagos.get(seleccionFormaPago).getIdFormaPago();


            venta.setIdVenta(Integer.parseInt(editIdVenta.getText().toString()));
            venta.setFecha(fechaVenta);
            venta.setHora(Time.valueOf(horaVenta));
            venta.setMonto(Double.parseDouble(editMontoVenta.getText().toString()));
            venta.setIdPedido(id_pedido);
            venta.setIdDireccion(id_direccion);
            venta.setIdFormaPago(id_formapago);

            helper.abrir();
            String estado = helper.actualizarVenta(venta);
            helper.cerrar();
            Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarTexto(View v) {
        editIdVenta.setText("");
        editIdVenta2.setText("");
        editMontoVenta.setText("");
        editFechaVenta.setText("");
        editHoraVenta.setText("");
    }

}