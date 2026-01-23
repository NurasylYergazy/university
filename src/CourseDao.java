import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {

    public int insert(Course course) throws SQLException {
        String sql = "INSERT INTO uni_course(course_name, credits) VALUES (?, ?) RETURNING course_id";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, course.getName());
            ps.setInt(2, course.getCredits());
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt("course_id");
        }
    }

    public List<String> findAll() throws SQLException {
        String sql = "SELECT course_id, course_name, credits FROM uni_course ORDER BY course_id";
        List<String> res = new ArrayList<>();
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                res.add(rs.getInt("course_id") + " | " +
                        rs.getString("course_name") + " | " +
                        rs.getInt("credits"));
            }
        }
        return res;
    }

    public void updateCredits(int courseId, int newCredits) throws SQLException {
        String sql = "UPDATE uni_course SET credits=? WHERE course_id=?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, newCredits);
            ps.setInt(2, courseId);
            ps.executeUpdate();
        }
    }

    public void deleteById(int courseId) throws SQLException {
        String sql = "DELETE FROM uni_course WHERE course_id=?";
        try (Connection c = DB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, courseId);
            ps.executeUpdate();
        }
    }
}
