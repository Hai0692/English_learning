package thuyhai.tchl.project_final.models;

import java.io.Serializable;

public class Theme_Model implements Serializable {
    private int ImageTheme;
    private String TitleTheme;

    public Theme_Model(int imageTheme, String titleTheme) {
        ImageTheme = imageTheme;
        TitleTheme = titleTheme;
    }

    public int getImageTheme() {
        return ImageTheme;
    }

    public void setImageTheme(int imageTheme) {
        ImageTheme = imageTheme;
    }

    public String getTitleTheme() {
        return TitleTheme;
    }

    public void setTitleTheme(String titleTheme) {
        TitleTheme = titleTheme;
    }
}
