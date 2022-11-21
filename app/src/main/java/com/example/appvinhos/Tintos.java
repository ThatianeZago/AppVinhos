package com.example.appvinhos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Tintos extends AppCompatActivity {

    //DECLARAR O ARRAY COM AS MARCAS DOS CARROS E OUTRO COM IMAGENS
    private String[] regiao = new String[]{"Alentejo","Douro"};
    private String[] douroTinto = new String[]{"Quinta Vale D. Maria Vinha da Francisca 2019 ", "Casa Ferreirinha Quinta da Leda 2018 ", "Vinho Tinto Barca Velha 2008"};
    private int[] imgDouroT = {R.drawable.vinhotdouro1, R.drawable.vinhotdouro2, R.drawable.vinhotdouro3};
    private String[] alentejoTinto = new String[]{"Grande Rocim 2019", "Vinho Tinto Marias Da Malhadinha Vinha Velhas 2019", "Vinho Tinto Pera Manca 2011"};
    private int[] imgAlentejoT = {R.drawable.vinhotalentejo1, R.drawable.vinhotalentejo2, R.drawable.vinhotalentejo3};
    private String[] precoAlentejo = new String[] {"64.50€","250,00€","495,00€"};
    private String[] precoDouro = new String[]{"70.00€","44.99€","995,00€"};
    private String[] descAlentejo = new String[]{"Vinho Tinto/ Alentejo","Vinho Tinto/ Alentejo","Vinho Tinto/ Alentejo"};
    private String[] descDouro = new String[]{"Vinho Tinto/ Douro","Vinho Tinto/ Douro","Vinho Tinto/ Douro"};

    //CRIAR VARIÁVEIS DO TIPO DE ELEMENTOS EXISTENTES NO XML
    private ImageView img1, img2,img3;
    private TextView pre1,pre2,pre3;
    private TextView name,name2,name3;
    private TextView desc, desc1, desc2;
    private Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tintos);

        //ASSOCIAR VARIAVÉIS JAVA COM OS RESPECTIVOS ELEMENTOS XML
        //SPINNER
        sp1 = findViewById(R.id.spinner2);
        //IMAGEM DOS VINHOS
        img1 = findViewById(R.id.imageView3);
        img2 = findViewById(R.id.imageView6);
        img3 = findViewById(R.id.imageView8);
        //PREÇO
        pre1 = findViewById(R.id.textView6);
        pre2 = findViewById(R.id.textView9);
        pre3 = findViewById(R.id.textView11);
        //NOME
        name = findViewById(R.id.textView4);
        name2 = findViewById(R.id.textView7);
        name3 = findViewById(R.id.textView12);
        //DESCRIÇÃO
        desc = findViewById(R.id.textView5);
        desc1 = findViewById(R.id.textView8);
        desc2 = findViewById(R.id.textView10);

        //CONSTRUIR ARRAY ADAPTAR E CARREGAR NO SPINNER
        ArrayAdapter<String> valores = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, regiao);

        //ASSOCIAR O ARRAY AO SPINNER
        sp1.setAdapter(valores);

        //APLICAR O CÓDIGO AO EVENTO DE SELEÇÃO DAS AÇÕES
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    img1.setImageResource(imgAlentejoT[0]);
                    name.setText(alentejoTinto[0]);
                    pre1.setText(precoAlentejo[0]);
                    desc.setText(descAlentejo[0]);
                    img2.setImageResource(imgAlentejoT[1]);
                    name2.setText(alentejoTinto[1]);
                    pre2.setText(precoAlentejo[1]);
                    desc1.setText(descAlentejo[1]);
                    img3.setImageResource(imgAlentejoT[2]);
                    name3.setText(alentejoTinto[2]);
                    pre3.setText(precoAlentejo[2]);
                    desc2.setText(descAlentejo[2]);
                }
                if (i == 1){
                    img1.setImageResource(imgDouroT[0]);
                    name.setText(douroTinto[0]);
                    pre1.setText(precoDouro[0]);
                    desc.setText(descDouro[0]);
                    img2.setImageResource(imgDouroT[1]);
                    name2.setText(douroTinto[1]);
                    pre2.setText(precoDouro[1]);
                    desc1.setText(descDouro[1]);
                    img3.setImageResource(imgDouroT[2]);
                    name3.setText(douroTinto[2]);
                    pre3.setText(precoDouro[0]);
                    desc2.setText(descDouro[2]);
                }
                Toast.makeText(Tintos.this, sp1.getSelectedItem() + "", Toast.LENGTH_LONG).show();
            }
            @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    //INCLUIR O MENU NA ACTIVITY
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuvinhos, menu);
        menu.removeItem(R.id.tintos);
        return super.onCreateOptionsMenu(menu);
    }
    //PROGRAMAR CADA BOTÃO DO MENU
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.btnsair){
            finish();
        }

        if(id == R.id.btnhome){
            Intent it = new Intent(Tintos.this,Home.class);
            startActivity(it);
            finish();
        }
        if(id == R.id.brancos){
            Intent it = new Intent(Tintos.this,Brancos.class);
            startActivity(it);
            finish();
        }
        if(id == R.id.espirituosos){
            Intent it = new Intent(Tintos.this,Espirituosos.class);
            startActivity(it);
            finish();
        }
        if(id == R.id.whisky){
            Intent it = new Intent(Tintos.this,Whiskys.class);
            startActivity(it);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}