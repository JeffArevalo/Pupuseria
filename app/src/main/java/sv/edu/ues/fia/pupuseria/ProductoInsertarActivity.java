package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProductoInsertarActivity extends Activity {

    ControlDBPupuseria helper;
    EditText editIdPrInsert;
    EditText editNomPInsert;
    EditText editDesPInsert;
    EditText editPrecPInsert;
    EditText editEstPInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_insertar);

        helper = new ControlDBPupuseria(this);
        editIdPrInsert = (EditText) findViewById(R.id.editIdProdInsrt);
        editNomPInsert = (EditText) findViewById(R.id.editNomProdInsrt);
        editDesPInsert = (EditText) findViewById(R.id.editDescripProdInsrt);
        editPrecPInsert = (EditText) findViewById(R.id.editPrecProdInsrt);
        editEstPInsert = (EditText) findViewById(R.id.editEstadoProdInsrt);
    }

    public void insertProd(View v){
        try{
            if(editIdPrInsert.getText().toString().isEmpty()){
                Toast.makeText(ProductoInsertarActivity.this, "Ingresar por favor el campo del ID", Toast.LENGTH_SHORT).show();
            }else{
                if(Short.parseShort(editEstPInsert.getText().toString())<0 || Short.parseShort(editEstPInsert.getText().toString())>1){
                    Toast.makeText(ProductoInsertarActivity.this, "Ingresar por favor el campo del Estado de producto 0 o 1", Toast.LENGTH_SHORT).show();
                }else{
                    //creacion de variables para manipular los campos
                    String idProd = editIdPrInsert.getText().toString();
                    //idprod que es String se pasa a int
                    int idProdC = Integer.parseInt(idProd);
                    String nomProd = editNomPInsert.getText().toString();
                    String descProd = editDesPInsert.getText().toString();
                    String precProd = editPrecPInsert.getText().toString();
                    //precProd que es String se pasa a float
                    float precProdC = Float.parseFloat(precProd);
                    String estProd = editEstPInsert.getText().toString();
                    //estProd que es String se pasa a short
                    short estProdC = Short.parseShort(estProd);

                    // insercion
                    String regInsert;

                    Producto p = new Producto();
                    p.setId_producto(idProdC);
                    p.setNombre_producto(nomProd);
                    p.setDescripcion_producto(descProd);
                    p.setPrecio_producto(precProdC);
                    p.setEstado_producto(estProdC);

                    helper.abrir();
                    regInsert=helper.insertarProducto(p);
                    helper.cerrar();

                    Toast.makeText(this, regInsert, Toast.LENGTH_SHORT).show();
                }

            }
        }catch (Exception e){
            Toast.makeText(this, "A ocurrido un error durante la ejecucion en Insertar en Producto", Toast.LENGTH_SHORT).show();
        }

    }

    public void clcTxt(View v){
        editIdPrInsert.setText("");
        editNomPInsert.setText("");
        editDesPInsert.setText("");
        editPrecPInsert.setText("");
        editEstPInsert.setText("");
    }

}