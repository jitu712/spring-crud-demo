package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("postgresqlDAO")
public class PersonDataAccessService implements PersonDAO {

	private final JdbcTemplate jdbcTemplate;

	public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertPerson(UUID id, Person person) {
		return 0;
	}

	@Override
	public List<Person> selectAllPerson() {
		final String psc = "SELECT id, name from person";
		return jdbcTemplate.query(psc, (resultSet, i) -> {
			UUID id = UUID.fromString(resultSet.getString("id"));
			String name = resultSet.getString("name");
			return new Person(id, name);
		});
		// return List.of(new Person(UUID.randomUUID(), "From postgreDB"));
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		return null;
	}

	@Override
	public int deletePersonById(UUID id) {
		return 0;
	}

	@Override
	public int updatePersonById(UUID id, Person person) {
		return 0;
	}

}
