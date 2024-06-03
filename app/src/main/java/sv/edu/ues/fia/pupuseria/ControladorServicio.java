package sv.edu.ues.fia.pupuseria;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
public class ControladorServicio {

    public static String obtenerRespuestaPeticion(String url, Context ctx) {
        String respuesta = " ";
        // Estableciendo tiempo de espera del servicio
        HttpParams parametros = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(parametros, 3000);
        HttpConnectionParams.setSoTimeout(parametros, 5000);
        // Creando objetos de conexion
        HttpClient cliente = new DefaultHttpClient(parametros);
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpRespuesta = cliente.execute(httpGet);
            StatusLine estado = httpRespuesta.getStatusLine();
            int codigoEstado = estado.getStatusCode();
            if (codigoEstado == 200) {
                HttpEntity entidad = httpRespuesta.getEntity();
                respuesta = EntityUtils.toString(entidad);
            }
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en la conexion", Toast.LENGTH_LONG).show();
        // Desplegando el error en el LogCat
            Log.v("Error de Conexion", e.toString());
        }
        return respuesta;
    }

    public static void insertarLicenciaWSC(String peticion, Context ctx){
        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            int respuesta = Integer.parseInt(json);
            if (respuesta == 1)
                Toast.makeText(ctx, "Licencia ingresada", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(ctx, "Error Licencia duplicada", Toast.LENGTH_LONG).show();
        }
    }
    public static void insertarVehiculoWSC(String peticion, Context ctx){
        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            int respuesta = Integer.parseInt(json);
            if (respuesta == 1)
                Toast.makeText(ctx, "Vehiculo ingresado", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(ctx, "Error Vehiculo duplicado", Toast.LENGTH_LONG).show();
        }
    }

}
