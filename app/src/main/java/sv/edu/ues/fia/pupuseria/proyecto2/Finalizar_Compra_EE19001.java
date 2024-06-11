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
public class Finalizar_Compra_EE19001 extends AppCompatActivity {


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalizar_compra_ee19001);

    }
    public void menu_principal_click(View v){
        if(v.getId()==R.id.btn_menu_principal){
            Intent i  = new Intent(Finalizar_Compra_EE19001.this, MenuActivity.class);
            startActivity(i);
        }
    }
}