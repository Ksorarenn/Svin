package com.example.sms;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    private Integer clicker = 0;
    ProgressBar progressBar;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageView);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("clicker")) {
            clicker = savedInstanceState.getInt("clicker", 0);
        }
        TextView TXT = (TextView)findViewById(R.id.textView2);
        TXT.setText(clicker.toString());
        Log.d("", "onRestoreInstanceState");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("clicker", clicker);
        Log.d("CLICK","Сейвимся");
        Toast.makeText(this, "Сейвимся",Toast.LENGTH_LONG).show();
    }
    @Override
    protected  void onStart(){
        super.onStart();
        Log.d("CLICK", "Поехали");
        Toast.makeText(this, "Поехали", Toast.LENGTH_LONG).show();
    }
    @Override
    protected  void onResume(){
        super.onResume();
        Log.d("CLICK", "Работаем");
        Toast.makeText(this, "Работаем", Toast.LENGTH_LONG).show();
    }
    @Override
    protected  void onPause(){
        super.onPause();
        Log.d("CLICK", "Терпим");
        Toast.makeText(this, "Терпим", Toast.LENGTH_LONG).show();
    }
    @SuppressLint("SetTextI18n")
    public void one_click_button (View view){
        progressBar.incrementProgressBy(10);
        if (progressBar.getProgress() >=200 && progressBar.getProgress() <= 399) {
            imageView.setImageResource(R.drawable.piglet2);
        }
        if (progressBar.getProgress() >= 400) {
            Toast.makeText(MainActivity.this, "Вот это свин..", Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.piglet31);
        }
        clicker++;
        TextView TXT = (TextView)findViewById(R.id.textView2);
        TXT.setText(clicker.toString());
    }
}