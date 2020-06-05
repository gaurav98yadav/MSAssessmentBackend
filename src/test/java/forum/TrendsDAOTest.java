package forum;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
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

import com.accoflow.dao.TrendsDAO;
import com.accoflow.dto.Course;
import com.accoflow.dto.Location;
import com.accoflow.dto.Year;
import com.accoflow.models.Trends;

public class TrendsDAOTest {
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
	private TrendsDAO trendsDAO;
	
	@Before
	public void beforeTrainerService() {

		MockitoAnnotations.initMocks(this);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void displayTrends() {
		Course c = new Course();
		List<Course>list= new ArrayList<>();
		list.add(c);
		Location l = new Location();
		List<Location>list2= new ArrayList<>();
		list2.add(l);
		Year y = new Year();
		List<Year>list3= new ArrayList<>();
		list3.add(y);
		when(jdbcTemplate.query(anyString(),any(RowMapper.class))).thenReturn(list);
		when(jdbcTemplate.query(anyString(),any(RowMapper.class))).thenReturn(list2);
		when(jdbcTemplate.query(anyString(),any(RowMapper.class))).thenReturn(list3);
		Trends t = new Trends();
		t.setCourses(list);
		t.setLocations(list2);
		t.setYears(list3);
		Assert.assertNotNull(trendsDAO.displayTrends());
	}

}
