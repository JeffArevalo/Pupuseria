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
        try{
            if(editIdProdDel.getText().toString().isEmpty()){
                Toast.makeText(this, "El Campo ID Producto se esta enviando vacio, por favor completar", Toast.LENGTH_SHORT).show();
            }else{
                String regDel;
                Producto p = new Producto();
                p.setId_producto(Integer.parseInt(editIdProdDel.getText().toString()));
                helper.abrir();
                regDel=helper.eliminarProducto(p);
                helper.cerrar();
                Toast.makeText(this, regDel, Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this, "A ocurrido un error durante la ejecucion en Eliminar Producto", Toast.LENGTH_SHORT).show();
        }

    }
}