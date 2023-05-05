package jwp.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Answer {

    private int answerId;
    private String writer;
    private String contents;
    private Date createdDate;
    private int questionId;

    public Answer(int answerId, String writer, String contents, Date createdDate, int questionId) {
        this.questionId = questionId;
        this.writer = writer;
        this.contents = contents;
        this.createdDate = createdDate;
        this.answerId = answerId;
    }

    public Answer(int questionId, String writer, String contents) {
        this.questionId = questionId;
        this.writer = writer;
        this.contents = contents;
        this.createdDate = Date.valueOf(LocalDate.now());
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
    public int hashCode() {
        return Objects.hash(getWriter(), getContents(), getQuestionId(), getCreatedDate());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Answer answer = (Answer) obj;
        return getQuestionId() == answer.getQuestionId()
                && Objects.equals(getWriter(), answer.getWriter())
                && Objects.equals(getAnswerId(), answer.getAnswerId())
                && Objects.equals(getContents(), answer.getContents());
    }

}
