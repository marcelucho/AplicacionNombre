package com.marcelo;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private static String TAG = "ActivityName";

    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        //Este método establece el diseño (layout) de la actividad a partir
        // del archivo XML content_main.xml. Esto define cómo se verá la
        // interfaz de usuario en esta actividad.


        setContentView(R.layout.content_main);
    }

    // Almacena el texto que ingreso el usuario
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        //Para probar si se esta ejecutando
        Log.i(TAG, "onSaveInstanceState");

        // final es cuando se quiere modificar después
        final EditText editText = (EditText) findViewById(R.id.editText);

        CharSequence texto = editText.getText();
        outState.putCharSequence("savedText", texto);
    }
    //Restaurar el estado anterior
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"onRestoreInstanceState");

        final TextView textView = (TextView) findViewById(R.id.textView);

        CharSequence savedText = savedInstanceState.getCharSequence("savedText");
        textView.setText(savedText);
    }
}
