package repositories.implementations;

import java.util.List;
import java.util.NoSuchElementException;

import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.Record2;
import org.jooq.SelectConditionStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jooq.steve.db.tables.records.QuestionRecord;
import repositories.dto.QuestionDTO;
import repositories.interfaces.IQuestionRepo;
import web.dto.QuestionForm;

import static jooq.steve.db.tables.Question.QUESTION;

@Repository
public class QuestionRepoImpl implements IQuestionRepo {

    private DSLContext ctx;

    @Autowired
    QuestionRepoImpl(DSLContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public List<repositories.dto.QuestionDTO> getAllUsersQuestions() {
        SelectConditionStep<Record3<Integer, Integer, String>> query = ctx.select(
                QUESTION.QUESTION_PK,
                QUESTION.USER_PK,
                QUESTION.QUESTION_TEXT)
                .from(QUESTION)
                .where();

        return query.fetch()
                .map(r -> QuestionDTO.builder()
                        .questionPk(r.value1())
                        .userPk(r.value2())
                        .questionText(r.value3())
                        .build());
    }

    @Override
    public List<QuestionDTO> getQuestionsByUser(Integer userPk) {
        SelectConditionStep<Record2<Integer, String>> query = ctx.select(
                QUESTION.USER_PK,
                QUESTION.QUESTION_TEXT)
                .from(QUESTION)
                .where(QUESTION.USER_PK.equal(userPk));

        return query.fetch()
                .map(r -> QuestionDTO.builder()
                        .userPk(r.value1())
                        .questionText(r.value2())
                        .build());
    }

    @Override
    public QuestionForm getQuestion(Integer questionPk) {
        QuestionRecord questionRecord = ctx.selectFrom(QUESTION)
                .where(QUESTION.QUESTION_PK.equal(questionPk))
                .fetchOne();

        if (questionRecord == null) {
            throw new NoSuchElementException("Question with ID " + questionPk + " not found");
        }

        QuestionForm questionForm = QuestionForm.builder()
                .userPk(questionRecord.getUserPk())
                .questionPk(questionRecord.getQuestionPk())
                .questionText(questionRecord.getQuestionText())
                .build();

        return questionForm;
    }

    @Override
    public void insertQuestion(QuestionForm form) {
        ctx.transaction(configuration -> {
            try {
                ctx.insertInto(QUESTION)
                        .set(QUESTION.USER_PK, form.getUserPk())
                        .set(QUESTION.QUESTION_TEXT, form.getQuestionText())
                        .execute();
            } catch (DataAccessException e) {
                throw new Exception("Failed to insert new question ", e);
            }
        });
    }

    @Override
    public void updateQuestion(QuestionForm form) {
        ctx.transaction(configuration -> {
            try {
                ctx.update(QUESTION)
                        .set(QUESTION.QUESTION_TEXT, form.getQuestionText())
                        .where(QUESTION.QUESTION_PK.equal(form.getQuestionPk()))
                        .execute();
            } catch (DataAccessException e) {
                throw new Exception("Failed to update question " + form.getQuestionPk(), e);
            }
        });
    }

    @Override
    public void deleteQuestion(Integer questionPk) {
        ctx.transaction(configuration -> {
            DSLContext ctx = DSL.using(configuration);
            try {
                ctx.delete(QUESTION)
                        .where(QUESTION.QUESTION_PK.equal(questionPk))
                        .execute();
            } catch (DataAccessException e) {
                throw new Exception("Failed to delete question from " + questionPk, e);
            }
        });
    }

}
