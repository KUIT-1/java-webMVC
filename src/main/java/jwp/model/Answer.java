package jwp.model;

import java.sql.Date;
import java.time.LocalDate;

public class Answer {
    private int answerId;
    private String writer;
    private String contents;
    private Date createdDate;
    private int questionId;

    public Answer(int answerId, String writer, String contents, Date createdDate, int questionId) {
        this.answerId = answerId;
        this.writer = writer;
        this.contents = contents;
        this.createdDate = createdDate;
        this.questionId = questionId;
    }

    public Answer(int questionId, String writer, String contents) {
        this.answerId = 0;
        this.writer = writer;
        this.contents = contents;
        this.createdDate = Date.valueOf(LocalDate.now());
        this.questionId = questionId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public String getWriter() {
        return writer;
    }

    public String getContents() {
        return contents;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public int getQuestionId() {
        return questionId;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", writer='" + writer + '\'' +
                ", contents='" + contents + '\'' +
                ", createdDate=" + createdDate +
                ", questionId=" + questionId +
                '}';
    }
}
