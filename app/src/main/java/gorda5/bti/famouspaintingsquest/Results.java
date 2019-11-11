package gorda5.bti.famouspaintingsquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent game = getIntent();
        int score = game.getIntExtra("score", -1);
        TextView scoretv = (TextView) findViewById(R.id.scores);
        scoretv.setText(Integer.toString(score));
    }
}
