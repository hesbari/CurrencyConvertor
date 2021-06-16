package com.example.currencyconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText cad_input, usd_input; // two parameters I am going to use
    TextView message;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cad_input = findViewById(R.id.cad_input);
        usd_input = findViewById(R.id.usd_input);
        message = findViewById(R.id.message_out);



    }

    public void convert(View view){

        Log.d("ButtonPress", "convert: This is called!");


        if (!cad_input.getText().toString().isEmpty() && usd_input.getText().toString().isEmpty())
        {
            // 1) get the text in cad
            double  usd = Double.parseDouble(cad_input.getText().toString()) * 0.82;
            usd_input.setText(String.valueOf(usd));
            // cad to used
            message.setText(" ");

        }
        else if (cad_input.getText().toString().isEmpty() && !usd_input.getText().toString().isEmpty())
        {
            // convert used to cad!
            double  cad = Double.parseDouble(usd_input.getText().toString()) * 1.22;
            cad_input.setText(String.valueOf(cad));
            message.setText(" ");
        }
        else if (cad_input.getText().toString().isEmpty() && usd_input.getText().toString().isEmpty())
        {
            // showing a message to the user it has many forms
            // textValue
            Toast toast = Toast.makeText(getApplicationContext(),"You have to have an input",Toast.LENGTH_LONG);
            toast.show();

            message.setText(" ");
            message.setText("you have to have an input!");

        }
        else{
            message.setText(" ");
            // both of them has values...
            message.setText("one of the fields has to be empty");
            Toast toast = Toast.makeText(getApplicationContext(),"one of the field is empty",Toast.LENGTH_LONG);
            toast.show();

        }



    }
}