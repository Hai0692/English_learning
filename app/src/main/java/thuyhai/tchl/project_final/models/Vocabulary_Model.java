package thuyhai.tchl.project_final.models;
import java.io.Serializable;

public class Vocabulary_Model implements Serializable {
    private String Vocabulary, Meaning;

    public Vocabulary_Model(String vocabulary, String meaning) {
        Vocabulary = vocabulary;
        Meaning = meaning;
    }

    public String getVocabulary() {
        return Vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        Vocabulary = vocabulary;
    }

    public String getMeaning() {
        return Meaning;
    }

    public void setMeaning(String meaning) {
        Meaning = meaning;
    }
}
