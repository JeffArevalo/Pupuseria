package sv.edu.ues.fia.pupuseria;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class LicenciaMenuActivity extends ListActivity {

    String[] menu={"Insertar Licencia","Eliminar Licencia","Consultar Licencia", "Actualizar Licencia"};
    String[] activities={"LicenciaInsertarActivity","LicenciaEliminarActivity","LicenciaConsultarActivity", "LicenciaActualizarActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = getListView();
        listView.setBackgroundColor(Color.rgb(242, 230, 227));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,menu);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String nombreValue = activities[position];
        l.getChildAt(position).setBackgroundColor(Color.rgb(231,167, 151));

        try{
            Class<?> clase = Class.forName("sv.edu.ues.fia.pupuseria."+nombreValue);
            Intent inte = new Intent(this,clase);
            this.startActivity(inte);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}