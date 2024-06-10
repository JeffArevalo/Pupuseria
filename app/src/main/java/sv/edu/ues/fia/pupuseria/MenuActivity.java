package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MenuActivity extends ListActivity {
    String[] menu={"Menu AS21004","Menu CH11049","Menu EE19001","Menu GD21001","Menu VP20007","Menu Servicios Web","LLenar Base de Datos"};
    String[] activities={"AS21004Activity","CH11049Activity","EE19001MenuActivity","GD21001MenuActivity","VP20007Activity","ServiciosWebMenuActivity"};
    ControlDBPupuseria BDhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menu));
        BDhelper=new ControlDBPupuseria(this);
    }

    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);

        if(position!=6){

            String nombreValue=activities[position];

            try{
                Class<?>
                        clase=Class.forName("sv.edu.ues.fia.pupuseria."+nombreValue);
                Intent inte = new Intent(this,clase);
                this.startActivity(inte);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }else{
           //
        }
    }

}
