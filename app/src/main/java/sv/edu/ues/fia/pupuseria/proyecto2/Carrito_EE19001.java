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
public class Carrito_EE19001 extends AppCompatActivity {
    static List<Carrito_Items> listaItems;
    static List<String> texto_lista;
    ListView lista;
    private final String url="https://grupo02pupuseria.000webhostapp.com/pupuseria_ws_webhost/pedido/query_pedido_usuario.php?";
    private final String url_finalizar="https://grupo02pupuseria.000webhostapp.com/pupuseria_ws_webhost/pedido/update_estado_pedido.php?";
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_ee19001);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        listaItems = new ArrayList<>();
        texto_lista = new ArrayList<>();
        lista = (ListView) findViewById(R.id.listView1);

        // llenando los productos seleccionados
        String url_final = url + "ID_USUARIO=1";
        String respuesta_http = ControladorServicio.obtenerRespuestaPeticion(url_final,this);
        //Toast.makeText(this, String.valueOf(respuesta_http), Toast.LENGTH_SHORT).show();
        try{
            listaItems.addAll(ControladorServicio.obtenerItems(respuesta_http,this));
            actualizarListView();
        }
        catch (Exception e){
            Toast.makeText(this, String.valueOf(e), Toast.LENGTH_SHORT).show();
        }

        // on click metodo para los items
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i  = new Intent(Carrito_EE19001.this, Modificar_Cantidad_Item_EE19001.class);
                i.putExtra("PRODUCTO",  listaItems.get(position));
                startActivity(i);
            }
        });

    }

    private void actualizarListView() {
        texto_lista.clear();
        String dato;
        for (int i = 0; i < listaItems.size(); i++) {
            dato = listaItems.get(i).getNOMBRE_PRODUCTO() + " || Cantidad: " + listaItems.get(i).getCANTIDAD() + " || Subtotal: " + listaItems.get(i).getSUBTOTAL();
            texto_lista.add(dato);
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, texto_lista);
        lista.setAdapter(adaptador);
    }

    public void finalizar_compra(View v){
        if(v.getId()==R.id.btn_finalizar_compra){
            String url_final = url_finalizar + "ID_PEDIDO="+listaItems.get(0).getID_PEDIDO()+"&ESTADO=1";
            String respuesta_http = ControladorServicio.obtenerRespuestaPeticion(url_final,this);
            Log.v("Error de Conexion", respuesta_http);
            if(Integer.valueOf(respuesta_http)==1){
                Intent i  = new Intent(Carrito_EE19001.this, Finalizar_Compra_EE19001.class);
                startActivity(i);
            }
            else{
                Toast.makeText(this, "Hubo un error", Toast.LENGTH_SHORT).show();
            }
        }
    }
}