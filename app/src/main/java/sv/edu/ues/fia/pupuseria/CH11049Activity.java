package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CH11049Activity extends ListActivity {

    String[] menu = {"Tabla Usuario", "Tabla Direccion", "Tabla Documento_Identidad", "DocumentoIdentidadActivity"};
    String[] activities = {"UsuarioMenuActivity", "DireccionMenuActivity", "DocumentoIdentidadMenuActivity"};



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String nombreValue = activities[position];
        try {
            Class<?> clase = Class.forName("sv.edu.ues.fia.pupuseria." + nombreValue);
            Intent inte = new Intent(this, clase);
            startActivity(inte);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
