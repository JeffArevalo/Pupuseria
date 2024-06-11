package sv.edu.ues.fia.pupuseria.proyecto2;
import sv.edu.ues.fia.pupuseria.R;
import sv.edu.ues.fia.pupuseria.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import android.app.ListActivity;

@SuppressLint("NewApi")
public class Modificar_Cantidad_Item_EE19001 extends AppCompatActivity {
    static List<Carrito_Items> listaItems;
    EditText nombre_producto;
    EditText cant;
    private String url="https://grupo02pupuseria.000webhostapp.com/pupuseria_ws_webhost/contiene/update_contiene_cantidad.php?";
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_cantidad_item_ee19001);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //inicializando
        nombre_producto = (EditText) findViewById(R.id.nombre_producto);
        cant = (EditText) findViewById(R.id.cant);
        listaItems = new ArrayList<Carrito_Items>();
        //obteniendo producto de la view anterior
        Intent intent = getIntent();
        if (intent.getParcelableExtra("PRODUCTO") != null) {
            listaItems.add(intent.getParcelableExtra("PRODUCTO"));
            nombre_producto.setText(String.valueOf(listaItems.get(0).getNOMBRE_PRODUCTO()));
            cant.setText(String.valueOf(listaItems.get(0).getCANTIDAD()));
        }

    }
    public void servicio(View view){
        if(listaItems!=null){
            if(view.getId() == R.id.btn_plus ) {
                listaItems.get(0).setCANTIDAD(listaItems.get(0).getCANTIDAD() + 1) ;
                cant.setText(String.valueOf(listaItems.get(0).getCANTIDAD()));
                String url_final = url + "ID_PRODUCTO="+ listaItems.get(0).getID_PRODUCTO()+"&ID_PEDIDO="+listaItems.get(0).getID_PEDIDO()+"&CANTIDAD="+listaItems.get(0).getCANTIDAD();
                Log.v("Error de conexion",url_final);
                String respuesta_http = String.valueOf(ControladorServicio.obtenerRespuestaPeticion(url_final,this));
                if(Integer.valueOf(respuesta_http)==1){
                    Toast.makeText(this, "ANADIDO UN PRODUCTO", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
            if(view.getId() == R.id.btn_minus ){
                listaItems.get(0).setCANTIDAD(listaItems.get(0).getCANTIDAD() - 1) ;
                cant.setText(String.valueOf(listaItems.get(0).getCANTIDAD()));
                String url_final = url + "ID_PRODUCTO="+listaItems.get(0).getID_PRODUCTO()+"&ID_PEDIDO="+listaItems.get(0).getID_PEDIDO()+"&CANTIDAD="+listaItems.get(0).getCANTIDAD();
                String respuesta_http = String.valueOf(ControladorServicio.obtenerRespuestaPeticion(url_final,this));
                Log.v("Error de conexion",respuesta_http);
                if(Integer.valueOf(respuesta_http)==1){
                    Toast.makeText(this, "Disminuido UN PRODUCTO", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}