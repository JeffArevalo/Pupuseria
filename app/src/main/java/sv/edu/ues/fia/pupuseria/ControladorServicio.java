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
import java.util.ArrayList;
import java.util.List;
public class ControladorServicio {

    public static String obtenerRespuestaPeticion(String url,
                                                  Context ctx) {
        String respuesta = " ";
        // Estableciendo tiempo de espera del servicio
        HttpParams parametros = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(parametros, 10000);
        HttpConnectionParams.setSoTimeout(parametros, 10000);
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
            Toast.makeText(ctx, "Error en la conexion",
                            Toast.LENGTH_LONG)
                    .show();
            // Desplegando el error en el LogCat
            Log.v("Error de Conexion", e.toString());
        }
        return respuesta;
    }

    public static String obtenerRespuestaPost(String url, JSONObject obj, Context ctx) {
        String respuesta = " ";
        try {
            HttpParams parametros = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(parametros,
                    3000);
            HttpConnectionParams.setSoTimeout(parametros, 5000);
            HttpClient cliente = new DefaultHttpClient(parametros);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("content-type", "application/json");
            StringEntity nuevaEntidad = new
                    StringEntity(obj.toString());
            httpPost.setEntity(nuevaEntidad);
            Log.v("Peticion",url);
            Log.v("POST", httpPost.toString());
            HttpResponse httpRespuesta = cliente.execute(httpPost);
            StatusLine estado = httpRespuesta.getStatusLine();
            int codigoEstado = estado.getStatusCode();
            if (codigoEstado == 200) {
                respuesta = Integer.toString(codigoEstado);
                Log.v("respuesta",respuesta);
            }
            else{
                Log.v("respuesta",Integer.toString(codigoEstado));
            }
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en la conexion",
                            Toast.LENGTH_LONG)
                    .show();
            // Desplegando el error en el LogCat
            Log.v("Error de Conexion", e.toString());
        }
        return respuesta;
    }

    //MOSTRAR TODAS LAS FORMAS DE PAGO
    public static List<FormaPago> obtenerFormasPago(String json, Context ctx) {
        List<FormaPago> listaFormaPago = new ArrayList<>();
        try {
            JSONArray materiasJSON = new JSONArray(json);
            for (int i = 0; i < materiasJSON.length(); i++) {
                JSONObject obj = materiasJSON.getJSONObject(i);
                FormaPago forma = new FormaPago();
                forma.setIdFormaPago(obj.getInt("ID_FORMAPAGO"));
                forma.setFormaPago(obj.getString("NOMBRE_FORMAPAGO"));
                listaFormaPago.add(forma);
            }
            return listaFormaPago;
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en parseOO de JSON",
                            Toast.LENGTH_LONG)
                    .show();
            return null;
        }
    }

    //INSERTAR UNA FORMA DE PAGO
    public static void insertarFormaPago(String peticion, Context ctx) {
        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            JSONObject resultado = new JSONObject(json);
            Toast.makeText(ctx, "Registro ingresado"+
                            resultado.getJSONArray("resultado").toString(), Toast.LENGTH_LONG)
                    .show();
            int respuesta = resultado.getInt("resultado");
            if (respuesta == 1)
                Toast.makeText(ctx, "Registro ingresado",
                                Toast.LENGTH_LONG)
                        .show();
            else
                Toast.makeText(ctx, "Error registro duplicado",
                        Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void insertarAdministrador(String peticion, Context ctx){
        String json = obtenerRespuestaPeticion(peticion, ctx);
        try{
            JSONObject result = new JSONObject(json);
            Toast.makeText(ctx, "Registro ingresado"+ result.getJSONArray("resultado").toString(), Toast.LENGTH_LONG).show();
            int respuesta = result.getInt("resultado");
            if (respuesta == 1){
                Toast.makeText(ctx, "Registro ingresado", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(ctx, "Error registro duplicado", Toast.LENGTH_LONG).show();
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
    public static void insertarUsuario(String peticion, Context ctx) {
        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            JSONObject resultado = new JSONObject(json);
            Toast.makeText(ctx, "Registro ingresado" + resultado.getJSONArray("resultado").toString(), Toast.LENGTH_LONG).show();
            int respuesta = resultado.getInt("resultado");
            if (respuesta == 1)
                Toast.makeText(ctx, "Registro ingresado", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(ctx, "Error registro duplicado", Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static List<Administrador> obtenerAdministrador(String json, Context ctx) {
        List<Administrador> listaAdmin = new ArrayList<>();
        try {
            JSONArray adminJSON = new JSONArray(json);
            for (int i = 0; i < adminJSON.length(); i++) {
                JSONObject obj = adminJSON.getJSONObject(i);
                Administrador admin = new Administrador();
                admin.setId_administrador(obj.getInt("ID_ADMINISTRADOR"));
                admin.setNombre_administrador(obj.getString("NOMBRE_ADMINISTRADOR"));
                admin.setApellido_administrador(obj.getString("APELLIDO_ADMINISTRADOR"));
                admin.setTelefono_administrador(obj.getString("TELEFONO_ADMINISTRADOR"));
                listaAdmin.add(admin);
            }
            return listaAdmin;
        } catch (Exception e) {
            Toast.makeText(ctx, "Error en parseOO de JSON", Toast.LENGTH_LONG).show();
            return null;
        }
    }
    public static void eliminarUsuario(String peticion, Context ctx) {
        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            JSONObject resultado = new JSONObject(json);
            String status = resultado.getString("status");
            if ("success".equals(status)) {
                Toast.makeText(ctx, "Usuario eliminado correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ctx, "Error al eliminar usuario", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(ctx, "Error en la respuesta del servidor", Toast.LENGTH_SHORT).show();
        }
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

    public static void insertarDepartamento(String peticion, Context ctx) {
        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            JSONObject resultado = new JSONObject(json);
            Toast.makeText(ctx, "Registro ingresado"+
                            resultado.getJSONArray("resultado").toString(), Toast.LENGTH_LONG)
                    .show();
            int respuesta = resultado.getInt("resultado");
            if (respuesta == 1)
                Toast.makeText(ctx, "Registro ingresado",
                                Toast.LENGTH_LONG)
                        .show();
            else
                Toast.makeText(ctx, "Error registro duplicado",
                        Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void insertarMunicipio(String peticion, Context ctx) {
        String json = obtenerRespuestaPeticion(peticion, ctx);
        try {
            JSONObject resultado = new JSONObject(json);
            Toast.makeText(ctx, "Registro ingresado"+
                            resultado.getJSONArray("resultado").toString(), Toast.LENGTH_LONG)
                    .show();
            int respuesta = resultado.getInt("resultado");
            if (respuesta == 1)
                Toast.makeText(ctx, "Registro ingresado",
                                Toast.LENGTH_LONG)
                        .show();
            else
                Toast.makeText(ctx, "Error registro duplicado",
                        Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
