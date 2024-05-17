package org.food.dosacloud;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcIngredientRepository implements IngredientRepository  {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findALl() {
        return jdbcTemplate.query("select id,name, type from Ingredient", this::mapRowToIngredient) ;
    }

    @Override
    public Ingredient findById(String id) {
         return jdbcTemplate.queryForObject(
                "select id, name, type from Ingredient where id=?", new RowMapper<Ingredient>() {
                    @Override
                    public Ingredient mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new Ingredient(
                                rs.getString("id"),
                                rs.getString("name"),
                                Ingredient.Type.valueOf(rs.getString("type"))
                        );
                    }
                }, id
        );

    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
                "insert into Ingredient (id, name, type) values (?,?,?)",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString()
        );
        return ingredient;
    }


    private Ingredient mapRowToIngredient(ResultSet resultSet, int rowNum) throws SQLException {
        return new Ingredient(
                resultSet.getString("id"),
                resultSet.getString("name"),
                Ingredient.Type.valueOf(resultSet.getString("type"))
        );
    }
}
