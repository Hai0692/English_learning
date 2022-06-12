package thuyhai.tchl.project_final.models;

import android.net.Uri;

public class vocabulary_response {
    private int id;
    private int kind_id;
    private String word;
    private String type_word;
    private String phonetic;
    private String audio;
    private String definition;

    public vocabulary_response(int id, int kind_id, String word, String type_word, String phonetic, String audio, String definition) {
        this.id = id;
        this.kind_id = kind_id;
        this.word = word;
        this.type_word = type_word;
        this.phonetic = phonetic;
        this.audio = audio;
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKind_id() {
        return kind_id;
    }

    public void setKind_id(int kind_id) {
        this.kind_id = kind_id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getType_word() {
        return type_word;
    }

    public void setType_word(String type_word) {
        this.type_word = type_word;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public String toString() {
        return "vocabulary_response{" +
                "id=" + id +
                ", kind_id=" + kind_id +
                ", word='" + word + '\'' +
                ", type_word='" + type_word + '\'' +
                ", phonetic='" + phonetic + '\'' +
                ", audio='" + audio + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}
