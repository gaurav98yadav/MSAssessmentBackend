package forum;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.accoflow.constants.Queries;
import com.accoflow.dao.TrainerDAO;
import com.accoflow.models.Trainer;

public class TrainerDAOTest {
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
	private TrainerDAO trainerDAO;
	
	@Before
	public void beforeTrainerService() {

		MockitoAnnotations.initMocks(this);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void addTrainer() {
		Trainer t = new Trainer();
		List<Trainer>list = new ArrayList<>();
		when(jdbcTemplate.query(anyString(),new Object[] {anyInt()}, any(RowMapper.class))).thenReturn(list);
		when(jdbcTemplate.update(anyString(),anyString(),anyString(),anyString())).thenReturn(1);
		when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(1);
		Assert.assertEquals(1,trainerDAO.addTrainer(t));
	}
	@SuppressWarnings("unchecked")
	@Test
	public void addTrainer2() {
		Trainer t = new Trainer();
		List<Trainer>list = new ArrayList<>();
		t.setTrainer_id(1);
		list.add(t);
		when(jdbcTemplate.query(anyString(),new Object[] {anyInt()}, any(RowMapper.class))).thenReturn(list);
		Assert.assertEquals(1,trainerDAO.addTrainer(t));
	}

}
