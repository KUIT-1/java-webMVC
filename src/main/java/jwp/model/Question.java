package jwp.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Question {
    private int questionId;
    private String writer;
    private String title;
    private String contents;
    private Date createdDate;
    private int countOfAnswer;

    public Question(int questionId, String writer, String title, String contents, Date createdDate, int countOfAnswer) {
        this.questionId = questionId;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createdDate = createdDate;
        this.countOfAnswer = countOfAnswer;
    }

    public Question(String writer, String title, String contents) {
        this.questionId = 0;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createdDate = Date.valueOf(LocalDate.now());
        this.countOfAnswer = 0;
    }
    public int getQuestionId() {
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public int getCountOfAnswer() {
        return countOfAnswer;
    }

    public boolean isSameUser(User user) {
        return writer.equals(user.getUserId());
    }

    public void updateTitleAndContents(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
    public void increaseCountOfAnswer() {
        countOfAnswer++;
    }

    public void decreaseCountOfAnswer() {
        countOfAnswer--;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWriter(), getTitle(), getContents(), getCountOfAnswer());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Question question = (Question) obj;
        return getCountOfAnswer() == question.getCountOfAnswer()
                && Objects.equals(getWriter(), question.getWriter())
                && Objects.equals(getTitle(), question.getTitle())
                && Objects.equals(getContents(), question.getContents());
    }

    @Override
    public String toString() {
        return "Question [questionId=" + questionId + ", writer=" + writer + ", title=" + title + "]";
    }
}
