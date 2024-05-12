package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_menu);
        lanzarGD21001MenuActivity();
    }

    public void lanzarGD21001MenuActivity(){
        Intent i = new Intent(this, GD21001MenuActivity.class);
        startActivity(i);
    }
}