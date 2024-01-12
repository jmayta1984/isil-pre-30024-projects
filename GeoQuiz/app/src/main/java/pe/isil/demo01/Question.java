package pe.isil.demo01;

public class Question {
    private final String sentence;
    private final boolean response;
    private boolean verified = false;


    public Question(String sentence, boolean response) {
        this.sentence = sentence;
        this.response = response;
    }

    public String getSentence() {
        return sentence;
    }

    public boolean isResponse() {
        return response;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
