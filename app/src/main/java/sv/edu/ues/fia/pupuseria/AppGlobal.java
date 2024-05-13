package sv.edu.ues.fia.pupuseria;

import android.app.Application;

public class AppGlobal extends Application {
    private String userPermisos;

    public String getUserPermisos(){
        return userPermisos;
    }
    public void setUserPermisos(String userPermisos){
        this.userPermisos = userPermisos;
    }
}

