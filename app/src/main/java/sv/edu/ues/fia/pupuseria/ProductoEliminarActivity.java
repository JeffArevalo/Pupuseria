package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProductoEliminarActivity extends Activity {

    EditText editIdProdDel;
    ControlDBPupuseria helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_eliminar);

        helper = new ControlDBPupuseria(this);
        editIdProdDel=(EditText) findViewById(R.id.editIdProdDlt);
    }

    public void eliminarCamposProducto(View v){
        String regDel;
        Producto p = new Producto();
        p.setId_producto(Integer.parseInt(editIdProdDel.getText().toString()));
        helper.abrir();
        regDel=helper.eliminarProducto(p);
        helper.cerrar();
        Toast.makeText(this, regDel, Toast.LENGTH_SHORT).show();
    }
}