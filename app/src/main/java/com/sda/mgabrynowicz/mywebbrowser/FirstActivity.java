package com.sda.mgabrynowicz.mywebbrowser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class FirstActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        //todo To Do example
        editText.setSelection(8);

        TextView resourceText = (TextView) findViewById(R.id.textView);
        resourceText.setText(getApplicationContext().getString(R.string.myCustomValue) + "\n" + BuildConfig.someName);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("SDA", "click click");
                url = editText.getText().toString();
                if (!url.toLowerCase(Locale.getDefault()).startsWith("http://")) {
                    Toast.makeText(FirstActivity.this, R.string.toastText, Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                    intent.putExtra("url", url);
                    startActivity(intent);
                }
            }
        });


    }
}
