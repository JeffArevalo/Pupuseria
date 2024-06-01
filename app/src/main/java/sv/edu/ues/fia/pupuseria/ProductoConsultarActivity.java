package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProductoConsultarActivity extends Activity {

    ControlDBPupuseria helper;
    EditText editIdPrCon;
    EditText editNomPCon;
    EditText editDesPCon;
    EditText editPrecCon;
    EditText editEstPCon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_consultar);

        helper = new ControlDBPupuseria(this);
        editIdPrCon = (EditText) findViewById(R.id.editIdProdRetrv);
        editNomPCon = (EditText) findViewById(R.id.editNomProdRetrv);
        editDesPCon = (EditText) findViewById(R.id.editDescripProdRetrv);
        editPrecCon = (EditText) findViewById(R.id.editPrecProdRetrv);
        editEstPCon = (EditText) findViewById(R.id.editEstadoProdRetrv);

    }

    public void consultarProducto(View v){
        try{
            if(editIdPrCon.getText().toString().isEmpty()){
                Toast.makeText(this, "El Campo ID de Producto se esta enviando vacio, por favor completar", Toast.LENGTH_SHORT).show();
            }else{
                helper.abrir();
                Producto p = helper.consultarProducto(Integer.parseInt(editIdPrCon.getText().toString()));
                helper.cerrar();

                if(p == null){
                    Toast.makeText(this, "Producto con ID: " + editIdPrCon.getText().toString() + " no existe o no se encontro."
                            , Toast.LENGTH_LONG).show();
                }else{
                    editNomPCon.setText(p.getNombre_producto());
                    editDesPCon.setText(p.getDescripcion_producto());
                    editPrecCon.setText(String.valueOf(p.getPrecio_producto()));
                    editEstPCon.setText(String.valueOf(p.getEstado_producto()));
                }
            }
        }catch (Exception e){
            Toast.makeText(this, "A ocurrido un error durante la ejecucion en Consultar Producto", Toast.LENGTH_SHORT).show();
        }
    }

    public void limpiarCampos(View v){
        editIdPrCon.setText("");
        editNomPCon.setText("");
        editDesPCon.setText("");
        editPrecCon.setText("");
        editEstPCon.setText("");
    }
}