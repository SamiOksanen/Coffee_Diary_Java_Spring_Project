package fi.hh.coffeediary.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.hh.coffeediary.bean.Kahvi;

public class KahviRowMapper  implements RowMapper<Kahvi> {

	public Kahvi mapRow(ResultSet rs, int rowNum) throws SQLException {
		Kahvi k = new Kahvi();
		k.setMaara(rs.getInt("maara"));
		k.setPaiva(rs.getDate("paiva"));
		k.setId(rs.getInt("id"));
		
		return k;
	}

}
