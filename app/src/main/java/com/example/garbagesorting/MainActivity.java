package com.example.garbagesorting;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_login;
    private Button btn_alllogin;
    private EditText et_garbage;
    private TextView tx_sorting;
    private ListView lv_garbage;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);
        db.deleteAll();
        btn_login = findViewById(R.id.btn_login);
        btn_alllogin = findViewById(R.id.btn_alllogin);
        et_garbage = (EditText)findViewById(R.id.et_garbage);
        tx_sorting = findViewById(R.id.tx_sorting);
        lv_garbage = findViewById(R.id.lv_garbage);
        db.addContact(new Contact("suliao", "可回收物"));
        db.addContact(new Contact("guoke", "其他垃圾"));
        db.addContact(new Contact("gutou", "厨余垃圾"));
        db.addContact(new Contact("dengpao", "有害垃圾"));
        btn_login.setOnClickListener(view -> {
            String val_g =  String.valueOf(et_garbage.getText());
            try {
                Contact contacts = db.getContact(val_g);
                tx_sorting.setText("垃圾："+val_g+"\n分类："+contacts.getSorting());
            }
            catch (Exception e){
                tx_sorting.setText("不存在此垃圾");
            }
        });
        btn_alllogin.setOnClickListener(view -> {
            String sorting;
            List<Contact> contacts = db.getAllContacts();
            List<String> cstring = new ArrayList<>();
            int i=0;
            try {
                while (true){
                    cstring.add(contacts.get(i).getGarbage()+"\n"+contacts.get(i).getSorting());
                    i++;
                }
            }
            catch (Exception e){

            }
            ArrayAdapter<String> data = new ArrayAdapter<String>(
                    MainActivity.this, android.R.layout.simple_list_item_1,cstring);
            lv_garbage.setAdapter(data);
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
            intent.setClass(MainActivity.this,ActivityAdd.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_ser) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,MainActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_del) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,ActivityDel.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_upd) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,ActivityUpd.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
