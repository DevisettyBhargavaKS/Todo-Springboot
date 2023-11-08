package com.codewithbhargav.Spring.repository;

import com.codewithbhargav.Spring.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin
@Repository
public class TodoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Todo> findall() {
        return jdbcTemplate.query("select * from todo", new BeanPropertyRowMapper<>(Todo.class));
    }

    public List<Todo> insert(Todo todo) {
         jdbcTemplate.update("insert into todo(id,name,gender) values(?,?,?);",new Object[]{todo.getId(),todo.getName(),todo.getGender()});
         return findall();

    }

    public List<Todo> update(Todo todo) {
        jdbcTemplate.update("update todo set name=?,gender=? where id=?;",new Object[]{todo.getName(),todo.getGender(),todo.getId()});
        return findall();

    }

    public List<Todo> deleteById(int id) {
        jdbcTemplate.update("delete from todo where id=?;",new Object[]{id});
        return findall();

    }
}
