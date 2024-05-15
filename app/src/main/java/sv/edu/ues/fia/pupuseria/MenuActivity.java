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
    String[] menu={"Menu AS21004","Menu CH11049","Menu EE19001","Menu GD21001","Menu VP20007","LLenar Base de Datos"};
    String[] activities={"","CH11049Activity","","GD21001MenuActivity","VP20007Activity"};
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

        if(position!=5){

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