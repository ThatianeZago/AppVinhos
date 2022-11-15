package com.example.appvinhos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    //INCLUIR O MENU NA ACTIVITY
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuvinhos,menu);
        menu.removeItem(R.id.btnhome);
        return super.onCreateOptionsMenu(menu);
    }
    //PROGRAMAR CADA BOTÃO DO MENU

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.btnsair){
            finish();
        }
        if(id == R.id.tintos){
            Intent it = new Intent(Home.this,Tintos.class);
            startActivity(it);
            finish();
        }
        if(id == R.id.brancos){
            Intent it = new Intent(Home.this,Brancos.class);
            startActivity(it);
            finish();
        }
        if(id == R.id.espirituosos){
            Intent it = new Intent(Home.this,Espirituosos.class);
            startActivity(it);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}