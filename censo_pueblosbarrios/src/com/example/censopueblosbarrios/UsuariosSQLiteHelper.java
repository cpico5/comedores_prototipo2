package com.example.censopueblosbarrios;	

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
	 private static final int DATABASE_VERSION = 4;
	 
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
	 
//////////////////////   TABLA DATOS  //////////////////////////////////////////////////////////////
	 
	 
	    public static class TablaDatos{
	        public static String TABLA_DATOS = "datos";
	        public static String COLUMNA_SECCION = "seccion";
	        public static String COLUMNA_DISTRITO = "distrito";
	        public static String COLUMNA_MUNICIPIO = "municipio";
	        public static String COLUMNA_DELEGACION = "delegacion";
	        public static String COLUMNA_EQUIPOS = "equipo";
	        public static String COLUMNA_COORDINADOR = "coordinador";
	        
	    }
	    
	    private static final String DATABASE_DATOS = "create table "
	            + TablaDatos.TABLA_DATOS + "(" 
	            + TablaDatos.COLUMNA_SECCION + " INTEGER not null, "
	    		+ TablaDatos.COLUMNA_DISTRITO + " text not null, "
	    		+ TablaDatos.COLUMNA_MUNICIPIO + " text not null, "
	    		+ TablaDatos.COLUMNA_DELEGACION + " integer not null, "
	    		+ TablaDatos.COLUMNA_EQUIPOS + " text not null, "
	    		+ TablaDatos.COLUMNA_COORDINADOR + " text not null); ";
	    
	    

	    
	    

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
	        public static String COLUMNA_SECCION = "seccion";
	        public static String COLUMNA_latitud = "latitud";
	        public static String COLUMNA_longitud = "longitud";
	        public static String COLUMNA_latitud2 = "latitud2";
	        public static String COLUMNA_longitud2 = "longitud2";
	        //INICIAN PREGUNTAS
	        public static String COLUMNA_pregunta_1="pregunta_1";
	        public static String COLUMNA_pregunta_2="pregunta_2";
	        public static String COLUMNA_pregunta_3="pregunta_3";
	        public static String COLUMNA_pregunta_4="pregunta_4";
	        public static String COLUMNA_pregunta_5="pregunta_5";
	        public static String COLUMNA_pregunta_6="pregunta_6";
	        public static String COLUMNA_pregunta_6a="pregunta_6a";
	        public static String COLUMNA_pregunta_6b="pregunta_6b";
	        public static String COLUMNA_pregunta_6c="pregunta_6c";
	        public static String COLUMNA_pregunta_7="pregunta_7";
	        public static String COLUMNA_pregunta_7a="pregunta_7a";
	        public static String COLUMNA_pregunta_8_1="pregunta_8_1";
	        public static String COLUMNA_pregunta_9_1="pregunta_9_1";
	        public static String COLUMNA_pregunta_10_1="pregunta_10_1";
	        public static String COLUMNA_pregunta_10a_1="pregunta_10a_1";
	        public static String COLUMNA_pregunta_10b_1="pregunta_10b_1";
	        public static String COLUMNA_pregunta_10c_1="pregunta_10c_1";
	        public static String COLUMNA_pregunta_11_1="pregunta_11_1";
	        public static String COLUMNA_pregunta_12_1="pregunta_12_1";
	        public static String COLUMNA_pregunta_12a_1="pregunta_12a_1";
	        public static String COLUMNA_pregunta_13_1="pregunta_13_1";
	        public static String COLUMNA_pregunta_13a_1="pregunta_13a_1";
	        public static String COLUMNA_pregunta_13b_1="pregunta_13b_1";
	        public static String COLUMNA_pregunta_13c_1="pregunta_13c_1";
	        public static String COLUMNA_pregunta_14_1="pregunta_14_1";
	        public static String COLUMNA_pregunta_14a_1="pregunta_14a_1";
	        public static String COLUMNA_pregunta_14b_1="pregunta_14b_1";
	        public static String COLUMNA_pregunta_8_2="pregunta_8_2";
	        public static String COLUMNA_pregunta_9_2="pregunta_9_2";
	        public static String COLUMNA_pregunta_10_2="pregunta_10_2";
	        public static String COLUMNA_pregunta_10a_2="pregunta_10a_2";
	        public static String COLUMNA_pregunta_10b_2="pregunta_10b_2";
	        public static String COLUMNA_pregunta_10c_2="pregunta_10c_2";
	        public static String COLUMNA_pregunta_11_2="pregunta_11_2";
	        public static String COLUMNA_pregunta_12_2="pregunta_12_2";
	        public static String COLUMNA_pregunta_12a_2="pregunta_12a_2";
	        public static String COLUMNA_pregunta_13_2="pregunta_13_2";
	        public static String COLUMNA_pregunta_13a_2="pregunta_13a_2";
	        public static String COLUMNA_pregunta_13b_2="pregunta_13b_2";
	        public static String COLUMNA_pregunta_13c_2="pregunta_13c_2";
	        public static String COLUMNA_pregunta_14_2="pregunta_14_2";
	        public static String COLUMNA_pregunta_14a_2="pregunta_14a_2";
	        public static String COLUMNA_pregunta_14b_2="pregunta_14b_2";
	        public static String COLUMNA_pregunta_15="pregunta_15";
	        public static String COLUMNA_pregunta_15a="pregunta_15a";
	        public static String COLUMNA_pregunta_16_1="pregunta_16_1";
	        public static String COLUMNA_pregunta_17_1="pregunta_17_1";
	        public static String COLUMNA_pregunta_17a_1="pregunta_17a_1";
	        public static String COLUMNA_pregunta_17b_1="pregunta_17b_1";
	        public static String COLUMNA_pregunta_17c_1="pregunta_17c_1";
	        public static String COLUMNA_pregunta_18_1="pregunta_18_1";
	        public static String COLUMNA_pregunta_19_1="pregunta_19_1";
	        public static String COLUMNA_pregunta_20_1="pregunta_20_1";
	        public static String COLUMNA_pregunta_21_1="pregunta_21_1";
	        public static String COLUMNA_pregunta_22_1="pregunta_22_1";
	        public static String COLUMNA_pregunta_22a_1="pregunta_22a_1";
	        public static String COLUMNA_pregunta_23_1="pregunta_23_1";
	        public static String COLUMNA_pregunta_16_2="pregunta_16_2";
	        public static String COLUMNA_pregunta_17_2="pregunta_17_2";
	        public static String COLUMNA_pregunta_17a_2="pregunta_17a_2";
	        public static String COLUMNA_pregunta_17b_2="pregunta_17b_2";
	        public static String COLUMNA_pregunta_17c_2="pregunta_17c_2";
	        public static String COLUMNA_pregunta_18_2="pregunta_18_2";
	        public static String COLUMNA_pregunta_19_2="pregunta_19_2";
	        public static String COLUMNA_pregunta_20_2="pregunta_20_2";
	        public static String COLUMNA_pregunta_21_2="pregunta_21_2";
	        public static String COLUMNA_pregunta_22_2="pregunta_22_2";
	        public static String COLUMNA_pregunta_22a_2="pregunta_22a_2";
	        public static String COLUMNA_pregunta_23_2="pregunta_23_2";
	        public static String COLUMNA_pregunta_90="pregunta_90";
	        public static String COLUMNA_pregunta_90a="pregunta_90a";
	        public static String COLUMNA_pregunta_90b="pregunta_90b";
	        public static String COLUMNA_pregunta_90c="pregunta_90c";
	        public static String COLUMNA_pregunta_90d="pregunta_90d";
	        public static String COLUMNA_pregunta_90e="pregunta_90e";
	        public static String COLUMNA_pregunta_90f="pregunta_90f";
	        public static String COLUMNA_pregunta_90g="pregunta_90g";
	        public static String COLUMNA_pregunta_90h="pregunta_90h";
	        public static String COLUMNA_pregunta_90i="pregunta_90i";
	        public static String COLUMNA_pregunta_90j="pregunta_90j";


	        public static String COLUMNA_hijos  		="hijos";
	        public static String COLUMNA_aporta  		="aporta";
	        public static String COLUMNA_ocupacion  	="ocupacion";
	        public static String COLUMNA_coche  		="coche";
	        public static String COLUMNA_cuantos_coches ="cuantos_coches";
	        public static String COLUMNA_cuartos  		="cuartos";
	        public static String COLUMNA_cuartos_dormir ="cuartos_dormir";
	        public static String COLUMNA_focos  		="focos";
	        public static String COLUMNA_banos  		="banos";
	        public static String COLUMNA_regadera  		="regadera";
	        public static String COLUMNA_internet  		="internet";
	        public static String COLUMNA_trabajaron 	="trabajaron";
	        public static String COLUMNA_estufa  		="estufa";
	        public static String COLUMNA_edad  			="edad";
	        public static String COLUMNA_genero  		="genero";
	        public static String COLUMNA_tipo_vivienda  ="tipo_vivienda";
	        public static String COLUMNA_tipo_piso 		="tipo_piso";
	        public static String COLUMNA_foto_fachada 		="foto_fachada";


	        public static String COLUMNA_abandono="abandono";
	        public static String COLUMNA_suma="suma";
	        public static String COLUMNA_status="status";
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
	            + TablaEncuestas.COLUMNA_SECCION + " INTEGER not null, "
	            + TablaEncuestas.COLUMNA_latitud + " text, "
	            + TablaEncuestas.COLUMNA_longitud + " text, "
	             + TablaEncuestas.COLUMNA_latitud2 + " text, "
	            + TablaEncuestas.COLUMNA_longitud2 + " text, "
	            
+ TablaEncuestas.COLUMNA_pregunta_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_3 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_4 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_5 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_6 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_6a +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_6b +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_6c +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_7 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_7a +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_8_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_9_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_10_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_10a_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_10b_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_10c_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_11_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_12_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_12a_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_13_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_13a_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_13b_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_13c_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_14_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_14a_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_14b_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_8_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_9_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_10_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_10a_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_10b_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_10c_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_11_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_12_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_12a_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_13_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_13a_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_13b_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_13c_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_14_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_14a_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_14b_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_15 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_15a +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_17_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_17a_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_17b_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_17c_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_18_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_19_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_20_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_21_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_22_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_22a_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_23_1 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_16_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_17_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_17a_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_17b_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_17c_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_18_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_19_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_20_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_21_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_22_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_22a_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_23_2 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_90 +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_90a +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_90b +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_90c +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_90d +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_90e +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_90f +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_90g +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_90h +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_90i +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_90j +  " text, "


+ TablaEncuestas.COLUMNA_hijos  +  " text, "
+ TablaEncuestas.COLUMNA_aporta  +  " text, "
+ TablaEncuestas.COLUMNA_ocupacion  +  " text, "
+ TablaEncuestas.COLUMNA_coche  +  " text, "
+ TablaEncuestas.COLUMNA_cuantos_coches  +  " text, "
+ TablaEncuestas.COLUMNA_cuartos  +  " text, "
+ TablaEncuestas.COLUMNA_cuartos_dormir  +  " text, "
+ TablaEncuestas.COLUMNA_focos  +  " text, "
+ TablaEncuestas.COLUMNA_banos  +  " text, "
+ TablaEncuestas.COLUMNA_regadera  +  " text, "
+ TablaEncuestas.COLUMNA_internet  +  " text, "
+ TablaEncuestas.COLUMNA_trabajaron  +  " text, "
+ TablaEncuestas.COLUMNA_estufa  +  " text, "
+ TablaEncuestas.COLUMNA_edad  +  " text, "
+ TablaEncuestas.COLUMNA_genero  +  " text, "
+ TablaEncuestas.COLUMNA_tipo_vivienda  +  " text, "
+ TablaEncuestas.COLUMNA_tipo_piso  +  " text, "
+ TablaEncuestas.COLUMNA_foto_fachada  +  " text, "


+ TablaEncuestas.COLUMNA_abandono +  " text, "

				+ TablaEncuestas.COLUMNA_suma +  " text, "
				+ TablaEncuestas.COLUMNA_status +  " text, "
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
