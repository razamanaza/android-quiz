package gorda5.bti.famouspaintingsquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class PaintersQuiz extends AppCompatActivity implements View.OnClickListener {

    private HashMap<Integer, String> buttons = new HashMap<Integer, String>();
    private ArrayList<Question> questions = new ArrayList<Question>();
    private int currentQuestion = 0;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private TextView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painters_quiz);
        answer1 = (Button) findViewById(R.id.answer1);
        buttons.put(answer1.getId(), "answer1");
        answer1.setOnClickListener(this);
        answer2 = (Button) findViewById(R.id.answer2);
        buttons.put(answer2.getId(), "answer2");
        answer2.setOnClickListener(this);
        answer3 = (Button) findViewById(R.id.answer3);
        buttons.put(answer3.getId(), "answer3");
        answer3.setOnClickListener(this);
        answer4 = (Button) findViewById(R.id.answer4);
        answer4.setOnClickListener(this);
        buttons.put(answer4.getId(), "answer4");
        picture = (TextView) findViewById(R.id.picture);
        setupQuestions();
        drawQuestion();
    }

    private void setupQuestions() {
        questions.add(new Question(
                R.drawable.vertumnus,
                "Andy Warhol",
                "Giuseppe Arcimboldo",
                "Leonardo da Vinci",
                "Salvador Dali",
                "answer2",
                "It's a RIGHT answer.\nVertumnus painting is Arcimboldo's most famous work and is a portrait of the Holy Roman Emperor Rudolf II re-imagined as Vertumnus, the Roman god of metamorphoses in nature and life",
                "Your answer is WRONG.\nThis is a painting Vertumnus by Mannerist painter Giuseppe Arcimboldo"
        ));
    }

    private void drawQuestion() {
        Question question = questions.get(currentQuestion);
        picture.setBackgroundResource(question.getQuestion());
        picture.setText("");
        answer1.setText(question.getAnswer1());
        answer2.setText(question.getAnswer2());
        answer3.setText(question.getAnswer3());
        answer4.setText(question.getAnswer4());
    }

    @Override
    public void onClick(View v) {

        Question question = questions.get(currentQuestion);
        String pressed = buttons.get(v.getId());
        if(pressed.equals(question.getCorrectId())) {
            picture.setBackgroundResource(0);
            picture.setText(question.getCorrectText());
            picture.setTextColor(Color.rgb(0, 77, 64));
        }
    }
}
