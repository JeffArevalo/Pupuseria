package sv.edu.ues.fia.pupuseria;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ControlDBPupuseria {
    // Campos para la tabla ADMINISTRADOR
    private static final String[] camposAdministrador = new String[]{"ID_ADMINISTRADOR", "NOMBRE_ADMINISTRADOR", "APELLIDO_ADMINISTRADOR", "TELEFONO_ADMINISTRADOR"};

    // Campos para la tabla CONTIENE
    private static final String[] camposContiene = new String[]{"ID_PEDIDO", "ID_PRODUCTO"};

    // Campos para la tabla DEPARTAMENTO
    private static final String[] camposDepartamento = new String[]{"ID_DEPARTAMENTO", "NOMBRE_DEPARTAMENTO"};

    // Campos para la tabla DIRECCION
    private static final String[] camposDireccion = new String[]{"ID_DIRECCION", "ID_DISTRITO", "DIRECCION"};

    // Campos para la tabla DISTRITO
    private static final String[] camposDistrito = new String[]{"ID_DISTRITO", "ID_MUNICIPIO", "NOMBRE_DISTRITO"};

    // Campos para la tabla DOCUMENTO_IDENTIDAD
    private static final String[] camposDocumentoIdentidad = new String[]{"ID_DOCUMENTO_IDENTIDAD", "TIPO_DOCUMENTO_IDENTIDAD", "NUMERO_DOCUMENTO_IDENTIDAD"};

    // Campos para la tabla EVENTO_ESPECIAL
    private static final String[] camposEventoEspecial = new String[]{"ID_EVENTO_ESPECIAL", "MONTO_MINIMO_EVENTO_ESPECIAL", "MONTO_MAXIMO_EVENTO_ESPECIAL"};

    // Campos para la tabla FORMAPAGO
    private static final String[] camposFormaPago = new String[]{"ID_FORMAPAGO", "NOMBRE_FORMAPAGO"};

    // Campos para la tabla LICENCIA
    private static final String[] camposLicencia = new String[]{"ID_LICENCIA", "TIPO_LICENCIA", "NUMERO_LICENCIA"};

    // Campos para la tabla MUNICIPIO
    private static final String[] camposMunicipio = new String[]{"ID_MUNICIPIO", "ID_DEPARTAMENTO", "NOMBRE_MUNICIPIO"};

    // Campos para la tabla OFRECE
    private static final String[] camposOfrece = new String[]{"ID_PRODUCTO", "ID_DIRECCION", "ID_TIENDA"};

    // Campos para la tabla PEDIDO
    private static final String[] camposPedido = new String[]{"ID_PEDIDO", "ID_EVENTO_ESPECIAL", "ID_REPARTIDOR", "ID_USUARIO"};

    // Campos para la tabla PRODUCTO
    private static final String[] camposProducto = new String[]{"ID_PRODUCTO", "NOMBRE_PRODUCTO", "DESCRIPCION_PRODUCTO", "PRECIO_PRODUCTO", "ESTADO_PRODUCTO"};

    // Campos para la tabla REPARTIDOR
    private static final String[] camposRepartidor = new String[]{"ID_REPARTIDOR", "ID_DIRECCION", "ID_VEHICULO", "ID_LICENCIA", "ID_DOCUMENTO_IDENTIDAD", "NOMBRE_REPARTIDOR", "APELLIDO_REPARTIDOR", "TELEFONO_REPARTIDOR"};

    // Campos para la tabla TIENDA
    private static final String[] camposTienda = new String[]{"ID_DIRECCION", "ID_TIENDA", "ID_ADMINISTRADOR", "NOMBRE_TIENDA", "TELEFONO_TIENDA"};

    // Campos para la tabla VEHICULO
    private static final String[] camposVehiculo = new String[]{"ID_VEHICULO", "PLACA_VEHICULO", "TIPO_VEHICULO"};

    // Campos para la tabla VENTA
    private static final String[] camposVenta = new String[]{"ID_VENTA", "ID_PEDIDO", "ID_FORMAPAGO", "ID_DIRECCION", "MONTO_VENTA", "FECHA_VENTA", "HORA_VENTA"};

    // Campos para la tabla USUARIO
    private static final String[] camposUsuario = new String[]{"ID_USUARIO", "ID_DIRECCION", "ID_DOCUMENTO_IDENTIDAD", "NOMBRE_USUARIO", "APELLIDO_USUARIO", "TELEFONO_USUARIO"};

    // Campos para la tabla USER
    private static final String[] camposUser = new String[]{"id_usuario", "nom_usuario", "clave"};

    // Campos para la tabla OPCIONCRUD
    private static final String[] camposOpcionCrud = new String[]{"id_opcion_crud", "des_opcion"};

    // Campos para la tabla ACCESOUSUARIO
    private static final String[] camposAccesoUsuario = new String[]{"id_acceso", "id_usuario", "id-opcion"};


    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;


    public ControlDBPupuseria(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "PupuseriaDB.s3db"; // Aquí se añade el nombre de la base de datos
        private static final int VERSION = 1;

        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {

                // Crear tabla ADMINISTRADOR
                db.execSQL("CREATE TABLE ADMINISTRADOR (" +
                        "ID_ADMINISTRADOR INTEGER PRIMARY KEY," +
                        "NOMBRE_ADMINISTRADOR TEXT NOT NULL," +
                        "APELLIDO_ADMINISTRADOR TEXT NOT NULL," +
                        "TELEFONO_ADMINISTRADOR TEXT NOT NULL)");

                // Crear tabla CONTIENE
                db.execSQL("CREATE TABLE CONTIENE (" +
                        "ID_PEDIDO INTEGER NOT NULL," +
                        "ID_PRODUCTO INTEGER NOT NULL," +
                        "PRIMARY KEY (ID_PEDIDO, ID_PRODUCTO)," +
                        "FOREIGN KEY (ID_PEDIDO) REFERENCES PEDIDO(ID_PEDIDO) ON DELETE RESTRICT ON UPDATE RESTRICT," +
                        "FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO(ID_PRODUCTO) ON DELETE RESTRICT ON UPDATE RESTRICT)");

                // Crear tabla DEPARTAMENTO
                db.execSQL("CREATE TABLE DEPARTAMENTO (" +
                        "ID_DEPARTAMENTO INTEGER PRIMARY KEY," +
                        "NOMBRE_DEPARTAMENTO TEXT NOT NULL)");

                // Crear tabla DIRECCION
                db.execSQL("CREATE TABLE DIRECCION (" +
                        "ID_DIRECCION INTEGER PRIMARY KEY," +
                        "ID_DISTRITO INTEGER NOT NULL," +
                        "DIRECCION TEXT NOT NULL," +
                        "FOREIGN KEY (ID_DISTRITO) REFERENCES DISTRITO(ID_DISTRITO) ON DELETE RESTRICT ON UPDATE RESTRICT)");

                // Crear tabla DISTRITO
                db.execSQL("CREATE TABLE DISTRITO (" +
                        "ID_DISTRITO INTEGER PRIMARY KEY," +
                        "ID_MUNICIPIO INTEGER NOT NULL," +
                        "NOMBRE_DISTRITO TEXT NOT NULL," +
                        "FOREIGN KEY (ID_MUNICIPIO) REFERENCES MUNICIPIO(ID_MUNICIPIO) ON DELETE RESTRICT ON UPDATE RESTRICT)");

                // Crear tabla DOCUMENTO_IDENTIDAD
                db.execSQL("CREATE TABLE DOCUMENTO_IDENTIDAD (" +
                        "ID_DOCUMENTO_IDENTIDAD INTEGER PRIMARY KEY," +
                        "TIPO_DOCUMENTO_IDENTIDAD TEXT NOT NULL," +
                        "NUMERO_DOCUMENTO_IDENTIDAD TEXT NOT NULL)");

                // Crear tabla EVENTO_ESPECIAL
                db.execSQL("CREATE TABLE EVENTO_ESPECIAL (" +
                        "ID_EVENTO_ESPECIAL INTEGER PRIMARY KEY," +
                        "MONTO_MINIMO_EVENTO_ESPECIAL REAL NOT NULL," +
                        "MONTO_MAXIMO_EVENTO_ESPECIAL REAL NOT NULL)");

                // Crear tabla FORMAPAGO
                db.execSQL("CREATE TABLE FORMAPAGO (" +
                        "ID_FORMAPAGO INTEGER PRIMARY KEY," +
                        "NOMBRE_FORMAPAGO TEXT NOT NULL)");

                // Crear tabla LICENCIA
                db.execSQL("CREATE TABLE LICENCIA (" +
                        "ID_LICENCIA INTEGER PRIMARY KEY," +
                        "TIPO_LICENCIA TEXT NOT NULL," +
                        "NUMERO_LICENCIA TEXT NOT NULL)");

                // Crear tabla MUNICIPIO
                db.execSQL("CREATE TABLE MUNICIPIO (" +
                        "ID_MUNICIPIO INTEGER PRIMARY KEY," +
                        "ID_DEPARTAMENTO INTEGER NOT NULL," +
                        "NOMBRE_MUNICIPIO TEXT NOT NULL," +
                        "FOREIGN KEY (ID_DEPARTAMENTO) REFERENCES DEPARTAMENTO(ID_DEPARTAMENTO) ON DELETE RESTRICT ON UPDATE RESTRICT)");

                // Crear tabla OFRECE
                db.execSQL("CREATE TABLE OFRECE (" +
                        "ID_PRODUCTO INTEGER NOT NULL," +
                        "ID_DIRECCION INTEGER NOT NULL," +
                        "ID_TIENDA INTEGER NOT NULL," +
                        "PRIMARY KEY (ID_DIRECCION, ID_PRODUCTO, ID_TIENDA)," +
                        "FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO(ID_PRODUCTO) ON DELETE RESTRICT ON UPDATE RESTRICT," +
                        "FOREIGN KEY (ID_DIRECCION, ID_TIENDA) REFERENCES TIENDA(ID_DIRECCION, ID_TIENDA) ON DELETE RESTRICT ON UPDATE RESTRICT)");

                // Crear tabla PEDIDO
                db.execSQL("CREATE TABLE PEDIDO (" +
                        "ID_PEDIDO INTEGER PRIMARY KEY," +
                        "ID_USUARIO INTEGER NOT NULL," +
                        "ID_REPARTIDOR INTEGER NOT NULL," +
                        "FOREIGN KEY (ID_REPARTIDOR) REFERENCES REPARTIDOR(ID_REPARTIDOR) ON DELETE RESTRICT ON UPDATE RESTRICT," +
                        "FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID_USUARIO) ON DELETE RESTRICT ON UPDATE RESTRICT)");

                // Crear tabla PRODUCTO
                db.execSQL("CREATE TABLE PRODUCTO (" +
                        "ID_PRODUCTO INTEGER PRIMARY KEY," +
                        "NOMBRE_PRODUCTO TEXT NOT NULL," +
                        "DESCRIPCION_PRODUCTO TEXT NOT NULL," +
                        "PRECIO_PRODUCTO REAL NOT NULL," +
                        "ESTADO_PRODUCTO INTEGER NOT NULL)");

                // Crear tabla REPARTIDOR
                db.execSQL("CREATE TABLE REPARTIDOR (" +
                        "ID_REPARTIDOR INTEGER PRIMARY KEY," +
                        "ID_DIRECCION INTEGER NOT NULL," +
                        "ID_VEHICULO INTEGER NOT NULL," +
                        "ID_LICENCIA INTEGER NOT NULL," +
                        "ID_DOCUMENTO_IDENTIDAD INTEGER," +
                        "NOMBRE_REPARTIDOR TEXT NOT NULL," +
                        "APELLIDO_REPARTIDOR TEXT NOT NULL," +
                        "TELEFONO_REPARTIDOR TEXT NOT NULL," +
                        "FOREIGN KEY (ID_DIRECCION) REFERENCES DIRECCION(ID_DIRECCION) ON DELETE RESTRICT ON UPDATE RESTRICT," +
                        "FOREIGN KEY (ID_VEHICULO) REFERENCES VEHICULO(ID_VEHICULO) ON DELETE RESTRICT ON UPDATE RESTRICT," +
                        "FOREIGN KEY (ID_LICENCIA) REFERENCES LICENCIA(ID_LICENCIA) ON DELETE RESTRICT ON UPDATE RESTRICT," +
                        "FOREIGN KEY (ID_DOCUMENTO_IDENTIDAD) REFERENCES DOCUMENTO_IDENTIDAD(ID_DOCUMENTO_IDENTIDAD) ON DELETE RESTRICT ON UPDATE RESTRICT)");

                // Crear tabla TIENDA
                db.execSQL("CREATE TABLE TIENDA (" +
                        "ID_DIRECCION INTEGER NOT NULL," +
                        "ID_TIENDA INTEGER NOT NULL," +
                        "ID_ADMINISTRADOR INTEGER NOT NULL," +
                        "NOMBRE_TIENDA TEXT NOT NULL," +
                        "TELEFONO_TIENDA TEXT NOT NULL," +
                        "PRIMARY KEY (ID_DIRECCION, ID_TIENDA)," +
                        "FOREIGN KEY (ID_ADMINISTRADOR) REFERENCES ADMINISTRADOR(ID_ADMINISTRADOR) ON DELETE RESTRICT ON UPDATE RESTRICT," +
                        "FOREIGN KEY (ID_DIRECCION) REFERENCES DIRECCION(ID_DIRECCION) ON DELETE RESTRICT ON UPDATE RESTRICT)");

                // Crear tabla USUARIO
                db.execSQL("CREATE TABLE USUARIO (" +
                        "ID_USUARIO INTEGER PRIMARY KEY," +
                        "ID_DIRECCION INTEGER NOT NULL," +
                        "ID_DOCUMENTO_IDENTIDAD INTEGER NOT NULL," +
                        "NOMBRE_USUARIO TEXT NOT NULL," +
                        "APELLIDO_USUARIO TEXT NOT NULL," +
                        "TELEFONO_USUARIO TEXT NOT NULL," +
                        "FOREIGN KEY (ID_DIRECCION) REFERENCES DIRECCION(ID_DIRECCION) ON DELETE RESTRICT ON UPDATE RESTRICT," +
                        "FOREIGN KEY (ID_DOCUMENTO_IDENTIDAD) REFERENCES DOCUMENTO_IDENTIDAD(ID_DOCUMENTO_IDENTIDAD) ON DELETE RESTRICT ON UPDATE RESTRICT)");

                db.execSQL("CREATE TABLE User (" +
                        "id_usuario CHAR(2) NOT NULL," +
                        " nom_usuario VARCHAR2(30) NOT NULL," +
                        " clave VARCHAR(10) NOT NULL," +
                        "CONSTRAINT PK_USUARIO PRIMARY KEY (id_usuario));");


                db.execSQL("CREATE TABLE OpcionCrud(" +
                        "id_opcion_crud INTEGER NOT NULL PRIMARY KEY," +
                        "des_opcion VARCHAR2(30) NOT NULL);");

                db.execSQL("CREATE TABLE AccesoUsuario (" +
                        "id_acceso INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                        " id_usuario CHAR(2) NOT NULL," +
                        " id_opcion_crud INTEGER NOT NULL, " +
                        "FOREIGN KEY(id_usuario) REFERENCES Usuario(id_usuario) ON DELETE CASCADE, " +
                        "FOREIGN KEY(id_opcion_crud) REFERENCES OpcionCrud(id_opcion_crud) ON DELETE CASCADE)");

                // Crear tabla VEHICULO
                db.execSQL("CREATE TABLE VEHICULO (" +
                        "ID_VEHICULO INTEGER PRIMARY KEY," +
                        "PLACA_VEHICULO TEXT NOT NULL," +
                        "TIPO_VEHICULO TEXT NOT NULL)");

                // Crear tabla VENTA
                db.execSQL("CREATE TABLE VENTA (" +
                        "ID_VENTA INTEGER PRIMARY KEY," +
                        "ID_PEDIDO INTEGER NOT NULL," +
                        "ID_FORMAPAGO INTEGER NOT NULL," +
                        "ID_DIRECCION INTEGER NOT NULL," +
                        "MONTO_VENTA REAL NOT NULL," +
                        "FECHA_VENTA DATE NOT NULL," +
                        "HORA_VENTA TIME NOT NULL," +
                        "FOREIGN KEY (ID_PEDIDO) REFERENCES PEDIDO(ID_PEDIDO) ON DELETE RESTRICT ON UPDATE RESTRICT," +
                        "FOREIGN KEY (ID_FORMAPAGO) REFERENCES FORMAPAGO(ID_FORMAPAGO) ON DELETE RESTRICT ON UPDATE RESTRICT," +
                        "FOREIGN KEY (ID_DIRECCION) REFERENCES DIRECCION(ID_DIRECCION) ON DELETE RESTRICT ON UPDATE RESTRICT)");


                // PONER TRIGGERS AQUI


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub
        }
    }

    public void abrir() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return;
    }

    public void cerrar() {
        DBHelper.close();
    }

    /******************************************** Tabla ADMINISTRADOR ********************************************/
    // Insertar registros de administradores
    // Actualizar registros de administradores
    // Eliminar registros de administradores
    // Consultar registros de administradores

    /******************************************** Tabla CONTIENE ********************************************/
    // Insertar registros de productos en pedidos
    // Actualizar registros de productos en pedidos
    // Eliminar registros de productos en pedidos
    // Consultar registros de productos en pedidos

    /******************************************** Tabla DEPARTAMENTO ********************************************/
    // Insertar registros de departamentos
    // Actualizar registros de departamentos
    // Eliminar registros de departamentos
    // Consultar registros de departamentos

    /******************************************** Tabla DIRECCION ********************************************/
    // Insertar registros de direcciones
    // Actualizar registros de direcciones
    // Eliminar registros de direcciones
    // Consultar registros de direcciones

    /******************************************** Tabla DISTRITO ********************************************/
    // Insertar registros de distritos
    // Actualizar registros de distritos
    // Eliminar registros de distritos
    // Consultar registros de distritos

    /******************************************** Tabla DOCUMENTO_IDENTIDAD ********************************************/
    // Insertar registros de documentos de identidad
    // Actualizar registros de documentos de identidad
    // Eliminar registros de documentos de identidad
    // Consultar registros de documentos de identidad

    /******************************************** Tabla EVENTO_ESPECIAL ********************************************/
    // Insertar registros de eventos especiales
    // Actualizar registros de eventos especiales
    // Eliminar registros de eventos especiales
    // Consultar registros de eventos especiales

    /******************************************** Tabla FORMAPAGO ********************************************/
    // Insertar registros de formas de pago
    public String insertarFormaPago(FormaPago forma){
        String regInsertados="Registro Insertado Nº ";
        long contador=0;
        ContentValues form = new ContentValues();
        form.put("ID_FORMAPAGO", forma.getIdFormaPago());
        form.put("NOMBRE_FORMAPAGO", forma.getFormaPago());

        contador=db.insert("FORMAPAGO", null, form);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    // Actualizar registros de formas de pago
    public String actualizarFormaPago(FormaPago pago){

        if(verificarIntegridad(pago, 5)){
            String[] id = {String.valueOf(pago.getIdFormaPago())};
            ContentValues cv = new ContentValues();
            cv.put("ID_FORMAPAGO", pago.getIdFormaPago());
            cv.put("NOMBRE_FORMAPAGO", pago.getFormaPago());

            db.update("FORMAPAGO", cv, "ID_FORMAPAGO = ?", id);
            return "Forma de pago actualizada Correctamente";
        }else{
            return "Forma de pago con ID " + pago.getIdFormaPago() + " no existe";
        }
    }

    // Eliminar registros de formas de pago
    public String eliminarFormaPago(FormaPago forma){

        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(forma,3)) {
            contador+=db.delete("FORMAPAGO", "ID_FORMAPAGO='"+forma.getIdFormaPago()+"'", null);
        }
        contador+=db.delete("FORMAPAGO", "ID_FORMAPAGO='"+forma.getIdFormaPago()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }

    // Consultar registros de formas de pago
    public FormaPago consultarFormaPago(int idforma){
        String[] id = {String.valueOf(idforma)};
        Cursor cursor = db.query("FORMAPAGO", camposFormaPago, "ID_FORMAPAGO = ?", id, null, null, null);
        if(cursor.moveToFirst()){
           FormaPago formaPago = new FormaPago();
           formaPago.setIdFormaPago(cursor.getInt(0));
           formaPago.setFormaPago(cursor.getString(1));
           return formaPago;
        }else{ return null;
        }
    }

    /*  muestra todas las formas de pago*/
    public ArrayList<FormaPago> mostrarFormaPagos() {

        ArrayList<FormaPago> listaFormaPagos = new ArrayList<>();
        FormaPago formaPago;
        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM " + "FORMAPAGO" + " ORDER BY ID_FORMAPAGO ASC", null);

        if (cursor.moveToFirst()) {
            do {
                formaPago = new FormaPago();
                formaPago.setIdFormaPago(cursor.getInt(0));
                formaPago.setFormaPago(cursor.getString(1));

                listaFormaPagos.add(formaPago);
            } while (cursor.moveToNext());
        }

        return listaFormaPagos;
    }


    /******************************************** Tabla LICENCIA ********************************************/
    public String insertarLicencia(Licencia licencia){
        String regInsertados = "Registro Insertado N= ";
        long contador=0;
        ContentValues lic = new ContentValues();
        lic.put("tipo_licencia", licencia.getTipo_licencia());
        lic.put("numero_licencia", licencia.getNumero_licencia());
        contador = db.insert("licencia",null, lic);
        if(contador==-1||contador==0){
            regInsertados="Error al insertar el registro, registro duplicado. Verificar inserción";
        }
        else{
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public Licencia consultarLicencia(String numeroLicencia){

        String[] id = {numeroLicencia};
        Cursor cursor = db.query("licencia", camposLicencia, "numero_licencia=?", id, null, null, null);
        if(cursor.moveToFirst()){
            Licencia licencia = new Licencia();
            licencia.setTipo_licencia(cursor.getString(1));
            licencia.setNumero_licencia(cursor.getString(2));
            return licencia;
        } else{
            return null;
        }
    }

    public String actualizarLicencia(Licencia licencia){
        String[] id = {licencia.getNumero_licencia()};
        ContentValues cv = new ContentValues();
        cv.put("tipo_licencia", licencia.getTipo_licencia());
        db.update("licencia", cv, "numero_licencia = ?", id);
        return "Registro Actualizado Correctamente";
    }

    public String eliminarLicencia(Licencia licencia){
        String regAfectados="Filas afectadas= ";
        int contador=0;
        contador+=db.delete("licencia", "numero_licencia='"+licencia.getNumero_licencia()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }


    /******************************************** Tabla MUNICIPIO ********************************************/
    // Insertar registros de municipios
    // Actualizar registros de municipios
    // Eliminar registros de municipios
    // Consultar registros de municipios

    /******************************************** Tabla OFRECE ********************************************/
    // Insertar registros de ofertas de productos en tiendas
    // Actualizar registros de ofertas de productos en tiendas
    // Eliminar registros de ofertas de productos en tiendas
    // Consultar registros de ofertas de productos en tiendas

    /******************************************** Tabla PEDIDO ********************************************/
    // Insertar registros de pedidos
    public String insertarPedido(Pedido pedido){
        String regInsertados="Registro Insertado Nº ";
        long contador=0;
        ContentValues cv = new ContentValues();
        cv.put("ID_PEDIDO", pedido.getIdPedido());
        cv.put("ID_REPARTIDOR", pedido.getIdRepartidor());
        cv.put("ID_USUARIO", pedido.getIdUsuario());

        contador=db.insert("PEDIDO", null, cv);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    // Actualizar registros de pedidos
    public String actualizarPedido(Pedido pedido){
            String[] id = {String.valueOf(pedido.getIdPedido())};
            ContentValues cv = new ContentValues();
            cv.put("ID_PEDIDO", pedido.getIdPedido());
            cv.put("ID_REPARTIDOR", pedido.getIdRepartidor());
            cv.put("ID_USUARIO", pedido.getIdUsuario());

            db.update("PEDIDO", cv, "ID_PEDIDO = ?", id);
            return "Pedido actualizado correctamente";
    }
    // Eliminar registros de pedidos
    public String eliminarPedido(Pedido pedido){

        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(pedido,3)) {
            contador+=db.delete("PEDIDO", "ID_PEDIDO='"+pedido.getIdPedido()+"'", null);
        }
        contador+=db.delete("PEDIDO", "ID_PEDIDO='"+pedido.getIdPedido()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }
    // Consultar registros de pedidos
    public Pedido consultarPedido(int idpedido){
        String[] id = {String.valueOf(idpedido)};
        Cursor cursor = db.query("PEDIDO", camposFormaPago, "ID_PEDIDO = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Pedido pedido = new Pedido();
            pedido.setIdPedido(cursor.getInt(0));
            pedido.setIdUsuario(cursor.getInt(1));
            pedido.setIdRepartidor(cursor.getInt(2));
            return pedido;
        }else{ return null;
        }
    }
    /*  muestra todos los pedidos*/
    public ArrayList<Pedido> mostrarPedidos() {

        ArrayList<Pedido> listaPedidos = new ArrayList<>();
        Pedido pedido;
        Cursor cursor;

        cursor = db.rawQuery("SELECT * FROM " + "PEDIDO" + " ORDER BY ID_PEDIDO ASC", null);

        if (cursor.moveToFirst()) {
            do {
                pedido = new Pedido();
                pedido.setIdPedido(cursor.getInt(0));
                pedido.setIdUsuario(cursor.getInt(1));
                pedido.setIdRepartidor(cursor.getInt(1));

                listaPedidos.add(pedido);
            } while (cursor.moveToNext());
        }

        return listaPedidos;
    }

    /******************************************** Tabla PRODUCTO ********************************************/
    // Insertar registros de productos
    // Actualizar registros de productos
    // Eliminar registros de productos
    // Consultar registros de productos

    /******************************************** Tabla REPARTIDOR ********************************************/
    public String insertarRepartidor(Repartidor repartidor){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues repartidores = new ContentValues();
        repartidores.put("id_direccion", repartidor.getId_direccion());
        repartidores.put("id_vehiculo", repartidor.getId_vehiculo());
        repartidores.put("id_licencia", repartidor.getId_licencia());
        repartidores.put("id_documento_identidad", repartidor.getId_documento_identidad());
        repartidores.put("nombre_repartidor", repartidor.getNombre_repartidor());
        repartidores.put("apellido_repartidor", repartidor.getApellido_repartidor());
        repartidores.put("telefono_repartidor", repartidor.getTelefono_repartidor());
        contador=db.insert("repartidor", null, repartidores);
        if(contador==-1 || contador==0){
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public Repartidor consultarRepartidor(int idDireccion, int idVehiculo, int idLicencia, int idDocumentoIdentidad){

        String[] id = {String.valueOf(idDireccion), String.valueOf(idVehiculo), String.valueOf(idLicencia), String.valueOf(idDocumentoIdentidad)};
        Cursor cursor = db.query("repartidor", camposRepartidor, "id_direccion = ? AND id_vehiculo = ? AND id_licencia = ? AND id_documento_identidad = ?", id, null, null, null);
        if(cursor.moveToFirst()){
            Repartidor repartidor = new Repartidor();
            repartidor.setId_direccion(Integer.parseInt(cursor.getString(1)));
            repartidor.setId_vehiculo(Integer.parseInt(cursor.getString(2)));
            repartidor.setId_licencia(Integer.parseInt(cursor.getString(3)));
            repartidor.setId_documento_identidad(Integer.parseInt(cursor.getString(4)));
            repartidor.setNombre_repartidor(cursor.getString(5));
            repartidor.setApellido_repartidor(cursor.getString(6));
            repartidor.setTelefono_repartidor(cursor.getString(7));
            return repartidor;
        }else{
            return null;
        }
    }

    public String actualizarRepartidor(Repartidor repartidor){

        String[] id = {String.valueOf(repartidor.getId_direccion()), String.valueOf(repartidor.getId_vehiculo()), String.valueOf(repartidor.getId_licencia()), String.valueOf(repartidor.getId_documento_identidad())};
        ContentValues cv = new ContentValues();
        cv.put("nombre_repartidor", repartidor.getNombre_repartidor());
        cv.put("apellido_repartidor", repartidor.getApellido_repartidor());
        cv.put("telefono_repartidor", repartidor.getTelefono_repartidor());
        db.update("repartidor", cv, "id_direccion = ? AND id_vehiculo = ? AND id_licencia = ? AND id_documento_identidad = ?", id);
        return "Registro Actualizado Correctamente";

    }

    public String eliminarRepartidor(Repartidor repartidor){
        String regAfectados="filas afectadas= ";
        int contador=0;
        String where="id_direccion='"+repartidor.getId_direccion()+"'";
        where=where+" AND id_vehiculo="+repartidor.getId_vehiculo();
        where=where+" AND id_licencia='"+repartidor.getId_licencia()+"'";
        where=where+" AND id_documento_identidad="+repartidor.getId_documento_identidad();
        contador+=db.delete("repartidor", where, null);
        regAfectados+=contador;
        return regAfectados;
    }


    /******************************************** Tabla TIENDA ********************************************/
    // Insertar registros de tiendas
    // Actualizar registros de tiendas
    // Eliminar registros de tiendas
    // Consultar registros de tiendas

    /******************************************** Tabla USUARIO ********************************************/
    // Insertar registros de usuarios
    // Actualizar registros de usuarios
    // Eliminar registros de usuarios
    // Consultar registros de usuarios

    /******************************************** Tabla VEHICULO ********************************************/

    public String insertarVehiculo(Vehiculo vehiculo){
        String regInsertados = "Registro Insertado N= ";
        long contador=0;
        ContentValues v = new ContentValues();
        v.put("placa_vehiculo", vehiculo.getPlaca_vehiculo());
        v.put("tipo_vehiculo", vehiculo.getTipo_vehiculo());
        contador = db.insert("vehiculo",null, v);
        if(contador==-1||contador==0){
            regInsertados="Error al insertar el registro, registro duplicado. Verificar inserción";
        }
        else{
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }

    public Vehiculo consultarVehiculo(String placaVehiculo){

        String[] id = {placaVehiculo};
        Cursor cursor = db.query("vehiculo", camposVehiculo, "placa_vehiculo=?", id, null, null, null);
        if(cursor.moveToFirst()){
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setPlaca_vehiculo(cursor.getString(1));
            vehiculo.setTipo_vehiculo(cursor.getString(2));
            return vehiculo;
        } else{
            Vehiculo vehiculo = new Vehiculo();
            vehiculo.setPlaca_vehiculo("nada");
            vehiculo.setTipo_vehiculo("nada");
            return vehiculo;
        }
    }

    public String actualizarVehiculo(Vehiculo vehiculo){
        String[] id = {vehiculo.getPlaca_vehiculo()};
        ContentValues cv = new ContentValues();
        cv.put("tipo_vehiculo", vehiculo.getTipo_vehiculo());
        db.update("vehiculo", cv, "placa_vehiculo = ?", id);
        return "Registro Actualizado Correctamente";
    }

    public String eliminarVehiculo(Vehiculo vehiculo){
        String regAfectados="Filas afectadas= ";
        int contador=0;
        contador+=db.delete("vehiculo", "placa_vehiculo='"+vehiculo.getPlaca_vehiculo()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }


    /******************************************** Tabla VENTA ********************************************/
    // Insertar registros de ventas
    // Actualizar registros de ventas
    // Eliminar registros de ventas
    public String eliminarVenta(Venta venta){

        String regAfectados="filas afectadas= ";
        int contador=0;
        if (verificarIntegridad(venta,3)) {
            contador+=db.delete("PEDIDO", "ID_PEDIDO='"+venta.getIdVenta()+"'", null);
        }
        contador+=db.delete("PEDIDO", "ID_PEDIDO='"+venta.getIdVenta()+"'", null);
        regAfectados+=contador;
        return regAfectados;
    }
    // Consultar registros de ventas

    /******************************************** Tabla ADMINISTRADOR ********************************************/
    // Insertar registros de administradores
    // Actualizar registros de administradores
    // Eliminar registros de administradores
    // Consultar registros de administradores


    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException {
        switch (relacion) {
            case 1: {

            }
            case 2: {

            }
            case 3: {

            }
            case 4: {

            }
            case 5: {
                FormaPago forma = (FormaPago) dato;
                String[] id = {String.valueOf(forma.getIdFormaPago())};
                abrir();
                Cursor c2 = db.query("FORMAPAGO", null, "ID_FORMAPAGO = ?", id, null, null, null);
                if(c2.moveToFirst()){
                    //Se encontro Alumno
                    return true;
                }
                return false;
            }

            default:
                return false;
        }
    }

    /******************************************** Tabla User ********************************************/
    /* Insertar Usuario*/
    public String insertar(User usuario) {
        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;
        ContentValues user = new ContentValues();
        user.put("id_usuario", usuario.getId_usuario());
        user.put("nom_usuario", usuario.getNom_usuario());
        user.put("clave", usuario.getClave());
        contador = db.insert("User", null, user);
        if (contador == -1 || contador == 0) {
            regInsertados = "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    /******************************************** Tabla AccesoUsuario ********************************************/
    public String insertar(AccesoUsuario accesoUsuario) {
        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;
        ContentValues accUsuario = new ContentValues();
        accUsuario.put("id_acceso", accesoUsuario.getId_acceso());
        accUsuario.put("id_usuario", accesoUsuario.getId_usuario());
        accUsuario.put("id_opcion_crud", accesoUsuario.getId_opcion_crud());

        ;
        contador = db.insert("AccesoUsuario", null, accUsuario);
        if (contador == -1 || contador == 0) {
            regInsertados = "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    /******************************************** Tabla OpcionCrud ********************************************/
    // CAMPOS: {"id_opcion_crud", "des_opcion"}
    public String insertar(OpcionCrud opcionCrud) {
        String regInsertados = "Registro Insertado Nº= ";
        long contador = 0;
        ContentValues opcCrud = new ContentValues();
        opcCrud.put("id_opcion_crud", opcionCrud.getId_opcion_crud());
        opcCrud.put("des_opcion", opcionCrud.getDes_opcion());

        ;
        contador = db.insert("OpcionCrud", null, opcCrud);
        if (contador == -1 || contador == 0) {
            regInsertados = "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        } else {
            regInsertados = regInsertados + contador;
        }
        return regInsertados;
    }

    public void permisosUsuarios() {

        db.execSQL("DELETE FROM User");
        db.execSQL("DELETE FROM OpcionCrud");
        db.execSQL("DELETE FROM AccesoUsuario");

        //User
        final String[] IDusuario = {"01", "02", "03", "04", "05"};
        final String[] nomUsuario = {"karla", "jaime", "wendy", "jeferson", "caleb"};
        final String[] clave = {"VP20007", "GD21001", "CH11049", "AS21004", "EE19001"};


        User user = new User();

        for (int i = 0; i < 5; i++) {
            user.setId_usuario(IDusuario[i]);
            user.setNom_usuario(nomUsuario[i]);
            user.setClave(clave[i]);
            insertar(user);
        }

        //OPCIONCRUD

        final int[] idOpcionCrud = {1, 2, 3, 4};
        final String[] opcionCrud = {"Insertar", "Actualizar", "Eliminar", "Consultar"};
        for (int i = 0; i < opcionCrud.length; i++) {
            OpcionCrud opcion = new OpcionCrud(idOpcionCrud[i], opcionCrud[i]);
            insertar(opcion);
        }

        //ACCESOUSUARIO
        final int[] idsAccesoUsuario = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final String[] IDusuarios = {"01", "01", "01", "01", "02", "02", "03", "03", "04", "05"};
        final int[] idOpcionCrud_Access = {1, 2, 3, 4, 1, 2, 3, 4, 1, 2};
        for (int i = 0; i < idsAccesoUsuario.length; i++) {
            AccesoUsuario accesoUsuario = new AccesoUsuario(idsAccesoUsuario[i], IDusuarios[i], idOpcionCrud_Access[i]);
            insertar(accesoUsuario);
        }
    }

    public Cursor llenarSpinner(String sql) throws SQLException {
        Cursor cursor = DBHelper.getReadableDatabase().rawQuery(sql, null);
        return cursor;
    }

    public String llenarBD() {
        abrir();

        //Limpia Base

        db.execSQL("DELETE FROM ADMINISTRADOR");
        db.execSQL("DELETE FROM CONTIENE");
        db.execSQL("DELETE FROM DEPARTAMENTO");
        db.execSQL("DELETE FROM DIRECCION");
        db.execSQL("DELETE FROM DISTRITO");
        db.execSQL("DELETE FROM DOCUMENTO_IDENTIDAD");
        db.execSQL("DELETE FROM EVENTO_ESPECIAL");
        db.execSQL("DELETE FROM FORMAPAGO");
        db.execSQL("DELETE FROM LICENCIA");
        db.execSQL("DELETE FROM MUNICIPIO");
        db.execSQL("DELETE FROM OFRECE");
        db.execSQL("DELETE FROM PEDIDO");
        db.execSQL("DELETE FROM PRODUCTO");
        db.execSQL("DELETE FROM REPARTIDOR");
        db.execSQL("DELETE FROM TIENDA");
        db.execSQL("DELETE FROM USUARIO");
        db.execSQL("DELETE FROM VEHICULO");
        db.execSQL("DELETE FROM VENTA");

        // Llenado de la tabla ADMINISTRADOR

        // Llenado de la tabla CONTIENE

        // Llenado de la tabla DEPARTAMENTO

        // Llenado de la tabla DIRECCION

        // Llenado de la tabla DISTRITO

        // Llenado de la tabla DOCUMENTO_IDENTIDAD

        // Llenado de la tabla EVENTO_ESPECIAL

        // Llenado de la tabla FORMAPAGO


        final int[] IdFormaPago = {1, 2, 3};
        final String[] NombrePago = {"Efectivo", "Chivo Wallet", "Tarjeta de credito"};

        FormaPago formaPago = new FormaPago();

        for (int i = 0; i < 3; i++) {
            formaPago.setIdFormaPago(IdFormaPago[i]);
            formaPago.setFormaPago(NombrePago[i]);
            insertarFormaPago(formaPago);
        }


        // Llenado de la tabla LICENCIA

        // Llenado de la tabla MUNICIPIO

        // Llenado de la tabla OFRECE

        // Llenado de la tabla PEDIDO
        /*
        final int[] IdPedido = {1, 2, 3};
        final int[] IdUsuario_p = {1, 2, 3};
        final int[] IdRepartidor_p = {1, 2, 3};

        Pedido pedido= new Pedido();
        for (int i = 0; i < 3; i++) {
            pedido.setIdPedido(IdPedido[i]);
            pedido.setIdUsuario(IdUsuario_p[i]);
            pedido.setIdRepartidor(IdRepartidor_p[i]);
            insertar(pedido);
        }
        */

        // Llenado de la tabla PRODUCTO

        // Llenado de la tabla REPARTIDOR

        // Llenado de la tabla TIENDA

        // Llenado de la tabla USUARIO

        // Llenado de la tabla VEHICULO

        // Llenado de la tabla VENTA
        /*
        final int[] IdVenta = {1, 2, 3};
        final Float[] montoVenta = {12.1f, 123.12f, 99.99f};
        final String[] fechaVentaString = {"01/01/2024", "15/02/2024", "30/03/2024"};
        final String[] horaVentaString = {"10:30:00", "14:45:00", "18:00:00"};
        final int[] IdDireccion_v = {1, 2, 3};
        final int[] IdFormaPago_v = {1, 2, 3};
        final int[] IdPedido_v = {1, 2, 3};

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Formato de fecha dd-MM-yyyy o el que corresponda
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss"); // Formato de hora HH:mm:ss

        Venta venta = new Venta();

        for (int i = 0; i < 3; i++) {
            try {
                Date fechaVenta = sdf.parse(fechaVentaString[i]); // Convertir la cadena de fecha a un objeto Date
                Date horaVenta = sdf.parse(horaVentaString[i]); // Convertir la cadena de hora a un objeto Date
                venta.setIdVenta(IdVenta[i]);
                venta.setMonto(montoVenta[i]);
                venta.setFecha(fechaVenta);
                venta.setHora(horaVenta);
                venta.setIdDireccion(IdDireccion_v[i]);
                venta.setIdFormaPago(IdFormaPago_v[i]);
                venta.setIdPedido(IdPedido_v[i]);
                insertar(venta);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        */

        cerrar();

        return context.getResources().getString(R.string.llenadoBD);
    }
}
