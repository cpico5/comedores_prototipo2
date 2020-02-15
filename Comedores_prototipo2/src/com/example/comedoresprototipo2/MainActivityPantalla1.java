package com.example.comedoresprototipo2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.comedoresprototipo2.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityPantalla1 extends Activity {

	private static final String LOG_TAG = "Pantalla1";
	private MediaRecorder mediaRecorder;
	private MediaPlayer mediaPlayer;

	final Context context = this;

	private ArrayList<CheckBox> mChecks;
	private ArrayList<CheckBox> mSelectedChecks;

	private ArrayList<CheckBox> mChecks2;
	private ArrayList<CheckBox> mSelectedChecks2;

	public MediaRecorder recorder = new MediaRecorder();
	private String audio;
	private Handler handler;
	public String honestidad;

	public StringBuilder builder0;

	private Button btnGuardar;
	private Button btnAbandono;
	private Button btnRechazo;
	private Button btnAbrir;
	private Button btnSalir;
	public Button uploadButton, emailButton;

	double latitude;
	double longitude;

	Random random = new java.util.Random();
	public int rand;
	public EditText editFin;
	public RadioGroup rdPreguntaMedio;
	public RadioGroup rdPreguntaSemana;
	public RadioGroup rdPreguntaFinSemana;

	public RadioGroup rdPreguntaOcupacion, rdPreguntaFocos, rdPreguntaE1a, rdPreguntaE1b, rdPreguntaCoche, rdPreguntaE3,
			rdPreguntaE4, rdPreguntaCuantosCoches, rdPreguntaTrabajo, rdPreguntaE7, rdPregunta4a, rdPregunta4b,
			rdPregunta4c, rdPregunta4d, rdPregunta4e, rdPreguntaCuartos, rdPreguntaCuartosDormir, rdPreguntaCuartos1a,
			rdPreguntaE92, rdPreguntaBanos, rdPreguntaTrabajaron,rdPreguntaInternet,rdPreguntaE101, rdPreguntaE102a, rdPreguntaE103, rdPreguntaRegadera,
			rdPreguntaEstufa, rdPreguntaEdad, rdPreguntaGenero, rdPreguntaTipoVivienda, rdPreguntaTipoPiso,
			rdPreguntaE17;
	
	

	public EditText txtSeccion, txtFolio;
	public RadioGroup   rdPregunta2a, rdPregunta2b,  rdPregunta3a,
			 rdPregunta6a, rdPregunta6b, rdPregunta6c;
	public RadioGroup  rdPregunta5a, rdPregunta5b, rdPregunta5c, rdPregunta5d, rdPregunta5e, rdPregunta5f,
			rdPregunta5g, rdPregunta5h, rdPregunta5i, rdPregunta5j, rdPregunta5k, rdPregunta5l;
	public RadioGroup       rdPregunta76,
			rdPregunta77, rdPregunta78;
	public RadioGroup   rdPregunta79a, rdPregunta79a1, rdPregunta79a2, rdPregunta79a3;
	public RadioGroup rdPregunta5m, rdPregunta5n, rdPregunta5o, rdPregunta5p, rdPregunta5q, rdPregunta5r, rdPregunta5s,
			rdPregunta5t;
	public RadioGroup rdPreguntaJefe, rdPreguntaAporta, rdPreguntaAbandono, rdPregunta6e;

	public RadioGroup   rdPreguntaHijos,  rdPregunta86a, rdPregunta86b, rdPregunta86c, rdPregunta86d,
			rdPregunta86e, rdPregunta86f, rdPregunta86g;


	public RadioButton radio_abandono1,radio_abandono2,radio_abandono3;
	
	public RadioButton radio11_1, radio11_2, radio11_3, radio11_4, radio11_5, radio11_6, radio11_7, radio11_8,
			radio11_9, radio11_10, radio11_11, radio11_12, radio11_0;
	public RadioButton radio13_1, radio13_2, radio13_3, radio13_4, radio13_5, radio13_6, radio13_7, radio13_8,
			radio13_9, radio13_10, radio13_11, radio13_12, radio13_0;
	public RadioButton radio14_1, radio14_2, radio14_3, radio14_4, radio14_5, radio14_6, radio14_7, radio14_8,
			radio14_9, radio14_10, radio14_11, radio14_12, radio14_0;

	public TextView pregunta3, pregunta6, pregunta6a, pregunta26, pregunta29b, pregunta51, pregunta34, pregunta35,
			pregunta36, pregunta36a;
	public TextView pregunta7, pregunta8, pregunta9, pregunta10, pregunta11, pregunta13, pregunta15, pregunta17,
			pregunta19, pregunta21, pregunta23, pregunta25;
	public TextView pregunta12, pregunta14, pregunta16, pregunta18, pregunta20;
	public TextView pregunta12a, pregunta14a, pregunta16a, pregunta18a, pregunta20a;
	public TextView pregunta12b, pregunta14b, pregunta16b, pregunta18b, pregunta20b;
	public TextView pregunta27, pregunta29;
	public TextView preguntaNom1, preguntaNom2, preguntaNom3, preguntaNom4, preguntaNom5;
	public TextView radio351, radio352, radio353, radio354, radio355;
	public TextView radio38, radio362, radio310, radio311, radio312;
	



	

	private static final int READ_BLOCK_SIZE = 100000;

	Nombre nom = new Nombre();
	String nombreEncuesta = nom.nombreEncuesta();

	UsuariosSQLiteHelper usdbh;
	UsuariosSQLiteHelper Udb;
	List<String> list;
	ArrayAdapter<String> adapter;
	ArrayAdapter<String> adapter2;
	private SQLiteDatabase db;

	UsuariosSQLiteHelper2 usdbh2;
	private SQLiteDatabase db2;

	private Spinner spinnerDelegaciones;
	private Spinner spinnerMeses;
	private Spinner spinnerSemana;
	private Spinner spinnerCalifica;
	
	private Spinner spinner7;
	private Spinner spinner8;
	
	private Spinner spinner12_1;
	private Spinner spinner12_2;
	private Spinner spinner12_3;

	String elDelegado;

	Timer timer;


	public String op1="sin datos";
	public String op2="sin datos";
	public String op3="sin datos";
	public String op4="sin datos";
	public String op5="sin datos";
	public String op6="sin datos";
	public String op7="sin datos";
	public String op8="sin datos";
	public String op9="sin datos";
	public String op10="sin datos";
	public String op11="sin datos";
	public String op12="sin datos";
	public String op13="sin datos";
	public String op13a="sin datos";
	public String op13b="sin datos";
	public String op13c="sin datos";
	public String op13d="sin datos";
	public String op14="sin datos";
	public String op14a="sin datos";
	public String op14b="sin datos";
	public String op14c="sin datos";
	public String op15="sin datos";
	public String op15a="sin datos";
	public String op16="sin datos";
	public String op16a="sin datos";
	public String op16b="sin datos";
	public String op16_1="sin datos";
	public String op16c="sin datos";
	public String op16d="sin datos";
	public String op16e="sin datos";
	public String op16f="sin datos";
	public String op16g="sin datos";
	public String op16h="sin datos";
	public String op16i="sin datos";
	public String op16j="sin datos";
	public String op16k="sin datos";
	public String op16l="sin datos";
	public String op16m="sin datos";
	public String op16n="sin datos";
	public String op16o="sin datos";
	public String op17="sin datos";
	public String op17a="sin datos";
	public String op17b="sin datos";
	public String op18="sin datos";
	public String op19="sin datos";
	public String op19a="sin datos";
	public String op19b="sin datos";
	public String op19c="sin datos";
	public String op19d="sin datos";
	public String op19e="sin datos";
	public String op20="sin datos";
	public String op21="sin datos";
	public String op22="sin datos";
	public String op23="sin datos";
	public String op24="sin datos";
	public String op25="sin datos";
	public String op26="sin datos";
	public String op26a="sin datos";
	public String op26b="sin datos";
	public String op27="sin datos";
	public String op27a="sin datos";
	public String op27a1="sin datos";
	public String op27a2="sin datos";
	public String op27a3="sin datos";
	public String op27a4="sin datos";
	public String op28="sin datos";
	public String op29="sin datos";
	public String op29a="sin datos";
	public String op29a1="sin datos";
	public String op29a2="sin datos";
	public String op30="sin datos";
	public String op31="sin datos";
	public String op32="sin datos";
	public String op33="sin datos";



	public String opAbandono="sin datos";
	public RadioGroup rdPregunta1;
	public RadioGroup rdPregunta2;
	public RadioGroup rdPregunta3;
	public RadioGroup rdPregunta4;
	public RadioGroup rdPregunta5;
	public RadioGroup rdPregunta6;
	public RadioGroup rdPregunta7;
	public RadioGroup rdPregunta8;
	public RadioGroup rdPregunta9;
	public RadioGroup rdPregunta10;
	public RadioGroup rdPregunta11;
	public RadioGroup rdPregunta12;
	public RadioGroup rdPregunta13;
	public RadioGroup rdPregunta13a;
	public RadioGroup rdPregunta13b;
	public RadioGroup rdPregunta13c;
	public RadioGroup rdPregunta13d;
	public RadioGroup rdPregunta14;
	public RadioGroup rdPregunta14a;
	public RadioGroup rdPregunta14b;
	public RadioGroup rdPregunta14c;
	public RadioGroup rdPregunta15;
	public RadioGroup rdPregunta15a;
	public RadioGroup rdPregunta16;
	public RadioGroup rdPregunta16a;
	public RadioGroup rdPregunta16b;
	public RadioGroup rdPregunta16_1;
	public RadioGroup rdPregunta16c;
	public RadioGroup rdPregunta16d;
	public RadioGroup rdPregunta16e;
	public RadioGroup rdPregunta16f;
	public RadioGroup rdPregunta16g;
	public RadioGroup rdPregunta16h;
	public RadioGroup rdPregunta16i;
	public RadioGroup rdPregunta16j;
	public RadioGroup rdPregunta16k;
	public RadioGroup rdPregunta16l;
	public RadioGroup rdPregunta16m;
	public RadioGroup rdPregunta16n;
	public RadioGroup rdPregunta16o;
	public RadioGroup rdPregunta17;
	public RadioGroup rdPregunta17a;
	public RadioGroup rdPregunta17b;
	public RadioGroup rdPregunta18;
	public RadioGroup rdPregunta19;
	public RadioGroup rdPregunta19a;
	public RadioGroup rdPregunta19b;
	public RadioGroup rdPregunta19c;
	public RadioGroup rdPregunta19d;
	public RadioGroup rdPregunta19e;
	public RadioGroup rdPregunta20;
	public RadioGroup rdPregunta21;
	public RadioGroup rdPregunta22;
	public RadioGroup rdPregunta23;
	public RadioGroup rdPregunta24;
	public RadioGroup rdPregunta25;
	public RadioGroup rdPregunta26;
	public RadioGroup rdPregunta26a;
	public RadioGroup rdPregunta26b;
	public RadioGroup rdPregunta27;
	public RadioGroup rdPregunta27a;
	public RadioGroup rdPregunta27a1;
	public RadioGroup rdPregunta27a2;
	public RadioGroup rdPregunta27a3;
	public RadioGroup rdPregunta27a4;
	public RadioGroup rdPregunta28;
	public RadioGroup rdPregunta29;
	public RadioGroup rdPregunta29a;
	public RadioGroup rdPregunta29a1;
	public RadioGroup rdPregunta29a2;
	public RadioGroup rdPregunta30;
	public RadioGroup rdPregunta31;
	public RadioGroup rdPregunta32;
	public RadioGroup rdPregunta33;
	public RadioGroup rdPregunta34;
	public RadioGroup rdPregunta35;

	
	public EditText editPregunta1;
	public EditText editPregunta2;
	public EditText editPregunta3;
	public EditText editPregunta4;
	public EditText editPregunta5;
	public EditText editPregunta6;
	public EditText editPregunta7;
	public EditText editPregunta8;
	public EditText editPregunta9;
	public EditText editPregunta10;
	public EditText editPregunta11;
	public EditText editPregunta12;
	public EditText editPregunta13;
	public EditText editPregunta13a;
	public EditText editPregunta13b;
	public EditText editPregunta13c;
	public EditText editPregunta13d;
	public EditText editPregunta14;
	public EditText editPregunta14a;
	public EditText editPregunta14b;
	public EditText editPregunta14c;
	public EditText editPregunta15;
	public EditText editPregunta15a;
	public EditText editPregunta16;
	public EditText editPregunta16a;
	public EditText editPregunta16b;
	public EditText editPregunta16_1;
	public EditText editPregunta16c;
	public EditText editPregunta16d;
	public EditText editPregunta16e;
	public EditText editPregunta16f;
	public EditText editPregunta16g;
	public EditText editPregunta16h;
	public EditText editPregunta16i;
	public EditText editPregunta16j;
	public EditText editPregunta16k;
	public EditText editPregunta16l;
	public EditText editPregunta16m;
	public EditText editPregunta16n;
	public EditText editPregunta16o;
	public EditText editPregunta17;
	public EditText editPregunta17a;
	public EditText editPregunta17b;
	public EditText editPregunta18;
	public EditText editPregunta19;
	public EditText editPregunta19a;
	public EditText editPregunta19b;
	public EditText editPregunta19c;
	public EditText editPregunta19d;
	public EditText editPregunta19e;
	public EditText editPregunta20;
	public EditText editPregunta21;
	public EditText editPregunta22;
	public EditText editPregunta23;
	public EditText editPregunta24;
	public EditText editPregunta25;
	public EditText editPregunta26;
	public EditText editPregunta26a;
	public EditText editPregunta26b;
	public EditText editPregunta27;
	public EditText editPregunta27a;
	public EditText editPregunta27a1;
	public EditText editPregunta27a2;
	public EditText editPregunta27a3;
	public EditText editPregunta27a4;
	public EditText editPregunta28;
	public EditText editPregunta29;
	public EditText editPregunta29a;
	public EditText editPregunta29a1;
	public EditText editPregunta29a2;
	public EditText editPregunta30;
	public EditText editPregunta31;
	public EditText editPregunta32;
	public EditText editPregunta33;
	public EditText editPregunta34;
	public EditText editPregunta35;

	
	public String captura1;
	public String captura2;
	public String captura3;
	public String captura4;
	public String captura5;
	public String captura6;
	public String captura7;
	public String captura8;
	public String captura9;
	public String captura10;
	public String captura11;
	public String captura12;
	public String captura13;
	public String captura13a;
	public String captura13b;
	public String captura13c;
	public String captura13d;
	public String captura14;
	public String captura14a;
	public String captura14b;
	public String captura14c;
	public String captura15;
	public String captura15a;
	public String captura16;
	public String captura16a;
	public String captura16b;
	public String captura16_1;
	public String captura16c;
	public String captura16d;
	public String captura16e;
	public String captura16f;
	public String captura16g;
	public String captura16h;
	public String captura16i;
	public String captura16j;
	public String captura16k;
	public String captura16l;
	public String captura16m;
	public String captura16n;
	public String captura16o;
	public String captura17;
	public String captura17a;
	public String captura17b;
	public String captura18;
	public String captura19;
	public String captura19a;
	public String captura19b;
	public String captura19c;
	public String captura19d;
	public String captura19e;
	public String captura20;
	public String captura21;
	public String captura22;
	public String captura23;
	public String captura24;
	public String captura25;
	public String captura26;
	public String captura26a;
	public String captura26b;
	public String captura27;
	public String captura27a;
	public String captura27a1;
	public String captura27a2;
	public String captura27a3;
	public String captura27a4;
	public String captura28;
	public String captura29;
	public String captura29a;
	public String captura29a1;
	public String captura29a2;
	public String captura30;
	public String captura31;
	public String captura32;
	public String captura33;
	public String captura34;
	public String captura35;


	public Resources res;

	UsuariosSQLiteHelper3 usdbh3;
	private SQLiteDatabase db3;

	LinearLayout lay1;
	LinearLayout lay2;
	LinearLayout lay3;
	LinearLayout lay4;
	LinearLayout lay5;
	LinearLayout lay6;
	LinearLayout lay7;
	LinearLayout lay8;
	LinearLayout lay9;
	LinearLayout lay10;
	LinearLayout lay11;
	LinearLayout lay12;
	LinearLayout lay13;
	LinearLayout lay13a;
	LinearLayout lay13b;
	LinearLayout lay13c;
	LinearLayout lay13d;
	LinearLayout lay14;
	LinearLayout lay14a;
	LinearLayout lay14b;
	LinearLayout lay14c;
	LinearLayout lay15;
	LinearLayout lay15a;
	LinearLayout lay16;
	LinearLayout lay16a;
	LinearLayout lay16b;
	LinearLayout lay16_1;
	LinearLayout lay16c;
	LinearLayout lay16d;
	LinearLayout lay16e;
	LinearLayout lay16f;
	LinearLayout lay16g;
	LinearLayout lay16h;
	LinearLayout lay16i;
	LinearLayout lay16j;
	LinearLayout lay16k;
	LinearLayout lay16l;
	LinearLayout lay16m;
	LinearLayout lay16n;
	LinearLayout lay16o;
	LinearLayout lay17;
	LinearLayout lay17a;
	LinearLayout lay17b;
	LinearLayout lay18;
	LinearLayout lay19;
	LinearLayout lay19a;
	LinearLayout lay19b;
	LinearLayout lay19c;
	LinearLayout lay19d;
	LinearLayout lay19e;
	LinearLayout lay20;
	LinearLayout lay21;
	LinearLayout lay22;
	LinearLayout lay23;
	LinearLayout lay24;
	LinearLayout lay25;
	LinearLayout lay26;
	LinearLayout lay26a;
	LinearLayout lay26b;
	LinearLayout lay27;
	LinearLayout lay27a;
	LinearLayout lay27a1;
	LinearLayout lay27a2;
	LinearLayout lay27a3;
	LinearLayout lay27a4;
	LinearLayout lay28;
	LinearLayout lay29;
	LinearLayout lay29a;
	LinearLayout lay29a1;
	LinearLayout lay29a2;
	LinearLayout lay30;
	LinearLayout lay31;
	LinearLayout lay32;
	LinearLayout lay33;
	LinearLayout lay34;



	public RadioButton radio1_07;

	public String capturaMedio;
	public String capturaSemana;
	public String capturaFinSemana, capturaHijos;

	public String captura41, captura42, captura43, captura44;
	public String captura51, captura52,   captura55, captura56, captura57;

	public String capturaOcupacion, capturaCoche, capturaE3, capturaE4, capturaCuantosCoches, capturaTrabajo, capturaE7,
			capturaFocos, capturaCuartos, capturaCuartosDormir, capturaBanos,capturaInternet,capturaTrabajaron;
	public String capturaRegadera, capturaEstufa, capturaEdad, capturaGenero, capturaTipoVivienda, capturaTipoPiso,
			capturaE17, capturaE18, capturaE19, capturaE20;
	public String capturaJefe, capturaAporta;
	
	
	public String maximo = "";
	int elMaximo;
	String tipoEncuesta;

	public String pasoUsuario;

	public String Secc;

	public EditText editUsuario;

	public String str;
	public String variablePrueba;
	public String encuestador;
	public String tablet;
	public String hora;

	public String quien;

	String upLoadServerUri = null;
	ProgressDialog dialog = null;
	final String path = "/mnt/sdcard/Mis_archivos/";

	int serverResponseCode = 0;

	public String tiempo;

	Calendar c = Calendar.getInstance();

	SimpleDateFormat df1 = new SimpleDateFormat("yyy-MM-dd");
	String formattedDate1 = df1.format(c.getTime());

	SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a");
	String formattedDate2 = df2.format(c.getTime());

	SimpleDateFormat df3 = new SimpleDateFormat("yyyMMdd");
	String formattedDate3 = df3.format(c.getTime());

	SimpleDateFormat df6 = new SimpleDateFormat("MM");
	String formattedDate6 = df6.format(c.getTime());

	SimpleDateFormat df7 = new SimpleDateFormat("dd");
	String formattedDate7 = df7.format(c.getTime());

	SimpleDateFormat df4 = new SimpleDateFormat("HH:mm:ss a");
	String formattedDate4 = df4.format(c.getTime());

	SimpleDateFormat df5 = new SimpleDateFormat("HH:mm:ss");
	String formattedDate5 = df5.format(c.getTime());

	public static String getHostName(String defValue) {
		try {
			Method getString = Build.class.getDeclaredMethod("getString", String.class);
			getString.setAccessible(true);
			return getString.invoke(null, "net.hostname").toString();
		} catch (Exception ex) {
			return defValue;
		}
	}

	static String ID = getHostName(null);
	static String prefix = ID;

	public String cachaNombre() {
		Bundle datos = this.getIntent().getExtras();
		String Nombre = datos.getString("Nombre");
		return Nombre;
	}

	public String cachaSeccion() {
		Bundle datos = this.getIntent().getExtras();
		String Seccion = datos.getString("Seccion");
		return Seccion;
	}

	public String cachaAlcaldia() {
		Bundle datos = this.getIntent().getExtras();
		String alcaldia = datos.getString("alcaldia");
		return alcaldia;
	}
	
	public String cachaEscuela() {
		Bundle datos = this.getIntent().getExtras();
		String escuela = datos.getString("escuela");
		return escuela;
	}
	
	public String cachaDomicilio() {
		Bundle datos = this.getIntent().getExtras();
		String domicilio = datos.getString("domicilio");
		return domicilio;
	}
	
	public String cachaCCT() {
		Bundle datos = this.getIntent().getExtras();
		String cct = datos.getString("cct");
		return cct;
	}
	
	public String cachaCP() {
		Bundle datos = this.getIntent().getExtras();
		String cp = datos.getString("cp");
		return cp;
	}
	
	public String cachaMatricula() {
		Bundle datos = this.getIntent().getExtras();
		String matricula = datos.getString("matricula");
		return matricula;
	}

	public String cachaEquipo() {
		Bundle datos = this.getIntent().getExtras();
		String equipo = datos.getString("equipo");
		return equipo;
	}

	public long t1() {
		Bundle datos = this.getIntent().getExtras();
		long t1 = datos.getLong("t1");
		return t1;
	}

	public void sacaChip() {
		String deviceId = Secure.getString(this.getContentResolver(), Secure.ANDROID_ID);
		tablet = deviceId;
	}

	public String sacaImei() {
		TelephonyManager TelephonyMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		String szImei = TelephonyMgr.getDeviceId(); // Requires READ_PHONE_STATE
		System.out.println("Mi Número: " + szImei);

		return szImei;
	}

	public String hora() {

		if (formattedDate5.matches("")) {
			formattedDate5 = df5.format(c.getTime());
		}
		return formattedDate5;
	}

	public void dialogo() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("¿Desea continuar Encuestando..?").setTitle("IMPORTANTE").setCancelable(false)
				.setNegativeButton("SALIR", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						detenerGrabacion();

						Intent i = new Intent(MainActivityPantalla1.this, Entrada.class);
						i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(i);
						System.exit(0); // metodo que se debe implementar
					}
				}).setPositiveButton("CONTINUAR", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						detenerGrabacion();

						Intent i = new Intent(MainActivityPantalla1.this, MainActivity.class);
						i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						i.putExtra("Nombre", cachaNombre());
						startActivity(i);
						System.exit(0); // metodo que se debe implementar
					}
				});
		AlertDialog alert = builder.create();
		alert.show();

	}
	
	public void dialogoFoto(final String elcct, final String laescuela) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Encuestador, tomar foto legible con firma del director y sello de la escuela").setTitle("Foto de CROQUIS").setCancelable(false)
				.setPositiveButton("CONTINUAR", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						detenerGrabacion();

						Intent i = new Intent(MainActivityPantalla1.this, FotoEvidencia.class);
						i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						i.putExtra("Nombre", cachaNombre());
						i.putExtra("cct", elcct);
						i.putExtra("escuela", laescuela);
						startActivity(i);
						System.exit(0); // metodo que se debe implementar
					}
				});
		AlertDialog alert = builder.create();
		alert.show();

	}
	
	

	public void dialogoParoAudio() {
		timer.cancel();
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		MainActivityPantalla1.this.runOnUiThread(new Runnable() {
			public void run() {
				builder.setMessage("¿Se detendrá la grabación y \n se reiniciará la encuesta..?")
						.setTitle("AVISO...!!!").setCancelable(false)
						.setNegativeButton("SALIR", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {

								detenerGrabacion();

								Intent i = new Intent(MainActivityPantalla1.this, Entrada.class);
								i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								startActivity(i);
								System.exit(0); // metodo que se debe
												// implementar
							}
						});
				AlertDialog alert = builder.create();
				alert.show();

			}
		});

	}

	public void dialogoCierraEncuesta() {
		timer.cancel();

		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		MainActivityPantalla1.this.runOnUiThread(new Runnable() {
			public void run() {
				builder.setMessage("Excediste el tiempo máximo para realizar la encuesta \n"
						+ "¡¡¡ Se detendrá la grabación y se reiniciará la Aplicación..!!!").setTitle("AVISO...!!!")
						.setCancelable(false).setNegativeButton("SALIR", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {

								detenerGrabacion();

								Intent i = new Intent(MainActivityPantalla1.this, Entrada.class);
								i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								startActivity(i);
								System.exit(0); // metodo que se debe
												// implementar
							}
						});

				AlertDialog alert = builder.create();

				alert.show();
			}
		});

	}

	public void dialogoAbandono() {
		timer.cancel();

		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		MainActivityPantalla1.this.runOnUiThread(new Runnable() {
			public void run() {
				builder.setMessage("Deseas abandonar la encuesta?").setTitle("AVISO...!!!").setCancelable(false)
						.setNegativeButton("SALIR", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {

								detenerGrabacion();
							}
						}).setPositiveButton("CONTINUAR", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {

							}
						});

				AlertDialog alert = builder.create();

				alert.show();
			}
		});

	}

	// EVENTO AL PULSAR EL BOTON ATRAS

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			// Esto es lo que hace mi botón al pulsar ir a atrás
			Toast.makeText(getApplicationContext(), "No puedo ir hacia atrás!!\nEstoy grabando...", Toast.LENGTH_SHORT)
					.show();

			// dialogoAbandono();

			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	public String nombreArchivo() {
		String date = formattedDate3.toString();
		String var2 = ".txt";
		String var3 = date + var2;

		final String nombre = date + "-" + tablet + "-" + nombreEncuesta + var2;
		return nombre;
	}

	public String nombreAudio() {

		elMaximo = Integer.parseInt(sacaMaximo().toString()) + 1;
		String date = formattedDate3.toString();
		String var2 = ".mp3";

		int consecutivo = Integer.parseInt(sacaConsecutivo().toString()) + 1;
		String elConsecutivo = String.valueOf(consecutivo);
		int Cons = elConsecutivo.length();

		if (Cons == 1) {
			elConsecutivo = "00" + elConsecutivo;
		} else if (Cons == 2) {
			elConsecutivo = "0" + elConsecutivo;
		} else {
			elConsecutivo = elConsecutivo;
		}

		String usuario;

		int tamanoUsuario = cachaNombre().length();

		if (tamanoUsuario == 1) {
			usuario = "00" + cachaNombre();
		} else if (tamanoUsuario == 2) {
			usuario = "0" + cachaNombre();
		} else {
			usuario = cachaNombre();
		}

		// nombreEncuesta_fecha_chip_usuario_consecutivo
		final String nombreAudio = nombreEncuesta + "_" + date + "_" + sacaImei() + "_" + cachaNombre() + "_"
				+ elConsecutivo + ".mp3";
		// final String nombreAudio =
		// nombreEncuesta+"_"+date+"_"+prefix+"_"+elConsecutivo+".mp3";
		return nombreAudio;
	}

	public String elTiempo() {
		// Para la diferenci entre tiempos
		Calendar t2 = Calendar.getInstance();
		long milis2 = t2.getTimeInMillis();
		long diff = milis2 - t1();

		long diffSegundos = diff / 1000;

		long diffMinutos = diffSegundos / 60;

		long residuo = diffSegundos % 60;

		System.out.println(diffSegundos);
		System.out.println(diffMinutos);
		System.out.println(residuo);

		tiempo = diffMinutos + ":" + residuo;

		return tiempo;

	}
	
	public class DecimalDigitsInputFilter implements InputFilter {

		Pattern mPattern;

		public DecimalDigitsInputFilter(int digitsBeforeZero,int digitsAfterZero) {
		    mPattern=Pattern.compile("[0-9]{0," + (digitsBeforeZero-1) + "}+((\\.[0-9]{0," + (digitsAfterZero-1) + "})?)||(\\.)?");
		}

		@Override
		public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

		        Matcher matcher=mPattern.matcher(dest);       
		        if(!matcher.matches())
		            return "";
		        return null;
		    }

		}

	private Integer[] mLinearLayoutIds = { 
//			R.layout.activity_pantalla1, 
//			R.layout.activity_pantalla2,
//			 R.layout.activity_pantalla3, 
//			 R.layout.activity_pantalla4,
//			 R.layout.activity_pantalla5,
//			 R.layout.activity_pantalla6, 
//			 R.layout.activity_pantalla7,
//			 R.layout.activity_pantalla8,
//			 R.layout.activity_pantalla9, 
//			 R.layout.activity_pantalla10,
			//// R.layout.activity_pantalla11,
			//// R.layout.activity_pantalla12,
			//// R.layout.activity_pantalla13,
			//// R.layout.activity_pantalla14,
			//// R.layout.activity_pantalla15,
			//// R.layout.activity_pantalla16,
			//// R.layout.activity_pantalla17,
			//// R.layout.activity_pantalla18,
			//// R.layout.activity_pantalla19,
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pantalla1); // COMENTAR ESTA CUANDO ES ALEATORIO

		// Carga las pantallas aleatoriamente
		random = new java.util.Random();
//
						/*DESCOMENTAR ESTAS 3 LINEAS CUANDO YA ESTA EL NUMERO DE HOJAS ALEATORIO */
//		 rand = random.nextInt(9);
//		 setContentView(mLinearLayoutIds[rand]);
//		 Log.i(null, "El aleatorio: " + rand); // si rand= 11 en el layoud
		// corresponde a uno mas
		 
		 
		 /*activity_pantalla12*/

		// Crea Log cuando falla la app
		Thread.setDefaultUncaughtExceptionHandler(new Crash(this));

		cachaNombre(); // llamado al mÃ©todo para obtener el numero del
						// encuestador

		try {

			handler = new Handler();

			new Thread(new Runnable() {
				@Override
				public void run() {
					handler.post(new Runnable() {
						@Override
						public void run() {
							grabar();
						}

					});

				}
			}).start();

		} catch (Exception e) {

		}

		///////////// EL TIMER PARA PARAR LA ENCUESTA /////////////////

		timer = new Timer();
//		timer.schedule(new CierraEncuesta(), 1800000); // 8 Minutos 480000

		////////////////////////
		

		rdPregunta1 = (RadioGroup)findViewById(R.id.rdPregunta1);
		rdPregunta2 = (RadioGroup)findViewById(R.id.rdPregunta2);
		rdPregunta3 = (RadioGroup)findViewById(R.id.rdPregunta3);
		rdPregunta4 = (RadioGroup)findViewById(R.id.rdPregunta4);
		rdPregunta5 = (RadioGroup)findViewById(R.id.rdPregunta5);
		rdPregunta6 = (RadioGroup)findViewById(R.id.rdPregunta6);
		rdPregunta7 = (RadioGroup)findViewById(R.id.rdPregunta7);
		rdPregunta8 = (RadioGroup)findViewById(R.id.rdPregunta8);
		rdPregunta9 = (RadioGroup)findViewById(R.id.rdPregunta9);
		rdPregunta10 = (RadioGroup)findViewById(R.id.rdPregunta10);
		rdPregunta11 = (RadioGroup)findViewById(R.id.rdPregunta11);
		rdPregunta12 = (RadioGroup)findViewById(R.id.rdPregunta12);
		rdPregunta13 = (RadioGroup)findViewById(R.id.rdPregunta13);
		rdPregunta13a = (RadioGroup)findViewById(R.id.rdPregunta13a);
		rdPregunta13b = (RadioGroup)findViewById(R.id.rdPregunta13b);
		rdPregunta13c = (RadioGroup)findViewById(R.id.rdPregunta13c);
		rdPregunta13d = (RadioGroup)findViewById(R.id.rdPregunta13d);
		rdPregunta14 = (RadioGroup)findViewById(R.id.rdPregunta14);
		rdPregunta14a = (RadioGroup)findViewById(R.id.rdPregunta14a);
		rdPregunta14b = (RadioGroup)findViewById(R.id.rdPregunta14b);
		rdPregunta14c = (RadioGroup)findViewById(R.id.rdPregunta14c);
		rdPregunta15 = (RadioGroup)findViewById(R.id.rdPregunta15);
		rdPregunta15a = (RadioGroup)findViewById(R.id.rdPregunta15a);
		rdPregunta16 = (RadioGroup)findViewById(R.id.rdPregunta16);
		rdPregunta16a = (RadioGroup)findViewById(R.id.rdPregunta16a);
		rdPregunta16b = (RadioGroup)findViewById(R.id.rdPregunta16b);
		rdPregunta16_1 = (RadioGroup)findViewById(R.id.rdPregunta16_1);
		rdPregunta16c = (RadioGroup)findViewById(R.id.rdPregunta16c);
		rdPregunta16d = (RadioGroup)findViewById(R.id.rdPregunta16d);
		rdPregunta16e = (RadioGroup)findViewById(R.id.rdPregunta16e);
		rdPregunta16f = (RadioGroup)findViewById(R.id.rdPregunta16f);
		rdPregunta16g = (RadioGroup)findViewById(R.id.rdPregunta16g);
		rdPregunta16h = (RadioGroup)findViewById(R.id.rdPregunta16h);
		rdPregunta16i = (RadioGroup)findViewById(R.id.rdPregunta16i);
		rdPregunta16j = (RadioGroup)findViewById(R.id.rdPregunta16j);
		rdPregunta16k = (RadioGroup)findViewById(R.id.rdPregunta16k);
		rdPregunta16l = (RadioGroup)findViewById(R.id.rdPregunta16l);
		rdPregunta16m = (RadioGroup)findViewById(R.id.rdPregunta16m);
		rdPregunta16n = (RadioGroup)findViewById(R.id.rdPregunta16n);
		rdPregunta16o = (RadioGroup)findViewById(R.id.rdPregunta16o);
		rdPregunta17 = (RadioGroup)findViewById(R.id.rdPregunta17);
		rdPregunta17a = (RadioGroup)findViewById(R.id.rdPregunta17a);
		rdPregunta17b = (RadioGroup)findViewById(R.id.rdPregunta17b);
		rdPregunta18 = (RadioGroup)findViewById(R.id.rdPregunta18);
		rdPregunta19 = (RadioGroup)findViewById(R.id.rdPregunta19);
		rdPregunta19a = (RadioGroup)findViewById(R.id.rdPregunta19a);
		rdPregunta19b = (RadioGroup)findViewById(R.id.rdPregunta19b);
		rdPregunta19c = (RadioGroup)findViewById(R.id.rdPregunta19c);
		rdPregunta19d = (RadioGroup)findViewById(R.id.rdPregunta19d);
		rdPregunta19e = (RadioGroup)findViewById(R.id.rdPregunta19e);
		rdPregunta20 = (RadioGroup)findViewById(R.id.rdPregunta20);
		rdPregunta21 = (RadioGroup)findViewById(R.id.rdPregunta21);
		rdPregunta22 = (RadioGroup)findViewById(R.id.rdPregunta22);
		rdPregunta23 = (RadioGroup)findViewById(R.id.rdPregunta23);
		rdPregunta24 = (RadioGroup)findViewById(R.id.rdPregunta24);
		rdPregunta25 = (RadioGroup)findViewById(R.id.rdPregunta25);
		rdPregunta26 = (RadioGroup)findViewById(R.id.rdPregunta26);
		rdPregunta26a = (RadioGroup)findViewById(R.id.rdPregunta26a);
		rdPregunta26b = (RadioGroup)findViewById(R.id.rdPregunta26b);
		rdPregunta27 = (RadioGroup)findViewById(R.id.rdPregunta27);
		rdPregunta27a = (RadioGroup)findViewById(R.id.rdPregunta27a);
		rdPregunta27a1 = (RadioGroup)findViewById(R.id.rdPregunta27a1);
		rdPregunta27a2 = (RadioGroup)findViewById(R.id.rdPregunta27a2);
		rdPregunta27a3 = (RadioGroup)findViewById(R.id.rdPregunta27a3);
		rdPregunta27a4 = (RadioGroup)findViewById(R.id.rdPregunta27a4);
		rdPregunta28 = (RadioGroup)findViewById(R.id.rdPregunta28);
		rdPregunta29 = (RadioGroup)findViewById(R.id.rdPregunta29);
		rdPregunta29a = (RadioGroup)findViewById(R.id.rdPregunta29a);
		rdPregunta29a1 = (RadioGroup)findViewById(R.id.rdPregunta29a1);
		rdPregunta29a2 = (RadioGroup)findViewById(R.id.rdPregunta29a2);
		rdPregunta30 = (RadioGroup)findViewById(R.id.rdPregunta30);
		rdPregunta31 = (RadioGroup)findViewById(R.id.rdPregunta31);
		rdPregunta32 = (RadioGroup)findViewById(R.id.rdPregunta32);
		rdPregunta33 = (RadioGroup)findViewById(R.id.rdPregunta33);
		rdPregunta34 = (RadioGroup)findViewById(R.id.rdPregunta34);
		rdPregunta35 = (RadioGroup)findViewById(R.id.rdPregunta35);
		rdPreguntaAbandono = (RadioGroup)findViewById(R.id.rdPreguntaAbandono);


		editPregunta1= (EditText)findViewById(R.id.editPregunta1);
		editPregunta2= (EditText)findViewById(R.id.editPregunta2);
		editPregunta3= (EditText)findViewById(R.id.editPregunta3);
		editPregunta4= (EditText)findViewById(R.id.editPregunta4);
		editPregunta5= (EditText)findViewById(R.id.editPregunta5);
		editPregunta6= (EditText)findViewById(R.id.editPregunta6);
		editPregunta7= (EditText)findViewById(R.id.editPregunta7);
//		editPregunta9= (EditText)findViewById(R.id.editPregunta9);
		editPregunta10= (EditText)findViewById(R.id.editPregunta10);
		editPregunta11= (EditText)findViewById(R.id.editPregunta11);
		editPregunta12= (EditText)findViewById(R.id.editPregunta12);
		editPregunta13d= (EditText)findViewById(R.id.editPregunta13d);
		editPregunta14a= (EditText)findViewById(R.id.editPregunta14a);
		editPregunta14c= (EditText)findViewById(R.id.editPregunta14c);
		editPregunta15a= (EditText)findViewById(R.id.editPregunta15a);
		editPregunta16o= (EditText)findViewById(R.id.editPregunta16o);
		editPregunta17b= (EditText)findViewById(R.id.editPregunta17b);
//		editPregunta26a= (EditText)findViewById(R.id.editPregunta26a);
//		editPregunta26b= (EditText)findViewById(R.id.editPregunta26b);
		editPregunta28= (EditText)findViewById(R.id.editPregunta28);
		editPregunta30= (EditText)findViewById(R.id.editPregunta30);
		editPregunta31= (EditText)findViewById(R.id.editPregunta31);
		editPregunta33= (EditText)findViewById(R.id.editPregunta33);

		
		editPregunta17b.setFilters(new InputFilter[] {
	            new DigitsKeyListener(Boolean.FALSE, Boolean.TRUE) {
	                int beforeDecimal = 2, afterDecimal = 2;

	                @Override
	                public CharSequence filter(CharSequence source, int start, int end,
	                        Spanned dest, int dstart, int dend) {
	                    String temp = editPregunta17b.getText() + source.toString();

	                    if (temp.equals(".")) {
	                        return "0.";
	                    }
	                    else if (temp.toString().indexOf(".") == -1) {
	                        // no decimal point placed yet
	                        if (temp.length() > beforeDecimal) {
	                            return "";
	                        }
	                    } else {
	                        temp = temp.substring(temp.indexOf(".") + 1);
	                        if (temp.length() > afterDecimal) {
	                            return "";
	                        }
	                    }

	                    return super.filter(source, start, end, dest, dstart, dend);
	                }
	            }
	    });

		res = getResources();

		captura1 =res.getString(R.string.PREGUNTA1);
		captura2 =res.getString(R.string.PREGUNTA2);
		captura3 =res.getString(R.string.PREGUNTA3);
		captura4 =res.getString(R.string.PREGUNTA4);
		captura5 =res.getString(R.string.PREGUNTA5);
		captura6 =res.getString(R.string.PREGUNTA6);
		captura7 =res.getString(R.string.PREGUNTA7);
		captura8 =res.getString(R.string.PREGUNTA8);
		captura9 =res.getString(R.string.PREGUNTA9);
		captura10 =res.getString(R.string.PREGUNTA10);
		captura11 =res.getString(R.string.PREGUNTA11);
		captura12 =res.getString(R.string.PREGUNTA12);
		captura13 =res.getString(R.string.PREGUNTA13);
		captura13a =res.getString(R.string.PREGUNTA13a);
		captura13b =res.getString(R.string.PREGUNTA13b);
		captura13c =res.getString(R.string.PREGUNTA13c);
		captura13d =res.getString(R.string.PREGUNTA13d);
		captura14 =res.getString(R.string.PREGUNTA14);
		captura14a =res.getString(R.string.PREGUNTA14a);
		captura14b =res.getString(R.string.PREGUNTA14b);
		captura14c =res.getString(R.string.PREGUNTA14c);
		captura15 =res.getString(R.string.PREGUNTA15);
		captura15a =res.getString(R.string.PREGUNTA15a);
		captura16 =res.getString(R.string.PREGUNTA16);
		captura16a =res.getString(R.string.PREGUNTA16a);
		captura16b =res.getString(R.string.PREGUNTA16b);
		captura16_1 =res.getString(R.string.PREGUNTA16_1);
		captura16c =res.getString(R.string.PREGUNTA16c);
		captura16d =res.getString(R.string.PREGUNTA16d);
		captura16e =res.getString(R.string.PREGUNTA16e);
		captura16f =res.getString(R.string.PREGUNTA16f);
		captura16g =res.getString(R.string.PREGUNTA16g);
		captura16h =res.getString(R.string.PREGUNTA16h);
		captura16i =res.getString(R.string.PREGUNTA16i);
		captura16j =res.getString(R.string.PREGUNTA16j);
		captura16k =res.getString(R.string.PREGUNTA16k);
		captura16l =res.getString(R.string.PREGUNTA16l);
		captura16m =res.getString(R.string.PREGUNTA16m);
		captura16n =res.getString(R.string.PREGUNTA16n);
		captura16o =res.getString(R.string.PREGUNTA16o);
		captura17 =res.getString(R.string.PREGUNTA17);
		captura17a =res.getString(R.string.PREGUNTA17a);
		captura17b =res.getString(R.string.PREGUNTA17b);
		captura18 =res.getString(R.string.PREGUNTA18);
		captura19 =res.getString(R.string.PREGUNTA19);
		captura19a =res.getString(R.string.PREGUNTA19a);
		captura19b =res.getString(R.string.PREGUNTA19b);
		captura19c =res.getString(R.string.PREGUNTA19c);
		captura19d =res.getString(R.string.PREGUNTA19d);
		captura19e =res.getString(R.string.PREGUNTA19e);
		captura20 =res.getString(R.string.PREGUNTA20);
		captura21 =res.getString(R.string.PREGUNTA21);
		captura22 =res.getString(R.string.PREGUNTA22);
		captura23 =res.getString(R.string.PREGUNTA23);
		captura24 =res.getString(R.string.PREGUNTA24);
		captura25 =res.getString(R.string.PREGUNTA25);
		captura26 =res.getString(R.string.PREGUNTA26);
		captura26a =res.getString(R.string.PREGUNTA26a);
		captura26b =res.getString(R.string.PREGUNTA26b);
		captura27 =res.getString(R.string.PREGUNTA27);
		captura27a =res.getString(R.string.PREGUNTA27a);
		captura27a1 =res.getString(R.string.PREGUNTA27a1);
		captura27a2 =res.getString(R.string.PREGUNTA27a2);
		captura27a3 =res.getString(R.string.PREGUNTA27a3);
		captura27a4 =res.getString(R.string.PREGUNTA27a4);
		captura28 =res.getString(R.string.PREGUNTA28);
		captura29 =res.getString(R.string.PREGUNTA29);
		captura29a =res.getString(R.string.PREGUNTA29a);
		captura29a1 =res.getString(R.string.PREGUNTA29a1);
		captura29a2 =res.getString(R.string.PREGUNTA29a2);
		captura30 =res.getString(R.string.PREGUNTA30);
		captura31 =res.getString(R.string.PREGUNTA31);
		captura32 =res.getString(R.string.PREGUNTA32);
		captura33 =res.getString(R.string.PREGUNTA33);

		lay1 = (LinearLayout) findViewById(R.id.lay1);
		lay2 = (LinearLayout) findViewById(R.id.lay2);
		lay3 = (LinearLayout) findViewById(R.id.lay3);
		lay4 = (LinearLayout) findViewById(R.id.lay4);
		lay5 = (LinearLayout) findViewById(R.id.lay5);
		lay6 = (LinearLayout) findViewById(R.id.lay6);
		lay7 = (LinearLayout) findViewById(R.id.lay7);
		lay8 = (LinearLayout) findViewById(R.id.lay8);
		lay9 = (LinearLayout) findViewById(R.id.lay9);
		lay10 = (LinearLayout) findViewById(R.id.lay10);
		lay11 = (LinearLayout) findViewById(R.id.lay11);
		lay12 = (LinearLayout) findViewById(R.id.lay12);
		lay13 = (LinearLayout) findViewById(R.id.lay13);
		lay13a = (LinearLayout) findViewById(R.id.lay13a);
		lay13b = (LinearLayout) findViewById(R.id.lay13b);
		lay13c = (LinearLayout) findViewById(R.id.lay13c);
		lay13d = (LinearLayout) findViewById(R.id.lay13d);
		lay14 = (LinearLayout) findViewById(R.id.lay14);
		lay14a = (LinearLayout) findViewById(R.id.lay14a);
		lay14b = (LinearLayout) findViewById(R.id.lay14b);
		lay14c = (LinearLayout) findViewById(R.id.lay14c);
		lay15 = (LinearLayout) findViewById(R.id.lay15);
		lay15a = (LinearLayout) findViewById(R.id.lay15a);
		lay16 = (LinearLayout) findViewById(R.id.lay16);
		lay16a = (LinearLayout) findViewById(R.id.lay16a);
		lay16b = (LinearLayout) findViewById(R.id.lay16b);
		lay16_1 = (LinearLayout) findViewById(R.id.lay16_1);
		lay16c = (LinearLayout) findViewById(R.id.lay16c);
		lay16d = (LinearLayout) findViewById(R.id.lay16d);
		lay16e = (LinearLayout) findViewById(R.id.lay16e);
		lay16f = (LinearLayout) findViewById(R.id.lay16f);
		lay16g = (LinearLayout) findViewById(R.id.lay16g);
		lay16h = (LinearLayout) findViewById(R.id.lay16h);
		lay16i = (LinearLayout) findViewById(R.id.lay16i);
		lay16j = (LinearLayout) findViewById(R.id.lay16j);
		lay16k = (LinearLayout) findViewById(R.id.lay16k);
		lay16l = (LinearLayout) findViewById(R.id.lay16l);
		lay16m = (LinearLayout) findViewById(R.id.lay16m);
		lay16n = (LinearLayout) findViewById(R.id.lay16n);
		lay16o = (LinearLayout) findViewById(R.id.lay16o);
		lay17 = (LinearLayout) findViewById(R.id.lay17);
		lay17a = (LinearLayout) findViewById(R.id.lay17a);
		lay17b = (LinearLayout) findViewById(R.id.lay17b);
		lay18 = (LinearLayout) findViewById(R.id.lay18);
		lay19 = (LinearLayout) findViewById(R.id.lay19);
		lay19a = (LinearLayout) findViewById(R.id.lay19a);
		lay19b = (LinearLayout) findViewById(R.id.lay19b);
		lay19c = (LinearLayout) findViewById(R.id.lay19c);
		lay19d = (LinearLayout) findViewById(R.id.lay19d);
		lay19e = (LinearLayout) findViewById(R.id.lay19e);
		lay20 = (LinearLayout) findViewById(R.id.lay20);
		lay21 = (LinearLayout) findViewById(R.id.lay21);
		lay22 = (LinearLayout) findViewById(R.id.lay22);
		lay23 = (LinearLayout) findViewById(R.id.lay23);
		lay24 = (LinearLayout) findViewById(R.id.lay24);
		lay25 = (LinearLayout) findViewById(R.id.lay25);
		lay26 = (LinearLayout) findViewById(R.id.lay26);
		lay26a = (LinearLayout) findViewById(R.id.lay26a);
		lay26b = (LinearLayout) findViewById(R.id.lay26b);
		lay27 = (LinearLayout) findViewById(R.id.lay27);
		lay27a = (LinearLayout) findViewById(R.id.lay27a);
		lay27a1 = (LinearLayout) findViewById(R.id.lay27a1);
		lay27a2 = (LinearLayout) findViewById(R.id.lay27a2);
		lay27a3 = (LinearLayout) findViewById(R.id.lay27a3);
		lay27a4 = (LinearLayout) findViewById(R.id.lay27a4);
		lay28 = (LinearLayout) findViewById(R.id.lay28);
		lay29 = (LinearLayout) findViewById(R.id.lay29);
		lay29a = (LinearLayout) findViewById(R.id.lay29a);
		lay29a1 = (LinearLayout) findViewById(R.id.lay29a1);
		lay29a2 = (LinearLayout) findViewById(R.id.lay29a2);
		lay30 = (LinearLayout) findViewById(R.id.lay30);
		lay31 = (LinearLayout) findViewById(R.id.lay31);
		lay32 = (LinearLayout) findViewById(R.id.lay32);
		lay33 = (LinearLayout) findViewById(R.id.lay33);
		lay34 = (LinearLayout) findViewById(R.id.lay34);
		
		radio_abandono1 = (RadioButton) findViewById(R.id.radio_abandono1);
		radio_abandono2 = (RadioButton) findViewById(R.id.radio_abandono2);
		radio_abandono3 = (RadioButton) findViewById(R.id.radio_abandono3);



	
		btnGuardar = (Button) findViewById(R.id.btnGuardar);
		btnSalir = (Button) findViewById(R.id.btnSalir);
		btnSalir.setEnabled(false);
		btnSalir.setVisibility(View.GONE);

		
editPregunta1.setText(formattedDate1);
editPregunta1.setEnabled(false);

editPregunta2.setText(cachaEscuela());
editPregunta3.setText(cachaCCT());
editPregunta4.setText(cachaDomicilio());
editPregunta6.setText(cachaCP());
editPregunta7.setText(cachaAlcaldia());



int matricula=Integer.parseInt(cachaMatricula());
Log.i(LOG_TAG, "=============> Matricula: "+matricula);

lay26a.setVisibility(View.GONE);
op26a="No aplica";
lay26b.setVisibility(View.GONE);
op26b="No aplica";





rdPregunta8.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op8 = "Sí";
			muestraTodo();
			radio_abandono1.setChecked(true);
		}
		else if (checkedId == R.id.radio2) {
			op8 = "No";
			ocultaTodo();
			radio_abandono2.setChecked(true);
//			tipoEncuesta = "ABANDONO";
//			valores("2");
//			dialogo();
		}
		else if (checkedId == R.id.radio0) {
			op8 = "Rechazó la entrevista";
			ocultaTodo();
			radio_abandono3.setChecked(true);
//			tipoEncuesta = "RECHAZO";
//			valores("3");
//			dialogo();
		}
	}
});

rdPregunta9.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op9 = "Ampliado";
			
		}
		else if (checkedId == R.id.radio2) {
			op9 = "Tiempo completo";
			
		}
		else if (checkedId == R.id.radio3) {
			op9 = "Matutino";
			
		}
		else if (checkedId == R.id.radio4) {
			op9 = "Vespertino";
		
		}
	}
});

//editPregunta9.addTextChangedListener(new TextWatcher() {
//	@Override
//	public void afterTextChanged(Editable s) {}
//	@Override
//	public void beforeTextChanged(CharSequence s, int start,int count, int after) {
//	}
//	@Override
//	public void onTextChanged(CharSequence s, int start,int before, int count) {
//		if(s.length() != 0){
//			rdPregunta9.clearCheck();
//		}
//	}
//});


editPregunta12.addTextChangedListener(new TextWatcher() {
	@Override
	public void afterTextChanged(Editable s) {
		
		
	}
	@Override
	public void beforeTextChanged(CharSequence s, int start,int count, int after) {
	}
	@Override
	public void onTextChanged(CharSequence s, int start,int before, int count) {
		if(s.length() != 0){
			
			String numMatricula=editPregunta12.getText().toString();
			
			if(editPregunta12.getText().toString().trim().length()==0){
				numMatricula="0";
				
			}
			
			int matricula=Integer.parseInt(numMatricula);
			
			if(matricula >= 100 && matricula <= 400){
				lay26a.setVisibility(View.VISIBLE);
				op26a="sin datos";
				lay26b.setVisibility(View.GONE);
				op26b="No aplica";
					
				}else if(matricula > 400 && matricula <= 600){
					lay26a.setVisibility(View.GONE);
					op26a="No aplica";
					lay26b.setVisibility(View.VISIBLE);
					op26b="sin datos";
				}else{
					lay26a.setVisibility(View.GONE);
					op26a="No aplica";
					lay26b.setVisibility(View.GONE);
					op26b="No aplica";
				}
			
			
		}
	}
});


rdPregunta13a.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op13a = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op13a = "No";
		}
	}
});

rdPregunta13b.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op13b = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op13b = "No";
		}
	}
});

rdPregunta13c.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op13c = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op13c = "No";
		}
	}
});



rdPregunta14.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op14 = "Sí";
			lay14a.setVisibility(View.VISIBLE);
			lay14b.setVisibility(View.VISIBLE);
			lay14c.setVisibility(View.VISIBLE);
			op14a="sin datos";
			op14b="sin datos";
			op14c="sin datos";
		}
		else if (checkedId == R.id.radio0) {
			op14 = "No";
			lay14a.setVisibility(View.GONE);
			lay14b.setVisibility(View.GONE);
			lay14c.setVisibility(View.GONE);
			op14a="No aplica";
			op14b="No aplica";
			op14c="No aplica";
		}
	}
});

rdPregunta14a.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op14a = "Autoridad Educativa Federal en la Ciudad de México (AEFCM)";
			editPregunta14a.setText("");
			
			lay18 .setVisibility(View.VISIBLE);
			lay19 .setVisibility(View.VISIBLE);
			lay19a .setVisibility(View.VISIBLE);
			lay19b .setVisibility(View.VISIBLE);
			lay19c .setVisibility(View.VISIBLE);
			lay19d .setVisibility(View.VISIBLE);
			lay19e .setVisibility(View.VISIBLE);
			lay20 .setVisibility(View.VISIBLE);
			lay21 .setVisibility(View.VISIBLE);
			
			op18="sin datos";
			op19="sin datos";
			op19a="sin datos";
			op19b="sin datos";
			op19c="sin datos";
			op19d="sin datos";
			op19e="sin datos";
			op20="sin datos";
			op21="sin datos";

			
		}
		else if (checkedId == R.id.radio2) {
			op14a = "DIF Ciudad de México";
			editPregunta14a.setText("");
			
			if(op14c.equals("Insumos alimentarios del Programa de Escuelas de Tiempo Completo de la AEFCM")){
				
				
			}else{
				
				lay18 .setVisibility(View.GONE);
				lay19 .setVisibility(View.GONE);
				lay19a .setVisibility(View.GONE);
				lay19b .setVisibility(View.GONE);
				lay19c .setVisibility(View.GONE);
				lay19d .setVisibility(View.GONE);
				lay19e .setVisibility(View.GONE);
				lay20 .setVisibility(View.GONE);
				lay21 .setVisibility(View.GONE);
				
				op18="No aplica";
				op19="No aplica";
				op19a="No aplica";
				op19b="No aplica";
				op19c="No aplica";
				op19d="No aplica";
				op19e="No aplica";
				op20="No aplica";
				op21="No aplica";
				
			}
			
		}
		else if (checkedId == R.id.radio0) {
			op14a = "Ambos";
			editPregunta14a.setText("");
			
			if(op14c.equals("Insumos alimentarios del Programa de Escuelas de Tiempo Completo de la AEFCM")){
				
				
			}else{
				
				lay18 .setVisibility(View.GONE);
				lay19 .setVisibility(View.GONE);
				lay19a .setVisibility(View.GONE);
				lay19b .setVisibility(View.GONE);
				lay19c .setVisibility(View.GONE);
				lay19d .setVisibility(View.GONE);
				lay19e .setVisibility(View.GONE);
				lay20 .setVisibility(View.GONE);
				lay21 .setVisibility(View.GONE);
				
				op18="No aplica";
				op19="No aplica";
				op19a="No aplica";
				op19b="No aplica";
				op19c="No aplica";
				op19d="No aplica";
				op19e="No aplica";
				op20="No aplica";
				op21="No aplica";
				
			}
		}
	}
});

editPregunta14a.addTextChangedListener(new TextWatcher() {
	@Override
	public void afterTextChanged(Editable s) {}
	@Override
	public void beforeTextChanged(CharSequence s, int start,int count, int after) {
	}
	@Override
	public void onTextChanged(CharSequence s, int start,int before, int count) {
		if(s.length() != 0){
			rdPregunta14a.clearCheck();
			
			
			if(op14c.equals("Insumos alimentarios del Programa de Escuelas de Tiempo Completo de la AEFCM")){
				
				
			}else{
				
				lay18 .setVisibility(View.GONE);
				lay19 .setVisibility(View.GONE);
				lay19a .setVisibility(View.GONE);
				lay19b .setVisibility(View.GONE);
				lay19c .setVisibility(View.GONE);
				lay19d .setVisibility(View.GONE);
				lay19e .setVisibility(View.GONE);
				lay20 .setVisibility(View.GONE);
				lay21 .setVisibility(View.GONE);
				
				op18="No aplica";
				op19="No aplica";
				op19a="No aplica";
				op19b="No aplica";
				op19c="No aplica";
				op19d="No aplica";
				op19e="No aplica";
				op20="No aplica";
				op21="No aplica";
				
			}
			
			
		}
	}
});

rdPregunta14b.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op14b = "Caliente";
		}
		else if (checkedId == R.id.radio2) {
			op14b = "Frio";
		}
		else if (checkedId == R.id.radio0) {
			op14b = "Ambos";
		}
	}
});

rdPregunta14c.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op14c = "Insumos alimentarios del Programa de Escuelas de Tiempo Completo de la AEFCM";
			editPregunta14c.setText("");
			
			lay18 .setVisibility(View.VISIBLE);
			lay19 .setVisibility(View.VISIBLE);
			lay19a .setVisibility(View.VISIBLE);
			lay19b .setVisibility(View.VISIBLE);
			lay19c .setVisibility(View.VISIBLE);
			lay19d .setVisibility(View.VISIBLE);
			lay19e .setVisibility(View.VISIBLE);
			lay20 .setVisibility(View.VISIBLE);
			lay21 .setVisibility(View.VISIBLE);
			
			op18="sin datos";
			op19="sin datos";
			op19a="sin datos";
			op19b="sin datos";
			op19c="sin datos";
			op19d="sin datos";
			op19e="sin datos";
			op20="sin datos";
			op21="sin datos";
			
		}
		else if (checkedId == R.id.radio2) {
			op14c = "Tarjeta de dispersión para alimentos calientes (DIF)";
			editPregunta14c.setText("");
			
		if(op14a.equals("Autoridad Educativa Federal en la Ciudad de México (AEFCM)")){
			
			
		}else{
			
			lay18 .setVisibility(View.GONE);
			lay19 .setVisibility(View.GONE);
			lay19a .setVisibility(View.GONE);
			lay19b .setVisibility(View.GONE);
			lay19c .setVisibility(View.GONE);
			lay19d .setVisibility(View.GONE);
			lay19e .setVisibility(View.GONE);
			lay20 .setVisibility(View.GONE);
			lay21 .setVisibility(View.GONE);
			
			op18="No aplica";
			op19="No aplica";
			op19a="No aplica";
			op19b="No aplica";
			op19c="No aplica";
			op19d="No aplica";
			op19e="No aplica";
			op20="No aplica";
			op21="No aplica";
			
		}
			
		}
		else if (checkedId == R.id.radio0) {
			op14c = "Alimento Frio (DIF, cereal, fruta, leche)";
			editPregunta14c.setText("");
			
			if(op14a.equals("Autoridad Educativa Federal en la Ciudad de México (AEFCM)")){
				
				
			}else{
				
				lay18 .setVisibility(View.GONE);
				lay19 .setVisibility(View.GONE);
				lay19a .setVisibility(View.GONE);
				lay19b .setVisibility(View.GONE);
				lay19c .setVisibility(View.GONE);
				lay19d .setVisibility(View.GONE);
				lay19e .setVisibility(View.GONE);
				lay20 .setVisibility(View.GONE);
				lay21 .setVisibility(View.GONE);
				
				op18="No aplica";
				op19="No aplica";
				op19a="No aplica";
				op19b="No aplica";
				op19c="No aplica";
				op19d="No aplica";
				op19e="No aplica";
				op20="No aplica";
				op21="No aplica";
				
			}
			
		}
	}
});

editPregunta14c.addTextChangedListener(new TextWatcher() {
	@Override
	public void afterTextChanged(Editable s) {}
	@Override
	public void beforeTextChanged(CharSequence s, int start,int count, int after) {
	}
	@Override
	public void onTextChanged(CharSequence s, int start,int before, int count) {
		if(s.length() != 0){
			rdPregunta14c.clearCheck();
			
			
			if(op14a.equals("Autoridad Educativa Federal en la Ciudad de México (AEFCM)")){
				
				
			}else{
				
				lay18 .setVisibility(View.GONE);
				lay19 .setVisibility(View.GONE);
				lay19a .setVisibility(View.GONE);
				lay19b .setVisibility(View.GONE);
				lay19c .setVisibility(View.GONE);
				lay19d .setVisibility(View.GONE);
				lay19e .setVisibility(View.GONE);
				lay20 .setVisibility(View.GONE);
				lay21 .setVisibility(View.GONE);
				
				op18="No aplica";
				op19="No aplica";
				op19a="No aplica";
				op19b="No aplica";
				op19c="No aplica";
				op19d="No aplica";
				op19e="No aplica";
				op20="No aplica";
				op21="No aplica";
				
			}
			
			
		}
	}
});

rdPregunta15.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op15 = "Muy Interesado";
			lay15a.setVisibility(View.GONE);
			op15a="No aplica";
		}
		else if (checkedId == R.id.radio2) {
			op15 = "Algo Interesado";
			lay15a.setVisibility(View.GONE);
			op15a="No aplica";
		}
		else if (checkedId == R.id.radio3) {
			op15 = "Poco Interesado";
			lay15a.setVisibility(View.GONE);
			op15a="No aplica";
		}
		else if (checkedId == R.id.radio0) {
			op15 = "Nada Interesado";
			lay15a.setVisibility(View.VISIBLE);
			op15a="sin datos";
		}
	}
});

rdPregunta16.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16 = "Sí";
			lay16a.setVisibility(View.VISIBLE);
			lay16b.setVisibility(View.VISIBLE);
			lay16_1.setVisibility(View.VISIBLE);
			lay16c.setVisibility(View.VISIBLE);
			lay16d.setVisibility(View.VISIBLE);
			lay16e.setVisibility(View.VISIBLE);
			lay16f.setVisibility(View.VISIBLE);
			lay16g.setVisibility(View.VISIBLE);
			lay16h.setVisibility(View.VISIBLE);
			lay16i.setVisibility(View.VISIBLE);
			lay16j.setVisibility(View.VISIBLE);
			lay16k.setVisibility(View.VISIBLE);
			lay16l.setVisibility(View.VISIBLE);
			lay16m.setVisibility(View.VISIBLE);
			lay16n.setVisibility(View.VISIBLE);
			lay16o.setVisibility(View.VISIBLE);
			op16a="sin datos";
			op16b="sin datos";
			op16c="sin datos";
			op16d="sin datos";
			op16e="sin datos";
			op16f="sin datos";
			op16g="sin datos";
			op16h="sin datos";
			op16i="sin datos";
			op16j="sin datos";
			op16k="sin datos";
			op16l="sin datos";
			op16m="sin datos";
			op16n="sin datos";
			op16o="sin datos";
			op16a="sin datos";
		}
		else if (checkedId == R.id.radio0) {
			op16 = "No";
			lay16a.setVisibility(View.GONE);
			lay16b.setVisibility(View.GONE);
			lay16_1.setVisibility(View.GONE);
			lay16c.setVisibility(View.GONE);
			lay16d.setVisibility(View.GONE);
			lay16e.setVisibility(View.GONE);
			lay16f.setVisibility(View.GONE);
			lay16g.setVisibility(View.GONE);
			lay16h.setVisibility(View.GONE);
			lay16i.setVisibility(View.GONE);
			lay16j.setVisibility(View.GONE);
			lay16k.setVisibility(View.GONE);
			lay16l.setVisibility(View.GONE);
			lay16m.setVisibility(View.GONE);
			lay16n.setVisibility(View.GONE);
			lay16o.setVisibility(View.GONE);
			op16a="No aplica";
			op16b="No aplica";
			op16c="No aplica";
			op16d="No aplica";
			op16e="No aplica";
			op16f="No aplica";
			op16g="No aplica";
			op16h="No aplica";
			op16i="No aplica";
			op16j="No aplica";
			op16k="No aplica";
			op16l="No aplica";
			op16m="No aplica";
			op16n="No aplica";
			op16o="No aplica";
		}
	}
});

rdPregunta16a.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16a = "Se construyó especialmente como cocina";
		}
		else if (checkedId == R.id.radio0) {
			op16a = "Se adaptó un espacio de la escuela para cocina";
		}
	}
});


rdPregunta16b.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16b = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op16b = "No";
		}
	}
});

rdPregunta16c.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16c = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op16c = "No";
		}
	}
});

rdPregunta16d.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16d = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op16d = "No";
		}
	}
});

rdPregunta16e.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16e = "Bueno";
		}
		else if (checkedId == R.id.radio2) {
			op16e = "Malo";
		}
		else if (checkedId == R.id.radio0) {
			op16e = "Regular";
		}
	}
});

rdPregunta16f.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16f = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op16f = "No";
		}
	}
});

rdPregunta16g.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16g = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op16g = "No";
		}
	}
});

rdPregunta16h.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16h = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op16h = "No";
		}
	}
});

rdPregunta16i.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16i = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op16i = "No";
		}
	}
});

rdPregunta16j.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16j = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op16j = "No";
		}
	}
});

rdPregunta16k.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16k = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op16k = "No";
		}
	}
});

rdPregunta16l.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16l = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op16l = "No";
		}
	}
});

rdPregunta16m.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16m = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op16m = "No";
		}
	}
});

rdPregunta16n.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16n = "Bueno";
		}
		else if (checkedId == R.id.radio2) {
			op16n = "Malo";
		}
		else if (checkedId == R.id.radio0) {
			op16n = "Regular";
		}
	}
});

rdPregunta16o.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op16o = "La escuela";
			editPregunta16o.setText("");
		}
		else if (checkedId == R.id.radio0) {
			op16o = "Proveedor externo";
			editPregunta16o.setText("");
		}
	}
});

editPregunta16o.addTextChangedListener(new TextWatcher() {
	@Override
	public void afterTextChanged(Editable s) {}
	@Override
	public void beforeTextChanged(CharSequence s, int start,int count, int after) {
	}
	@Override
	public void onTextChanged(CharSequence s, int start,int before, int count) {
		if(s.length() != 0){
			rdPregunta16o.clearCheck();
		}
	}
});

rdPregunta17.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op17 = "Sí";
			lay17a.setVisibility(View.VISIBLE);
			lay17b.setVisibility(View.VISIBLE);
			op17a="sin datos";
			editPregunta17b.setText("");
		}
		else if (checkedId == R.id.radio0) {
			op17 = "No";
			lay17a.setVisibility(View.GONE);
			lay17b.setVisibility(View.GONE);
			op17a="No aplica";
			editPregunta17b.setText("");
		}
	}
});

rdPregunta17a.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op17a = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op17a = "No";
		}
	}
});

rdPregunta18.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op18 = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op18 = "No";
		}
	}
});

rdPregunta19a.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op19a = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op19a = "No";
		}
	}
});

rdPregunta19b.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op19b = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op19b = "No";
		}
	}
});

rdPregunta19c.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op19c = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op19c = "No";
		}
	}
});

rdPregunta19d.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op19d = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op19d = "No";
		}
	}
});

rdPregunta19e.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op19e = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op19e = "No";
		}
	}
});

rdPregunta20.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op20 = "Recetas para la Escuela y el Hogar";
		}
		else if (checkedId == R.id.radio2) {
			op20 = "La cocina de mi escuela";
		}
		else if (checkedId == R.id.radio3) {
			op20 = "Ambas";
		}
		else if (checkedId == R.id.radio0) {
			op20 = "Ninguna";
		}
	}
});

rdPregunta21.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op21 = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op21 = "No";
		}
	}
});

rdPregunta22.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op22 = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op22 = "No";
		}
	}
});

rdPregunta23.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op23 = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op23 = "No";
		}
	}
});

rdPregunta24.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op24 = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op24 = "No";
		}
	}
});

rdPregunta25.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op25 = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op25 = "No";
		}
	}
});

rdPregunta26a.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op26a = "Sí";
		
		}
		else if (checkedId == R.id.radio0) {
			op26a = "No";
			
		}
	}
});

//editPregunta26a.addTextChangedListener(new TextWatcher() {
//	@Override
//	public void afterTextChanged(Editable s) {}
//	@Override
//	public void beforeTextChanged(CharSequence s, int start,int count, int after) {
//	}
//	@Override
//	public void onTextChanged(CharSequence s, int start,int before, int count) {
//		if(s.length() != 0){
//			rdPregunta26a.clearCheck();
//		}
//	}
//});

rdPregunta26b.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op26b = "Sí";
		
		}
		else if (checkedId == R.id.radio0) {
			op26b = "No";
			
		}
	}
});

//editPregunta26b.addTextChangedListener(new TextWatcher() {
//	@Override
//	public void afterTextChanged(Editable s) {}
//	@Override
//	public void beforeTextChanged(CharSequence s, int start,int count, int after) {
//	}
//	@Override
//	public void onTextChanged(CharSequence s, int start,int before, int count) {
//		if(s.length() != 0){
//			rdPregunta26b.clearCheck();
//		}
//	}
//});


rdPregunta27.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op27 = "Sí";
			
			lay27a .setVisibility(View.VISIBLE);
			lay27a1 .setVisibility(View.VISIBLE);
			lay27a2 .setVisibility(View.VISIBLE);
			lay27a3 .setVisibility(View.VISIBLE);
			lay27a4 .setVisibility(View.VISIBLE);

			op27a1="sin datos";
			op27a2="sin datos";
			op27a3="sin datos";
			op27a4="sin datos";
			
			
		}
		else if (checkedId == R.id.radio0) {
			op27 = "No";
			
			lay27a .setVisibility(View.GONE);
			lay27a1 .setVisibility(View.GONE);
			lay27a2 .setVisibility(View.GONE);
			lay27a3 .setVisibility(View.GONE);
			lay27a4 .setVisibility(View.GONE);

op27a1="No aplica";
op27a2="No aplica";
op27a3="No aplica";
op27a4="No aplica";
			
		}
	}
});

rdPregunta27a1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op27a1 = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op27a1 = "No";
		}
	}
});

rdPregunta27a2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op27a2 = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op27a2 = "No";
		}
	}
});

rdPregunta27a3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op27a3 = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op27a3 = "No";
		}
	}
});

rdPregunta27a4.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op27a4 = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op27a4 = "No";
		}
	}
});



rdPregunta29.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op29 = "Sí";
			
			lay29a .setVisibility(View.VISIBLE);
			lay29a1 .setVisibility(View.VISIBLE);
			lay29a2 .setVisibility(View.VISIBLE);

			op29a1="sin datos";
			op29a2="sin datos";

			
		}
		else if (checkedId == R.id.radio0) {
			op29 = "No";
			
			lay29a .setVisibility(View.GONE);
			lay29a1 .setVisibility(View.GONE);
			lay29a2 .setVisibility(View.GONE);

			op29a1="No aplica";
			op29a2="No aplica";
		}
	}
});


rdPregunta29a1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op29a1 = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op29a1 = "No";
		}
	}
});

rdPregunta29a2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op29a2 = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op29a2 = "No";
		}
	}
});

rdPregunta32.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		if (checkedId == R.id.radio1) {
			op32 = "Sí";
		}
		else if (checkedId == R.id.radio0) {
			op32 = "No";
		}
	}
});

		


		rdPreguntaAbandono.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio_abandono1) {
					opAbandono = "1";
					tipoEncuesta = "NORMAL";
					btnGuardar.setText("Guardar Normal");
				} else if (checkedId == R.id.radio_abandono2) {
					opAbandono = "2";
					tipoEncuesta = "ABANDONO";
					btnGuardar.setText("Guardar Abandono");
				} else if (checkedId == R.id.radio_abandono3) {
					opAbandono = "3";
					tipoEncuesta = "RECHAZO";
					btnGuardar.setText("Guardar Rechazo");
				}

			}
		});

	}

	////// FIN ONCREATE/////////////////////////////

	@Override
	protected void onPause() {
		super.onPause();

	}
	
	


	class CierraEncuesta extends TimerTask {

		@Override
		public void run() {

			dialogoCierraEncuesta();

		}

	}
	
	public void ocultaTodo(){
		
		lay9 .setVisibility(View.GONE);
		lay10 .setVisibility(View.GONE);
		lay11 .setVisibility(View.GONE);
		lay12 .setVisibility(View.GONE);
		lay13 .setVisibility(View.GONE);
		lay13a .setVisibility(View.GONE);
		lay13b .setVisibility(View.GONE);
		lay13c .setVisibility(View.GONE);
		lay13d .setVisibility(View.GONE);
		lay14 .setVisibility(View.GONE);
		lay14a .setVisibility(View.GONE);
		lay14b .setVisibility(View.GONE);
		lay14c .setVisibility(View.GONE);
		lay15 .setVisibility(View.GONE);
		lay15a .setVisibility(View.GONE);
		lay16 .setVisibility(View.GONE);
		lay16a .setVisibility(View.GONE);
		lay16b .setVisibility(View.GONE);
		lay16_1 .setVisibility(View.GONE);
		lay16c .setVisibility(View.GONE);
		lay16d .setVisibility(View.GONE);
		lay16e .setVisibility(View.GONE);
		lay16f .setVisibility(View.GONE);
		lay16g .setVisibility(View.GONE);
		lay16h .setVisibility(View.GONE);
		lay16i .setVisibility(View.GONE);
		lay16j .setVisibility(View.GONE);
		lay16k .setVisibility(View.GONE);
		lay16l .setVisibility(View.GONE);
		lay16m .setVisibility(View.GONE);
		lay16n .setVisibility(View.GONE);
		lay16o .setVisibility(View.GONE);
		lay17 .setVisibility(View.GONE);
		lay17a .setVisibility(View.GONE);
		lay17b .setVisibility(View.GONE);
		lay18 .setVisibility(View.GONE);
		lay19 .setVisibility(View.GONE);
		lay19a .setVisibility(View.GONE);
		lay19b .setVisibility(View.GONE);
		lay19c .setVisibility(View.GONE);
		lay19d .setVisibility(View.GONE);
		lay19e .setVisibility(View.GONE);
		lay20 .setVisibility(View.GONE);
		lay21 .setVisibility(View.GONE);
		lay22 .setVisibility(View.GONE);
		lay23 .setVisibility(View.GONE);
		lay24 .setVisibility(View.GONE);
		lay25 .setVisibility(View.GONE);
		lay26 .setVisibility(View.GONE);
		lay26a .setVisibility(View.GONE);
		lay26b .setVisibility(View.GONE);
		lay27 .setVisibility(View.GONE);
		lay27a .setVisibility(View.GONE);
		lay27a1 .setVisibility(View.GONE);
		lay27a2 .setVisibility(View.GONE);
		lay27a3 .setVisibility(View.GONE);
		lay27a4 .setVisibility(View.GONE);
		lay28 .setVisibility(View.GONE);
		lay29 .setVisibility(View.GONE);
		lay29a .setVisibility(View.GONE);
		lay29a1 .setVisibility(View.GONE);
		lay29a2 .setVisibility(View.GONE);
		lay30 .setVisibility(View.GONE);
		lay31 .setVisibility(View.GONE);
		lay32 .setVisibility(View.GONE);
		lay33 .setVisibility(View.GONE);
		lay34 .setVisibility(View.GONE);

		
		op9 ="No aplica";
		editPregunta10.setText("");
		editPregunta11.setText("");
		editPregunta12.setText("");
		
		op13a ="No aplica";
		op13b ="No aplica";
		op13c ="No aplica";
		editPregunta13d.setText("");
		op14 ="No aplica";
		op14a ="No aplica";
		op14b ="No aplica";
		op14c ="No aplica";
		op15 ="No aplica";
		editPregunta15a.setText("");
		op16 ="No aplica";
		op16a ="No aplica";
		op16b ="No aplica";
		op16_1 ="No aplica";
		op16c ="No aplica";
		op16d ="No aplica";
		op16e ="No aplica";
		op16f ="No aplica";
		op16g ="No aplica";
		op16h ="No aplica";
		op16i ="No aplica";
		op16j ="No aplica";
		op16k ="No aplica";
		op16l ="No aplica";
		op16m ="No aplica";
		op16n ="No aplica";
		op16o ="No aplica";
		op17 ="No aplica";
		op17a ="No aplica";
		editPregunta17b.setText("");
		op18 ="No aplica";
		op19 ="No aplica";
		op19a ="No aplica";
		op19b ="No aplica";
		op19c ="No aplica";
		op19d ="No aplica";
		op19e ="No aplica";
		op20 ="No aplica";
		op21 ="No aplica";
		op22 ="No aplica";
		op23 ="No aplica";
		op24 ="No aplica";
		op25 ="No aplica";
		op26 ="No aplica";
		op26a ="No aplica";
		op26b ="No aplica";
		op27 ="No aplica";
		op27a ="No aplica";
		op27a1 ="No aplica";
		op27a2 ="No aplica";
		op27a3 ="No aplica";
		op27a4 ="No aplica";
		editPregunta28.setText("");
		op29 ="No aplica";
		op29a ="No aplica";
		op29a1 ="No aplica";
		op29a2 ="No aplica";
		editPregunta30.setText("");
		editPregunta31.setText("");
		op32 ="No aplica";
		editPregunta33.setText("");

	}
	
public void muestraTodo(){
		
		lay9 .setVisibility(View.VISIBLE);
		lay10 .setVisibility(View.VISIBLE);
		lay11 .setVisibility(View.VISIBLE);
		lay12 .setVisibility(View.VISIBLE);
		lay13 .setVisibility(View.VISIBLE);
		lay13a .setVisibility(View.VISIBLE);
		lay13b .setVisibility(View.VISIBLE);
		lay13c .setVisibility(View.VISIBLE);
		lay13d .setVisibility(View.VISIBLE);
		lay14 .setVisibility(View.VISIBLE);
		lay14a .setVisibility(View.VISIBLE);
		lay14b .setVisibility(View.VISIBLE);
		lay14c .setVisibility(View.VISIBLE);
		lay15 .setVisibility(View.VISIBLE);
		lay15a .setVisibility(View.VISIBLE);
		lay16 .setVisibility(View.VISIBLE);
		lay16a .setVisibility(View.VISIBLE);
		lay16b .setVisibility(View.VISIBLE);
		lay16_1 .setVisibility(View.VISIBLE);
		lay16c .setVisibility(View.VISIBLE);
		lay16d .setVisibility(View.VISIBLE);
		lay16e .setVisibility(View.VISIBLE);
		lay16f .setVisibility(View.VISIBLE);
		lay16g .setVisibility(View.VISIBLE);
		lay16h .setVisibility(View.VISIBLE);
		lay16i .setVisibility(View.VISIBLE);
		lay16j .setVisibility(View.VISIBLE);
		lay16k .setVisibility(View.VISIBLE);
		lay16l .setVisibility(View.VISIBLE);
		lay16m .setVisibility(View.VISIBLE);
		lay16n .setVisibility(View.VISIBLE);
		lay16o .setVisibility(View.VISIBLE);
		lay17 .setVisibility(View.VISIBLE);
		lay17a .setVisibility(View.VISIBLE);
		lay17b .setVisibility(View.VISIBLE);
		lay18 .setVisibility(View.VISIBLE);
		lay19 .setVisibility(View.VISIBLE);
		lay19a .setVisibility(View.VISIBLE);
		lay19b .setVisibility(View.VISIBLE);
		lay19c .setVisibility(View.VISIBLE);
		lay19d .setVisibility(View.VISIBLE);
		lay19e .setVisibility(View.VISIBLE);
		lay20 .setVisibility(View.VISIBLE);
		lay21 .setVisibility(View.VISIBLE);
		lay22 .setVisibility(View.VISIBLE);
		lay23 .setVisibility(View.VISIBLE);
		lay24 .setVisibility(View.VISIBLE);
		lay25 .setVisibility(View.VISIBLE);
		lay26 .setVisibility(View.VISIBLE);
		lay26a .setVisibility(View.VISIBLE);
		lay26b .setVisibility(View.VISIBLE);
		lay27 .setVisibility(View.VISIBLE);
		lay27a .setVisibility(View.VISIBLE);
		lay27a1 .setVisibility(View.VISIBLE);
		lay27a2 .setVisibility(View.VISIBLE);
		lay27a3 .setVisibility(View.VISIBLE);
		lay27a4 .setVisibility(View.VISIBLE);
		lay28 .setVisibility(View.VISIBLE);
		lay29 .setVisibility(View.VISIBLE);
		lay29a .setVisibility(View.VISIBLE);
		lay29a1 .setVisibility(View.VISIBLE);
		lay29a2 .setVisibility(View.VISIBLE);
		lay30 .setVisibility(View.VISIBLE);
		lay31 .setVisibility(View.VISIBLE);
		lay32 .setVisibility(View.VISIBLE);
		lay33 .setVisibility(View.VISIBLE);
		lay34 .setVisibility(View.VISIBLE);

		
		op9 ="sin datos";
		editPregunta10.setText("");
		editPregunta11.setText("");
		editPregunta12.setText("");
		
		op13a ="sin datos";
		op13b ="sin datos";
		op13c ="sin datos";
		editPregunta13d.setText("");
		op14 ="sin datos";
		op14a ="sin datos";
		op14b ="sin datos";
		op14c ="sin datos";
		op15 ="sin datos";
		editPregunta15a.setText("");
		op16 ="sin datos";
		op16a ="sin datos";
		op16b ="sin datos";
		op16_1 ="sin datos";
		op16c ="sin datos";
		op16d ="sin datos";
		op16e ="sin datos";
		op16f ="sin datos";
		op16g ="sin datos";
		op16h ="sin datos";
		op16i ="sin datos";
		op16j ="sin datos";
		op16k ="sin datos";
		op16l ="sin datos";
		op16m ="sin datos";
		op16n ="sin datos";
		op16o ="sin datos";
		op17 ="sin datos";
		op17a ="sin datos";
		editPregunta17b.setText("");
		op18 ="sin datos";
		op19 ="sin datos";
		op19a ="sin datos";
		op19b ="sin datos";
		op19c ="sin datos";
		op19d ="sin datos";
		op19e ="sin datos";
		op20 ="sin datos";
		op21 ="sin datos";
		op22 ="sin datos";
		op23 ="sin datos";
		op24 ="sin datos";
		op25 ="sin datos";
		op26 ="sin datos";
		op26a ="sin datos";
		op26b ="sin datos";
		op27 ="sin datos";
		op27a ="sin datos";
		op27a1 ="sin datos";
		op27a2 ="sin datos";
		op27a3 ="sin datos";
		op27a4 ="sin datos";
		editPregunta28.setText("");
		op29 ="sin datos";
		op29a ="sin datos";
		op29a1 ="sin datos";
		op29a2 ="sin datos";
		editPregunta30.setText("");
		editPregunta31.setText("");
		op32 ="sin datos";
		editPregunta33.setText("");

	}

	public void drawResults() {
		for (CheckBox c : mChecks) {
			c.setChecked(mSelectedChecks.contains(c));
		}
	}

	public void drawResults2() {
		for (CheckBox d : mChecks2) {
			d.setChecked(mSelectedChecks2.contains(d));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void valores() {

		String str = "";

		String seg = formattedDate5.substring(7);
		System.out.println("El segundo: " + seg);
		System.out.println("El IMEI" + sacaImei());

		String mes = formattedDate6.toString();
		System.out.println("El mes" + mes);

		String dia = formattedDate7.toString();
		System.out.println("El dia" + dia);

		sacaChip();

		cachaNombre();

		
		String strId = String.valueOf(rand + 1);

		elMaximo = Integer.parseInt(sacaMaximo().toString()) + 1;


		String strText1=editPregunta1.getText().toString();
		String strText2=editPregunta2.getText().toString();
		String strText3=editPregunta3.getText().toString();
		String strText4=editPregunta4.getText().toString();
		String strText5=editPregunta5.getText().toString();
		String strText6=editPregunta6.getText().toString();
		String strText7=editPregunta7.getText().toString();
		
//		String strText9;
//		if(editPregunta9.getText().toString().trim().length()==0){
//		strText9=op9;
//		}else{
//		strText9=editPregunta9.getText().toString().trim();
//		rdPregunta9.clearCheck();
//		}
		
		String strText10=editPregunta10.getText().toString();
		String strText11=editPregunta11.getText().toString();
		String strText12=editPregunta12.getText().toString();
		String strText13d=editPregunta13d.getText().toString();
		
		String strText14a;
		if(editPregunta14a.getText().toString().trim().length()==0){
		strText14a=op14a;
		}else{
		strText14a=editPregunta14a.getText().toString().trim();
		rdPregunta14a.clearCheck();
		}
		
		String strText14c;
		if(editPregunta14c.getText().toString().trim().length()==0){
		strText14c=op14c;
		}else{
		strText14c=editPregunta14c.getText().toString().trim();
		rdPregunta14c.clearCheck();
		}

		
		String strText15a=editPregunta15a.getText().toString();
		
		String strText16o;
		if(editPregunta16o.getText().toString().trim().length()==0){
		strText16o=op16o;
		}else{
		strText16o=editPregunta16o.getText().toString().trim();
		rdPregunta16o.clearCheck();
		}
		
		String strText17b=editPregunta17b.getText().toString();
		
//		String strText26a;
//		if(editPregunta26a.getText().toString().trim().length()==0){
//		strText26a=op26a;
//		}else{
//		strText26a=editPregunta26a.getText().toString().trim();
//		rdPregunta26a.clearCheck();
//		}
		
		
//		String strText26b;
//		if(editPregunta26b.getText().toString().trim().length()==0){
//		strText26b=op26b;
//		}else{
//		strText26b=editPregunta26b.getText().toString().trim();
//		rdPregunta26b.clearCheck();
//		}
		
		String strText28=editPregunta28.getText().toString();
		
		String strText30=editPregunta30.getText().toString();
		String strText31=editPregunta31.getText().toString();
		String strText33=editPregunta33.getText().toString();
		
		String str1 = strText1;
		String str2 = strText2;
		String str3 = strText3;
		String str4 = strText4;
		String str5 = strText5;
		String str6 = strText6;
		String str7 = strText7;
		String str8 = op8;
		String str9 = op9;
		String str10 = strText10;
		String str11 = strText11;
		String str12 = strText12;
		String str13 = "cabecera pregunta";
		String str13a = op13a;
		String str13b = op13b;
		String str13c = op13c;
		String str13d = strText13d;
		String str14 = op14;
		String str14a = strText14a;
		String str14b = op14b;
		String str14c = strText14c;
		String str15 = op15;
		String str15a = strText15a;
		String str16 = op16;
		String str16a = op16a;
		String str16b = op16b;
		String str16_1 = "cabecera pregunta";
		String str16c = op16c;
		String str16d = op16d;
		String str16e = op16e;
		String str16f = op16f;
		String str16g = op16g;
		String str16h = op16h;
		String str16i = op16i;
		String str16j = op16j;
		String str16k = op16k;
		String str16l = op16l;
		String str16m = op16m;
		String str16n = op16n;
		String str16o = strText16o;
		String str17 = op17;
		String str17a = op17a;
		String str17b = editPregunta17b.getText().toString();
		String str18 = op18;
		String str19 = "cabecera pregunta";
		String str19a = op19a;
		String str19b = op19b;
		String str19c = op19c;
		String str19d = op19d;
		String str19e = op19e;
		String str20 = op20;
		String str21 = op21;
		String str22 = op22;
		String str23 = op23;
		String str24 = op24;
		String str25 = op25;
		String str26 = "cabecera pregunta";
		String str26a = op26a;
		String str26b = op26b;
		String str27 = op27;
		String str27a = "cabecera pregunta";
		String str27a1 = op27a1;
		String str27a2 = op27a2;
		String str27a3 = op27a3;
		String str27a4 = op27a4;
		String str28 = strText28;
		String str29 = op29;
		String str29a = "cabecera pregunta";
		String str29a1 = op29a1;
		String str29a2 = op29a2;
		String str30 = strText30;
		String str31 = strText31;
		String str32 = op32;
		String str33 = strText33;
		String str35 = "Sin fotografía";

		String strAbandono = opAbandono;

		if (strAbandono.matches("1")) {
			tipoEncuesta = "NORMAL";
		}

		

		String strFinal = "\n";

		// Clase que permite grabar texto en un archivo
		FileOutputStream fout = null;
		try {
			// INSERTA EN LA BASE DE DATOS //

			final String F = "File dbfile";

			String DATABASE_NAME = Environment.getExternalStorageDirectory() + "/Mis_archivos/" + nombreEncuesta + "_"
					+ sacaImei() + "";

			// Abrimos la base de datos 'DBUsuarios' en modo escritura
			usdbh = new UsuariosSQLiteHelper(this, "F", null, 1, DATABASE_NAME);

			db = usdbh.getWritableDatabase();

			// NORMAL
			Nombre nom = new Nombre();
			String nombreE = nom.nombreEncuesta();

			GPSTracker gps = new GPSTracker(this);
			latitude = gps.getLatitude();
			longitude = gps.getLongitude();

			if (latitude == 0.0) {
				latitude = Double.valueOf(sacaLatitud());
			}

			if (longitude == 0.0) {
				longitude = Double.valueOf(sacaLongitud());
			}

			String strLatitud = String.valueOf(latitude);
			String strLongitud = String.valueOf(longitude);

			if (db != null) {
				ContentValues values = new ContentValues();
				values.put("consecutivo_diario", elMaximo);
				values.put("equipo", "DIF");
				values.put("usuario", cachaNombre().toUpperCase());
				values.put("nombre_encuesta", nombreE.toUpperCase());
				values.put("fecha", formattedDate1);
				values.put("hora", formattedDate5);
				values.put("imei", sacaImei());
				values.put("latitud", strLatitud);
				values.put("longitud", strLongitud);

				values.put("pregunta_1",str1);
				values.put("pregunta_2",str2);
				values.put("pregunta_3",str3);
				values.put("pregunta_4",str4);
				values.put("pregunta_5",str5);
				values.put("pregunta_6",str6);
				values.put("pregunta_7",str7);
				values.put("pregunta_8",str8);
				values.put("pregunta_9",str9);
				values.put("pregunta_10",str10);
				values.put("pregunta_11",str11);
				values.put("pregunta_12",str12);
				values.put("pregunta_13",str13);
				values.put("pregunta_13a",str13a);
				values.put("pregunta_13b",str13b);
				values.put("pregunta_13c",str13c);
				values.put("pregunta_13d",str13d);
				values.put("pregunta_14",str14);
				values.put("pregunta_14a",str14a);
				values.put("pregunta_14b",str14b);
				values.put("pregunta_14c",str14c);
				values.put("pregunta_15",str15);
				values.put("pregunta_15a",str15a);
				values.put("pregunta_16",str16);
				values.put("pregunta_16a",str16a);
				values.put("pregunta_16b",str16b);
				values.put("pregunta_16_1",str16_1);
				values.put("pregunta_16c",str16c);
				values.put("pregunta_16d",str16d);
				values.put("pregunta_16e",str16e);
				values.put("pregunta_16f",str16f);
				values.put("pregunta_16g",str16g);
				values.put("pregunta_16h",str16h);
				values.put("pregunta_16i",str16i);
				values.put("pregunta_16j",str16j);
				values.put("pregunta_16k",str16k);
				values.put("pregunta_16l",str16l);
				values.put("pregunta_16m",str16m);
				values.put("pregunta_16n",str16n);
				values.put("pregunta_16o",str16o);
				values.put("pregunta_17",str17);
				values.put("pregunta_17a",str17a);
				values.put("pregunta_17b",str17b);
				values.put("pregunta_18",str18);
				values.put("pregunta_19",str19);
				values.put("pregunta_19a",str19a);
				values.put("pregunta_19b",str19b);
				values.put("pregunta_19c",str19c);
				values.put("pregunta_19d",str19d);
				values.put("pregunta_19e",str19e);
				values.put("pregunta_20",str20);
				values.put("pregunta_21",str21);
				values.put("pregunta_22",str22);
				values.put("pregunta_23",str23);
				values.put("pregunta_24",str24);
				values.put("pregunta_25",str25);
				values.put("pregunta_26",str26);
				values.put("pregunta_26a",str26a);
				values.put("pregunta_26b",str26b);
				values.put("pregunta_27",str27);
				values.put("pregunta_27a",str27a);
				values.put("pregunta_27a1",str27a1);
				values.put("pregunta_27a2",str27a2);
				values.put("pregunta_27a3",str27a3);
				values.put("pregunta_27a4",str27a4);
				values.put("pregunta_28",str28);
				values.put("pregunta_29",str29);
				values.put("pregunta_29a",str29a);
				values.put("pregunta_29a1",str29a1);
				values.put("pregunta_29a2",str29a2);
				values.put("pregunta_30",str30);
				values.put("pregunta_31",str31);
				values.put("pregunta_32",str32);
				values.put("pregunta_33",str33);
				values.put("foto_croquis",str35);


				values.put("abandono", strAbandono.toUpperCase());

				
				values.put("tiempo", elTiempo());
				values.put("tipocaptura", tipoEncuesta);

				db.insert("encuestas", null, values);
			}
			db.close();

			System.out.println("Latitud  " + strLatitud);
			System.out.println("Longitud  " + strLongitud);

			System.out.println("pregunta_1  " +   str1);
			System.out.println("pregunta_2  " +   str2);
			System.out.println("pregunta_3  " +   str3);
			System.out.println("pregunta_4  " +   str4);
			System.out.println("pregunta_5  " +   str5);
			System.out.println("pregunta_6  " +   str6);
			System.out.println("pregunta_7  " +   str7);
			System.out.println("pregunta_8  " +   str8);
			System.out.println("pregunta_9  " +   str9);
			System.out.println("pregunta_10  " +   str10);
			System.out.println("pregunta_11  " +   str11);
			System.out.println("pregunta_12  " +   str12);
			System.out.println("pregunta_13  " +   str13);
			System.out.println("pregunta_13a  " +   str13a);
			System.out.println("pregunta_13b  " +   str13b);
			System.out.println("pregunta_13c  " +   str13c);
			System.out.println("pregunta_13d  " +   str13d);
			System.out.println("pregunta_14  " +   str14);
			System.out.println("pregunta_14a  " +   str14a);
			System.out.println("pregunta_14b  " +   str14b);
			System.out.println("pregunta_14c  " +   str14c);
			System.out.println("pregunta_15  " +   str15);
			System.out.println("pregunta_15a  " +   str15a);
			System.out.println("pregunta_16  " +   str16);
			System.out.println("pregunta_16a  " +   str16a);
			System.out.println("pregunta_16b  " +   str16b);
			System.out.println("pregunta_16_1  " +   str16_1);
			System.out.println("pregunta_16c  " +   str16c);
			System.out.println("pregunta_16d  " +   str16d);
			System.out.println("pregunta_16e  " +   str16e);
			System.out.println("pregunta_16f  " +   str16f);
			System.out.println("pregunta_16g  " +   str16g);
			System.out.println("pregunta_16h  " +   str16h);
			System.out.println("pregunta_16i  " +   str16i);
			System.out.println("pregunta_16j  " +   str16j);
			System.out.println("pregunta_16k  " +   str16k);
			System.out.println("pregunta_16l  " +   str16l);
			System.out.println("pregunta_16m  " +   str16m);
			System.out.println("pregunta_16n  " +   str16n);
			System.out.println("pregunta_16o  " +   str16o);
			System.out.println("pregunta_17  " +   str17);
			System.out.println("pregunta_17a  " +   str17a);
			System.out.println("pregunta_17b  " +   str17b);
			System.out.println("pregunta_18  " +   str18);
			System.out.println("pregunta_19  " +   str19);
			System.out.println("pregunta_19a  " +   str19a);
			System.out.println("pregunta_19b  " +   str19b);
			System.out.println("pregunta_19c  " +   str19c);
			System.out.println("pregunta_19d  " +   str19d);
			System.out.println("pregunta_19e  " +   str19e);
			System.out.println("pregunta_20  " +   str20);
			System.out.println("pregunta_21  " +   str21);
			System.out.println("pregunta_22  " +   str22);
			System.out.println("pregunta_23  " +   str23);
			System.out.println("pregunta_24  " +   str24);
			System.out.println("pregunta_25  " +   str25);
			System.out.println("pregunta_26  " +   str26);
			System.out.println("pregunta_26a  " +   str26a);
			System.out.println("pregunta_26b  " +   str26b);
			System.out.println("pregunta_27  " +   str27);
			System.out.println("pregunta_27a  " +   str27a);
			System.out.println("pregunta_27a1  " +   str27a1);
			System.out.println("pregunta_27a2  " +   str27a2);
			System.out.println("pregunta_27a3  " +   str27a3);
			System.out.println("pregunta_27a4  " +   str27a4);
			System.out.println("pregunta_28  " +   str28);
			System.out.println("pregunta_29  " +   str29);
			System.out.println("pregunta_29a  " +   str29a);
			System.out.println("pregunta_29a1  " +   str29a1);
			System.out.println("pregunta_29a2  " +   str29a2);
			System.out.println("pregunta_30  " +   str30);
			System.out.println("pregunta_31  " +   str31);
			System.out.println("pregunta_32  " +   str32);
			System.out.println("pregunta_33  " +   str33);
			System.out.println("foto_croquis  " +   str35);


			System.out.println("abandono  " + strAbandono);
			System.out.println("tipocaptura  " + tipoEncuesta );

			

			// FIN INSERTA BASE DE DATOS //

		} catch (Exception e) {
			String stackTrace = Log.getStackTraceString(e);
		      Log.i(LOG_TAG,"============> algo pasó "+ stackTrace);
			
		}

	}

	public void guardar(View v) {
		System.out.println(cachaAlcaldia());

		timer.cancel();

		String str = "";

		if (opAbandono.matches("sin datos")) {
			opAbandono = "1";
		}

		int tipo = Integer.parseInt(opAbandono);

		switch (tipo) {
		case 1:

			
			  if (lay1.getVisibility() == 0 && op1.matches("sin datos") && editPregunta1.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura1,Toast.LENGTH_LONG).show();}
			  else if (lay2.getVisibility() == 0 && op2.matches("sin datos") && editPregunta2.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura2,Toast.LENGTH_LONG).show();}
			  else if (lay3.getVisibility() == 0 && op3.matches("sin datos") && editPregunta3.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura3,Toast.LENGTH_LONG).show();}
			  else if (lay4.getVisibility() == 0 && op4.matches("sin datos") && editPregunta4.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura4,Toast.LENGTH_LONG).show();}
			  else if (lay5.getVisibility() == 0 && op5.matches("sin datos") && editPregunta5.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura5,Toast.LENGTH_LONG).show();}
			  else if (lay6.getVisibility() == 0 && op6.matches("sin datos") && editPregunta6.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura6,Toast.LENGTH_LONG).show();}
			  else if (lay7.getVisibility() == 0 && op7.matches("sin datos") && editPregunta7.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura7,Toast.LENGTH_LONG).show();}
			  else if (lay8.getVisibility() == 0 && op8.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura8,Toast.LENGTH_LONG).show();}
			  else if (lay9.getVisibility() == 0 && op9.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura9,Toast.LENGTH_LONG).show();}
				else if (lay10.getVisibility() == 0 && op10.matches("sin datos") && editPregunta10.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura10,Toast.LENGTH_LONG).show();}
				else if (lay11.getVisibility() == 0 && op11.matches("sin datos") && editPregunta11.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura11,Toast.LENGTH_LONG).show();}
				else if (lay12.getVisibility() == 0 && op12.matches("sin datos") && editPregunta12.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura12,Toast.LENGTH_LONG).show();}
			  else if (lay13a.getVisibility() == 0 && op13a.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura13a,Toast.LENGTH_LONG).show();}
			  else if (lay13b.getVisibility() == 0 && op13b.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura13b,Toast.LENGTH_LONG).show();}
			  else if (lay13c.getVisibility() == 0 && op13c.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura13c,Toast.LENGTH_LONG).show();}
//			  else if (lay13d.getVisibility() == 0 && editPregunta13d.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura13d,Toast.LENGTH_LONG).show();}
			  else if (lay14.getVisibility() == 0 && op14.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura14,Toast.LENGTH_LONG).show();}
			  else if (lay14a.getVisibility() == 0 && op14a.matches("sin datos") && editPregunta14a.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura14a,Toast.LENGTH_LONG).show();}
			  else if (lay14b.getVisibility() == 0 && op14b.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura14b,Toast.LENGTH_LONG).show();}
			  else if (lay14c.getVisibility() == 0 && op14c.matches("sin datos") && editPregunta14c.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura14c,Toast.LENGTH_LONG).show();}
			  else if (lay15.getVisibility() == 0 && op15.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura15,Toast.LENGTH_LONG).show();}
			  else if (lay15a.getVisibility() == 0 && op15a.matches("sin datos") && editPregunta15a.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura15a,Toast.LENGTH_LONG).show();}
			  else if (lay16.getVisibility() == 0 && op16.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16,Toast.LENGTH_LONG).show();}
			  else if (lay16a.getVisibility() == 0 && op16a.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16a,Toast.LENGTH_LONG).show();}
			  else if (lay16b.getVisibility() == 0 && op16b.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16b,Toast.LENGTH_LONG).show();}
			  else if (lay16c.getVisibility() == 0 && op16c.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16c,Toast.LENGTH_LONG).show();}
			  else if (lay16d.getVisibility() == 0 && op16d.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16d,Toast.LENGTH_LONG).show();}
			  else if (lay16e.getVisibility() == 0 && op16e.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16e,Toast.LENGTH_LONG).show();}
			  else if (lay16f.getVisibility() == 0 && op16f.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16f,Toast.LENGTH_LONG).show();}
			  else if (lay16g.getVisibility() == 0 && op16g.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16g,Toast.LENGTH_LONG).show();}
			  else if (lay16h.getVisibility() == 0 && op16h.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16h,Toast.LENGTH_LONG).show();}
			  else if (lay16i.getVisibility() == 0 && op16i.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16i,Toast.LENGTH_LONG).show();}
			  else if (lay16j.getVisibility() == 0 && op16j.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16j,Toast.LENGTH_LONG).show();}
			  else if (lay16k.getVisibility() == 0 && op16k.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16k,Toast.LENGTH_LONG).show();}
			  else if (lay16l.getVisibility() == 0 && op16l.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16l,Toast.LENGTH_LONG).show();}
			  else if (lay16m.getVisibility() == 0 && op16m.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16m,Toast.LENGTH_LONG).show();}
			  else if (lay16n.getVisibility() == 0 && op16n.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16n,Toast.LENGTH_LONG).show();}
			  else if (lay16o.getVisibility() == 0 && op16o.matches("sin datos") && editPregunta16o.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16o,Toast.LENGTH_LONG).show();}
			  else if (lay17.getVisibility() == 0 && op17.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura17,Toast.LENGTH_LONG).show();}
			  else if (lay17a.getVisibility() == 0 && op17a.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura17a,Toast.LENGTH_LONG).show();}
			  else if (lay17b.getVisibility() == 0 && op17b.matches("sin datos") && editPregunta17b.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura17b,Toast.LENGTH_LONG).show();}
			  else if (lay18.getVisibility() == 0 && op18.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura18,Toast.LENGTH_LONG).show();}
			  else if (lay19a.getVisibility() == 0 && op19a.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura19a,Toast.LENGTH_LONG).show();}
			  else if (lay19b.getVisibility() == 0 && op19b.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura19b,Toast.LENGTH_LONG).show();}
			  else if (lay19c.getVisibility() == 0 && op19c.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura19c,Toast.LENGTH_LONG).show();}
			  else if (lay19d.getVisibility() == 0 && op19d.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura19d,Toast.LENGTH_LONG).show();}
			  else if (lay19e.getVisibility() == 0 && op19e.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura19e,Toast.LENGTH_LONG).show();}
			  else if (lay20.getVisibility() == 0 && op20.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura20,Toast.LENGTH_LONG).show();}
			  else if (lay21.getVisibility() == 0 && op21.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura21,Toast.LENGTH_LONG).show();}
			  else if (lay22.getVisibility() == 0 && op22.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura22,Toast.LENGTH_LONG).show();}
			  else if (lay23.getVisibility() == 0 && op23.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura23,Toast.LENGTH_LONG).show();}
			  else if (lay24.getVisibility() == 0 && op24.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura24,Toast.LENGTH_LONG).show();}
			  else if (lay25.getVisibility() == 0 && op25.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura25,Toast.LENGTH_LONG).show();}
			  else if (lay26a.getVisibility() == 0 && op26a.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura26a,Toast.LENGTH_LONG).show();}
			  else if (lay26b.getVisibility() == 0 && op26b.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura26b,Toast.LENGTH_LONG).show();}
			  else if (lay27.getVisibility() == 0 && op27.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura27,Toast.LENGTH_LONG).show();}
			  else if (lay27a1.getVisibility() == 0 && op27a1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura27a1,Toast.LENGTH_LONG).show();}
			  else if (lay27a2.getVisibility() == 0 && op27a2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura27a2,Toast.LENGTH_LONG).show();}
			  else if (lay27a3.getVisibility() == 0 && op27a3.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura27a3,Toast.LENGTH_LONG).show();}
			  else if (lay27a4.getVisibility() == 0 && op27a4.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura27a4,Toast.LENGTH_LONG).show();}
			  else if (lay28.getVisibility() == 0 && op28.matches("sin datos") && editPregunta28.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura28,Toast.LENGTH_LONG).show();}
			  else if (lay29.getVisibility() == 0 && op29.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura29,Toast.LENGTH_LONG).show();}
			  else if (lay29a1.getVisibility() == 0 && op29a1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura29a1,Toast.LENGTH_LONG).show();}
			  else if (lay29a2.getVisibility() == 0 && op29a2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura29a2,Toast.LENGTH_LONG).show();}
			  else if (lay30.getVisibility() == 0 && op30.matches("sin datos") && editPregunta30.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura30,Toast.LENGTH_LONG).show();}
				else if (lay31.getVisibility() == 0 && op31.matches("sin datos") && editPregunta31.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura31,Toast.LENGTH_LONG).show();}
			  else if (lay32.getVisibility() == 0 && op32.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura32,Toast.LENGTH_LONG).show();}
			  else if (lay33.getVisibility() == 0 && op33.matches("sin datos") && editPregunta33.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura33,Toast.LENGTH_LONG).show();}


			else {

				// para valor por default
				if (opAbandono.matches("sin datos")) {
					opAbandono = "1";
				}

				valores();
				btnGuardar.setEnabled(false);
				dialogoFoto(editPregunta3.getText().toString(),editPregunta2.getText().toString());

		} // Finaliza else
			break;

		case 2:

				
				valores();
				btnGuardar.setEnabled(false);
				dialogo();
		

			break;

		case 3:

				
				valores();
				btnGuardar.setEnabled(false);
				dialogo();


			break;
		}

	}

	public void Salir(View view) {
		finish();
	}

	private String sacaMaximo() {

		Set<String> set = new HashSet<String>();

		final String F = "File dbfile";

		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		String DATABASE_NAME = Environment.getExternalStorageDirectory() + "/Mis_archivos/" + nombreEncuesta + "_"
				+ sacaImei() + "";
		usdbh = new UsuariosSQLiteHelper(this, "F", null, 1, DATABASE_NAME);

		db = usdbh.getReadableDatabase();

		String selectQuery = "SELECT count(*) FROM encuestas where fecha='" + formattedDate1 + "'";

		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {

				maximo = cursor.getString(0);

			} while (cursor.moveToNext());
		}

		cursor.close();
		db.close();

		return maximo;
	}

	private String sacaConsecutivo() {

		String consecutivo = null;

		Set<String> set = new HashSet<String>();

		final String F = "File dbfile";

		// Abrimos la base de datos 'DBUsuarios' en modo escritura

		String DATABASE_NAME = Environment.getExternalStorageDirectory() + "/Mis_archivos/" + nombreEncuesta + "_"
				+ sacaImei() + "";
		usdbh = new UsuariosSQLiteHelper(this, "F", null, 1, DATABASE_NAME);

		db = usdbh.getReadableDatabase();

		String selectQuery = "SELECT count(*) FROM encuestas order by id desc limit 1";

		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {

				consecutivo = cursor.getString(0);

			} while (cursor.moveToNext());
		}

		cursor.close();
		db.close();

		return consecutivo;
	}

	

	/////////////// SPINNER /////////////////
//	public void CargaSpinnerAlcaldia() {
//		String var = "Selecciona";
//		if (var == null) {
//			var = "";
//		}
//		final String[] datos = new String[] { "" + var + "", "ÁLVARO OBREGÓN", "AZCAPOTZALCO", "BENITO JUÁREZ",
//				"COYOACÁN", "CUAJIMALPA DE MORELOS", "CUAUHTÉMOC", "GUSTAVO A. MADERO", "IZTACALCO", "IZTAPALAPA",
//				"MAGDALENA CONTRERAS", "MIGUEL HIDALGO", "MILPA ALTA", "TLÁHUAC", "TLALPAN", "VENUSTIANO CARRANZA",
//				"XOCHIMILCO", "No sabe / No contestó" };
//		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
//		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		CargaAlcaldia.setAdapter(adaptador);
//		spinnerDelegaciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
//			}
//
//			public void onNothingSelected(AdapterView<?> parent) {
//			}
//		});
//	}

	///////////// FIN SPINNER /////////////

	private String sacaDelegacion(String seccion) {
		Set<String> set = new HashSet<String>();
		final String F = "File dbfile";
		String Dele = "";
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		usdbh2 = new UsuariosSQLiteHelper2(this, "F", null, 1);
		db2 = usdbh2.getReadableDatabase();
		String selectQuery = "SELECT delegacion FROM datos where seccion='" + seccion + "'";
		Cursor cursor = db2.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				Dele = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		cursor.close();
		db2.close();
		return Dele;
	}

	private String sacaLatitud() {
		Set<String> set = new HashSet<String>();
		String acceso = null;
		final String F = "File dbfile";
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		usdbh3 = new UsuariosSQLiteHelper3(this);
		db3 = usdbh3.getReadableDatabase();
		String selectQuery = "select latitud from ubicacion order by id desc limit 1";
		Cursor cursor = db3.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				acceso = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		cursor.close();
		// db.close();

		return acceso;
	}

	private String sacaLongitud() {
		Set<String> set = new HashSet<String>();
		String acceso = null;
		final String F = "File dbfile";
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		usdbh3 = new UsuariosSQLiteHelper3(this);
		db3 = usdbh3.getReadableDatabase();
		String selectQuery = "select longitud from ubicacion order by id desc limit 1";
		Cursor cursor = db3.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				acceso = cursor.getString(0);
			} while (cursor.moveToNext());
		}
		cursor.close();
		// db.close();

		return acceso;
	}

	public void grabar() {

		// sacaMaximo();
		String pathAudio = "/mnt/sdcard/Audio1" + formattedDate3 + "";

		Nombre nom = new Nombre();
		String nombreEncuesta = nom.nombreEncuesta();

		File sdCard = null, directory, file = null;
		if (Environment.getExternalStorageState().equals("mounted")) {
			// Obtenemos el directorio de la memoria externa
			sdCard = Environment.getExternalStorageDirectory();
		}
		directory = new File(sdCard.getAbsolutePath() + "/" + nombreEncuesta + "-Audio" + formattedDate3 + "");
		recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
		recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
		recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
		recorder.setOutputFile("/mnt/sdcard/" + nombreEncuesta + "-Audio" + formattedDate3 + "/" + nombreAudio() + "");
		try {
			recorder.prepare();
		} catch (IOException e) {
			Log.i("", String.valueOf("Fallo en grabación: " + e.getMessage()));
		}
		recorder.start();
	}

	public void detenerGrabacion() {
		Thread thread = new Thread() {
			public void run() {
				if (recorder != null)
					recorder.stop();
				recorder.reset(); // You can reuse the object by going back to
				// setAudioSource() step
				recorder.release();
			}
		};
		thread.start();
	}

}
