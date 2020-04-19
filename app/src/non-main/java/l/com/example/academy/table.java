package l.com.example.academy;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class table extends AppCompatActivity {
    private boolean table_fg = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
    }
    public void onClick(View view){

        SQLiteDatabase db = getBaseContext().openOrCreateDatabase("app.db", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users1 (name TEXT, age INTEGER)");
        db.execSQL("INSERT INTO users1 VALUES ('Tom Smith', 23);");
        db.execSQL("INSERT INTO users1 VALUES ('John Dow', 31);");

        Cursor query = db.rawQuery("SELECT * FROM users1;", null);
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView11 = (TextView) findViewById(R.id.textView11);
        TextView textView111 = (TextView) findViewById(R.id.textView111);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView22 = (TextView) findViewById(R.id.textView22);
        TextView textView222 = (TextView) findViewById(R.id.textView222);
        if(query.moveToFirst()){
            do{
                String name = query.getString(0);
                int age = query.getInt(1);
                textView1.append(name );
                textView11.append(name );
                textView111.append(name );
                textView2.append(name );
                textView22.append(name );
                textView222.append(name );
            }
            while(query.moveToNext());
        }
        query.close();
        db.close();
    }
    public void collapse(View view)
    {
        TableLayout table = findViewById(R.id.table);
        Button switchBtn = findViewById(R.id.switchBtn);

        table.setColumnCollapsed(1,table_fg);
        table.setColumnCollapsed(2,table_fg);


        if(table_fg)
        {
            table_fg = false;
            switchBtn.setText("Показать");
        }else
        {
            table_fg = true;
            switchBtn.setText("Скрыть");
        }
    }
}
