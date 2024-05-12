//package com.example.pupuseria;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class GD21001MenuActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_gd21001_menu);
//    }
//}
package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class GD21001MenuActivity extends ListActivity {

    String [] menu={"Administrador", "Tienda", "Producto"};
    String[] activities={"AdministradorMenuActivity", "TiendaMenuActivity", "ProductoMenuActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        if(position!=3){
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