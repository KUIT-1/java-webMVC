package jwp.model;

import core.jdbc.JdbcTemplate;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Queue;

public class Question {
    private int questionId; // PK
    private String writer;
    private String title;
    private String contents;
    private Date createDate;
    private int countOfAnswer;

    public Question(int questionId, String writer, String title, String contents, Date createDate, int countOfAnswer) {
        this.questionId = questionId;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createDate = createDate;
        this.countOfAnswer = countOfAnswer;
    }

    public Question(String writer, String title, String contents, int countOfAnswer) {
        this.questionId = 0;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createDate = Date.valueOf(LocalDate.now());
        this.countOfAnswer = countOfAnswer;
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

    public Date getCreateDate() {
        return createDate;
    }

    public int getCountOfAnswer() {
        return countOfAnswer;
    }
    @Override
    public int hashCode() {
        return Objects.hash(getWriter(), getTitle(), getContents(), getCountOfAnswer());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return getCountOfAnswer() == question.getCountOfAnswer() && Objects.equals(getWriter(), question.getWriter()) && Objects.equals(getTitle(), question.getTitle()) && Objects.equals(getContents(), question.getContents());
    }

}
