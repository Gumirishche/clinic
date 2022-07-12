package db;
import java.sql.*;
import java.time.LocalDate;

public class DB {
    public void createDoctor(String name) throws SQLException {
        String sql = "INSERT INTO doctor(name) VALUES(?)";

        PreparedStatement prSt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Clinic", "postgres", "123").prepareStatement(sql);
        prSt.setString(1, name);
        System.out.println(prSt);

        prSt.executeUpdate();
    }
    public void createPatient(String name) throws SQLException {
        String sql = "INSERT INTO patient(name,date) VALUES(?,?)";

        PreparedStatement prSt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Clinic", "postgres", "123").prepareStatement(sql);
        prSt.setString(1, name);
        prSt.setString(2, LocalDate.now().toString());
        System.out.println(prSt);

        prSt.executeUpdate();
    }

    public void createAppointment(int idDoctor,int idPatient, String date) throws SQLException {
        String sql = "INSERT INTO ap(idDoctor,idPatient,date,status) VALUES(?,?,?,?)";

        PreparedStatement prSt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Clinic", "postgres", "123").prepareStatement(sql);
        prSt.setInt(1, idDoctor);
        prSt.setInt(2, idPatient);
        prSt.setString(3, date);
        prSt.setString(4,"NEW");
        System.out.println(prSt);

        prSt.executeUpdate();
    }
    public void deletePatient(int id) throws SQLException {
        String sql = "DELETE FROM patient WHERE id = ?";

        PreparedStatement prSt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Clinic", "postgres", "123").prepareStatement(sql);
        prSt.setInt(1, id);
        System.out.println(prSt);

        prSt.executeUpdate();
    }
    public void deleteDoctor(int id) throws SQLException {
        String sql = "DELETE FROM doctor WHERE id = ?";

        PreparedStatement prSt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Clinic", "postgres", "123").prepareStatement(sql);
        prSt.setInt(1, id);
        System.out.println(prSt);

        prSt.executeUpdate();
    }

    public void deleteAppointment(int idDoctor,int idPatient) throws SQLException {
        String sql = "DELETE FROM ap WHERE idDoctor = ? AND idPatient = ?";

        PreparedStatement prSt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Clinic", "postgres", "123").prepareStatement(sql);
        prSt.setInt(1, idDoctor);
        prSt.setInt(2, idPatient);
        System.out.println(prSt);

        prSt.executeUpdate();
    }

    public void getDoctor() throws SQLException {
        String sql = "SELECT * FROM doctor ORDER BY id DESC";
        Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Clinic", "postgres", "123").createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            System.out.println("id: "+res.getString("id")+"  "+"name: "+res.getString("name"));
        }
    }
    public void getPatient() throws SQLException {
        String sql = "SELECT * FROM patient ORDER BY id DESC";
        Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Clinic", "postgres", "123").createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            System.out.println("id: "+res.getString("id")+"  "+"name: "+res.getString("name")+"  "+"date: "+res.getString("date"));
        }
    }

    public void getAppointment(int idPatient) throws SQLException {
        String sql = "SELECT * FROM ap where idPatient = "+idPatient;
        Statement statement = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Clinic", "postgres", "123").createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            System.out.println("idDoctor: "+res.getString("idDoctor")+"  "+"idPatient: "+res.getString("idPatient")+"  "+"date: "+res.getString("date")+"  "+"status: "+res.getString("status"));
        }
    }
    public void updatePatient(String id,String name) throws SQLException {
        String sql = "UPDATE patient SET name = ? WHERE id = "+ id;
        PreparedStatement prSt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Clinic", "postgres", "123").prepareStatement(sql);
        prSt.setString(1, name);
        System.out.println(prSt);

        prSt.executeUpdate();
    }

    public void updateAppointment(String idDoctor,String idPatient, String status) throws SQLException {
        String sql = "UPDATE ap SET status = ? WHERE idDoctor = "+ idDoctor +"AND idPatient = "+idPatient;
        PreparedStatement prSt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Clinic", "postgres", "123").prepareStatement(sql);
        prSt.setString(1, status);
        System.out.println(prSt);

        prSt.executeUpdate();
    }
}
