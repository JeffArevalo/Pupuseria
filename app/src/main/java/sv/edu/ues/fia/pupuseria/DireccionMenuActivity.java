package sv.edu.ues.fia.pupuseria;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DireccionMenuActivity extends ListActivity {

    // Lista del menú de Dirección
    String[] menu={"Insertar Dirección","Eliminar Dirección","Consultar Dirección", "Actualizar Dirección"};
    String[] activities={"DireccionInsertarActivity","DireccionEliminarActivity","DireccionConsultarActivity", "DireccionActualizarActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = getListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }

    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        String nombreValue=activities[position];

        try{
            Class<?> clase=Class.forName("sv.edu.ues.fia.pupuseria."+nombreValue); // Asegúrate de reemplazar "tu.paquete.aqui" con el nombre de tu paquete
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
