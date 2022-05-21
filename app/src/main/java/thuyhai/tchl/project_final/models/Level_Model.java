package thuyhai.tchl.project_final.models;

public class Level_Model {
    private int ID;
    private String name_level;

    public Level_Model(int ID, String name_level) {
        this.ID = ID;
        this.name_level = name_level;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName_level() {
        return name_level;
    }

    public void setName_level(String name_level) {
        this.name_level = name_level;
    }
}
