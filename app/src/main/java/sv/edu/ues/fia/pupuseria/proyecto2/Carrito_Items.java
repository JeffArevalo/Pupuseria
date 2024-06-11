package sv.edu.ues.fia.pupuseria.proyecto2;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcel;

public class Carrito_Items implements Parcelable {
    private int ID_PEDIDO;
    private int ID_PRODUCTO;
    private String NOMBRE_PRODUCTO;
    private int CANTIDAD;
    private float SUBTOTAL;

    public Carrito_Items(){};

    public Carrito_Items(int ID_PEDIDO, int ID_PRODUCTO, String NOMBRE_PRODUCTO, int CANTIDAD, float SUBTOTAL) {
        this.ID_PEDIDO = ID_PEDIDO;
        this.ID_PRODUCTO = ID_PRODUCTO;
        this.NOMBRE_PRODUCTO = NOMBRE_PRODUCTO;
        this.CANTIDAD = CANTIDAD;
        this.SUBTOTAL = SUBTOTAL;
    }

    protected Carrito_Items(Parcel in) {
        ID_PEDIDO = in.readInt();
        ID_PRODUCTO = in.readInt();
        NOMBRE_PRODUCTO = in.readString();
        CANTIDAD = in.readInt();
        SUBTOTAL = in.readFloat();
    }

    public static final Creator<Carrito_Items> CREATOR = new Creator<Carrito_Items>() {
        @Override
        public Carrito_Items createFromParcel(Parcel in) {
            return new Carrito_Items(in);
        }

        @Override
        public Carrito_Items[] newArray(int size) {
            return new Carrito_Items[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ID_PEDIDO);
        dest.writeInt(ID_PRODUCTO);
        dest.writeString(NOMBRE_PRODUCTO);
        dest.writeInt(CANTIDAD);
        dest.writeFloat(SUBTOTAL);
    }

    // Getters y setters
    public int getID_PEDIDO() {
        return ID_PEDIDO;
    }

    public void setID_PEDIDO(int ID_PEDIDO) {
        this.ID_PEDIDO = ID_PEDIDO;
    }

    public int getID_PRODUCTO() {
        return ID_PRODUCTO;
    }

    public void setID_PRODUCTO(int ID_PRODUCTO) {
        this.ID_PRODUCTO = ID_PRODUCTO;
    }

    public String getNOMBRE_PRODUCTO() {
        return NOMBRE_PRODUCTO;
    }

    public void setNOMBRE_PRODUCTO(String NOMBRE_PRODUCTO) {
        this.NOMBRE_PRODUCTO = NOMBRE_PRODUCTO;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public float getSUBTOTAL() {
        return SUBTOTAL;
    }

    public void setSUBTOTAL(float SUBTOTAL) {
        this.SUBTOTAL = SUBTOTAL;
    }
}
