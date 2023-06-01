package Anser;

public class modelQuestion {
    String Question;
    String Answer;

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public boolean itsHim(String ss) {
        if (this.Question.indexOf(ss) > -1) return true;
        return false;
    }

    @Override
    public String toString() {
        return "modelQuestion{" +
                "Q='" + Question + '\'' +
                "A='" + Answer + '\'' +
                '}';
    }
}
