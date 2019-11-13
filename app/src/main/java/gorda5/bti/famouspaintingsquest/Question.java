package gorda5.bti.famouspaintingsquest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *  Question class to generate and store quiz questions.
 */
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

    /**
     * Constructor takes name of the picture, name of the author and the text after the correct answer. The number of correct answer will be generated automatically.
     * The other 3 authors also will be generated randomly.
     * @param question Name of the picture for the question
     * @param answer Correct name of the artist
     * @param correctText The text that will be shown after the right answer
     */
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

    /**
     * Getter method for question field
     * @return The name of the picture to guess
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Getter method for the answer for button with id answer1
     * @return Artist's name
     */
    public String getAnswer1() {
        return answers[0];
    }

    /**
     * Getter method for the answer for button with id answer2
     * @return Artist's name
     */
    public String getAnswer2() {
        return answers[1];
    }

    /**
     * Getter method for the answer for button with id answer3
     * @return Artist's name
     */
    public String getAnswer3() {
        return answers[2];
    }

    /**
     * Getter method for the answer for button with id answer4
     * @return Artist's name
     */
    public String getAnswer4() {
        return answers[3];
    }

    /**
     * Getter method for the right answer id
     * @return Right answer id
     */
    public String getCorrectId() {
        return "answer" + (correctId + 1);
    }

    /**
     * Getter method for the text after the right answer
     * @return Text with useful information
     */
    public String getCorrectText() {
        return correctText;
    }
    /**
     * Setter method for the question field
     * @param question The filename of the picture
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     *  Setter method to set the author name for button with answer1 id
     * @param answer1 The name of the artist
     */
    public void setAnswer1(String answer1) {
        this.answers[0] = answer1;
    }

    /**
     *  Setter method to set the author name for button with answer2 id
     * @param answer2 The name of the artist
     */
    public void setAnswer2(String answer2) {
        this.answers[1] = answer2;
    }

    /**
     *  Setter method to set the author name for button with answer3 id
     * @param answer3 The name of the artist
     */
    public void setAnswer3(String answer3) {
        this.answers[2] = answer3;
    }

    /**
     *  Setter method to set the author name for button with answer4 id
     * @param answer4 The name of the artist
     */
    public void setAnswer4(String answer4) {
        this.answers[3] = answer4;
    }

    /**
     *  Setter method to set the id for correct answer
     * @param correctId The index of the right answer
     */
    public void setCorrectId(int correctId) {
        this.correctId = correctId;
    }

    /**
     * Setter method for the text after the right answer
     * @param correctText Text with useful information
     */
    public void setCorrectText(String correctText) {
        this.correctText = correctText;
    }

    /**
     * Method to show the text representation of the class object
     * @return Text representation
     */
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

    /**
     * Method to get the name of the button with given Id
     * @param id Id for the button
     * @return The name of the button with given Id
     */
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
