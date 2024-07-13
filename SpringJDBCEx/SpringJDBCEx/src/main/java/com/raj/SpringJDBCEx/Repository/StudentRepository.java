package com.raj.SpringJDBCEx.Repository;

import com.raj.SpringJDBCEx.Model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Students s) {
        String sql ="Insert into Students values(?,?,?)";
        int res=jdbc.update(sql,s.getRollNo(),s.getName(),s.getMarks());
        System.out.println(res +"Updated");
    }


    public List<Students> findAll() {

        String query ="Select * from Students";
        List<Students> students = jdbc.query(query,(rs,rowNum)-> {
            Students s = new Students();
            s.setRollNo(rs.getInt("RollNo"));
            s.setName(rs.getString("Name"));
            s.setMarks(rs.getInt("marks"));
            return s;
        });

        return students;
    }
}
