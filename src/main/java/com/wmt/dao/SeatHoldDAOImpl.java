package com.wmt.dao;

/*import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;*/

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.wmt.model.SeatHold;
import com.wmt.model.Seats;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SeatHoldDAOImpl implements SeatHoldDAO {

	private JdbcTemplate jdbcTemplate;

	public SeatHoldDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int numSeatsAvailable() {
		String sql = "select count(*) from seats where (DATEDIFF('second', lastheldtime, CURRENT_TIMESTAMP())-900>0 OR status=0)";
		int total = this.jdbcTemplate.queryForObject(sql, Integer.class);
		return total;
	}

	@Transactional
	@Override
	public SeatHold findAndHoldSeats(int numSeats, final String customerEmail) {

		// Sequence-1 : Find available seats or expired on-hold seats
		String sqlSelect = "select seatid, rownumber, seatnumber, description from seats "
				+ "where status=0 OR ((DATEDIFF('second',lastheldtime ,  CURRENT_TIMESTAMP())-900 >0) "
				+ "AND status = 1) order by rownumber, seatnumber limit ?";
		
		List<Seats> seats = this.jdbcTemplate.query(sqlSelect,
				new Object[] { numSeats }, new RowMapper<Seats>() {
					public Seats mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						Seats seat = new Seats();
						seat.setSeatId(rs.getLong("seatid"));
						seat.setRowNumber(rs.getInt("rownumber"));
						seat.setSeatNumber(rs.getInt("seatnumber"));
						seat.setDescription(rs.getString("description"));
						return seat;
					}
				});

		// Sequence-2 : Add customerEmail to SeatHold
		String sqlInsertSeatHold = "insert into seathold(email) values(?)";
		this.jdbcTemplate.update(sqlInsertSeatHold, customerEmail);

		// Sequence-3 : Find seatHoldId for the customer //TODO
		String sqlSelectSeatHold = "select max(seatholdid) from seathold where email=?";
		Long seatHoldId = this.jdbcTemplate.queryForObject(sqlSelectSeatHold,
				new Object[] { customerEmail }, Long.class);

		// Sequence-4 : Hold seats for customer
		String sqlUpdateSeats = "update seats set status=1, lastheldtime=CURRENT_TIMESTAMP, seatholdid=? "
				+ "where seatid=?";

		for (Seats seat : seats) {
			this.jdbcTemplate.update(sqlUpdateSeats, seatHoldId,
					seat.getSeatId());
		}
		return new SeatHold(seatHoldId, customerEmail, seats);
	}

	@Transactional
	@Override
	public int reserveSeats(int seatHoldId, String customerEmail) {
		String sql = "update seats set status=2 where (DATEDIFF('second',lastheldtime, CURRENT_TIMESTAMP())-900 <0) AND status = 1 AND seatholdId=?";
		this.jdbcTemplate.update(sql, seatHoldId);
		return seatHoldId;
	}

}
