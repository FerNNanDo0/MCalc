package com.calc.mcalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.ValidationResult;

public class MainActivity extends AppCompatActivity {

    private static final String pct = "%";
    private static final int porcento  = 100;
    public EditText edt;
    public TextView txt_total;

    String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] opers = {"+", "-", "/", "*", "%"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edt = findViewById(R.id.edit);
        txt_total = findViewById(R.id.text_Result);

        edt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                return true;
            }
        });

    }

    public  void pont( View view ) { edt.append("."); }

    // botoes de operadores
    public void porcent(View v) { edt.append(opers[4]); }
    public void mais(View v) { edt.append(opers[0]); }
    public void menos(View v) { edt.append(opers[1]); }
    public void vezes(View v) { edt.append(opers[3]); }
    public void dividir(View v) { edt.append(opers[2]); }

    public void igual(View v) {
        try {
            String edit = edt.getText().toString();
            String pct = "%";

            //String edit = edt.getText().toString();

/*
            double result = express.evaluate();
            long resultLong = (long) result;

            if (result == (double) resultLong) {
                txt_total.setText(String.valueOf(resultLong));

            }else
                if (result != (double) resultLong){
                    txt_total.setText( String.valueOf(result));
            }else   */
// verifica em qual indice do EditText ta o sinal de % para dar o resultadd
            if ( pct.charAt(0) == edit.charAt(1) ) {

                    String num1 = edit.substring(0, 1);
                    String num2 = edit.substring(2, edt.getText().length());

                    Float nn = Float.parseFloat(num1);
                    Float nnn = Float.parseFloat(num2);

                    Float totall = (nn * nnn) / porcento;
                    System.out.println(" Sim aqui tem um >> "+ num1 +"%"+ num2 +" = "+ String.valueOf(totall) );

                    txt_total.setText( String.valueOf(totall) );

            }else
                if (pct.charAt(0) == edit.charAt(2)) {

                    String num1 = edit.substring(0, 2);
                    String num2 = edit.substring(3, edt.getText().length());

                    Float nn = Float.parseFloat(num1);
                    Float nnn = Float.parseFloat(num2);

                    Float totall = (nn * nnn) / porcento;
                    System.out.println(" Sim aqui tem um >> " + num1 + "%" + num2);

                    txt_total.setText( String.valueOf(totall) );
                }else
                    if ( pct.charAt(0) == edit.charAt(3) ) {

                        String num1 = edit.substring(0, 3);
                        String num2 = edit.substring(4, edt.getText().length());

                        Float nn = Float.parseFloat(num1);
                        Float nnn = Float.parseFloat(num2);

                        Float totall = (nn * nnn) / porcento;
                        System.out.println(" Sim aqui tem um >> "+ num1 +"%"+ num2 +" = "+ totall);

                        txt_total.setText( String.valueOf(totall) );
                    }else {
                        Expression express = new ExpressionBuilder(edit).build();
                        double result = express.evaluate();
                        long resultLong = (long) result;

                        if (result == (double) resultLong) {
                            txt_total.setText(String.valueOf(resultLong));

                        }else{
                            txt_total.setText( String.valueOf(result));
                   }
                }
  //  Demais expressoes da calculadora
        } catch (Exception e) {
        }

    }

    public void apagarTd( View v ){ edt.setText(""); txt_total.setText(""); }

// botao para apagar caracteres da caixa de texto
    public void ddelete(View v) { int len = edt.getText().length();

        if ( len > 0 ){ edt.getText().delete(len -1, len); }    }

 //   botoes dos numeros
    public void zero(View v){ edt.append(numeros[0]); }
    public void um(View v){ edt.append(numeros[1]); }
    public void dois(View v){ edt.append(numeros[2]); }
    public void tres(View v){ edt.append(numeros[3]); }
    public void quatro(View v){ edt.append(numeros[4]); }
    public void cinco(View v){ edt.append(numeros[5]); }
    public void seis(View v){ edt.append(numeros[6]); }
    public void sete(View v){ edt.append(numeros[7]); }
    public void oito(View v){ edt.append(numeros[8]); }
    public void nove(View v){ edt.append(numeros[9]); }




    // fim da classe
}