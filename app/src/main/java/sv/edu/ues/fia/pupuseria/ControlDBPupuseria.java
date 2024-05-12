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


import java.sql.Timestamp;
import java.util.ArrayList;

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
                        "ID_EVENTO_ESPECIAL INTEGER," +
                        "ID_REPARTIDOR INTEGER NOT NULL," +
                        "ID_USUARIO INTEGER NOT NULL," +
                        "FOREIGN KEY (ID_EVENTO_ESPECIAL) REFERENCES EVENTO_ESPECIAL(ID_EVENTO_ESPECIAL) ON DELETE RESTRICT ON UPDATE RESTRICT," +
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
    // Actualizar registros de formas de pago
    // Eliminar registros de formas de pago
    // Consultar registros de formas de pago

    /******************************************** Tabla LICENCIA ********************************************/
    // Insertar registros de licencias
    // Actualizar registros de licencias
    // Eliminar registros de licencias
    // Consultar registros de licencias

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
    // Actualizar registros de pedidos
    // Eliminar registros de pedidos
    // Consultar registros de pedidos

    /******************************************** Tabla PRODUCTO ********************************************/
    // Insertar registros de productos
    // Actualizar registros de productos
    // Eliminar registros de productos
    // Consultar registros de productos

    /******************************************** Tabla REPARTIDOR ********************************************/
    // Insertar registros de repartidores
    // Actualizar registros de repartidores
    // Eliminar registros de repartidores
    // Consultar registros de repartidores

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
    // Insertar registros de vehículos
    // Actualizar registros de vehículos
    // Eliminar registros de vehículos
    // Consultar registros de vehículos

    /******************************************** Tabla VENTA ********************************************/
    // Insertar registros de ventas
    // Actualizar registros de ventas
    // Eliminar registros de ventas
    // Consultar registros de ventas

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

        // Llenado de la tabla LICENCIA

        // Llenado de la tabla MUNICIPIO

        // Llenado de la tabla OFRECE

        // Llenado de la tabla PEDIDO

        // Llenado de la tabla PRODUCTO

        // Llenado de la tabla REPARTIDOR

        // Llenado de la tabla TIENDA

        // Llenado de la tabla USUARIO

        // Llenado de la tabla VEHICULO

        // Llenado de la tabla VENTA

        cerrar();

        return context.getResources().getString(R.string.llenadoBD);
    }
}
