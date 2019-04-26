package com.dao;

import com.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class StudentDaoImp implements StudentDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*public StudentDaoImp(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }*/

    public StudentDaoImp() {

    }


    @Override
    public int create(Student student) {
        String sql = "insert into student (name,email,courses) values (?,?,?)";
        try {
            int counter = jdbcTemplate.update(sql, student.getName(), student.getEmail(), student.getCourse());
            System.out.println("Create success");

            return counter;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Student> read() {
        String sql = "SELECT * FROM student";
        List<Student> studentList = jdbcTemplate.query(sql, new RowMapper<Student>() {

            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("courses"));

                return student;
            }

        });

        return studentList;
    }

    @Override
    public Student findStudentById(int id) {
        String sql = "select * from student where id = ?";
        List<Student> students = jdbcTemplate.query(sql, new Object[] { id }, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("courses"));
                return student;
            }
        });
        return students.get(0);
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "update student set name =?, email=?, courses =? where id =?";
        try {
            int counter = jdbcTemplate.update(sql, student.getName(), student.getEmail(), student.getCourse(),student.getId());
            System.out.println("Update success");

            return counter;
        }catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int deleteStudent(int id) {
        String sql = "delete from student where id = ?";
        try {
            return jdbcTemplate.update(sql,id);

        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

}
