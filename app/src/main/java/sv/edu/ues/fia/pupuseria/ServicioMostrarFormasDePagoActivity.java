package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ServicioMostrarFormasDePagoActivity extends AppCompatActivity {
    ControlDBPupuseria db;
    static List<FormaPago> listaFormaPago;

    static List<String> nombreFormaPago;
    ListView listViewFormasPago;

    private final String urlHostingGratuito = "https://grupo02pupuseria.000webhostapp.com/mostrar_forma_pago.php";
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio_mostrar_formas_de_pago);

        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        db = new ControlDBPupuseria(this);
        listaFormaPago = new ArrayList<FormaPago>();
        nombreFormaPago = new ArrayList<String>();
        listViewFormasPago = (ListView) findViewById(R.id.listViewFormasPago);
    }

    public void servicioPHP(View v) {
        String url = "";
        url = urlHostingGratuito;
        Log.e("Esta es la url que se manda",url);
        String formasPago = ControladorServicio.obtenerRespuestaPeticion(url, this);
        try {
            listaFormaPago.addAll(ControladorServicio.obtenerFormasPago(formasPago, this));
            actualizarListView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void actualizarListView() {
        String dato = "";
        nombreFormaPago.clear();
        for (int i = 0; i < listaFormaPago.size(); i++) {
            dato = listaFormaPago.get(i).getIdFormaPago() + " "
                    + listaFormaPago.get(i).getFormaPago();
            Log.e("Esta es el dato",dato);
            nombreFormaPago.add(dato);
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombreFormaPago);
        listViewFormasPago.setAdapter(adaptador);
    }

}