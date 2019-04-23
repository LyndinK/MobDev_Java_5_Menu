package com.example.task3;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvInfo;
    EditText etInput;
    Button bControl;
    Random randomchik = new Random();
    int random;
    int limit = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = findViewById(R.id.textView);
        etInput = findViewById(R.id.editText);
        bControl = findViewById(R.id.button);
        random = randomchik.nextInt(100-0+1);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.task3_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub


        if(item.getItemId()== R.id.menu_exit) {
            moveTaskToBack(true);
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
        if(item.getItemId()== R.id.menu_new) {
            random = randomchik.nextInt(100-0+1);
        }
        if(item.getItemId()== R.id.menu_lvl1) {
            random = randomchik.nextInt(100-0+1);
            limit = 100;
        }
        if(item.getItemId()== R.id.menu_lvl2) {
            random = randomchik.nextInt(10000000-0+1);
            limit = 10000000;
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View view) {

        if (etInput.getText().length() != 0) {

            int value = Integer.parseInt(etInput.getText().toString());

            if (value >= limit || value == 0) {
                tvInfo.setText(getString(R.string.errorrr));
            }
            else {

                if (value < random) {
                    tvInfo.setText(getString(R.string.niz));
                }
                if (value > random) {
                    tvInfo.setText(getString(R.string.verx));
                }
                if (value == random) {
                    tvInfo.setText(getString(R.string.pobeda));
                }
            }
        }
        else {
            tvInfo.setText(getString(R.string.errorr));
        }


    }
}
