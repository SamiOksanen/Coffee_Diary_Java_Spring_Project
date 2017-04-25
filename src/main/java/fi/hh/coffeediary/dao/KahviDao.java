package fi.hh.coffeediary.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.hh.coffeediary.bean.Kahvi;
import fi.hh.coffeediary.dao.KahviRowMapper;
import fi.hh.coffeediary.dao.KahviaEiLoydyPoikkeus;

@Repository
public class KahviDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void talleta(Kahvi k) {
		final String sql = "INSERT INTO kahvi(maara, paiva) VALUES(?,?)";

		// anonyymi sis‰luokka tarvitsee vakioina v‰litett‰v‰t arvot,
		// jotta roskien keruu onnistuu t‰m‰n metodin suorituksen p‰‰ttyess‰.
		final int maara = k.getMaara();
		final Date paiva = k.getPaiva();

		// jdbc pist‰‰ generoidun id:n t‰nne talteen
		KeyHolder idHolder = new GeneratedKeyHolder();

		// suoritetaan p‰ivitys itse m‰‰ritellyll‰ PreparedStatementCreatorilla
		// ja KeyHolderilla
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setInt(1, maara);
				ps.setDate(2, (java.sql.Date) paiva);
				return ps;
			}
		}, idHolder);

		// tallennetaan id takaisin beaniin, koska
		// kutsujalla pit‰isi olla viittaus samaiseen olioon
		k.setId(idHolder.getKey().intValue());

	}
	
	public Kahvi etsi(int id) {
		String sql = "SELECT maara, paiva, id FROM kahvi WHERE id = ?";
		Object[] parametrit = new Object[] { id };
		RowMapper<Kahvi> mapper = new KahviRowMapper();

		Kahvi k;
		try {
			k = jdbcTemplate.queryForObject(sql, parametrit, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new KahviaEiLoydyPoikkeus(e);
		}
		return k;

	}

	public List<Kahvi> haeKaikki() {

		String sql = "SELECT id, maara, paiva FROM kahvi";
		RowMapper<Kahvi> mapper = new KahviRowMapper();
		List<Kahvi> kahvit = jdbcTemplate.query(sql, mapper);

		return kahvit;
	}
}
