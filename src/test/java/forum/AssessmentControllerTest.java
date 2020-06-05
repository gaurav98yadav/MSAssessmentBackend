package forum;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.accoflow.controller.AssessmentController;
import com.accoflow.models.Assessment;
import com.accoflow.services.AssessmentService;

public class AssessmentControllerTest {
	
	@InjectMocks
	AssessmentController assessmentService;
	@Mock
	AssessmentService assessmentDAO;
	
	
	 
	@Before
	public void beforeTrainerService() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addAssessment() {
		
		Assessment assessment = new Assessment();
		when(assessmentDAO.addAssessment(assessment)).thenReturn(true);
		
		Assert.assertEquals(assessmentService.addAssessment(assessment), true);
		
	}
	@Test
	public void addProject() {
		
		Assessment assessment = new Assessment();
		when(assessmentDAO.addProject(assessment)).thenReturn(true);
		
		Assert.assertEquals(assessmentService.addProject(assessment), true);
		
	}
	@Test
	public void displayQuestions() {
		
		Assessment assessment = new Assessment();
		List<Assessment>list = new ArrayList<>();
		list.add(assessment);
		when(assessmentDAO.displayAssessments(anyInt())).thenReturn(list);
		
		Assert.assertEquals(assessmentService.displayQuestions(anyInt()),list);
		
	}
	@Test
	public void editAssessment() {
		
		Assessment assessment = new Assessment();
		when(assessmentDAO.editAssessment(assessment)).thenReturn("sucesss");
		
		Assert.assertEquals(assessmentService.editAssessment(assessment), "sucesss");
		
	}
	@Test
	public void deleteAssessment() {
		
		Assessment assessment = new Assessment();
		when(assessmentDAO.deleteAssessment(assessment)).thenReturn("success");
		
		Assert.assertEquals(assessmentService.deleteAssessment(assessment), "success");
		
	}


}
