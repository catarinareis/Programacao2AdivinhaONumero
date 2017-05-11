package pt.ipleiria.estg.dei.tutoriaisandroid.olamundo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        int guess = Integer.parseInt(txtGuess.getText().toString());

        if (guess == valorAleatorio)
            Toast.makeText(this, "Acertou!",
                    Toast.LENGTH_SHORT).show();
        else if (guess < valorAleatorio)
            Toast.makeText(this, "para cima...",
                    Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "para baixo...",
                    Toast.LENGTH_SHORT).show();

        txtGuess.setText("");
    }

}
