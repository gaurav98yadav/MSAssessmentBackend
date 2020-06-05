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

import com.accoflow.controller.TrendsController;
import com.accoflow.models.Grad;
import com.accoflow.models.Trends;
import com.accoflow.services.TrendsService;

public class TrendsControllerTest {
	
	@InjectMocks
	TrendsController trendsController;
	@Mock
	TrendsService trendsService;
	
	 
	@Before
	public void beforeTrainerService() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void viewTrends() {
		
		Trends trend = new Trends();	
		when(trendsService.displayTrends()).thenReturn(trend);
		
		Assert.assertEquals(trendsController.displayTrends(),trend);
		
	}

}
