package gorda5.bti.famouspaintingsquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startQuiz = (Button) findViewById(R.id.startQuiz);
        startQuiz.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent nextScreen = new Intent(MainActivity.this, PaintersQuiz.class);
        startActivity(nextScreen);
    }
}
