package thuyhai.tchl.project_final.models;
import java.io.Serializable;

public class question_response implements Serializable {

    private String name;
    private String body;

    public question_response(String name, String body) {
        this.name = name;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "question_response{" +
                "name='" + name + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}