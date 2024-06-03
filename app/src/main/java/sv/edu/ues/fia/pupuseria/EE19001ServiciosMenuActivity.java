package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EE19001ServiciosMenuActivity extends ListActivity {
    String [] menu={"InsertarLicencia", "InsertarVehiclo"};
    String[] activities={"ServicioInsertarLicenciaActivity", "ServicioInsertarVehiculoActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_ee19001_servicios_menu);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        if(position!=2){
            String nombreValue = activities[position];
            try{
                Class<?> clase=Class.forName("sv.edu.ues.fia.pupuseria."+nombreValue);
                Intent inte = new Intent(this, clase);
                this.startActivity(inte);
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}