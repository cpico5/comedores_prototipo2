package com.example.comedoresprototipo2;	

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
 
public class UsuariosSQLiteHelper2 extends SQLiteOpenHelper {

	private static final String ENCODING = "ISO-8859-1";
	 

	public static String getHostName(String defValue) {
	    try {
	        Method getString = Build.class.getDeclaredMethod("getString", String.class);
	        getString.setAccessible(true);
	        return getString.invoke(null, "net.hostname").toString();
	    } catch (Exception ex) {
	        return defValue;
	    }
	}
	
public String tablet;
InputStream datos, usuarios, nofue, acambio,prd, pri, pan, morena, independiente= null;

static Nombre nom= new Nombre();
static String nombreD = nom.nombreDatos();
	
	static String ID = getHostName(null);
	static String prefix = "listado";

	 private static final String DATABASE_NAME = Environment.getExternalStorageDirectory() +"/Mis_archivos/" +nombreD+"_"+prefix+"";
	 private static final int DATABASE_VERSION = 7;
	 
	 public UsuariosSQLiteHelper2(Context context, String name,CursorFactory factory, int version) {
		 super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
		 try {
			 datos = context.getAssets().open("datos.sql");
             usuarios = context.getAssets().open("usuarios.sql");
      
        } catch (Exception ex) {
            Log.i(null, "HORROR-1: " + ex.fillInStackTrace());           
        } 
		 
	 }
	 
//////////////////////   TABLA DATOS  //////////////////////////////////////////////////////////////
	 
	 
//////////////////////TABLA DATOS  //////////////////////////////////////////////////////////////
	 
	 
public static class TablaDatos{
public static String TABLA_DATOS = "datos";
public static String COLUMNA_id = "id";
public static String COLUMNA_nombre_escuela = "nombre_escuela";
public static String COLUMNA_domicilio = "domicilio";
public static String COLUMNA_codigo_postal = "codigo_postal";
public static String COLUMNA_alcaldia = "alcaldia";
public static String COLUMNA_cct = "cct";
public static String COLUMNA_turno = "turno";
public static String COLUMNA_nivel_educativo = "nivel_educativo";
public static String COLUMNA_matricula = "matricula";
public static String COLUMNA_pertenece_petc = "pertenece_petc";
public static String COLUMNA_servicio_petc = "servicio_petc";
public static String COLUMNA_cocina_petc = "cocina_petc";
public static String COLUMNA_programa_alimentos = "programa_alimentos";
public static String COLUMNA_status_inclusion = "status_inclusion";
public static String COLUMNA_equipamiento_dif = "equipamiento_dif";
public static String COLUMNA_marginacion = "marginacion";
public static String COLUMNA_clave_inmueble = "clave_inmueble";

}

private static final String DATABASE_DATOS = "create table "
+ TablaDatos.TABLA_DATOS + "(" 
+ TablaDatos.COLUMNA_id + " INTEGER not null, "
+ TablaDatos.COLUMNA_nombre_escuela + " text not null, "
+ TablaDatos.COLUMNA_domicilio + " text not null, "
+ TablaDatos.COLUMNA_codigo_postal + " integer not null, "
+ TablaDatos.COLUMNA_alcaldia + " text not null, "
+ TablaDatos.COLUMNA_cct + " text not null, "
+ TablaDatos.COLUMNA_turno + " text not null, "
+ TablaDatos.COLUMNA_nivel_educativo + " integer not null, "
+ TablaDatos.COLUMNA_matricula + " text not null, "
+ TablaDatos.COLUMNA_pertenece_petc + " text not null, "
+ TablaDatos.COLUMNA_servicio_petc + " text not null, "
+ TablaDatos.COLUMNA_cocina_petc + " integer not null, "
+ TablaDatos.COLUMNA_programa_alimentos + " text not null, "
+ TablaDatos.COLUMNA_status_inclusion + " text not null, "
+ TablaDatos.COLUMNA_equipamiento_dif + " text not null, "
+ TablaDatos.COLUMNA_marginacion + " integer not null, "
+ TablaDatos.COLUMNA_clave_inmueble + " text not null); ";

///////////////////////////  TABLA USUARIOS	 /////////////////////////////////////////////////////////    

public static class TablaUsuarios{
public static String TABLA_USUARIOS = "usuarios";
public static String COLUMNA_USUARIO = "usuario";
public static String COLUMNA_PASSWORD = "password";

}

private static final String DATABASE_USUARIOS = "create table "
+ TablaUsuarios.TABLA_USUARIOS + "(" 
+ TablaUsuarios.COLUMNA_USUARIO + " text not null, "
+ TablaUsuarios.COLUMNA_PASSWORD+ " text not null); ";

	    

	    
	    


	    
	    @Override
	    public void onCreate(SQLiteDatabase db) {
	        // TODO Auto-generated method stub
	        db.execSQL(DATABASE_DATOS);
	        db.execSQL(DATABASE_USUARIOS);
	     
	        
	        cargaDatos(db);
	        cargaUsuarios(db);
	        
	    }
	    
	    
	    public void cargaDatos(SQLiteDatabase db){
	    	InputStream tabla=datos;
	    	try {

	             if (tabla != null) {
	                 db.beginTransaction();
	                 BufferedReader reader = new BufferedReader(new InputStreamReader(tabla,ENCODING));
	                 String line = reader.readLine();
	                 while (!TextUtils.isEmpty(line)) {
	                     db.execSQL(line);
	                     line = reader.readLine();
	                 }
	                 db.setTransactionSuccessful();
	             }
	        } catch (Exception ex) {
	            Log.i(null, "HORROR-2: " + ex.getMessage());           
	        } finally {
	            db.endTransaction();
	            if (tabla != null) {
	                try {
	                    tabla.close();
	                } catch (IOException e) {
	                	Log.i(null, "HORROR-3; " + e.getMessage()); 
	                }                
	            }
	        }
	    	
	    }
	    
	    public void cargaUsuarios(SQLiteDatabase db){
	    	InputStream tabla=usuarios;
	    	try {

	             if (tabla != null) {
	                 db.beginTransaction();
	                 BufferedReader reader = new BufferedReader(new InputStreamReader(tabla,ENCODING));
	                 String line = reader.readLine();
	                 while (!TextUtils.isEmpty(line)) {
	                     db.execSQL(line);
	                     line = reader.readLine();
	                 }
	                 db.setTransactionSuccessful();
	             }
	        } catch (Exception ex) {
	            Log.i(null, "HORROR-2: " + ex.getMessage());           
	        } finally {
	            db.endTransaction();
	            if (tabla != null) {
	                try {
	                    tabla.close();
	                } catch (IOException e) {
	                	Log.i(null, "HORROR-3; " + e.getMessage()); 
	                }                
	            }
	        }
	    	
	    }
	    
	    
	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        // TODO Auto-generated method stub
	        db.execSQL("DROP table if exists " + TablaDatos.TABLA_DATOS);
	        db.execSQL("DROP table if exists " + TablaUsuarios.TABLA_USUARIOS);
	       onCreate(db);
	    }
}
