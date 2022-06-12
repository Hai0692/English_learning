package thuyhai.tchl.project_final.models;

import java.io.Serializable;

public class level_response implements Serializable {
    private String level;
    public level_response(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "level_response{" +
                "level='" + level + '\'' +
                '}';
    }
}
