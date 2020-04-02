package com.example.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,
    buttonC,buttonAddition, buttonEgal, buttonMultiplication, buttonSoustraction, buttonDivision, buttonVirgule, buttonModulo, buttonEffacer;

    private TextView resultat;
    private EditText entreeClavier;

    //on définit valeur1 sur la valeur spéciale Not a Number
    private double valeur1 = Double.NaN;
    private double valeur2;

    private static final char ADDITION = '+';
    private static final char SOUSTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char MODULO = '%';

    private char CURRENT_ACTION;

    final DecimalFormat decimalFormat = new DecimalFormat("#.##########");

    @Override
    protected void onCreate(Bundle savedInstanceSave){
        super.onCreate(savedInstanceSave);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonVirgule = (Button) findViewById(R.id.buttonVirgule);
        buttonAddition = (Button) findViewById(R.id.buttonAddition);
        buttonSoustraction = (Button) findViewById(R.id.buttonSoustraction);
        buttonDivision = (Button) findViewById(R.id.buttonDivision);
        buttonMultiplication = (Button) findViewById(R.id.buttonMultiplication);
        buttonModulo = (Button) findViewById(R.id.buttonModulo);
        buttonEgal = (Button) findViewById(R.id.buttonEgal);
        buttonEffacer = (Button) findViewById(R.id.buttonEffacer);
        entreeClavier = (EditText) findViewById(R.id.editText);
        resultat = (TextView) findViewById(R.id.textView);



        //Si on clique sur le bouton 1, EditText(ecran) l'affiche. Même logique pour tous les chiffres.
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entreeClavier.setText(entreeClavier.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entreeClavier.setText(entreeClavier.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entreeClavier.setText(entreeClavier.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entreeClavier.setText(entreeClavier.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entreeClavier.setText(entreeClavier.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entreeClavier.setText(entreeClavier.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entreeClavier.setText(entreeClavier.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entreeClavier.setText(entreeClavier.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entreeClavier.setText(entreeClavier.getText() + "9");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entreeClavier.setText(entreeClavier.getText() + "0");
            }
        });
        // Pour chaque opérateur, on appelle la fonction calcul() et on définit l'action courante en fonction de l'opérateur séléctionné.
        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcul();
                CURRENT_ACTION = ADDITION;
                resultat.setText(decimalFormat.format(valeur1) + "+");
                entreeClavier.setText(null);
            }
        });
        buttonSoustraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcul();
                CURRENT_ACTION = SOUSTRACTION;
                resultat.setText(decimalFormat.format(valeur1) + "-");
                entreeClavier.setText(null);
            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcul();
                CURRENT_ACTION = DIVISION;
                resultat.setText(decimalFormat.format(valeur1) + "/");
                entreeClavier.setText(null);
            }
        });
        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcul();
                CURRENT_ACTION = MULTIPLICATION;
                resultat.setText(decimalFormat.format(valeur1) + "*");
                entreeClavier.setText(null);
            }
        });
        buttonModulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcul();
                CURRENT_ACTION = MODULO;
                resultat.setText(decimalFormat.format(valeur1) + "%");
                entreeClavier.setText(null);

            }
        });
        //Pour l'opérateur '=', on efface le contenu des variables valeur1 et Current_Action et on termine d'écrire le calcul dans la partie résultat de l'écran
        buttonEgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcul();
                resultat.setText(resultat.getText().toString() +
                        decimalFormat.format(valeur2) + " = " + decimalFormat.format(valeur1));
                valeur1 = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });
        buttonVirgule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entreeClavier.setText(entreeClavier.getText() + ".");
            }
        });
        buttonEffacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    effacer();
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entreeClavier.setText("");
                resultat.setText("");
                valeur1 = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });
    }

                                                //Permet de calculer val1 avec val2 en fonction de l'opération demandée
    private void calcul() {
        if(!Double.isNaN(valeur1)) {            //si valeur 1 est un nombre valide, lire valeur 2 et faire le calcul
            valeur2 = Double.parseDouble(entreeClavier.getText().toString());
            entreeClavier.setText(null);

            if(CURRENT_ACTION == ADDITION)
                valeur1 = this.valeur1 + valeur2;
            else if(CURRENT_ACTION == SOUSTRACTION)
                valeur1 = this.valeur1 - valeur2;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valeur1 = this.valeur1 * valeur2;
            else if(CURRENT_ACTION == DIVISION)
                valeur1 = this.valeur1 / valeur2;
            else if(CURRENT_ACTION == MODULO){
                valeur1 = (int) (this.valeur1 % valeur2);
                if(valeur1<0 && valeur2>0){
                    valeur1 += valeur2;
                }
            }
        }
        else {                                  //sinon on attribue l'entrée clavier à valeur 1
            try {
                valeur1 = Double.parseDouble(entreeClavier.getText().toString());
            }
            catch (Exception e){}
        }
    }

    private void effacer(){                                                 //On converti l'entrée clavier en String
        String remplacement = String.valueOf(entreeClavier.getText());
        if (!remplacement.equals("")){                                      //Si la string n'est pas vide, on retire le dernier caractère
            entreeClavier.setText(remplacement.substring(0, remplacement.length()-1));
        }
    }
}
