package com.example.alcoholorgasoline;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText precoAlcool;
    private EditText precoGasolina;
    private Button botaoVerificar;
    private TextView textoResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mapeando componentes na tela
        precoAlcool = (EditText) findViewById(R.id.idAlcoolPreco);
        precoGasolina = (EditText) findViewById(R.id.idGasolinaPreco);
        botaoVerificar = (Button) findViewById(R.id.idBotaoVerificar);
        textoResultado = (TextView) findViewById(R.id.idTextoResultado);


        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recuperar valores inseridos pelo usuário
                String precoAlcoolInserido = precoAlcool.getText().toString();
                String precoGasolinaInserido = precoGasolina.getText().toString();

                if (precoAlcoolInserido.isEmpty() || precoGasolinaInserido.isEmpty()) {
                    textoResultado.setText("Por favor, digite um valor em ambos os combustíveis!");
                } else {
                    //Converter Strings inseridas pelo usuários para números
                    Double valorDoAlcool = Double.parseDouble(precoAlcoolInserido);
                    Double valorDaGasolina = Double.parseDouble(precoGasolinaInserido);


                    //Cálculo sobre os valores de álcool e gasolina. Álcool/Gasolina.
                    double resultado = valorDoAlcool / valorDaGasolina;


                    if (resultado >= 0.7) {
                    //Melhor abastecer com gasolina
                    textoResultado.setText("É melhor abastecer com gasolina!");
                    } else {
                    //Melhor abastecer com álcool
                    textoResultado.setText("É melhor abastecer com álcool!");
                    }
                }
            }
        });
    }
}
