package gorda5.bti.famouspaintingsquest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Question {
    private String question;
    private String[] answers = new String[4];
    private String correctText;
    private int correctId;
    private ArrayList<String> artists = new ArrayList<>(Arrays.asList(
            "Andy Warhol",
            "Bill Hammond",
            "Giuseppe Arcimboldo",
            "Gottfried Lindauer",
            "Ivan Aivazovsky",
            "Kazimir Malevich",
            "Leonardo da Vinci",
            "Pablo Picasso",
            "Salvador Dali",
            "Vincent van Gogh",
            "Michelangelo",
            "Henri Matisse",
            "Jackson Pollock",
            "Edvard Munch",
            "Claude Monet",
            "Rene Magritte",
            "Frida Kahlo",
            "Yayoi Kusama",
            "Sandro Botticelli",
            "Paul Gauguin"
    ));

    private int random(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }

    public Question(String question, String answer, String correctText) {
        this.question = question;
        this.correctText = correctText;
        this.correctId = random(3);
        artists.remove(answer);
        for(int i = 3; i >= 0; i--){
            int index = random(i + 16);
            answers[i] = i == this.correctId ? answer : artists.get(index);
            artists.remove(artists.get(index));
        }
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answers[0];
    }

    public String getAnswer2() {
        return answers[1];
    }

    public String getAnswer3() {
        return answers[2];
    }

    public String getAnswer4() {
        return answers[3];
    }

    public String getCorrectId() {
        return "answer" + (correctId + 1);
    }

    public String getCorrectText() {
        return correctText;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer1(String answer1) {
        this.answers[0] = answer1;
    }

    public void setAnswer2(String answer2) {
        this.answers[1] = answer2;
    }

    public void setAnswer3(String answer3) {
        this.answers[2] = answer3;
    }

    public void setAnswer4(String answer4) {
        this.answers[3] = answer4;
    }

    public void setCorrectId(int correctId) {
        this.correctId = correctId;
    }

    public void setCorrectText(String correctText) {
        this.correctText = correctText;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer1='" + answers[0] + '\'' +
                ", answer2='" + answers[1] + '\'' +
                ", answer3='" + answers[2] + '\'' +
                ", answer4='" + answers[3] + '\'' +
                ", correctId=" + correctId +
                ", correctText='" + correctText + '\'' +
                '}';
    }

    public String getAnswer(String id) {
        switch (id) {
            case "answer1":
                return this.getAnswer1();
            case "answer2":
                return this.getAnswer2();
            case "answer3":
                return this.getAnswer3();
            case "answer4":
                return this.getAnswer4();
            default:
                return "";
        }
    }
}
