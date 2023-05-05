package jwp.model;

import java.sql.Date;
import java.time.LocalDate;

public class Question {
    /**
     * CREATE TABLE QUESTIONS (
     *                            questionId 			bigint				auto_increment,
     *                            writer				varchar(30)			NOT NULL,
     *                            title				varchar(50)			NOT NULL,
     *                            contents			varchar(5000)		NOT NULL,
     *                            createdDate			timestamp			NOT NULL,
     *                            countOfAnswer int,
     *                            PRIMARY KEY               (questionId)
     * );
     */
    private int questionId;
    private String writer;
    private String title;
    private String contents;
    private Date createdDate;
    private int countOfAnswer;

    public Question(int questionId, String writer, String title, String contents, Date createdDate, int countOfAnswer){
        this.questionId = questionId;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createdDate = createdDate;
        this.countOfAnswer = countOfAnswer;
    }
    public Question(String writer, String title, String contents, int countOfAnswer){
        this.questionId = 0;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.createdDate = Date.valueOf(LocalDate.now());
        this.countOfAnswer = countOfAnswer;
    }

    public int getQuestionId(){return questionId;}
    public String getWriter(){return writer;}
    public String getTitle(){return title;}
    public String getContents(){return contents;}
    public Date getCreatedDate(){return createdDate;}
    public int getCountOfAnswer(){return countOfAnswer;}
}
