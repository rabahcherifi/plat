package com.example.rabah.listeview;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class DeailPlatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deail_plat);
        final Plat plat = (Plat) getIntent().getSerializableExtra("plat");
        TextView prix = (TextView) findViewById(R.id.textView);
        TextView nom = (TextView) findViewById(R.id.textView3);
        TextView des = (TextView) findViewById(R.id.textView2);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        nom.setText(plat.getNom());
        prix.setText(plat.getPrix());
        des.setText(plat.getDes());
        image.setImageResource(R.drawable.a);


        Button b = (Button) findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String s = "{commande:[nom:" + plat.getNom() + ",prix:" + plat.getPrix() + "]}";
        String url1 = "http://www.example.com/api.php?cmd=" + s;


        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            new DownloadWebpageTask().execute(url1);
            Intent inte = new Intent(DeailPlatActivity.this, MainActivity.class);
            startActivity(inte);
            Toast.makeText(DeailPlatActivity.this , s+"", Toast.LENGTH_LONG).show();


    }
}
        });



}
    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {


            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
    }
    private String downloadUrl(String myurl) throws IOException {
        String all = "";
        InputStream is = null;


        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000 );
            conn.setRequestMethod("POST");
            conn.setDoInput(true);

            conn.connect();
            int response = conn.getResponseCode();
            is = conn.getInputStream();


            BufferedReader r = new BufferedReader(new InputStreamReader(is));
            StringBuilder total = new StringBuilder();

            String line;
            while ((line = r.readLine()) != null) {
                all += line;
            }



        } catch (IOException e) {
        } finally {
            if (is != null) {
                is.close();
            }
            return all;
        }
    }
}
