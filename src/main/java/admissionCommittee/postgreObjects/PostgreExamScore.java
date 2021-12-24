package admissionCommittee.postgreObjects;

import admissionCommittee.dao.AbstractDao;
import admissionCommittee.objects.ExamScore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostgreExamScore extends AbstractDao {
    public PostgreExamScore() throws SQLException {
    }

    @Override
    public void insert(Object o) throws SQLException {
        ExamScore examScore = (ExamScore) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "insert into acd.exam_scores values (?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, examScore.getExamScoreId());
        preparedStatement.setInt(2, examScore.getRegistrationNumber());
        preparedStatement.setInt(3, examScore.getExamScores()[0]);
        preparedStatement.setInt(4, examScore.getExamScores()[1]);
        preparedStatement.setInt(5, examScore.getExamScores()[2]);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void delete(Object o) throws SQLException {
        ExamScore examScore = (ExamScore) o;
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "delete from acd.exam_scores where exam_scores_id=?");
        preparedStatement.setInt(1, examScore.getExamScoreId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public void update(int id, Object o) throws SQLException {
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "update acd.exam_scores set exam_score_1=? where exam_scores_id=?");
        preparedStatement.setInt(1, (int) o);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @Override
    public List getAll() throws SQLException {
        List<ExamScore> examScores = new ArrayList<>();
        PreparedStatement preparedStatement = DEFAULT_CONNECTION.prepareStatement(
                "select * from acd.exam_scores");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            ExamScore examScore = new ExamScore();
            examScore.setExamScoreId(resultSet.getInt(1));
            examScore.setRegistrationNumber(resultSet.getInt(2));
            int[] scores = {resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5)};
            examScore.setExamScores(scores);
            examScores.add(examScore);
        }
        return examScores;
    }
}
