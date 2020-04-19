package l.com.example.academy;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.MissingFormatArgumentException;

public class MainActivity extends AppCompatActivity {


    private ImageView logotip;
    private EditText Login1,Password1;
    private Button In, Schedule;
    private ImageButton Phone,SMS;
    MainActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        all();





    }




    public void all()
    {

        PackageManager packageManager = getPackageManager();

        boolean telephonySupported = packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY);
        boolean gsmSupported = packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_GSM);
        boolean cdmaSupported = packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_CDMA);

        In = (Button)findViewById(R.id.In);
        logotip = (ImageView)findViewById(R.id.logotip);
        Animation Rise = AnimationUtils.loadAnimation(MainActivity.this,R.anim.rise);
        logotip.startAnimation(Rise);
        Login1 = (EditText)findViewById(R.id.Login);
        Password1 = (EditText)findViewById(R.id.Password);
        Phone = (ImageButton)findViewById(R.id.phone) ;
        Schedule = (Button)findViewById(R.id.schedule);
        Rise.setAnimationListener(new Animation.AnimationListener() {
                                      @Override
                                      public void onAnimationStart(Animation animation) {
                                      }

                                      @Override
                                      public void onAnimationEnd(Animation Rise) {
                                          Animation Text = AnimationUtils.loadAnimation(MainActivity.this, R.anim.text_anim);
                                          Login1.startAnimation(Text);
                                          Password1.startAnimation(Text);
                                      }

                                      @Override
                                      public void onAnimationRepeat(Animation animation) {

                                      }
                                  });



        In.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        if (Login1.getText().toString().equals("Olga") && Password1.getText().toString().equals("23051973a")) {
                            Toast.makeText(getApplicationContext(), "Вход выполнен", Toast.LENGTH_SHORT).show();

                            Intent intent1;


                            Pair[] pairs = new Pair[1];
                            pairs[0] = new Pair<View, String>(logotip,"imageTransition");
                            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                            intent1 = new Intent(MainActivity.this, Second.class);
                            startActivity(intent1,options.toBundle());




                        } else {
                            Toast.makeText(getApplicationContext(), "Вход не выполнен", Toast.LENGTH_SHORT).show();
                        }



                    }
                }
        );

        Phone.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {


                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234567"));
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }

                    }
                }
        );
    }

}
