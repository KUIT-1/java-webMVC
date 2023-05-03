package jwp.model;

import java.util.Date;

public class Question {

    long questionId;
    String writer;
    String title;
    String contents;

    Date createdDate;
    int countOfAnswer;


    public Question(long questionId, String writer, String title, String contents,Date createdDate, int countOfAnswer) {
        this.questionId = questionId;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createdDate = createdDate;
        this.countOfAnswer = countOfAnswer;
    }

    public long getQuestionId() {
        return questionId;
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public int getCountOfAnswer() {
        return countOfAnswer;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
