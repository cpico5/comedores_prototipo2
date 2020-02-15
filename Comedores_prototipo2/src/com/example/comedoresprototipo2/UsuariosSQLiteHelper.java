package com.example.comedoresprototipo2;	

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.UUID;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
 
public class UsuariosSQLiteHelper extends SQLiteOpenHelper {

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
	

	UUID uuid = UUID.randomUUID();
	
public String tablet;
InputStream datos, usuarios, nofue, acambio,prd, pri, pan, morena, independiente= null;

static Nombre nom= new Nombre();
static String nombreE = nom.nombreEncuesta();



	static String ID = getHostName(null);
	static String prefix = ID;

	// private static final String DATABASE_NAME = Environment.getExternalStorageDirectory() +"/Mis_archivos/" +nombreE+"_"+prefix+"";
	 private static final int DATABASE_VERSION = 3;
	 
	 public UsuariosSQLiteHelper(Context context, String name,CursorFactory factory, int version, String DATABASE_NAME) {
		 super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
		 try {
             datos = context.getAssets().open("datos.sql");
             usuarios = context.getAssets().open("usuarios.sql");

        } catch (Exception ex) {
            Log.i(null, "HORROR-1: " + ex.fillInStackTrace());           
        } 
		 
	 }
	 


	    
	    

/////////////////////  TABLA ENCUESTAS  ///////////////////////////////////////////////
	    
	    public static class TablaEncuestas{
	        public static String TABLA_ENCUESTAS = "encuestas";
	        public static String COLUMNA_CONSECUTIVO_DIARIO = "consecutivo_diario";
	        public static String COLUMNA_EQUIPO = "equipo";
	        public static String COLUMNA_USUARIO = "usuario";
	        public static String COLUMNA_NOMBRE_ENCUESTA = "nombre_encuesta";
	        public static String COLUMNA_FECHA = "fecha";
	        public static String COLUMNA_HORA = "hora";
	        public static String COLUMNA_imei = "imei";
	        public static String COLUMNA_latitud = "latitud";
	        public static String COLUMNA_longitud = "longitud";
	        //INICIAN PREGUNTAS
	        public static String COLUMNA_pregunta_1="pregunta_1";
	        public static String COLUMNA_pregunta_2="pregunta_2";
	        public static String COLUMNA_pregunta_3="pregunta_3";
	        public static String COLUMNA_pregunta_4="pregunta_4";
	        public static String COLUMNA_pregunta_5="pregunta_5";
	        public static String COLUMNA_pregunta_6="pregunta_6";
	        public static String COLUMNA_pregunta_7="pregunta_7";
	        public static String COLUMNA_pregunta_8="pregunta_8";
	        public static String COLUMNA_pregunta_9="pregunta_9";
	        public static String COLUMNA_pregunta_10="pregunta_10";
	        public static String COLUMNA_pregunta_11="pregunta_11";
	        public static String COLUMNA_pregunta_12="pregunta_12";
	        public static String COLUMNA_pregunta_13="pregunta_13";
	        public static String COLUMNA_pregunta_13a="pregunta_13a";
	        public static String COLUMNA_pregunta_13b="pregunta_13b";
	        public static String COLUMNA_pregunta_13c="pregunta_13c";
	        public static String COLUMNA_pregunta_13d="pregunta_13d";
	        public static String COLUMNA_pregunta_14="pregunta_14";
	        public static String COLUMNA_pregunta_14a="pregunta_14a";
	        public static String COLUMNA_pregunta_14b="pregunta_14b";
	        public static String COLUMNA_pregunta_14c="pregunta_14c";
	        public static String COLUMNA_pregunta_15="pregunta_15";
	        public static String COLUMNA_pregunta_15a="pregunta_15a";
	        public static String COLUMNA_pregunta_16="pregunta_16";
	        public static String COLUMNA_pregunta_16a="pregunta_16a";
	        public static String COLUMNA_pregunta_16b="pregunta_16b";
	        public static String COLUMNA_pregunta_16_1="pregunta_16_1";
	        public static String COLUMNA_pregunta_16c="pregunta_16c";
	        public static String COLUMNA_pregunta_16d="pregunta_16d";
	        public static String COLUMNA_pregunta_16e="pregunta_16e";
	        public static String COLUMNA_pregunta_16f="pregunta_16f";
	        public static String COLUMNA_pregunta_16g="pregunta_16g";
	        public static String COLUMNA_pregunta_16h="pregunta_16h";
	        public static String COLUMNA_pregunta_16i="pregunta_16i";
	        public static String COLUMNA_pregunta_16j="pregunta_16j";
	        public static String COLUMNA_pregunta_16k="pregunta_16k";
	        public static String COLUMNA_pregunta_16l="pregunta_16l";
	        public static String COLUMNA_pregunta_16m="pregunta_16m";
	        public static String COLUMNA_pregunta_16n="pregunta_16n";
	        public static String COLUMNA_pregunta_16o="pregunta_16o";
	        public static String COLUMNA_pregunta_17="pregunta_17";
	        public static String COLUMNA_pregunta_17a="pregunta_17a";
	        public static String COLUMNA_pregunta_17b="pregunta_17b";
	        public static String COLUMNA_pregunta_18="pregunta_18";
	        public static String COLUMNA_pregunta_19="pregunta_19";
	        public static String COLUMNA_pregunta_19a="pregunta_19a";
	        public static String COLUMNA_pregunta_19b="pregunta_19b";
	        public static String COLUMNA_pregunta_19c="pregunta_19c";
	        public static String COLUMNA_pregunta_19d="pregunta_19d";
	        public static String COLUMNA_pregunta_19e="pregunta_19e";
	        public static String COLUMNA_pregunta_20="pregunta_20";
	        public static String COLUMNA_pregunta_21="pregunta_21";
	        public static String COLUMNA_pregunta_22="pregunta_22";
	        public static String COLUMNA_pregunta_23="pregunta_23";
	        public static String COLUMNA_pregunta_24="pregunta_24";
	        public static String COLUMNA_pregunta_25="pregunta_25";
	        public static String COLUMNA_pregunta_26="pregunta_26";
	        public static String COLUMNA_pregunta_26a="pregunta_26a";
	        public static String COLUMNA_pregunta_26b="pregunta_26b";
	        public static String COLUMNA_pregunta_27="pregunta_27";
	        public static String COLUMNA_pregunta_27a="pregunta_27a";
	        public static String COLUMNA_pregunta_27a1="pregunta_27a1";
	        public static String COLUMNA_pregunta_27a2="pregunta_27a2";
	        public static String COLUMNA_pregunta_27a3="pregunta_27a3";
	        public static String COLUMNA_pregunta_27a4="pregunta_27a4";
	        public static String COLUMNA_pregunta_28="pregunta_28";
	        public static String COLUMNA_pregunta_29="pregunta_29";
	        public static String COLUMNA_pregunta_29a="pregunta_29a";
	        public static String COLUMNA_pregunta_29a1="pregunta_29a1";
	        public static String COLUMNA_pregunta_29a2="pregunta_29a2";
	        public static String COLUMNA_pregunta_30="pregunta_30";
	        public static String COLUMNA_pregunta_31="pregunta_31";
	        public static String COLUMNA_pregunta_32="pregunta_32";
	        public static String COLUMNA_pregunta_33="pregunta_33";
	        public static String COLUMNA_foto_croquis="foto_croquis";

	        public static String COLUMNA_abandono="abandono";
	       
	        // FINALIZAN PREGUNTAS
	        public static String COLUMNA_TIEMPO = "tiempo";
	        public static String COLUMNA_TIPOCAPTURA = "tipocaptura";
	    }
	    


	    
	    private static final String DATABASE_ENCUESTA= "create table "
	            + TablaEncuestas.TABLA_ENCUESTAS + "("
	            + "id integer primary key autoincrement,"
	            + TablaEncuestas.COLUMNA_CONSECUTIVO_DIARIO + " text not null, "
	            + TablaEncuestas.COLUMNA_EQUIPO + " text not null, "
	            + TablaEncuestas.COLUMNA_USUARIO + " text not null, "
	            + TablaEncuestas.COLUMNA_NOMBRE_ENCUESTA + " text not null, "
	            + TablaEncuestas.COLUMNA_FECHA + " date not null, "
	            + TablaEncuestas.COLUMNA_HORA + " text not null, "
	            + TablaEncuestas.COLUMNA_imei + " text not null, "
	            + TablaEncuestas.COLUMNA_latitud + " text, "
	            + TablaEncuestas.COLUMNA_longitud + " text, "
	            
+ TablaEncuestas.COLUMNA_pregunta_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_3 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_4 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_5 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_6 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_7 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_8 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_9 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_10 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_11 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_12 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_13 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_13a +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_13b +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_13c +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_13d +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_14 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_14a +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_14b +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_14c +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_15 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_15a +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16a +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16b +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16c +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16d +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16e +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16f +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16g +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16h +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16i +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16j +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16k +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16l +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16m +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16n +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16o +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_17 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_17a +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_17b +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_18 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_19 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_19a +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_19b +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_19c +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_19d +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_19e +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_20 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_21 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_22 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_23 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_24 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_25 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_26 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_26a +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_26b +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_27 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_27a +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_27a1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_27a2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_27a3 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_27a4 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_28 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_29 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_29a +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_29a1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_29a2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_30 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_31 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_32 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_33 +  " text, "
+ TablaEncuestas.COLUMNA_foto_croquis +  " text, "

+ TablaEncuestas.COLUMNA_abandono +  " text, "

				
				+ TablaEncuestas.COLUMNA_TIEMPO + " text not null, "
				+ TablaEncuestas.COLUMNA_TIPOCAPTURA + " text not null); ";
	    
////////////////////////////  TABLA USUARIOS	 /////////////////////////////////////////////////////////    
	    
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
	        db.execSQL(DATABASE_ENCUESTA);
	        
	        
	        
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
	        db.execSQL("drop table if exists " + TablaEncuestas.TABLA_ENCUESTAS);
	        onCreate(db);
	    }
}
