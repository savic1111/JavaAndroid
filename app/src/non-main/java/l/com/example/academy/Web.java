package l.com.example.academy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView browser = findViewById(R.id.webBrowser);
        browser.loadUrl("https://маленькаяакадемия.рф/основное/о-нас");
    }
}
