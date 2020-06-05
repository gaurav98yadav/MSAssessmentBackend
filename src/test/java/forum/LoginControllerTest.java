package forum;
import static org.mockito.Mockito.when;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.accoflow.controller.LoginController;
import com.accoflow.models.Trainer;
import com.accoflow.services.TrainerService;

public class LoginControllerTest {
	
	@InjectMocks
	LoginController trainerService;
	@Mock
	TrainerService trainerDAO;
	
	
	 
	@Before
	public void beforeTrainerService() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addTrainer() {
		
		int a=1;
		
		
		Trainer trainer = new Trainer();
		trainer.setTrainer_id(1);
		trainer.setTrainer_email("blah");
		trainer.setTrainer_name("abdul");
		
		when(trainerDAO.addTrainer(trainer)).thenReturn(a);
		
		Assert.assertEquals(trainerService.addEmployee(trainer), a);
		
	}

}
