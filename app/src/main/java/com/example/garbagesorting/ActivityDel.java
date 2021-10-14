package com.example.garbagesorting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ActivityDel extends AppCompatActivity {

    private Button btn_dellogin;
    private EditText et_delgarbage;
    private TextView tx_sorting;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del);
        DatabaseHandler db = new DatabaseHandler(this);
        btn_dellogin = findViewById(R.id.btn_dellogin);
        et_delgarbage = (EditText)findViewById(R.id.et_delgarbage);
        tx_sorting = findViewById(R.id.tx_sorting);
        btn_dellogin.setOnClickListener(view -> {
            String val_g =  String.valueOf(et_delgarbage.getText());
            db.deleteContact(val_g);
            tx_sorting.setText(val_g+"删除成功");
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            Intent intent = new Intent();
            intent.setClass(ActivityDel.this,ActivityAdd.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_ser) {
            Intent intent = new Intent();
            intent.setClass(ActivityDel.this,ActivitySer.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_del) {
            Intent intent = new Intent();
            intent.setClass(ActivityDel.this,ActivityDel.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_upd) {
            Intent intent = new Intent();
            intent.setClass(ActivityDel.this,ActivityUpd.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
