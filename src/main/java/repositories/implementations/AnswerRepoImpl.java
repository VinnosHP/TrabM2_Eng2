package repositories.implementations;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.SelectConditionStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import repositories.dto.AnswerDTO;
import repositories.interfaces.IAnswerRepo;
import web.dto.AnswerForm;

import static jooq.steve.db.tables.Answer.ANSWER;
import static org.springframework.util.ObjectUtils.isEmpty;

@Repository
public class AnswerRepoImpl implements IAnswerRepo {

    private DSLContext ctx;

    @Autowired
    AnswerRepoImpl(DSLContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public List<repositories.dto.AnswerDTO> getAllUsersAnswers(AnswerForm form) {
        SelectConditionStep<Record3<Integer, Integer, String>> query = ctx.select(
                ANSWER.USER_PK,
                ANSWER.QUESTION_PK,
                ANSWER.ANSWER_TEXT)
                .from(ANSWER)
                .where();

        if (!isEmpty(form.getUserPk())) {
            query.and(ANSWER.USER_PK.equal(form.getUserPk()));
        }

        if (!isEmpty(form.getQuestionPk())) {
            query.and(ANSWER.QUESTION_PK.equal(form.getQuestionPk()));
        }

        return query.fetch()
                .map(r -> AnswerDTO.builder()
                        .userPk(r.value1())
                        .questionPk(r.value2())
                        .answerText(r.value3())
                        .build());
    }

    @Override
    public List<AnswerDTO> getAnswersByUser(Integer userPk) {
        SelectConditionStep<Record3<Integer, Integer, String>> query = ctx.select(
                ANSWER.USER_PK,
                ANSWER.QUESTION_PK,
                ANSWER.ANSWER_TEXT)
                .from(ANSWER)
                .where(ANSWER.USER_PK.equal(userPk));

        return query.fetch()
                .map(r -> AnswerDTO.builder()
                        .userPk(r.value1())
                        .questionPk(r.value2())
                        .answerText(r.value3())
                        .build());
    }

    @Override
    public List<AnswerDTO> getAnswersByQuestion(Integer questionPk) {
        SelectConditionStep<Record3<Integer, Integer, String>> query = ctx.select(
                ANSWER.USER_PK,
                ANSWER.QUESTION_PK,
                ANSWER.ANSWER_TEXT)
                .from(ANSWER)
                .where(ANSWER.QUESTION_PK.equal(questionPk));

        return query.fetch()
                .map(r -> AnswerDTO.builder()
                        .userPk(r.value1())
                        .questionPk(r.value2())
                        .answerText(r.value3())
                        .build());
    }

    @Override
    public void insertAnswer(AnswerForm form) {
        ctx.transaction(configuration -> {
            try {
                ctx.insertInto(ANSWER)
                        .set(ANSWER.USER_PK, form.getUserPk())
                        .set(ANSWER.QUESTION_PK, form.getQuestionPk())
                        .set(ANSWER.ANSWER_TEXT, form.getAnswerText())
                        .execute();
            } catch (DataAccessException e) {
                throw new Exception("Failed to insert answer into question " + form.getQuestionPk(), e);
            }
        });
    }

    @Override
    public void updateAnswer(AnswerForm form) {
        ctx.transaction(configuration -> {
            try {
                ctx.update(ANSWER)
                        .set(ANSWER.ANSWER_TEXT, form.getAnswerText())
                        .where(ANSWER.ANSWER_PK.equal(form.getAnswerPk()))
                        .execute();
            } catch (DataAccessException e) {
                throw new Exception("Failed to update answer " + form.getAnswerPk(), e);
            }
        });
    }

    @Override
    public void deleteAnswer(Integer answerPk) {
        ctx.transaction(configuration -> {
            DSLContext ctx = DSL.using(configuration);
            try {
                ctx.delete(ANSWER)
                        .where(ANSWER.ANSWER_PK.equal(answerPk))
                        .execute();
            } catch (DataAccessException e) {
                throw new Exception("Failed to delete answer from " + answerPk, e);
            }
        });
    }

}
