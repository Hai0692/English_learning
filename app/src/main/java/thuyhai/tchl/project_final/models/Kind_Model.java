package thuyhai.tchl.project_final.models;

import java.io.Serializable;

public class Kind_Model implements Serializable {
    private int ImgKind;
    private String TitleKind;

    public Kind_Model(int imgKind, String titleKind) {
        ImgKind = imgKind;
        TitleKind = titleKind;
    }

    public int getImgKind() {
        return ImgKind;
    }

    public void setImgKind(int imgKind) {
        ImgKind = imgKind;
    }

    public String getTitleKind() {
        return TitleKind;
    }

    public void setTitleKind(String titleKind) {
        TitleKind = titleKind;
    }
}
