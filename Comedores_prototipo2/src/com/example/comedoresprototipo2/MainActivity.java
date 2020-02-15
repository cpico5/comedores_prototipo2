package com.example.comedoresprototipo2;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemSelectedListener {


	Random random = new java.util.Random();
	public int rand;

	Nombre nom = new Nombre();
	String nombreEncuesta = nom.nombreEncuesta();
	
	 String upLoadServerUriFotos = "https://opinion.cdmx.gob.mx/cgi-bin/php/recibeFotos"+nombreEncuesta+".php?encuesta="+nombreEncuesta+"";
		int serverResponseCode = 0;

	private EditText txtCodigo;
	private EditText txtNombre;
	private TextView txtResultado;
	private TextView txtEncuesta;
	private TextView txtEquipo;

	private Button btnInsertar;
	private Button btnActualizar;
	private Button btnEliminar;
	private Button btnConsultar;
	private Button btnSiguiente;
	private Button btnEnviar;
	private Button btnRechazo;
	private Button btnInformacion;
	public ProgressBar progressBar;

	private SQLiteDatabase db;

	public String encuestador;
	public String credencial;
	public String seccion;
	public String equipo;
	
	
	private String TAG="MainACtivity";
	
	
	UsuariosSQLiteHelper3 usdbh3;
	private SQLiteDatabase db3;
	
	UsuariosSQLiteHelper2 usdbh2;
	private SQLiteDatabase db2;

	public EditText Usuario;
	public String tablet;
	public String encuestaQuien;
	public String pasoUsuario;

	public String Secc;
	public String cuantasSecciones;
	public String quienEncuesta;
	final String path = "/mnt/sdcard/Mis_archivos/";
	final String pathZip = "/mnt/sdcard/";
	// final String pathAudio="/mnt/sdcard/Audio/";
	
	double latitude;
	double longitude;

	public String maximo = "";
	int elMaximo;

	private static final String LOG_TAG = "Grabadora";
	private MediaRecorder mediaRecorder;
	private MediaPlayer mediaPlayer;

	private String audio;
	private Handler handler;

	private Button btnCargar;

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
	
	//	static String prefix = ID;

	public EditText editUsuario;

	public String str;

	ProgressDialog dialog = null;

	private static final int READ_BLOCK_SIZE = 2000000;

	UsuariosSQLiteHelper usdbh;
	private Spinner spinner;
	private Spinner spinner2;
	private Spinner spinner3;
	private Spinner spinnerAlcaldia;
	private Spinner spinnerEscuela;
	private Spinner spinnerDomicilio;
	private Spinner spinnerCCT;
	UsuariosSQLiteHelper Udb;
	List<String> list;
	ArrayAdapter<String> adapter;
	ArrayAdapter<String> adapter2;

	Calendar c = Calendar.getInstance();

	SimpleDateFormat df1 = new SimpleDateFormat("yyyMMdd");
	String formattedDate1 = df1.format(c.getTime());
	
	SimpleDateFormat df6 = new SimpleDateFormat("yyyMMdd");
	String formattedDateFecha = df1.format(c.getTime());

	SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a");
	String formattedDate2 = df2.format(c.getTime());

	SimpleDateFormat df3 = new SimpleDateFormat("yyy-MM-dd");
	String formattedDate3 = df3.format(c.getTime());

	SimpleDateFormat df4 = new SimpleDateFormat("HH:mm:ss a");
	String formattedDate4 = df4.format(c.getTime());

	SimpleDateFormat df5 = new SimpleDateFormat("HH:mm:ss");
	String formattedDate5 = df5.format(c.getTime());

	// Para calcular la diferencia entre horas se toma el tiempo en milisegundos
	Calendar t1 = Calendar.getInstance();
	Calendar t2 = Calendar.getInstance();
	Calendar t3 = Calendar.getInstance();
	// esta variable la paso hasta la �ltima p�gina
	long milis1 = t1.getTimeInMillis();

	public String nombreArchivo() {
//		String date = formattedDate3.toString();
//		String var2 = ".txt";
//		String var3 = date + var2;

//		final String nombre = date + "-" + tablet + "-" + nombreEncuesta + "-" + var2;
		final String nombre =nombreEncuesta+"_"+prefix;
		
		// String nombre="encuestas20140219.txt";
		return nombre;
	}

	public String nombreAudio() {

		elMaximo = Integer.parseInt(sacaMaximo().toString()) + 1;
		String date = formattedDate3.toString();
		String var2 = ".mp3";

		final String nombreAudio = "R" + elMaximo + "_T" + sacaImei() + "_E" + cachaNombre() + var2;
		// String nombre="encuestas20140219.txt";
		return nombreAudio;
	}

	public String nombreArchivoCSV() {
		String date = formattedDate3.toString();
		String var2 = ".csv";
		String var3 = date + var2;

		final String nombre = date + "-" + nombreEncuesta + "-" + prefix + var2;
		// String nombre="encuestas20140219.txt";
		return nombre;
	}

	public String cachaNombre2() {
		Bundle datos = this.getIntent().getExtras();
		encuestador = datos.getString("Nombre2");
		return encuestador;

	}

	public String sacaImei(){
		TelephonyManager TelephonyMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		String szImei = TelephonyMgr.getDeviceId(); // Requires READ_PHONE_STATE
		System.out.println("Mi N�mero: " + szImei);

		return szImei;
	}
	
	public String sacaChip(){
		String deviceId = Secure.getString(this.getContentResolver(),Secure.ANDROID_ID);
		tablet=deviceId;	
		return tablet;
	}

	public String cachaNombre() {
		Bundle datos = this.getIntent().getExtras();
		encuestador = datos.getString("Nombre");
		return encuestador;
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		GPSTracker gps = new GPSTracker(this);
		latitude = gps.getLatitude();
		longitude = gps.getLongitude();
		
		if(latitude==0.0){
			latitude=Double.valueOf(sacaLatitud());
		}
		
		if(longitude==0.0){
			longitude=Double.valueOf(sacaLongitud());
		}
		
		Log.i("GPS", "Latitud sin GPS: "+latitude);
		Log.i("GPS", "Longitud sin GPS: "+longitude);
		
//		if(gps.canGetLocation()){
//		    double latitude = gps.getLatitude();
//		    double longitude = gps.getLongitude();
//		}else{
//		// can't get location
//		// GPS or Network is not enabled
//		// Ask user to enable GPS/network in settings
//		    gps.showSettingsAlert();  
//			Log.i("GPS", "Latitud sin GPS: "+latitude);
//			Log.i("GPS", "Longitud sin GPS: "+longitude);
//		}
//		
		
		
		sacaChip();

		File sdCard, directory, file;

		sdCard = Environment.getExternalStorageDirectory();
		txtResultado = (TextView) findViewById(R.id.txtResultado);
		txtEncuesta = (TextView) findViewById(R.id.txtEncuesta);
		txtEquipo = (TextView) findViewById(R.id.txtEquipo);

		spinnerAlcaldia = (Spinner) findViewById(R.id.spinnerAlcaldia);
		spinnerEscuela = (Spinner) findViewById(R.id.spinnerEscuela);
		spinnerDomicilio = (Spinner) findViewById(R.id.spinnerDomicilio);
		spinnerCCT = (Spinner) findViewById(R.id.spinnerCCT);

		btnConsultar = (Button) findViewById(R.id.btnConsultar);
		btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
		btnSiguiente.setEnabled(false);
		btnConsultar.setEnabled(false);
		

		progressBar = (ProgressBar) findViewById(R.id.progressbar);

//		btnEnviar = (Button) findViewById(R.id.btnEnviar);
		btnRechazo = (Button) findViewById(R.id.btnRechazo);
		btnInformacion = (Button) findViewById(R.id.btnInformacion);
		btnRechazo.setEnabled(false);

		if (cachaNombre() == null) {

			encuestaQuien = cachaNombre2();

		} else {

			cachaNombre();

			encuestaQuien = cachaNombre();

		}
		
		
		new UpdateFotos().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);


		CargaSpinnerAlcaldia();
		// SeccionesSpinner();

		final String F = "File dbfile";
		
		String DATABASE_NAME = Environment.getExternalStorageDirectory() +"/Mis_archivos/" +nombreEncuesta+"_"+sacaImei()+"";

		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		usdbh = new UsuariosSQLiteHelper(this, "F", null, 1,DATABASE_NAME);

		db = usdbh.getWritableDatabase();

		usdbh2 = new UsuariosSQLiteHelper2(this, "F", null, 1);

		db2 = usdbh2.getWritableDatabase();
		
		btnConsultar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				txtResultado.setText("");
				
				
				String alcaldia=spinnerAlcaldia.getSelectedItem().toString();
				String escuela=spinnerEscuela.getSelectedItem().toString();
				String domicilio=spinnerDomicilio.getSelectedItem().toString();
				String cct=spinnerCCT.getSelectedItem().toString();
				
				txtResultado.setText(	"Escuela:\t\t" +escuela + "\n"+
										"Domicilio:\t\t"+ domicilio +"\n"+
										"CCT:\t\t" + cct +"\n"+
										"Alcald�a:\t\t"+ alcaldia +"\n"+
										"C�digo postal:\t"+sacaCP(alcaldia, escuela, cct)+"\n"+
										"Turno:\t\t"+sacaTurno(alcaldia, escuela, cct)+"\n"+
										"Nivel educativo:\t"+sacaNivelEducativo(alcaldia, escuela, cct));

				btnSiguiente.setEnabled(true);
				btnRechazo.setEnabled(true);

			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class UpdateProgress extends AsyncTask<Void, Integer, Void> {
		int progress;

		@Override
		protected void onPostExecute(Void result) {

		}

		@Override
		protected void onPreExecute() {
			progress = 0;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			progressBar.setProgress(values[0]);
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			while (progress < 100) {
				progress++;
				publishProgress(progress);
				SystemClock.sleep(100);
			}
			return null;
		}
	}

	public void Siguiente(View view) {

		if (cachaNombre() == null) {

			encuestaQuien = cachaNombre2().toUpperCase();

		} else {

			cachaNombre();

			encuestaQuien = cachaNombre().toUpperCase();

		}


		System.out.println("El ID: " + ID);
		System.out.println("El prefix: " + prefix);

		String seg = formattedDate5.substring(7);
		System.out.println("El segundo: " + seg);
		System.out.println("El ID: " + prefix);


		// System.out.println("el peso "+elPeso());

		// if (elPeso()==0) {

		// if(area.equals("ORIENTE-edgar")||area.equals("ORIENTE-EDDY")||area.equals("ORIENTE-MAGGIE")||area.equals("ORIENTE-MAYRA")){
		//
		// String delegacion=text;
		// Intent intent = new Intent(getApplicationContext(),
		// MainActivityPantalla2.class);
		// intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		// intent.putExtra("Seccion", txtNombre.getText().toString());//para
		// pasar la variable a la otra actividad
		// intent.putExtra("Nombre", encuestaQuien);//para pasar la variable a
		// la otra actividad
		// intent.putExtra("delegacion", delegacion);
		// otra actividad
		// intent.putExtra("t1", milis1);
		// startActivity(intent);
		// finish();
		//
		// } else {

		// pasaDatos();
		// }

		// } else {

		// System.out.println(cuentaArchivos());
		// new UpdateProgress().execute();
		dialogo();
		// }
	}

	public void Salir(View v) {

		finish();
	}
	
	//para comprimir archivos
	public void zip(String[] _files, String zipFileName) {
		try {
			BufferedInputStream origin = null;
			FileOutputStream dest = new FileOutputStream(zipFileName);
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
			byte data[] = new byte[2048];

			for (int i = 0; i < _files.length; i++) {
				Log.i(null, "Compress" + "Adding: " + _files[i]);
				FileInputStream fi = new FileInputStream(_files[i]);
				origin = new BufferedInputStream(fi, 2048);

				ZipEntry entry = new ZipEntry(_files[i].substring(_files[i].lastIndexOf("/") + 1));
				out.putNextEntry(entry);
				int count;

				while ((count = origin.read(data, 0, 2048)) != -1) {
					out.write(data, 0, count);
				}
				origin.close();
			}

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		public void Enviar(View view) throws IOException {

		// dameTodo();

		cargaEncuestador();
		String[] to = { "cpico56@gmail.com" };
		String[] cc = { "cpico5@hotmail.com" };
//		enviar1(to, cc, "Hola", "Esto es un email enviado desde una app de Android");
//		txtEncuesta.setText("");
//
//		cargaEncuestador();
//		enviar2(to, cc, "Hola", "Esto es un email enviado desde una app de Android");
//		txtEncuesta.setText("");
//
//		// en orden de ejecuci�n: este se ejecuta primero
//		cargaEncuestador();
		enviar(to, cc, "Hola", "Esto es un email enviado desde una app de Android");
		txtEncuesta.setText("");

	}

	private void enviar(String[] to, String[] cc, String asunto, String mensaje) {
		String deviceId = Secure.getString(this.getContentResolver(), Secure.ANDROID_ID);
		tablet = deviceId;
		String date2 = formattedDate3.toString();
//		final String nombre2 = date2 + "-" + tablet + "-" + nombreEncuesta + ".txt";
		final String nombre2 = date2 + "-" + tablet + "-" + nombreEncuesta + ".txt";
	
		String texto = txtEncuesta.getText().toString();

		Intent em = new Intent(android.content.Intent.ACTION_SEND_MULTIPLE);// send multiple, para enviar varios archivos.
		em.setType("plain/text");

		em.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] { "larecepcion2018@gmail.com" });
		em.putExtra(android.content.Intent.EXTRA_SUBJECT, "Archivos tablet: '" + tablet + "'" + " d�a: " + date2);
		em.putExtra(android.content.Intent.EXTRA_TEXT, "Se env�an archivos de la Tablet:  '" + tablet + "'\n\n"
				+ "- Coordinador que env�a: '" + cachaNombre().toUpperCase() + "'" + "\n" + texto);

		File sdCard;
		sdCard = Environment.getExternalStorageDirectory();

		final String AudiosZip = nombreEncuesta+"-Audio"+formattedDate1+".zip";
		Log.i(null,"zip"+ AudiosZip);
		
	// para enviar multiples archivos adjuntos

		ArrayList<Uri> uris = new ArrayList<Uri>();
		// uris.add(Uri.parse("file://" + path + "" + nombre2));
		// uris.add(Uri.parse("file://" + path + "" + nombre2));
		uris.add(Uri.parse("file://" + pathZip + "" + AudiosZip));
		uris.add(Uri.parse("file://" + path + "" + nombreArchivo()));
//		uris.add(Uri.parse("file://" + pathZip + AudiosZip));
		em.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);

		startActivity(Intent.createChooser(em, "Enviar correo electr�nico"));

	}


	public void Rechazo(View view) {

		dialogoRechazo();

	}
	
	public void Info(View view) {

		Intent intent = new Intent(getApplicationContext(), Menu_Principal.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		
		intent.putExtra("Nombre", encuestaQuien);
											// actividad
		intent.putExtra("t1", milis1);
		startActivity(intent);
		finish();

	}

	public void dialogo() {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// builder.setMessage(cuentaArchivos())
		builder.setMessage("Encuestas: \n" + "Normal:   " + " " + dameNormales()
				+ "\n" + "Abandono: " + " " + dameAbandonos() + "\n" + 
				"Rechazos: " + dameRechazosTodos())

				.setTitle("AVISO...!!!").setCancelable(false)
				.setNegativeButton("SALIR", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
//						Intent i = new Intent(MainActivity.this, Entrada.class);
//						i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//						startActivity(i);
//						finish();
//						; // metodo que se debe implementar
					}
				}).setPositiveButton("CONTINUAR", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						System.out.println(cachaNombre());


						
						pasaDatos();

					

					}
				});
		AlertDialog alert = builder.create();
		alert.show();

	}

	// RECUPERAR UN DATO DE LA BASE DE DATOS




	public void cargaEncuestador() {

		db = usdbh.getWritableDatabase();
		String selectQuery1 = " SELECT usuario, count(*) as total from encuestas where fecha='" + formattedDate3
				+ "' group by usuario";
		Cursor c = db.rawQuery(selectQuery1, null);

		if (c.moveToFirst())
			do {

				String enc = c.getString(0);
				String tot = c.getString(1);
				// Recorremos el cursor hasta que no haya m�s registros
				txtEncuesta.append("- Encuestador: " + enc + "  " + "\tTotal de encuestas: " + tot + "\n");

			} while (c.moveToNext());

		c.close();
		db.close();
	}

	public String dameNormales() {

		
		String cuantasSecciones_base;

		db = usdbh.getWritableDatabase();
		String selectQuery1 = "select count(*) as total from encuestas where usuario='"+cachaNombre()+"' and fecha='" + formattedDate3 + "' and tipocaptura='NORMAL'";
		// String selectQuery1 = "select seccion, count(*) as total from
		// locatario where seccion='"+seccion+"' group by seccion"; //total de
		// encuestas
		Cursor c = db.rawQuery(selectQuery1, null);

		if (c.getCount() > 0) {
			// Recorremos el cursor hasta que no haya m�s registros
			c.moveToFirst();
			cuantasSecciones_base = c.getString(0);
		}

		else {

			cuantasSecciones_base = "0";

		}

		c.close();
		db.close();
		return cuantasSecciones_base;

	}

	public String dameAbandonos() {
		
		String cuantasSecciones_base;
		db = usdbh.getWritableDatabase();
		String selectQuery1 = "select count(*) as total from encuestas where usuario='"+cachaNombre()+"' and fecha='" + formattedDate3 + "' and tipocaptura='ABANDONO'";
		Cursor c = db.rawQuery(selectQuery1, null);
		if (c.getCount() > 0) {
			// Recorremos el cursor hasta que no haya m�s registros
			c.moveToFirst();
			cuantasSecciones_base = c.getString(0);
		} else {
			cuantasSecciones_base = "0";
		}
		c.close();
		db.close();
		return cuantasSecciones_base;
	}

	public String dameHombres() {

		
		String masculino;

		db = usdbh.getWritableDatabase();
		// String selectQuery1 = "select seccion, count(*) as total from
		// encuestas where seccion='"+seccion+"' and fecha='"+formattedDate1+"'
		// group by seccion";
		String selectQuery1 = "select socioeconomico_12, count(*) as total from encuestas where seccion='" + seccion
				+ "' and fecha='" + formattedDate3 + "'  and socioeconomico_12='MASCULINO' and tipocaptura='NORMAL' group by socioeconomico_12"; // total
																												// de
																												// encuestas
		Cursor c = db.rawQuery(selectQuery1, null);

		if (c.getCount() > 0) {
			// Recorremos el cursor hasta que no haya m�s registros
			c.moveToFirst();
			masculino = c.getString(1);
		}

		else {

			masculino = "0";

		}

		c.close();
		db.close();
		return masculino;

	}

	public String dameMujeres() {

		
		String femenino;

		db = usdbh.getWritableDatabase();
		// String selectQuery1 = "select seccion, count(*) as total from
		// encuestas where seccion='"+seccion+"' and fecha='"+formattedDate1+"'
		// group by seccion";
		String selectQuery1 = "select socioeconomico_12, count(*) as total from encuestas where seccion='" + seccion
				+ "' and fecha='" + formattedDate3 + "'  and socioeconomico_12='FEMENINO' and tipocaptura='NORMAL' group by socioeconomico_12"; // total
																												// de
																												// encuestas
		Cursor c = db.rawQuery(selectQuery1, null);

		if (c.getCount() > 0) {
			// Recorremos el cursor hasta que no haya m�s registros
			c.moveToFirst();
			femenino = c.getString(1);
		}

		else {

			femenino = "0";

		}

		c.close();
		db.close();
		return femenino;

	}

	public String dameRechazosTodos() {
		
		String cuantasSecciones_base;
		db = usdbh.getWritableDatabase();
		String selectQuery1 = "select count(*) as total from encuestas where usuario='"+cachaNombre()+"' and fecha='" + formattedDate3 + "' and tipocaptura='RECHAZO'";
		Cursor c = db.rawQuery(selectQuery1, null);
		if (c.getCount() > 0) {
			// Recorremos el cursor hasta que no haya m�s registros
			c.moveToFirst();
			cuantasSecciones_base = c.getString(0);
		} else {
			cuantasSecciones_base = "0";
		}
		c.close();
		db.close();
		return cuantasSecciones_base;
	}

	public String dameRechazos() {
		
		String cuantasSecciones_base;
		db = usdbh.getWritableDatabase();
		String selectQuery1 = "select seccion, count(*) as total from encuestas where seccion='" + seccion
				+ "' and fecha='" + formattedDate3 + "' and tipocaptura='RECHAZO' group by seccion";
		Cursor c = db.rawQuery(selectQuery1, null);
		if (c.getCount() > 0) {
			// Recorremos el cursor hasta que no haya m�s registros
			c.moveToFirst();
			cuantasSecciones_base = c.getString(1);
		} else {
			cuantasSecciones_base = "0";
		}
		c.close();
		db.close();
		return cuantasSecciones_base;
	}

	public void pasaDatos() {

		String seg = formattedDate5.substring(7);


		String alcaldia=spinnerAlcaldia.getSelectedItem().toString();
		String escuela=spinnerEscuela.getSelectedItem().toString();
		String domicilio=spinnerDomicilio.getSelectedItem().toString();
		String cct=spinnerCCT.getSelectedItem().toString();
		String cp=sacaCP(alcaldia, escuela, cct);
		String matricula=sacaMatricula(alcaldia, escuela, cct);
		

		Intent intent = new Intent(getApplicationContext(), MainActivityPantalla1.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.putExtra("Nombre", encuestaQuien);
		intent.putExtra("alcaldia", alcaldia);
		intent.putExtra("escuela", escuela);
		intent.putExtra("domicilio", domicilio);
		intent.putExtra("cct", cct);
		intent.putExtra("cp", cp);
		intent.putExtra("matricula", matricula);
											// actividad
		intent.putExtra("t1", milis1);
		startActivity(intent);
		finish();

	}



	
	//Usuarios

//	private void cargaUsuario() {
//
//		final String[] datos = new String[] {
//				"ALAN",
//				"ARREDONDO",
//				"BERNACHI",
//				"DANIEL",
//				"EDUARDO S",
//				"ENRIQUE",
//				"IRIS",
//				"LUJANO",
//				"OSCAR",
//				"POLANCO",
//				"SANDRA",
//				"SAUL",
//				"TABLA"
//};
//
//		// Alternativa 1: Array java
//		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
//
//		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//		spinner2.setAdapter(adaptador);
//
//		// ACCI�N QUE SE REALIZA CUANDO ES SELECCIOANDO UN ELEMENTO DEL SPINNER
//		spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
//				SeccionesSpinner();
//				txtEquipo.setText("Seleccionado: " + datos[position]);
//				btnSiguiente.setEnabled(false);// desactiva el bot�n siguiente
//				txtResultado.setText("");// limpia el cuadro de texto
//			}
//
//			public void onNothingSelected(AdapterView<?> parent) {
//				txtEquipo.setText("");
//			}
//		});
//
//	}

//	private void SeccionesSpinner() {
//
//		usdbh2 = new UsuariosSQLiteHelper2(this, "F", null, 1);
//
//		Set<String> set = new HashSet<String>();
//
//		equipo = spinner2.getSelectedItem().toString().toLowerCase();
//		System.out.println(equipo);
//
//		db2 = usdbh2.getWritableDatabase();
//
//		// Para llenar el spinner solo con los datos del equipo
//		// PARA QUITAR LOS REGISTROS SELECT t1.seccion FROM (SELECT seccion FROM
//		// datos where equipo='"+equipo+"' union ALL SELECT seccion FROM
//		// encuestas )t1 GROUP BY t1.seccion HAVING count(*) <=3 ORDER BY
//		// t1.seccion asc
//		// String selectQuery1 = "SELECT * FROM datos WHERE equipo='"+equipo+"'
//		// and seccion NOT IN (SELECT seccion FROM encuestas GROUP BY seccion
//		// HAVING COUNT(*) >= 4 ORDER BY seccion)";
//		String selectQuery1 = "SELECT * FROM datos WHERE equipo='" + equipo + "'";
//
//		// Otra consulta Select seccion from datos where equipo ='eddy' and not
//		// exists (select seccion from encuestas where encuestas.seccion =
//		// datos.seccion) GROUP BY datos.seccion HAVING count(*) <=4;
//		Cursor c = db2.rawQuery(selectQuery1, null);
//
//		if (c.moveToFirst()) {
//			do {
//
//				set.add(c.getString(0));
//
//				String secc = c.getString(0);
//
//			} while (c.moveToNext());
//		}
//
//		else {
//			Toast toast2 = Toast.makeText(getApplicationContext(), "NO CORRESPONDE ESTE N�MERO DE SECCI�N...!",
//					Toast.LENGTH_LONG);
//
//			toast2.setGravity(Gravity.TOP | Gravity.CENTER, 0, 0);
//
//			toast2.show();
//
//		}
//
//		c.close();
////		db.close();
//		// here i used Set Because Set doesn't allow duplicates.
//		Set<String> set1 = set;
//		List<String> list = new ArrayList<String>(set1);
//
//		adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, list);
//
//		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//		Collections.sort(list);
//		spinner3.setAdapter(adapter);
//
//		// ACCI�N QUE SE REALIZA CUANDO ES SELECCIOANDO UN ELEMENTO DEL SPINNER
//		spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
//				btnSiguiente.setEnabled(false);// desactiva el bot�n siguiente
//				txtResultado.setText("");// limpia el cuadro de texto
//			}
//
//			public void onNothingSelected(AdapterView<?> parent) {
//				// txtEquipo.setText("");
//			}
//		});
//		spinner3.setWillNotDraw(false);
//
//	}

	private String sacaMaximo() {

		Set<String> set = new HashSet<String>();

		final String F = "File dbfile";

		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		
		String DATABASE_NAME = Environment.getExternalStorageDirectory() +"/Mis_archivos/" +nombreEncuesta+"_"+sacaImei()+"";
		usdbh = new UsuariosSQLiteHelper(this, "F", null, 1,DATABASE_NAME);

		db = usdbh.getReadableDatabase();

		String selectQuery = "SELECT count(*) FROM encuestas where fecha='" + formattedDate3 + "'";

		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {

				maximo = cursor.getString(0);

			} while (cursor.moveToNext());
		}

		cursor.close();
//		db.close();

		return maximo;
	}

	private String sacaMaximo2() {

		Set<String> set = new HashSet<String>();

		final String F = "File dbfile";

		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		
		String DATABASE_NAME = Environment.getExternalStorageDirectory() +"/Mis_archivos/" +nombreEncuesta+"_"+sacaImei()+"";
		usdbh = new UsuariosSQLiteHelper(this, "F", null, 1,DATABASE_NAME);

		db = usdbh.getReadableDatabase();

		String selectQuery = "SELECT count(*) FROM usuario";

		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor.moveToFirst()) {
			do {

				maximo = cursor.getString(0);

			} while (cursor.moveToNext());
		}

		cursor.close();
//		db.close();

		return maximo;
	}

	

	public void valoresRechazoMasculino() {

		

		String seg = formattedDate5.substring(7);
		System.out.println("El segundo: " + seg);
		System.out.println("El ID" + prefix);

		cachaNombre();

		String strId = String.valueOf(rand + 1);
		
		GPSTracker gps = new GPSTracker(this);
		latitude = gps.getLatitude();
		longitude = gps.getLongitude();
		
		if(latitude==0.0){
			latitude=Double.valueOf(sacaLatitud());
		}
		
		if(longitude==0.0){
			longitude=Double.valueOf(sacaLongitud());
		}
		
		String strLatitud=String.valueOf(latitude);
		String strLongitud=String.valueOf(longitude);


		elMaximo = Integer.parseInt(sacaMaximo().toString()) + 1;

		// Clase que permite grabar texto en un archivo
		FileOutputStream fout = null;
		try {
			// INSERTA EN LA BASE DE DATOS //

			String DATABASE_NAME = Environment.getExternalStorageDirectory() +"/Mis_archivos/" +nombreEncuesta+"_"+sacaImei()+"";
			usdbh = new UsuariosSQLiteHelper(this, "F", null, 1,DATABASE_NAME);

			db = usdbh.getWritableDatabase();

			// NORMAL
			Nombre nom = new Nombre();
			String nombreE = nom.nombreEncuesta();

			if (db != null) {
				ContentValues values = new ContentValues();
				values.put("consecutivo_diario", elMaximo);
				values.put("usuario", cachaNombre().toUpperCase());
				values.put("equipo", equipo.toUpperCase());
				values.put("nombre_encuesta", nombreE.toUpperCase());
				values.put("fecha", formattedDate3);
				values.put("hora", formattedDate5);
				values.put("imei", sacaImei());
				values.put("latitud", strLatitud);
				values.put("longitud", strLongitud);

				values.put("genero", "Masculino");
				values.put("suma", "0");
				values.put("status", "0");

				values.put("tiempo", "00:00");
				values.put("tipocaptura", "RECHAZO");

				db.insert("encuestas", null, values);
			}
//			db.close();

			// FIN INSERTA BASE DE DATOS //
			
			txtEquipo.setText("");
			btnSiguiente.setEnabled(false);// desactiva el bot�n siguiente
			btnRechazo.setEnabled(false);
			txtResultado.setText("");// limpia el cuadro de texto

		} catch (Exception e) {
			System.out.println("algo pas�...1");
			Log.i("Guardar", e.getMessage());
		}

	}

	public void valoresRechazoFemenino() {

	
		
		GPSTracker gps = new GPSTracker(this);
		latitude = gps.getLatitude();
		longitude = gps.getLongitude();
		
		if(latitude==0.0){
			latitude=Double.valueOf(sacaLatitud());
		}
		
		if(longitude==0.0){
			longitude=Double.valueOf(sacaLongitud());
		}
		
		String strLatitud=String.valueOf(latitude);
		String strLongitud=String.valueOf(longitude);

		String seg = formattedDate5.substring(7);
		System.out.println("El segundo: " + seg);
		System.out.println("El Imei" + sacaImei());

		cachaNombre();

		String strId = String.valueOf(rand + 1);

		elMaximo = Integer.parseInt(sacaMaximo().toString()) + 1;

		// Clase que permite grabar texto en un archivo
		FileOutputStream fout = null;
		try {
			// INSERTA EN LA BASE DE DATOS //

			final String F = "File dbfile";

			// Abrimos la base de datos 'DBUsuarios' en modo escritura
			String DATABASE_NAME = Environment.getExternalStorageDirectory() +"/Mis_archivos/" +nombreEncuesta+"_"+sacaImei()+"";
			usdbh = new UsuariosSQLiteHelper(this, "F", null, 1,DATABASE_NAME);

			db = usdbh.getWritableDatabase();

			// NORMAL
			Nombre nom = new Nombre();
			String nombreE = nom.nombreEncuesta();

			if (db != null) {
				ContentValues values = new ContentValues();
				values.put("consecutivo_diario", elMaximo);
				values.put("usuario", cachaNombre().toUpperCase());
				values.put("equipo", equipo.toUpperCase());
				values.put("nombre_encuesta", nombreE.toUpperCase());
				values.put("fecha", formattedDate3);
				values.put("hora", formattedDate5);
				values.put("imei", sacaImei());
//				values.put("seccion", strSecc);
				values.put("latitud", strLatitud);
				values.put("longitud", strLongitud);

				values.put("genero", "Femenino");
				values.put("suma", "0");
				values.put("status", "0");

				values.put("tiempo", "00:00");
				values.put("tipocaptura", "RECHAZO");

				db.insert("encuestas", null, values);
			}
//			db.close();

			// FIN INSERTA BASE DE DATOS //
			
			txtEquipo.setText("");
			btnSiguiente.setEnabled(false);// desactiva el bot�n siguiente
			btnRechazo.setEnabled(false);
			txtResultado.setText("");// limpia el cuadro de texto

		} catch (Exception e) {
			System.out.println("algo pas�...1");
			Log.i("Guardar", e.getMessage());
		}

	}

	public void dialogoRechazo() {

		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		MainActivity.this.runOnUiThread(new Runnable() {
			public void run() {
				builder.setMessage("Sexo de quien rechaza")
				.setTitle("Rechazo de Encuesta").setCancelable(false)
						.setNegativeButton("Masculino", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {

								valoresRechazoMasculino();
								Intent intent = new Intent(getApplicationContext(), MainActivity.class);
								intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								intent.putExtra("Nombre", encuestaQuien);
																	// actividad
								startActivity(intent);
								finish();
								
							}
						}).setPositiveButton("Femenino", new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {

								valoresRechazoFemenino();
								Intent intent = new Intent(getApplicationContext(), MainActivity.class);
								intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
								intent.putExtra("Nombre", encuestaQuien);
																	// actividad
								startActivity(intent);
								finish();

							}
						});

				AlertDialog alert = builder.create();

				alert.show();
			}
		});

	}

	public void dameTodo() throws IOException {

		File myFile;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		String TimeStampDB = sdf.format(cal.getTime());

		try {

			File sdCard = null, directory, file = null;

			// validamos si se encuentra montada nuestra memoria externa

			if (Environment.getExternalStorageState().equals("mounted")) {

				// Obtenemos el directorio de la memoria externa
				sdCard = Environment.getExternalStorageDirectory();

			}

			// Obtenemos el direcorio donde se encuentra nuestro
			// archivo a leer
			directory = new File(sdCard.getAbsolutePath() + "/Mis_archivos");

			// Creamos un objeto File de nuestro archivo a leer
			file = new File(directory, nombreArchivoCSV());

			file.createNewFile();
			FileOutputStream fOut = new FileOutputStream(file);
			OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
			myOutWriter.append("diario,seccion,usuario,fecha,hora,tablet");

			myOutWriter.append("\n");

			String DATABASE_NAME = Environment.getExternalStorageDirectory() +"/Mis_archivos/" +nombreEncuesta+"_"+sacaImei()+"";
			usdbh = new UsuariosSQLiteHelper(this, "F", null, 1,DATABASE_NAME);

			db = usdbh.getWritableDatabase();

			Cursor c = db.rawQuery("SELECT * FROM locatario", null);

			if (c != null) {
				if (c.moveToFirst()) {
					do {

						String diario = c.getString(c.getColumnIndex("diario"));
						String usuario = c.getString(c.getColumnIndex("usuario"));
						String fecha = c.getString(c.getColumnIndex("fecha"));
						String hora = c.getString(c.getColumnIndex("hora"));
						String tablet = c.getString(c.getColumnIndex("tableta"));
						String seccion = c.getString(c.getColumnIndex("seccion"));

						myOutWriter.append(
								diario + "," + seccion + "," + usuario + "," + fecha + "," + hora + "," + tablet);
						myOutWriter.append("\n");

					}

					while (c.moveToNext());
				}

				c.close();
				myOutWriter.close();
				fOut.close();

			}
		} catch (SQLiteException se) {
			Log.e(getClass().getSimpleName(), "Could not create or Open the database");
		}

		finally {

//			db.close();

		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

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
//		db.close();

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
//		db.close();

		return acceso;
	}
	
	
	
	private String sacaTurno(String alcaldia,String escuela,String cct) {
		Set<String> set = new HashSet<String>();
		final String F = "File dbfile";
		String Dele="";
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		usdbh2 = new UsuariosSQLiteHelper2(this, "F", null, 1);
		db2 = usdbh2.getReadableDatabase();
		String selectQuery = "SELECT turno FROM datos where alcaldia='" + alcaldia + "' and nombre_escuela='"+escuela+"' and cct='"+cct+"'";
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
	
	private String sacaCP(String alcaldia,String escuela,String cct) {
		Set<String> set = new HashSet<String>();
		final String F = "File dbfile";
		String Dele="";
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		usdbh2 = new UsuariosSQLiteHelper2(this, "F", null, 1);
		db2 = usdbh2.getReadableDatabase();
		String selectQuery = "SELECT codigo_postal FROM datos where alcaldia='" + alcaldia + "' and nombre_escuela='"+escuela+"' and cct='"+cct+"'";
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
	
	private String sacaNivelEducativo(String alcaldia,String escuela,String cct) {
		Set<String> set = new HashSet<String>();
		final String F = "File dbfile";
		String Dele="";
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		usdbh2 = new UsuariosSQLiteHelper2(this, "F", null, 1);
		db2 = usdbh2.getReadableDatabase();
		String selectQuery = "SELECT nivel_educativo FROM datos where alcaldia='" + alcaldia + "' and nombre_escuela='"+escuela+"' and cct='"+cct+"'";
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
	
	private String sacaMatricula(String alcaldia,String escuela,String cct) {
		Set<String> set = new HashSet<String>();
		final String F = "File dbfile";
		String Dele="";
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		usdbh2 = new UsuariosSQLiteHelper2(this, "F", null, 1);
		db2 = usdbh2.getReadableDatabase();
		String selectQuery = "SELECT matricula FROM datos where alcaldia='" + alcaldia + "' and nombre_escuela='"+escuela+"' and cct='"+cct+"'";
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
	
	
	public void CargaSpinnerAlcaldia() {
		String var = "Selecciona";
		if (var == null) {
			var = "";
		}
		final String[] datos = new String[] { "" + var + "", "ALVARO OBREGON", "AZCAPOTZALCO", "BENITO JUAREZ",
				"COYOACAN", "CUAJIMALPA DE MORELOS", "CUAUHTEMOC", "GUSTAVO A. MADERO", "IZTACALCO", "IZTAPALAPA",
				"LA MAGDALENA CONTRERAS", "MIGUEL HIDALGO", "MILPA ALTA", "TLAHUAC", "TLALPAN", "VENUSTIANO CARRANZA",
				"XOCHIMILCO"};
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.multiline_spinner_dropdown_item,datos);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerAlcaldia.setAdapter(adaptador);
		spinnerAlcaldia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
				
				txtResultado.setText("");
				
				String alcaldia=spinnerAlcaldia.getSelectedItem().toString();
				
				if(alcaldia.equals("Selecciona")){
					btnConsultar.setVisibility(View.GONE);;
				}else{
					btnConsultar.setVisibility(View.VISIBLE);;
					btnConsultar.setEnabled(true);
				}
				
				
				LoadSpinnerEscuela(alcaldia);
				
				
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
	
	
	private void LoadSpinnerEscuela(String alcaldia) {

		Set<String> set = new HashSet<String>();
		final String F = "File dbfile";
		String Dele="";
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		usdbh2 = new UsuariosSQLiteHelper2(this, "F", null, 1);

		db2 = usdbh2.getWritableDatabase();
		String selectQuery = "SELECT nombre_escuela FROM datos where alcaldia='" + alcaldia + "'";
		Cursor c = db2.rawQuery(selectQuery, null);
		if (c.moveToFirst()) {
			do {
				set.add(c.getString(0));
				String escuela = c.getString(0);
			} while (c.moveToNext());
		}

		c.close();
//		db.close();
		Set<String> set1 = set;
		List<String> list = new ArrayList<String>(set1);
		
			
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.multiline_spinner_dropdown_item,list);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Collections.sort(list);
		spinnerEscuela.setAdapter(adaptador);
		// ACCI�N QUE SE REALIZA CUANDO ES SELECCIOANDO UN ELEMENTO DEL SPINNER
		spinnerEscuela.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
				
				txtResultado.setText("");
				
				String alcaldia=spinnerAlcaldia.getSelectedItem().toString();
				String escuela=spinnerEscuela.getSelectedItem().toString();
				
				LoadSpinnerCCT(alcaldia, escuela);

			}
			public void onNothingSelected(AdapterView<?> parent) {
				// txtEquipo.setText("");
			}
		});
		spinnerEscuela.setWillNotDraw(false);

	}
	
	
	
	private void LoadSpinnerCCT(String alcaldia,String escuela) {

		Set<String> set = new HashSet<String>();
		final String F = "File dbfile";
		String Dele="";
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		usdbh2 = new UsuariosSQLiteHelper2(this, "F", null, 1);

		db2 = usdbh2.getWritableDatabase();
		String selectQuery = "SELECT cct FROM datos where alcaldia='" + alcaldia + "' and nombre_escuela='"+escuela+"'";
		Cursor c = db2.rawQuery(selectQuery, null);
		if (c.moveToFirst()) {
			do {
				set.add(c.getString(0));
				String Nombre_escuela = c.getString(0);
			} while (c.moveToNext());
		}

		c.close();
//		db.close();
		Set<String> set1 = set;
		List<String> list = new ArrayList<String>(set1);

		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.multiline_spinner_dropdown_item,list);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Collections.sort(list);
		spinnerCCT.setAdapter(adaptador);
		// ACCI�N QUE SE REALIZA CUANDO ES SELECCIOANDO UN ELEMENTO DEL SPINNER
		spinnerCCT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
				
				txtResultado.setText("");
				
				String alcaldia=spinnerAlcaldia.getSelectedItem().toString();
				String escuela=spinnerEscuela.getSelectedItem().toString();
				String cct=spinnerCCT.getSelectedItem().toString();
				
				LoadSpinnerDomicilio(alcaldia, escuela,cct);

			}
			public void onNothingSelected(AdapterView<?> parent) {
				// txtEquipo.setText("");
			}
		});
		spinnerCCT.setWillNotDraw(false);

	}
	
	private void LoadSpinnerDomicilio(String alcaldia,String escuela,String cct) {

		Set<String> set = new HashSet<String>();
		final String F = "File dbfile";
		String Dele="";
		// Abrimos la base de datos 'DBUsuarios' en modo escritura
		usdbh2 = new UsuariosSQLiteHelper2(this, "F", null, 1);

		db2 = usdbh2.getWritableDatabase();
		String selectQuery = "SELECT domicilio FROM datos where alcaldia='" + alcaldia + "' and nombre_escuela='"+escuela+"' and cct ='"+cct+"'";
		Cursor c = db2.rawQuery(selectQuery, null);
		if (c.moveToFirst()) {
			do {
				set.add(c.getString(0));
				String Nombre_escuela = c.getString(0);
			} while (c.moveToNext());
		}

		c.close();
//		db.close();
		Set<String> set1 = set;
		List<String> list = new ArrayList<String>(set1);

		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.multiline_spinner_dropdown_item,list);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Collections.sort(list);
		spinnerDomicilio.setAdapter(adaptador);
		// ACCI�N QUE SE REALIZA CUANDO ES SELECCIOANDO UN ELEMENTO DEL SPINNER
		spinnerDomicilio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
				
				txtResultado.setText("");

			}
			public void onNothingSelected(AdapterView<?> parent) {
				// txtEquipo.setText("");
			}
		});
		spinnerDomicilio.setWillNotDraw(false);

	}
	
    //////////   UPLOAD DE FOTOS ////////
    
	//Enviar Fotos
	

	public int uploadFotos(String sourceFileUri,String fech) {

	File sdCard;
	sdCard = Environment.getExternalStorageDirectory();
	//final String pathFotos = sdCard.getAbsolutePath() + "/"+ nombreEncuesta+"-Audio"+fech;
	final String pathFotos = sdCard.getAbsolutePath() +"/Fotos/FotosComedoresPrototipo2"+formattedDateFecha+"N";

	String fileName = sourceFileUri;

	HttpURLConnection conn = null;
	DataOutputStream dos = null;  
	String lineEnd = "\r\n";
	String twoHyphens = "--";
	String boundary = "*****";
	int bytesRead, bytesAvailable, bufferSize;
	byte[] buffer;
	int maxBufferSize = 1 * 1024 * 1024; 
	File sourceFile = new File(sourceFileUri); 
	 
	if (!sourceFile.isFile()) {
	     
//	     dialog.dismiss(); 
	     Log.i(TAG, " =====> archivo:  El Archivo no existe... :" + pathFotos + "" + "/" + "20161124_002_359083065132816_1.jpg");
	     runOnUiThread(new Runnable() {
	         public void run() {

	         }
	     }); 
	      
	     return 0;
	  
	}
	else
	{
	     try { 
	           // open a URL connection to the Servlet
	         FileInputStream fileInputStream = new FileInputStream(sourceFile);
	         URL url = new URL(upLoadServerUriFotos);
	         // Open a HTTP  connection to  the URL
	         conn = (HttpURLConnection) url.openConnection(); 
	         conn.setDoInput(true); // Allow Inputs
	         conn.setDoOutput(true); // Allow Outputs
	         conn.setUseCaches(false); // Don't use a Cached Copy
	         conn.setRequestMethod("POST");
	         conn.setRequestProperty("Connection", "Keep-Alive");
	         conn.setRequestProperty("ENCTYPE", "multipart/form-data");
	         conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
	         conn.setRequestProperty("uploaded_file", fileName); 
	          
	         dos = new DataOutputStream(conn.getOutputStream());

	         dos.writeBytes(twoHyphens + boundary + lineEnd); 
	         dos.writeBytes("Content-Disposition: form-data; name=\"uploaded_file\";filename=\"" + fileName + "\""
						+ lineEnd);
	          
	         dos.writeBytes(lineEnd);

	         // create a buffer of  maximum size
	         bytesAvailable = fileInputStream.available(); 

	         bufferSize = Math.min(bytesAvailable, maxBufferSize);
	         buffer = new byte[bufferSize];
	         // read file and write it into form...
	         bytesRead = fileInputStream.read(buffer, 0, bufferSize);  
	         while (bytesRead > 0) {
	           dos.write(buffer, 0, bufferSize);
	           bytesAvailable = fileInputStream.available();
	           bufferSize = Math.min(bytesAvailable, maxBufferSize);
	           bytesRead = fileInputStream.read(buffer, 0, bufferSize);   
	          }
	         // send multipart form data necesssary after file data...
	         dos.writeBytes(lineEnd);
	         dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
	         // Responses from the server (code and message)
	         serverResponseCode = conn.getResponseCode();
	         String serverResponseMessage = conn.getResponseMessage();

	         Log.i("Foto", "HTTP Response fotos is : "+ serverResponseMessage + ": " + serverResponseCode);
	          
	         if(serverResponseCode == 200){
	              
	             runOnUiThread(new Runnable() {
	                  public void run() {
	                       
	                      String msg = "File Upload Completed.\n\n See uploaded file here : \n\n"
	                                    +" http://www.androidexample.com/media/uploads/"
	                                    +"20161124_002_359083065132816_1.jpg";

//	                      Toast.makeText(Entrada.this, "File Upload Complete."+msg,Toast.LENGTH_SHORT).show();
	                  }
	              });                
	         }    
	          
	         //close the streams //
	         fileInputStream.close();
	         dos.flush();
	         dos.close();
	           
	    } catch (MalformedURLException ex) {
	         
//	        dialog.dismiss();  
	        ex.printStackTrace();
	         
	        runOnUiThread(new Runnable() {
	            public void run() {
//	                messageText.setText("MalformedURLException Exception : check script url.");
//	                Toast.makeText(CalendarViewFotos.this, "MalformedURLException", 
//	                                                    Toast.LENGTH_SHORT).show();
	            }
	        });
	         
	        Log.i(TAG, " =====> archivo:  El Archivo no existe... :" + "Upload file to server "+ "error: " + ex.getMessage());

//	        Log.e("Upload file to server", "error: " + ex.getMessage(), ex);  
	    } catch (Exception e) {
	         
//	        dialog.dismiss();  
	        e.printStackTrace();
	         
	        runOnUiThread(new Runnable() {
	            public void run() {
//	                messageText.setText("Error de Internet");
//	                Toast.makeText(CalendarViewFotos.this, "Error de Internet", 
//	                        Toast.LENGTH_SHORT).show();
	            }
	        });
	        Log.i(TAG, " =====> archivo:  El Archivo no existe... :" + "Upload file to server Exception "+ "Exception : "+ e.getMessage());

//	        Log.e("Upload file to server Exception", "Exception : "
//	                                         + e.getMessage(), e);  
	    }
	    return serverResponseCode; 
	     
	 } // End else block 
	} 

	class UpdateFotos extends AsyncTask<String, Float, String> {

		protected void onPreExecute() {
			super.onPreExecute();
			Log.i("Foto", "CarlosQ:  Entra ====>");
		}
		
		
		@Override
		protected String doInBackground(String... params) {

			
			final String date2 = formattedDateFecha;
			 File sdCard;
				sdCard = Environment.getExternalStorageDirectory();
				final String pathFotos = sdCard.getAbsolutePath() +"/Fotos/FotosComedoresPrototipo2"+formattedDateFecha+"N";
				final String pathFotosN = sdCard.getAbsolutePath() +"/Fotos/FotosComedoresPrototipo2"+formattedDateFecha+"N/";
				final String pathFotosF = sdCard.getAbsolutePath() +"/Fotos/FotosComedoresPrototipo2"+formattedDateFecha+ "/";;
	        
		        String sDirectorio = pathFotos;
				final File f = new File(sDirectorio);
				Log.i(null,"lista"+pathFotos);
				
//				final String customURL = "https://encuestas.sies2018.org/coordinacion/Fotos/";
				final String customURL = "https://opinion.cdmx.gob.mx/fotografias/comedores_prototipo2/";

			Log.i("Foto", "CarlosQ =======> lista 1: " + pathFotos);

			File F = new File(pathFotos);

			try {
				
				if (F.exists()) {
					
				File[] ficheros = F.listFiles();
				
				for (int i = 0; i <ficheros.length; i++) {
                   //Simulamos cierto retraso
                   try {Thread.sleep(500); }
                   catch (InterruptedException e) {}

                   publishProgress(i/(float)(ficheros.length)); //Actualizamos los valores
               }


				
					String[] s = new String[ficheros.length];
					String[] t = new String[ficheros.length];
					for (int x = 0; x < ficheros.length; x++) {
						Log.i("Foto", "CarlosQ ===========> lista: " + ficheros[x].getName());
						s[x] = pathFotos + "/" + ficheros[x].getName();
						t[x] = ficheros[x].getName();
					//	uploadFotos(s[x],date2);
						 URL u = new URL (customURL+t[x]);
						HttpURLConnection huc =  ( HttpURLConnection )  u.openConnection (); 
						huc.setRequestMethod ("GET");  //OR  huc.setRequestMethod ("HEAD"); 
						huc.connect () ; 
						huc.getResponseCode();
						Log.i("Foto", "CarlosQ: =====================> Respuesta " + huc.getResponseCode());
						if(huc.getResponseCode()==200){
							moveFile(pathFotosN, t[x], pathFotosF);
							Log.i("Foto", "CarlosQ: ================>  En el servidor y Movido ====>" + t[x] );
						}else if(huc.getResponseCode()==404){
							uploadFotos(s[x],date2);
							Log.i("Foto", "CarlosQ: =================> Enviado Sin Moverse ====>" + t[x] );
						}
					}
					// first parameter is d files second parameter is zip file name
					
				} else {
					Log.i(null, "lista 2: " + "No existe el directorio");
				}
				// first parameter is d files second parameter is zip file name

			} catch (Exception e) {
				// TODO Auto-generated catch block
				Log.i(null, "error zip: " + "_" + e.getMessage());
			}

			

			return date2;
		}
		
		
		protected void onProgressUpdate (Float... valores) {
              int p = Math.round(100*valores[0]);

          }



		protected void onPostExecute(String date2) {
			super.onPostExecute(date2);

	}

	}

	private void moveFile(String inputPath, String inputFile, String outputPath) {

InputStream in = null;
OutputStream out = null;
try {

//create output directory if it doesn't exist
File dir = new File (outputPath); 
if (!dir.exists())
{
    dir.mkdirs();
}


in = new FileInputStream(inputPath + inputFile);        
out = new FileOutputStream(outputPath + inputFile);

byte[] buffer = new byte[1024];
int read;
while ((read = in.read(buffer)) != -1) {
    out.write(buffer, 0, read);
}
in.close();
in = null;

    // write the output file
    out.flush();
out.close();
out = null;

// delete the original file
new File(inputPath + inputFile).delete();  


} 

 catch (FileNotFoundException fnfe1) {
Log.i(null,"Archivos  tag"+ fnfe1.getMessage());
}
  catch (Exception e) {
	  Log.i(null,"Archivos  tag"+ e.getMessage());
}

}

	

	


}
