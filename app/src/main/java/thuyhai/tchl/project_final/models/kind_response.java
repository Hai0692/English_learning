package thuyhai.tchl.project_final.models;

import java.io.Serializable;

public class kind_response implements Serializable {
    private String kind_name ;
    private int id;

    public String getKind_name() {
        return kind_name;
    }

    public void setKind_name(String kind_name) {
        this.kind_name = kind_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public kind_response(String kind_name, int id) {
        this.kind_name = kind_name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "kind_response{" +
                "kind_name='" + kind_name + '\'' +
                ", id=" + id +
                '}';
    }
}
