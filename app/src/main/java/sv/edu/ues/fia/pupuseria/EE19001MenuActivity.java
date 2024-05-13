package sv.edu.ues.fia.pupuseria;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EE19001MenuActivity extends ListActivity {
    String[] menu={"Tabla Licencia","Tabla Vehiculo","Tabla Repartidor"};
    String[] activities={"LicenciaMenuActivity","VehiculoMenuActivity","RepartidorMenuActivity"};
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
            Class<?> clase=Class.forName("sv.edu.ues.fia.pupuseria."+nombreValue);
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}