package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ProductoMenuActivity extends ListActivity {

    String[] menu ={"Insertar", "Actualizar", "Consultar", "Eliminar"};
    String[] activities={"ProductoInsertarActivity", "ProductoActualizarActivity",
            "ProductoConsultarActivity", "ProductoEliminarActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_producto_menu);

        ListView listView = getListView();
        listView.setBackgroundColor(Color.rgb(242, 230, 227));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu);
        setListAdapter(adapter);
    }

    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);
        String nombreValue=activities[position];

        l.getChildAt(position).setBackgroundColor(Color.rgb(231,167, 151));
        try{
            Class<?> clase=Class.forName("sv.edu.ues.fia.pupuseria."+nombreValue);
            Intent inte = new Intent(this, clase);
            this.startActivity(inte);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}