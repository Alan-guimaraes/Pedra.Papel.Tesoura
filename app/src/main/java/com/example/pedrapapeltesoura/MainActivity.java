package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void selecionadoPedra(View view){
        this.opcaoSelecionada ("Pedra");
    }
    public void selecionadoPapel(View view){
        this.opcaoSelecionada ("Papel");
    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada ("Tesoura");
    }


    public void opcaoSelecionada(String escolhaUsuario){

        ImageView ImageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);



        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes [ numero ];

        switch (escolhaApp){
            case "pedra" :
                ImageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                ImageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                ImageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ){
            textResultado.setText("Você perdeu :( ");

        }else if (
                (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura")
        ){
            textResultado.setText("Você ganhou :) ");

        }else {
            textResultado.setText("Empatamos :0 ");
        }

        System.out.println( "Item clicado " + escolhaApp);


    }
}