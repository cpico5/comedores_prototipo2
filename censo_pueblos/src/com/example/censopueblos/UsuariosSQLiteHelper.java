package com.example.censopueblos;	

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
	 private static final int DATABASE_VERSION = 10;
	 
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
	    	        
	        public static String COLUMNA_pregunta_72	="pregunta_72";
	        public static String COLUMNA_pregunta_72a	="pregunta_72a";
	        public static String COLUMNA_pregunta_73	="pregunta_73";
	        public static String COLUMNA_pregunta_73a	="pregunta_73a";
	        public static String COLUMNA_edad  			="edad";
	        public static String COLUMNA_aporta  		="aporta";
	        public static String COLUMNA_ocupacion  	="ocupacion";
	        public static String COLUMNA_pregunta_76a	="pregunta_76a";
	        public static String COLUMNA_pregunta_76b	="pregunta_76b";
	        public static String COLUMNA_trabajaron 	="trabajaron";
	        public static String COLUMNA_coche  		="coche";
	        public static String COLUMNA_cuantos_coches ="cuantos_coches";
	        public static String COLUMNA_cuartos  		="cuartos";
	        public static String COLUMNA_cuartos_dormir ="cuartos_dormir";
	        public static String COLUMNA_focos  		="focos";
	        public static String COLUMNA_banos  		="banos";
	        public static String COLUMNA_regadera  		="regadera";
	        public static String COLUMNA_internet  		="internet";
	        public static String COLUMNA_estufa  		="estufa";
	        public static String COLUMNA_tipo_piso 		="tipo_piso";
	        public static String COLUMNA_tipo_vivienda  ="tipo_vivienda";
	        public static String COLUMNA_pregunta_88	="pregunta_88";
	        public static String COLUMNA_genero  		="genero";
// direccion
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
	        
	        public static String COLUMNA_foto_fachada="foto_fachada";

	        
	        

	        public static String COLUMNA_abandono="abandono";
	        public static String COLUMNA_suma="suma";
	        public static String COLUMNA_status="status";
	        // FINALIZAN PREGUNTAS
	        public static String COLUMNA_TIEMPO = "tiempo";
	        public static String COLUMNA_TIPOCAPTURA = "tipocaptura";
	    }
	    
	    private static final String DATABASE_ENCUESTAS= "create table "
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

	        + TablaEncuestas.COLUMNA_pregunta_72 +  " text, "
	        + TablaEncuestas.COLUMNA_pregunta_72a +  " text, "
	        + TablaEncuestas.COLUMNA_pregunta_73 +  " text, "
	        + TablaEncuestas.COLUMNA_pregunta_73a +  " text, "
	        + TablaEncuestas.COLUMNA_edad  +  " text, "
	        + TablaEncuestas.COLUMNA_aporta  +  " text, "
	        + TablaEncuestas.COLUMNA_ocupacion  +  " text, "
	        + TablaEncuestas.COLUMNA_pregunta_76a +  " text, "
	        + TablaEncuestas.COLUMNA_pregunta_76b +  " text, "
	        + TablaEncuestas.COLUMNA_trabajaron  +  " text, "
+ TablaEncuestas.COLUMNA_coche  +  " text, "
+ TablaEncuestas.COLUMNA_cuantos_coches  +  " text, "
+ TablaEncuestas.COLUMNA_cuartos  +  " text, "
+ TablaEncuestas.COLUMNA_cuartos_dormir  +  " text, "
+ TablaEncuestas.COLUMNA_focos  +  " text, "
+ TablaEncuestas.COLUMNA_banos  +  " text, "
+ TablaEncuestas.COLUMNA_regadera  +  " text, "
+ TablaEncuestas.COLUMNA_internet  +  " text, "
+ TablaEncuestas.COLUMNA_estufa  +  " text, "
+ TablaEncuestas.COLUMNA_tipo_piso  +  " text, "
+ TablaEncuestas.COLUMNA_tipo_vivienda  +  " text, "
+ TablaEncuestas.COLUMNA_pregunta_88 +  " text, "
+ TablaEncuestas.COLUMNA_genero  +  " text, "

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
+ TablaEncuestas.COLUMNA_foto_fachada +  " text, "

+ TablaEncuestas.COLUMNA_abandono +  " text, "

				+ TablaEncuestas.COLUMNA_suma +  " text, "
				+ TablaEncuestas.COLUMNA_status +  " text, "
				+ TablaEncuestas.COLUMNA_TIEMPO + " text not null, "
				+ TablaEncuestas.COLUMNA_TIPOCAPTURA + " text not null); ";
	    
	    
/////////////////////  TABLA ENCUESTAS  ///////////////////////////////////////////////
	    
public static class TablaAdultos{
public static String TABLA_ADULTOS = "encuestas_adultos";
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
public static String COLUMNA_pregunta_7="pregunta_7";
public static String COLUMNA_pregunta_7a="pregunta_7a";

public static String COLUMNA_pregunta_8_1="pregunta_8_1";
public static String COLUMNA_pregunta_8a_1="pregunta_8a_1";
public static String COLUMNA_pregunta_9_1="pregunta_9_1";
public static String COLUMNA_pregunta_10_1="pregunta_10_1";
public static String COLUMNA_pregunta_11_1="pregunta_11_1";
public static String COLUMNA_pregunta_11a_1="pregunta_11a_1";
public static String COLUMNA_pregunta_11b_1="pregunta_11b_1";
public static String COLUMNA_pregunta_11c_1="pregunta_11c_1";
public static String COLUMNA_pregunta_12_1="pregunta_12_1";
public static String COLUMNA_pregunta_12a_1="pregunta_12a_1";
public static String COLUMNA_pregunta_12b_1="pregunta_12b_1";
public static String COLUMNA_pregunta_12c_1="pregunta_12c_1";
public static String COLUMNA_pregunta_13_1="pregunta_13_1";
public static String COLUMNA_pregunta_14_1="pregunta_14_1";
public static String COLUMNA_pregunta_14a_1="pregunta_14a_1";
public static String COLUMNA_pregunta_14b_1="pregunta_14b_1";
public static String COLUMNA_pregunta_14c_1="pregunta_14c_1";
public static String COLUMNA_pregunta_15_1="pregunta_15_1";
public static String COLUMNA_pregunta_15a_1="pregunta_15a_1";
public static String COLUMNA_pregunta_16_1="pregunta_16_1";
public static String COLUMNA_pregunta_16a_1="pregunta_16a_1";
public static String COLUMNA_pregunta_16b_1="pregunta_16b_1";
public static String COLUMNA_pregunta_17_1="pregunta_17_1";
public static String COLUMNA_pregunta_17a_1="pregunta_17a_1";
public static String COLUMNA_pregunta_18_1="pregunta_18_1";
public static String COLUMNA_pregunta_19_1="pregunta_19_1";
public static String COLUMNA_pregunta_19a_1="pregunta_19a_1";
public static String COLUMNA_pregunta_19b_1="pregunta_19b_1";
public static String COLUMNA_pregunta_19c_1="pregunta_19c_1";
public static String COLUMNA_pregunta_19d_1="pregunta_19d_1";
public static String COLUMNA_pregunta_19e_1="pregunta_19e_1";
public static String COLUMNA_pregunta_19f_1="pregunta_19f_1";
public static String COLUMNA_pregunta_19g_1="pregunta_19g_1";
public static String COLUMNA_pregunta_19h_1="pregunta_19h_1";
public static String COLUMNA_pregunta_20_1="pregunta_20_1";
public static String COLUMNA_pregunta_20a_1="pregunta_20a_1";
public static String COLUMNA_pregunta_20b_1="pregunta_20b_1";
public static String COLUMNA_pregunta_20c_1="pregunta_20c_1";
public static String COLUMNA_pregunta_20d_1="pregunta_20d_1";
public static String COLUMNA_pregunta_20e_1="pregunta_20e_1";
public static String COLUMNA_pregunta_192_1="pregunta_192_1";
public static String COLUMNA_pregunta_193_1="pregunta_193_1";
public static String COLUMNA_pregunta_193a_1="pregunta_193a_1";
public static String COLUMNA_pregunta_193b_1="pregunta_193b_1";
public static String COLUMNA_pregunta_193c_1="pregunta_193c_1";
public static String COLUMNA_pregunta_193d_1="pregunta_193d_1";
public static String COLUMNA_pregunta_193e_1="pregunta_193e_1";
public static String COLUMNA_pregunta_193f_1="pregunta_193f_1";
public static String COLUMNA_pregunta_193g_1="pregunta_193g_1";
public static String COLUMNA_pregunta_193h_1="pregunta_193h_1";
public static String COLUMNA_pregunta_CLAS_1="pregunta_CLAS_1";
public static String COLUMNA_pregunta_21_1="pregunta_21_1";
public static String COLUMNA_pregunta_22_1="pregunta_22_1";
public static String COLUMNA_pregunta_23_1="pregunta_23_1";
public static String COLUMNA_pregunta_24_1="pregunta_24_1";
public static String COLUMNA_pregunta_24a_1="pregunta_24a_1";
public static String COLUMNA_pregunta_24a1_1="pregunta_24a1_1";
public static String COLUMNA_pregunta_24a2_1="pregunta_24a2_1";
public static String COLUMNA_pregunta_24a3_1="pregunta_24a3_1";
public static String COLUMNA_pregunta_24a4_1="pregunta_24a4_1";
public static String COLUMNA_pregunta_24a5_1="pregunta_24a5_1";
public static String COLUMNA_pregunta_25_1="pregunta_25_1";
public static String COLUMNA_pregunta_25a_1="pregunta_25a_1";
public static String COLUMNA_pregunta_25b_1="pregunta_25b_1";
public static String COLUMNA_pregunta_25c_1="pregunta_25c_1";
public static String COLUMNA_pregunta_25d_1="pregunta_25d_1";
public static String COLUMNA_pregunta_25e_1="pregunta_25e_1";
public static String COLUMNA_pregunta_25f_1="pregunta_25f_1";
public static String COLUMNA_pregunta_25g_1="pregunta_25g_1";
public static String COLUMNA_pregunta_25h_1="pregunta_25h_1";
public static String COLUMNA_pregunta_25i_1="pregunta_25i_1";
public static String COLUMNA_pregunta_25j_1="pregunta_25j_1";
public static String COLUMNA_pregunta_25k_1="pregunta_25k_1";
public static String COLUMNA_pregunta_26_1="pregunta_26_1";
public static String COLUMNA_pregunta_27_1="pregunta_27_1";
public static String COLUMNA_pregunta_28_1="pregunta_28_1";
public static String COLUMNA_pregunta_29_1="pregunta_29_1";
public static String COLUMNA_pregunta_30_1="pregunta_30_1";
public static String COLUMNA_pregunta_30a_1="pregunta_30a_1";

public static String COLUMNA_pregunta_8_2="pregunta_8_2";
public static String COLUMNA_pregunta_8a_2="pregunta_8a_2";
public static String COLUMNA_pregunta_9_2="pregunta_9_2";
public static String COLUMNA_pregunta_10_2="pregunta_10_2";
public static String COLUMNA_pregunta_11_2="pregunta_11_2";
public static String COLUMNA_pregunta_11a_2="pregunta_11a_2";
public static String COLUMNA_pregunta_11b_2="pregunta_11b_2";
public static String COLUMNA_pregunta_11c_2="pregunta_11c_2";
public static String COLUMNA_pregunta_12_2="pregunta_12_2";
public static String COLUMNA_pregunta_12a_2="pregunta_12a_2";
public static String COLUMNA_pregunta_12b_2="pregunta_12b_2";
public static String COLUMNA_pregunta_12c_2="pregunta_12c_2";
public static String COLUMNA_pregunta_13_2="pregunta_13_2";
public static String COLUMNA_pregunta_14_2="pregunta_14_2";
public static String COLUMNA_pregunta_14a_2="pregunta_14a_2";
public static String COLUMNA_pregunta_14b_2="pregunta_14b_2";
public static String COLUMNA_pregunta_14c_2="pregunta_14c_2";
public static String COLUMNA_pregunta_15_2="pregunta_15_2";
public static String COLUMNA_pregunta_15a_2="pregunta_15a_2";
public static String COLUMNA_pregunta_16_2="pregunta_16_2";
public static String COLUMNA_pregunta_16a_2="pregunta_16a_2";
public static String COLUMNA_pregunta_16b_2="pregunta_16b_2";
public static String COLUMNA_pregunta_17_2="pregunta_17_2";
public static String COLUMNA_pregunta_17a_2="pregunta_17a_2";
public static String COLUMNA_pregunta_18_2="pregunta_18_2";
public static String COLUMNA_pregunta_19_2="pregunta_19_2";
public static String COLUMNA_pregunta_19a_2="pregunta_19a_2";
public static String COLUMNA_pregunta_19b_2="pregunta_19b_2";
public static String COLUMNA_pregunta_19c_2="pregunta_19c_2";
public static String COLUMNA_pregunta_19d_2="pregunta_19d_2";
public static String COLUMNA_pregunta_19e_2="pregunta_19e_2";
public static String COLUMNA_pregunta_19f_2="pregunta_19f_2";
public static String COLUMNA_pregunta_19g_2="pregunta_19g_2";
public static String COLUMNA_pregunta_19h_2="pregunta_19h_2";
public static String COLUMNA_pregunta_20_2="pregunta_20_2";
public static String COLUMNA_pregunta_20a_2="pregunta_20a_2";
public static String COLUMNA_pregunta_20b_2="pregunta_20b_2";
public static String COLUMNA_pregunta_20c_2="pregunta_20c_2";
public static String COLUMNA_pregunta_20d_2="pregunta_20d_2";
public static String COLUMNA_pregunta_20e_2="pregunta_20e_2";
public static String COLUMNA_pregunta_192_2="pregunta_192_2";
public static String COLUMNA_pregunta_193_2="pregunta_193_2";
public static String COLUMNA_pregunta_193a_2="pregunta_193a_2";
public static String COLUMNA_pregunta_193b_2="pregunta_193b_2";
public static String COLUMNA_pregunta_193c_2="pregunta_193c_2";
public static String COLUMNA_pregunta_193d_2="pregunta_193d_2";
public static String COLUMNA_pregunta_193e_2="pregunta_193e_2";
public static String COLUMNA_pregunta_193f_2="pregunta_193f_2";
public static String COLUMNA_pregunta_193g_2="pregunta_193g_2";
public static String COLUMNA_pregunta_193h_2="pregunta_193h_2";
public static String COLUMNA_pregunta_CLAS_2="pregunta_CLAS_2";
public static String COLUMNA_pregunta_21_2="pregunta_21_2";
public static String COLUMNA_pregunta_22_2="pregunta_22_2";
public static String COLUMNA_pregunta_23_2="pregunta_23_2";
public static String COLUMNA_pregunta_24_2="pregunta_24_2";
public static String COLUMNA_pregunta_24a_2="pregunta_24a_2";
public static String COLUMNA_pregunta_24a1_2="pregunta_24a1_2";
public static String COLUMNA_pregunta_24a2_2="pregunta_24a2_2";
public static String COLUMNA_pregunta_24a3_2="pregunta_24a3_2";
public static String COLUMNA_pregunta_24a4_2="pregunta_24a4_2";
public static String COLUMNA_pregunta_24a5_2="pregunta_24a5_2";
public static String COLUMNA_pregunta_25_2="pregunta_25_2";
public static String COLUMNA_pregunta_25a_2="pregunta_25a_2";
public static String COLUMNA_pregunta_25b_2="pregunta_25b_2";
public static String COLUMNA_pregunta_25c_2="pregunta_25c_2";
public static String COLUMNA_pregunta_25d_2="pregunta_25d_2";
public static String COLUMNA_pregunta_25e_2="pregunta_25e_2";
public static String COLUMNA_pregunta_25f_2="pregunta_25f_2";
public static String COLUMNA_pregunta_25g_2="pregunta_25g_2";
public static String COLUMNA_pregunta_25h_2="pregunta_25h_2";
public static String COLUMNA_pregunta_25i_2="pregunta_25i_2";
public static String COLUMNA_pregunta_25j_2="pregunta_25j_2";
public static String COLUMNA_pregunta_25k_2="pregunta_25k_2";
public static String COLUMNA_pregunta_26_2="pregunta_26_2";
public static String COLUMNA_pregunta_27_2="pregunta_27_2";
public static String COLUMNA_pregunta_28_2="pregunta_28_2";
public static String COLUMNA_pregunta_29_2="pregunta_29_2";
public static String COLUMNA_pregunta_30_2="pregunta_30_2";
public static String COLUMNA_pregunta_30a_2="pregunta_30a_2";

public static String COLUMNA_pregunta_8_3="pregunta_8_3";
public static String COLUMNA_pregunta_8a_3="pregunta_8a_3";
public static String COLUMNA_pregunta_9_3="pregunta_9_3";
public static String COLUMNA_pregunta_10_3="pregunta_10_3";
public static String COLUMNA_pregunta_11_3="pregunta_11_3";
public static String COLUMNA_pregunta_11a_3="pregunta_11a_3";
public static String COLUMNA_pregunta_11b_3="pregunta_11b_3";
public static String COLUMNA_pregunta_11c_3="pregunta_11c_3";
public static String COLUMNA_pregunta_12_3="pregunta_12_3";
public static String COLUMNA_pregunta_12a_3="pregunta_12a_3";
public static String COLUMNA_pregunta_12b_3="pregunta_12b_3";
public static String COLUMNA_pregunta_12c_3="pregunta_12c_3";
public static String COLUMNA_pregunta_13_3="pregunta_13_3";
public static String COLUMNA_pregunta_14_3="pregunta_14_3";
public static String COLUMNA_pregunta_14a_3="pregunta_14a_3";
public static String COLUMNA_pregunta_14b_3="pregunta_14b_3";
public static String COLUMNA_pregunta_14c_3="pregunta_14c_3";
public static String COLUMNA_pregunta_15_3="pregunta_15_3";
public static String COLUMNA_pregunta_15a_3="pregunta_15a_3";
public static String COLUMNA_pregunta_16_3="pregunta_16_3";
public static String COLUMNA_pregunta_16a_3="pregunta_16a_3";
public static String COLUMNA_pregunta_16b_3="pregunta_16b_3";
public static String COLUMNA_pregunta_17_3="pregunta_17_3";
public static String COLUMNA_pregunta_17a_3="pregunta_17a_3";
public static String COLUMNA_pregunta_18_3="pregunta_18_3";
public static String COLUMNA_pregunta_19_3="pregunta_19_3";
public static String COLUMNA_pregunta_19a_3="pregunta_19a_3";
public static String COLUMNA_pregunta_19b_3="pregunta_19b_3";
public static String COLUMNA_pregunta_19c_3="pregunta_19c_3";
public static String COLUMNA_pregunta_19d_3="pregunta_19d_3";
public static String COLUMNA_pregunta_19e_3="pregunta_19e_3";
public static String COLUMNA_pregunta_19f_3="pregunta_19f_3";
public static String COLUMNA_pregunta_19g_3="pregunta_19g_3";
public static String COLUMNA_pregunta_19h_3="pregunta_19h_3";
public static String COLUMNA_pregunta_20_3="pregunta_20_3";
public static String COLUMNA_pregunta_20a_3="pregunta_20a_3";
public static String COLUMNA_pregunta_20b_3="pregunta_20b_3";
public static String COLUMNA_pregunta_20c_3="pregunta_20c_3";
public static String COLUMNA_pregunta_20d_3="pregunta_20d_3";
public static String COLUMNA_pregunta_20e_3="pregunta_20e_3";
public static String COLUMNA_pregunta_192_3="pregunta_192_3";
public static String COLUMNA_pregunta_193_3="pregunta_193_3";
public static String COLUMNA_pregunta_193a_3="pregunta_193a_3";
public static String COLUMNA_pregunta_193b_3="pregunta_193b_3";
public static String COLUMNA_pregunta_193c_3="pregunta_193c_3";
public static String COLUMNA_pregunta_193d_3="pregunta_193d_3";
public static String COLUMNA_pregunta_193e_3="pregunta_193e_3";
public static String COLUMNA_pregunta_193f_3="pregunta_193f_3";
public static String COLUMNA_pregunta_193g_3="pregunta_193g_3";
public static String COLUMNA_pregunta_193h_3="pregunta_193h_3";
public static String COLUMNA_pregunta_CLAS_3="pregunta_CLAS_3";
public static String COLUMNA_pregunta_21_3="pregunta_21_3";
public static String COLUMNA_pregunta_22_3="pregunta_22_3";
public static String COLUMNA_pregunta_23_3="pregunta_23_3";
public static String COLUMNA_pregunta_24_3="pregunta_24_3";
public static String COLUMNA_pregunta_24a_3="pregunta_24a_3";
public static String COLUMNA_pregunta_24a1_3="pregunta_24a1_3";
public static String COLUMNA_pregunta_24a2_3="pregunta_24a2_3";
public static String COLUMNA_pregunta_24a3_3="pregunta_24a3_3";
public static String COLUMNA_pregunta_24a4_3="pregunta_24a4_3";
public static String COLUMNA_pregunta_24a5_3="pregunta_24a5_3";
public static String COLUMNA_pregunta_25_3="pregunta_25_3";
public static String COLUMNA_pregunta_25a_3="pregunta_25a_3";
public static String COLUMNA_pregunta_25b_3="pregunta_25b_3";
public static String COLUMNA_pregunta_25c_3="pregunta_25c_3";
public static String COLUMNA_pregunta_25d_3="pregunta_25d_3";
public static String COLUMNA_pregunta_25e_3="pregunta_25e_3";
public static String COLUMNA_pregunta_25f_3="pregunta_25f_3";
public static String COLUMNA_pregunta_25g_3="pregunta_25g_3";
public static String COLUMNA_pregunta_25h_3="pregunta_25h_3";
public static String COLUMNA_pregunta_25i_3="pregunta_25i_3";
public static String COLUMNA_pregunta_25j_3="pregunta_25j_3";
public static String COLUMNA_pregunta_25k_3="pregunta_25k_3";
public static String COLUMNA_pregunta_26_3="pregunta_26_3";
public static String COLUMNA_pregunta_27_3="pregunta_27_3";
public static String COLUMNA_pregunta_28_3="pregunta_28_3";
public static String COLUMNA_pregunta_29_3="pregunta_29_3";
public static String COLUMNA_pregunta_30_3="pregunta_30_3";
public static String COLUMNA_pregunta_30a_3="pregunta_30a_3";

public static String COLUMNA_pregunta_8_4="pregunta_8_4";
public static String COLUMNA_pregunta_8a_4="pregunta_8a_4";
public static String COLUMNA_pregunta_9_4="pregunta_9_4";
public static String COLUMNA_pregunta_10_4="pregunta_10_4";
public static String COLUMNA_pregunta_11_4="pregunta_11_4";
public static String COLUMNA_pregunta_11a_4="pregunta_11a_4";
public static String COLUMNA_pregunta_11b_4="pregunta_11b_4";
public static String COLUMNA_pregunta_11c_4="pregunta_11c_4";
public static String COLUMNA_pregunta_12_4="pregunta_12_4";
public static String COLUMNA_pregunta_12a_4="pregunta_12a_4";
public static String COLUMNA_pregunta_12b_4="pregunta_12b_4";
public static String COLUMNA_pregunta_12c_4="pregunta_12c_4";
public static String COLUMNA_pregunta_13_4="pregunta_13_4";
public static String COLUMNA_pregunta_14_4="pregunta_14_4";
public static String COLUMNA_pregunta_14a_4="pregunta_14a_4";
public static String COLUMNA_pregunta_14b_4="pregunta_14b_4";
public static String COLUMNA_pregunta_14c_4="pregunta_14c_4";
public static String COLUMNA_pregunta_15_4="pregunta_15_4";
public static String COLUMNA_pregunta_15a_4="pregunta_15a_4";
public static String COLUMNA_pregunta_16_4="pregunta_16_4";
public static String COLUMNA_pregunta_16a_4="pregunta_16a_4";
public static String COLUMNA_pregunta_16b_4="pregunta_16b_4";
public static String COLUMNA_pregunta_17_4="pregunta_17_4";
public static String COLUMNA_pregunta_17a_4="pregunta_17a_4";
public static String COLUMNA_pregunta_18_4="pregunta_18_4";
public static String COLUMNA_pregunta_19_4="pregunta_19_4";
public static String COLUMNA_pregunta_19a_4="pregunta_19a_4";
public static String COLUMNA_pregunta_19b_4="pregunta_19b_4";
public static String COLUMNA_pregunta_19c_4="pregunta_19c_4";
public static String COLUMNA_pregunta_19d_4="pregunta_19d_4";
public static String COLUMNA_pregunta_19e_4="pregunta_19e_4";
public static String COLUMNA_pregunta_19f_4="pregunta_19f_4";
public static String COLUMNA_pregunta_19g_4="pregunta_19g_4";
public static String COLUMNA_pregunta_19h_4="pregunta_19h_4";
public static String COLUMNA_pregunta_20_4="pregunta_20_4";
public static String COLUMNA_pregunta_20a_4="pregunta_20a_4";
public static String COLUMNA_pregunta_20b_4="pregunta_20b_4";
public static String COLUMNA_pregunta_20c_4="pregunta_20c_4";
public static String COLUMNA_pregunta_20d_4="pregunta_20d_4";
public static String COLUMNA_pregunta_20e_4="pregunta_20e_4";
public static String COLUMNA_pregunta_192_4="pregunta_192_4";
public static String COLUMNA_pregunta_193_4="pregunta_193_4";
public static String COLUMNA_pregunta_193a_4="pregunta_193a_4";
public static String COLUMNA_pregunta_193b_4="pregunta_193b_4";
public static String COLUMNA_pregunta_193c_4="pregunta_193c_4";
public static String COLUMNA_pregunta_193d_4="pregunta_193d_4";
public static String COLUMNA_pregunta_193e_4="pregunta_193e_4";
public static String COLUMNA_pregunta_193f_4="pregunta_193f_4";
public static String COLUMNA_pregunta_193g_4="pregunta_193g_4";
public static String COLUMNA_pregunta_193h_4="pregunta_193h_4";
public static String COLUMNA_pregunta_CLAS_4="pregunta_CLAS_4";
public static String COLUMNA_pregunta_21_4="pregunta_21_4";
public static String COLUMNA_pregunta_22_4="pregunta_22_4";
public static String COLUMNA_pregunta_23_4="pregunta_23_4";
public static String COLUMNA_pregunta_24_4="pregunta_24_4";
public static String COLUMNA_pregunta_24a_4="pregunta_24a_4";
public static String COLUMNA_pregunta_24a1_4="pregunta_24a1_4";
public static String COLUMNA_pregunta_24a2_4="pregunta_24a2_4";
public static String COLUMNA_pregunta_24a3_4="pregunta_24a3_4";
public static String COLUMNA_pregunta_24a4_4="pregunta_24a4_4";
public static String COLUMNA_pregunta_24a5_4="pregunta_24a5_4";
public static String COLUMNA_pregunta_25_4="pregunta_25_4";
public static String COLUMNA_pregunta_25a_4="pregunta_25a_4";
public static String COLUMNA_pregunta_25b_4="pregunta_25b_4";
public static String COLUMNA_pregunta_25c_4="pregunta_25c_4";
public static String COLUMNA_pregunta_25d_4="pregunta_25d_4";
public static String COLUMNA_pregunta_25e_4="pregunta_25e_4";
public static String COLUMNA_pregunta_25f_4="pregunta_25f_4";
public static String COLUMNA_pregunta_25g_4="pregunta_25g_4";
public static String COLUMNA_pregunta_25h_4="pregunta_25h_4";
public static String COLUMNA_pregunta_25i_4="pregunta_25i_4";
public static String COLUMNA_pregunta_25j_4="pregunta_25j_4";
public static String COLUMNA_pregunta_25k_4="pregunta_25k_4";
public static String COLUMNA_pregunta_26_4="pregunta_26_4";
public static String COLUMNA_pregunta_27_4="pregunta_27_4";
public static String COLUMNA_pregunta_28_4="pregunta_28_4";
public static String COLUMNA_pregunta_29_4="pregunta_29_4";
public static String COLUMNA_pregunta_30_4="pregunta_30_4";
public static String COLUMNA_pregunta_30a_4="pregunta_30a_4";

public static String COLUMNA_pregunta_8_5="pregunta_8_5";
public static String COLUMNA_pregunta_8a_5="pregunta_8a_5";
public static String COLUMNA_pregunta_9_5="pregunta_9_5";
public static String COLUMNA_pregunta_10_5="pregunta_10_5";
public static String COLUMNA_pregunta_11_5="pregunta_11_5";
public static String COLUMNA_pregunta_11a_5="pregunta_11a_5";
public static String COLUMNA_pregunta_11b_5="pregunta_11b_5";
public static String COLUMNA_pregunta_11c_5="pregunta_11c_5";
public static String COLUMNA_pregunta_12_5="pregunta_12_5";
public static String COLUMNA_pregunta_12a_5="pregunta_12a_5";
public static String COLUMNA_pregunta_12b_5="pregunta_12b_5";
public static String COLUMNA_pregunta_12c_5="pregunta_12c_5";
public static String COLUMNA_pregunta_13_5="pregunta_13_5";
public static String COLUMNA_pregunta_14_5="pregunta_14_5";
public static String COLUMNA_pregunta_14a_5="pregunta_14a_5";
public static String COLUMNA_pregunta_14b_5="pregunta_14b_5";
public static String COLUMNA_pregunta_14c_5="pregunta_14c_5";
public static String COLUMNA_pregunta_15_5="pregunta_15_5";
public static String COLUMNA_pregunta_15a_5="pregunta_15a_5";
public static String COLUMNA_pregunta_16_5="pregunta_16_5";
public static String COLUMNA_pregunta_16a_5="pregunta_16a_5";
public static String COLUMNA_pregunta_16b_5="pregunta_16b_5";
public static String COLUMNA_pregunta_17_5="pregunta_17_5";
public static String COLUMNA_pregunta_17a_5="pregunta_17a_5";
public static String COLUMNA_pregunta_18_5="pregunta_18_5";
public static String COLUMNA_pregunta_19_5="pregunta_19_5";
public static String COLUMNA_pregunta_19a_5="pregunta_19a_5";
public static String COLUMNA_pregunta_19b_5="pregunta_19b_5";
public static String COLUMNA_pregunta_19c_5="pregunta_19c_5";
public static String COLUMNA_pregunta_19d_5="pregunta_19d_5";
public static String COLUMNA_pregunta_19e_5="pregunta_19e_5";
public static String COLUMNA_pregunta_19f_5="pregunta_19f_5";
public static String COLUMNA_pregunta_19g_5="pregunta_19g_5";
public static String COLUMNA_pregunta_19h_5="pregunta_19h_5";
public static String COLUMNA_pregunta_20_5="pregunta_20_5";
public static String COLUMNA_pregunta_20a_5="pregunta_20a_5";
public static String COLUMNA_pregunta_20b_5="pregunta_20b_5";
public static String COLUMNA_pregunta_20c_5="pregunta_20c_5";
public static String COLUMNA_pregunta_20d_5="pregunta_20d_5";
public static String COLUMNA_pregunta_20e_5="pregunta_20e_5";
public static String COLUMNA_pregunta_192_5="pregunta_192_5";
public static String COLUMNA_pregunta_193_5="pregunta_193_5";
public static String COLUMNA_pregunta_193a_5="pregunta_193a_5";
public static String COLUMNA_pregunta_193b_5="pregunta_193b_5";
public static String COLUMNA_pregunta_193c_5="pregunta_193c_5";
public static String COLUMNA_pregunta_193d_5="pregunta_193d_5";
public static String COLUMNA_pregunta_193e_5="pregunta_193e_5";
public static String COLUMNA_pregunta_193f_5="pregunta_193f_5";
public static String COLUMNA_pregunta_193g_5="pregunta_193g_5";
public static String COLUMNA_pregunta_193h_5="pregunta_193h_5";
public static String COLUMNA_pregunta_CLAS_5="pregunta_CLAS_5";
public static String COLUMNA_pregunta_21_5="pregunta_21_5";
public static String COLUMNA_pregunta_22_5="pregunta_22_5";
public static String COLUMNA_pregunta_23_5="pregunta_23_5";
public static String COLUMNA_pregunta_24_5="pregunta_24_5";
public static String COLUMNA_pregunta_24a_5="pregunta_24a_5";
public static String COLUMNA_pregunta_24a1_5="pregunta_24a1_5";
public static String COLUMNA_pregunta_24a2_5="pregunta_24a2_5";
public static String COLUMNA_pregunta_24a3_5="pregunta_24a3_5";
public static String COLUMNA_pregunta_24a4_5="pregunta_24a4_5";
public static String COLUMNA_pregunta_24a5_5="pregunta_24a5_5";
public static String COLUMNA_pregunta_25_5="pregunta_25_5";
public static String COLUMNA_pregunta_25a_5="pregunta_25a_5";
public static String COLUMNA_pregunta_25b_5="pregunta_25b_5";
public static String COLUMNA_pregunta_25c_5="pregunta_25c_5";
public static String COLUMNA_pregunta_25d_5="pregunta_25d_5";
public static String COLUMNA_pregunta_25e_5="pregunta_25e_5";
public static String COLUMNA_pregunta_25f_5="pregunta_25f_5";
public static String COLUMNA_pregunta_25g_5="pregunta_25g_5";
public static String COLUMNA_pregunta_25h_5="pregunta_25h_5";
public static String COLUMNA_pregunta_25i_5="pregunta_25i_5";
public static String COLUMNA_pregunta_25j_5="pregunta_25j_5";
public static String COLUMNA_pregunta_25k_5="pregunta_25k_5";
public static String COLUMNA_pregunta_26_5="pregunta_26_5";
public static String COLUMNA_pregunta_27_5="pregunta_27_5";
public static String COLUMNA_pregunta_28_5="pregunta_28_5";
public static String COLUMNA_pregunta_29_5="pregunta_29_5";
public static String COLUMNA_pregunta_30_5="pregunta_30_5";
public static String COLUMNA_pregunta_30a_5="pregunta_30a_5";

public static String COLUMNA_abandono="abandono";
public static String COLUMNA_suma="suma";
public static String COLUMNA_status="status";
// FINALIZAN PREGUNTAS
public static String COLUMNA_TIEMPO = "tiempo";
public static String COLUMNA_TIPOCAPTURA = "tipocaptura";
}

private static final String DATABASE_ADULTOS= "create table "
    + TablaAdultos.TABLA_ADULTOS + "("
    + "id integer primary key autoincrement,"
    + TablaAdultos.COLUMNA_CONSECUTIVO_DIARIO + " text not null, "
    + TablaAdultos.COLUMNA_EQUIPO + " text not null, "
    + TablaAdultos.COLUMNA_USUARIO + " text not null, "
    + TablaAdultos.COLUMNA_NOMBRE_ENCUESTA + " text not null, "
    + TablaAdultos.COLUMNA_FECHA + " date not null, "
    + TablaAdultos.COLUMNA_HORA + " text not null, "
    + TablaAdultos.COLUMNA_imei + " text not null, "
    + TablaAdultos.COLUMNA_SECCION + " INTEGER not null, "
    + TablaAdultos.COLUMNA_latitud + " text, "
    + TablaAdultos.COLUMNA_longitud + " text, "
    + TablaAdultos.COLUMNA_latitud2 + " text, "
    + TablaAdultos.COLUMNA_longitud2 + " text, "

    + TablaAdultos.COLUMNA_pregunta_7 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_7a +  " text, "

+ TablaAdultos.COLUMNA_pregunta_8_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_8a_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_9_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_10_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11a_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11b_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11c_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12a_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12b_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12c_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_13_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14a_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14b_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14c_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_15_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_15a_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_16_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_16a_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_16b_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_17_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_17a_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_18_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19a_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19b_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19c_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19d_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19e_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19f_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19g_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19h_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20a_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20b_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20c_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20d_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20e_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_192_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193a_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193b_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193c_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193d_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193e_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193f_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193g_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193h_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_CLAS_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_21_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_22_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_23_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a1_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a2_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a3_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a4_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a5_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25a_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25b_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25c_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25d_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25e_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25f_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25g_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25h_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25i_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25j_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25k_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_26_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_27_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_28_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_29_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_30_1 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_30a_1 +  " text, "

+ TablaAdultos.COLUMNA_pregunta_8_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_8a_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_9_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_10_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11a_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11b_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11c_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12a_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12b_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12c_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_13_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14a_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14b_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14c_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_15_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_15a_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_16_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_16a_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_16b_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_17_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_17a_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_18_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19a_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19b_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19c_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19d_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19e_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19f_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19g_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19h_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20a_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20b_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20c_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20d_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20e_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_192_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193a_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193b_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193c_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193d_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193e_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193f_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193g_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193h_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_CLAS_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_21_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_22_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_23_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a1_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a2_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a3_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a4_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a5_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25a_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25b_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25c_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25d_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25e_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25f_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25g_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25h_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25i_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25j_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25k_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_26_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_27_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_28_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_29_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_30_2 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_30a_2 +  " text, "

+ TablaAdultos.COLUMNA_pregunta_8_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_8a_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_9_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_10_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11a_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11b_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11c_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12a_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12b_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12c_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_13_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14a_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14b_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14c_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_15_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_15a_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_16_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_16a_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_16b_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_17_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_17a_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_18_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19a_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19b_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19c_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19d_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19e_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19f_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19g_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19h_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20a_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20b_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20c_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20d_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20e_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_192_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193a_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193b_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193c_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193d_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193e_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193f_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193g_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193h_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_CLAS_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_21_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_22_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_23_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a1_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a2_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a3_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a4_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a5_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25a_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25b_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25c_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25d_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25e_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25f_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25g_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25h_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25i_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25j_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25k_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_26_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_27_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_28_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_29_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_30_3 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_30a_3 +  " text, "

+ TablaAdultos.COLUMNA_pregunta_8_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_8a_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_9_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_10_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11a_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11b_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11c_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12a_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12b_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12c_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_13_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14a_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14b_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14c_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_15_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_15a_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_16_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_16a_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_16b_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_17_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_17a_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_18_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19a_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19b_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19c_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19d_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19e_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19f_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19g_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19h_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20a_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20b_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20c_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20d_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20e_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_192_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193a_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193b_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193c_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193d_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193e_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193f_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193g_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193h_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_CLAS_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_21_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_22_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_23_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a1_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a2_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a3_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a4_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a5_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25a_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25b_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25c_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25d_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25e_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25f_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25g_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25h_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25i_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25j_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25k_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_26_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_27_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_28_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_29_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_30_4 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_30a_4 +  " text, "

+ TablaAdultos.COLUMNA_pregunta_8_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_8a_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_9_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_10_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11a_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11b_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_11c_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12a_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12b_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_12c_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_13_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14a_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14b_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_14c_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_15_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_15a_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_16_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_16a_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_16b_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_17_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_17a_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_18_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19a_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19b_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19c_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19d_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19e_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19f_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19g_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_19h_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20a_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20b_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20c_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20d_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_20e_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_192_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193a_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193b_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193c_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193d_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193e_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193f_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193g_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_193h_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_CLAS_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_21_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_22_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_23_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a1_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a2_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a3_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a4_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_24a5_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25a_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25b_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25c_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25d_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25e_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25f_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25g_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25h_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25i_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25j_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_25k_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_26_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_27_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_28_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_29_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_30_5 +  " text, "
+ TablaAdultos.COLUMNA_pregunta_30a_5 +  " text, "

+ TablaAdultos.COLUMNA_abandono +  " text, "

	+ TablaAdultos.COLUMNA_suma +  " text, "
	+ TablaAdultos.COLUMNA_status +  " text, "
	+ TablaAdultos.COLUMNA_TIEMPO + " text not null, "
	+ TablaAdultos.COLUMNA_TIPOCAPTURA + " text not null); ";


/////////////////////  TABLA ENCUESTAS  ///////////////////////////////////////////////

public static class TablaMenoresConDiscapacidad{
public static String TABLA_MENORES_CON_DISCAPACIDAD = "encuestas_con_discapacidad";
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


public static String COLUMNA_pregunta_31="pregunta_31";
public static String COLUMNA_pregunta_31a="pregunta_31a";

public static String COLUMNA_pregunta_32_1="pregunta_32_1";
public static String COLUMNA_pregunta_32a_1="pregunta_32a_1";
public static String COLUMNA_pregunta_33_1="pregunta_33_1";
public static String COLUMNA_pregunta_34_1="pregunta_34_1";
public static String COLUMNA_pregunta_34a_1="pregunta_34a_1";
public static String COLUMNA_pregunta_34b_1="pregunta_34b_1";
public static String COLUMNA_pregunta_34c_1="pregunta_34c_1";
public static String COLUMNA_pregunta_35_1="pregunta_35_1";
public static String COLUMNA_pregunta_35a_1="pregunta_35a_1";
public static String COLUMNA_pregunta_36_1="pregunta_36_1";
public static String COLUMNA_pregunta_36a_1="pregunta_36a_1";
public static String COLUMNA_pregunta_36b_1="pregunta_36b_1";
public static String COLUMNA_pregunta_36c_1="pregunta_36c_1";
public static String COLUMNA_pregunta_37_1="pregunta_37_1";
public static String COLUMNA_pregunta_38_1="pregunta_38_1";
public static String COLUMNA_pregunta_38a_1="pregunta_38a_1";
public static String COLUMNA_pregunta_38b_1="pregunta_38b_1";
public static String COLUMNA_pregunta_38c_1="pregunta_38c_1";
public static String COLUMNA_pregunta_38d_1="pregunta_38d_1";
public static String COLUMNA_pregunta_38e_1="pregunta_38e_1";
public static String COLUMNA_pregunta_39_1="pregunta_39_1";
public static String COLUMNA_pregunta_40_1="pregunta_40_1";
public static String COLUMNA_pregunta_41_1="pregunta_41_1";
public static String COLUMNA_pregunta_41a_1="pregunta_41a_1";
public static String COLUMNA_pregunta_42_1="pregunta_42_1";
public static String COLUMNA_pregunta_42a_1="pregunta_42a_1";
public static String COLUMNA_pregunta_43_1="pregunta_43_1";
public static String COLUMNA_pregunta_43a_1="pregunta_43a_1";
public static String COLUMNA_pregunta_44_1="pregunta_44_1";
public static String COLUMNA_pregunta_45_1="pregunta_45_1";
public static String COLUMNA_pregunta_46_1="pregunta_46_1";
public static String COLUMNA_pregunta_47_1="pregunta_47_1";
public static String COLUMNA_pregunta_47a_1="pregunta_47a_1";
public static String COLUMNA_pregunta_47b_1="pregunta_47b_1";
public static String COLUMNA_pregunta_47c_1="pregunta_47c_1";
public static String COLUMNA_pregunta_47d_1="pregunta_47d_1";
public static String COLUMNA_pregunta_47e_1="pregunta_47e_1";
public static String COLUMNA_pregunta_48_1="pregunta_48_1";
public static String COLUMNA_pregunta_48a_1="pregunta_48a_1";
public static String COLUMNA_pregunta_49_1="pregunta_49_1";
public static String COLUMNA_pregunta_49a_1="pregunta_49a_1";
public static String COLUMNA_pregunta_50_1="pregunta_50_1";
public static String COLUMNA_pregunta_50a_1="pregunta_50a_1";
public static String COLUMNA_pregunta_50a1_1="pregunta_50a1_1";
public static String COLUMNA_pregunta_50a2_1="pregunta_50a2_1";
public static String COLUMNA_pregunta_51_1="pregunta_51_1";
public static String COLUMNA_pregunta_51a_1="pregunta_51a_1";
public static String COLUMNA_pregunta_51b_1="pregunta_51b_1";
public static String COLUMNA_pregunta_51c_1="pregunta_51c_1";
public static String COLUMNA_pregunta_51d_1="pregunta_51d_1";
public static String COLUMNA_pregunta_51e_1="pregunta_51e_1";
public static String COLUMNA_pregunta_51f_1="pregunta_51f_1";
public static String COLUMNA_pregunta_51g_1="pregunta_51g_1";



public static String COLUMNA_pregunta_32_2="pregunta_32_2";
public static String COLUMNA_pregunta_32a_2="pregunta_32a_2";
public static String COLUMNA_pregunta_33_2="pregunta_33_2";
public static String COLUMNA_pregunta_34_2="pregunta_34_2";
public static String COLUMNA_pregunta_34a_2="pregunta_34a_2";
public static String COLUMNA_pregunta_34b_2="pregunta_34b_2";
public static String COLUMNA_pregunta_34c_2="pregunta_34c_2";
public static String COLUMNA_pregunta_35_2="pregunta_35_2";
public static String COLUMNA_pregunta_35a_2="pregunta_35a_2";
public static String COLUMNA_pregunta_36_2="pregunta_36_2";
public static String COLUMNA_pregunta_36a_2="pregunta_36a_2";
public static String COLUMNA_pregunta_36b_2="pregunta_36b_2";
public static String COLUMNA_pregunta_36c_2="pregunta_36c_2";
public static String COLUMNA_pregunta_37_2="pregunta_37_2";
public static String COLUMNA_pregunta_38_2="pregunta_38_2";
public static String COLUMNA_pregunta_38a_2="pregunta_38a_2";
public static String COLUMNA_pregunta_38b_2="pregunta_38b_2";
public static String COLUMNA_pregunta_38c_2="pregunta_38c_2";
public static String COLUMNA_pregunta_38d_2="pregunta_38d_2";
public static String COLUMNA_pregunta_38e_2="pregunta_38e_2";
public static String COLUMNA_pregunta_39_2="pregunta_39_2";
public static String COLUMNA_pregunta_40_2="pregunta_40_2";
public static String COLUMNA_pregunta_41_2="pregunta_41_2";
public static String COLUMNA_pregunta_41a_2="pregunta_41a_2";
public static String COLUMNA_pregunta_42_2="pregunta_42_2";
public static String COLUMNA_pregunta_42a_2="pregunta_42a_2";
public static String COLUMNA_pregunta_43_2="pregunta_43_2";
public static String COLUMNA_pregunta_43a_2="pregunta_43a_2";
public static String COLUMNA_pregunta_44_2="pregunta_44_2";
public static String COLUMNA_pregunta_45_2="pregunta_45_2";
public static String COLUMNA_pregunta_46_2="pregunta_46_2";
public static String COLUMNA_pregunta_47_2="pregunta_47_2";
public static String COLUMNA_pregunta_47a_2="pregunta_47a_2";
public static String COLUMNA_pregunta_47b_2="pregunta_47b_2";
public static String COLUMNA_pregunta_47c_2="pregunta_47c_2";
public static String COLUMNA_pregunta_47d_2="pregunta_47d_2";
public static String COLUMNA_pregunta_47e_2="pregunta_47e_2";
public static String COLUMNA_pregunta_48_2="pregunta_48_2";
public static String COLUMNA_pregunta_48a_2="pregunta_48a_2";
public static String COLUMNA_pregunta_49_2="pregunta_49_2";
public static String COLUMNA_pregunta_49a_2="pregunta_49a_2";
public static String COLUMNA_pregunta_50_2="pregunta_50_2";
public static String COLUMNA_pregunta_50a_2="pregunta_50a_2";
public static String COLUMNA_pregunta_50a1_2="pregunta_50a1_2";
public static String COLUMNA_pregunta_50a2_2="pregunta_50a2_2";
public static String COLUMNA_pregunta_51_2="pregunta_51_2";
public static String COLUMNA_pregunta_51a_2="pregunta_51a_2";
public static String COLUMNA_pregunta_51b_2="pregunta_51b_2";
public static String COLUMNA_pregunta_51c_2="pregunta_51c_2";
public static String COLUMNA_pregunta_51d_2="pregunta_51d_2";
public static String COLUMNA_pregunta_51e_2="pregunta_51e_2";
public static String COLUMNA_pregunta_51f_2="pregunta_51f_2";
public static String COLUMNA_pregunta_51g_2="pregunta_51g_2";



public static String COLUMNA_pregunta_32_3="pregunta_32_3";
public static String COLUMNA_pregunta_32a_3="pregunta_32a_3";
public static String COLUMNA_pregunta_33_3="pregunta_33_3";
public static String COLUMNA_pregunta_34_3="pregunta_34_3";
public static String COLUMNA_pregunta_34a_3="pregunta_34a_3";
public static String COLUMNA_pregunta_34b_3="pregunta_34b_3";
public static String COLUMNA_pregunta_34c_3="pregunta_34c_3";
public static String COLUMNA_pregunta_35_3="pregunta_35_3";
public static String COLUMNA_pregunta_35a_3="pregunta_35a_3";
public static String COLUMNA_pregunta_36_3="pregunta_36_3";
public static String COLUMNA_pregunta_36a_3="pregunta_36a_3";
public static String COLUMNA_pregunta_36b_3="pregunta_36b_3";
public static String COLUMNA_pregunta_36c_3="pregunta_36c_3";
public static String COLUMNA_pregunta_37_3="pregunta_37_3";
public static String COLUMNA_pregunta_38_3="pregunta_38_3";
public static String COLUMNA_pregunta_38a_3="pregunta_38a_3";
public static String COLUMNA_pregunta_38b_3="pregunta_38b_3";
public static String COLUMNA_pregunta_38c_3="pregunta_38c_3";
public static String COLUMNA_pregunta_38d_3="pregunta_38d_3";
public static String COLUMNA_pregunta_38e_3="pregunta_38e_3";
public static String COLUMNA_pregunta_39_3="pregunta_39_3";
public static String COLUMNA_pregunta_40_3="pregunta_40_3";
public static String COLUMNA_pregunta_41_3="pregunta_41_3";
public static String COLUMNA_pregunta_41a_3="pregunta_41a_3";
public static String COLUMNA_pregunta_42_3="pregunta_42_3";
public static String COLUMNA_pregunta_42a_3="pregunta_42a_3";
public static String COLUMNA_pregunta_43_3="pregunta_43_3";
public static String COLUMNA_pregunta_43a_3="pregunta_43a_3";
public static String COLUMNA_pregunta_44_3="pregunta_44_3";
public static String COLUMNA_pregunta_45_3="pregunta_45_3";
public static String COLUMNA_pregunta_46_3="pregunta_46_3";
public static String COLUMNA_pregunta_47_3="pregunta_47_3";
public static String COLUMNA_pregunta_47a_3="pregunta_47a_3";
public static String COLUMNA_pregunta_47b_3="pregunta_47b_3";
public static String COLUMNA_pregunta_47c_3="pregunta_47c_3";
public static String COLUMNA_pregunta_47d_3="pregunta_47d_3";
public static String COLUMNA_pregunta_47e_3="pregunta_47e_3";
public static String COLUMNA_pregunta_48_3="pregunta_48_3";
public static String COLUMNA_pregunta_48a_3="pregunta_48a_3";
public static String COLUMNA_pregunta_49_3="pregunta_49_3";
public static String COLUMNA_pregunta_49a_3="pregunta_49a_3";
public static String COLUMNA_pregunta_50_3="pregunta_50_3";
public static String COLUMNA_pregunta_50a_3="pregunta_50a_3";
public static String COLUMNA_pregunta_50a1_3="pregunta_50a1_3";
public static String COLUMNA_pregunta_50a2_3="pregunta_50a2_3";
public static String COLUMNA_pregunta_51_3="pregunta_51_3";
public static String COLUMNA_pregunta_51a_3="pregunta_51a_3";
public static String COLUMNA_pregunta_51b_3="pregunta_51b_3";
public static String COLUMNA_pregunta_51c_3="pregunta_51c_3";
public static String COLUMNA_pregunta_51d_3="pregunta_51d_3";
public static String COLUMNA_pregunta_51e_3="pregunta_51e_3";
public static String COLUMNA_pregunta_51f_3="pregunta_51f_3";
public static String COLUMNA_pregunta_51g_3="pregunta_51g_3";



public static String COLUMNA_pregunta_32_4="pregunta_32_4";
public static String COLUMNA_pregunta_32a_4="pregunta_32a_4";
public static String COLUMNA_pregunta_33_4="pregunta_33_4";
public static String COLUMNA_pregunta_34_4="pregunta_34_4";
public static String COLUMNA_pregunta_34a_4="pregunta_34a_4";
public static String COLUMNA_pregunta_34b_4="pregunta_34b_4";
public static String COLUMNA_pregunta_34c_4="pregunta_34c_4";
public static String COLUMNA_pregunta_35_4="pregunta_35_4";
public static String COLUMNA_pregunta_35a_4="pregunta_35a_4";
public static String COLUMNA_pregunta_36_4="pregunta_36_4";
public static String COLUMNA_pregunta_36a_4="pregunta_36a_4";
public static String COLUMNA_pregunta_36b_4="pregunta_36b_4";
public static String COLUMNA_pregunta_36c_4="pregunta_36c_4";
public static String COLUMNA_pregunta_37_4="pregunta_37_4";
public static String COLUMNA_pregunta_38_4="pregunta_38_4";
public static String COLUMNA_pregunta_38a_4="pregunta_38a_4";
public static String COLUMNA_pregunta_38b_4="pregunta_38b_4";
public static String COLUMNA_pregunta_38c_4="pregunta_38c_4";
public static String COLUMNA_pregunta_38d_4="pregunta_38d_4";
public static String COLUMNA_pregunta_38e_4="pregunta_38e_4";
public static String COLUMNA_pregunta_39_4="pregunta_39_4";
public static String COLUMNA_pregunta_40_4="pregunta_40_4";
public static String COLUMNA_pregunta_41_4="pregunta_41_4";
public static String COLUMNA_pregunta_41a_4="pregunta_41a_4";
public static String COLUMNA_pregunta_42_4="pregunta_42_4";
public static String COLUMNA_pregunta_42a_4="pregunta_42a_4";
public static String COLUMNA_pregunta_43_4="pregunta_43_4";
public static String COLUMNA_pregunta_43a_4="pregunta_43a_4";
public static String COLUMNA_pregunta_44_4="pregunta_44_4";
public static String COLUMNA_pregunta_45_4="pregunta_45_4";
public static String COLUMNA_pregunta_46_4="pregunta_46_4";
public static String COLUMNA_pregunta_47_4="pregunta_47_4";
public static String COLUMNA_pregunta_47a_4="pregunta_47a_4";
public static String COLUMNA_pregunta_47b_4="pregunta_47b_4";
public static String COLUMNA_pregunta_47c_4="pregunta_47c_4";
public static String COLUMNA_pregunta_47d_4="pregunta_47d_4";
public static String COLUMNA_pregunta_47e_4="pregunta_47e_4";
public static String COLUMNA_pregunta_48_4="pregunta_48_4";
public static String COLUMNA_pregunta_48a_4="pregunta_48a_4";
public static String COLUMNA_pregunta_49_4="pregunta_49_4";
public static String COLUMNA_pregunta_49a_4="pregunta_49a_4";
public static String COLUMNA_pregunta_50_4="pregunta_50_4";
public static String COLUMNA_pregunta_50a_4="pregunta_50a_4";
public static String COLUMNA_pregunta_50a1_4="pregunta_50a1_4";
public static String COLUMNA_pregunta_50a2_4="pregunta_50a2_4";
public static String COLUMNA_pregunta_51_4="pregunta_51_4";
public static String COLUMNA_pregunta_51a_4="pregunta_51a_4";
public static String COLUMNA_pregunta_51b_4="pregunta_51b_4";
public static String COLUMNA_pregunta_51c_4="pregunta_51c_4";
public static String COLUMNA_pregunta_51d_4="pregunta_51d_4";
public static String COLUMNA_pregunta_51e_4="pregunta_51e_4";
public static String COLUMNA_pregunta_51f_4="pregunta_51f_4";
public static String COLUMNA_pregunta_51g_4="pregunta_51g_4";



public static String COLUMNA_pregunta_32_5="pregunta_32_5";
public static String COLUMNA_pregunta_32a_5="pregunta_32a_5";
public static String COLUMNA_pregunta_33_5="pregunta_33_5";
public static String COLUMNA_pregunta_34_5="pregunta_34_5";
public static String COLUMNA_pregunta_34a_5="pregunta_34a_5";
public static String COLUMNA_pregunta_34b_5="pregunta_34b_5";
public static String COLUMNA_pregunta_34c_5="pregunta_34c_5";
public static String COLUMNA_pregunta_35_5="pregunta_35_5";
public static String COLUMNA_pregunta_35a_5="pregunta_35a_5";
public static String COLUMNA_pregunta_36_5="pregunta_36_5";
public static String COLUMNA_pregunta_36a_5="pregunta_36a_5";
public static String COLUMNA_pregunta_36b_5="pregunta_36b_5";
public static String COLUMNA_pregunta_36c_5="pregunta_36c_5";
public static String COLUMNA_pregunta_37_5="pregunta_37_5";
public static String COLUMNA_pregunta_38_5="pregunta_38_5";
public static String COLUMNA_pregunta_38a_5="pregunta_38a_5";
public static String COLUMNA_pregunta_38b_5="pregunta_38b_5";
public static String COLUMNA_pregunta_38c_5="pregunta_38c_5";
public static String COLUMNA_pregunta_38d_5="pregunta_38d_5";
public static String COLUMNA_pregunta_38e_5="pregunta_38e_5";
public static String COLUMNA_pregunta_39_5="pregunta_39_5";
public static String COLUMNA_pregunta_40_5="pregunta_40_5";
public static String COLUMNA_pregunta_41_5="pregunta_41_5";
public static String COLUMNA_pregunta_41a_5="pregunta_41a_5";
public static String COLUMNA_pregunta_42_5="pregunta_42_5";
public static String COLUMNA_pregunta_42a_5="pregunta_42a_5";
public static String COLUMNA_pregunta_43_5="pregunta_43_5";
public static String COLUMNA_pregunta_43a_5="pregunta_43a_5";
public static String COLUMNA_pregunta_44_5="pregunta_44_5";
public static String COLUMNA_pregunta_45_5="pregunta_45_5";
public static String COLUMNA_pregunta_46_5="pregunta_46_5";
public static String COLUMNA_pregunta_47_5="pregunta_47_5";
public static String COLUMNA_pregunta_47a_5="pregunta_47a_5";
public static String COLUMNA_pregunta_47b_5="pregunta_47b_5";
public static String COLUMNA_pregunta_47c_5="pregunta_47c_5";
public static String COLUMNA_pregunta_47d_5="pregunta_47d_5";
public static String COLUMNA_pregunta_47e_5="pregunta_47e_5";
public static String COLUMNA_pregunta_48_5="pregunta_48_5";
public static String COLUMNA_pregunta_48a_5="pregunta_48a_5";
public static String COLUMNA_pregunta_49_5="pregunta_49_5";
public static String COLUMNA_pregunta_49a_5="pregunta_49a_5";
public static String COLUMNA_pregunta_50_5="pregunta_50_5";
public static String COLUMNA_pregunta_50a_5="pregunta_50a_5";
public static String COLUMNA_pregunta_50a1_5="pregunta_50a1_5";
public static String COLUMNA_pregunta_50a2_5="pregunta_50a2_5";
public static String COLUMNA_pregunta_51_5="pregunta_51_5";
public static String COLUMNA_pregunta_51a_5="pregunta_51a_5";
public static String COLUMNA_pregunta_51b_5="pregunta_51b_5";
public static String COLUMNA_pregunta_51c_5="pregunta_51c_5";
public static String COLUMNA_pregunta_51d_5="pregunta_51d_5";
public static String COLUMNA_pregunta_51e_5="pregunta_51e_5";
public static String COLUMNA_pregunta_51f_5="pregunta_51f_5";
public static String COLUMNA_pregunta_51g_5="pregunta_51g_5";


public static String COLUMNA_abandono="abandono";
public static String COLUMNA_suma="suma";
public static String COLUMNA_status="status";
// FINALIZAN PREGUNTAS
public static String COLUMNA_TIEMPO = "tiempo";
public static String COLUMNA_TIPOCAPTURA = "tipocaptura";
}

private static final String DATABASE_MENORES_CON= "create table "
+ TablaMenoresConDiscapacidad.TABLA_MENORES_CON_DISCAPACIDAD + "("
+ "id integer primary key autoincrement,"
+ TablaMenoresConDiscapacidad.COLUMNA_CONSECUTIVO_DIARIO + " text not null, "
+ TablaMenoresConDiscapacidad.COLUMNA_EQUIPO + " text not null, "
+ TablaMenoresConDiscapacidad.COLUMNA_USUARIO + " text not null, "
+ TablaMenoresConDiscapacidad.COLUMNA_NOMBRE_ENCUESTA + " text not null, "
+ TablaMenoresConDiscapacidad.COLUMNA_FECHA + " date not null, "
+ TablaMenoresConDiscapacidad.COLUMNA_HORA + " text not null, "
+ TablaMenoresConDiscapacidad.COLUMNA_imei + " text not null, "
+ TablaMenoresConDiscapacidad.COLUMNA_SECCION + " INTEGER not null, "
+ TablaMenoresConDiscapacidad.COLUMNA_latitud + " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_longitud + " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_latitud2 + " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_longitud2 + " text, "


+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_31 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_31a +  " text, "

+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_32_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_32a_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_33_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34a_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34b_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34c_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_35_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_35a_1 +  " text, "

+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36a_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36b_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36c_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_37_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38a_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38b_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38c_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38d_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38e_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_39_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_40_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_41_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_41a_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_42_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_42a_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_43_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_43a_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_44_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_45_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_46_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47a_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47b_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47c_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47d_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47e_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_48_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_48a_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_49_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_49a_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50a_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50a1_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50a2_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51a_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51b_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51c_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51d_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51e_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51f_1 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51g_1 +  " text, "


+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_32_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_32a_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_33_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34a_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34b_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34c_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_35_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_35a_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36a_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36b_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36c_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_37_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38a_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38b_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38c_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38d_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38e_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_39_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_40_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_41_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_41a_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_42_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_42a_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_43_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_43a_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_44_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_45_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_46_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47a_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47b_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47c_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47d_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47e_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_48_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_48a_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_49_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_49a_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50a_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50a1_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50a2_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51a_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51b_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51c_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51d_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51e_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51f_2 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51g_2 +  " text, "

+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_32_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_32a_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_33_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34a_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34b_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34c_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_35_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_35a_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36a_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36b_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36c_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_37_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38a_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38b_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38c_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38d_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38e_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_39_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_40_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_41_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_41a_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_42_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_42a_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_43_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_43a_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_44_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_45_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_46_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47a_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47b_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47c_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47d_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47e_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_48_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_48a_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_49_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_49a_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50a_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50a1_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50a2_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51a_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51b_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51c_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51d_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51e_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51f_3 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51g_3 +  " text, "


+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_32_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_32a_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_33_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34a_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34b_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34c_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_35_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_35a_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36a_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36b_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36c_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_37_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38a_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38b_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38c_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38d_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38e_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_39_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_40_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_41_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_41a_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_42_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_42a_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_43_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_43a_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_44_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_45_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_46_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47a_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47b_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47c_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47d_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47e_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_48_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_48a_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_49_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_49a_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50a_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50a1_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50a2_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51a_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51b_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51c_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51d_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51e_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51f_4 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51g_4 +  " text, "


+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_32_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_32a_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_33_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34a_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34b_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_34c_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_35_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_35a_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36a_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36b_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_36c_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_37_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38a_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38b_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38c_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38d_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_38e_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_39_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_40_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_41_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_41a_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_42_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_42a_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_43_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_43a_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_44_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_45_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_46_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47a_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47b_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47c_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47d_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_47e_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_48_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_48a_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_49_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_49a_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50a_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50a1_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_50a2_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51a_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51b_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51c_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51d_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51e_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51f_5 +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_pregunta_51g_5 +  " text, "





+ TablaMenoresConDiscapacidad.COLUMNA_abandono +  " text, "

+ TablaMenoresConDiscapacidad.COLUMNA_suma +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_status +  " text, "
+ TablaMenoresConDiscapacidad.COLUMNA_TIEMPO + " text not null, "
+ TablaMenoresConDiscapacidad.COLUMNA_TIPOCAPTURA + " text not null); ";


/////////////////////  TABLA ENCUESTAS  ///////////////////////////////////////////////

public static class TablaMenoresSinDiscapacidad{
public static String TABLA_MENORES_SIN_DISCAPACIDAD = "encuestas_sin_discapacidad";
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

public static String COLUMNA_pregunta_52_1="pregunta_52_1";
public static String COLUMNA_pregunta_52a_1="pregunta_52a_1";

public static String COLUMNA_pregunta_53_1="pregunta_53_1";
public static String COLUMNA_pregunta_53a_1="pregunta_53a_1";
public static String COLUMNA_pregunta_54_1="pregunta_54_1";
public static String COLUMNA_pregunta_55_1="pregunta_55_1";
public static String COLUMNA_pregunta_55a_1="pregunta_55a_1";
public static String COLUMNA_pregunta_55b_1="pregunta_55b_1";
public static String COLUMNA_pregunta_55c_1="pregunta_55c_1";
public static String COLUMNA_pregunta_56_1="pregunta_56_1";
public static String COLUMNA_pregunta_56a_1="pregunta_56a_1";
public static String COLUMNA_pregunta_57_1="pregunta_57_1";
public static String COLUMNA_pregunta_57a_1="pregunta_57a_1";
public static String COLUMNA_pregunta_57b_1="pregunta_57b_1";
public static String COLUMNA_pregunta_57c_1="pregunta_57c_1";
public static String COLUMNA_pregunta_58_1="pregunta_58_1";
public static String COLUMNA_pregunta_59_1="pregunta_59_1";
public static String COLUMNA_pregunta_59a_1="pregunta_59a_1";
public static String COLUMNA_pregunta_59b_1="pregunta_59b_1";
public static String COLUMNA_pregunta_59c_1="pregunta_59c_1";
public static String COLUMNA_pregunta_59d_1="pregunta_59d_1";
public static String COLUMNA_pregunta_59e_1="pregunta_59e_1";
public static String COLUMNA_pregunta_59f_1="pregunta_59f_1";
public static String COLUMNA_pregunta_59g_1="pregunta_59g_1";
public static String COLUMNA_pregunta_59h_1="pregunta_59h_1";
public static String COLUMNA_pregunta_59i_1="pregunta_59i_1";
public static String COLUMNA_pregunta_59j_1="pregunta_59j_1";
public static String COLUMNA_pregunta_60_1="pregunta_60_1";
public static String COLUMNA_pregunta_60a_1="pregunta_60a_1";
public static String COLUMNA_pregunta_61_1="pregunta_61_1";
public static String COLUMNA_pregunta_61a_1="pregunta_61a_1";
public static String COLUMNA_pregunta_62_1="pregunta_62_1";
public static String COLUMNA_pregunta_62a_1="pregunta_62a_1";
public static String COLUMNA_pregunta_63_1="pregunta_63_1";
public static String COLUMNA_pregunta_64_1="pregunta_64_1";
public static String COLUMNA_pregunta_65_1="pregunta_65_1";
public static String COLUMNA_pregunta_66_1="pregunta_66_1";
public static String COLUMNA_pregunta_66a_1="pregunta_66a_1";
public static String COLUMNA_pregunta_66b_1="pregunta_66b_1";
public static String COLUMNA_pregunta_66c_1="pregunta_66c_1";
public static String COLUMNA_pregunta_66d_1="pregunta_66d_1";
public static String COLUMNA_pregunta_66e_1="pregunta_66e_1";
public static String COLUMNA_pregunta_67_1="pregunta_67_1";
public static String COLUMNA_pregunta_67a_1="pregunta_67a_1";
public static String COLUMNA_pregunta_68_1="pregunta_68_1";
public static String COLUMNA_pregunta_68a_1="pregunta_68a_1";
public static String COLUMNA_pregunta_69_1="pregunta_69_1";
public static String COLUMNA_pregunta_69a_1="pregunta_69a_1";
public static String COLUMNA_pregunta_69a1_1="pregunta_69a1_1";
public static String COLUMNA_pregunta_69a2_1="pregunta_69a2_1";
public static String COLUMNA_pregunta_70_1="pregunta_70_1";
public static String COLUMNA_pregunta_70a_1="pregunta_70a_1";
public static String COLUMNA_pregunta_70b_1="pregunta_70b_1";
public static String COLUMNA_pregunta_70c_1="pregunta_70c_1";
public static String COLUMNA_pregunta_70d_1="pregunta_70d_1";
public static String COLUMNA_pregunta_70e_1="pregunta_70e_1";
public static String COLUMNA_pregunta_70f_1="pregunta_70f_1";
public static String COLUMNA_pregunta_71_1="pregunta_71_1";
public static String COLUMNA_pregunta_CLAS2_1="pregunta_CLAS2_1";


public static String COLUMNA_pregunta_53_2="pregunta_53_2";
public static String COLUMNA_pregunta_53a_2="pregunta_53a_2";
public static String COLUMNA_pregunta_54_2="pregunta_54_2";
public static String COLUMNA_pregunta_55_2="pregunta_55_2";
public static String COLUMNA_pregunta_55a_2="pregunta_55a_2";
public static String COLUMNA_pregunta_55b_2="pregunta_55b_2";
public static String COLUMNA_pregunta_55c_2="pregunta_55c_2";
public static String COLUMNA_pregunta_56_2="pregunta_56_2";
public static String COLUMNA_pregunta_56a_2="pregunta_56a_2";
public static String COLUMNA_pregunta_57_2="pregunta_57_2";
public static String COLUMNA_pregunta_57a_2="pregunta_57a_2";
public static String COLUMNA_pregunta_57b_2="pregunta_57b_2";
public static String COLUMNA_pregunta_57c_2="pregunta_57c_2";
public static String COLUMNA_pregunta_58_2="pregunta_58_2";
public static String COLUMNA_pregunta_59_2="pregunta_59_2";
public static String COLUMNA_pregunta_59a_2="pregunta_59a_2";
public static String COLUMNA_pregunta_59b_2="pregunta_59b_2";
public static String COLUMNA_pregunta_59c_2="pregunta_59c_2";
public static String COLUMNA_pregunta_59d_2="pregunta_59d_2";
public static String COLUMNA_pregunta_59e_2="pregunta_59e_2";
public static String COLUMNA_pregunta_59f_2="pregunta_59f_2";
public static String COLUMNA_pregunta_59g_2="pregunta_59g_2";
public static String COLUMNA_pregunta_59h_2="pregunta_59h_2";
public static String COLUMNA_pregunta_59i_2="pregunta_59i_2";
public static String COLUMNA_pregunta_59j_2="pregunta_59j_2";
public static String COLUMNA_pregunta_60_2="pregunta_60_2";
public static String COLUMNA_pregunta_60a_2="pregunta_60a_2";
public static String COLUMNA_pregunta_61_2="pregunta_61_2";
public static String COLUMNA_pregunta_61a_2="pregunta_61a_2";
public static String COLUMNA_pregunta_62_2="pregunta_62_2";
public static String COLUMNA_pregunta_62a_2="pregunta_62a_2";
public static String COLUMNA_pregunta_63_2="pregunta_63_2";
public static String COLUMNA_pregunta_64_2="pregunta_64_2";
public static String COLUMNA_pregunta_65_2="pregunta_65_2";
public static String COLUMNA_pregunta_66_2="pregunta_66_2";
public static String COLUMNA_pregunta_66a_2="pregunta_66a_2";
public static String COLUMNA_pregunta_66b_2="pregunta_66b_2";
public static String COLUMNA_pregunta_66c_2="pregunta_66c_2";
public static String COLUMNA_pregunta_66d_2="pregunta_66d_2";
public static String COLUMNA_pregunta_66e_2="pregunta_66e_2";
public static String COLUMNA_pregunta_67_2="pregunta_67_2";
public static String COLUMNA_pregunta_67a_2="pregunta_67a_2";
public static String COLUMNA_pregunta_68_2="pregunta_68_2";
public static String COLUMNA_pregunta_68a_2="pregunta_68a_2";
public static String COLUMNA_pregunta_69_2="pregunta_69_2";
public static String COLUMNA_pregunta_69a_2="pregunta_69a_2";
public static String COLUMNA_pregunta_69a1_2="pregunta_69a1_2";
public static String COLUMNA_pregunta_69a2_2="pregunta_69a2_2";
public static String COLUMNA_pregunta_70_2="pregunta_70_2";
public static String COLUMNA_pregunta_70a_2="pregunta_70a_2";
public static String COLUMNA_pregunta_70b_2="pregunta_70b_2";
public static String COLUMNA_pregunta_70c_2="pregunta_70c_2";
public static String COLUMNA_pregunta_70d_2="pregunta_70d_2";
public static String COLUMNA_pregunta_70e_2="pregunta_70e_2";
public static String COLUMNA_pregunta_70f_2="pregunta_70f_2";
public static String COLUMNA_pregunta_71_2="pregunta_71_2";
public static String COLUMNA_pregunta_CLAS2_2="pregunta_CLAS2_2";


public static String COLUMNA_pregunta_53_3="pregunta_53_3";
public static String COLUMNA_pregunta_53a_3="pregunta_53a_3";
public static String COLUMNA_pregunta_54_3="pregunta_54_3";
public static String COLUMNA_pregunta_55_3="pregunta_55_3";
public static String COLUMNA_pregunta_55a_3="pregunta_55a_3";
public static String COLUMNA_pregunta_55b_3="pregunta_55b_3";
public static String COLUMNA_pregunta_55c_3="pregunta_55c_3";
public static String COLUMNA_pregunta_56_3="pregunta_56_3";
public static String COLUMNA_pregunta_56a_3="pregunta_56a_3";
public static String COLUMNA_pregunta_57_3="pregunta_57_3";
public static String COLUMNA_pregunta_57a_3="pregunta_57a_3";
public static String COLUMNA_pregunta_57b_3="pregunta_57b_3";
public static String COLUMNA_pregunta_57c_3="pregunta_57c_3";
public static String COLUMNA_pregunta_58_3="pregunta_58_3";
public static String COLUMNA_pregunta_59_3="pregunta_59_3";
public static String COLUMNA_pregunta_59a_3="pregunta_59a_3";
public static String COLUMNA_pregunta_59b_3="pregunta_59b_3";
public static String COLUMNA_pregunta_59c_3="pregunta_59c_3";
public static String COLUMNA_pregunta_59d_3="pregunta_59d_3";
public static String COLUMNA_pregunta_59e_3="pregunta_59e_3";
public static String COLUMNA_pregunta_59f_3="pregunta_59f_3";
public static String COLUMNA_pregunta_59g_3="pregunta_59g_3";
public static String COLUMNA_pregunta_59h_3="pregunta_59h_3";
public static String COLUMNA_pregunta_59i_3="pregunta_59i_3";
public static String COLUMNA_pregunta_59j_3="pregunta_59j_3";
public static String COLUMNA_pregunta_60_3="pregunta_60_3";
public static String COLUMNA_pregunta_60a_3="pregunta_60a_3";
public static String COLUMNA_pregunta_61_3="pregunta_61_3";
public static String COLUMNA_pregunta_61a_3="pregunta_61a_3";
public static String COLUMNA_pregunta_62_3="pregunta_62_3";
public static String COLUMNA_pregunta_62a_3="pregunta_62a_3";
public static String COLUMNA_pregunta_63_3="pregunta_63_3";
public static String COLUMNA_pregunta_64_3="pregunta_64_3";
public static String COLUMNA_pregunta_65_3="pregunta_65_3";
public static String COLUMNA_pregunta_66_3="pregunta_66_3";
public static String COLUMNA_pregunta_66a_3="pregunta_66a_3";
public static String COLUMNA_pregunta_66b_3="pregunta_66b_3";
public static String COLUMNA_pregunta_66c_3="pregunta_66c_3";
public static String COLUMNA_pregunta_66d_3="pregunta_66d_3";
public static String COLUMNA_pregunta_66e_3="pregunta_66e_3";
public static String COLUMNA_pregunta_67_3="pregunta_67_3";
public static String COLUMNA_pregunta_67a_3="pregunta_67a_3";
public static String COLUMNA_pregunta_68_3="pregunta_68_3";
public static String COLUMNA_pregunta_68a_3="pregunta_68a_3";
public static String COLUMNA_pregunta_69_3="pregunta_69_3";
public static String COLUMNA_pregunta_69a_3="pregunta_69a_3";
public static String COLUMNA_pregunta_69a1_3="pregunta_69a1_3";
public static String COLUMNA_pregunta_69a2_3="pregunta_69a2_3";
public static String COLUMNA_pregunta_70_3="pregunta_70_3";
public static String COLUMNA_pregunta_70a_3="pregunta_70a_3";
public static String COLUMNA_pregunta_70b_3="pregunta_70b_3";
public static String COLUMNA_pregunta_70c_3="pregunta_70c_3";
public static String COLUMNA_pregunta_70d_3="pregunta_70d_3";
public static String COLUMNA_pregunta_70e_3="pregunta_70e_3";
public static String COLUMNA_pregunta_70f_3="pregunta_70f_3";
public static String COLUMNA_pregunta_71_3="pregunta_71_3";
public static String COLUMNA_pregunta_CLAS2_3="pregunta_CLAS2_3";

public static String COLUMNA_pregunta_53_4="pregunta_53_4";
public static String COLUMNA_pregunta_53a_4="pregunta_53a_4";
public static String COLUMNA_pregunta_54_4="pregunta_54_4";
public static String COLUMNA_pregunta_55_4="pregunta_55_4";
public static String COLUMNA_pregunta_55a_4="pregunta_55a_4";
public static String COLUMNA_pregunta_55b_4="pregunta_55b_4";
public static String COLUMNA_pregunta_55c_4="pregunta_55c_4";
public static String COLUMNA_pregunta_56_4="pregunta_56_4";
public static String COLUMNA_pregunta_56a_4="pregunta_56a_4";
public static String COLUMNA_pregunta_57_4="pregunta_57_4";
public static String COLUMNA_pregunta_57a_4="pregunta_57a_4";
public static String COLUMNA_pregunta_57b_4="pregunta_57b_4";
public static String COLUMNA_pregunta_57c_4="pregunta_57c_4";
public static String COLUMNA_pregunta_58_4="pregunta_58_4";
public static String COLUMNA_pregunta_59_4="pregunta_59_4";
public static String COLUMNA_pregunta_59a_4="pregunta_59a_4";
public static String COLUMNA_pregunta_59b_4="pregunta_59b_4";
public static String COLUMNA_pregunta_59c_4="pregunta_59c_4";
public static String COLUMNA_pregunta_59d_4="pregunta_59d_4";
public static String COLUMNA_pregunta_59e_4="pregunta_59e_4";
public static String COLUMNA_pregunta_59f_4="pregunta_59f_4";
public static String COLUMNA_pregunta_59g_4="pregunta_59g_4";
public static String COLUMNA_pregunta_59h_4="pregunta_59h_4";
public static String COLUMNA_pregunta_59i_4="pregunta_59i_4";
public static String COLUMNA_pregunta_59j_4="pregunta_59j_4";
public static String COLUMNA_pregunta_60_4="pregunta_60_4";
public static String COLUMNA_pregunta_60a_4="pregunta_60a_4";
public static String COLUMNA_pregunta_61_4="pregunta_61_4";
public static String COLUMNA_pregunta_61a_4="pregunta_61a_4";
public static String COLUMNA_pregunta_62_4="pregunta_62_4";
public static String COLUMNA_pregunta_62a_4="pregunta_62a_4";
public static String COLUMNA_pregunta_63_4="pregunta_63_4";
public static String COLUMNA_pregunta_64_4="pregunta_64_4";
public static String COLUMNA_pregunta_65_4="pregunta_65_4";
public static String COLUMNA_pregunta_66_4="pregunta_66_4";
public static String COLUMNA_pregunta_66a_4="pregunta_66a_4";
public static String COLUMNA_pregunta_66b_4="pregunta_66b_4";
public static String COLUMNA_pregunta_66c_4="pregunta_66c_4";
public static String COLUMNA_pregunta_66d_4="pregunta_66d_4";
public static String COLUMNA_pregunta_66e_4="pregunta_66e_4";
public static String COLUMNA_pregunta_67_4="pregunta_67_4";
public static String COLUMNA_pregunta_67a_4="pregunta_67a_4";
public static String COLUMNA_pregunta_68_4="pregunta_68_4";
public static String COLUMNA_pregunta_68a_4="pregunta_68a_4";
public static String COLUMNA_pregunta_69_4="pregunta_69_4";
public static String COLUMNA_pregunta_69a_4="pregunta_69a_4";
public static String COLUMNA_pregunta_69a1_4="pregunta_69a1_4";
public static String COLUMNA_pregunta_69a2_4="pregunta_69a2_4";
public static String COLUMNA_pregunta_70_4="pregunta_70_4";
public static String COLUMNA_pregunta_70a_4="pregunta_70a_4";
public static String COLUMNA_pregunta_70b_4="pregunta_70b_4";
public static String COLUMNA_pregunta_70c_4="pregunta_70c_4";
public static String COLUMNA_pregunta_70d_4="pregunta_70d_4";
public static String COLUMNA_pregunta_70e_4="pregunta_70e_4";
public static String COLUMNA_pregunta_70f_4="pregunta_70f_4";
public static String COLUMNA_pregunta_71_4="pregunta_71_4";
public static String COLUMNA_pregunta_CLAS2_4="pregunta_CLAS2_4";

public static String COLUMNA_pregunta_53_5="pregunta_53_5";
public static String COLUMNA_pregunta_53a_5="pregunta_53a_5";
public static String COLUMNA_pregunta_54_5="pregunta_54_5";
public static String COLUMNA_pregunta_55_5="pregunta_55_5";
public static String COLUMNA_pregunta_55a_5="pregunta_55a_5";
public static String COLUMNA_pregunta_55b_5="pregunta_55b_5";
public static String COLUMNA_pregunta_55c_5="pregunta_55c_5";
public static String COLUMNA_pregunta_56_5="pregunta_56_5";
public static String COLUMNA_pregunta_56a_5="pregunta_56a_5";
public static String COLUMNA_pregunta_57_5="pregunta_57_5";
public static String COLUMNA_pregunta_57a_5="pregunta_57a_5";
public static String COLUMNA_pregunta_57b_5="pregunta_57b_5";
public static String COLUMNA_pregunta_57c_5="pregunta_57c_5";
public static String COLUMNA_pregunta_58_5="pregunta_58_5";
public static String COLUMNA_pregunta_59_5="pregunta_59_5";
public static String COLUMNA_pregunta_59a_5="pregunta_59a_5";
public static String COLUMNA_pregunta_59b_5="pregunta_59b_5";
public static String COLUMNA_pregunta_59c_5="pregunta_59c_5";
public static String COLUMNA_pregunta_59d_5="pregunta_59d_5";
public static String COLUMNA_pregunta_59e_5="pregunta_59e_5";
public static String COLUMNA_pregunta_59f_5="pregunta_59f_5";
public static String COLUMNA_pregunta_59g_5="pregunta_59g_5";
public static String COLUMNA_pregunta_59h_5="pregunta_59h_5";
public static String COLUMNA_pregunta_59i_5="pregunta_59i_5";
public static String COLUMNA_pregunta_59j_5="pregunta_59j_5";
public static String COLUMNA_pregunta_60_5="pregunta_60_5";
public static String COLUMNA_pregunta_60a_5="pregunta_60a_5";
public static String COLUMNA_pregunta_61_5="pregunta_61_5";
public static String COLUMNA_pregunta_61a_5="pregunta_61a_5";
public static String COLUMNA_pregunta_62_5="pregunta_62_5";
public static String COLUMNA_pregunta_62a_5="pregunta_62a_5";
public static String COLUMNA_pregunta_63_5="pregunta_63_5";
public static String COLUMNA_pregunta_64_5="pregunta_64_5";
public static String COLUMNA_pregunta_65_5="pregunta_65_5";
public static String COLUMNA_pregunta_66_5="pregunta_66_5";
public static String COLUMNA_pregunta_66a_5="pregunta_66a_5";
public static String COLUMNA_pregunta_66b_5="pregunta_66b_5";
public static String COLUMNA_pregunta_66c_5="pregunta_66c_5";
public static String COLUMNA_pregunta_66d_5="pregunta_66d_5";
public static String COLUMNA_pregunta_66e_5="pregunta_66e_5";
public static String COLUMNA_pregunta_67_5="pregunta_67_5";
public static String COLUMNA_pregunta_67a_5="pregunta_67a_5";
public static String COLUMNA_pregunta_68_5="pregunta_68_5";
public static String COLUMNA_pregunta_68a_5="pregunta_68a_5";
public static String COLUMNA_pregunta_69_5="pregunta_69_5";
public static String COLUMNA_pregunta_69a_5="pregunta_69a_5";
public static String COLUMNA_pregunta_69a1_5="pregunta_69a1_5";
public static String COLUMNA_pregunta_69a2_5="pregunta_69a2_5";
public static String COLUMNA_pregunta_70_5="pregunta_70_5";
public static String COLUMNA_pregunta_70a_5="pregunta_70a_5";
public static String COLUMNA_pregunta_70b_5="pregunta_70b_5";
public static String COLUMNA_pregunta_70c_5="pregunta_70c_5";
public static String COLUMNA_pregunta_70d_5="pregunta_70d_5";
public static String COLUMNA_pregunta_70e_5="pregunta_70e_5";
public static String COLUMNA_pregunta_70f_5="pregunta_70f_5";
public static String COLUMNA_pregunta_71_5="pregunta_71_5";
public static String COLUMNA_pregunta_CLAS2_5="pregunta_CLAS2_5";



public static String COLUMNA_abandono="abandono";
public static String COLUMNA_suma="suma";
public static String COLUMNA_status="status";
// FINALIZAN PREGUNTAS
public static String COLUMNA_TIEMPO = "tiempo";
public static String COLUMNA_TIPOCAPTURA = "tipocaptura";
}

private static final String DATABASE_MENORES_SIN= "create table "
+ TablaMenoresSinDiscapacidad.TABLA_MENORES_SIN_DISCAPACIDAD + "("
+ "id integer primary key autoincrement,"
+ TablaMenoresSinDiscapacidad.COLUMNA_CONSECUTIVO_DIARIO + " text not null, "
+ TablaMenoresSinDiscapacidad.COLUMNA_EQUIPO + " text not null, "
+ TablaMenoresSinDiscapacidad.COLUMNA_USUARIO + " text not null, "
+ TablaMenoresSinDiscapacidad.COLUMNA_NOMBRE_ENCUESTA + " text not null, "
+ TablaMenoresSinDiscapacidad.COLUMNA_FECHA + " date not null, "
+ TablaMenoresSinDiscapacidad.COLUMNA_HORA + " text not null, "
+ TablaMenoresSinDiscapacidad.COLUMNA_imei + " text not null, "
+ TablaMenoresSinDiscapacidad.COLUMNA_SECCION + " INTEGER not null, "
+ TablaMenoresSinDiscapacidad.COLUMNA_latitud + " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_longitud + " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_latitud2 + " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_longitud2 + " text, "


+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_52_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_52a_1 +  " text, "

+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_53_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_53a_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_54_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55a_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55b_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55c_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_56_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_56a_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57a_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57b_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57c_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_58_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59a_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59b_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59c_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59d_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59e_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59f_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59g_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59h_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59i_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59j_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_60_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_60a_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_61_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_61a_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_62_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_62a_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_63_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_64_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_65_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66a_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66b_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66c_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66d_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66e_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_67_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_67a_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_68_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_68a_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69a_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69a1_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69a2_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70a_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70b_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70c_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70d_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70e_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70f_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_71_1 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_CLAS2_1 +  " text, "


+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_53_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_53a_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_54_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55a_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55b_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55c_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_56_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_56a_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57a_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57b_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57c_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_58_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59a_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59b_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59c_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59d_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59e_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59f_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59g_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59h_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59i_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59j_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_60_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_60a_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_61_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_61a_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_62_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_62a_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_63_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_64_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_65_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66a_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66b_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66c_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66d_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66e_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_67_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_67a_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_68_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_68a_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69a_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69a1_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69a2_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70a_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70b_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70c_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70d_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70e_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70f_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_71_2 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_CLAS2_2 +  " text, "


+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_53_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_53a_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_54_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55a_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55b_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55c_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_56_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_56a_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57a_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57b_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57c_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_58_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59a_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59b_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59c_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59d_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59e_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59f_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59g_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59h_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59i_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59j_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_60_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_60a_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_61_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_61a_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_62_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_62a_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_63_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_64_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_65_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66a_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66b_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66c_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66d_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66e_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_67_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_67a_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_68_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_68a_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69a_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69a1_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69a2_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70a_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70b_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70c_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70d_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70e_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70f_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_71_3 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_CLAS2_3 +  " text, "


+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_53_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_53a_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_54_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55a_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55b_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55c_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_56_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_56a_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57a_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57b_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57c_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_58_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59a_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59b_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59c_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59d_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59e_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59f_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59g_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59h_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59i_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59j_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_60_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_60a_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_61_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_61a_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_62_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_62a_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_63_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_64_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_65_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66a_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66b_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66c_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66d_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66e_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_67_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_67a_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_68_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_68a_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69a_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69a1_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69a2_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70a_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70b_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70c_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70d_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70e_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70f_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_71_4 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_CLAS2_4 +  " text, "


+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_53_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_53a_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_54_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55a_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55b_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_55c_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_56_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_56a_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57a_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57b_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_57c_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_58_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59a_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59b_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59c_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59d_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59e_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59f_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59g_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59h_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59i_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_59j_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_60_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_60a_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_61_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_61a_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_62_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_62a_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_63_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_64_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_65_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66a_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66b_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66c_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66d_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_66e_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_67_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_67a_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_68_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_68a_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69a_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69a1_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_69a2_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70a_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70b_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70c_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70d_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70e_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_70f_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_71_5 +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_pregunta_CLAS2_5 +  " text, "

+ TablaMenoresSinDiscapacidad.COLUMNA_abandono +  " text, "

+ TablaMenoresSinDiscapacidad.COLUMNA_suma +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_status +  " text, "
+ TablaMenoresSinDiscapacidad.COLUMNA_TIEMPO + " text not null, "
+ TablaMenoresSinDiscapacidad.COLUMNA_TIPOCAPTURA + " text not null); ";
	 
	    
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
	        db.execSQL(DATABASE_ENCUESTAS);
	        db.execSQL(DATABASE_ADULTOS);
	        db.execSQL(DATABASE_MENORES_CON);
	        db.execSQL(DATABASE_MENORES_SIN);
	        
	        
	        
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
	        db.execSQL("drop table if exists " + TablaAdultos.TABLA_ADULTOS);
	        db.execSQL("drop table if exists " + TablaMenoresConDiscapacidad.TABLA_MENORES_CON_DISCAPACIDAD);
	        db.execSQL("drop table if exists " + TablaMenoresSinDiscapacidad.TABLA_MENORES_SIN_DISCAPACIDAD);
	        onCreate(db);
	    }
}
