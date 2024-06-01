package sv.edu.ues.fia.pupuseria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ProductoActualizarActivity extends Activity {

    ControlDBPupuseria helper;
    EditText editIdPrUpdt;
    EditText editIdPrUpdt2;
    EditText editNomPUpdt;
    EditText editDesPUpdt;
    EditText editPrecUpdt;
    EditText editEstPUpdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto_actualizar);

        helper = new ControlDBPupuseria(this);
        editIdPrUpdt = (EditText) findViewById(R.id.editIdProdUpdt);
        editIdPrUpdt2 = (EditText) findViewById(R.id.editIdProdUpdt2);
        editNomPUpdt = (EditText) findViewById(R.id.editNomProdUpdt);
        editDesPUpdt = (EditText) findViewById(R.id.editDescripProdUpdt);
        editPrecUpdt = (EditText) findViewById(R.id.editPrecProdUpdt);
        editEstPUpdt = (EditText) findViewById(R.id.editEstadoProdUpdt);
    }

    //editar campos lo que hace es traer los valores de los campos y rellenarlos en los espacios para asi ver que debe cambiar luego
    public void editarCampos(View v){
        try{
            //verifica que se mande el campo id que se desea actualizar
            if(editIdPrUpdt.getText().toString().isEmpty() ) {
                //si esta vacio envia un toast
                Toast.makeText(this, "No ha ingresado ningun ID de Producto", Toast.LENGTH_SHORT).show();
            }else{
                //si esta lleno realiza la funcion de consultar para llenar los campos con los datos actuales para editar los necesarios
                helper.abrir();
                Producto p = helper.consultarProducto(Integer.parseInt(editIdPrUpdt.getText().toString()));
                helper.cerrar();

                if(p == null){
                    Toast.makeText(this, "Producto con ID: " + editIdPrUpdt.getText().toString() + " no existe o no se encontro."
                            , Toast.LENGTH_LONG).show();
                }else{
                    editIdPrUpdt2.setText(String.valueOf(p.getId_producto()));
                    editNomPUpdt.setText(p.getNombre_producto());
                    editDesPUpdt.setText(p.getDescripcion_producto());
                    editPrecUpdt.setText(String.valueOf(p.getPrecio_producto()));
                    editEstPUpdt.setText(String.valueOf(p.getEstado_producto()));
                }
            }
        }catch (Exception e){
            Toast.makeText(this, "A ocurrido un error durante la ejecucion en Editar en Actualizar Producto", Toast.LENGTH_SHORT).show();
        }


    }

    public void actualizarProductos(View v){
        try{
            if(editIdPrUpdt2.getText().toString().isEmpty()){
                Toast.makeText(this, "El nuevo valor de ID de Producto se esta enviando vacio", Toast.LENGTH_SHORT).show();
            }else{
                if(Short.parseShort(editEstPUpdt.getText().toString())<0 || Short.parseShort(editEstPUpdt.getText().toString())>1){
                    Toast.makeText(ProductoActualizarActivity.this, "Ingresar por favor el campo del Estado de producto 0 o 1", Toast.LENGTH_SHORT).show();
                }else{
                    Producto pUpdt = new Producto();
                    pUpdt.setId_producto(Integer.parseInt(editIdPrUpdt2.getText().toString()));
                    pUpdt.setNombre_producto(editNomPUpdt.getText().toString());
                    pUpdt.setDescripcion_producto(editDesPUpdt.getText().toString());
                    pUpdt.setPrecio_producto(Float.parseFloat(editPrecUpdt.getText().toString()));
                    pUpdt.setEstado_producto(Short.parseShort(editEstPUpdt.getText().toString()));

                    helper.abrir();
                    String estado = helper.actualizarProducto(pUpdt);
                    helper.cerrar();

                    Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
                }
            }
        }catch (Exception e){
            Toast.makeText(this, "A ocurrido un error durante la ejecucion en Actualizar Producto", Toast.LENGTH_SHORT).show();
        }

    }

    public void limpiarCamposPA(View v){
        editIdPrUpdt.setText("");
        editIdPrUpdt2.setText("");
        editNomPUpdt.setText("");
        editDesPUpdt.setText("");
        editPrecUpdt.setText("");
        editEstPUpdt.setText("");
    }
}