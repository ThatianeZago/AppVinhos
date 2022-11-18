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

public class Brancos extends AppCompatActivity {
    //DECLARAR O ARRAY COM AS MARCAS DOS CARROS E OUTRO COM IMAGENS
    private String[] regiao = new String[]{"Alentejo","Douro"};
    private String[] douroBranco = new String[]{"Vinho Branco Douro Antonia Adelaide Ferreira 2016", "Vinho Branco Douro Assobio", "Vinho Branco Douro Qta. Vale D. Maria Vinha Martim 2019 "};
    private int[] imgDouroB = {R.drawable.vinhobrancodouro1, R.drawable.vinhobrancodouro2, R.drawable.vinhobrancodouro3};
    private String[] alentejoBranco = new String[]{"Quinta do Paral Reserva 2019","Vinho Branco Aldeia Cima Garrafeira","Vinho Branco Marias Da Malhadinha Vinha Velhas 2020 "};
    private int[] imgAlentejoB = {R.drawable.vinhobrancoalentejo1, R.drawable.vinhobrancoalentejo2, R.drawable.vinhobrancoalentejo3};
    private String[] precoBAlentejo = new String[] {"25.00€","81,95€","65,00€"};
    private String[] precoBDouro = new String[]{"34,95€","5,79€","59,95€"};
    private String[] descBAlentejo = new String[]{"Vinho Branco/ Alentejo","2019 - Vinho Branco/ Alentejo","Vinho Branco/ Alentejo"};
    private String[] descBDouro = new String[]{"Vinho Branco/ Douro","Vinho Branco/ Douro","Vinho Branco/ Douro"};

    //CRIAR VARIÁVEIS DO TIPO DE ELEMENTOS EXISTENTES NO XML
    private ImageView img1, img2,img3;
    private TextView pre1,pre2,pre3;
    private TextView name,name2,name3;
    private TextView desc, desc1, desc2;
    private Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brancos);

        //ASSOCIAR VARIAVÉIS JAVA COM OS RESPECTIVOS ELEMENTOS XML
        //SPINNER
        sp1 = findViewById(R.id.spinner);
        //IMAGEM DOS VINHOS
        img1 = findViewById(R.id.imageView);
        img2 = findViewById(R.id.imageView4);
        img3 = findViewById(R.id.imageView5);
        //PREÇO
        pre1 = findViewById(R.id.textView15);
        pre2 = findViewById(R.id.textView18);
        pre3 = findViewById(R.id.textView19);
        //NOME
        name = findViewById(R.id.textView13);
        name2 = findViewById(R.id.textView16);
        name3 = findViewById(R.id.textView21);
        //DESCRIÇÃO
        desc = findViewById(R.id.textView14);
        desc1 = findViewById(R.id.textView17);
        desc2 = findViewById(R.id.textView20);

        //CONSTRUIR ARRAY ADAPTAR E CARREGAR NO SPINNER
        ArrayAdapter<String> valores = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, regiao);

        //ASSOCIAR O ARRAY AO SPINNER
        sp1.setAdapter(valores);

        //APLICAR O CÓDIGO AO EVENTO DE SELEÇÃO DAS AÇÕES
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    img1.setImageResource(imgAlentejoB[0]);
                    name.setText(alentejoBranco[0]);
                    pre1.setText(precoBAlentejo[0]);
                    desc.setText(descBAlentejo[0]);
                    img2.setImageResource(imgAlentejoB[1]);
                    name2.setText(alentejoBranco[1]);
                    pre2.setText(precoBAlentejo[1]);
                    desc1.setText(descBAlentejo[1]);
                    img3.setImageResource(imgAlentejoB[2]);
                    name3.setText(alentejoBranco[2]);
                    pre3.setText(precoBAlentejo[2]);
                    desc2.setText(descBAlentejo[2]);
                }
                if (i == 1){
                    img1.setImageResource(imgDouroB[0]);
                    name.setText(douroBranco[0]);
                    pre1.setText(precoBDouro[0]);
                    desc.setText(descBDouro[0]);
                    img2.setImageResource(imgDouroB[1]);
                    name2.setText(douroBranco[1]);
                    pre2.setText(precoBDouro[1]);
                    desc1.setText(descBDouro[1]);
                    img3.setImageResource(imgDouroB[2]);
                    name3.setText(douroBranco[2]);
                    pre3.setText(precoBDouro[0]);
                    desc2.setText(descBDouro[2]);
                }
                Toast.makeText(Brancos.this, sp1.getSelectedItem() + "", Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    //INCLUIR O MENU NA ACTIVITY
       @Override
        public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuvinhos,menu);
        menu.removeItem(R.id.brancos);
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
            Intent it = new Intent(Brancos.this,Home.class);
            startActivity(it);
            finish();
        }
        if(id == R.id.brancos){
            Intent it = new Intent(Brancos.this,Tintos.class);
            startActivity(it);
            finish();
        }
        if(id == R.id.espirituosos){
            Intent it = new Intent(Brancos.this,Espirituosos.class);
            startActivity(it);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}