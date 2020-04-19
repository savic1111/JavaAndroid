package l.com.example.academy;

import android.content.Intent;
import android.graphics.Color;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;


public class Second extends AppCompatActivity  {

    private EditText edit;
    private TextView txt,textOut;

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000 ;
    private String[] mons = {"February", "January", "December"};
     Button add,Clear,Read,Schedule;
     EditText name , Email;
     GridView gv;
     ImageButton voice;
     TextView text;

MainActivity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);


        edit = findViewById(R.id.editText);
        txt = findViewById(R.id.textView2);
        textOut = findViewById(R.id.textOut);
add = findViewById(R.id.add);








Schedule = (Button)findViewById(R.id.schedule);

        Schedule.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent;
                        intent = new Intent(Second.this,Main2.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

                    }
                }
        );


        ArrayAdapter<String> Arraymonths = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mons);

        Arraymonths.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.months);

        spinner.setAdapter(Arraymonths);

         spinner.setPrompt("Месяцы");
        spinner.setSelection(2);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.MAGENTA);
                ((TextView) parent.getChildAt(0)).setTextSize(12);
                switch (position) {
                    case 0:
                        Toast.makeText(getBaseContext(),parent.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();

                        break;
                    case 1:

                        Intent intent;
                        intent = new Intent(Second.this, MainActivity.class);
                        startActivity(intent);
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        voice = findViewById(R.id.voice);
        text = findViewById(R.id.text);

        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              speak();

            }
        });
    }

    private void speak()
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hi speak something");



        try{

startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT);
            if (text.getText().toString().equals("Ольга"))
            {
                textOut.setText("Вы отстой ");
            }

        }catch (Exception e)
        {
            Toast.makeText(this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        switch(requestCode){
            case REQUEST_CODE_SPEECH_INPUT:{
                if(resultCode == RESULT_OK && null != data)
                {

                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

text.setText(result.get(0));
                }
                break;
            }

        }
    }

    public void read(View view) {
        try {
            FileInputStream fileInput = openFileInput("example.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader buffer = new BufferedReader(reader);
            StringBuffer str = new StringBuffer();
            String lines ;
            while((lines = buffer.readLine())!=null){
str.append(lines+"\r");

            }
            txt.setText(str.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(View view)
    {
        try {
            String mytxt = edit.getText().toString();
            FileOutputStream fileOutput = openFileOutput("example.txt", MODE_PRIVATE);
            fileOutput.write(mytxt.getBytes());
            fileOutput.close();
            edit.setText("");
            Toast.makeText(Second.this,"Текст сохране" , Toast.LENGTH_SHORT).show();
        }catch (FileNotFoundException e)
        {
            e.printStackTrace();

        }catch (IOException e)
        {
            e.printStackTrace();
        }




    }
    public void READ(View view) {
        Intent intent;
        intent = new Intent(Second.this,table.class);
        startActivity(intent);
    }
    public void ADD(View view) {
        Intent intent;
        intent = new Intent(Second.this,table.class);
        startActivity(intent);
    }

    public void DATA(View view) {
        Intent intent;
        intent = new Intent(Second.this, mm.class);
        startActivity(intent);
    }

    public void DATA1(View view) {
        Intent intent;
        intent = new Intent(Second.this,Web.class);
        startActivity(intent);
    }

}
