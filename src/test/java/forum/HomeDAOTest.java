package forum;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.accoflow.constants.Queries;
import com.accoflow.dao.HomeDAO;
import com.accoflow.models.Grad;

@RunWith(MockitoJUnitRunner.class)
public class HomeDAOTest {
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
	private HomeDAO homeDAO;
	
	@Before
	public void beforeTrainerService() {

		MockitoAnnotations.initMocks(this);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void displayGrads() {
		Grad grad = new Grad();
		grad.setAssignment_marks(100);
		grad.setGrad_id(1);
		grad.setGrad_college("SPIT");
		grad.setGrad_name("GMY");
		grad.setGrad_location("Mumbai");
		grad.setGrad_year(2011);
		grad.setTotal_marks(100);
		grad.setQuiz_marks(100);
		grad.setProject_marks(100);
		grad.setMcq_marks(100);
		List<Grad> list = new ArrayList<>();
		list.add(grad);
		when(jdbcTemplate.query(anyString(),any(RowMapper.class))).thenReturn(list);
		System.out.println(homeDAO.displayGrads());
		Assert.assertEquals(list,homeDAO.displayGrads());
	}

}
