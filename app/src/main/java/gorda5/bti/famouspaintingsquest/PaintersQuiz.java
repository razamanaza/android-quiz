package gorda5.bti.famouspaintingsquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
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
    private TextView estimation;
    private TextView info;
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
        estimation = (TextView) findViewById(R.id.estimationText);
        info = (TextView) findViewById(R.id.usefulInfo);
        setupQuestions();
        Collections.shuffle(questions);
        drawQuestion();
    }

    private void setupQuestions() {
        questions.add(new Question(
                "vertumnus",
                "Giuseppe Arcimboldo",
                "Vertumnus painting is Arcimboldo's most famous work and is a portrait of the Holy Roman Emperor Rudolf II re-imagined as Vertumnus, the Roman god of metamorphoses in nature and life."
        ));
        questions.add(new Question(
                "the_persistence_of_memory",
                "Salvador Dali",
                "The Persistence of Memory is a 1931 painting by artist Salvador Dalí, and one of the most recognizable works of Surrealism. It is widely recognized and frequently referenced in popular culture, and sometimes referred to by more descriptive (though incorrect) titles, such as \"Melting Clocks\", \"The Soft Watches\" or \"The Melting Watches\"."
        ));
        questions.add(new Question(
                "black_square",
                "Kazimir Malevich",
                "Black Square is an iconic painting by Kazimir Malevich. The first version was done in 1915. Malevich made four variants. The work is frequently invoked by critics, historians, curators, and artists as the \"zero point of painting\", referring to the painting's historical significance and paraphrasing Malevich."
        ));
        questions.add(new Question(
                "les_demoiselles_davignon",
                "Pablo Picasso",
                "Les Demoiselles d'Avignon is a large oil painting created in 1907 by the Spanish artist Pablo Picasso. Each figure is depicted in a disconcerting confrontational manner and none is conventionally feminine. The women appear slightly menacing and are rendered with angular and disjointed body shapes."
        ));
        questions.add(new Question(
                "mao",
                "Andy Warhol",
                "Mao is one of a series of silkscreened portraits of the Chinese Communist leader Mao Zedong that Andy Warhol produced in 1973. This towering image mirrors representations that were displayed throughout China during and after the Cultural Revolution."
        ));
        questions.add(new Question(
                "portrait_of_wahanui_reihana_te_huatare",
                "Gottfried Lindauer",
                "Gottfried Lindauer (5 January 1839[1] – 13 June 1926) was a Bohemian and New Zealand artist famous for his portraits, including many of Maori people."
        ));
        questions.add(new Question(
                "the_mona_lisa",
                "Leonardo da Vinci",
                "Leonardo da Vinci was an Italian polymath of the Renaissance.. He is widely considered one of the greatest painters of all time, despite perhaps only 15 of his paintings having survived. The Mona Lisa is the most famous of his works and the most popular portrait ever made."
        ));
        questions.add(new Question(
                "the_ninth_wave",
                "Ivan Aivazovsky",
                "Ivan Konstantinovich Aivazovsky was a Russian Romantic painter who is considered one of the greatest masters of marine art. Baptized as Hovhannes Aivazian, he was born into an Armenian family in the Black Sea port of Feodosia in Crimea and was mostly based there."
        ));
        questions.add(new Question(
                "the_scream_edvard_munch",
                "Edvard Munch",
                "The Scream is the popular name given to a composition created by Norwegian Expressionist artist Edvard Munch. The agonised face in the painting has become one of the most iconic images of art, seen as symbolising the anxiety of modern man."
        ));
        questions.add(new Question(
                "the_starry_night",
                "Vincent van Gogh",
                "The Starry Night by painter Vincent van Gogh. It describes the view from the east-facing window of his asylum room, just before sunrise, with the addition of an ideal village. Regarded as among Van Gogh's finest works, The Starry Night is one of the most recognized paintings in the history of Western culture."
        ));
    }

    private void drawQuestion() {
        question = questions.get(currentQuestion);
        int picId = getResources().getIdentifier(question.getQuestion(), "drawable", getPackageName());
        picture.setBackgroundResource(picId);
        answer1.setText(question.getAnswer1());
        answer1.setVisibility(View.VISIBLE);
        answer2.setText(question.getAnswer2());
        answer2.setVisibility(View.VISIBLE);
        answer3.setText(question.getAnswer3());
        answer3.setVisibility(View.VISIBLE);
        answer4.setText(question.getAnswer4());
        answer4.setBackgroundColor(Color.parseColor("#BF360C"));
        estimation.setVisibility(View.INVISIBLE);
        info.setVisibility(View.INVISIBLE);
    }

    private void drawRight() {
        answer1.setVisibility(View.INVISIBLE);
        answer2.setVisibility(View.INVISIBLE);
        answer3.setVisibility(View.INVISIBLE);
        answer4.setBackgroundColor(Color.parseColor("#01579B"));
        answer4.setText("Next");
        estimation.setVisibility(View.VISIBLE);
        estimation.setTextColor(Color.parseColor("#33691E"));
        estimation.setText("YOUR ANSWER IS RIGHT");
        info.setVisibility(View.VISIBLE);
        info.setText(question.getCorrectText());
    }

    private void drawWrong() {
        estimation.setVisibility(View.VISIBLE);
        estimation.setTextColor(Color.parseColor("#B71C1C"));
        estimation.setText("YOUR ANSWER IS WRONG");
    }

    @Override
    public void onClick(View v) {
        String pressed = buttons.get(v.getId());
        if(answer4.getText().equals("Next")){
            isAnswered = false;
            currentQuestion++;
            if (currentQuestion < questions.size()) {
                drawQuestion();
            } else {
                Intent nextScreen = new Intent(PaintersQuiz.this, Results.class);
                nextScreen.putExtra("score", scores);
                startActivity(nextScreen);
            }
        } else {
            if(pressed.equals(question.getCorrectId())) {
                scores += isAnswered == true ? 0 : 1;
                isAnswered = true;
                drawRight();
            } else {
                isAnswered = true;
                drawWrong();
            }
        }
    }
}
