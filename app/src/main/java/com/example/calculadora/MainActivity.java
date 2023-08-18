// BOO HAHA :] FIQUE A VONTADE! <3

package com.example.calculadora;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero,numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,numeroSete,numeroOito,numeroNove,ponto,soma,subtracao,multiplicacao,divisao,igual,bt_limpar;
    private TextView txtExpressao,txtResultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // -- INICIANDO BOTÕES ON CLICK --
        IniciarComponentes();

        getSupportActionBar().hide();

            numeroZero.setOnClickListener(this);
            numeroUm.setOnClickListener(this);
            numeroDois.setOnClickListener(this);
            numeroTres.setOnClickListener(this);
            numeroQuatro.setOnClickListener(this);
            numeroCinco.setOnClickListener(this);
            numeroSeis.setOnClickListener(this);
            numeroSete.setOnClickListener(this);
            numeroOito.setOnClickListener(this);
            numeroNove.setOnClickListener(this);
            ponto.setOnClickListener(this);
            soma.setOnClickListener(this);
            soma.setOnClickListener(this);
            subtracao.setOnClickListener(this);
            multiplicacao.setOnClickListener(this);
            divisao.setOnClickListener(this);


        // -- COMANDO BOTÃO LIMPAR --
            bt_limpar.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    txtExpressao.setText("");
                    txtResultado.setText("");

                }
            });

        // -- COMANDO BACKSPACE (LIMPA O ÚLTIMO VALOR) --
            backspace.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    TextView expressao = findViewById(R.id.txt_expressao);
                    String string = expressao.getText().toString();

                    if(!string.isEmpty()){

                        byte var0 = 0;
                        int var1 = string.length()-1;
                        String txtExpressao = string.substring(var0,var1);
                        expressao.setText(txtExpressao);
                    }
                    txtResultado.setText("");
                }
            });

        // -- CALCULAR RESULTADO --
            igual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                        double resultado = expressao.evaluate();
                        long longResult = (long) resultado;

                        if(resultado == (double)longResult){
                            txtResultado.setText((CharSequence) String.valueOf(longResult));
                        }else {
                            txtResultado.setText((CharSequence) String.valueOf(resultado));
                        }
                    }catch (Exception e){

                    }



                }
            });

    }

    // -- ATRELAR O ID A VARIÁVEL --
    private void IniciarComponentes(){
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        bt_limpar = findViewById(R.id.limpar);
        backspace = findViewById(R.id.backspace);
        txtResultado = findViewById(R.id.txt_resultado);
        txtExpressao = findViewById(R.id.txt_expressao);
    }

    // -- ACRESCENTAR VALOR VAZIO AO LIMPAR DADOS E RESULTADO --
    public void AcrescentarExpressao(String string, boolean limpar_dados){

        if (txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }
        if (limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }
        else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }

    // -- ACRESCENTAR O VALOR AO CLICAR NO BOTÃO --
    @Override
    public void onClick(View view) {
        int id = view.getId();
            if (id == R.id.numero_zero) {
                AcrescentarExpressao("0", true);
            }
            else if (id == R.id.numero_um) {
                AcrescentarExpressao("1", true);
            }
            else if (id == R.id.numero_dois) {
                AcrescentarExpressao("2", true);
            }
            else if (id == R.id.numero_tres) {
                AcrescentarExpressao("3", true);
            }
            else if (id == R.id.numero_quatro) {
                AcrescentarExpressao("4", true);
            }
            else if (id == R.id.numero_cinco) {
                AcrescentarExpressao("5", true);
            }
            else if (id == R.id.numero_seis) {
                AcrescentarExpressao("6", true);
            }
            else if (id == R.id.numero_sete) {
                AcrescentarExpressao("7", true);
            }
            else if (id == R.id.numero_oito) {
                AcrescentarExpressao("8", true);
            }
            else if (id == R.id.numero_nove) {
                AcrescentarExpressao("9", true);
            }
            else if (id == R.id.ponto) {
                AcrescentarExpressao(".", true);
            }
            else if (id == R.id.soma) {
                AcrescentarExpressao("+", true);
            }
            else if (id == R.id.subtracao) {
                AcrescentarExpressao("-", true);
            }
            else if (id == R.id.multiplicacao) {
                AcrescentarExpressao("*", true);
            }
            else if (id == R.id.divisao) {
                AcrescentarExpressao("/", true);
            }

        }
    }
