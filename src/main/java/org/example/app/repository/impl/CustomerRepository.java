package org.example.app.repository.impl;

import org.example.app.domain.customer.Customer;
import org.example.app.domain.customer.CustomerMapper;
import org.example.app.repository.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository implements AppRepository<Customer> {

    NamedParameterJdbcTemplate template;

    @Autowired
    public CustomerRepository(DataSource dataSource) {
        template = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public boolean create(Customer customer) {
        String sql = "INSERT INTO customers (name, phone, address) VALUES (:name, :phone, :address)";
        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("name", customer.getName())
                .addValue("phone", customer.getPhone())
                .addValue("address", customer.getAddress());
        return template.update(sql, paramSource) > 0;
    }

    @Override
    public Optional<List<Customer>> fetchAll() {
        String sql = "SELECT * FROM customers";
        Optional<List<Customer>> optional;
        try {
            optional = Optional.of(template.query(sql, new CustomerMapper()));
        } catch (Exception ex) {
            optional = Optional.empty();
        }
        return optional;
    }

    @Override
    public Optional<Customer> fetchById(Long id) {
        String sql = "SELECT * FROM customers WHERE id = :id LIMIT 1";
        SqlParameterSource paramSource = new MapSqlParameterSource("id", id);
        Optional<Customer> optional;
        try {
            optional = Optional.ofNullable(template.queryForObject(sql, paramSource, new CustomerMapper()));
        } catch (Exception e) {
            optional = Optional.empty();
        }
        return optional;
    }

    @Override
    public boolean update(Long id, Customer customer) {
        String sql = "UPDATE customers SET name = :name, phone = :phone, address = :address WHERE id = :id";
        SqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("name", customer.getName())
                .addValue("phone", customer.getPhone())
                .addValue("address", customer.getAddress())
                .addValue("id", id);
        return template.update(sql, paramSource) > 0;
    }

    @Override
    public boolean delete(Long id) {
        String sql = "DELETE FROM customers WHERE id = :id";
        SqlParameterSource paramSource = new MapSqlParameterSource("id", id);
        return template.update(sql, paramSource) > 0;
    }

    public Optional<Customer> getLastEntity() {
        String sql = "SELECT * FROM customers ORDER BY id DESC LIMIT 1";
        SqlParameterSource paramSource = new MapSqlParameterSource();
        Optional<Customer> optional;
        try {
            optional = Optional.ofNullable(template.queryForObject(sql, paramSource, new CustomerMapper()));
        } catch (Exception e) {
            optional = Optional.empty();
        }
        return optional;
    }
}
