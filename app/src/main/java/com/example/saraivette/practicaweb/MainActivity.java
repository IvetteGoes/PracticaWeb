package com.example.saraivette.practicaweb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.*;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button ire;
    EditText dime;

    // INI AGREGADO
    private WebView mWebView;
// FIN AGREGADO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INI AGREGADO
        mWebView = (WebView) findViewById(R.id.activity_main_webview);
        ire = (Button) findViewById(R.id.irbtn);
        dime = (EditText)findViewById(R.id.dirtxt);

// Activamos Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
// Url que carga la app (webview)
// Forzamos el webview para que abra los enlaces internos dentro de la la APP
        mWebView.setWebViewClient(new WebViewClient());
// Forzamos el webview para que abra los enlaces externos en el navegador
        mWebView.setWebViewClient(new MyAppWebViewClient());
// FIN AGREGADO

        ire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String ir = dime.getText().toString();
                mWebView.loadUrl(""+ir);

                WebView dime= (WebView) findViewById(R.id.activity_main_webview);
                dime.setWebViewClient(new WebViewClient());
            }
        });
    }





    // INI AGREGADO
    @Override
// Detectar cuando se presiona el botón de retroceso
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
// FIN AGREGADO

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
