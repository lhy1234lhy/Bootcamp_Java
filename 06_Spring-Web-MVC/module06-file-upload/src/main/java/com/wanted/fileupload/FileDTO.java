package com.wanted.fileupload;

public class FileDTO {

    private String originFileName;
    private String savedName;
    private String filePath;
    private String description;

    public FileDTO(String originFileName, String savedName, String filePath, String description) {
        this.originFileName = originFileName;
        this.savedName = savedName;
        this.filePath = filePath;
        this.description = description;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }

    public String getSavedName() {
        return savedName;
    }

    public void setSavedName(String savedName) {
        this.savedName = savedName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FileDTO{" +
                "originFileName='" + originFileName + '\'' +
                ", savedName='" + savedName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
