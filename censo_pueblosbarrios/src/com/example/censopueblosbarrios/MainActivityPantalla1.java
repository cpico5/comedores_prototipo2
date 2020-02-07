package com.example.censopueblosbarrios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import com.example.censopuelosbarrios.R;

import android.annotation.SuppressLint;
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
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
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

	private static final String LOG_TAG = "Pantalla 1";
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
	
	

	public EditText editOtroNoticias, editOtroPeriodico, editOtroRedes;
	public EditText txtSeccion, txtFolio;
	public RadioGroup  rdPregunta5a, rdPregunta5b, rdPregunta5c, rdPregunta5d, rdPregunta5e, rdPregunta5f,
			rdPregunta5g, rdPregunta5h, rdPregunta5i, rdPregunta5j, rdPregunta5k, rdPregunta5l;
	public RadioGroup   rdPregunta79a, rdPregunta79a1, rdPregunta79a2, rdPregunta79a3;
	public RadioGroup rdPregunta5m, rdPregunta5n, rdPregunta5o, rdPregunta5p, rdPregunta5q, rdPregunta5r, rdPregunta5s,
			rdPregunta5t;
	public RadioGroup rdPreguntaJefe, rdPreguntaAporta, rdPreguntaAbandono, rdPregunta6e;

	public RadioGroup   rdPreguntaHijos, rdPregunta81, rdPregunta86a, rdPregunta86b, rdPregunta86c, rdPregunta86d,
			rdPregunta86e, rdPregunta86f, rdPregunta86g;

	public EditText editPregunta7c, editPregunta5e,   editPregunta5h, editPregunta5k,
			editPregunta5l,  editPregunta29a, editPregunta35;
	public RadioGroup    rdPregunta13, rdPregunta14 ;
	public RadioGroup  rdPregunta14a, rdPregunta16a, rdPregunta18a, rdPregunta20a;
	public RadioGroup  rdPregunta14b, rdPregunta16b, rdPregunta18b, rdPregunta20b;
	public RadioGroup rdPregunta23, rdPregunta23a, rdPregunta24;
	public RadioGroup  rdPregunta21, rdPregunta22;
	public RadioGroup rdPregunta1a, rdPregunta1a0, rdPregunta1a2, rdPregunta1b, rdPregunta1c, rdPregunta1d,
			rdPregunta1e, rdPregunta1f, rdPregunta1g, rdPregunta1h, rdPregunta1i;
	public RadioGroup rdPregunta2c, rdPregunta2d, rdPregunta2e, rdPregunta2f, rdPregunta2g, rdPregunta2h, rdPregunta2i;

	public RadioButton radio11_1, radio11_2, radio11_3, radio11_4, radio11_5, radio11_6, radio11_7, radio11_8,
			radio11_9, radio11_10, radio11_11, radio11_12, radio11_0,radio12_0_1,radio12_0_2;
	public RadioButton radio13_1, radio13_2, radio13_3, radio13_4, radio13_5, radio13_6, radio13_7, radio13_8,
			radio13_9, radio13_10, radio13_11, radio13_12, radio13_0;
	public RadioButton radio_abandono1,radio_abandono2,radio_abandono3;

	public EditText     editPregunta13, editPregunta16,
			editPregunta21, editPregunta23, editPregunta24;
	public RadioGroup rdPregunta26a, rdPregunta280, rdPregunta28a, rdPregunta28b,  rdPregunta29a,
			rdPregunta29b;

	public RadioGroup rdPregunta34, rdPregunta34a, rdPregunta34b, rdPregunta34c, rdPregunta35, rdPregunta36,
			rdPregunta36a, rdPregunta37, rdPregunta38;
	public RadioGroup rdPregunta51, rdPregunta55, rdPregunta56;

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
	
	private Spinner spinner14a_1;
	private Spinner spinner14a_2;
	private Spinner spinner14a_3;
	private Spinner spinner14a_4;
	private Spinner spinner14a_5;
	
	private Spinner spinner14b_1;
	private Spinner spinner14b_2;
	private Spinner spinner14b_3;
	private Spinner spinner14b_4;
	private Spinner spinner14b_5;
	
	private Spinner spinner14c_1;
	private Spinner spinner14c_2;
	private Spinner spinner14c_3;
	private Spinner spinner14c_4;
	private Spinner spinner14c_5;
	
	private Spinner spinner16a_1;
	private Spinner spinner16a_2;
	private Spinner spinner16a_3;
	private Spinner spinner16a_4;
	private Spinner spinner16a_5;
	
	private Spinner spinner17a_1;
	private Spinner spinner17b_1;
	private Spinner spinner17c_1;
	
	private Spinner spinner17a_2;
	private Spinner spinner17b_2;
	private Spinner spinner17c_2;
	

	
	private Spinner spinner20_1;
	private Spinner spinner20_2;
	private Spinner spinner20_3;
	private Spinner spinner20_4;
	private Spinner spinner20_5;
	
	private Spinner spinner20_1p;
	private Spinner spinner20_2p;
	private Spinner spinner20_3p;
	private Spinner spinner20_4p;
	private Spinner spinner20_5p;
	
	private Spinner spinner20b_1;
	private Spinner spinner20b_2;
	private Spinner spinner20b_3;
	private Spinner spinner20b_4;
	private Spinner spinner20b_5;
	
	private Spinner spinner20b_1p;
	private Spinner spinner20b_2p;
	private Spinner spinner20b_3p;
	private Spinner spinner20b_4p;
	private Spinner spinner20b_5p;
	
	private Spinner spinner20c_1;
	private Spinner spinner20c_2;
	private Spinner spinner20c_3;
	private Spinner spinner20c_4;
	private Spinner spinner20c_5;
	
	private Spinner spinner20c_1p;
	private Spinner spinner20c_2p;
	private Spinner spinner20c_3p;
	private Spinner spinner20c_4p;
	private Spinner spinner20c_5p;
	
	private Spinner spinner34a_1;
	private Spinner spinner34a_2;
	private Spinner spinner34a_3;
	private Spinner spinner34a_4;
	private Spinner spinner34a_5;
	
	private Spinner spinner34b_1;
	private Spinner spinner34b_2;
	private Spinner spinner34b_3;
	private Spinner spinner34b_4;
	private Spinner spinner34b_5;
	
	private Spinner spinner34c_1;
	private Spinner spinner34c_2;
	private Spinner spinner34c_3;
	private Spinner spinner34c_4;
	private Spinner spinner34c_5;
	
	private Spinner spinner41a_1;
	private Spinner spinner41a_2;
	private Spinner spinner41a_3;
	private Spinner spinner41a_4;
	private Spinner spinner41a_5;
	
	private Spinner spinner42a_1;
	private Spinner spinner42a_2;
	private Spinner spinner42a_3;
	private Spinner spinner42a_4;
	private Spinner spinner42a_5;
	
	private Spinner spinner43_1;
	private Spinner spinner43_2;
	private Spinner spinner43_3;
	private Spinner spinner43_4;
	private Spinner spinner43_5;
	
	private Spinner spinner43_1p;
	private Spinner spinner43_2p;
	private Spinner spinner43_3p;
	private Spinner spinner43_4p;
	private Spinner spinner43_5p;
	
	private Spinner spinner55a_1;
	private Spinner spinner55a_2;
	private Spinner spinner55a_3;
	private Spinner spinner55a_4;
	private Spinner spinner55a_5;
	
	private Spinner spinner55b_1;
	private Spinner spinner55b_2;
	private Spinner spinner55b_3;
	private Spinner spinner55b_4;
	private Spinner spinner55b_5;
	
	private Spinner spinner55c_1;
	private Spinner spinner55c_2;
	private Spinner spinner55c_3;
	private Spinner spinner55c_4;
	private Spinner spinner55c_5;
	
	private Spinner spinner60a_1;
	private Spinner spinner60a_2;
	private Spinner spinner60a_3;
	private Spinner spinner60a_4;
	private Spinner spinner60a_5;
	
	private Spinner spinner61a_1;
	private Spinner spinner61a_2;
	private Spinner spinner61a_3;
	private Spinner spinner61a_4;
	private Spinner spinner61a_5;
	
	private Spinner spinner62_1;
	private Spinner spinner62_2;
	private Spinner spinner62_3;
	private Spinner spinner62_4;
	private Spinner spinner62_5;
	
	private Spinner spinner62_1p;
	private Spinner spinner62_2p;
	private Spinner spinner62_3p;
	private Spinner spinner62_4p;
	private Spinner spinner62_5p;
	
	
	
	private Spinner spinner90i;

	String elDelegado;

	Timer timer;


	public String edad_1;
	public String edad_2;
	public String edad_3;
	public String edad_4;
	public String edad_5;
	
	public String op1="sin datos";
	public String op2="sin datos";
	public String op3="sin datos";
	public String op4="sin datos";
	public String op5="sin datos";
	public String op6="sin datos";
	public String op6a="sin datos";
	public String op6b="sin datos";
	public String op6c="sin datos";
	public String op7="sin datos";
	public String op7a="sin datos";
	public String op8_1="sin datos";
	public String op9_1="sin datos";
	public String op10_1="sin datos";
	public String op10a_1="sin datos";
	public String op10b_1="sin datos";
	public String op10c_1="sin datos";
	public String op11_1="sin datos";
	public String op12_1="sin datos";
	public String op12a_1="sin datos";
	public String op12b_1="sin datos";
	public String op13_1="sin datos";
	public String op13a_1="sin datos";
	public String op13b_1="sin datos";
	public String op13c_1="sin datos";
	public String op14_1="sin datos";
	public String op14a_1="sin datos";
	public String op14b_1="sin datos";
	public String op8_2="sin datos";
	public String op9_2="sin datos";
	public String op10_2="sin datos";
	public String op10a_2="sin datos";
	public String op10b_2="sin datos";
	public String op10c_2="sin datos";
	public String op11_2="sin datos";
	public String op12_2="sin datos";
	public String op12a_2="sin datos";
	public String op12b_2="sin datos";
	public String op13_2="sin datos";
	public String op13a_2="sin datos";
	public String op13b_2="sin datos";
	public String op13c_2="sin datos";
	public String op14_2="sin datos";
	public String op14a_2="sin datos";
	public String op14b_2="sin datos";
	public String op15="sin datos";
	public String op15a="sin datos";
	public String op16_1="sin datos";
	public String op17_1="sin datos";
	public String op17a_1="sin datos";
	public String op17b_1="sin datos";
	public String op17c_1="sin datos";
	public String op18_1="sin datos";
	public String op19_1="sin datos";
	public String op20_1="sin datos";
	public String op21_1="sin datos";
	public String op22_1="sin datos";
	public String op22a_1="sin datos";
	public String op23_1="sin datos";
	public String op16_2="sin datos";
	public String op17_2="sin datos";
	public String op17a_2="sin datos";
	public String op17b_2="sin datos";
	public String op17c_2="sin datos";
	public String op18_2="sin datos";
	public String op19_2="sin datos";
	public String op20_2="sin datos";
	public String op21_2="sin datos";
	public String op22_2="sin datos";
	public String op22a_2="sin datos";
	public String op23_2="sin datos";
	public String op90="sin datos";
	public String op90a="sin datos";
	public String op90b="sin datos";
	public String op90c="sin datos";
	public String op90d="sin datos";
	public String op90e="sin datos";
	public String op90f="sin datos";
	public String op90g="sin datos";
	public String op90h="sin datos";
	public String op90i="sin datos";
	public String op90j="sin datos";

	
	public String opEstadoCivil="sin datos";
	public String opHijos="sin datos";
	public String opJefe="sin datos";
	public String opAporta="sin datos";
	public String opEstudio="sin datos";
	public String opAbandono="sin datos";
	public String opOcupacion="sin datos";
	public String opE1a="sin datos";
	public String opE1b="sin datos";
	public String opCoche="sin datos";
	public String opE3="sin datos";
	public String opFocos="sin datos";
	public String opCuantosCoches="sin datos";
	public String opTrabajo="sin datos";
	public String opE7="sin datos";
	
	
	public String opCuartos="sin datos";
	public String opCuartosDormir="sin datos";
	public String opE4="sin datos";
	public String opE91a="sin datos";
	public String opE92="sin datos";
	public String opBanos="sin datos";
	public String opE101="sin datos";
	public String opE102a="sin datos";
	public String opE103="sin datos";
	public String opRegadera="sin datos";
	public String opInternet="sin datos";
	public String opTrabajaron="sin datos";
	public String opEstufa="sin datos";
	public String opEdad="sin datos";
	public String opGenero="sin datos";
	public String opTipoVivienda="sin datos";
	public String opTipoPiso="sin datos";


	public RadioGroup rdPregunta1;
	public RadioGroup rdPregunta2;
	public RadioGroup rdPregunta3;
	public RadioGroup rdPregunta4;
	public RadioGroup rdPregunta5;
	public RadioGroup rdPregunta6;
	public RadioGroup rdPregunta6a;
	public RadioGroup rdPregunta6b;
	public RadioGroup rdPregunta6c;
	public RadioGroup rdPregunta7;
	public RadioGroup rdPregunta7a;
	public RadioGroup rdPregunta8_1;
	public RadioGroup rdPregunta9_1;
	public RadioGroup rdPregunta10_1;
	public RadioGroup rdPregunta10a_1;
	public RadioGroup rdPregunta10b_1;
	public RadioGroup rdPregunta10c_1;
	public RadioGroup rdPregunta11_1;
	public RadioGroup rdPregunta12_1;
	public RadioGroup rdPregunta12a_1;
	public RadioGroup rdPregunta12b_1;
	public RadioGroup rdPregunta13_1;
	public RadioGroup rdPregunta13a_1;
	public RadioGroup rdPregunta13b_1;
	public RadioGroup rdPregunta13c_1;
	public RadioGroup rdPregunta14_1;
	public RadioGroup rdPregunta14a_1;
	public RadioGroup rdPregunta14b_1;
	public RadioGroup rdPregunta8_2;
	public RadioGroup rdPregunta9_2;
	public RadioGroup rdPregunta10_2;
	public RadioGroup rdPregunta10a_2;
	public RadioGroup rdPregunta10b_2;
	public RadioGroup rdPregunta10c_2;
	public RadioGroup rdPregunta11_2;
	public RadioGroup rdPregunta12_2;
	public RadioGroup rdPregunta12a_2;
	public RadioGroup rdPregunta12b_2;
	public RadioGroup rdPregunta13_2;
	public RadioGroup rdPregunta13a_2;
	public RadioGroup rdPregunta13b_2;
	public RadioGroup rdPregunta13c_2;
	public RadioGroup rdPregunta14_2;
	public RadioGroup rdPregunta14a_2;
	public RadioGroup rdPregunta14b_2;
	public RadioGroup rdPregunta15;
	public RadioGroup rdPregunta15a;
	public RadioGroup rdPregunta16_1;
	public RadioGroup rdPregunta17_1;
	public RadioGroup rdPregunta17a_1;
	public RadioGroup rdPregunta17b_1;
	public RadioGroup rdPregunta17c_1;
	public RadioGroup rdPregunta18_1;
	public RadioGroup rdPregunta19_1;
	public RadioGroup rdPregunta20_1;
	public RadioGroup rdPregunta21_1;
	public RadioGroup rdPregunta22_1;
	public RadioGroup rdPregunta22a_1;
	public RadioGroup rdPregunta23_1;
	public RadioGroup rdPregunta16_2;
	public RadioGroup rdPregunta17_2;
	public RadioGroup rdPregunta17a_2;
	public RadioGroup rdPregunta17b_2;
	public RadioGroup rdPregunta17c_2;
	public RadioGroup rdPregunta18_2;
	public RadioGroup rdPregunta19_2;
	public RadioGroup rdPregunta20_2;
	public RadioGroup rdPregunta21_2;
	public RadioGroup rdPregunta22_2;
	public RadioGroup rdPregunta22a_2;
	public RadioGroup rdPregunta23_2;
	public RadioGroup rdPregunta90;
	public RadioGroup rdPregunta90a;
	public RadioGroup rdPregunta90b;
	public RadioGroup rdPregunta90c;
	public RadioGroup rdPregunta90d;
	public RadioGroup rdPregunta90e;
	public RadioGroup rdPregunta90f;
	public RadioGroup rdPregunta90g;
	public RadioGroup rdPregunta90h;
	public RadioGroup rdPregunta90i;
	public RadioGroup rdPregunta90j;

	
	public EditText editPregunta1;
	public EditText editPregunta2;
	public EditText editPregunta3;
	public EditText editPregunta4;
	public EditText editPregunta5;
	public EditText editPregunta6;
	public EditText editPregunta6a;
	public EditText editPregunta6b;
	public EditText editPregunta6c;
	public EditText editPregunta7;
	public EditText editPregunta7a;
	public EditText editPregunta8_1;
	public EditText editPregunta9_1;
	public EditText editPregunta10_1;
	public EditText editPregunta10a_1;
	public EditText editPregunta10b_1;
	public EditText editPregunta10c_1;
	public EditText editPregunta11_1;
	public EditText editPregunta12_1;
	public EditText editPregunta12a_1;
	public EditText editPregunta13_1;
	public EditText editPregunta13a_1;
	public EditText editPregunta13b_1;
	public EditText editPregunta13c_1;
	public EditText editPregunta14_1;
	public EditText editPregunta14a_1;
	public EditText editPregunta14b_1;
	public EditText editPregunta8_2;
	public EditText editPregunta9_2;
	public EditText editPregunta10_2;
	public EditText editPregunta10a_2;
	public EditText editPregunta10b_2;
	public EditText editPregunta10c_2;
	public EditText editPregunta11_2;
	public EditText editPregunta12_2;
	public EditText editPregunta12a_2;
	public EditText editPregunta13_2;
	public EditText editPregunta13a_2;
	public EditText editPregunta13b_2;
	public EditText editPregunta13c_2;
	public EditText editPregunta15;
	public EditText editPregunta15a;
	public EditText editPregunta16_1;
	public EditText editPregunta17_1;
	public EditText editPregunta17a_1;
	public EditText editPregunta17b_1;
	public EditText editPregunta17c_1;
	public EditText editPregunta18_1;
	public EditText editPregunta19_1;
	public EditText editPregunta20_1;
	public EditText editPregunta21_1;
	public EditText editPregunta22_1;
	public EditText editPregunta22a_1;
	public EditText editPregunta23_1;
	public EditText editPregunta16_2;
	public EditText editPregunta17_2;
	public EditText editPregunta17a_2;
	public EditText editPregunta17b_2;
	public EditText editPregunta17c_2;
	public EditText editPregunta18_2;
	public EditText editPregunta19_2;
	public EditText editPregunta20_2;
	public EditText editPregunta21_2;
	public EditText editPregunta22_2;
	public EditText editPregunta22a_2;
	public EditText editPregunta23_2;
	public EditText editPregunta90;
	public EditText editPregunta90a;
	public EditText editPregunta90b;
	public EditText editPregunta90c;
	public EditText editPregunta90d;
	public EditText editPregunta90e;
	public EditText editPregunta90f;
	public EditText editPregunta90g;
	public EditText editPregunta90h;
	public EditText editPregunta90i;
	public EditText editPregunta90j;



	
	public EditText editPreguntaOcupacion;


	public String captura1;
	public String captura2;
	public String captura3;
	public String captura4;
	public String captura5;
	public String captura6;
	public String captura6a;
	public String captura6b;
	public String captura6c;
	public String captura7;
	public String captura7a;
	public String captura8_1;
	public String captura9_1;
	public String captura10_1;
	public String captura10a_1;
	public String captura10b_1;
	public String captura10c_1;
	public String captura11_1;
	public String captura12_1;
	public String captura12a_1;
	public String captura12b_1;
	public String captura13_1;
	public String captura13a_1;
	public String captura13b_1;
	public String captura13c_1;
	public String captura14_1;
	public String captura14a_1;
	public String captura14b_1;
	public String captura8_2;
	public String captura9_2;
	public String captura10_2;
	public String captura10a_2;
	public String captura10b_2;
	public String captura10c_2;
	public String captura11_2;
	public String captura12_2;
	public String captura12a_2;
	public String captura12b_2;
	public String captura13_2;
	public String captura13a_2;
	public String captura13b_2;
	public String captura13c_2;
	public String captura14_2;
	public String captura14a_2;
	public String captura14b_2;
	public String captura15;
	public String captura15a;
	public String captura16_1;
	public String captura17_1;
	public String captura17a_1;
	public String captura17b_1;
	public String captura17c_1;
	public String captura18_1;
	public String captura19_1;
	public String captura20_1;
	public String captura21_1;
	public String captura22_1;
	public String captura22a_1;
	public String captura23_1;
	public String captura16_2;
	public String captura17_2;
	public String captura17a_2;
	public String captura17b_2;
	public String captura17c_2;
	public String captura18_2;
	public String captura19_2;
	public String captura20_2;
	public String captura21_2;
	public String captura22_2;
	public String captura22a_2;
	public String captura23_2;
	public String captura90;
	public String captura90a;
	public String captura90b;
	public String captura90c;
	public String captura90d;
	public String captura90e;
	public String captura90f;
	public String captura90g;
	public String captura90h;
	public String captura90i;
	public String captura90j;





	public Resources res;

	UsuariosSQLiteHelper3 usdbh3;
	private SQLiteDatabase db3;

	LinearLayout lay1;
	LinearLayout lay2;
	LinearLayout lay3;
	LinearLayout lay4;
	LinearLayout lay5;
	LinearLayout lay6;
	LinearLayout lay6a;
	LinearLayout lay6b;
	LinearLayout lay6c;
	LinearLayout lay7;
	LinearLayout lay7a;
	LinearLayout lay8_1;
	LinearLayout lay9_1;
	LinearLayout lay10_1;
	LinearLayout lay10a_1;
	LinearLayout lay10b_1;
	LinearLayout lay10c_1;
	LinearLayout lay11_1;
	LinearLayout lay12_1;
	LinearLayout lay12a_1;
	LinearLayout lay12b_1;
	LinearLayout lay13_1;
	LinearLayout lay13a_1;
	LinearLayout lay13b_1;
	LinearLayout lay13c_1;
	LinearLayout lay14_1;
	LinearLayout lay14a_1;
	LinearLayout lay14b_1;
	LinearLayout lay8_2;
	LinearLayout lay9_2;
	LinearLayout lay10_2;
	LinearLayout lay10a_2;
	LinearLayout lay10b_2;
	LinearLayout lay10c_2;
	LinearLayout lay11_2;
	LinearLayout lay12_2;
	LinearLayout lay12a_2;
	LinearLayout lay12b_2;
	LinearLayout lay13_2;
	LinearLayout lay13a_2;
	LinearLayout lay13b_2;
	LinearLayout lay13c_2;
	LinearLayout lay14_2;
	LinearLayout lay14a_2;
	LinearLayout lay14b_2;
	LinearLayout lay15;
	LinearLayout lay15a;
	LinearLayout lay16_1;
	LinearLayout lay17_1;
	LinearLayout lay17a_1;
	LinearLayout lay17b_1;
	LinearLayout lay17c_1;
	LinearLayout lay18_1;
	LinearLayout lay19_1;
	LinearLayout lay20_1;
	LinearLayout lay21_1;
	LinearLayout lay22_1;
	LinearLayout lay22a_1;
	LinearLayout lay23_1;
	LinearLayout lay16_2;
	LinearLayout lay17_2;
	LinearLayout lay17a_2;
	LinearLayout lay17b_2;
	LinearLayout lay17c_2;
	LinearLayout lay18_2;
	LinearLayout lay19_2;
	LinearLayout lay20_2;
	LinearLayout lay21_2;
	LinearLayout lay22_2;
	LinearLayout lay22a_2;
	LinearLayout lay23_2;
	LinearLayout lay90;
	LinearLayout lay90a;
	LinearLayout lay90b;
	LinearLayout lay90c;
	LinearLayout lay90d;
	LinearLayout lay90e;
	LinearLayout lay90f;
	LinearLayout lay90g;
	LinearLayout lay90h;
	LinearLayout lay90i;
	LinearLayout lay90j;

//	LinearLayout layEstadisticas;
	LinearLayout layEst;
	LinearLayout layEdad;
	LinearLayout layHijos;
	LinearLayout layAporta;
	LinearLayout layOcupacion;
	LinearLayout layTrabajaron;
	LinearLayout layCoche;
	LinearLayout layCuartos;
	LinearLayout layCuartosDormir;
	LinearLayout layFocos;
	LinearLayout layBanos;
	LinearLayout layRegadera;
	LinearLayout layInternet;
	LinearLayout layEstufa;
	LinearLayout layTipoPiso;
	LinearLayout layTipoVivienda;
	LinearLayout layGenero;
	LinearLayout layCuantosCoches;
	


	public RadioButton radio1_07;

	public String captura10a, captura11a,  captura13a, captura14a, captura14b, captura14c;
	public String   captura13, captura14,  captura16,   captura18a;
	public String captura21, captura22, captura23, captura23a, captura24;
	public String capturaMedio;
	public String capturaSemana;
	public String capturaFinSemana, capturaHijos;


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

	public String cachaDelegacion() {
		Bundle datos = this.getIntent().getExtras();
		String delegacion = datos.getString("delegacion");
		return delegacion;
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
	

	
	public void dialogoFoto() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Encuestador, tomar foto de la Fachada").setTitle("Foto de Fachada").setCancelable(false)
				.setPositiveButton("CONTINUAR", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

						detenerGrabacion();

						elMaximo = Integer.parseInt(sacaMaximo().toString());
						
						Log.i(LOG_TAG, ">>>>>>>>>>  Consecutivo"+ elMaximo);
						elMaximo = Integer.parseInt(sacaMaximo().toString());
						Intent i = new Intent(MainActivityPantalla1.this, FotoEvidencia.class);
						i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						i.putExtra("Nombre", cachaNombre());
						i.putExtra("consecutivo_diario", elMaximo);
						i.putExtra("seccion", txtSeccion.getText().toString());
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
		setContentView(R.layout.activity_pantalla1); // COMENTAR ESTA CUANDO

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

//		timer = new Timer();
//		timer.schedule(new CierraEncuesta(), 1800000); // 8 Minutos 480000

		////////////////////////
		txtSeccion = (EditText) findViewById(R.id.txtSeccion);

		txtSeccion.setText(cachaSeccion());
		txtSeccion.setEnabled(false);
		
		radio_abandono1 =(RadioButton)findViewById(R.id.radio_abandono1);
		radio_abandono2 =(RadioButton)findViewById(R.id.radio_abandono2);
		radio_abandono3 =(RadioButton)findViewById(R.id.radio_abandono3);
		
		radio12_0_1 =(RadioButton)findViewById(R.id.radio12_0_1);
		radio12_0_2 =(RadioButton)findViewById(R.id.radio12_0_2);

		rdPregunta1 = (RadioGroup)findViewById(R.id.rdPregunta1);
		rdPregunta2 = (RadioGroup)findViewById(R.id.rdPregunta2);
		rdPregunta3 = (RadioGroup)findViewById(R.id.rdPregunta3);
		rdPregunta4 = (RadioGroup)findViewById(R.id.rdPregunta4);
		rdPregunta5 = (RadioGroup)findViewById(R.id.rdPregunta5);
		rdPregunta6 = (RadioGroup)findViewById(R.id.rdPregunta6);
		rdPregunta6a = (RadioGroup)findViewById(R.id.rdPregunta6a);
		rdPregunta6b = (RadioGroup)findViewById(R.id.rdPregunta6b);
		rdPregunta6c = (RadioGroup)findViewById(R.id.rdPregunta6c);
		rdPregunta7 = (RadioGroup)findViewById(R.id.rdPregunta7);
		rdPregunta7a = (RadioGroup)findViewById(R.id.rdPregunta7a);
		rdPregunta8_1 = (RadioGroup)findViewById(R.id.rdPregunta8_1);
		rdPregunta9_1 = (RadioGroup)findViewById(R.id.rdPregunta9_1);
		rdPregunta10_1 = (RadioGroup)findViewById(R.id.rdPregunta10_1);
		rdPregunta10a_1 = (RadioGroup)findViewById(R.id.rdPregunta10a_1);
		rdPregunta10b_1 = (RadioGroup)findViewById(R.id.rdPregunta10b_1);
		rdPregunta10c_1 = (RadioGroup)findViewById(R.id.rdPregunta10c_1);
		rdPregunta11_1 = (RadioGroup)findViewById(R.id.rdPregunta11_1);
		rdPregunta12_1 = (RadioGroup)findViewById(R.id.rdPregunta12_1);
		rdPregunta13_1 = (RadioGroup)findViewById(R.id.rdPregunta13_1);
		rdPregunta13a_1 = (RadioGroup)findViewById(R.id.rdPregunta13a_1);
		rdPregunta13b_1 = (RadioGroup)findViewById(R.id.rdPregunta13b_1);
		rdPregunta13c_1 = (RadioGroup)findViewById(R.id.rdPregunta13c_1);
		rdPregunta14_1 = (RadioGroup)findViewById(R.id.rdPregunta14_1);
		rdPregunta14a_1 = (RadioGroup)findViewById(R.id.rdPregunta14a_1);
		rdPregunta14b_1 = (RadioGroup)findViewById(R.id.rdPregunta14b_1);
		rdPregunta8_2 = (RadioGroup)findViewById(R.id.rdPregunta8_2);
		rdPregunta9_2 = (RadioGroup)findViewById(R.id.rdPregunta9_2);
		rdPregunta10_2 = (RadioGroup)findViewById(R.id.rdPregunta10_2);
		rdPregunta10a_2 = (RadioGroup)findViewById(R.id.rdPregunta10a_2);
		rdPregunta10b_2 = (RadioGroup)findViewById(R.id.rdPregunta10b_2);
		rdPregunta10c_2 = (RadioGroup)findViewById(R.id.rdPregunta10c_2);
		rdPregunta11_2 = (RadioGroup)findViewById(R.id.rdPregunta11_2);
		rdPregunta12_2 = (RadioGroup)findViewById(R.id.rdPregunta12_2);
		rdPregunta13_2 = (RadioGroup)findViewById(R.id.rdPregunta13_2);
		rdPregunta13a_2 = (RadioGroup)findViewById(R.id.rdPregunta13a_2);
		rdPregunta13b_2 = (RadioGroup)findViewById(R.id.rdPregunta13b_2);
		rdPregunta13c_2 = (RadioGroup)findViewById(R.id.rdPregunta13c_2);
		rdPregunta14_2 = (RadioGroup)findViewById(R.id.rdPregunta14_2);
		rdPregunta14a_2 = (RadioGroup)findViewById(R.id.rdPregunta14a_2);
		rdPregunta14b_2 = (RadioGroup)findViewById(R.id.rdPregunta14b_2);
		rdPregunta15 = (RadioGroup)findViewById(R.id.rdPregunta15);
		rdPregunta15a = (RadioGroup)findViewById(R.id.rdPregunta15a);
		rdPregunta16_1 = (RadioGroup)findViewById(R.id.rdPregunta16_1);
		rdPregunta17_1 = (RadioGroup)findViewById(R.id.rdPregunta17_1);
		rdPregunta17a_1 = (RadioGroup)findViewById(R.id.rdPregunta17a_1);
		rdPregunta17b_1 = (RadioGroup)findViewById(R.id.rdPregunta17b_1);
		rdPregunta17c_1 = (RadioGroup)findViewById(R.id.rdPregunta17c_1);
		rdPregunta18_1 = (RadioGroup)findViewById(R.id.rdPregunta18_1);
		rdPregunta19_1 = (RadioGroup)findViewById(R.id.rdPregunta19_1);
		rdPregunta20_1 = (RadioGroup)findViewById(R.id.rdPregunta20_1);
		rdPregunta21_1 = (RadioGroup)findViewById(R.id.rdPregunta21_1);
		rdPregunta22_1 = (RadioGroup)findViewById(R.id.rdPregunta22_1);
		rdPregunta22a_1 = (RadioGroup)findViewById(R.id.rdPregunta22a_1);
		rdPregunta23_1 = (RadioGroup)findViewById(R.id.rdPregunta23_1);
		rdPregunta16_2 = (RadioGroup)findViewById(R.id.rdPregunta16_2);
		rdPregunta17_2 = (RadioGroup)findViewById(R.id.rdPregunta17_2);
		rdPregunta17a_2 = (RadioGroup)findViewById(R.id.rdPregunta17a_2);
		rdPregunta17b_2 = (RadioGroup)findViewById(R.id.rdPregunta17b_2);
		rdPregunta17c_2 = (RadioGroup)findViewById(R.id.rdPregunta17c_2);
		rdPregunta18_2 = (RadioGroup)findViewById(R.id.rdPregunta18_2);
		rdPregunta19_2 = (RadioGroup)findViewById(R.id.rdPregunta19_2);
		rdPregunta20_2 = (RadioGroup)findViewById(R.id.rdPregunta20_2);
		rdPregunta21_2 = (RadioGroup)findViewById(R.id.rdPregunta21_2);
		rdPregunta22_2 = (RadioGroup)findViewById(R.id.rdPregunta22_2);
		rdPregunta22a_2 = (RadioGroup)findViewById(R.id.rdPregunta22a_2);
		rdPregunta23_2 = (RadioGroup)findViewById(R.id.rdPregunta23_2);
		rdPregunta90 = (RadioGroup)findViewById(R.id.rdPregunta90);
		rdPregunta90a = (RadioGroup)findViewById(R.id.rdPregunta90a);
		rdPregunta90b = (RadioGroup)findViewById(R.id.rdPregunta90b);
		rdPregunta90c = (RadioGroup)findViewById(R.id.rdPregunta90c);
		rdPregunta90d = (RadioGroup)findViewById(R.id.rdPregunta90d);
		rdPregunta90e = (RadioGroup)findViewById(R.id.rdPregunta90e);
		rdPregunta90f = (RadioGroup)findViewById(R.id.rdPregunta90f);
		rdPregunta90g = (RadioGroup)findViewById(R.id.rdPregunta90g);
		rdPregunta90h = (RadioGroup)findViewById(R.id.rdPregunta90h);
		rdPregunta90i = (RadioGroup)findViewById(R.id.rdPregunta90i);
		rdPregunta90j = (RadioGroup)findViewById(R.id.rdPregunta90j);
		
		rdPreguntaHijos = (RadioGroup) findViewById(R.id.rdPreguntaHijos);
		rdPreguntaAporta = (RadioGroup) findViewById(R.id.rdPreguntaAporta);
		rdPreguntaAbandono = (RadioGroup) findViewById(R.id.rdPreguntaAbandono);
		rdPreguntaOcupacion = (RadioGroup) findViewById(R.id.rdPreguntaOcupacion);
		rdPreguntaCoche = (RadioGroup) findViewById(R.id.rdPreguntaCoche);
		rdPreguntaCuantosCoches = (RadioGroup) findViewById(R.id.rdPreguntaCuantosCoches);
		rdPreguntaCuartos = (RadioGroup) findViewById(R.id.rdPreguntaCuartos);
		rdPreguntaCuartosDormir = (RadioGroup) findViewById(R.id.rdPreguntaCuartosDormir);
		rdPreguntaFocos = (RadioGroup) findViewById(R.id.rdPreguntaFocos);
		rdPreguntaBanos = (RadioGroup) findViewById(R.id.rdPreguntaBanos);
		rdPreguntaRegadera = (RadioGroup) findViewById(R.id.rdPreguntaRegadera);
		rdPreguntaInternet = (RadioGroup) findViewById(R.id.rdPreguntaInternet);
		rdPreguntaTrabajaron = (RadioGroup) findViewById(R.id.rdPreguntaTrabajaron);
		rdPreguntaEstufa = (RadioGroup) findViewById(R.id.rdPreguntaEstufa);
		rdPreguntaEdad = (RadioGroup) findViewById(R.id.rdPreguntaEdad);
		rdPreguntaGenero = (RadioGroup) findViewById(R.id.rdPreguntaGenero);
		rdPreguntaTipoVivienda = (RadioGroup) findViewById(R.id.rdPreguntaTipoVivienda);
		rdPreguntaTipoPiso = (RadioGroup) findViewById(R.id.rdPreguntaTipoPiso);
		
		
		
		
		editPregunta12_1= (EditText)findViewById(R.id.editPregunta12_1);
		editPregunta12a_1= (EditText)findViewById(R.id.editPregunta12a_1);
		editPregunta16_1= (EditText)findViewById(R.id.editPregunta16_1);
		editPregunta18_1= (EditText)findViewById(R.id.editPregunta18_1);
		editPregunta19_1= (EditText)findViewById(R.id.editPregunta19_1);
		editPregunta21_1= (EditText)findViewById(R.id.editPregunta21_1);
		editPregunta22a_1= (EditText)findViewById(R.id.editPregunta22a_1);
		
		editPregunta12_2= (EditText)findViewById(R.id.editPregunta12_2);
		editPregunta12a_2= (EditText)findViewById(R.id.editPregunta12a_2);
		editPregunta16_2= (EditText)findViewById(R.id.editPregunta16_2);
		editPregunta18_2= (EditText)findViewById(R.id.editPregunta18_2);
		editPregunta19_2= (EditText)findViewById(R.id.editPregunta19_2);
		editPregunta21_2= (EditText)findViewById(R.id.editPregunta21_2);
		editPregunta22a_2= (EditText)findViewById(R.id.editPregunta22a_2);
		
		editPregunta90a= (EditText)findViewById(R.id.editPregunta90a);
		editPregunta90b= (EditText)findViewById(R.id.editPregunta90b);
		editPregunta90c= (EditText)findViewById(R.id.editPregunta90c);
		editPregunta90d= (EditText)findViewById(R.id.editPregunta90d);
		editPregunta90e= (EditText)findViewById(R.id.editPregunta90e);
		editPregunta90f= (EditText)findViewById(R.id.editPregunta90f);
		editPregunta90g= (EditText)findViewById(R.id.editPregunta90g);
		editPregunta90h= (EditText)findViewById(R.id.editPregunta90h);
//		editPregunta90i= (EditText)findViewById(R.id.editPregunta90i);
		editPregunta90j= (EditText)findViewById(R.id.editPregunta90j);


		res = getResources();
		
		captura1 =res.getString(R.string.PREGUNTA1);
		captura2 =res.getString(R.string.PREGUNTA2);
		captura3 =res.getString(R.string.PREGUNTA3);
		captura4 =res.getString(R.string.PREGUNTA4);
		captura5 =res.getString(R.string.PREGUNTA5);
		captura6 =res.getString(R.string.PREGUNTA6);
		captura6a =res.getString(R.string.PREGUNTA6a);
		captura6b =res.getString(R.string.PREGUNTA6b);
		captura6c =res.getString(R.string.PREGUNTA6c);
		captura7 =res.getString(R.string.PREGUNTA7);
		captura7a =res.getString(R.string.PREGUNTA7a);
		captura8_1 =res.getString(R.string.PREGUNTA8_1);
		captura9_1 =res.getString(R.string.PREGUNTA9_1);
		captura10_1 =res.getString(R.string.PREGUNTA10_1);
		captura10a_1 =res.getString(R.string.PREGUNTA10a_1);
		captura10b_1 =res.getString(R.string.PREGUNTA10b_1);
		captura10c_1 =res.getString(R.string.PREGUNTA10c_1);
		captura11_1 =res.getString(R.string.PREGUNTA11_1);
		captura12_1 =res.getString(R.string.PREGUNTA12_1);
		captura12a_1 =res.getString(R.string.PREGUNTA12a_1);
		captura12b_1 =res.getString(R.string.PREGUNTA12b_1);
		captura13_1 =res.getString(R.string.PREGUNTA13_1);
		captura13a_1 =res.getString(R.string.PREGUNTA13a_1);
		captura13b_1 =res.getString(R.string.PREGUNTA13b_1);
		captura13c_1 =res.getString(R.string.PREGUNTA13c_1);
		captura14_1 =res.getString(R.string.PREGUNTA14_1);
		captura14a_1 =res.getString(R.string.PREGUNTA14a_1);
		captura14b_1 =res.getString(R.string.PREGUNTA14b_1);
		captura8_2 =res.getString(R.string.PREGUNTA8_2);
		captura9_2 =res.getString(R.string.PREGUNTA9_2);
		captura10_2 =res.getString(R.string.PREGUNTA10_2);
		captura10a_2 =res.getString(R.string.PREGUNTA10a_2);
		captura10b_2 =res.getString(R.string.PREGUNTA10b_2);
		captura10c_2 =res.getString(R.string.PREGUNTA10c_2);
		captura11_2 =res.getString(R.string.PREGUNTA11_2);
		captura12_2 =res.getString(R.string.PREGUNTA12_2);
		captura12a_2 =res.getString(R.string.PREGUNTA12a_2);
		captura12b_2 =res.getString(R.string.PREGUNTA12b_2);
		captura13_2 =res.getString(R.string.PREGUNTA13_2);
		captura13a_2 =res.getString(R.string.PREGUNTA13a_2);
		captura13b_2 =res.getString(R.string.PREGUNTA13b_2);
		captura13c_2 =res.getString(R.string.PREGUNTA13c_2);
		captura14_2 =res.getString(R.string.PREGUNTA14_2);
		captura14a_2 =res.getString(R.string.PREGUNTA14a_2);
		captura14b_2 =res.getString(R.string.PREGUNTA14b_2);
		captura15 =res.getString(R.string.PREGUNTA15);
		captura15a =res.getString(R.string.PREGUNTA15a);
		captura16_1 =res.getString(R.string.PREGUNTA16_1);
		captura17_1 =res.getString(R.string.PREGUNTA17_1);
		captura17a_1 =res.getString(R.string.PREGUNTA17a_1);
		captura17b_1 =res.getString(R.string.PREGUNTA17b_1);
		captura17c_1 =res.getString(R.string.PREGUNTA17c_1);
		captura18_1 =res.getString(R.string.PREGUNTA18_1);
		captura19_1 =res.getString(R.string.PREGUNTA19_1);
		captura20_1 =res.getString(R.string.PREGUNTA20_1);
		captura21_1 =res.getString(R.string.PREGUNTA21_1);
		captura22_1 =res.getString(R.string.PREGUNTA22_1);
		captura22a_1 =res.getString(R.string.PREGUNTA22a_1);
		captura23_1 =res.getString(R.string.PREGUNTA23_1);
		captura16_2 =res.getString(R.string.PREGUNTA16_2);
		captura17_2 =res.getString(R.string.PREGUNTA17_2);
		captura17a_2 =res.getString(R.string.PREGUNTA17a_2);
		captura17b_2 =res.getString(R.string.PREGUNTA17b_2);
		captura17c_2 =res.getString(R.string.PREGUNTA17c_2);
		captura18_2 =res.getString(R.string.PREGUNTA18_2);
		captura19_2 =res.getString(R.string.PREGUNTA19_2);
		captura20_2 =res.getString(R.string.PREGUNTA20_2);
		captura21_2 =res.getString(R.string.PREGUNTA21_2);
		captura22_2 =res.getString(R.string.PREGUNTA22_2);
		captura22a_2 =res.getString(R.string.PREGUNTA22a_2);
		captura23_2 =res.getString(R.string.PREGUNTA23_2);
		captura90 =res.getString(R.string.PREGUNTA90);
		captura90a =res.getString(R.string.PREGUNTA90a);
		captura90b =res.getString(R.string.PREGUNTA90b);
		captura90c =res.getString(R.string.PREGUNTA90c);
		captura90d =res.getString(R.string.PREGUNTA90d);
		captura90e =res.getString(R.string.PREGUNTA90e);
		captura90f =res.getString(R.string.PREGUNTA90f);
		captura90g =res.getString(R.string.PREGUNTA90g);
		captura90h =res.getString(R.string.PREGUNTA90h);
		captura90i =res.getString(R.string.PREGUNTA90i);
		captura90j =res.getString(R.string.PREGUNTA90j);
		
		capturaHijos=res.getString(R.string.PREGUNTAHIJOS);
		capturaAporta=res.getString(R.string.PREGUNTAAPORTA);
		capturaOcupacion=res.getString(R.string.PREGUNTAOCUPACION);
		capturaCoche=res.getString(R.string.PREGUNTACOCHE);
		capturaCuantosCoches=res.getString(R.string.PREGUNTACUANTOSCOCHES);
		capturaFocos=res.getString(R.string.PREGUNTAFOCOS);
		capturaCuartos=res.getString(R.string.PREGUNTACUARTOS);
		capturaCuartosDormir=res.getString(R.string.PREGUNTACUARTOSDORMIR);
		capturaBanos=res.getString(R.string.PREGUNTABANOS);
		capturaRegadera=res.getString(R.string.PREGUNTAREGADERA);
		capturaInternet=res.getString(R.string.PREGUNTAINTERNET);
		capturaTrabajaron=res.getString(R.string.PREGUNTATRABAJARON);
		capturaEstufa=res.getString(R.string.PREGUNTAESTUFA);
		capturaEdad=res.getString(R.string.PREGUNTAEDAD);
		capturaGenero=res.getString(R.string.PREGUNTAGENERO);
		capturaTipoVivienda=res.getString(R.string.PREGUNTA_TIPO_VIVIENDA);
		capturaTipoPiso=res.getString(R.string.PREGUNTA_TIPO_PISO);



		
		lay1 = (LinearLayout) findViewById(R.id.lay1);
		lay2 = (LinearLayout) findViewById(R.id.lay2);
		lay3 = (LinearLayout) findViewById(R.id.lay3);
		lay4 = (LinearLayout) findViewById(R.id.lay4);
		lay5 = (LinearLayout) findViewById(R.id.lay5);
		lay6 = (LinearLayout) findViewById(R.id.lay6);
		lay6a = (LinearLayout) findViewById(R.id.lay6a);
		lay6b = (LinearLayout) findViewById(R.id.lay6b);
		lay6c = (LinearLayout) findViewById(R.id.lay6c);
		lay7 = (LinearLayout) findViewById(R.id.lay7);
		lay7a = (LinearLayout) findViewById(R.id.lay7a);
		lay8_1 = (LinearLayout) findViewById(R.id.lay8_1);
		lay9_1 = (LinearLayout) findViewById(R.id.lay9_1);
		lay10_1 = (LinearLayout) findViewById(R.id.lay10_1);
		lay10a_1 = (LinearLayout) findViewById(R.id.lay10a_1);
		lay10b_1 = (LinearLayout) findViewById(R.id.lay10b_1);
		lay10c_1 = (LinearLayout) findViewById(R.id.lay10c_1);
		lay11_1 = (LinearLayout) findViewById(R.id.lay11_1);
		lay12_1 = (LinearLayout) findViewById(R.id.lay12_1);
		lay13_1 = (LinearLayout) findViewById(R.id.lay13_1);
		lay13a_1 = (LinearLayout) findViewById(R.id.lay13a_1);
		lay13b_1 = (LinearLayout) findViewById(R.id.lay13b_1);
		lay13c_1 = (LinearLayout) findViewById(R.id.lay13c_1);
		lay14_1 = (LinearLayout) findViewById(R.id.lay14_1);
		lay14a_1 = (LinearLayout) findViewById(R.id.lay14a_1);
		lay14b_1 = (LinearLayout) findViewById(R.id.lay14b_1);
		lay8_2 = (LinearLayout) findViewById(R.id.lay8_2);
		lay9_2 = (LinearLayout) findViewById(R.id.lay9_2);
		lay10_2 = (LinearLayout) findViewById(R.id.lay10_2);
		lay10a_2 = (LinearLayout) findViewById(R.id.lay10a_2);
		lay10b_2 = (LinearLayout) findViewById(R.id.lay10b_2);
		lay10c_2 = (LinearLayout) findViewById(R.id.lay10c_2);
		lay11_2 = (LinearLayout) findViewById(R.id.lay11_2);
		lay12_2 = (LinearLayout) findViewById(R.id.lay12_2);
		lay13_2 = (LinearLayout) findViewById(R.id.lay13_2);
		lay13a_2 = (LinearLayout) findViewById(R.id.lay13a_2);
		lay13b_2 = (LinearLayout) findViewById(R.id.lay13b_2);
		lay13c_2 = (LinearLayout) findViewById(R.id.lay13c_2);
		lay14_2 = (LinearLayout) findViewById(R.id.lay14_2);
		lay14a_2 = (LinearLayout) findViewById(R.id.lay14a_2);
		lay14b_2 = (LinearLayout) findViewById(R.id.lay14b_2);
		lay15 = (LinearLayout) findViewById(R.id.lay15);
		lay15a = (LinearLayout) findViewById(R.id.lay15a);
		lay16_1 = (LinearLayout) findViewById(R.id.lay16_1);
		lay17_1 = (LinearLayout) findViewById(R.id.lay17_1);
		lay17a_1 = (LinearLayout) findViewById(R.id.lay17a_1);
		lay17b_1 = (LinearLayout) findViewById(R.id.lay17b_1);
		lay17c_1 = (LinearLayout) findViewById(R.id.lay17c_1);
		lay18_1 = (LinearLayout) findViewById(R.id.lay18_1);
		lay19_1 = (LinearLayout) findViewById(R.id.lay19_1);
		lay20_1 = (LinearLayout) findViewById(R.id.lay20_1);
		lay21_1 = (LinearLayout) findViewById(R.id.lay21_1);
		lay22_1 = (LinearLayout) findViewById(R.id.lay22_1);
		lay22a_1 = (LinearLayout) findViewById(R.id.lay22a_1);
		lay23_1 = (LinearLayout) findViewById(R.id.lay23_1);
		lay16_2 = (LinearLayout) findViewById(R.id.lay16_2);
		lay17_2 = (LinearLayout) findViewById(R.id.lay17_2);
		lay17a_2 = (LinearLayout) findViewById(R.id.lay17a_2);
		lay17b_2 = (LinearLayout) findViewById(R.id.lay17b_2);
		lay17c_2 = (LinearLayout) findViewById(R.id.lay17c_2);
		lay18_2 = (LinearLayout) findViewById(R.id.lay18_2);
		lay19_2 = (LinearLayout) findViewById(R.id.lay19_2);
		lay20_2 = (LinearLayout) findViewById(R.id.lay20_2);
		lay21_2 = (LinearLayout) findViewById(R.id.lay21_2);
		lay22_2 = (LinearLayout) findViewById(R.id.lay22_2);
		lay22a_2 = (LinearLayout) findViewById(R.id.lay22a_2);
		lay23_2 = (LinearLayout) findViewById(R.id.lay23_2);
		lay90 = (LinearLayout) findViewById(R.id.lay90);
		lay90a = (LinearLayout) findViewById(R.id.lay90a);
		lay90b = (LinearLayout) findViewById(R.id.lay90b);
		lay90c = (LinearLayout) findViewById(R.id.lay90c);
		lay90d = (LinearLayout) findViewById(R.id.lay90d);
		lay90e = (LinearLayout) findViewById(R.id.lay90e);
		lay90f = (LinearLayout) findViewById(R.id.lay90f);
		lay90g = (LinearLayout) findViewById(R.id.lay90g);
		lay90h = (LinearLayout) findViewById(R.id.lay90h);
		lay90i = (LinearLayout) findViewById(R.id.lay90i);
		lay90j = (LinearLayout) findViewById(R.id.lay90j);
		
		layEst= (LinearLayout) findViewById(R.id.layEst);
		layEdad= (LinearLayout) findViewById(R.id.layEdad);
		layHijos= (LinearLayout) findViewById(R.id.layHijos);
		layAporta= (LinearLayout) findViewById(R.id.layAporta);
		layOcupacion= (LinearLayout) findViewById(R.id.layOcupacion);
		layTrabajaron= (LinearLayout) findViewById(R.id.layTrabajaron);
		layCoche= (LinearLayout) findViewById(R.id.laycoche);
		layCuartos= (LinearLayout) findViewById(R.id.layCuartos);
		layCuartosDormir= (LinearLayout) findViewById(R.id.layCuartosDormir);
		layFocos= (LinearLayout) findViewById(R.id.layFocos);
		layBanos= (LinearLayout) findViewById(R.id.layBanos);
		layRegadera= (LinearLayout) findViewById(R.id.layRegadera);
		layInternet= (LinearLayout) findViewById(R.id.layInternet);
		layEstufa= (LinearLayout) findViewById(R.id.layEstufa);
		layTipoPiso= (LinearLayout) findViewById(R.id.layTipoPiso);
		layTipoVivienda= (LinearLayout) findViewById(R.id.layTipoVivienda);
		layGenero= (LinearLayout) findViewById(R.id.layGenero);
		layCuantosCoches= (LinearLayout) findViewById(R.id.layCuantosCoches);



				
//		preg_clas_2.xml


		
		btnGuardar = (Button) findViewById(R.id.btnGuardar);
		btnSalir = (Button) findViewById(R.id.btnSalir);
		btnSalir.setEnabled(false);
		btnSalir.setVisibility(View.GONE);

//				ocultaEstadisticas();
		
		spinner17a_1= (Spinner)findViewById(R.id.spinner17a_1);
		spinner17a_2= (Spinner)findViewById(R.id.spinner17a_2);
		

		CargaSpinner17a_1();
		CargaSpinner17a_2();
		
		
		spinner17b_1= (Spinner)findViewById(R.id.spinner17b_1);
		spinner17b_2= (Spinner)findViewById(R.id.spinner17b_2);
		

		CargaSpinner17b_1();
		CargaSpinner17b_2();
		
		
		spinner17c_1= (Spinner)findViewById(R.id.spinner17c_1);
		spinner17c_2= (Spinner)findViewById(R.id.spinner17c_2);
		
		CargaSpinner17c_1();
		CargaSpinner17c_2();
		
		
		
		
		spinner90i= (Spinner)findViewById(R.id.spinner90i);
		CargaSpinner90i();
		
		lay2 .setVisibility(View.GONE);
		lay3 .setVisibility(View.GONE);
		lay4 .setVisibility(View.GONE);
		lay5 .setVisibility(View.GONE);
		lay6 .setVisibility(View.GONE);
		lay6a .setVisibility(View.GONE);
		lay6b .setVisibility(View.GONE);
		lay6c .setVisibility(View.GONE);
		lay7 .setVisibility(View.GONE);
		lay7a .setVisibility(View.GONE);
		
		op2 ="No aplica";
		op3 ="No aplica";
		op4 ="No aplica";
		op5 ="No aplica";
		op6 ="No aplica";
		op6a ="No aplica";
		op6b ="No aplica";
		op6c ="No aplica";
		op7 ="No aplica";
		op7a ="No aplica";
		
		
		rdPregunta2 .clearCheck();
		rdPregunta3 .clearCheck();
		rdPregunta4 .clearCheck();
		rdPregunta5 .clearCheck();
		rdPregunta6 .clearCheck();
		rdPregunta6a .clearCheck();
		rdPregunta6b .clearCheck();
		rdPregunta6c .clearCheck();
		rdPregunta7 .clearCheck();
		rdPregunta7a .clearCheck();
		
		

			ocultaTodo();	
			
			ocultaMenorConDiscapacidad_1();
			ocultaMenorConDiscapacidad_2();
			
	
		rdPregunta1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.radio1) {
					op1 = "No abren";
					
					radio_abandono2.setChecked(true);
					lay2.setVisibility(View.GONE); 
					op2="No aplica";
					rdPregunta2.clearCheck();


					lay2 .setVisibility(View.GONE);
					lay3 .setVisibility(View.GONE);
					lay4 .setVisibility(View.GONE);
					lay5 .setVisibility(View.GONE);
					lay6 .setVisibility(View.GONE);
					lay6a .setVisibility(View.GONE);
					lay6b .setVisibility(View.GONE);
					lay6c .setVisibility(View.GONE);
					lay7 .setVisibility(View.GONE);
					lay7a .setVisibility(View.GONE);


					op2="No aplica";
					op3="No aplica";
					op4="No aplica";
					op5="No aplica";
					op6a="No aplica";
					op6b="No aplica";
					op6c="No aplica";
					op7="No aplica";
					op7a="No aplica";
					
					rdPregunta2.clearCheck();
					rdPregunta3.clearCheck();
					rdPregunta4.clearCheck();
					rdPregunta5.clearCheck();
					rdPregunta6a.clearCheck();
					rdPregunta6b.clearCheck();
					rdPregunta6c.clearCheck();
					rdPregunta7.clearCheck();
					rdPregunta7a.clearCheck();

					ocultaEstadisticas();


					lay90.setVisibility(View.VISIBLE); 
					lay90a.setVisibility(View.VISIBLE); 
					lay90b.setVisibility(View.VISIBLE); 
					lay90c.setVisibility(View.VISIBLE); 
					lay90d.setVisibility(View.VISIBLE); 
					lay90e.setVisibility(View.VISIBLE); 
					lay90f.setVisibility(View.VISIBLE); 
					lay90g.setVisibility(View.VISIBLE); 
					lay90h.setVisibility(View.VISIBLE); 
					lay90i.setVisibility(View.VISIBLE); 
					lay90j.setVisibility(View.VISIBLE); 
					
					
					ocultaMenorConDiscapacidad_1();
					ocultaMenorConDiscapacidad_2();


					
					lay15.setVisibility(View.GONE); 
					op15="No aplica";
					rdPregunta15.clearCheck();
					lay15a.setVisibility(View.GONE); 
					op15a="No aplica";
					rdPregunta15a.clearCheck();



				}
				else if (checkedId == R.id.radio0) {
					op1 = "Si abren";
					radio_abandono1.setChecked(true);
					lay2.setVisibility(View.VISIBLE); 
					op2="sin datos"; 

					ocultaAdulto_1();
					ocultaAdulto_2();
					lay15.setVisibility(View.GONE); 
					op15="No aplica";
					rdPregunta15.clearCheck();
					lay15a.setVisibility(View.GONE); 
					op15a="No aplica";
					rdPregunta15a.clearCheck();

				}
			}
		});

		rdPregunta2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.radio1) {
					op2 = "Acepta Cuestionario";
					radio_abandono1.setChecked(true);
					
					lay3 .setVisibility(View.VISIBLE);
					lay4 .setVisibility(View.VISIBLE);
					lay5 .setVisibility(View.VISIBLE);
					lay6 .setVisibility(View.VISIBLE);
					lay6a .setVisibility(View.VISIBLE);
					lay6b .setVisibility(View.VISIBLE);
					lay6c .setVisibility(View.VISIBLE);
					lay7 .setVisibility(View.VISIBLE);
					
					
					op3="sin datos";
					op4 ="sin datos";
					op5 ="sin datos";
					op6 ="sin datos";
					op6a="sin datos";
					op6b="sin datos";
					op6c="sin datos";
					op7 ="sin datos";
				
					
					rdPregunta3.clearCheck();
					rdPregunta4 .clearCheck();
					rdPregunta5 .clearCheck();
					rdPregunta6 .clearCheck();
					rdPregunta6a.clearCheck();
					rdPregunta6b.clearCheck();
					rdPregunta6c.clearCheck();
					rdPregunta7 .clearCheck();
				
					
					
				}
				else if (checkedId == R.id.radio2) {
					op2 = "No acepta por el momento o es menor quien abre";
					radio_abandono3.setChecked(true);
					
					ocultaEstadisticas();
					lay3 .setVisibility(View.GONE);
					lay4 .setVisibility(View.GONE);
					lay5 .setVisibility(View.GONE);
					lay6 .setVisibility(View.GONE);
					lay6a .setVisibility(View.GONE);
					lay6b .setVisibility(View.GONE);
					lay6c .setVisibility(View.GONE);
					lay7 .setVisibility(View.GONE);
					lay7a .setVisibility(View.GONE);
					op3="No aplica";
					op4 ="No aplica";
					op5 ="No aplica";
					op6 ="No aplica";
					op6a="No aplica";
					op6b="No aplica";
					op6c="No aplica";
					op7 ="No aplica";
					op7a="No aplica";
					rdPregunta3.clearCheck();
					rdPregunta4 .clearCheck();
					rdPregunta5 .clearCheck();
					rdPregunta6 .clearCheck();
					rdPregunta6a.clearCheck();
					rdPregunta6b.clearCheck();
					rdPregunta6c.clearCheck();
					rdPregunta7 .clearCheck();
					rdPregunta7a.clearCheck();
					
					
//					ocultaAdulto_1();
//					ocultaAdulto_2();
//					
					
					
					lay90.setVisibility(View.VISIBLE); 
					lay90a.setVisibility(View.VISIBLE); 
					lay90b.setVisibility(View.VISIBLE); 
					lay90c.setVisibility(View.VISIBLE); 
					lay90d.setVisibility(View.VISIBLE); 
					lay90e.setVisibility(View.VISIBLE); 
					lay90f.setVisibility(View.VISIBLE); 
					lay90g.setVisibility(View.VISIBLE); 
					lay90h.setVisibility(View.VISIBLE); 
					lay90i.setVisibility(View.VISIBLE); 
					lay90j.setVisibility(View.VISIBLE); 
				}
				else if (checkedId == R.id.radio3) {
					op2 = "No tiene posibilidades de responder";
					radio_abandono3.setChecked(true);
					
					ocultaEstadisticas();
					lay3 .setVisibility(View.GONE);
					lay4 .setVisibility(View.GONE);
					lay5 .setVisibility(View.GONE);
					lay6 .setVisibility(View.GONE);
					lay6a .setVisibility(View.GONE);
					lay6b .setVisibility(View.GONE);
					lay6c .setVisibility(View.GONE);
					lay7 .setVisibility(View.GONE);
					lay7a .setVisibility(View.GONE);
					
					op3="No aplica";
					op4 ="No aplica";
					op5 ="No aplica";
					op6 ="No aplica";
					op6a="No aplica";
					op6b="No aplica";
					op6c="No aplica";
					op7 ="No aplica";
					op7a="No aplica";
					
					rdPregunta3.clearCheck();
					rdPregunta4 .clearCheck();
					rdPregunta5 .clearCheck();
					rdPregunta6 .clearCheck();
					rdPregunta6a.clearCheck();
					rdPregunta6b.clearCheck();
					rdPregunta6c.clearCheck();
					rdPregunta7 .clearCheck();
					rdPregunta7a.clearCheck();
					
					
//					ocultaAdulto_1();
//					ocultaAdulto_2();
//					
					
					
					lay90.setVisibility(View.VISIBLE); 
					lay90a.setVisibility(View.VISIBLE); 
					lay90b.setVisibility(View.VISIBLE); 
					lay90c.setVisibility(View.VISIBLE); 
					lay90d.setVisibility(View.VISIBLE); 
					lay90e.setVisibility(View.VISIBLE); 
					lay90f.setVisibility(View.VISIBLE); 
					lay90g.setVisibility(View.VISIBLE); 
					lay90h.setVisibility(View.VISIBLE); 
					lay90i.setVisibility(View.VISIBLE); 
					lay90j.setVisibility(View.VISIBLE); 
				}
				else if (checkedId == R.id.radio0) {
					op2 = "No acepta cuestionario";
					radio_abandono3.setChecked(true);
					
					ocultaEstadisticas();
					lay3 .setVisibility(View.GONE);
					lay4 .setVisibility(View.GONE);
					lay5 .setVisibility(View.GONE);
					lay6 .setVisibility(View.GONE);
					lay6a .setVisibility(View.GONE);
					lay6b .setVisibility(View.GONE);
					lay6c .setVisibility(View.GONE);
					lay7 .setVisibility(View.GONE);
					lay7a .setVisibility(View.GONE);
					
					op3="No aplica";
					op4 ="No aplica";
					op5 ="No aplica";
					op6 ="No aplica";
					op6a="No aplica";
					op6b="No aplica";
					op6c="No aplica";
					op7 ="No aplica";
					op7a="No aplica";
					
					rdPregunta3.clearCheck();
					rdPregunta4 .clearCheck();
					rdPregunta5 .clearCheck();
					rdPregunta6 .clearCheck();
					rdPregunta6a.clearCheck();
					rdPregunta6b.clearCheck();
					rdPregunta6c.clearCheck();
					rdPregunta7 .clearCheck();
					rdPregunta7a.clearCheck();
					
					
					
//					ocultaAdulto_1();
//					ocultaAdulto_2();
//					
					
					
					lay90.setVisibility(View.VISIBLE); 
					lay90a.setVisibility(View.VISIBLE); 
					lay90b.setVisibility(View.VISIBLE); 
					lay90c.setVisibility(View.VISIBLE); 
					lay90d.setVisibility(View.VISIBLE); 
					lay90e.setVisibility(View.VISIBLE); 
					lay90f.setVisibility(View.VISIBLE); 
					lay90g.setVisibility(View.VISIBLE); 
					lay90h.setVisibility(View.VISIBLE); 
					lay90i.setVisibility(View.VISIBLE); 
					lay90j.setVisibility(View.VISIBLE); 
				}
			}
		});


		rdPregunta3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.radio1) {
					op3 = "Televisión";
				}
				else if (checkedId == R.id.radio2) {
					op3 = "Radio";
				}
				else if (checkedId == R.id.radio3) {
					op3 = "Periódico";
				}
				else if (checkedId == R.id.radio4) {
					op3 = "Redes sociales";
				}
				else if (checkedId == R.id.radio5) {
					op3 = "Internet";
				}
				else if (checkedId == R.id.radio6) {
					op3 = "Otra";
				}
				else if (checkedId == R.id.radio0) {
					op3 = "No sabe / No contestó";
				}
			}
		});

		rdPregunta4.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.radio1) {
					op4 = "Sí";
				}
				else if (checkedId == R.id.radio2) {
					op4 = "No";
				}
				else if (checkedId == R.id.radio0) {
					op4 = "No sabe / No contestó";
				}
			}
		});

		rdPregunta5.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.radio1) {
					op5 = "Sí";
				}
				else if (checkedId == R.id.radio2) {
					op5 = "No";
				}
				else if (checkedId == R.id.radio0) {
					op5 = "No sabe / No contestó";
				}
			}
		});

		rdPregunta6a.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.radio1) {
					op6a = "Lo tiene";
				}
				else if (checkedId == R.id.radio2) {
					op6a = "Tenía y ya no";
				}
				else if (checkedId == R.id.radio3) {
					op6a = "Nunca lo ha tenido";
				}
				else if (checkedId == R.id.radio0) {
					op6a = "No sabe / No contestó";
				}
			}
		});

		rdPregunta6b.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.radio1) {
					op6b = "Lo tiene";
				}
				else if (checkedId == R.id.radio2) {
					op6b = "Tenía y ya no";
				}
				else if (checkedId == R.id.radio3) {
					op6b = "Nunca lo ha tenido";
				}
				else if (checkedId == R.id.radio0) {
					op6b = "No sabe / No contestó";
				}
			}
		});

		rdPregunta6c.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.radio1) {
					op6c = "Lo tiene";
				}
				else if (checkedId == R.id.radio2) {
					op6c = "Tenía y ya no";
				}
				else if (checkedId == R.id.radio3) {
					op6c = "Nunca lo ha tenido";
				}
				else if (checkedId == R.id.radio0) {
					op6c = "No sabe / No contestó";
				}
			}
		});

		rdPregunta7.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.radio1) {
					op7 = "Sí";
					lay7a .setVisibility(View.VISIBLE);

			
				layEst.setVisibility(View.VISIBLE);
				layEdad.setVisibility(View.VISIBLE);
				layHijos.setVisibility(View.VISIBLE);
				layAporta.setVisibility(View.VISIBLE);
				layOcupacion.setVisibility(View.VISIBLE);
				layTrabajaron.setVisibility(View.VISIBLE);
				layCoche.setVisibility(View.VISIBLE);
				layCuantosCoches.setVisibility(View.VISIBLE);
				layCuartos.setVisibility(View.VISIBLE);
				layCuartosDormir.setVisibility(View.VISIBLE);
				layFocos.setVisibility(View.VISIBLE);
				layBanos.setVisibility(View.VISIBLE);
				layRegadera.setVisibility(View.VISIBLE);
				layInternet.setVisibility(View.VISIBLE);
				layEstufa.setVisibility(View.VISIBLE);
				layTipoPiso.setVisibility(View.VISIBLE);
				layTipoVivienda.setVisibility(View.VISIBLE);
				layGenero.setVisibility(View.VISIBLE);
				
				
				lay90.setVisibility(View.VISIBLE); 
				lay90a.setVisibility(View.VISIBLE); 
				lay90b.setVisibility(View.VISIBLE); 
				lay90c.setVisibility(View.VISIBLE); 
				lay90d.setVisibility(View.VISIBLE); 
				lay90e.setVisibility(View.VISIBLE); 
				lay90f.setVisibility(View.VISIBLE); 
				lay90g.setVisibility(View.VISIBLE); 
				lay90h.setVisibility(View.VISIBLE); 
				lay90i.setVisibility(View.VISIBLE); 
				lay90j.setVisibility(View.VISIBLE); 


				}
				else if (checkedId == R.id.radio2) {
					op7 = "No";
					lay7a.setVisibility(View.GONE);
					op7a="No aplica";
					rdPregunta7a.clearCheck();
					
					ocultaAdulto_1();
					ocultaAdulto_2();
					lay15 .setVisibility(View.VISIBLE);
					rdPregunta15.clearCheck();
			
					
					


				}
				else if (checkedId == R.id.radio0) {
					op7 = "No sabe / No contestó";
					lay7a.setVisibility(View.GONE);
					op7a="No aplica";
					rdPregunta7a.clearCheck();

					ocultaAdulto_1();
					ocultaAdulto_2();
					lay15 .setVisibility(View.VISIBLE);
					rdPregunta15.clearCheck();
					
					

				}
			}
		});

		rdPregunta7a.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.radio1) {
					op7a = "Una";
					muestraAdulto_1();
					ocultaAdulto_2();
					lay15.setVisibility(View.VISIBLE); 
					op15="sin datos";
					rdPregunta15.clearCheck();
					
					
					
				}
				else if (checkedId == R.id.radio2) {
					op7a = "Dos";
					
					muestraAdulto_1();
					muestraAdulto_2();
					lay15.setVisibility(View.VISIBLE); 
					op15="sin datos";
					rdPregunta15.clearCheck();
					
				}
				else if (checkedId == R.id.radio3) {
					op7a = "Tres";
					
					muestraAdulto_1();
					muestraAdulto_2();
					lay15.setVisibility(View.VISIBLE); 
					op15="sin datos";
					rdPregunta15.clearCheck();
					


				}
				else if (checkedId == R.id.radio4) {
					op7a = "Cuatro";
					
					muestraAdulto_1();
					muestraAdulto_2();
					lay15.setVisibility(View.VISIBLE); 
					op15="sin datos";
					rdPregunta15.clearCheck();
					

				}
				else if (checkedId == R.id.radio0) {
					op7a = "Cinco o más";
					
					muestraAdulto_1();
					muestraAdulto_2();
					lay15.setVisibility(View.VISIBLE); 
					op15="sin datos";
					rdPregunta15.clearCheck();
					


				}
			}
		});

		
		/////////////////////////  INICIA ADULTOS  /////////////////////////////
		
//// INICIA ADULTO_1  //

		rdPregunta8_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op8_1 = "Si";
					lay9_1.setVisibility(View.GONE);
					op9_1="No aplica";
					rdPregunta9_1.clearCheck();
					
					lay10a_1 .setVisibility(View.VISIBLE);
					lay10b_1 .setVisibility(View.VISIBLE);
					lay10c_1 .setVisibility(View.VISIBLE);
					lay11_1 .setVisibility(View.VISIBLE);
					lay12_1 .setVisibility(View.VISIBLE);
					lay13_1 .setVisibility(View.VISIBLE);
					lay13a_1 .setVisibility(View.VISIBLE);
					lay13b_1 .setVisibility(View.VISIBLE);
					lay13c_1 .setVisibility(View.VISIBLE);
					lay14_1 .setVisibility(View.VISIBLE);
					lay14a_1 .setVisibility(View.VISIBLE);
					lay14b_1 .setVisibility(View.VISIBLE);

					op10_1 ="sin datos";
					op10a_1 ="sin datos";
					op10b_1 ="sin datos";
					op10c_1 ="sin datos";
					op11_1 ="sin datos";
					op12_1 ="sin datos";
					op13a_1 ="sin datos";
					op13b_1 ="sin datos";
					op13c_1 ="sin datos";
					op14a_1 ="sin datos";
					op14b_1 ="sin datos";
					
					rdPregunta10_1.clearCheck();
					rdPregunta10a_1 .clearCheck();
					rdPregunta10b_1 .clearCheck();
					rdPregunta10c_1 .clearCheck();
					rdPregunta11_1.clearCheck();
					rdPregunta12_1.clearCheck();
					rdPregunta13a_1.clearCheck();
					rdPregunta13b_1.clearCheck();
					rdPregunta13c_1.clearCheck();
					rdPregunta14a_1.clearCheck();
					rdPregunta14b_1.clearCheck();

				}

				else if (checkedId == R.id.radio0) {

					op8_1 = "No";
					lay9_1.setVisibility(View.VISIBLE);
					op9_1="sin datos";
					rdPregunta9_1.clearCheck();

				}

			}

		});

		rdPregunta9_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op9_1 = "Si";
					lay10_1.setVisibility(View.VISIBLE);
					op10_1="sin datos";
					rdPregunta10_1.clearCheck();
					lay10a_1 .setVisibility(View.VISIBLE);
					lay10b_1 .setVisibility(View.VISIBLE);
					lay10c_1 .setVisibility(View.VISIBLE);
					lay11_1 .setVisibility(View.VISIBLE);
					lay12_1 .setVisibility(View.VISIBLE);
					lay13_1 .setVisibility(View.VISIBLE);
					lay13a_1 .setVisibility(View.VISIBLE);
					lay13b_1 .setVisibility(View.VISIBLE);
					lay13c_1 .setVisibility(View.VISIBLE);
					lay14_1 .setVisibility(View.VISIBLE);
					lay14a_1 .setVisibility(View.VISIBLE);
					lay14b_1 .setVisibility(View.VISIBLE);

					op10_1 ="sin datos";
					op10a_1 ="sin datos";
					op10b_1 ="sin datos";
					op10c_1 ="sin datos";
					op11_1 ="sin datos";
					op12_1 ="sin datos";
					op13a_1 ="sin datos";
					op13b_1 ="sin datos";
					op13c_1 ="sin datos";
					op14a_1 ="sin datos";
					op14b_1 ="sin datos";
					
					rdPregunta10_1.clearCheck();
					rdPregunta10a_1 .clearCheck();
					rdPregunta10b_1 .clearCheck();
					rdPregunta10c_1 .clearCheck();
					rdPregunta11_1.clearCheck();
					rdPregunta12_1.clearCheck();
					rdPregunta13a_1.clearCheck();
					rdPregunta13b_1.clearCheck();
					rdPregunta13c_1.clearCheck();
					rdPregunta14a_1.clearCheck();
					rdPregunta14b_1.clearCheck();
					

				}

				else if (checkedId == R.id.radio0) {

					op9_1 = "No";
					
					lay10_1 .setVisibility(View.GONE);
					lay10a_1 .setVisibility(View.GONE);
					lay10b_1 .setVisibility(View.GONE);
					lay10c_1 .setVisibility(View.GONE);
					lay11_1 .setVisibility(View.GONE);
					lay12_1 .setVisibility(View.GONE);
					lay13_1 .setVisibility(View.GONE);
					lay13a_1 .setVisibility(View.GONE);
					lay13b_1 .setVisibility(View.GONE);
					lay13c_1 .setVisibility(View.GONE);
					lay14_1 .setVisibility(View.GONE);
					lay14a_1 .setVisibility(View.GONE);
					lay14b_1 .setVisibility(View.GONE);

					op10_1 ="No aplica";
					op10a_1 ="No aplica";
					op10b_1 ="No aplica";
					op10c_1 ="No aplica";
					op11_1 ="No aplica";
					op12_1 ="No aplica";
					op13a_1 ="No aplica";
					op13b_1 ="No aplica";
					op13c_1 ="No aplica";
					op14a_1 ="No aplica";
					op14b_1 ="No aplica";
					
					rdPregunta10_1.clearCheck();
					rdPregunta10a_1 .clearCheck();
					rdPregunta10b_1 .clearCheck();
					rdPregunta10c_1 .clearCheck();
					rdPregunta11_1.clearCheck();
					rdPregunta12_1.clearCheck();
					rdPregunta13a_1.clearCheck();
					rdPregunta13b_1.clearCheck();
					rdPregunta13c_1.clearCheck();
					rdPregunta14a_1.clearCheck();
					rdPregunta14b_1.clearCheck();
					

				}

			}

		});

		rdPregunta10_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op10_1 = "Si";
					lay10a_1.setVisibility(View.VISIBLE);
					op10a_1="sin datos";
					rdPregunta10a_1.clearCheck();
					lay10b_1.setVisibility(View.VISIBLE);
					op10b_1="sin datos";
					rdPregunta10b_1.clearCheck();
					lay10c_1.setVisibility(View.VISIBLE);
					op10c_1="sin datos";
					rdPregunta10c_1.clearCheck();
					
					lay15.setVisibility(View.VISIBLE); 
					op15="sin datos";
					rdPregunta15.clearCheck();
					rdPregunta12_1.clearCheck();

				}

				else if (checkedId == R.id.radio2) {

					op10_1 = "No";
					lay10a_1.setVisibility(View.GONE);
					op10a_1="No aplica";
					rdPregunta10a_1.clearCheck();
					lay10b_1.setVisibility(View.GONE);
					op10b_1="No aplica";
					rdPregunta10b_1.clearCheck();
					lay10c_1.setVisibility(View.GONE);
					op10c_1="No aplica";
					rdPregunta10c_1.clearCheck();
					
					lay15.setVisibility(View.VISIBLE); 
					op15="sin datos";
					rdPregunta15.clearCheck();
					
					rdPregunta12_1.clearCheck();
					
					
					
					
					lay90.setVisibility(View.VISIBLE); 
					lay90a.setVisibility(View.VISIBLE); 
					lay90b.setVisibility(View.VISIBLE); 
					lay90c.setVisibility(View.VISIBLE); 
					lay90d.setVisibility(View.VISIBLE); 
					lay90e.setVisibility(View.VISIBLE); 
					lay90f.setVisibility(View.VISIBLE); 
					lay90g.setVisibility(View.VISIBLE); 
					lay90h.setVisibility(View.VISIBLE); 
					lay90i.setVisibility(View.VISIBLE); 
					lay90j.setVisibility(View.VISIBLE); 

				}

				else if (checkedId == R.id.radio0) {

					op10_1 = "No sabe / No contestó";
					lay10a_1.setVisibility(View.GONE);
					op10a_1="No aplica";
					rdPregunta10a_1.clearCheck();
					lay10b_1.setVisibility(View.GONE);
					op10b_1="No aplica";
					rdPregunta10b_1.clearCheck();
					lay10c_1.setVisibility(View.GONE);
					op10c_1="No aplica";
					rdPregunta10c_1.clearCheck();

					rdPregunta12_1.clearCheck();		
					
					
					lay90.setVisibility(View.VISIBLE); 
					lay90a.setVisibility(View.VISIBLE); 
					lay90b.setVisibility(View.VISIBLE); 
					lay90c.setVisibility(View.VISIBLE); 
					lay90d.setVisibility(View.VISIBLE); 
					lay90e.setVisibility(View.VISIBLE); 
					lay90f.setVisibility(View.VISIBLE); 
					lay90g.setVisibility(View.VISIBLE); 
					lay90h.setVisibility(View.VISIBLE); 
					lay90i.setVisibility(View.VISIBLE); 
					lay90j.setVisibility(View.VISIBLE); 

				}

			}

		});

		rdPregunta10a_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op10a_1 = "Octubre 2019 o antes";

				}

				else if (checkedId == R.id.radio2) {

					op10a_1 = "Noviembre 2019";

				}

				else if (checkedId == R.id.radio3) {

					op10a_1 = "Diciembre 2019	";

				}

				else if (checkedId == R.id.radio4) {

					op10a_1 = "Enero 2020";

				}

				else if (checkedId == R.id.radio5) {

					op10a_1 = "Febrero 2020";

				}

				else if (checkedId == R.id.radio0) {

					op10a_1 = "No sabe / No contestó";

				}

			}

		});

		rdPregunta10b_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op10b_1 = "Si";
					lay10c_1.setVisibility(View.VISIBLE);
					op10c_1="sin datos";
					rdPregunta10c_1.clearCheck();

				}

				else if (checkedId == R.id.radio2) {

					op10b_1 = "No";
					lay10c_1.setVisibility(View.GONE);
					op10c_1="No aplica";
					rdPregunta10c_1.clearCheck();

				}

				else if (checkedId == R.id.radio0) {

					op10b_1 = "No sabe / No contestó";
					lay10c_1.setVisibility(View.GONE);
					op10c_1="No aplica";
					rdPregunta10c_1.clearCheck();

				}

			}

		});

		rdPregunta10c_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op10c_1 = "Si";

				}

				else if (checkedId == R.id.radio2) {

					op10c_1 = "No";

				}

				else if (checkedId == R.id.radio3) {

					op10c_1 = "No lo sabe/ no ha checado";

				}

				else if (checkedId == R.id.radio0) {

					op10c_1 = "No contestó";

				}

			}

		});

		rdPregunta11_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.radio1) {
					op11_1 = "Masculino";
					
				}
				else if (checkedId == R.id.radio0) {
					op11_1 = "Femenino";
					
				}
			}
		});

		rdPregunta12_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				 if (checkedId == R.id.radio12_0_1) {

					op12_1 = "No sabe / No contestó";

					editPregunta12_1.setText("");
					editPregunta12a_1.setText("");
					
					
					if(op10_1.equals("No")){
						
						lay13_1 .setVisibility(View.VISIBLE);
						lay13a_1 .setVisibility(View.VISIBLE);
						lay13b_1 .setVisibility(View.VISIBLE);
						lay13c_1 .setVisibility(View.VISIBLE);
						lay14_1 .setVisibility(View.VISIBLE);
						lay14a_1 .setVisibility(View.VISIBLE);
						lay14b_1 .setVisibility(View.VISIBLE);

						op13a_1 ="sin datos";
						op13b_1 ="sin datos";
						op13c_1 ="sin datos";
						op14_1 ="sin datos";
						op14a_1 ="sin datos";
						op14b_1 ="sin datos";
						
						rdPregunta13a_1.clearCheck();
						rdPregunta13b_1.clearCheck();
						rdPregunta13c_1.clearCheck();
						rdPregunta14a_1.clearCheck();
						rdPregunta14b_1.clearCheck();
						
						
					}else{
					
					
					lay13_1 .setVisibility(View.GONE);
					lay13a_1 .setVisibility(View.GONE);
					lay13b_1 .setVisibility(View.GONE);
					lay13c_1 .setVisibility(View.GONE);
					lay14_1 .setVisibility(View.GONE);
					lay14a_1 .setVisibility(View.GONE);
					lay14b_1 .setVisibility(View.GONE);

					op13a_1 ="No aplica";
					op13b_1 ="No aplica";
					op13c_1 ="No aplica";
					op14_1 ="No aplica";
					op14a_1 ="No aplica";
					op14b_1 ="No aplica";
					
					rdPregunta13a_1.clearCheck();
					rdPregunta13b_1.clearCheck();
					rdPregunta13c_1.clearCheck();
					rdPregunta14a_1.clearCheck();
					rdPregunta14b_1.clearCheck();
					}

				}

			}

		});

		editPregunta12_1.addTextChangedListener(new TextWatcher() {
			@Override
			public void afterTextChanged(Editable s) {
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start,int count, int after) {
			}
			@Override
			public void onTextChanged(CharSequence s, int start,int before, int count) {
				if(s.length() != 0){
					

						rdPregunta12_1.clearCheck();
					
						String laEdad=editPregunta12_1.getText().toString();
						String losMeses=editPregunta12a_1.getText().toString();
						
						if(laEdad.length()==0){
							laEdad="0";
						}else{
							laEdad=laEdad;
						}
					
					if(losMeses.length()==0){
						losMeses="0";
					}else{
						losMeses=losMeses;
					}
					
					Integer edad=Integer.parseInt(laEdad);
					Integer meses=Integer.parseInt(losMeses);
					
					if(op10_1.equals("Si")){
						
						lay13_1 .setVisibility(View.GONE);
						lay13a_1 .setVisibility(View.GONE);
						lay13b_1 .setVisibility(View.GONE);
						lay13c_1 .setVisibility(View.GONE);
						lay14_1 .setVisibility(View.GONE);
						lay14a_1 .setVisibility(View.GONE);
						lay14b_1 .setVisibility(View.GONE);

						op13a_1 ="No aplica";
						op13b_1 ="No aplica";
						op13c_1 ="No aplica";
						op14a_1 ="No aplica";
						op14b_1 ="No aplica";
						
						rdPregunta13a_1.clearCheck();
						rdPregunta13b_1.clearCheck();
						rdPregunta13c_1.clearCheck();
						rdPregunta14a_1.clearCheck();
						rdPregunta14b_1.clearCheck();
						
					}else if(edad >= 68){
						lay13_1 .setVisibility(View.GONE);
						lay13a_1 .setVisibility(View.GONE);
						lay13b_1 .setVisibility(View.GONE);
						lay13c_1 .setVisibility(View.GONE);
						lay14_1 .setVisibility(View.GONE);
						lay14a_1 .setVisibility(View.GONE);
						lay14b_1 .setVisibility(View.GONE);

						op13a_1 ="No aplica";
						op13b_1 ="No aplica";
						op13c_1 ="No aplica";
						op14_1 ="No aplica";
						op14a_1 ="No aplica";
						op14b_1 ="No aplica";
						
						rdPregunta13a_1.clearCheck();
						rdPregunta13b_1.clearCheck();
						rdPregunta13c_1.clearCheck();
						rdPregunta14a_1.clearCheck();
						rdPregunta14b_1.clearCheck();
						
					}else if(edad >= 65  || (edad >= 67 && meses <=11)){
						lay13_1 .setVisibility(View.VISIBLE);
						lay13a_1 .setVisibility(View.VISIBLE);
						lay13b_1 .setVisibility(View.VISIBLE);
						lay13c_1 .setVisibility(View.VISIBLE);
						lay14_1 .setVisibility(View.VISIBLE);
						lay14a_1 .setVisibility(View.VISIBLE);
						lay14b_1 .setVisibility(View.VISIBLE);

						op13a_1 ="sin datos";
						op13b_1 ="sin datos";
						op13c_1 ="sin datos";
						op14_1 ="sin datos";
						op14a_1 ="sin datos";
						op14b_1 ="sin datos";
						
						rdPregunta13a_1.clearCheck();
						rdPregunta13b_1.clearCheck();
						rdPregunta13c_1.clearCheck();
						rdPregunta14a_1.clearCheck();
						rdPregunta14b_1.clearCheck();
						
					}else{
					
						lay13_1 .setVisibility(View.GONE);
						lay13a_1 .setVisibility(View.GONE);
						lay13b_1 .setVisibility(View.GONE);
						lay13c_1 .setVisibility(View.GONE);
						lay14_1 .setVisibility(View.GONE);
						lay14a_1 .setVisibility(View.GONE);
						lay14b_1 .setVisibility(View.GONE);

						op13a_1 ="No aplica";
						op13b_1 ="No aplica";
						op13c_1 ="No aplica";
						op14_1 ="No aplica";
						op14a_1 ="No aplica";
						op14b_1 ="No aplica";
						
						rdPregunta13a_1.clearCheck();
						rdPregunta13b_1.clearCheck();
						rdPregunta13c_1.clearCheck();
						rdPregunta14a_1.clearCheck();
						rdPregunta14b_1.clearCheck();
						
					}
					

				}

			}

		});
		
		editPregunta12a_1.addTextChangedListener(new TextWatcher() {
			@Override
			public void afterTextChanged(Editable s) {
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start,int count, int after) {
			}
			@Override
			public void onTextChanged(CharSequence s, int start,int before, int count) {
				if(s.length() != 0){
					
					rdPregunta12_1.clearCheck();
					String laEdad=editPregunta12_1.getText().toString();
					String losMeses=editPregunta12a_1.getText().toString();
					
					if(laEdad.length()==0){
						laEdad="0";
					}else{
						laEdad=laEdad;
					}
				
				if(losMeses.length()==0){
					losMeses="0";
				}else{
					losMeses=losMeses;
				}
				
				Integer edad=Integer.parseInt(laEdad);
				Integer meses=Integer.parseInt(losMeses);
					if(op10_1.equals("Si")){
						
						lay13_1 .setVisibility(View.GONE);
						lay13a_1 .setVisibility(View.GONE);
						lay13b_1 .setVisibility(View.GONE);
						lay13c_1 .setVisibility(View.GONE);
						lay14_1 .setVisibility(View.GONE);
						lay14a_1 .setVisibility(View.GONE);
						lay14b_1 .setVisibility(View.GONE);

						op13a_1 ="No aplica";
						op13b_1 ="No aplica";
						op13c_1 ="No aplica";
						op14a_1 ="No aplica";
						op14b_1 ="No aplica";
						
						rdPregunta13a_1.clearCheck();
						rdPregunta13b_1.clearCheck();
						rdPregunta13c_1.clearCheck();
						rdPregunta14a_1.clearCheck();
						rdPregunta14b_1.clearCheck();
					}else if(edad >= 68){
						lay13_1 .setVisibility(View.GONE);
						lay13a_1 .setVisibility(View.GONE);
						lay13b_1 .setVisibility(View.GONE);
						lay13c_1 .setVisibility(View.GONE);
						lay14_1 .setVisibility(View.GONE);
						lay14a_1 .setVisibility(View.GONE);
						lay14b_1 .setVisibility(View.GONE);

						op13a_1 ="No aplica";
						op13b_1 ="No aplica";
						op13c_1 ="No aplica";
						op14a_1 ="No aplica";
						op14b_1 ="No aplica";
						
						rdPregunta13a_1.clearCheck();
						rdPregunta13b_1.clearCheck();
						rdPregunta13c_1.clearCheck();
						rdPregunta14a_1.clearCheck();
						rdPregunta14b_1.clearCheck();
						
					}else if(edad >= 65  || (edad >= 67 && meses <=11)){
						lay13_1 .setVisibility(View.VISIBLE);
						lay13a_1 .setVisibility(View.VISIBLE);
						lay13b_1 .setVisibility(View.VISIBLE);
						lay13c_1 .setVisibility(View.VISIBLE);
						lay14_1 .setVisibility(View.VISIBLE);
						lay14a_1 .setVisibility(View.VISIBLE);
						lay14b_1 .setVisibility(View.VISIBLE);

						op13a_1 ="sin datos";
						op13b_1 ="sin datos";
						op13c_1 ="sin datos";
						op14_1 ="sin datos";
						op14a_1 ="sin datos";
						op14b_1 ="sin datos";
						
						rdPregunta13a_1.clearCheck();
						rdPregunta13b_1.clearCheck();
						rdPregunta13c_1.clearCheck();
						rdPregunta14a_1.clearCheck();
						rdPregunta14b_1.clearCheck();
					}else{
					
						lay13_1 .setVisibility(View.GONE);
						lay13a_1 .setVisibility(View.GONE);
						lay13b_1 .setVisibility(View.GONE);
						lay13c_1 .setVisibility(View.GONE);
						lay14_1 .setVisibility(View.GONE);
						lay14a_1 .setVisibility(View.GONE);
						lay14b_1 .setVisibility(View.GONE);

						op13a_1 ="No aplica";
						op13b_1 ="No aplica";
						op13c_1 ="No aplica";
						op14a_1 ="No aplica";
						op14b_1 ="No aplica";
						
						rdPregunta13a_1.clearCheck();
						rdPregunta13b_1.clearCheck();
						rdPregunta13c_1.clearCheck();
						rdPregunta14a_1.clearCheck();
						rdPregunta14b_1.clearCheck();
						
					}
					
				}

			}

		});

		rdPregunta13a_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op13a_1 = "Si";
					rdPregunta13c_1.clearCheck();
					lay14_1 .setVisibility(View.GONE);
					lay14a_1 .setVisibility(View.GONE);
					lay14b_1 .setVisibility(View.GONE);

					op14a_1 ="No aplica";
					op14b_1 ="No aplica";

					rdPregunta14a_1.clearCheck();
					rdPregunta14b_1.clearCheck();


				}

				else if (checkedId == R.id.radio2) {

					op13a_1 = "No";
					op13c_1="sin datos";
					rdPregunta13c_1.clearCheck();


				}

				else if (checkedId == R.id.radio0) {

					op13a_1 = "No sabe / No contestó";
					op13c_1="sin datos";
					rdPregunta13c_1.clearCheck();

				}

			}

		});

		rdPregunta13b_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op13b_1 = "Si";
					rdPregunta13c_1.clearCheck();
					
					lay14_1 .setVisibility(View.GONE);
					lay14a_1 .setVisibility(View.GONE);
					lay14b_1 .setVisibility(View.GONE);

					op14a_1 ="No aplica";
					op14b_1 ="No aplica";
					rdPregunta14a_1.clearCheck();
					rdPregunta14b_1.clearCheck();



				}

				else if (checkedId == R.id.radio2) {

					op13b_1 = "No";
					op13c_1="sin datos";
					rdPregunta13c_1.clearCheck();

				}

				else if (checkedId == R.id.radio0) {

					op13b_1 = "No sabe / No contestó";
					op13c_1="sin datos";
					rdPregunta13c_1.clearCheck();

				}

			}

		});

		rdPregunta13c_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op13c_1 = "Si";
					lay14_1 .setVisibility(View.GONE);
					lay14a_1 .setVisibility(View.GONE);
					lay14b_1 .setVisibility(View.GONE);

					op14_1 ="No aplica";
					op14a_1 ="No aplica";
					op14b_1 ="No aplica";
					
					rdPregunta14a_1.clearCheck();
					rdPregunta14b_1.clearCheck();



				}

				else if (checkedId == R.id.radio2) {

					op13c_1 = "No";
					
					if(op13a_1.equals("No") && op13b_1.equals("No")){
						
						lay14_1 .setVisibility(View.VISIBLE);
						lay14a_1 .setVisibility(View.VISIBLE);
						lay14b_1 .setVisibility(View.VISIBLE);

						op14a_1 ="sin datos";
						op14b_1 ="sin datos";
						
						rdPregunta14a_1.clearCheck();
						rdPregunta14b_1.clearCheck();
						
					}
					
if(op13a_1.equals("No sabe / No contestó") && op13b_1.equals("No sabe / No contestó")){
						
						lay14_1 .setVisibility(View.VISIBLE);
						lay14a_1 .setVisibility(View.VISIBLE);
						lay14b_1 .setVisibility(View.VISIBLE);

						op14a_1 ="sin datos";
						op14b_1 ="sin datos";
						
						rdPregunta14a_1.clearCheck();
						rdPregunta14b_1.clearCheck();
						
}

				}

				else if (checkedId == R.id.radio0) {

					op13c_1 = "No sabe / No contestó";
					if(op13a_1.equals("No") && op13b_1.equals("No")){
						
						lay14_1 .setVisibility(View.VISIBLE);
						lay14a_1 .setVisibility(View.VISIBLE);
						lay14b_1 .setVisibility(View.VISIBLE);

						
						op14a_1 ="sin datos";
						op14b_1 ="sin datos";
						
						rdPregunta14a_1.clearCheck();
						rdPregunta14b_1.clearCheck();
						
					}
					
if(op13a_1.equals("No sabe / No contestó") && op13b_1.equals("No sabe / No contestó")){
						
						lay14_1 .setVisibility(View.VISIBLE);
						lay14a_1 .setVisibility(View.VISIBLE);
						lay14b_1 .setVisibility(View.VISIBLE);

						op14a_1 ="sin datos";
						op14b_1 ="sin datos";
						
						rdPregunta14a_1.clearCheck();
						rdPregunta14b_1.clearCheck();
						
}


				}

			}

		});

		rdPregunta14_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {




			}

		});

		rdPregunta14a_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op14a_1 = "Si";

				}

				else if (checkedId == R.id.radio2) {

					op14a_1 = "No";

				}

				else if (checkedId == R.id.radio0) {

					op14a_1 = "No sabe / No contestó";

				}

			}

		});

		rdPregunta14b_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op14b_1 = "Si";

				}

				else if (checkedId == R.id.radio2) {

					op14b_1 = "No";

				}

				else if (checkedId == R.id.radio0) {

					op14b_1 = "No sabe / No contestó";

				}

			}

		});


		////  FINALIZA ADULTO_1 ///
		
	//// INICIA ADULTO_2  //

			rdPregunta8_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {



					if (checkedId == R.id.radio1) {

						op8_2 = "Si";
						lay9_2.setVisibility(View.GONE);
						op9_2="No aplica";
						rdPregunta9_2.clearCheck();
						
						lay10a_2 .setVisibility(View.VISIBLE);
						lay10b_2 .setVisibility(View.VISIBLE);
						lay10c_2 .setVisibility(View.VISIBLE);
						lay11_2 .setVisibility(View.VISIBLE);
						lay12_2 .setVisibility(View.VISIBLE);
						lay13_2 .setVisibility(View.VISIBLE);
						lay13a_2 .setVisibility(View.VISIBLE);
						lay13b_2 .setVisibility(View.VISIBLE);
						lay13c_2 .setVisibility(View.VISIBLE);
						lay14_2 .setVisibility(View.VISIBLE);
						lay14a_2 .setVisibility(View.VISIBLE);
						lay14b_2 .setVisibility(View.VISIBLE);

						op10_2 ="sin datos";
						op10a_2 ="sin datos";
						op10b_2 ="sin datos";
						op10c_2 ="sin datos";
						op11_2 ="sin datos";
						op12_2 ="sin datos";
						op13a_2 ="sin datos";
						op13b_2 ="sin datos";
						op13c_2 ="sin datos";
						op14a_2 ="sin datos";
						op14b_2 ="sin datos";
						
						rdPregunta10_2.clearCheck();
						rdPregunta10a_2 .clearCheck();
						rdPregunta10b_2 .clearCheck();
						rdPregunta10c_2 .clearCheck();
						rdPregunta11_2.clearCheck();
						rdPregunta12_2.clearCheck();
						rdPregunta13a_2.clearCheck();
						rdPregunta13b_2.clearCheck();
						rdPregunta13c_2.clearCheck();
						rdPregunta14a_2.clearCheck();
						rdPregunta14b_2.clearCheck();

					}

					else if (checkedId == R.id.radio0) {

						op8_2 = "No";
						lay9_2.setVisibility(View.VISIBLE);
						op9_2="sin datos";
						rdPregunta9_2.clearCheck();

					}

				}

			});

			rdPregunta9_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {



					if (checkedId == R.id.radio1) {

						op9_2 = "Si";
						lay10_2.setVisibility(View.VISIBLE);
						op10_2="sin datos";
						rdPregunta10_2.clearCheck();
						lay10a_2 .setVisibility(View.VISIBLE);
						lay10b_2 .setVisibility(View.VISIBLE);
						lay10c_2 .setVisibility(View.VISIBLE);
						lay11_2 .setVisibility(View.VISIBLE);
						lay12_2 .setVisibility(View.VISIBLE);
						lay13_2 .setVisibility(View.VISIBLE);
						lay13a_2 .setVisibility(View.VISIBLE);
						lay13b_2 .setVisibility(View.VISIBLE);
						lay13c_2 .setVisibility(View.VISIBLE);
						lay14_2 .setVisibility(View.VISIBLE);
						lay14a_2 .setVisibility(View.VISIBLE);
						lay14b_2 .setVisibility(View.VISIBLE);

						op10_2 ="sin datos";
						op10a_2 ="sin datos";
						op10b_2 ="sin datos";
						op10c_2 ="sin datos";
						op11_2 ="sin datos";
						op12_2 ="sin datos";
						op13a_2 ="sin datos";
						op13b_2 ="sin datos";
						op13c_2 ="sin datos";
						op14a_2 ="sin datos";
						op14b_2 ="sin datos";
						
						rdPregunta10_2.clearCheck();
						rdPregunta10a_2 .clearCheck();
						rdPregunta10b_2 .clearCheck();
						rdPregunta10c_2 .clearCheck();
						rdPregunta11_2.clearCheck();
						rdPregunta12_2.clearCheck();
						rdPregunta13a_2.clearCheck();
						rdPregunta13b_2.clearCheck();
						rdPregunta13c_2.clearCheck();
						rdPregunta14a_2.clearCheck();
						rdPregunta14b_2.clearCheck();
						

					}

					else if (checkedId == R.id.radio0) {

						op9_2 = "No";
						
						lay10_2 .setVisibility(View.GONE);
						lay10a_2 .setVisibility(View.GONE);
						lay10b_2 .setVisibility(View.GONE);
						lay10c_2 .setVisibility(View.GONE);
						lay11_2 .setVisibility(View.GONE);
						lay12_2 .setVisibility(View.GONE);
						lay13_2 .setVisibility(View.GONE);
						lay13a_2 .setVisibility(View.GONE);
						lay13b_2 .setVisibility(View.GONE);
						lay13c_2 .setVisibility(View.GONE);
						lay14_2 .setVisibility(View.GONE);
						lay14a_2 .setVisibility(View.GONE);
						lay14b_2 .setVisibility(View.GONE);

						op10_2 ="No aplica";
						op10a_2 ="No aplica";
						op10b_2 ="No aplica";
						op10c_2 ="No aplica";
						op11_2 ="No aplica";
						op12_2 ="No aplica";
						op13a_2 ="No aplica";
						op13b_2 ="No aplica";
						op13c_2 ="No aplica";
						op14a_2 ="No aplica";
						op14b_2 ="No aplica";
						
						rdPregunta10_2.clearCheck();
						rdPregunta10a_2 .clearCheck();
						rdPregunta10b_2 .clearCheck();
						rdPregunta10c_2 .clearCheck();
						rdPregunta11_2.clearCheck();
						rdPregunta12_2.clearCheck();
						rdPregunta13a_2.clearCheck();
						rdPregunta13b_2.clearCheck();
						rdPregunta13c_2.clearCheck();
						rdPregunta14a_2.clearCheck();
						rdPregunta14b_2.clearCheck();
						

					}

				}

			});

			rdPregunta10_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {



					if (checkedId == R.id.radio1) {

						op10_2 = "Si";
						lay10a_2.setVisibility(View.VISIBLE);
						op10a_2="sin datos";
						rdPregunta10a_2.clearCheck();
						lay10b_2.setVisibility(View.VISIBLE);
						op10b_2="sin datos";
						rdPregunta10b_2.clearCheck();
						lay10c_2.setVisibility(View.VISIBLE);
						op10c_2="sin datos";
						rdPregunta10c_2.clearCheck();
						
						lay15.setVisibility(View.VISIBLE); 
						op15="sin datos";
						rdPregunta15.clearCheck();
						rdPregunta12_2.clearCheck();

					}

					else if (checkedId == R.id.radio2) {

						op10_2 = "No";
						lay10a_2.setVisibility(View.GONE);
						op10a_2="No aplica";
						rdPregunta10a_2.clearCheck();
						lay10b_2.setVisibility(View.GONE);
						op10b_2="No aplica";
						rdPregunta10b_2.clearCheck();
						lay10c_2.setVisibility(View.GONE);
						op10c_2="No aplica";
						rdPregunta10c_2.clearCheck();
						
						lay15.setVisibility(View.VISIBLE); 
						op15="sin datos";
						rdPregunta15.clearCheck();
						rdPregunta12_2.clearCheck();
						
						
						
						
						lay90.setVisibility(View.VISIBLE); 
						lay90a.setVisibility(View.VISIBLE); 
						lay90b.setVisibility(View.VISIBLE); 
						lay90c.setVisibility(View.VISIBLE); 
						lay90d.setVisibility(View.VISIBLE); 
						lay90e.setVisibility(View.VISIBLE); 
						lay90f.setVisibility(View.VISIBLE); 
						lay90g.setVisibility(View.VISIBLE); 
						lay90h.setVisibility(View.VISIBLE); 
						lay90i.setVisibility(View.VISIBLE); 
						lay90j.setVisibility(View.VISIBLE); 

					}

					else if (checkedId == R.id.radio0) {

						op10_2 = "No sabe / No contestó";
						lay10a_2.setVisibility(View.GONE);
						op10a_2="No aplica";
						rdPregunta10a_2.clearCheck();
						lay10b_2.setVisibility(View.GONE);
						op10b_2="No aplica";
						rdPregunta10b_2.clearCheck();
						lay10c_2.setVisibility(View.GONE);
						op10c_2="No aplica";
						rdPregunta10c_2.clearCheck();
						rdPregunta12_2.clearCheck();

										
						
						
						lay90.setVisibility(View.VISIBLE); 
						lay90a.setVisibility(View.VISIBLE); 
						lay90b.setVisibility(View.VISIBLE); 
						lay90c.setVisibility(View.VISIBLE); 
						lay90d.setVisibility(View.VISIBLE); 
						lay90e.setVisibility(View.VISIBLE); 
						lay90f.setVisibility(View.VISIBLE); 
						lay90g.setVisibility(View.VISIBLE); 
						lay90h.setVisibility(View.VISIBLE); 
						lay90i.setVisibility(View.VISIBLE); 
						lay90j.setVisibility(View.VISIBLE); 

					}

				}

			});

			rdPregunta10a_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {



					if (checkedId == R.id.radio1) {

						op10a_2 = "Octubre 2019 o antes";

					}

					else if (checkedId == R.id.radio2) {

						op10a_2 = "Noviembre 2019";

					}

					else if (checkedId == R.id.radio3) {

						op10a_2 = "Diciembre 2019	";

					}

					else if (checkedId == R.id.radio4) {

						op10a_2 = "Enero 2020";

					}

					else if (checkedId == R.id.radio5) {

						op10a_2 = "Febrero 2020";

					}

					else if (checkedId == R.id.radio0) {

						op10a_2 = "No sabe / No contestó";

					}

				}

			});

			rdPregunta10b_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {



					if (checkedId == R.id.radio1) {

						op10b_2 = "Si";
						lay10c_2.setVisibility(View.VISIBLE);
						op10c_2="sin datos";
						rdPregunta10c_2.clearCheck();

					}

					else if (checkedId == R.id.radio2) {

						op10b_2 = "No";
						lay10c_2.setVisibility(View.GONE);
						op10c_2="No aplica";
						rdPregunta10c_2.clearCheck();

					}

					else if (checkedId == R.id.radio0) {

						op10b_2 = "No sabe / No contestó";
						lay10c_2.setVisibility(View.GONE);
						op10c_2="No aplica";
						rdPregunta10c_2.clearCheck();

					}

				}

			});

			rdPregunta10c_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {



					if (checkedId == R.id.radio1) {

						op10c_2 = "Si";

					}

					else if (checkedId == R.id.radio2) {

						op10c_2 = "No";

					}

					else if (checkedId == R.id.radio3) {

						op10c_2 = "No lo sabe/ no ha checado";

					}

					else if (checkedId == R.id.radio0) {

						op10c_2 = "No contestó";

					}

				}

			});

			rdPregunta11_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					if (checkedId == R.id.radio1) {
						op11_2 = "Masculino";
						
					}
					else if (checkedId == R.id.radio0) {
						op11_2 = "Femenino";
						
					}
				}
			});

			rdPregunta12_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {



					 if (checkedId == R.id.radio12_0_2) {

						op12_2 = "No sabe / No contestó";

						editPregunta12_2.setText("");
						editPregunta12a_2.setText("");
						
						if(op10_2.equals("No")){
						
							lay13_2 .setVisibility(View.VISIBLE);
							lay13a_2 .setVisibility(View.VISIBLE);
							lay13b_2 .setVisibility(View.VISIBLE);
							lay13c_2 .setVisibility(View.VISIBLE);
							lay14_2 .setVisibility(View.VISIBLE);
							lay14a_2 .setVisibility(View.VISIBLE);
							lay14b_2 .setVisibility(View.VISIBLE);

							op13a_2 ="sin datos";
							op13b_2 ="sin datos";
							op13c_2 ="sin datos";
							op14_2 ="sin datos";
							op14a_2 ="sin datos";
							op14b_2 ="sin datos";
							
							rdPregunta13a_2.clearCheck();
							rdPregunta13b_2.clearCheck();
							rdPregunta13c_2.clearCheck();
							rdPregunta14a_2.clearCheck();
							rdPregunta14b_2.clearCheck();
							
						}else{
						
						lay13_2 .setVisibility(View.GONE);
						lay13a_2 .setVisibility(View.GONE);
						lay13b_2 .setVisibility(View.GONE);
						lay13c_2 .setVisibility(View.GONE);
						lay14_2 .setVisibility(View.GONE);
						lay14a_2 .setVisibility(View.GONE);
						lay14b_2 .setVisibility(View.GONE);

						op13a_2 ="No aplica";
						op13b_2 ="No aplica";
						op13c_2 ="No aplica";
						op14_2 ="No aplica";
						op14a_2 ="No aplica";
						op14b_2 ="No aplica";
						
						rdPregunta13a_2.clearCheck();
						rdPregunta13b_2.clearCheck();
						rdPregunta13c_2.clearCheck();
						rdPregunta14a_2.clearCheck();
						rdPregunta14b_2.clearCheck();
						}
					}

				}

			});

			editPregunta12_2.addTextChangedListener(new TextWatcher() {
				@Override
				public void afterTextChanged(Editable s) {
				}
				@Override
				public void beforeTextChanged(CharSequence s, int start,int count, int after) {
				}
				@Override
				public void onTextChanged(CharSequence s, int start,int before, int count) {
					if(s.length() != 0){
						
				
							rdPregunta12_2.clearCheck();
						
							String laEdad=editPregunta12_2.getText().toString();
							String losMeses=editPregunta12a_2.getText().toString();
							
							if(laEdad.length()==0){
								laEdad="0";
							}else{
								laEdad=laEdad;
							}
						
						if(losMeses.length()==0){
							losMeses="0";
						}else{
							losMeses=losMeses;
						}
						
						Integer edad=Integer.parseInt(laEdad);
						Integer meses=Integer.parseInt(losMeses);
						if(op10_2.equals("Si")){
							
							lay13_2 .setVisibility(View.GONE);
							lay13a_2 .setVisibility(View.GONE);
							lay13b_2 .setVisibility(View.GONE);
							lay13c_2 .setVisibility(View.GONE);
							lay14_2 .setVisibility(View.GONE);
							lay14a_2 .setVisibility(View.GONE);
							lay14b_2 .setVisibility(View.GONE);

							op13a_2 ="No aplica";
							op13b_2 ="No aplica";
							op13c_2 ="No aplica";
							op14a_2 ="No aplica";
							op14b_2 ="No aplica";
							
							rdPregunta13a_2.clearCheck();
							rdPregunta13b_2.clearCheck();
							rdPregunta13c_2.clearCheck();
							rdPregunta14a_2.clearCheck();
							rdPregunta14b_2.clearCheck();
							
						}else if(edad >= 68){
							lay13_2 .setVisibility(View.GONE);
							lay13a_2 .setVisibility(View.GONE);
							lay13b_2 .setVisibility(View.GONE);
							lay13c_2 .setVisibility(View.GONE);
							lay14_2 .setVisibility(View.GONE);
							lay14a_2 .setVisibility(View.GONE);
							lay14b_2 .setVisibility(View.GONE);

							op13a_2 ="No aplica";
							op13b_2 ="No aplica";
							op13c_2 ="No aplica";
							op14_2 ="No aplica";
							op14a_2 ="No aplica";
							op14b_2 ="No aplica";
							
							rdPregunta13a_2.clearCheck();
							rdPregunta13b_2.clearCheck();
							rdPregunta13c_2.clearCheck();
							rdPregunta14a_2.clearCheck();
							rdPregunta14b_2.clearCheck();
							
						}else if(edad >= 65  || (edad >= 67 && meses <=11)){
							lay13_2 .setVisibility(View.VISIBLE);
							lay13a_2 .setVisibility(View.VISIBLE);
							lay13b_2 .setVisibility(View.VISIBLE);
							lay13c_2 .setVisibility(View.VISIBLE);
							lay14_2 .setVisibility(View.VISIBLE);
							lay14a_2 .setVisibility(View.VISIBLE);
							lay14b_2 .setVisibility(View.VISIBLE);

							op13a_2 ="sin datos";
							op13b_2 ="sin datos";
							op13c_2 ="sin datos";
							op14_2 ="sin datos";
							op14a_2 ="sin datos";
							op14b_2 ="sin datos";
							
							rdPregunta13a_2.clearCheck();
							rdPregunta13b_2.clearCheck();
							rdPregunta13c_2.clearCheck();
							rdPregunta14a_2.clearCheck();
							rdPregunta14b_2.clearCheck();
							
						}else{
						
							lay13_2 .setVisibility(View.GONE);
							lay13a_2 .setVisibility(View.GONE);
							lay13b_2 .setVisibility(View.GONE);
							lay13c_2 .setVisibility(View.GONE);
							lay14_2 .setVisibility(View.GONE);
							lay14a_2 .setVisibility(View.GONE);
							lay14b_2 .setVisibility(View.GONE);

							op13a_2 ="No aplica";
							op13b_2 ="No aplica";
							op13c_2 ="No aplica";
							op14_2 ="No aplica";
							op14a_2 ="No aplica";
							op14b_2 ="No aplica";
							
							rdPregunta13a_2.clearCheck();
							rdPregunta13b_2.clearCheck();
							rdPregunta13c_2.clearCheck();
							rdPregunta14a_2.clearCheck();
							rdPregunta14b_2.clearCheck();
							
						}
						

					}

				}

			});
			
			editPregunta12a_2.addTextChangedListener(new TextWatcher() {
				@Override
				public void afterTextChanged(Editable s) {
				}
				@Override
				public void beforeTextChanged(CharSequence s, int start,int count, int after) {
				}
				@Override
				public void onTextChanged(CharSequence s, int start,int before, int count) {
					if(s.length() != 0){
						
						rdPregunta12_2.clearCheck();
						
						String laEdad=editPregunta12_2.getText().toString();
						String losMeses=editPregunta12a_2.getText().toString();
						
						if(laEdad.length()==0){
							laEdad="0";
						}else{
							laEdad=laEdad;
						}
					
					if(losMeses.length()==0){
						losMeses="0";
					}else{
						losMeses=losMeses;
					}
					
					Integer edad=Integer.parseInt(laEdad);
					Integer meses=Integer.parseInt(losMeses);
					
						if(op10_2.equals("Si")){
							
							lay13_2 .setVisibility(View.GONE);
							lay13a_2 .setVisibility(View.GONE);
							lay13b_2 .setVisibility(View.GONE);
							lay13c_2 .setVisibility(View.GONE);
							lay14_2 .setVisibility(View.GONE);
							lay14a_2 .setVisibility(View.GONE);
							lay14b_2 .setVisibility(View.GONE);

							op13a_2 ="No aplica";
							op13b_2 ="No aplica";
							op13c_2 ="No aplica";
							op14a_2 ="No aplica";
							op14b_2 ="No aplica";
							
							rdPregunta13a_2.clearCheck();
							rdPregunta13b_2.clearCheck();
							rdPregunta13c_2.clearCheck();
							rdPregunta14a_2.clearCheck();
							rdPregunta14b_2.clearCheck();
						}else if(edad >= 68){
							lay13_2 .setVisibility(View.GONE);
							lay13a_2 .setVisibility(View.GONE);
							lay13b_2 .setVisibility(View.GONE);
							lay13c_2 .setVisibility(View.GONE);
							lay14_2 .setVisibility(View.GONE);
							lay14a_2 .setVisibility(View.GONE);
							lay14b_2 .setVisibility(View.GONE);

							op13a_2 ="No aplica";
							op13b_2 ="No aplica";
							op13c_2 ="No aplica";
							op14a_2 ="No aplica";
							op14b_2 ="No aplica";
							
							rdPregunta13a_2.clearCheck();
							rdPregunta13b_2.clearCheck();
							rdPregunta13c_2.clearCheck();
							rdPregunta14a_2.clearCheck();
							rdPregunta14b_2.clearCheck();
							
						}else if(edad >= 65  || (edad >= 67 && meses <=11)){
							lay13_2 .setVisibility(View.VISIBLE);
							lay13a_2 .setVisibility(View.VISIBLE);
							lay13b_2 .setVisibility(View.VISIBLE);
							lay13c_2 .setVisibility(View.VISIBLE);
							lay14_2 .setVisibility(View.VISIBLE);
							lay14a_2 .setVisibility(View.VISIBLE);
							lay14b_2 .setVisibility(View.VISIBLE);

							op13a_2 ="sin datos";
							op13b_2 ="sin datos";
							op13c_2 ="sin datos";
							op14_2 ="sin datos";
							op14a_2 ="sin datos";
							op14b_2 ="sin datos";
							
							rdPregunta13a_2.clearCheck();
							rdPregunta13b_2.clearCheck();
							rdPregunta13c_2.clearCheck();
							rdPregunta14a_2.clearCheck();
							rdPregunta14b_2.clearCheck();
						}else{
						
							lay13_2 .setVisibility(View.GONE);
							lay13a_2 .setVisibility(View.GONE);
							lay13b_2 .setVisibility(View.GONE);
							lay13c_2 .setVisibility(View.GONE);
							lay14_2 .setVisibility(View.GONE);
							lay14a_2 .setVisibility(View.GONE);
							lay14b_2 .setVisibility(View.GONE);

							op13a_2 ="No aplica";
							op13b_2 ="No aplica";
							op13c_2 ="No aplica";
							op14a_2 ="No aplica";
							op14b_2 ="No aplica";
							
							rdPregunta13a_2.clearCheck();
							rdPregunta13b_2.clearCheck();
							rdPregunta13c_2.clearCheck();
							rdPregunta14a_2.clearCheck();
							rdPregunta14b_2.clearCheck();
							
						}
						
					}

				}

			});

			rdPregunta13a_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {



					if (checkedId == R.id.radio1) {

						op13a_2 = "Si";
						rdPregunta13c_2.clearCheck();
						lay14_2 .setVisibility(View.GONE);
						lay14a_2 .setVisibility(View.GONE);
						lay14b_2 .setVisibility(View.GONE);

						op14a_2 ="No aplica";
						op14b_2 ="No aplica";

						rdPregunta14a_2.clearCheck();
						rdPregunta14b_2.clearCheck();


					}

					else if (checkedId == R.id.radio2) {

						op13a_2 = "No";
						op13c_2="sin datos";
						rdPregunta13c_2.clearCheck();


					}

					else if (checkedId == R.id.radio0) {

						op13a_2 = "No sabe / No contestó";
						op13c_2="sin datos";
						rdPregunta13c_2.clearCheck();

					}

				}

			});

			rdPregunta13b_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {



					if (checkedId == R.id.radio1) {

						op13b_2 = "Si";
						rdPregunta13c_2.clearCheck();
						
						lay14_2 .setVisibility(View.GONE);
						lay14a_2 .setVisibility(View.GONE);
						lay14b_2 .setVisibility(View.GONE);

						op14a_2 ="No aplica";
						op14b_2 ="No aplica";
						rdPregunta14a_2.clearCheck();
						rdPregunta14b_2.clearCheck();



					}

					else if (checkedId == R.id.radio2) {

						op13b_2 = "No";
						op13c_2="sin datos";
						rdPregunta13c_2.clearCheck();

					}

					else if (checkedId == R.id.radio0) {

						op13b_2 = "No sabe / No contestó";
						op13c_2="sin datos";
						rdPregunta13c_2.clearCheck();

					}

				}

			});

			rdPregunta13c_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {



					if (checkedId == R.id.radio1) {

						op13c_2 = "Si";
						lay14_2 .setVisibility(View.GONE);
						lay14a_2 .setVisibility(View.GONE);
						lay14b_2 .setVisibility(View.GONE);

						op14_2 ="No aplica";
						op14a_2 ="No aplica";
						op14b_2 ="No aplica";
						
						rdPregunta14a_2.clearCheck();
						rdPregunta14b_2.clearCheck();



					}

					else if (checkedId == R.id.radio2) {

						op13c_2 = "No";
						
						if(op13a_2.equals("No") && op13b_2.equals("No")){
							
							lay14_2 .setVisibility(View.VISIBLE);
							lay14a_2 .setVisibility(View.VISIBLE);
							lay14b_2 .setVisibility(View.VISIBLE);

							op14a_2 ="sin datos";
							op14b_2 ="sin datos";
							
							rdPregunta14a_2.clearCheck();
							rdPregunta14b_2.clearCheck();
							
						}
						
	if(op13a_2.equals("No sabe / No contestó") && op13b_2.equals("No sabe / No contestó")){
							
							lay14_2 .setVisibility(View.VISIBLE);
							lay14a_2 .setVisibility(View.VISIBLE);
							lay14b_2 .setVisibility(View.VISIBLE);

							op14a_2 ="sin datos";
							op14b_2 ="sin datos";
							
							rdPregunta14a_2.clearCheck();
							rdPregunta14b_2.clearCheck();
							
	}

					}

					else if (checkedId == R.id.radio0) {

						op13c_2 = "No sabe / No contestó";
						if(op13a_2.equals("No") && op13b_2.equals("No")){
							
							lay14_2 .setVisibility(View.VISIBLE);
							lay14a_2 .setVisibility(View.VISIBLE);
							lay14b_2 .setVisibility(View.VISIBLE);

							
							op14a_2 ="sin datos";
							op14b_2 ="sin datos";
							
							rdPregunta14a_2.clearCheck();
							rdPregunta14b_2.clearCheck();
							
						}
						
	if(op13a_2.equals("No sabe / No contestó") && op13b_2.equals("No sabe / No contestó")){
							
							lay14_2 .setVisibility(View.VISIBLE);
							lay14a_2 .setVisibility(View.VISIBLE);
							lay14b_2 .setVisibility(View.VISIBLE);

							op14a_2 ="sin datos";
							op14b_2 ="sin datos";
							
							rdPregunta14a_2.clearCheck();
							rdPregunta14b_2.clearCheck();
							
	}


					}

				}

			});

			rdPregunta14_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {




				}

			});

			rdPregunta14a_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {



					if (checkedId == R.id.radio1) {

						op14a_2 = "Si";

					}

					else if (checkedId == R.id.radio2) {

						op14a_2 = "No";

					}

					else if (checkedId == R.id.radio0) {

						op14a_2 = "No sabe / No contestó";

					}

				}

			});

			rdPregunta14b_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {



					if (checkedId == R.id.radio1) {

						op14b_2 = "Si";

					}

					else if (checkedId == R.id.radio2) {

						op14b_2 = "No";

					}

					else if (checkedId == R.id.radio0) {

						op14b_2 = "No sabe / No contestó";

					}

				}

			});


			////  FINALIZA ADULTO_2 ///
	

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





		rdPregunta15.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op15 = "Si";
					lay15a .setVisibility(View.VISIBLE);
					op15a="sin datos";
					rdPregunta15a.clearCheck();
					
					
					layEst.setVisibility(View.VISIBLE);
					layEdad.setVisibility(View.VISIBLE);
					layHijos.setVisibility(View.VISIBLE);
					
					layAporta.setVisibility(View.VISIBLE);
					layOcupacion.setVisibility(View.VISIBLE);
					layTrabajaron.setVisibility(View.VISIBLE);
					layCoche.setVisibility(View.VISIBLE);
					layCuantosCoches.setVisibility(View.VISIBLE);
					layCuartos.setVisibility(View.VISIBLE);
					layCuartosDormir.setVisibility(View.VISIBLE);
					layFocos.setVisibility(View.VISIBLE);
					layBanos.setVisibility(View.VISIBLE);
					layRegadera.setVisibility(View.VISIBLE);
					layInternet.setVisibility(View.VISIBLE);
					layEstufa.setVisibility(View.VISIBLE);
					layTipoPiso.setVisibility(View.VISIBLE);
					layTipoVivienda.setVisibility(View.VISIBLE);
					layGenero.setVisibility(View.VISIBLE);
				
					
//					
					
					
					lay90.setVisibility(View.VISIBLE); 
					lay90a.setVisibility(View.VISIBLE); 
					lay90b.setVisibility(View.VISIBLE); 
					lay90c.setVisibility(View.VISIBLE); 
					lay90d.setVisibility(View.VISIBLE); 
					lay90e.setVisibility(View.VISIBLE); 
					lay90f.setVisibility(View.VISIBLE); 
					lay90g.setVisibility(View.VISIBLE); 
					lay90h.setVisibility(View.VISIBLE); 
					lay90i.setVisibility(View.VISIBLE); 
					lay90j.setVisibility(View.VISIBLE); 

				}

				else if (checkedId == R.id.radio2) {

					op15 = "No";
					lay15a .setVisibility(View.GONE);
					op15a="No aplica";
					rdPregunta15a.clearCheck();
					
					ocultaMenorConDiscapacidad_1();
					ocultaMenorConDiscapacidad_2();
					
					if(op7.equals("No") || op7.equals("No sabe / No contestó")){
						
						ocultaEstadisticas();
						
						lay90.setVisibility(View.VISIBLE); 
						lay90a.setVisibility(View.VISIBLE); 
						lay90b.setVisibility(View.VISIBLE); 
						lay90c.setVisibility(View.VISIBLE); 
						lay90d.setVisibility(View.VISIBLE); 
						lay90e.setVisibility(View.VISIBLE); 
						lay90f.setVisibility(View.VISIBLE); 
						lay90g.setVisibility(View.VISIBLE); 
						lay90h.setVisibility(View.VISIBLE); 
						lay90i.setVisibility(View.VISIBLE); 
						lay90j.setVisibility(View.VISIBLE); 
					}
					
					

				}

				else if (checkedId == R.id.radio0) {

					op15 = "No sabe / No contestó";
					lay15a .setVisibility(View.GONE);
					op15a="No aplica";
					rdPregunta15a.clearCheck();
					ocultaMenorConDiscapacidad_1();
					ocultaMenorConDiscapacidad_2();
					
					if(op7.equals("No") || op7.equals("No sabe / No contestó")){
						
						ocultaEstadisticas();
						
						lay90.setVisibility(View.VISIBLE); 
						lay90a.setVisibility(View.VISIBLE); 
						lay90b.setVisibility(View.VISIBLE); 
						lay90c.setVisibility(View.VISIBLE); 
						lay90d.setVisibility(View.VISIBLE); 
						lay90e.setVisibility(View.VISIBLE); 
						lay90f.setVisibility(View.VISIBLE); 
						lay90g.setVisibility(View.VISIBLE); 
						lay90h.setVisibility(View.VISIBLE); 
						lay90i.setVisibility(View.VISIBLE); 
						lay90j.setVisibility(View.VISIBLE); 
					}

				}

			}

		});


		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





		rdPregunta15a.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op15a = "1";
					MuestraMenorConDiscapacidad_1();
					ocultaMenorConDiscapacidad_2();
				}

				else if (checkedId == R.id.radio2) {

					op15a = "2";
					MuestraMenorConDiscapacidad_1();
					MuestraMenorConDiscapacidad_2();

				}

				else if (checkedId == R.id.radio3) {

					op15a = "3";
					MuestraMenorConDiscapacidad_1();
					MuestraMenorConDiscapacidad_2();

				}

				else if (checkedId == R.id.radio4) {

					op15a = "4";
					MuestraMenorConDiscapacidad_1();
					MuestraMenorConDiscapacidad_2();

				}

				else if (checkedId == R.id.radio0) {

					op15a = "5 o más";
					MuestraMenorConDiscapacidad_1();
					MuestraMenorConDiscapacidad_2();

				}

			}

		});


		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////  INICIA MENOR_1  //////



		rdPregunta16_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op16_1 = "Madre/ padre";

					editPregunta16_1.setText("");

				}

				else if (checkedId == R.id.radio2) {

					op16_1 = "Abuela/ Abuelo";

					editPregunta16_1.setText("");

				}

				else if (checkedId == R.id.radio0) {

					op16_1 = "Hermana/ Hermano";

					editPregunta16_1.setText("");

				}

			}

		});


		editPregunta16_1.addTextChangedListener(new TextWatcher() {

			@Override

			public void afterTextChanged(Editable s) {}

			@Override

			public void beforeTextChanged(CharSequence s, int start,int count, int after) {

			}

			@Override

			public void onTextChanged(CharSequence s, int start,int before, int count) {

				if(s.length() != 0){

					rdPregunta16_1.clearCheck();

				}

			}

		});




	



		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





		rdPregunta17a_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				 if (checkedId == R.id.radio0) {

					op17a_1 = "No sabe / No contestó";

					spinner17a_1.setSelection(0);

				}

			}

		});




		

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





		rdPregunta17b_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				 if (checkedId == R.id.radio0) {

					op17b_1 = "No sabe / No contestó";

					spinner17b_1.setSelection(0);

				}

			}

		});



		

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





		rdPregunta17c_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				 if (checkedId == R.id.radio0) {

					op17c_1 = "No sabe / No contestó";

					spinner17c_1.setSelection(0);

				}

			}

		});



		

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





		rdPregunta18_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



//				 if (checkedId == R.id.radio0) {
//
//					op18_1 = "No sabe / No contestó";
//
//					editPregunta18_1.setText("");
//
//				}

			}

		});


		editPregunta18_1.addTextChangedListener(new TextWatcher() {

			@Override

			public void afterTextChanged(Editable s) {}

			@Override

			public void beforeTextChanged(CharSequence s, int start,int count, int after) {

			}

			@Override

			public void onTextChanged(CharSequence s, int start,int before, int count) {

				if(s.length() != 0){

					rdPregunta18_1.clearCheck();

				}

			}

		});




		



		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





		rdPregunta19_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op19_1 = "Masculino";

					editPregunta19_1.setText("");

				}

				else if (checkedId == R.id.radio0) {

					op19_1 = "Femenino";

					editPregunta19_1.setText("");

				}

			}

		});


		editPregunta19_1.addTextChangedListener(new TextWatcher() {

			@Override

			public void afterTextChanged(Editable s) {}

			@Override

			public void beforeTextChanged(CharSequence s, int start,int count, int after) {

			}

			@Override

			public void onTextChanged(CharSequence s, int start,int before, int count) {

				if(s.length() != 0){

					rdPregunta19_1.clearCheck();

				}

			}

		});




	



		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





		rdPregunta20_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op20_1 = "De nacimiento";


				}

				else if (checkedId == R.id.radio2) {

					op20_1 = "Adquirida";


				}

				else if (checkedId == R.id.radio0) {

					op20_1 = "No sabe / No contestó";


				}

			}

		});


		

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





		rdPregunta21_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op21_1 = "SSA";

					editPregunta21_1.setText("");

				}

				else if (checkedId == R.id.radio2) {

					op21_1 = "IMSS";

					editPregunta21_1.setText("");

				}

				else if (checkedId == R.id.radio3) {

					op21_1 = "ISSSTE";

					editPregunta21_1.setText("");

				}

				else if (checkedId == R.id.radio0) {

					op21_1 = "No sabe / No contestó";

					editPregunta21_1.setText("");

				}

			}

		});


		editPregunta21_1.addTextChangedListener(new TextWatcher() {

			@Override

			public void afterTextChanged(Editable s) {}

			@Override

			public void beforeTextChanged(CharSequence s, int start,int count, int after) {

			}

			@Override

			public void onTextChanged(CharSequence s, int start,int before, int count) {

				if(s.length() != 0){

					rdPregunta21_1.clearCheck();

				}

			}

		});




		


		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





		rdPregunta22_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op22_1 = "Si";
					lay22a_1.setVisibility(View.VISIBLE);
					op22a_1="sin datos";
					rdPregunta22a_1.clearCheck();

				}

				else if (checkedId == R.id.radio2) {

					op22_1 = "No";
					lay22a_1.setVisibility(View.GONE);
					op22a_1="No aplica";
					rdPregunta22a_1.clearCheck();

				}

				else if (checkedId == R.id.radio0) {

					op22_1 = "No sabe / No contestó";
					lay22a_1.setVisibility(View.GONE);
					op22a_1="No aplica";
					rdPregunta22a_1.clearCheck();

				}

			}

		});


		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





		rdPregunta22a_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op22a_1 = "IMSS";

					editPregunta22a_1.setText("");

				}

				else if (checkedId == R.id.radio2) {

					op22a_1 = "ISSSTE";

					editPregunta22a_1.setText("");

				}

				else if (checkedId == R.id.radio3) {

					op22a_1 = "INSABI";

					editPregunta22a_1.setText("");

				}

				else if (checkedId == R.id.radio4) {

					op22a_1 = "Seguro popular";

					editPregunta22a_1.setText("");

				}

				else if (checkedId == R.id.radio0) {

					op22a_1 = "No sabe / No contestó";

					editPregunta22a_1.setText("");

				}

			}

		});


		editPregunta22a_1.addTextChangedListener(new TextWatcher() {

			@Override

			public void afterTextChanged(Editable s) {}

			@Override

			public void beforeTextChanged(CharSequence s, int start,int count, int after) {

			}

			@Override

			public void onTextChanged(CharSequence s, int start,int before, int count) {

				if(s.length() != 0){

					rdPregunta22a_1.clearCheck();

				}

			}

		});




	



		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





		rdPregunta23_1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {



				if (checkedId == R.id.radio1) {

					op23_1 = "Preescolar";


				}

				else if (checkedId == R.id.radio2) {

					op23_1 = "Primaria";

				}

				else if (checkedId == R.id.radio3) {

					op23_1 = "Secundaria";

				}
				else if (checkedId == R.id.radio4) {

					op23_1 = "CENDI ó Guardería";

				}
				else if (checkedId == R.id.radio5) {

					op23_1 = "No asiste a la escuela";

				}

				else if (checkedId == R.id.radio0) {

					op23_1 = "No sabe / No contestó";

				}

			}

		});


		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




		///// FINALIZA MENOR_1  ///////
		
////////////INICIA MENOR_2  //////



	rdPregunta16_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {



			if (checkedId == R.id.radio1) {

				op16_2 = "Madre/ padre";

				editPregunta16_2.setText("");

			}

			else if (checkedId == R.id.radio2) {

				op16_2 = "Abuela/ Abuelo";

				editPregunta16_2.setText("");

			}

			else if (checkedId == R.id.radio0) {

				op16_2 = "Hermana/ Hermano";

				editPregunta16_2.setText("");

			}

		}

	});


	editPregunta16_2.addTextChangedListener(new TextWatcher() {

		@Override

		public void afterTextChanged(Editable s) {}

		@Override

		public void beforeTextChanged(CharSequence s, int start,int count, int after) {

		}

		@Override

		public void onTextChanged(CharSequence s, int start,int before, int count) {

			if(s.length() != 0){

				rdPregunta16_2.clearCheck();

			}

		}

	});








	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	rdPregunta17a_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {



			 if (checkedId == R.id.radio0) {

				op17a_2 = "No sabe / No contestó";

				spinner17a_2.setSelection(0);

			}

		}

	});




	

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	rdPregunta17b_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {



			 if (checkedId == R.id.radio0) {

				op17b_2 = "No sabe / No contestó";

				spinner17b_2.setSelection(0);

			}

		}

	});



	

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	rdPregunta17c_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {



			 if (checkedId == R.id.radio0) {

				op17c_2 = "No sabe / No contestó";

				spinner17c_2.setSelection(0);

			}

		}

	});



	

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	rdPregunta18_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {



//			 if (checkedId == R.id.radio0) {
//
//				op18_2 = "No sabe / No contestó";
//
//				editPregunta18_2.setText("");
//
//			}

		}

	});


	editPregunta18_2.addTextChangedListener(new TextWatcher() {

		@Override

		public void afterTextChanged(Editable s) {}

		@Override

		public void beforeTextChanged(CharSequence s, int start,int count, int after) {

		}

		@Override

		public void onTextChanged(CharSequence s, int start,int before, int count) {

			if(s.length() != 0){

				rdPregunta18_2.clearCheck();

			}

		}

	});




	



	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	rdPregunta19_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {



			if (checkedId == R.id.radio1) {

				op19_2 = "Masculino";

				editPregunta19_2.setText("");

			}

			else if (checkedId == R.id.radio0) {

				op19_2 = "Femenino";

				editPregunta19_2.setText("");

			}

		}

	});


	editPregunta19_2.addTextChangedListener(new TextWatcher() {

		@Override

		public void afterTextChanged(Editable s) {}

		@Override

		public void beforeTextChanged(CharSequence s, int start,int count, int after) {

		}

		@Override

		public void onTextChanged(CharSequence s, int start,int before, int count) {

			if(s.length() != 0){

				rdPregunta19_2.clearCheck();

			}

		}

	});








	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	rdPregunta20_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {



			if (checkedId == R.id.radio1) {

				op20_2 = "De nacimiento";


			}

			else if (checkedId == R.id.radio2) {

				op20_2 = "Adquirida";


			}

			else if (checkedId == R.id.radio0) {

				op20_2 = "No sabe / No contestó";


			}

		}

	});


	

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	rdPregunta21_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {



			if (checkedId == R.id.radio1) {

				op21_2 = "SSA";

				editPregunta21_2.setText("");

			}

			else if (checkedId == R.id.radio2) {

				op21_2 = "IMSS";

				editPregunta21_2.setText("");

			}

			else if (checkedId == R.id.radio3) {

				op21_2 = "ISSSTE";

				editPregunta21_2.setText("");

			}

			else if (checkedId == R.id.radio0) {

				op21_2 = "No sabe / No contestó";

				editPregunta21_2.setText("");

			}

		}

	});


	editPregunta21_2.addTextChangedListener(new TextWatcher() {

		@Override

		public void afterTextChanged(Editable s) {}

		@Override

		public void beforeTextChanged(CharSequence s, int start,int count, int after) {

		}

		@Override

		public void onTextChanged(CharSequence s, int start,int before, int count) {

			if(s.length() != 0){

				rdPregunta21_2.clearCheck();

			}

		}

	});




	


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	rdPregunta22_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {



			if (checkedId == R.id.radio1) {

				op22_2 = "Si";
				lay22a_2.setVisibility(View.VISIBLE);
				op22a_2="sin datos";
				rdPregunta22a_2.clearCheck();

			}

			else if (checkedId == R.id.radio2) {

				op22_2 = "No";
				lay22a_2.setVisibility(View.GONE);
				op22a_2="No aplica";
				rdPregunta22a_2.clearCheck();

			}

			else if (checkedId == R.id.radio0) {

				op22_2 = "No sabe / No contestó";
				lay22a_2.setVisibility(View.GONE);
				op22a_2="No aplica";
				rdPregunta22a_2.clearCheck();

			}

		}

	});


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	rdPregunta22a_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {



			if (checkedId == R.id.radio1) {

				op22a_2 = "IMSS";

				editPregunta22a_2.setText("");

			}

			else if (checkedId == R.id.radio2) {

				op22a_2 = "ISSSTE";

				editPregunta22a_2.setText("");

			}

			else if (checkedId == R.id.radio3) {

				op22a_2 = "INSABI";

				editPregunta22a_2.setText("");

			}

			else if (checkedId == R.id.radio4) {

				op22a_2 = "Seguro popular";

				editPregunta22a_2.setText("");

			}

			else if (checkedId == R.id.radio0) {

				op22a_2 = "No sabe / No contestó";

				editPregunta22a_2.setText("");

			}

		}

	});


	editPregunta22a_2.addTextChangedListener(new TextWatcher() {

		@Override

		public void afterTextChanged(Editable s) {}

		@Override

		public void beforeTextChanged(CharSequence s, int start,int count, int after) {

		}

		@Override

		public void onTextChanged(CharSequence s, int start,int before, int count) {

			if(s.length() != 0){

				rdPregunta22a_2.clearCheck();

			}

		}

	});








	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





	rdPregunta23_2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {



			if (checkedId == R.id.radio1) {

				op23_2 = "Preescolar";


			}

			else if (checkedId == R.id.radio2) {

				op23_2 = "Primaria";

			}

			else if (checkedId == R.id.radio3) {

				op23_2 = "Secundaria";

			}
			else if (checkedId == R.id.radio4) {

				op23_2 = "CENDI ó Guardería";

			}
			else if (checkedId == R.id.radio5) {

				op23_2 = "No asiste a la escuela";

			}

			else if (checkedId == R.id.radio0) {

				op23_2 = "No sabe / No contestó";

			}

		}

	});


	
	///// FINALIZA MENOR_2  ///////
		


		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////





		///////////////////////////////////// //////////////////////////////////////////////////////////////////////

		rdPreguntaHijos.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio1) {
					opHijos = "Si";
				} else if (checkedId == R.id.radio2) {
					opHijos = "No";
				} else if (checkedId == R.id.radio0) {
					opHijos = "No sabe / No contestó";
				} else {
					opHijos = "";

				}

			}
		});

		rdPreguntaAporta.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio1) {
					opAporta = "No completó primaria";
				} else if (checkedId == R.id.radio2) {
					opAporta = "Primaria o secundaria";
				} else if (checkedId == R.id.radio3) {
					opAporta = "Preparatoria o carrera técnica";
				} else if (checkedId == R.id.radio4) {
					opAporta = "Licenciatura";
				} else if (checkedId == R.id.radio5) {
					opAporta = "Posgrado";
				} else if (checkedId == R.id.radio0) {
					opAporta = "No contestó";
				} else {
					opAporta = "";

				}

			}
		});

		rdPreguntaOcupacion.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio1) {
					opOcupacion = "Hogar";
				} else if (checkedId == R.id.radio2) {
					opOcupacion = "Estudiante";
				} else if (checkedId == R.id.radio3) {
					opOcupacion = "Profesionista";
				} else if (checkedId == R.id.radio4) {
					opOcupacion = "Empleado";
				} else if (checkedId == R.id.radio5) {
					opOcupacion = "Obrero / oficio";
				} else if (checkedId == R.id.radio6) {
					opOcupacion = "Comerciante";
				} else if (checkedId == R.id.radio7) {
					opOcupacion = "Jubilado";
				} else if (checkedId == R.id.radio8) {
					opOcupacion = "Otro";
				} else if (checkedId == R.id.radio9) {
					opOcupacion = "Desempleado";
				} else if (checkedId == R.id.radio0) {
					opOcupacion = "No contestó";
				} else {
					opOcupacion = "";

				}

			}
		});

		rdPreguntaCoche.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio1) {
					opCoche = "Si";
					layCuantosCoches.setVisibility(View.VISIBLE);
					opCuantosCoches = "sin datos";
				} else if (checkedId == R.id.radio2) {
					opCoche = "No";
					layCuantosCoches.setVisibility(View.GONE);
					rdPreguntaCuantosCoches.clearCheck();
					opCuantosCoches = "Ninguno";

				} else if (checkedId == R.id.radio0) {
					opCoche = "No contestó";
					layCuantosCoches.setVisibility(View.GONE);
					rdPreguntaCuantosCoches.clearCheck();
					opCuantosCoches = "Ninguno";

				} else {
					opCoche = "";

				}

			}
		});

		rdPreguntaCuantosCoches.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio1) {
					opCuantosCoches = "Ninguno";
				} else if (checkedId == R.id.radio2) {
					opCuantosCoches = "Uno";
				} else if (checkedId == R.id.radio3) {
					opCuantosCoches = "Dos";
				} else if (checkedId == R.id.radio4) {
					opCuantosCoches = "Tres";
				} else if (checkedId == R.id.radio5) {
					opCuantosCoches = "Cuatro o más";
				} else if (checkedId == R.id.radio0) {
					opCuantosCoches = "No contestó";
				} else {
					opCuantosCoches = "";

				}

			}
		});

		rdPreguntaCuartos.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio1) {
					opCuartos = "1";
				} else if (checkedId == R.id.radio2) {
					opCuartos = "2";
				} else if (checkedId == R.id.radio3) {
					opCuartos = "3";
				} else if (checkedId == R.id.radio4) {
					opCuartos = "4";
				} else if (checkedId == R.id.radio5) {
					opCuartos = "5";
				} else if (checkedId == R.id.radio6) {
					opCuartos = "6";
				} else if (checkedId == R.id.radio7) {
					opCuartos = "7";
				} else if (checkedId == R.id.radio8) {
					opCuartos = "8";
				} else if (checkedId == R.id.radio9) {
					opCuartos = "9";
				} else if (checkedId == R.id.radio10) {
					opCuartos = "10";
				} else if (checkedId == R.id.radio0) {
					opCuartos = "No contestó";
				} else {
					opCuartos = "";

				}

			}
		});

		rdPreguntaCuartosDormir.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio1) {
					opCuartosDormir = "1";
				} else if (checkedId == R.id.radio2) {
					opCuartosDormir = "2";
				} else if (checkedId == R.id.radio3) {
					opCuartosDormir = "3";
				} else if (checkedId == R.id.radio4) {
					opCuartosDormir = "4";
				} else if (checkedId == R.id.radio5) {
					opCuartosDormir = "5";
				} else if (checkedId == R.id.radio6) {
					opCuartosDormir = "6";
				} else if (checkedId == R.id.radio7) {
					opCuartosDormir = "7";
				} else if (checkedId == R.id.radio8) {
					opCuartosDormir = "8";
				} else if (checkedId == R.id.radio9) {
					opCuartosDormir = "9";
				} else if (checkedId == R.id.radio10) {
					opCuartosDormir = "10";
				} else if (checkedId == R.id.radio0) {
					opCuartosDormir = "No contestó";
				} else {
					opCuartosDormir = "";

				}

			}
		});

		rdPreguntaFocos.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio1) {
					opFocos = "0 a 5";
				} else if (checkedId == R.id.radio2) {
					opFocos = "6 a 10";
				} else if (checkedId == R.id.radio3) {
					opFocos = "11 a 15";
				} else if (checkedId == R.id.radio4) {
					opFocos = "16 a 20";
				} else if (checkedId == R.id.radio5) {
					opFocos = "21 o más";
				} else if (checkedId == R.id.radio0) {
					opFocos = "No contestó";
				} else {
					opFocos = "";

				}

			}
		});

		rdPreguntaBanos.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio1) {
					opBanos = "Ninguno";
				} else if (checkedId == R.id.radio2) {
					opBanos = "Uno";
				} else if (checkedId == R.id.radio3) {
					opBanos = "Dos o Tres";
				} else if (checkedId == R.id.radio4) {
					opBanos = "Cuatro o más";
				} else if (checkedId == R.id.radio0) {
					opBanos = "No contestó";
				} else {
					opBanos = "";

				}

			}
		});

		rdPreguntaRegadera.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio1) {
					opRegadera = "Si";

				} else if (checkedId == R.id.radio2) {
					opRegadera = "No";
				} else if (checkedId == R.id.radio0) {
					opRegadera = "No contestó";
				} else {
					opRegadera = "";

				}

			}
		});
		
		rdPreguntaInternet.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				
						
				if (checkedId == R.id.radio1) {
					opInternet="Si";
					
				}
				else if (checkedId == R.id.radio2) {
					opInternet="No";
				}
				else if (checkedId == R.id.radio0) {
					opInternet="No sabe / no contestó";
				}
				else{
					opInternet="";
					
				}
				
			
			}
		});



	rdPreguntaTrabajaron.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			
					
			if (checkedId == R.id.radio1) {
				opTrabajaron="Ninguno";
				
			}
			else if (checkedId == R.id.radio2) {
				opTrabajaron="Uno";
			}
			else if (checkedId == R.id.radio3) {
				opTrabajaron="Dos";
			}
			else if (checkedId == R.id.radio4) {
				opTrabajaron="Tres";
			}
			else if (checkedId == R.id.radio5) {
				opTrabajaron="Cuatro o más";
			}
			else if (checkedId == R.id.radio0) {
				opTrabajaron="No sabe / no contestó";
			}
			else{
				opTrabajaron="";
				
			}
			
		
		}
	});

		rdPreguntaEstufa.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio1) {
					opEstufa = "Si";

				} else if (checkedId == R.id.radio2) {
					opEstufa = "No";
				} else if (checkedId == R.id.radio0) {
					opEstufa = "No contestó";
				} else {
					opEstufa = "";

				}

			}
		});

		rdPreguntaEdad.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio1) {
					opEdad = "Menor de 18 años";
				} else if (checkedId == R.id.radio2) {
					opEdad = "18 a 29";
				} else if (checkedId == R.id.radio3) {
					opEdad = "30 a 39";
				} else if (checkedId == R.id.radio4) {
					opEdad = "40 a 49";
				} else if (checkedId == R.id.radio5) {
					opEdad = "50 a 59";
				} else if (checkedId == R.id.radio6) {
					opEdad = "60 a 69";
				} else if (checkedId == R.id.radio7) {
					opEdad = "70 o más";
				} else if (checkedId == R.id.radio0) {
					opEdad = "No contestó";
				} else {
					opEdad = "";

				}

			}
		});

		rdPreguntaGenero.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio1) {
					opGenero = "Masculino";
				} else if (checkedId == R.id.radio2) {
					opGenero = "Femenino";
				}

			}
		});

		rdPreguntaTipoVivienda.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio1) {
					opTipoVivienda = "Casa";
				} else if (checkedId == R.id.radio2) {
					opTipoVivienda = "Condominio";
				} else if (checkedId == R.id.radio0) {
					opTipoVivienda = "No contestó";
				} else {
					opTipoVivienda = "";

				}

			}
		});

		rdPreguntaTipoPiso.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				if (checkedId == R.id.radio1) {
					opTipoPiso = "Tierra o cemento";
				} else if (checkedId == R.id.radio2) {
					opTipoPiso = "Cualquier otro";
				} else if (checkedId == R.id.radio0) {
					opTipoPiso = "No contestó";
				} else {
					opTipoPiso = "";

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

		
		
	}////// FIN ONCREATE/////////////////////////////
	
	public void mensaje(String mensaje){
		
		Toast.makeText(getBaseContext(),"Aviso: " +  mensaje,Toast.LENGTH_LONG).show();
		
	}

	@Override
	protected void onPause() {
		super.onPause();

	}
	
	////////  MUESTRA ADULTOS  ////
	
	public void muestraAdulto_1(){
		lay8_1 .setVisibility(View.VISIBLE);
		lay9_1 .setVisibility(View.VISIBLE);
		lay10_1 .setVisibility(View.VISIBLE);
		lay10a_1 .setVisibility(View.VISIBLE);
		lay10b_1 .setVisibility(View.VISIBLE);
		lay10c_1 .setVisibility(View.VISIBLE);
		lay11_1 .setVisibility(View.VISIBLE);
		lay12_1 .setVisibility(View.VISIBLE);
		lay13_1 .setVisibility(View.VISIBLE);
		lay14_1 .setVisibility(View.VISIBLE);
		lay14a_1 .setVisibility(View.VISIBLE);
		lay14b_1 .setVisibility(View.VISIBLE);
		
		rdPregunta8_1.clearCheck();
		rdPregunta9_1 .clearCheck();
		rdPregunta10_1.clearCheck();
		rdPregunta10a_1 .clearCheck();
		rdPregunta10b_1 .clearCheck();
		rdPregunta10c_1 .clearCheck();
		rdPregunta11_1.clearCheck();
		rdPregunta12_1.clearCheck();
		rdPregunta13a_1.clearCheck();
		rdPregunta13b_1.clearCheck();
		rdPregunta13c_1.clearCheck();
		rdPregunta14a_1.clearCheck();
		rdPregunta14b_1.clearCheck();
		
		editPregunta12_1.setText("");
		editPregunta12a_1.setText("");
		
		op8_1 ="sin datos";
		op9_1 ="sin datos";
		op10_1 ="sin datos";
		op10a_1 ="sin datos";
		op10b_1 ="sin datos";
		op10c_1 ="sin datos";
		op11_1 ="sin datos";
		op12_1 ="sin datos";
		op13_1 ="sin datos";
		op14_1 ="sin datos";
		op14a_1 ="sin datos";
		op14b_1 ="sin datos";
	}
	
	public void muestraAdulto_2(){
		lay8_2 .setVisibility(View.VISIBLE);
		lay9_2 .setVisibility(View.VISIBLE);
		lay10_2 .setVisibility(View.VISIBLE);
		lay10a_2 .setVisibility(View.VISIBLE);
		lay10b_2 .setVisibility(View.VISIBLE);
		lay10c_2 .setVisibility(View.VISIBLE);
		lay11_2 .setVisibility(View.VISIBLE);
		lay12_2 .setVisibility(View.VISIBLE);
		lay13_2 .setVisibility(View.VISIBLE);
		lay14_2 .setVisibility(View.VISIBLE);
		lay14a_2 .setVisibility(View.VISIBLE);
		lay14b_2 .setVisibility(View.VISIBLE);
		
		op8_2 ="sin datos";
		op9_2 ="sin datos";
		op10_2 ="sin datos";
		op10a_2 ="sin datos";
		op10b_2 ="sin datos";
		op10c_2 ="sin datos";
		op11_2 ="sin datos";
		op12_2 ="sin datos";
		op13_2 ="sin datos";
		op14_2 ="sin datos";
		op14a_2 ="sin datos";
		op14b_2 ="sin datos";
		
		editPregunta12_2.setText("");
		editPregunta12a_2.setText("");
		
		rdPregunta8_1.clearCheck();
		rdPregunta9_1 .clearCheck();
		rdPregunta10_1.clearCheck();
		rdPregunta10a_1 .clearCheck();
		rdPregunta10b_1 .clearCheck();
		rdPregunta10c_1 .clearCheck();
		rdPregunta11_1.clearCheck();
		rdPregunta12_1.clearCheck();
		rdPregunta13a_1.clearCheck();
		rdPregunta13b_1.clearCheck();
		rdPregunta13c_1.clearCheck();
		rdPregunta14a_1.clearCheck();
		rdPregunta14b_1.clearCheck();
		
	}
		
//////// OCULTA ADULTOS  ////
	
	public void ocultaAdulto_1(){
		lay8_1 .setVisibility(View.GONE);
		lay9_1 .setVisibility(View.GONE);
		lay10_1 .setVisibility(View.GONE);
		lay10a_1 .setVisibility(View.GONE);
		lay10b_1 .setVisibility(View.GONE);
		lay10c_1 .setVisibility(View.GONE);
		lay11_1 .setVisibility(View.GONE);
		lay12_1 .setVisibility(View.GONE);
		lay13_1 .setVisibility(View.GONE);
		lay13a_1 .setVisibility(View.GONE);
		lay13b_1 .setVisibility(View.GONE);
		lay13c_1 .setVisibility(View.GONE);
		lay14_1 .setVisibility(View.GONE);
		lay14a_1 .setVisibility(View.GONE);
		lay14b_1 .setVisibility(View.GONE);

		
		editPregunta12_1.setText("");
		editPregunta12a_1.setText("");
		
		
		
		op8_1 ="No aplica";
		op9_1 ="No aplica";
		op10_1 ="No aplica";
		op10a_1 ="No aplica";
		op10b_1 ="No aplica";
		op10c_1 ="No aplica";
		op11_1 ="No aplica";
		op12_1 ="No aplica";
		op13a_1 ="No aplica";
		op13b_1 ="No aplica";
		op13c_1 ="No aplica";
		op14_1 ="No aplica";
		op14a_1 ="No aplica";
		op14b_1 ="No aplica";
		
		rdPregunta8_1.clearCheck();
		rdPregunta9_1 .clearCheck();
		rdPregunta10_1.clearCheck();
		rdPregunta10a_1 .clearCheck();
		rdPregunta10b_1 .clearCheck();
		rdPregunta10c_1 .clearCheck();
		rdPregunta11_1.clearCheck();
		rdPregunta12_1.clearCheck();
		rdPregunta13a_1.clearCheck();
		rdPregunta13b_1.clearCheck();
		rdPregunta13c_1.clearCheck();
		rdPregunta14a_1.clearCheck();
		rdPregunta14b_1.clearCheck();
		

	}
	
	public void ocultaAdulto_2(){
		lay8_2 .setVisibility(View.GONE);
		lay9_2 .setVisibility(View.GONE);
		lay10_2 .setVisibility(View.GONE);
		lay10a_2 .setVisibility(View.GONE);
		lay10b_2 .setVisibility(View.GONE);
		lay10c_2 .setVisibility(View.GONE);
		lay11_2 .setVisibility(View.GONE);
		lay12_2 .setVisibility(View.GONE);
		lay13_2 .setVisibility(View.GONE);
		lay13a_2 .setVisibility(View.GONE);
		lay13b_2 .setVisibility(View.GONE);
		lay13c_2 .setVisibility(View.GONE);
		lay14_2 .setVisibility(View.GONE);
		lay14a_2 .setVisibility(View.GONE);
		lay14b_2 .setVisibility(View.GONE);

		op8_2 ="No aplica";
		op9_2 ="No aplica";
		op10_2 ="No aplica";
		op10a_2 ="No aplica";
		op10b_2 ="No aplica";
		op10c_2 ="No aplica";
		op11_2 ="No aplica";
		op12_2 ="No aplica";
		op13a_2 ="No aplica";
		op13b_2 ="No aplica";
		op13c_2 ="No aplica";
		op14_2 ="No aplica";
		op14a_2 ="No aplica";
		op14b_2 ="No aplica";
		
		
		editPregunta12_2.setText("");
		editPregunta12a_2.setText("");
		
		
		rdPregunta8_1.clearCheck();
		rdPregunta9_1 .clearCheck();
		rdPregunta10_1.clearCheck();
		rdPregunta10a_1 .clearCheck();
		rdPregunta10b_1 .clearCheck();
		rdPregunta10c_1 .clearCheck();
		rdPregunta11_1.clearCheck();
		rdPregunta12_1.clearCheck();
		rdPregunta13a_1.clearCheck();
		rdPregunta13b_1.clearCheck();
		rdPregunta13c_1.clearCheck();
		rdPregunta14a_1.clearCheck();
		rdPregunta14b_1.clearCheck();
		

	}

	
	public void MuestraMenorConDiscapacidad_1(){
		
//		lay31a .setVisibility(View.GONE);
//		op31a="No aplica";

		
		lay16_1 .setVisibility(View.VISIBLE);
		lay16_1 .setVisibility(View.VISIBLE);
		lay17_1 .setVisibility(View.VISIBLE);
		lay17a_1 .setVisibility(View.VISIBLE);
		lay17b_1 .setVisibility(View.VISIBLE);
		lay17c_1 .setVisibility(View.VISIBLE);
		lay18_1 .setVisibility(View.VISIBLE);
		lay19_1 .setVisibility(View.VISIBLE);
		lay20_1 .setVisibility(View.VISIBLE);
		lay21_1 .setVisibility(View.VISIBLE);
		lay22_1 .setVisibility(View.VISIBLE);
		lay22a_1 .setVisibility(View.VISIBLE);
		lay23_1 .setVisibility(View.VISIBLE);
		
		
		op16_1="sin datos";
		op17a_1="sin datos";
		op17b_1="sin datos";
		op17c_1="sin datos";
		op18_1="sin datos";
		op19_1="sin datos";
		op20_1="sin datos";
		op21_1="sin datos";
		op22_1="sin datos";
		op22a_1="sin datos";
		op23_1="sin datos";
		
		rdPregunta16_1.clearCheck();
		rdPregunta17_1.clearCheck();
		rdPregunta18_1.clearCheck();
		rdPregunta19_1.clearCheck();
		rdPregunta20_1.clearCheck();
		rdPregunta21_1.clearCheck();
		rdPregunta22_1.clearCheck();
		rdPregunta22a_1.clearCheck();
		rdPregunta23_1.clearCheck();
		

		
	}
	
	
	public void MuestraMenorConDiscapacidad_2(){
		
//		lay31a .setVisibility(View.GONE);
//		op31a="No aplica";

		lay16_2 .setVisibility(View.VISIBLE);
		lay16_2 .setVisibility(View.VISIBLE);
		lay17_2 .setVisibility(View.VISIBLE);
		lay17a_2 .setVisibility(View.VISIBLE);
		lay17b_2 .setVisibility(View.VISIBLE);
		lay17c_2 .setVisibility(View.VISIBLE);
		lay18_2 .setVisibility(View.VISIBLE);
		lay19_2 .setVisibility(View.VISIBLE);
		lay20_2 .setVisibility(View.VISIBLE);
		lay21_2 .setVisibility(View.VISIBLE);
		lay22_2 .setVisibility(View.VISIBLE);
		lay22a_2 .setVisibility(View.VISIBLE);
		lay23_2 .setVisibility(View.VISIBLE);
		
		
		op16_2="sin datos";
		op17a_2="sin datos";
		op17b_2="sin datos";
		op17c_2="sin datos";
		op18_2="sin datos";
		op19_2="sin datos";
		op20_2="sin datos";
		op21_2="sin datos";
		op22_2="sin datos";
		op22a_2="sin datos";
		op23_2="sin datos";
		
		rdPregunta16_2.clearCheck();
		rdPregunta17_2.clearCheck();
		rdPregunta18_2.clearCheck();
		rdPregunta19_2.clearCheck();
		rdPregunta20_2.clearCheck();
		rdPregunta21_2.clearCheck();
		rdPregunta22_2.clearCheck();
		rdPregunta22a_2.clearCheck();
		rdPregunta23_2.clearCheck();
		

		
	}
	
	
	
	public void ocultaMenorConDiscapacidad_1(){
		
//		lay31a .setVisibility(View.GONE);
//		op31a="No aplica";

		
		lay16_1 .setVisibility(View.GONE);
		lay16_1 .setVisibility(View.GONE);
		lay17_1 .setVisibility(View.GONE);
		lay17a_1 .setVisibility(View.GONE);
		lay17b_1 .setVisibility(View.GONE);
		lay17c_1 .setVisibility(View.GONE);
		lay18_1 .setVisibility(View.GONE);
		lay19_1 .setVisibility(View.GONE);
		lay20_1 .setVisibility(View.GONE);
		lay21_1 .setVisibility(View.GONE);
		lay22_1 .setVisibility(View.GONE);
		lay22a_1 .setVisibility(View.GONE);
		lay23_1 .setVisibility(View.GONE);
		
		
		op16_1="No aplica";
		op17a_1="No aplica";
		op17b_1="No aplica";
		op17c_1="No aplica";
		op18_1="No aplica";
		op19_1="No aplica";
		op20_1="No aplica";
		op21_1="No aplica";
		op22_1="No aplica";
		op22a_1="No aplica";
		op23_1="No aplica";
		
		rdPregunta16_1.clearCheck();
		rdPregunta17_1.clearCheck();
		rdPregunta18_1.clearCheck();
		rdPregunta19_1.clearCheck();
		rdPregunta20_1.clearCheck();
		rdPregunta21_1.clearCheck();
		rdPregunta22_1.clearCheck();
		rdPregunta22a_1.clearCheck();
		rdPregunta23_1.clearCheck();
		

		
	}
	
	public void ocultaMenorConDiscapacidad_2(){
		
//		lay31a .setVisibility(View.GONE);
//		op31a="No aplica";

		
		lay16_2 .setVisibility(View.GONE);
		lay16_2 .setVisibility(View.GONE);
		lay17_2 .setVisibility(View.GONE);
		lay17a_2 .setVisibility(View.GONE);
		lay17b_2 .setVisibility(View.GONE);
		lay17c_2 .setVisibility(View.GONE);
		lay18_2 .setVisibility(View.GONE);
		lay19_2 .setVisibility(View.GONE);
		lay20_2 .setVisibility(View.GONE);
		lay21_2 .setVisibility(View.GONE);
		lay22_2 .setVisibility(View.GONE);
		lay22a_2 .setVisibility(View.GONE);
		lay23_2 .setVisibility(View.GONE);
		
		
		op16_2="No aplica";
		op17a_2="No aplica";
		op17b_2="No aplica";
		op17c_2="No aplica";
		op18_2="No aplica";
		op19_2="No aplica";
		op20_2="No aplica";
		op21_2="No aplica";
		op22_2="No aplica";
		op22a_2="No aplica";
		op23_2="No aplica";
		
		rdPregunta16_2.clearCheck();
		rdPregunta17_2.clearCheck();
		rdPregunta18_2.clearCheck();
		rdPregunta19_2.clearCheck();
		rdPregunta20_2.clearCheck();
		rdPregunta21_2.clearCheck();
		rdPregunta22_2.clearCheck();
		rdPregunta22a_2.clearCheck();
		rdPregunta23_2.clearCheck();
		

		
	}
	
	
	
	
//	
//	
//	public void muestraDireccion() {
//	
//		lay3 .setVisibility(View.GONE);
//		lay4 .setVisibility(View.GONE);
//		lay5 .setVisibility(View.GONE);
//		lay6 .setVisibility(View.GONE);
//		lay6a .setVisibility(View.GONE);
//		lay6b .setVisibility(View.GONE);
//		lay6c .setVisibility(View.GONE);
//		lay7 .setVisibility(View.GONE);
//		lay7a .setVisibility(View.GONE);
//		
//		
////		ocultaAdulto_1();
////		ocultaAdulto_2();
////		
//		
//		
//		lay90.setVisibility(View.VISIBLE); 
//		lay90a.setVisibility(View.VISIBLE); 
//		lay90b.setVisibility(View.VISIBLE); 
//		lay90c.setVisibility(View.VISIBLE); 
//		lay90d.setVisibility(View.VISIBLE); 
//		lay90e.setVisibility(View.VISIBLE); 
//		lay90f.setVisibility(View.VISIBLE); 
//		lay90g.setVisibility(View.VISIBLE); 
//		lay90h.setVisibility(View.VISIBLE); 
//		lay90i.setVisibility(View.VISIBLE); 
//		lay90j.setVisibility(View.VISIBLE); 
//
//
//		
//	}
//	

	
	public void ocultaDireccion() {
	
	lay3 .setVisibility(View.VISIBLE);
	lay4 .setVisibility(View.VISIBLE);
	lay5 .setVisibility(View.VISIBLE);
	lay6 .setVisibility(View.VISIBLE);
	lay6a .setVisibility(View.VISIBLE);
	lay6b .setVisibility(View.VISIBLE);
	lay6c .setVisibility(View.VISIBLE);
	lay7 .setVisibility(View.VISIBLE);
//	lay7a .setVisibility(View.VISIBLE);
	

	
		
	
	
	}
	
	
	public void ocultaTodo(){
	lay3 .setVisibility(View.GONE);
	lay4 .setVisibility(View.GONE);
	lay5 .setVisibility(View.GONE);
	lay6 .setVisibility(View.GONE);
	lay6a .setVisibility(View.GONE);
	lay6b .setVisibility(View.GONE);
	lay6c .setVisibility(View.GONE);
	lay7 .setVisibility(View.GONE);
	lay7a .setVisibility(View.GONE);
	
	
	rdPregunta3.clearCheck();
	rdPregunta4 .clearCheck();
	rdPregunta5 .clearCheck();
	rdPregunta6 .clearCheck();
	rdPregunta6a.clearCheck();
	rdPregunta6b.clearCheck();
	rdPregunta6c.clearCheck();
	rdPregunta7 .clearCheck();
	rdPregunta7a.clearCheck();
	
	ocultaAdulto_1();
	ocultaAdulto_2();
	
	ocultaMenorConDiscapacidad_1();
	ocultaMenorConDiscapacidad_2();
	
	
	
	lay90.setVisibility(View.GONE); 
	lay90a.setVisibility(View.GONE); 
	lay90b.setVisibility(View.GONE); 
	lay90c.setVisibility(View.GONE); 
	lay90d.setVisibility(View.GONE); 
	lay90e.setVisibility(View.GONE); 
	lay90f.setVisibility(View.GONE); 
	lay90g.setVisibility(View.GONE); 
	lay90h.setVisibility(View.GONE); 
	lay90i.setVisibility(View.GONE); 
	lay90j.setVisibility(View.GONE); 
}

	public void ocultaAdultos(){
	
		
		ocultaAdulto_1();
		ocultaAdulto_2();
		
	
}
	
	public void ocultaEstadisticas(){
		layEst.setVisibility(View.GONE);
		layEdad.setVisibility(View.GONE);
		layHijos.setVisibility(View.GONE);
		layAporta.setVisibility(View.GONE);
		layOcupacion.setVisibility(View.GONE);
		layTrabajaron.setVisibility(View.GONE);
		layCoche.setVisibility(View.GONE);
		layCuantosCoches.setVisibility(View.GONE);
		layCuartos.setVisibility(View.GONE);
		layCuartosDormir.setVisibility(View.GONE);
		layFocos.setVisibility(View.GONE);
		layBanos.setVisibility(View.GONE);
		layRegadera.setVisibility(View.GONE);
		layInternet.setVisibility(View.GONE);
		layEstufa.setVisibility(View.GONE);
		layTipoPiso.setVisibility(View.GONE);
		layTipoVivienda.setVisibility(View.GONE);
		layGenero.setVisibility(View.GONE);
		
		opEdad="No aplica";
		opAporta="No aplica";
		opOcupacion="No aplica";
		opTrabajaron="No aplica";
		opCoche="No aplica";
		opCuantosCoches="No aplica";
		opCuartos="No aplica";
		opCuartosDormir="No aplica";
		opFocos="No aplica";
		opBanos="No aplica";
		opRegadera="No aplica";
		opInternet="No aplica";
		opEstufa="No aplica";
		opTipoPiso="No aplica";
		opTipoVivienda="No aplica";
		opGenero="No aplica";
	}
	
	public void muestraEstadisticas(){
		layEst.setVisibility(View.VISIBLE);
		layEdad.setVisibility(View.VISIBLE);
		layHijos.setVisibility(View.VISIBLE);
		layAporta.setVisibility(View.VISIBLE);
		layOcupacion.setVisibility(View.VISIBLE);
		layTrabajaron.setVisibility(View.VISIBLE);
		layCoche.setVisibility(View.VISIBLE);
		layCuantosCoches.setVisibility(View.VISIBLE);
		layCuartos.setVisibility(View.VISIBLE);
		layCuartosDormir.setVisibility(View.VISIBLE);
		layFocos.setVisibility(View.VISIBLE);
		layBanos.setVisibility(View.VISIBLE);
		layRegadera.setVisibility(View.VISIBLE);
		layInternet.setVisibility(View.VISIBLE);
		layEstufa.setVisibility(View.VISIBLE);
		layTipoPiso.setVisibility(View.VISIBLE);
		layTipoVivienda.setVisibility(View.VISIBLE);
		layGenero.setVisibility(View.VISIBLE);
	}



	
	class CierraEncuesta extends TimerTask {

		@Override
		public void run() {

			dialogoCierraEncuesta();

		}

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

		txtSeccion.setText(cachaSeccion());

		String strSecc = txtSeccion.getText().toString();
		String strId = String.valueOf(rand + 1);

		elMaximo = Integer.parseInt(sacaMaximo().toString()) + 1;
		
		String strText12_1;
		String strText12a_1;
		if(editPregunta12_1.getText().toString().trim().length()==0 && editPregunta12a_1.getText().toString().trim().length()==0){
			strText12_1=op12_1;
			strText12a_1=op12_1;
		}else{
			strText12_1=editPregunta12_1.getText().toString().trim();
			strText12a_1=editPregunta12a_1.getText().toString().trim();
			rdPregunta12_1.clearCheck();
		}
		
		String strText12_2;
		String strText12a_2;
		if(editPregunta12_2.getText().toString().trim().length()==0 && editPregunta12a_2.getText().toString().trim().length()==0){
			strText12_2=op12_2;
			strText12a_2=op12_2;
		}else{
			strText12_2=editPregunta12_2.getText().toString().trim();
			strText12a_2=editPregunta12a_2.getText().toString().trim();
			rdPregunta12_2.clearCheck();
		}
		
	
		
		
		String strText16_1;
		if(editPregunta16_1.getText().toString().trim().length()==0){
			strText16_1=op16_1;
		}else{
			strText16_1=editPregunta16_1.getText().toString().trim();
			rdPregunta16_1.clearCheck();
		}
		
		String strText16_2;
		if(editPregunta16_2.getText().toString().trim().length()==0){
			strText16_2=op16_2;
		}else{
			strText16_2=editPregunta16_2.getText().toString().trim();
			rdPregunta16_2.clearCheck();
		}
		
		
		
		
		String strText17a_1;
		if(spinner17a_1.getSelectedItem().toString().equals("Selecciona")){
			strText17a_1=op17a_1;
		}else{
			strText17a_1=spinner17a_1.getSelectedItem().toString();
			rdPregunta17a_1.clearCheck();
		}

		String strText17b_1;
		if(spinner17b_1.getSelectedItem().toString().equals("Selecciona")){
			strText17b_1=op17b_1;
		}else{
			strText17b_1=spinner17b_1.getSelectedItem().toString();
			rdPregunta17b_1.clearCheck();
		}
		
		String strText17c_1;
		if(spinner17c_1.getSelectedItem().toString().equals("Selecciona")){
			strText17c_1=op17c_1;
		}else{
			strText17c_1=spinner17c_1.getSelectedItem().toString();
			rdPregunta17c_1.clearCheck();
		}
		
		String strText17a_2;
		if(spinner17a_2.getSelectedItem().toString().equals("Selecciona")){
			strText17a_2=op17a_2;
		}else{
			strText17a_2=spinner17a_2.getSelectedItem().toString();
			rdPregunta17a_2.clearCheck();
		}

		String strText17b_2;
		if(spinner17b_2.getSelectedItem().toString().equals("Selecciona")){
			strText17b_2=op17b_2;
		}else{
			strText17b_2=spinner17b_2.getSelectedItem().toString();
			rdPregunta17b_2.clearCheck();
		}
		
		String strText17c_2;
		if(spinner17c_2.getSelectedItem().toString().equals("Selecciona")){
			strText17c_2=op17c_2;
		}else{
			strText17c_2=spinner17c_2.getSelectedItem().toString();
			rdPregunta17c_2.clearCheck();
		}
		
		
		String strText18_1;
		if(editPregunta18_1.getText().toString().trim().length()==0){
			strText18_1=op18_1;
		}else{
			strText18_1=editPregunta18_1.getText().toString().trim();
			rdPregunta18_1.clearCheck();
		}
		
		String strText18_2;
		if(editPregunta18_2.getText().toString().trim().length()==0){
			strText18_2=op18_2;
		}else{
			strText18_2=editPregunta18_2.getText().toString().trim();
			rdPregunta18_2.clearCheck();
		}
		
		
		String strText19_1;
		if(editPregunta19_1.getText().toString().trim().length()==0){
			strText19_1=op19_1;
		}else{
			strText19_1=editPregunta19_1.getText().toString().trim();
			rdPregunta19_1.clearCheck();
		}
		
		String strText19_2;
		if(editPregunta19_2.getText().toString().trim().length()==0){
			strText19_2=op19_2;
		}else{
			strText19_2=editPregunta19_2.getText().toString().trim();
			rdPregunta19_2.clearCheck();
		}
		
		String strText21_1;
		if(editPregunta21_1.getText().toString().trim().length()==0){
			strText21_1=op21_1;
		}else{
			strText21_1=editPregunta21_1.getText().toString().trim();
			rdPregunta21_1.clearCheck();
		}
		
		String strText21_2;
		if(editPregunta21_2.getText().toString().trim().length()==0){
			strText21_2=op21_2;
		}else{
			strText21_2=editPregunta21_2.getText().toString().trim();
			rdPregunta21_2.clearCheck();
		}

		
		String strText22a_1;
		if(editPregunta22a_1.getText().toString().trim().length()==0){
			strText22a_1=op22a_1;
		}else{
			strText22a_1=editPregunta22a_1.getText().toString().trim();
			rdPregunta22a_1.clearCheck();
		}
		
		String strText22a_2;
		if(editPregunta22a_2.getText().toString().trim().length()==0){
			strText22a_2=op22a_2;
		}else{
			strText22a_2=editPregunta22a_2.getText().toString().trim();
			rdPregunta22a_2.clearCheck();
		}
		
		String str1 = op1;
		String str2 = op2;
		String str3 = op3;
		String str4 = op4;
		String str5 = op5;
		String str6 = op6;
		String str6a = op6a;
		String str6b = op6b;
		String str6c = op6c;
		String str7 = op7;
		String str7a = op7a;
		String str8_1 = op8_1;
		String str9_1 = op9_1;
		String str10_1 = op10_1;
		String str10a_1 = op10a_1;
		String str10b_1 = op10b_1;
		String str10c_1 = op10c_1;
		String str11_1 = op11_1;
		String str12_1 = strText12_1;
		String str12a_1 = strText12a_1;
		String str13_1 = op13_1;
		String str13a_1 = op13a_1;
		String str13b_1 = op13b_1;
		String str13c_1 = op13c_1;
		String str14_1 = op14_1;
		String str14a_1 = op14a_1;
		String str14b_1 = op14b_1;
		String str8_2 = op8_2;
		String str9_2 = op9_2;
		String str10_2 = op10_2;
		String str10a_2 = op10a_2;
		String str10b_2 = op10b_2;
		String str10c_2 = op10c_2;
		String str11_2 = op11_2;
		String str12_2 = strText12_2;
		String str12a_2 = strText12a_2;
		String str13_2 = op13_2;
		String str13a_2 = op13a_2;
		String str13b_2 = op13b_2;
		String str13c_2 = op13c_2;
		String str14_2 = op14_2;
		String str14a_2 = op14a_2;
		String str14b_2 = op14b_2;
		String str15 = op15;
		String str15a = op15a;
		String str16_1 = strText16_1;
		String str17_1 = op17_1;
		String str17a_1 = strText17a_1;
		String str17b_1 = strText17b_1;
		String str17c_1 = strText17c_1;
		String str18_1 = strText18_1;
		String str19_1 = strText19_1;
		String str20_1 = op20_1;
		String str21_1 = strText21_1;
		String str22_1 = op22_1;
		String str22a_1 = strText22a_1;
		String str23_1 = op23_1;
		String str16_2 = strText16_2;
		String str17_2 = op17_2;
		String str17a_2 = strText17a_2;
		String str17b_2 = strText17b_2;
		String str17c_2 = strText17c_2;
		String str18_2 = strText18_2;
		String str19_2 = strText19_2;
		String str20_2 = op20_2;
		String str21_2 = strText21_2;
		String str22_2 = op22_2;
		String str22a_2 = strText22a_2;
		String str23_2 = op23_2;


		String str90 = "cabecera de pregunta";
		String str90a = editPregunta90a.getText().toString();
		String str90b = editPregunta90b.getText().toString();
		String str90c = editPregunta90c.getText().toString();
		String str90d = editPregunta90d.getText().toString();
		String str90e = editPregunta90e.getText().toString();
		String str90f = editPregunta90f.getText().toString();
		String str90g = editPregunta90g.getText().toString();
		String str90h = editPregunta90h.getText().toString();
		String str90i = spinner90i.getSelectedItem().toString();
		String str90j = editPregunta90j.getText().toString();

	
		
		
		
		
		String strHijos		= opHijos;
		String strEdad 		= opEdad;
		String strAporta 	= opAporta;
		String strOcupacion = opOcupacion;
		String strTrabajaron = opTrabajaron;
		String strCoches 	= opCoche;// coche
		String strCuantosCoches = opCuantosCoches;
		String strCuartos 	= opCuartos;
		String strCuartosDormir = opCuartosDormir;
		String strFocos 	= opFocos;
		String strBanos 	= opBanos;
		String strRegadera 	= opRegadera;
		String strInternet 	= opInternet;
		String strEstufa 	= opEstufa;
		String strTipoPiso 	= opTipoPiso;
		String strTipoVivienda = opTipoVivienda;
		String strGenero 	= opGenero;
		
		
		String strAbandono = opAbandono;
		
		

		if (strAbandono.matches("1")) {
			tipoEncuesta = "NORMAL";
		}

		String strEstudios = opAporta;
		String strCocheCuantos = opCuantosCoches;
		String strFoco = opFocos;
		String strCuarto = opCuartos;
		String strBano = opBanos;
		String strRega = opRegadera;
		String strEstu = opEstufa;
		String strPiso = opTipoPiso;

		// estudios
		if (strEstudios.matches("sin datos")) {
			strEstudios = "0";
		} else if (strEstudios.matches("No completó primaria")) {
			strEstudios = "0";
		} else if (strEstudios.matches("Primaria o secundaria")) {
			strEstudios = "22";
		} else if (strEstudios.matches("Preparatoria o carrera técnica")) {
			strEstudios = "38";
		} else if (strEstudios.matches("Licenciatura")) {
			strEstudios = "52";
		} else if (strEstudios.matches("Posgrado")) {
			strEstudios = "72";
		} else if (strEstudios.matches("No contestó")) {
			strEstudios = "0";
		}else if (strEstudios.matches("No aplica")) {
			strEstudios = "0";
		}
		// coches
		if (strCocheCuantos.matches("sin datos")) {
			strCocheCuantos = "0";
		} else if (strCocheCuantos.matches("Ninguno")) {
			strCocheCuantos = "0";
		} else if (strCocheCuantos.matches("Uno")) {
			strCocheCuantos = "32";
		} else if (strCocheCuantos.matches("Dos")) {
			strCocheCuantos = "41";
		} else if (strCocheCuantos.matches("Tres")) {
			strCocheCuantos = "58";
		} else if (strCocheCuantos.matches("Cuatro o más")) {
			strCocheCuantos = "58";
		} else if (strCocheCuantos.matches("No contestó")) {
			strCocheCuantos = "0";
		}else if (strCocheCuantos.matches("No aplica")) {
			strCocheCuantos = "0";
		}
		// Focos
		if (strFoco.matches("sin datos")) {
			strFoco = "0";
		} else if (strFoco.matches("0 a 5")) {
			strFoco = "0";
		} else if (strFoco.matches("6 a 10")) {
			strFoco = "15";
		} else if (strFoco.matches("11 a 15")) {
			strFoco = "27";
		} else if (strFoco.matches("16 a 20")) {
			strFoco = "32";
		} else if (strFoco.matches("21 o más")) {
			strFoco = "46";
		} else if (strFoco.matches("No contestó")) {
			strFoco = "0";
		}else if (strFoco.matches("No aplica")) {
			strFoco = "0";
		}
		// Cuartos
		if (strCuarto.matches("sin datos")) {
			strCuarto = "0";
		} else if (strCuarto.matches("1")) {
			strCuarto = "0";
		} else if (strCuarto.matches("2")) {
			strCuarto = "0";
		} else if (strCuarto.matches("3")) {
			strCuarto = "0";
		} else if (strCuarto.matches("4")) {
			strCuarto = "0";
		} else if (strCuarto.matches("5")) {
			strCuarto = "8";
		} else if (strCuarto.matches("6")) {
			strCuarto = "8";
		} else if (strCuarto.matches("7")) {
			strCuarto = "14";
		} else if (strCuarto.matches("8")) {
			strCuarto = "14";
		} else if (strCuarto.matches("9")) {
			strCuarto = "14";
		} else if (strCuarto.matches("10")) {
			strCuarto = "14";
		} else if (strCuarto.matches("No contestó")) {
			strCuarto = "0";
		} else if (strCuarto.matches("No aplica")) {
			strCuarto = "0";
		}
		// Banos
		if (strBano.matches("sin datos")) {
			strBano = "0";
		} else if (strBano.matches("Ninguno")) {
			strBano = "0";
		} else if (strBano.matches("Uno")) {
			strBano = "13";
		} else if (strBano.matches("Dos o Tres")) {
			strBano = "31";
		} else if (strBano.matches("Cuatro o más")) {
			strBano = "48";
		} else if (strBano.matches("No contestó")) {
			strBano = "0";
		} else if (strBano.matches("No aplica")) {
			strBano = "0";
		}
		// Regadera
		if (strRega.matches("sin datos")) {
			strRega = "0";
		} else if (strRega.matches("Si")) {
			strRega = "10";
		} else if (strRega.matches("No")) {
			strRega = "0";
		} else if (strRega.matches("No contestó")) {
			strRega = "0";
		} else if (strRega.matches("No aplica")) {
			strRega = "0";
		}
		// Estufa
		if (strEstu.matches("sin datos")) {
			strEstu = "0";
		} else if (strEstu.matches("Si")) {
			strEstu = "20";
		} else if (strEstu.matches("No")) {
			strEstu = "0";
		} else if (strEstu.matches("No contestó")) {
			strEstu = "0";
		} else if (strEstu.matches("No aplica")) {
			strEstu = "0";
		}
		// Piso
		if (strPiso.matches("sin datos")) {
			strPiso = "0";
		} else if (strPiso.matches("Tierra o cemento")) {
			strPiso = "0";
		} else if (strPiso.matches("Cualquier otro")) {
			strPiso = "11";
		} else if (strPiso.matches("No contestó")) {
			strPiso = "0";
		} else if (strPiso.matches("No aplica")) {
			strPiso = "0";
		}

		Integer estudios = Integer.valueOf(strEstudios);
		Integer coches = Integer.valueOf(strCocheCuantos);
		Integer focos = Integer.valueOf(strFoco);
		Integer cuartos = Integer.valueOf(strCuarto);
		Integer banos = Integer.valueOf(strBano);
		Integer regadera = Integer.valueOf(strRega);
		Integer estufa = Integer.valueOf(strEstu);
		Integer piso = Integer.valueOf(strPiso);

		Integer suma = (estudios + coches + focos + cuartos + banos + regadera + estufa + piso);

		String status = null;

		if (suma >= 0 && suma <= 32) {
			status = "E";
		} else if (suma >= 33 && suma <= 79) {
			status = "D";
		} else if (suma >= 80 && suma <= 104) {
			status = "D+";
		} else if (suma >= 105 && suma <= 127) {
			status = "C-";
		} else if (suma >= 128 && suma <= 154) {
			status = "C";
		} else if (suma >= 155 && suma <= 192) {
			status = "C+";
		} else if (suma >= 193) {
			status = "AB";
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

			String strLatitud = String.valueOf(latitude);
			String strLongitud = String.valueOf(longitude);
			
			
			if (latitude == 0.0) {
				latitude = Double.valueOf(sacaLatitud());
				
			}

			if (longitude == 0.0) {
				longitude = Double.valueOf(sacaLongitud());
				
			}

			String strLatitud2 = String.valueOf(latitude);
			String strLongitud2 = String.valueOf(longitude);

			if (db != null) {
				ContentValues values = new ContentValues();
				values.put("consecutivo_diario", elMaximo);
				values.put("equipo", cachaEquipo().toUpperCase());
				values.put("usuario", cachaNombre().toUpperCase());
				values.put("nombre_encuesta", nombreE.toUpperCase());
				values.put("fecha", formattedDate1);
				values.put("hora", formattedDate5);
				values.put("imei", sacaImei());
				values.put("seccion", strSecc);
				values.put("latitud", strLatitud);
				values.put("longitud", strLongitud);
				values.put("latitud2", strLatitud2);
				values.put("longitud2", strLongitud2);

				values.put("pregunta_1",str1);
				values.put("pregunta_2",str2);
				values.put("pregunta_3",str3);
				values.put("pregunta_4",str4);
				values.put("pregunta_5",str5);
				values.put("pregunta_6",str6);
				values.put("pregunta_6a",str6a);
				values.put("pregunta_6b",str6b);
				values.put("pregunta_6c",str6c);
				values.put("pregunta_7",str7);
				values.put("pregunta_7a",str7a);
				values.put("pregunta_8_1",str8_1);
				values.put("pregunta_9_1",str9_1);
				values.put("pregunta_10_1",str10_1);
				values.put("pregunta_10a_1",str10a_1);
				values.put("pregunta_10b_1",str10b_1);
				values.put("pregunta_10c_1",str10c_1);
				values.put("pregunta_11_1",str11_1);
				values.put("pregunta_12_1",str12_1);
				values.put("pregunta_12a_1",str12a_1);
				values.put("pregunta_13_1",str13_1);
				values.put("pregunta_13a_1",str13a_1);
				values.put("pregunta_13b_1",str13b_1);
				values.put("pregunta_13c_1",str13c_1);
				values.put("pregunta_14_1",str14_1);
				values.put("pregunta_14a_1",str14a_1);
				values.put("pregunta_14b_1",str14b_1);
				values.put("pregunta_8_2",str8_2);
				values.put("pregunta_9_2",str9_2);
				values.put("pregunta_10_2",str10_2);
				values.put("pregunta_10a_2",str10a_2);
				values.put("pregunta_10b_2",str10b_2);
				values.put("pregunta_10c_2",str10c_2);
				values.put("pregunta_11_2",str11_2);
				values.put("pregunta_12_2",str12_2);
				values.put("pregunta_12a_2",str12a_2);
				values.put("pregunta_13_2",str13_2);
				values.put("pregunta_13a_2",str13a_2);
				values.put("pregunta_13b_2",str13b_2);
				values.put("pregunta_13c_2",str13c_2);
				values.put("pregunta_14_2",str14_2);
				values.put("pregunta_14a_2",str14a_2);
				values.put("pregunta_14b_2",str14b_2);
				values.put("pregunta_15",str15);
				values.put("pregunta_15a",str15a);
				values.put("pregunta_16_1",str16_1);
				values.put("pregunta_17_1",str17_1);
				values.put("pregunta_17a_1",str17a_1);
				values.put("pregunta_17b_1",str17b_1);
				values.put("pregunta_17c_1",str17c_1);
				values.put("pregunta_18_1",str18_1);
				values.put("pregunta_19_1",str19_1);
				values.put("pregunta_20_1",str20_1);
				values.put("pregunta_21_1",str21_1);
				values.put("pregunta_22_1",str22_1);
				values.put("pregunta_22a_1",str22a_1);
				values.put("pregunta_23_1",str23_1);
				values.put("pregunta_16_2",str16_2);
				values.put("pregunta_17_2",str17_2);
				values.put("pregunta_17a_2",str17a_2);
				values.put("pregunta_17b_2",str17b_2);
				values.put("pregunta_17c_2",str17c_2);
				values.put("pregunta_18_2",str18_2);
				values.put("pregunta_19_2",str19_2);
				values.put("pregunta_20_2",str20_2);
				values.put("pregunta_21_2",str21_2);
				values.put("pregunta_22_2",str22_2);
				values.put("pregunta_22a_2",str22a_2);
				values.put("pregunta_23_2",str23_2);
				values.put("pregunta_90",str90);
				values.put("pregunta_90a",str90a);
				values.put("pregunta_90b",str90b);
				values.put("pregunta_90c",str90c);
				values.put("pregunta_90d",str90d);
				values.put("pregunta_90e",str90e);
				values.put("pregunta_90f",str90f);
				values.put("pregunta_90g",str90g);
				values.put("pregunta_90h",str90h);
				values.put("pregunta_90i",str90i);
				values.put("pregunta_90j",str90j);

				
				
				values.put("hijos", strHijos);
				values.put("aporta", strAporta);
				values.put("ocupacion", strOcupacion);
				values.put("coche", strCoches);
				values.put("cuantos_coches", strCuantosCoches);
				values.put("cuartos", strCuartos);
				values.put("cuartos_dormir", strCuartosDormir);
				values.put("focos", strFocos);
				values.put("banos", strBanos);
				values.put("regadera", strRegadera);
				values.put("internet", strInternet);
				values.put("trabajaron", strTrabajaron);
				values.put("estufa", strEstufa);
				values.put("edad", strEdad);
				values.put("genero", strGenero);
				values.put("tipo_vivienda", strTipoVivienda);
				values.put("tipo_piso", strTipoPiso);
				values.put("foto_fachada", "sin foto");

				


				values.put("abandono", strAbandono.toUpperCase());

				values.put("suma", suma);
				values.put("status", status);

				values.put("tiempo", elTiempo());
				values.put("tipocaptura", tipoEncuesta);

				db.insert("encuestas", null, values);
			}
			
			
						
			db.close();

			System.out.println("Latitud  " + strLatitud);
			System.out.println("Longitud  " + strLongitud);
			
			System.out.println("Latitud2  " + strLatitud2);
			System.out.println("Longitud2  " + strLongitud2);

			System.out.println("pregunta_1  " +   str1);
			System.out.println("pregunta_2  " +   str2);
			System.out.println("pregunta_3  " +   str3);
			System.out.println("pregunta_4  " +   str4);
			System.out.println("pregunta_5  " +   str5);
			System.out.println("pregunta_6  " +   str6);
			System.out.println("pregunta_6a  " +   str6a);
			System.out.println("pregunta_6b  " +   str6b);
			System.out.println("pregunta_6c  " +   str6c);
			System.out.println("pregunta_7  " +   str7);
			System.out.println("pregunta_7a  " +   str7a);
			System.out.println("pregunta_8_1  " +   str8_1);
			System.out.println("pregunta_9_1  " +   str9_1);
			System.out.println("pregunta_10_1  " +   str10_1);
			System.out.println("pregunta_10a_1  " +   str10a_1);
			System.out.println("pregunta_10b_1  " +   str10b_1);
			System.out.println("pregunta_10c_1  " +   str10c_1);
			System.out.println("pregunta_11_1  " +   str11_1);
			System.out.println("pregunta_12_1  " +   str12_1);
			System.out.println("pregunta_12a_1  " +   str12a_1);
			System.out.println("pregunta_13_1  " +   str13_1);
			System.out.println("pregunta_13a_1  " +   str13a_1);
			System.out.println("pregunta_13b_1  " +   str13b_1);
			System.out.println("pregunta_13c_1  " +   str13c_1);
			System.out.println("pregunta_14_1  " +   str14_1);
			System.out.println("pregunta_14a_1  " +   str14a_1);
			System.out.println("pregunta_14b_1  " +   str14b_1);
			System.out.println("pregunta_8_2  " +   str8_2);
			System.out.println("pregunta_9_2  " +   str9_2);
			System.out.println("pregunta_10_2  " +   str10_2);
			System.out.println("pregunta_10a_2  " +   str10a_2);
			System.out.println("pregunta_10b_2  " +   str10b_2);
			System.out.println("pregunta_10c_2  " +   str10c_2);
			System.out.println("pregunta_11_2  " +   str11_2);
			System.out.println("pregunta_12_2  " +   str12_2);
			System.out.println("pregunta_12a_2  " +   str12a_2);
			System.out.println("pregunta_13_2  " +   str13_2);
			System.out.println("pregunta_13a_2  " +   str13a_2);
			System.out.println("pregunta_13b_2  " +   str13b_2);
			System.out.println("pregunta_13c_2  " +   str13c_2);
			System.out.println("pregunta_14_2  " +   str14_2);
			System.out.println("pregunta_14a_2  " +   str14a_2);
			System.out.println("pregunta_14b_2  " +   str14b_2);
			System.out.println("pregunta_15  " +   str15);
			System.out.println("pregunta_15a  " +   str15a);
			System.out.println("pregunta_16_1  " +   str16_1);
			System.out.println("pregunta_17_1  " +   str17_1);
			System.out.println("pregunta_17a_1  " +   str17a_1);
			System.out.println("pregunta_17b_1  " +   str17b_1);
			System.out.println("pregunta_17c_1  " +   str17c_1);
			System.out.println("pregunta_18_1  " +   str18_1);
			System.out.println("pregunta_19_1  " +   str19_1);
			System.out.println("pregunta_20_1  " +   str20_1);
			System.out.println("pregunta_21_1  " +   str21_1);
			System.out.println("pregunta_22_1  " +   str22_1);
			System.out.println("pregunta_22a_1  " +   str22a_1);
			System.out.println("pregunta_23_1  " +   str23_1);
			System.out.println("pregunta_16_2  " +   str16_2);
			System.out.println("pregunta_17_2  " +   str17_2);
			System.out.println("pregunta_17a_2  " +   str17a_2);
			System.out.println("pregunta_17b_2  " +   str17b_2);
			System.out.println("pregunta_17c_2  " +   str17c_2);
			System.out.println("pregunta_18_2  " +   str18_2);
			System.out.println("pregunta_19_2  " +   str19_2);
			System.out.println("pregunta_20_2  " +   str20_2);
			System.out.println("pregunta_21_2  " +   str21_2);
			System.out.println("pregunta_22_2  " +   str22_2);
			System.out.println("pregunta_22a_2  " +   str22a_2);
			System.out.println("pregunta_23_2  " +   str23_2);
			System.out.println("pregunta_90  " +   str90);
			System.out.println("pregunta_90a  " +   str90a);
			System.out.println("pregunta_90b  " +   str90b);
			System.out.println("pregunta_90c  " +   str90c);
			System.out.println("pregunta_90d  " +   str90d);
			System.out.println("pregunta_90e  " +   str90e);
			System.out.println("pregunta_90f  " +   str90f);
			System.out.println("pregunta_90g  " +   str90g);
			System.out.println("pregunta_90h  " +   str90h);
			System.out.println("pregunta_90i  " +   str90i);
			System.out.println("pregunta_90j  " +   str90j);

			
			System.out.println(" hijos   " + strHijos);
			System.out.println(" trabajaron   " + strTrabajaron);
			System.out.println(" coche   " + strCoches);
			System.out.println(" cuantos_coches   " + strCuantosCoches);
			System.out.println(" cuartos   " + strCuartos);
			System.out.println(" cuartos_dormir   " + strCuartosDormir);
			System.out.println(" focos   " + strFocos);
			System.out.println(" baños   " + strBanos);
			System.out.println(" regadera   " + strRegadera);
			System.out.println(" internet   " + strInternet);
			System.out.println(" estufa   " + strEstufa);
			System.out.println(" tipo_piso   " + strTipoPiso);
			System.out.println(" tipo_vivienda   " + strTipoVivienda);
			System.out.println(" genero   " + strGenero);
			
			
			
			System.out.println("pregunta_90  " +   str90);
			System.out.println("pregunta_90a  " +   str90a);
			System.out.println("pregunta_90b  " +   str90b);
			System.out.println("pregunta_90c  " +   str90c);
			System.out.println("pregunta_90d  " +   str90d);
			System.out.println("pregunta_90e  " +   str90e);
			System.out.println("pregunta_90f  " +   str90f);
			System.out.println("pregunta_90g  " +   str90g);
			System.out.println("pregunta_90h  " +   str90h);
			System.out.println("pregunta_90i  " +   str90i);
			System.out.println("pregunta_90j  " +   str90j);
			System.out.println("foto_fachada  " +   "sin foto");

			System.out.println("abandono  " + strAbandono);

			System.out.println("suma  " + suma);
			System.out.println("status  " + status);

			// FIN INSERTA BASE DE DATOS //

		} catch (Exception e) {
			System.out.println("algo pasó...1");
		}

	}


	

	public void guardar(View v) {
		System.out.println(cachaDelegacion());

//		timer.cancel();

		String str = "";

		if (opAbandono.matches("sin datos")) {
			opAbandono = "1";
		}

		int tipo = Integer.parseInt(opAbandono);

		switch (tipo) {
		case 1:

			String strText10 = null;
				
			
			
			
			
			
			

			 
			  if (lay1.getVisibility() == 0 && op1.matches("sin datos")){Toast.makeText(this,"CAPTURA:  " +  "Acceso",Toast.LENGTH_LONG).show();}
			  else if (lay2.getVisibility() == 0 && op2.matches("sin datos")){Toast.makeText(this,"CAPTURA:  " +  captura2,Toast.LENGTH_LONG).show();}
			  else if (lay3.getVisibility() == 0 && op3.matches("sin datos")){Toast.makeText(this,"CAPTURA:  " +  captura3,Toast.LENGTH_LONG).show();}
			  else if (lay4.getVisibility() == 0 && op4.matches("sin datos")){Toast.makeText(this,"CAPTURA:  " +  captura4,Toast.LENGTH_LONG).show();}
			  else if (lay5.getVisibility() == 0 && op5.matches("sin datos")){Toast.makeText(this,"CAPTURA:  " +  captura5,Toast.LENGTH_LONG).show();}
			  else if (lay6a.getVisibility() == 0 && op6a.matches("sin datos")){Toast.makeText(this,"CAPTURA:  " +  captura6a,Toast.LENGTH_LONG).show();}
			  else if (lay6b.getVisibility() == 0 && op6b.matches("sin datos")){Toast.makeText(this,"CAPTURA:  " +  captura6b,Toast.LENGTH_LONG).show();}
			  else if (lay6c.getVisibility() == 0 && op6c.matches("sin datos")){Toast.makeText(this,"CAPTURA:  " +  captura6c,Toast.LENGTH_LONG).show();}
			  else if (lay7.getVisibility() == 0 && op7.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura7,Toast.LENGTH_LONG).show();}
			  else if (lay7a.getVisibility() == 0 && op7a.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura7a,Toast.LENGTH_LONG).show();}
			  
			  else if (lay8_1.getVisibility() == 0 && op8_1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura8_1,Toast.LENGTH_LONG).show();}
			  else if (lay9_1.getVisibility() == 0 && op9_1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura9_1,Toast.LENGTH_LONG).show();}
			  else if (lay10_1.getVisibility() == 0 && op10_1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura10_1,Toast.LENGTH_LONG).show();}
			  else if (lay10a_1.getVisibility() == 0 && op10a_1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura10a_1,Toast.LENGTH_LONG).show();}
			  else if (lay10b_1.getVisibility() == 0 && op10b_1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura10b_1,Toast.LENGTH_LONG).show();}
			  else if (lay10c_1.getVisibility() == 0 && op10c_1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura10c_1,Toast.LENGTH_LONG).show();}
			  else if (lay11_1.getVisibility() == 0 && op11_1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura11_1,Toast.LENGTH_LONG).show();}
			  else if (lay12_1.getVisibility() == 0 && op12_1.matches("sin datos") && editPregunta12_1.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura12_1,Toast.LENGTH_LONG).show();}
			  else if (lay13a_1.getVisibility() == 0 && op13a_1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura13a_1,Toast.LENGTH_LONG).show();}
			  else if (lay13b_1.getVisibility() == 0 && op13b_1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura13b_1,Toast.LENGTH_LONG).show();}
			  else if (lay13c_1.getVisibility() == 0 && op13c_1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura13c_1,Toast.LENGTH_LONG).show();}
			  else if (lay14a_1.getVisibility() == 0 && op14a_1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura14a_1,Toast.LENGTH_LONG).show();}
			  else if (lay14b_1.getVisibility() == 0 && op14b_1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura14b_1,Toast.LENGTH_LONG).show();}
			 
			  
			  else if (lay8_2.getVisibility() == 0 && op8_2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura8_2,Toast.LENGTH_LONG).show();}
			  else if (lay9_2.getVisibility() == 0 && op9_2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura9_2,Toast.LENGTH_LONG).show();}
			  else if (lay10_2.getVisibility() == 0 && op10_2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura10_2,Toast.LENGTH_LONG).show();}
			  else if (lay10a_2.getVisibility() == 0 && op10a_2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura10a_2,Toast.LENGTH_LONG).show();}
			  else if (lay10b_2.getVisibility() == 0 && op10b_2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura10b_2,Toast.LENGTH_LONG).show();}
			  else if (lay10c_2.getVisibility() == 0 && op10c_2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura10c_2,Toast.LENGTH_LONG).show();}
			  else if (lay11_2.getVisibility() == 0 && op11_2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura11_2,Toast.LENGTH_LONG).show();}
			  else if (lay12_2.getVisibility() == 0 && op12_2.matches("sin datos") && editPregunta12_2.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura12_2,Toast.LENGTH_LONG).show();}
			  else if (lay13a_2.getVisibility() == 0 && op13a_2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura13a_2,Toast.LENGTH_LONG).show();}
			  else if (lay13b_2.getVisibility() == 0 && op13b_2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura13b_2,Toast.LENGTH_LONG).show();}
			  else if (lay13c_2.getVisibility() == 0 && op13c_2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura13c_2,Toast.LENGTH_LONG).show();}
			  else if (lay14a_2.getVisibility() == 0 && op14a_2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura14a_2,Toast.LENGTH_LONG).show();}
			  else if (lay14b_2.getVisibility() == 0 && op14b_2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura14b_2,Toast.LENGTH_LONG).show();}
			 
			  
			  else if (lay15.getVisibility() == 0 && op15.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura15,Toast.LENGTH_LONG).show();}
			  else if (lay15a.getVisibility() == 0 && op15a.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura15a,Toast.LENGTH_LONG).show();}
			  
			  else if (lay16_1.getVisibility() == 0 && op16_1.matches("sin datos") && editPregunta16_1.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16_1,Toast.LENGTH_LONG).show();}
			  else if (lay17a_1.getVisibility() == 0 && op17a_1.matches("sin datos")&& spinner17a_1.getSelectedItem().toString().equals("Selecciona")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura17a_1,Toast.LENGTH_LONG).show();}
			  else if (lay17b_1.getVisibility() == 0 && op17b_1.matches("sin datos")&& spinner17b_1.getSelectedItem().toString().equals("Selecciona")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura17b_1,Toast.LENGTH_LONG).show();}
			  else if (lay17c_1.getVisibility() == 0 && op17c_1.matches("sin datos")&& spinner17c_1.getSelectedItem().toString().equals("Selecciona")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura17c_1,Toast.LENGTH_LONG).show();}
			  else if (lay18_1.getVisibility() == 0 && op18_1.matches("sin datos") && editPregunta18_1.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura18_1,Toast.LENGTH_LONG).show();}
			  else if (lay19_1.getVisibility() == 0 && op19_1.matches("sin datos") && editPregunta19_1.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura19_1,Toast.LENGTH_LONG).show();}
			  else if (lay20_1.getVisibility() == 0 && op20_1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura20_1,Toast.LENGTH_LONG).show();}
			  else if (lay21_1.getVisibility() == 0 && op21_1.matches("sin datos") && editPregunta21_1.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura21_1,Toast.LENGTH_LONG).show();}
			  else if (lay22_1.getVisibility() == 0 && op22_1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura22_1,Toast.LENGTH_LONG).show();}
			  else if (lay22a_1.getVisibility() == 0 && op22a_1.matches("sin datos") && editPregunta22a_1.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura22a_1,Toast.LENGTH_LONG).show();}
			  else if (lay23_1.getVisibility() == 0 && op23_1.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura23_1,Toast.LENGTH_LONG).show();}
			  
			  else if (lay16_2.getVisibility() == 0 && op16_2.matches("sin datos") && editPregunta16_2.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura16_2,Toast.LENGTH_LONG).show();}
			  else if (lay17a_2.getVisibility() == 0 && op17a_2.matches("sin datos")&& spinner17a_2.getSelectedItem().toString().equals("Selecciona")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura17a_2,Toast.LENGTH_LONG).show();}
			  else if (lay17b_2.getVisibility() == 0 && op17b_2.matches("sin datos")&& spinner17b_2.getSelectedItem().toString().equals("Selecciona")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura17b_2,Toast.LENGTH_LONG).show();}
			  else if (lay17c_2.getVisibility() == 0 && op17c_2.matches("sin datos")&& spinner17c_2.getSelectedItem().toString().equals("Selecciona")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura17c_2,Toast.LENGTH_LONG).show();}
			  else if (lay18_2.getVisibility() == 0 && op18_2.matches("sin datos") && editPregunta18_2.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura18_2,Toast.LENGTH_LONG).show();}
			  else if (lay19_2.getVisibility() == 0 && op19_2.matches("sin datos") && editPregunta19_2.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura19_2,Toast.LENGTH_LONG).show();}
			  else if (lay20_2.getVisibility() == 0 && op20_2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura20_2,Toast.LENGTH_LONG).show();}
			  else if (lay21_2.getVisibility() == 0 && op21_2.matches("sin datos") && editPregunta21_2.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura21_2,Toast.LENGTH_LONG).show();}
			  else if (lay22_2.getVisibility() == 0 && op22_2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura22_2,Toast.LENGTH_LONG).show();}
			  else if (lay22a_2.getVisibility() == 0 && op22a_2.matches("sin datos") && editPregunta22a_2.getText().toString().trim().length() == 0 ){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura22a_2,Toast.LENGTH_LONG).show();}
			  else if (lay23_2.getVisibility() == 0 && op23_2.matches("sin datos")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura23_2,Toast.LENGTH_LONG).show();}
			 

			else if (layEdad.getVisibility() == 0 && opEdad.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaEdad, Toast.LENGTH_LONG).show();} 
			else if (layAporta.getVisibility() == 0 && opAporta.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaAporta, Toast.LENGTH_LONG).show();} 
			else if (layOcupacion.getVisibility() == 0 && opOcupacion.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaOcupacion, Toast.LENGTH_LONG).show();} 
			else if (layTrabajaron.getVisibility() == 0 && opTrabajaron.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaTrabajaron, Toast.LENGTH_LONG).show();} 
			else if (layCoche.getVisibility() == 0 && opCoche.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaCoche, Toast.LENGTH_LONG).show();} 
			else if (layCuantosCoches.getVisibility() == 0 && opCuantosCoches.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaCuantosCoches, Toast.LENGTH_LONG).show();} 
			else if (layCuartos.getVisibility() == 0 && opCuartos.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaCuartos, Toast.LENGTH_LONG).show();} 
			else if (layCuartosDormir.getVisibility() == 0 && opCuartosDormir.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaCuartosDormir, Toast.LENGTH_LONG).show();} 
			else if (layFocos.getVisibility() == 0 && opFocos.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaFocos, Toast.LENGTH_LONG).show();}
			else if (layBanos.getVisibility() == 0 && opBanos.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaBanos, Toast.LENGTH_LONG).show();} 
			else if (layRegadera.getVisibility() == 0 && opRegadera.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaBanos, Toast.LENGTH_LONG).show();} 
			else if (layInternet.getVisibility() == 0 && opInternet.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaInternet, Toast.LENGTH_LONG).show();} 
			else if (layEstufa.getVisibility() == 0 && opEstufa.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaEstufa, Toast.LENGTH_LONG).show();} 
			else if (layTipoPiso.getVisibility() == 0 && opTipoPiso.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaTipoPiso, Toast.LENGTH_LONG).show();}
			else if (layTipoVivienda.getVisibility() == 0 && opTipoVivienda.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaTipoVivienda, Toast.LENGTH_LONG).show();} 
			else if (layGenero.getVisibility() == 0 && opGenero.matches("sin datos")) {Toast.makeText(getBaseContext(), "CAPTURA:  " + capturaGenero, Toast.LENGTH_LONG).show();} 
			
			 else if (lay90a.getVisibility()==0 && editPregunta90a.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90a,Toast.LENGTH_LONG).show();}
			  else if (lay90c.getVisibility() == 0 && editPregunta90b.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90c,Toast.LENGTH_LONG).show();}
			  else if (lay90b.getVisibility() == 0 && editPregunta90c.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90b,Toast.LENGTH_LONG).show();}
			  else if (lay90d.getVisibility() == 0 && editPregunta90d.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90d,Toast.LENGTH_LONG).show();}
			  else if (lay90e.getVisibility() == 0 && editPregunta90e.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90e,Toast.LENGTH_LONG).show();}
			  else if (lay90f.getVisibility() == 0 && editPregunta90f.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90f,Toast.LENGTH_LONG).show();}
			  else if (lay90g.getVisibility() == 0 && editPregunta90g.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90g,Toast.LENGTH_LONG).show();}
			  else if (lay90h.getVisibility() == 0 && editPregunta90h.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90h,Toast.LENGTH_LONG).show();}
			  else if (lay90i.getVisibility() == 0 && spinner90i.getSelectedItem().toString().equals("Selecciona")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90i,Toast.LENGTH_LONG).show();}
			  else if (lay90j.getVisibility() == 0 && editPregunta90j.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90j,Toast.LENGTH_LONG).show();}

			else {

				// para valor por default
				if (opAbandono.matches("sin datos")) {
					opAbandono = "1";
				}

				
				
				valores();
				btnGuardar.setEnabled(false);
				dialogoFoto();
				
				

			}// Finaliza else de validación
			  
			break;

		case 2:
		
			 if (lay2.getVisibility() == 0 && op2.matches("sin datos")){Toast.makeText(this,"CAPTURA:  " +  captura2,Toast.LENGTH_LONG).show();}
			 else if (lay90a.getVisibility()==0 && editPregunta90a.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90a,Toast.LENGTH_LONG).show();}
			  else if (lay90c.getVisibility() == 0 && editPregunta90b.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90c,Toast.LENGTH_LONG).show();}
			  else if (lay90b.getVisibility() == 0 && editPregunta90c.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90b,Toast.LENGTH_LONG).show();}
			  else if (lay90d.getVisibility() == 0 && editPregunta90d.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90d,Toast.LENGTH_LONG).show();}
			  else if (lay90e.getVisibility() == 0 && editPregunta90e.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90e,Toast.LENGTH_LONG).show();}
			  else if (lay90f.getVisibility() == 0 && editPregunta90f.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90f,Toast.LENGTH_LONG).show();}
			  else if (lay90g.getVisibility() == 0 && editPregunta90g.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90g,Toast.LENGTH_LONG).show();}
			  else if (lay90h.getVisibility() == 0 && editPregunta90h.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90h,Toast.LENGTH_LONG).show();}
			  else if (lay90i.getVisibility() == 0 && spinner90i.getSelectedItem().toString().equals("Selecciona")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90i,Toast.LENGTH_LONG).show();}
			  else if (lay90j.getVisibility() == 0 && editPregunta90j.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90j,Toast.LENGTH_LONG).show();}
			  else {
				  
				valores();
				btnGuardar.setEnabled(false);
				dialogoFoto();
			  }

			break;

		case 3:


			 if (lay2.getVisibility() == 0 && op2.matches("sin datos")){Toast.makeText(this,"CAPTURA:  " +  captura2,Toast.LENGTH_LONG).show();}
			 else if (lay90a.getVisibility()==0 && editPregunta90a.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90a,Toast.LENGTH_LONG).show();}
			  else if (lay90c.getVisibility() == 0 && editPregunta90b.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90c,Toast.LENGTH_LONG).show();}
			  else if (lay90b.getVisibility() == 0 && editPregunta90c.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90b,Toast.LENGTH_LONG).show();}
			  else if (lay90d.getVisibility() == 0 && editPregunta90d.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90d,Toast.LENGTH_LONG).show();}
			  else if (lay90e.getVisibility() == 0 && editPregunta90e.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90e,Toast.LENGTH_LONG).show();}
			  else if (lay90f.getVisibility() == 0 && editPregunta90f.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90f,Toast.LENGTH_LONG).show();}
			  else if (lay90g.getVisibility() == 0 && editPregunta90g.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90g,Toast.LENGTH_LONG).show();}
			  else if (lay90h.getVisibility() == 0 && editPregunta90h.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90h,Toast.LENGTH_LONG).show();}
			  else if (lay90i.getVisibility() == 0 && spinner90i.getSelectedItem().toString().equals("Selecciona")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90i,Toast.LENGTH_LONG).show();}
			  else if (lay90j.getVisibility() == 0 && editPregunta90j.getText().toString().trim().equals("")){Toast.makeText(getBaseContext(),"CAPTURA:  " +  captura90j,Toast.LENGTH_LONG).show();}
			  
	
			  else{  
				valores();
				btnGuardar.setEnabled(false);
				dialogoFoto();
			  }

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

	

	public void CargaSpinnerEscala() {
		String var = "Selecciona";
		if (var == null) {
			var = "";
		}
		final String[] datos = new String[] { "" + var + "", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"No sabe / No contestó" };
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.multiline_spinner_dropdown_item,
				datos);
		adaptador.setDropDownViewResource(R.layout.multiline_spinner_dropdown_item);
		spinnerCalifica.setAdapter(adaptador);
		spinnerCalifica.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
	
	
	
	public void CargaSpinner17a_1() {
		String var = "Selecciona";
		if (var == null) {
			var = "";
		}
		final String[] datos = new String[] { "" + var + "", 
				"1",
				"2",
				"3",
				"4",
				"5",
				"6",
				"7",
				"8",
				"9",
				"10",
				"11",
				"12",
				"13",
				"14",
				"15",
				"16",
				"17",
				"18",
				"19",
				"20",
				"21",
				"22",
				"23",
				"24",
				"25",
				"26",
				"27",
				"28",
				"29",
				"30",
				"31"
				};
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.multiline_spinner_dropdown_item,
				datos);
		adaptador.setDropDownViewResource(R.layout.multiline_spinner_dropdown_item);
		spinner17a_1.setAdapter(adaptador);
		spinner17a_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
				rdPregunta17a_1.clearCheck();
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
	
	public void CargaSpinner17b_1() {
		String var = "Selecciona";
		if (var == null) {
			var = "";
		}
		final String[] datos = new String[] { "" + var + "", 
				"Enero",
				"Febrero",
				"Marzo",
				"Abril",
				"Mayo",
				"Junio",
				"Julio",
				"Agosto",
				"Septiembre",
				"Octubre",
				"Noviembre",
				"Diciembre"
				};
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.multiline_spinner_dropdown_item,
				datos);
		adaptador.setDropDownViewResource(R.layout.multiline_spinner_dropdown_item);
		spinner17b_1.setAdapter(adaptador);
		spinner17b_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
				rdPregunta17b_1.clearCheck();
				
				spinner17c_1.setSelection(0);
				
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
	
	public void CargaSpinner17c_1() {
		String var = "Selecciona";
		if (var == null) {
			var = "";
		}
		final String[] datos = new String[] { "" + var + "", 
				"2004",
				"2005",
				"2006",
				"2007",
				"2008",
				"2009",
				"2010",
				"2011",
				"2012",
				"2013",
				"2014",
				"2015",
				"2016",
				"2017",
				"2018",
				"2019",
				"2020"
				};
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.multiline_spinner_dropdown_item,
				datos);
		adaptador.setDropDownViewResource(R.layout.multiline_spinner_dropdown_item);
		spinner17c_1.setAdapter(adaptador);
		spinner17c_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@SuppressLint("NewApi")
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
				rdPregunta17c_1.clearCheck();
				
				
				final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
				java.util.Date hoy = new Date(); //Fecha de hoy 
				
				String elAno;
				if(spinner17c_1.getSelectedItem().toString().equals("Selecciona")){
					elAno="2020";
				}else{
					elAno=spinner17c_1.getSelectedItem().toString();
				}
				String elMes=spinner17b_1.getSelectedItem().toString();
				String elDia;
				
				if(spinner17a_1.getSelectedItem().toString().equals("Selecciona")){
					elDia="1";
				}else{
					elDia=spinner17a_1.getSelectedItem().toString();
				}
				
				int el_mes = 0;

				if(elMes=="Enero"){el_mes=1;}
				else if (elMes=="Febrero"){el_mes=2;}
				else if (elMes=="Marzo"){el_mes=3;}
				else if (elMes=="Abril"){el_mes=4;}
				else if (elMes=="Mayo"){el_mes=5;}
				else if (elMes=="Junio"){el_mes=6;}
				else if (elMes=="Julio"){el_mes=7;}
				else if (elMes=="Agosto"){el_mes=8;}
				else if (elMes=="Septiembre"){el_mes=9;}
				else if (elMes=="Octubre"){el_mes=10;}
				else if (elMes=="Noviembre"){el_mes=11;}
				else if (elMes=="Diciembre"){el_mes=12;}
				
				
				int año = Integer.parseInt(elAno); 
				int mes = el_mes; 
				int dia = Integer.parseInt(elDia); //Fecha anterior 
				GregorianCalendar calendar = new GregorianCalendar(año, mes-1, dia); 
				java.sql.Date fecha = new java.sql.Date(calendar.getTimeInMillis());

				long diferencia = ( hoy.getTime() - fecha.getTime() )/MILLSECS_PER_DAY; 
				
				long calculo_edad=(diferencia/365);
			
				String Edad=String.valueOf(calculo_edad);
				
				System.out.println("Diff Años: "+diferencia/365); 
				System.out.println("Diff Dias: "+(diferencia%365)); 
				
				editPregunta18_1.setText(Edad);
				editPregunta18_1.setEnabled(false);
				
				
				
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
	

	
	public void CargaSpinner17a_2() {
		String var = "Selecciona";
		if (var == null) {
			var = "";
		}
		final String[] datos = new String[] { "" + var + "", 
				"1",
				"2",
				"3",
				"4",
				"5",
				"6",
				"7",
				"8",
				"9",
				"10",
				"11",
				"12",
				"13",
				"14",
				"15",
				"16",
				"17",
				"18",
				"19",
				"20",
				"21",
				"22",
				"23",
				"24",
				"25",
				"26",
				"27",
				"28",
				"29",
				"30",
				"31"
				};
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.multiline_spinner_dropdown_item,
				datos);
		adaptador.setDropDownViewResource(R.layout.multiline_spinner_dropdown_item);
		spinner17a_2.setAdapter(adaptador);
		spinner17a_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
				rdPregunta17a_2.clearCheck();
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
	
	public void CargaSpinner17b_2() {
		String var = "Selecciona";
		if (var == null) {
			var = "";
		}
		final String[] datos = new String[] { "" + var + "", 
				"Enero",
				"Febrero",
				"Marzo",
				"Abril",
				"Mayo",
				"Junio",
				"Julio",
				"Agosto",
				"Septiembre",
				"Octubre",
				"Noviembre",
				"Diciembre"
				};
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.multiline_spinner_dropdown_item,
				datos);
		adaptador.setDropDownViewResource(R.layout.multiline_spinner_dropdown_item);
		spinner17b_2.setAdapter(adaptador);
		spinner17b_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
				rdPregunta17b_2.clearCheck();
				
				spinner17c_2.setSelection(0);
				
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
	
	public void CargaSpinner17c_2() {
		String var = "Selecciona";
		if (var == null) {
			var = "";
		}
		final String[] datos = new String[] { "" + var + "", 
				"2004",
				"2005",
				"2006",
				"2007",
				"2008",
				"2009",
				"2010",
				"2011",
				"2012",
				"2013",
				"2014",
				"2015",
				"2016",
				"2017",
				"2018",
				"2019",
				"2020"
				};
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.multiline_spinner_dropdown_item,
				datos);
		adaptador.setDropDownViewResource(R.layout.multiline_spinner_dropdown_item);
		spinner17c_2.setAdapter(adaptador);
		spinner17c_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@SuppressLint("NewApi")
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
				rdPregunta17c_2.clearCheck();
				
				
				final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
				java.util.Date hoy = new Date(); //Fecha de hoy 
				
				String elAno;
				if(spinner17c_2.getSelectedItem().toString().equals("Selecciona")){
					elAno="2020";
				}else{
					elAno=spinner17c_2.getSelectedItem().toString();
				}
				String elMes=spinner17b_2.getSelectedItem().toString();
				String elDia;
				
				if(spinner17a_2.getSelectedItem().toString().equals("Selecciona")){
					elDia="1";
				}else{
					elDia=spinner17a_2.getSelectedItem().toString();
				}
				
				int el_mes = 0;

				if(elMes=="Enero"){el_mes=1;}
				else if (elMes=="Febrero"){el_mes=2;}
				else if (elMes=="Marzo"){el_mes=3;}
				else if (elMes=="Abril"){el_mes=4;}
				else if (elMes=="Mayo"){el_mes=5;}
				else if (elMes=="Junio"){el_mes=6;}
				else if (elMes=="Julio"){el_mes=7;}
				else if (elMes=="Agosto"){el_mes=8;}
				else if (elMes=="Septiembre"){el_mes=9;}
				else if (elMes=="Octubre"){el_mes=10;}
				else if (elMes=="Noviembre"){el_mes=11;}
				else if (elMes=="Diciembre"){el_mes=12;}
				
				
				int año = Integer.parseInt(elAno); 
				int mes = el_mes; 
				int dia = Integer.parseInt(elDia); //Fecha anterior 
				GregorianCalendar calendar = new GregorianCalendar(año, mes-1, dia); 
				java.sql.Date fecha = new java.sql.Date(calendar.getTimeInMillis());

				long diferencia = ( hoy.getTime() - fecha.getTime() )/MILLSECS_PER_DAY; 
				
				long calculo_edad=(diferencia/365);
			
				String Edad=String.valueOf(calculo_edad);
				
				System.out.println("Diff Años: "+diferencia/365); 
				System.out.println("Diff Dias: "+(diferencia%365)); 
				
				editPregunta18_2.setText(Edad);
				editPregunta18_2.setEnabled(false);
				
				
				
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
	

	

	/////////////// SPINNER /////////////////
	public void CargaSpinnerAlcaldia() {
		String var = "Selecciona";
		if (var == null) {
			var = "";
		}
		final String[] datos = new String[] { "" + var + "", "ÁLVARO OBREGÓN", "AZCAPOTZALCO", "BENITO JUÁREZ",
				"COYOACÁN", "CUAJIMALPA DE MORELOS", "CUAUHTÉMOC", "GUSTAVO A. MADERO", "IZTACALCO", "IZTAPALAPA",
				"LA MAGDALENA CONTRERAS", "MIGUEL HIDALGO", "MILPA ALTA", "TLÁHUAC", "TLALPAN", "VENUSTIANO CARRANZA",
				"XOCHIMILCO", "No sabe / No contestó" };
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerDelegaciones.setAdapter(adaptador);
		spinnerDelegaciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
	
	
	public void CargaSpinner90i() {
		String var = "Selecciona";
		if (var == null) {
			var = "";
		}
		final String[] datos = new String[] { "" + var + "", "ÁLVARO OBREGÓN",
				"CUAJIMALPA DE MORELOS", "LA MAGDALENA CONTRERAS",  "MILPA ALTA", "TLÁHUAC", "TLALPAN", "XOCHIMILCO" };
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner90i.setAdapter(adaptador);
		spinner90i.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}

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
