package gorda5.bti.famouspaintingsquest;

public class Question {
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctText;
    private String correctId;

    public Question(String question, String answer1, String answer2, String answer3, String answer4, String correctId, String correctText) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctId = correctId;
        this.correctText = correctText;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getCorrectId() {
        return correctId;
    }

    public String getCorrectText() {
        return correctText;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public void setCorrectId(String correctId) {
        this.correctId = correctId;
    }

    public void setCorrectText(String correctText) {
        this.correctText = correctText;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", answer4='" + answer4 + '\'' +
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
