import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public int insert(Student student, int uniId) throws SQLException {
        String sql = "INSERT INTO uni_student(full_name, study_year, uni_id) VALUES (?, ?, ?) RETURNING student_id";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, student.getFullName());
            ps.setInt(2, student.getYear());
            ps.setInt(3, uniId);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt("student_id");
        }
    }

    public List<String> findAll() throws SQLException {
        String sql = "SELECT student_id, full_name, study_year, uni_id FROM uni_student ORDER BY student_id";
        List<String> res = new ArrayList<>();
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                res.add(rs.getInt("student_id") + " | " +
                        rs.getString("full_name") + " | " +
                        rs.getInt("study_year") + " | uni_id=" +
                        rs.getInt("uni_id"));
            }
        }
        return res;
    }

    public void updateYear(int studentId, int newYear) throws SQLException {
        String sql = "UPDATE uni_student SET study_year=? WHERE student_id=?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, newYear);
            ps.setInt(2, studentId);
            ps.executeUpdate();
        }
    }

    public void deleteById(int studentId) throws SQLException {
        String sql = "DELETE FROM uni_student WHERE student_id=?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.executeUpdate();
        }
    }
}
