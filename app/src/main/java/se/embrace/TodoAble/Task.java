package se.embrace.TodoAble;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;

public class Task implements Parcelable {

    private long id;
    private String title;
    private String description;
    private Date started = new Date();
    private String startedTime;
    private String completedTime;
    private boolean completed;
    private boolean archived;

    public Task() {
    }

    protected Task(Parcel in) {
        id = in.readLong();
        title = in.readString();
        description = in.readString();
        startedTime = in.readString();
        completedTime = in.readString();
        completed = in.readByte() != 0;
        archived = in.readByte() != 0;
        long timestamp = in.readLong();
        if (timestamp != -1)
        {
            started = new Date(timestamp);
        }
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", started=" + started +
                ", startedTime='" + startedTime + '\'' +
                ", completedTime='" + completedTime + '\'' +
                ", completed=" + completed +
                ", archived=" + archived +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (completed != task.completed) return false;
        if (archived != task.archived) return false;
        if (!title.equals(task.title)) return false;
        if (description != null ? !description.equals(task.description) : task.description != null)
            return false;
        return started != null ? started.equals(task.started) : task.started == null;


        //if (!description.equals(task.description)) return false;
        //if (!started.equals(task.started)) return false;
        //if (!startedTime.equals(task.startedTime)) return false;
        //return completedTime.equals(task.completedTime);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + started.hashCode();
        result = 31 * result + startedTime.hashCode();
        result = 31 * result + completedTime.hashCode();
        result = 31 * result + (completed ? 1 : 0);
        result = 31 * result + (archived ? 1 : 0);
        return result;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public String getStartedTime() {
        return startedTime;
    }

    public void setStartedTime(String startedTime) {
        this.startedTime = startedTime;
    }

    public String getCompletedTime() {
        return completedTime;
    }

    public void setCompletedTime(String completedTime) {
        this.completedTime = completedTime;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public Task(long id, String title, String description, Date started, String startedTime, String completedTime, boolean completed, boolean archived) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.started = started;
        this.startedTime = startedTime;
        this.completedTime = completedTime;
        this.completed = completed;
        this.archived = archived;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(startedTime);
        dest.writeString(completedTime);
        dest.writeByte((byte) (completed ? 1 : 0));
        dest.writeByte((byte) (archived ? 1 : 0));
        if (started != null)
        {
            dest.writeLong(started.getTime());
        }
        else
        {
            dest.writeLong(-1);
        }
    }
}