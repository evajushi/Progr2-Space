import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;

public class sqlConnect {
    private String path = "jdbc:mysql://sql7.freesqldatabase.com:3306/sql7755696";
    private String username = "sql7755696";
    private String password = "tGKZtBXEFM"; 

    public void makeConnection(String path, String username, String password) {
        Connection myCon = DriverManager.getConnection(this.path, this.username, this.password);
    }

    public void insertPatient(String value1, String value2, String value3, Date value4, String value5, 
    String value6, String value7, String value8, String value9)/*skotoste me*/ {
        String sql = "INSERT INTO Patient(AMKA, Name, Surname, dateOfBirth, phoneNumber, address, email, medicalRecord, gender) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertStmt = myCon.prepareStatement(sql); //???
        /* " + value1 + "," + value2 + "," + value3 "," + value4 +
         "," value5 "," + value6 "," + value7 + "," + value8 + "," + value9 + ")" ) */
        insertStmt.setString(1, value1); 
        insertStmt.setString(2, value2); 
        insertStmt.setString(3, value3); 
        insertStmt.setDate(4, value4); 
        insertStmt.setString(5, value5); 
        insertStmt.setString(6, value6); 
        insertStmt.setString(7, value7); 
        insertStmt.setString(8, value8); 
        insertStmt.setString(9, value9); 
        insertStmt.executeUpdate();
       
    }

    public void insertAppointment(String val1, String val2, Date val3, Time val4, String val5) {
        String sql = "INSERT INTO Appointment(docCode, specialization, apptTime, apptDate, patientName) VALUES(?, ?, ?, ?, ?)";
        PreparedStatement insertStmt = myCon.prepareStatement(sql);
        insertStmt.setString(1, val1); 
        insertStmt.setString(2, val2); 
        insertStmt.setDate(3, val3); 
        insertStmt.setTime(4, val4); 
        insertStmt.setString(5, val5);
    }

    public void selectTD(String tableName) {
        PreparedStatement selectStmt = myCon.prepareStatement("SELECT * FROM" + tableName);
        selectStmt.executeQuery();
    }

    public void selectAMKA(String amkaString) {
        String sql = "SELECT * FROM Patient WHERE AMKA = " + amkaString;
        PreparedStatement selectStmt = myCon.prepareStatement(sql);
        selectStmt.execute();
    }
}
        
