package forum;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.accoflow.dao.HomeDAO;
import com.accoflow.dto.Scorecard;
import com.accoflow.models.Grad;
import com.accoflow.services.HomeService;

public class HomeServiceTest {
	
	@InjectMocks
	HomeService homeService;
	@Mock
	HomeDAO homeDAO;
	
	 
	@Before
	public void beforeTrainerService() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void displayGrads() {
		
		Grad grad = new Grad();
		List<Grad> list = new ArrayList<>();
		list.add(grad);

		
		when(homeDAO.displayGrads()).thenReturn(list);
		
		Assert.assertEquals(homeService.displayGrads(),list);
		
	}
	@Test
	public void profile()
	{
		Scorecard sc = new Scorecard();
		when(homeDAO.profile(1)).thenReturn(sc);
		Assert.assertEquals(sc, homeService.profile(1));
	}

}
