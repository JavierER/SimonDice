package com.example.javii.simondice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private int pulsaciones = -1;
    private Button[] arrayBotones;
    private int[] Pulsados;
    private int[] Aleatorios;
    private static int random;
    private static int numeroMilis = 0;
    private android.os.Handler handler = new android.os.Handler();
    private android.os.Handler handler1 = new android.os.Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayBotones = new Button[4];
        Pulsados = new int[4];
        pulsaciones=-1;
        Aleatorios = new int[4];
        arrayBotones[0]=(Button) findViewById(R.id.boton1);
        arrayBotones[1]=(Button) findViewById(R.id.boton2);
        arrayBotones[2]=(Button) findViewById(R.id.boton3);
        arrayBotones[3]=(Button) findViewById(R.id.boton4);
        handler = new android.os.Handler();
        handler1 = new android.os.Handler();
    }


    public void cambiarColor(View v) throws InterruptedException {

        numeroMilis=0;

        for (int i = 0; i < 4; i++) {

            random = (int) (Math.random()*4);

            Aleatorios[i]=random;

            numeroMilis+=1000;

            if (random == 4) {

                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        arrayBotones[3].setBackgroundResource(R.color.rojooscuro);

                        handler1.postDelayed(new Runnable(){
                            @Override
                            public void run() {
                                arrayBotones[3].setBackgroundResource(R.color.rojo);
                            }
                        },500);

                    }
                }, numeroMilis);

            }else if(random == 1){

                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        arrayBotones[0].setBackgroundResource(R.color.azuloscuro);

                        handler1.postDelayed(new Runnable(){
                            @Override
                            public void run() {
                                arrayBotones[0].setBackgroundResource(R.color.azul);
                            }
                        },500);

                    }
                }, numeroMilis);

            }else if (random == 2){

                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        arrayBotones[1].setBackgroundResource(R.color.amarillooscuro);

                        handler1.postDelayed(new Runnable(){
                            @Override
                            public void run() {
                                arrayBotones[1].setBackgroundResource(R.color.amarillo);
                            }
                        },500);

                    }
                }, numeroMilis);

            }else{

                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        arrayBotones[2].setBackgroundResource(R.color.verdeoscuro);

                        handler1.postDelayed(new Runnable(){
                            @Override
                            public void run() {
                                arrayBotones[2].setBackgroundResource(R.color.verde);
                            }
                        },500);
                    }
                }, numeroMilis);
            }
        }
    }

    public void pulsarBotones (View view) {

        pulsaciones++;

        if (view.getId() == R.id.boton1) {
            Pulsados[pulsaciones]= 1;
        }else if(view.getId()== R.id.boton2){
            Pulsados[pulsaciones]=2;
        }else if(view.getId()==R.id.boton3){
            Pulsados[pulsaciones]=3;
        }else{
            Pulsados[pulsaciones]=4;
        }

        if(pulsaciones==3){
            checkIt();
            pulsaciones=-1;
        }
    }

    public void checkIt(){
        boolean victoria=false;
        for (int i = 0; i< Aleatorios.length; i++){
            if (Pulsados[i] != Aleatorios[i]){
                victoria=false;
                break;
            }else{
                victoria=true;
            }
        }
        if (victoria){
            System.out.println("WIN");
        }else{
            System.out.println("LOSE");
            System.exit(0);
        }

    }

}