package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

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


}