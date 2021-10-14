package com.example.garbagesorting;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ActivityAdd extends AppCompatActivity {
    private EditText et_addgarbage;
    private EditText et_addsorting;
    private Button btn_addlogin;
    private TextView tx_sorting;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        DatabaseHandler db = new DatabaseHandler(this);
        btn_addlogin = findViewById(R.id.btn_addlogin);
        et_addgarbage = (EditText)findViewById(R.id.et_addgarbage);
        et_addsorting = (EditText)findViewById(R.id.et_addsorting);
        tx_sorting = findViewById(R.id.tx_sorting);
        btn_addlogin.setOnClickListener(view -> {
            String val_g =  String.valueOf(et_addgarbage.getText());
            String val_s =  String.valueOf(et_addsorting.getText());
            db.addContact(new Contact(val_g, val_s));
            tx_sorting.setText(val_g+"增加完成");
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
            intent.setClass(ActivityAdd.this,ActivityAdd.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_ser) {
            Intent intent = new Intent();
            intent.setClass(ActivityAdd.this,ActivitySer.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_del) {
            Intent intent = new Intent();
            intent.setClass(ActivityAdd.this,ActivityDel.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_upd) {
            Intent intent = new Intent();
            intent.setClass(ActivityAdd.this,ActivityUpd.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
