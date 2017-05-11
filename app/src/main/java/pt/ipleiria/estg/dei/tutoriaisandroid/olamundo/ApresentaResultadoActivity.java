package pt.ipleiria.estg.dei.tutoriaisandroid.olamundo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ApresentaResultadoActivity extends AppCompatActivity {

    public static final String MESSAGE = "pt.ipleiria.estg.dei.tutoriaisandroid.olamundo.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresenta_resultado);

        Intent intent = getIntent();

        String message = intent.getStringExtra(MESSAGE);

        TextView txtMensagem = (TextView) findViewById(R.id.textView);

        txtMensagem.setText(message);

    }

    public static Intent createIntent(Context context, String message){
        Intent intent = new Intent(context,
                ApresentaResultadoActivity.class);

        intent.putExtra(MESSAGE, message);

        return intent;
    }
}
