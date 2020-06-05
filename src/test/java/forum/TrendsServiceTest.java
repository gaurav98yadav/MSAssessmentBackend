package forum;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.accoflow.dao.TrendsDAO;
import com.accoflow.models.Trends;
import com.accoflow.services.TrendsService;

public class TrendsServiceTest {
	
	@InjectMocks
	TrendsService trendsService;
	@Mock
	TrendsDAO trendsDAO;
	
	 
	@Before
	public void beforeTrainerService() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void viewTrends() {
		
		Trends trend = new Trends();	
		when(trendsDAO.displayTrends()).thenReturn(trend);
		
		Assert.assertEquals(trendsService.displayTrends(),trend);
		
	}

}
