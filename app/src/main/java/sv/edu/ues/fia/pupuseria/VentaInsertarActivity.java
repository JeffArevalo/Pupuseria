package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class VentaInsertarActivity extends AppCompatActivity {
    ControlDBPupuseria helper;
    EditText editIdVenta, editMontoVenta, editFechaVenta, editHoraVenta;
    Spinner spinnerIdPedido, spinnerIdDireccion, spinnerIdFormaPago;
    List<Pedido> listaPedidos = new ArrayList<>();
    //List<Direccion> listaDirecciones = new ArrayList<>();
    List<FormaPago> listaFormaPagos = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venta_insertar);

        helper = new ControlDBPupuseria(this);

        editIdVenta = (EditText) findViewById(R.id.editTextNumber2);
        editMontoVenta = (EditText) findViewById(R.id.editTextNumberDecimal);
        editFechaVenta = (EditText) findViewById(R.id.editTextDate);
        editHoraVenta = (EditText) findViewById(R.id.editTextTime);

        spinnerIdPedido = findViewById(R.id.spinner4);
        spinnerIdDireccion = findViewById(R.id.spinner5);
        spinnerIdFormaPago = findViewById(R.id.spinner6);

        helper.abrir();
        listaPedidos = helper.mostrarPedidos();
        //listaDirecciones = helper.mostrarDirecciones();
        listaFormaPagos = helper.mostrarFormaPagos();
        helper.cerrar();

        //establece valores al spinner
        ArrayAdapter<Pedido> adapterPedido = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaPedidos);
        adapterPedido.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdPedido.setAdapter(adapterPedido);
        /*
        //establece valores al spinner
        ArrayAdapter<Direccion> adapterDireccion = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaDirecciones);
        adapterDireccion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdDireccion.setAdapter(adapterPedido);
        */
        //establece valores al spinner
        ArrayAdapter<FormaPago> adapterFormaPago = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listaFormaPagos);
        adapterFormaPago.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIdFormaPago.setAdapter(adapterFormaPago);
    }
    /*
    public void insertarVenta(View v) {
        if (editIdVenta.getText().toString().isEmpty()) {

            Toast.makeText(this, getResources().getString(R.string.vacio), Toast.LENGTH_SHORT).show();
        } else {
            int id_venta = Integer.valueOf(editIdVenta.getText().toString());
            float monto = Float.valueOf(editMontoVenta.getText().toString());
            Date fechaVenta = new Date();
            //Time horaVenta = new Time();

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                fechaVenta = sdf.parse(editFechaVenta.getText().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            int seleccionPedido = spinnerIdPedido.getSelectedItemPosition();
            int id_pedido = listaPedidos.get(seleccionPedido).getIdPedido();

            int seleccionDireccion = spinnerIdDireccion.getSelectedItemPosition();
            int id_direccion = listaDireccion.get(seleccionDireccion).getId_docente();

            int seleccionFormaPago = spinnerIdFormaPago.getSelectedItemPosition();
            int id_formapago = listaFormaPagos.get(seleccionFormaPago).getIdFormaPago();

            String regInsertados;

            Venta venta = new Venta();
            venta.setIdVenta(id_venta);
            venta.setFecha(fechaVenta);
            //venta.setHora(horaVenta);

            venta.setIdPedido(id_pedido);
            //venta.setIdDireccion(id_direccion);
            venta.setIdFormaPago(id_formapago);

            helper.abrir();
            regInsertados = helper.insertar(venta);
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
    */

    public void limpiarTexto(View v) {
        editIdVenta.setText("");
        editMontoVenta.setText("");
        editFechaVenta.setText("");
        editHoraVenta.setText("");
    }
}