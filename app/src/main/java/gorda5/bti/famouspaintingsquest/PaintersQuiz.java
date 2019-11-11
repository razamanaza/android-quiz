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
    Question question;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private TextView picture;
    boolean isAnswered = false;
    int scores = 0;

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
                "It's a RIGHT answer.\n\nVertumnus painting is Arcimboldo's most famous work and is a portrait of the Holy Roman Emperor Rudolf II re-imagined as Vertumnus, the Roman god of metamorphoses in nature and life",
                "Your answer is WRONG.\n\nThis is a painting Vertumnus by painter Giuseppe Arcimboldo"
        ));
    }

    private void drawQuestion() {
        question = questions.get(currentQuestion);
        picture.setBackgroundResource(question.getQuestion());
        picture.setText("");
        answer1.setText(question.getAnswer1());
        answer1.setBackgroundColor(Color.parseColor("#BF360C"));
        answer2.setText(question.getAnswer2());
        answer2.setVisibility(View.VISIBLE);
        answer3.setText(question.getAnswer3());
        answer3.setVisibility(View.VISIBLE);
        answer4.setText(question.getAnswer4());
        answer4.setBackgroundColor(Color.parseColor("#BF360C"));
    }

    private void drawRight(String pressed) {
        picture.setBackgroundResource(0);
        picture.setText(question.getCorrectText());
        picture.setTextColor(Color.parseColor("#33691E"));
        answer1.setText(question.getAnswer(pressed));
        answer1.setBackgroundColor(Color.parseColor("#33691E"));
        answer2.setVisibility(View.INVISIBLE);
        answer3.setVisibility(View.INVISIBLE);
        answer4.setText("Next");
        answer4.setBackgroundColor(Color.parseColor("#01579B"));
    }

    private void drawWrong(String pressed) {
        picture.setBackgroundResource(0);
        picture.setText(question.getWrongText());
        picture.setTextColor(Color.parseColor("#BF360C"));
        answer1.setText(question.getAnswer(pressed));
        answer1.setBackgroundColor(Color.parseColor("#BF360C"));
        answer2.setVisibility(View.INVISIBLE);
        answer3.setVisibility(View.INVISIBLE);
        answer4.setText("Next");
        answer4.setBackgroundColor(Color.parseColor("#01579B"));
    }

    @Override
    public void onClick(View v) {
        String pressed = buttons.get(v.getId());
        Log.d("GORDA5", pressed);
        if(isAnswered && pressed.equals("answer4")){
            isAnswered = false;
            drawQuestion();
        } else if (!isAnswered){
            if(pressed.equals(question.getCorrectId())) {
                isAnswered = true;
                scores++;
                drawRight(pressed);
            } else {
                isAnswered = true;
                drawWrong(pressed);
            }
        }

    }
}
