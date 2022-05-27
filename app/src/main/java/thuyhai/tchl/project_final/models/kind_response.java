package thuyhai.tchl.project_final.models;

import java.io.Serializable;

public class kind_response implements Serializable {
    private String kind_name ;

    public kind_response(String kind_name) {
        this.kind_name = kind_name;
    }

    public String getKind_name() {
        return kind_name;
    }

    public void setKind_name(String kind_name) {
        this.kind_name = kind_name;
    }
}
