package thuyhai.tchl.project_final.models;

public class Question_Model {
    private String questionModel;
    private String nameModel;
    private int imageModel;

    public Question_Model(String questionModel, String nameModel, int imageModel) {
        this.questionModel = questionModel;
        this.nameModel = nameModel;
        this.imageModel = imageModel;
    }

    public String getQuestionModel() {
        return questionModel;
    }

    public String getNameModel() {
        return nameModel;
    }

    public int getImageModel() {
        return imageModel;
    }

    public void setQuestionModel(String questionModel) {
        this.questionModel = questionModel;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public void setImageModel(int imageModel) {
        this.imageModel = imageModel;
    }
}
