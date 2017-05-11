package pt.ipleiria.estg.dei.tutoriaisandroid.olamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final Random gerador = new Random();

    private int valorAleatorio;

    private EditText txtGuess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorAleatorio = geraValorAleatorio(1, 10);
        txtGuess = (EditText) findViewById(R.id.editText);
    }

    private int geraValorAleatorio(int min, int max){
        int valor = gerador.nextInt(max - min + 1) + min;
        return valor;
    }

    public void onClickAdivinha(View view) {
        if (txtGuess.getText() == null ||
                txtGuess.getText().toString().trim().isEmpty())
            return;

        String message;
        
        int guess = Integer.parseInt(txtGuess.getText().toString());

        if (guess == valorAleatorio)
            message = "Acertou!";
        else if (guess < valorAleatorio)
            message = "para cima...";
        else
            message = "para baixo...";

        Intent intent = ApresentaResultadoActivity.createIntent(this, message);

        startActivity(intent);

        txtGuess.setText("");

    }
}
