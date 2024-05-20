package repositories.implementations;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Record4;
import org.jooq.SelectConditionStep;
import org.jooq.exception.DataAccessException;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import repositories.dto.User;
import repositories.interfaces.IUserRepo;
import webapp.dto.UserForm;

import static jooq.steve.db.tables.User.USER;

@Repository
public class UserRepoImpl implements IUserRepo {

    private DSLContext ctx;

    @Autowired
    UserRepoImpl(DSLContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public List<User> getUsersList() {
        SelectConditionStep<Record4<Integer, String, String, String>> query = ctx.select(
                USER.PICTURE_ID,
                USER.NAME,
                USER.EMAIL,
                USER.PASSWORD)
                .from(USER)
                .where();

        return query.fetch()
                .map(r -> User.builder()
                        .pictureId(r.value1())
                        .userName(r.value2())
                        .userEmail(r.value3())
                        .userPassword(r.value4())
                        .build());
    }

    @Override
    public void createNewUser(UserForm form) {
        ctx.transaction(configuration -> {
            try {
                ctx.insertInto(USER)
                        .set(USER.PICTURE_ID, form.getPictureId())
                        .set(USER.NAME, form.getUserName())
                        .set(USER.EMAIL, form.getUserEmail())
                        .set(USER.PASSWORD, form.getUserPassword())
                        .execute();
            } catch (DataAccessException e) {
                throw new Exception("Failed to create new user", e);
            }
        });
    }

    @Override
    public void updateUser(UserForm form) {
        ctx.transaction(configuration -> {
            try {
                ctx.update(USER)
                        .set(USER.PICTURE_ID, form.getPictureId())
                        .set(USER.NAME, form.getUserName())
                        .set(USER.EMAIL, form.getUserEmail())
                        .set(USER.PASSWORD, form.getUserPassword())
                        .where(USER.USER_PK.equal(form.getUserPk()))
                        .execute();
            } catch (DataAccessException e) {
                throw new Exception("Failed to update user: " + form.getUserPk(), e);
            }
        });
    }

    @Override
    public void deleteUser(Integer userPk) {
        ctx.transaction(configuration -> {
            DSLContext ctx = DSL.using(configuration);
            try {
                ctx.delete(USER)
                        .where(USER.USER_PK.equal(userPk))
                        .execute();
            } catch (DataAccessException e) {
                throw new Exception("Failed to delete userPk: " + userPk, e);
            }
        });
    }
}
