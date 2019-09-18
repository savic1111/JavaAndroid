package l.com.example.academy;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Perehod extends AppCompatActivity {

    Button klass11,klass10,klass9;

    @Override
public void finish()
{
super.finish();
    overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perehod);

        klass11 = (Button)findViewById(R.id.klass11);
        klass10 = (Button)findViewById(R.id.klass10);
        klass9 = (Button)findViewById(R.id.klass9);


        klass11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Perehod.this,raspisanie.class);
                Bundle b = new Bundle();
                b.putString("classID","11");
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        klass10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Perehod.this,raspisanie.class);
                Bundle b = new Bundle();
                b.putString("classID","10");
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        klass9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(Perehod.this,raspisanie.class);
                Bundle b = new Bundle();
                b.putString("classID","9");
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}
