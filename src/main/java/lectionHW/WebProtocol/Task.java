package lectionHW.WebProtocol;

import com.google.gson.annotations.SerializedName;

public class Task {
    @SerializedName("userId")
    private int userId;

    @SerializedName("id")
    private int taskId;

    @SerializedName("title")
    private String title;

    @SerializedName("completed")
    private boolean completed;

    public int getUserId() {
        return userId;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "Task: " +
                "id" + taskId +
                ", title='" + title + "\n";
    }
}
