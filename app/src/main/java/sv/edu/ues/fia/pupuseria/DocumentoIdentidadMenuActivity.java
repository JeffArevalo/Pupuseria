package sv.edu.ues.fia.pupuseria;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DocumentoIdentidadMenuActivity extends ListActivity {

    // Lista del menú de Documento
    String[] menu = {"Insertar Documento identidad", "Eliminar Documento identidad", "Consultar Documento identidad", "Actualizar Documento identidad"};
    String[] activities = {"DocumentoIdentidadInsertarActivity", "DocumentoIdentidadEliminarActivity", "DocumentoIdentidadConsultarActivity", "DocumentoIdentidadActualizarActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = getListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String nombreValue = activities[position];

        try {
            Class<?> clase = Class.forName("sv.edu.ues.fia.pupuseria." + nombreValue);
            Intent intent = new Intent(this, clase);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}