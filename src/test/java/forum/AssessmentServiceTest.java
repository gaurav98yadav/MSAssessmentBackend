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

import com.accoflow.dao.AssessmentDAO;
import com.accoflow.models.Assessment;
import com.accoflow.services.AssessmentService;

public class AssessmentServiceTest {

	@InjectMocks
	AssessmentService assessmentService;
	@Mock
	AssessmentDAO assessmentDAO;
	
	
	 
	@Before
	public void beforeTrainerService() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void duplicacy() {
		
		Assessment assessment = new Assessment();
		assessment.setAssessment_type(1);
		when(assessmentDAO.checkDuplicates(assessment)).thenReturn(false);
		
		Assert.assertEquals(assessmentService.addAssessment(assessment), false);
		
	}
	
	@Test
	public void addAssessment() {
		
		Assessment assessment = new Assessment();
		assessment.setAssessment_type(1);
		when(assessmentDAO.checkDuplicates(assessment)).thenReturn(false);
		when(assessmentDAO.quiz(assessment)).thenReturn(false);
		
		Assert.assertEquals(assessmentService.addAssessment(assessment), false);
		
	}
	@Test
	public void addMCQ() {
		
		Assessment assessment = new Assessment();
		assessment.setAssessment_type(2);
		when(assessmentDAO.mcq(assessment)).thenReturn(false);
		
		Assert.assertEquals(assessmentService.addAssessment(assessment), false);
		
	}
	@Test
	public void addAssignment() {
		
		Assessment assessment = new Assessment();
		assessment.setAssessment_type(3);
		when(assessmentDAO.assignment(assessment)).thenReturn(false);
		
		Assert.assertEquals(assessmentService.addAssessment(assessment), false);
		
	}
	@Test
	public void addProject() {
		
		Assessment assessment = new Assessment();
		assessment.setAssessment_type(4);
		when(assessmentDAO.project(assessment)).thenReturn(false);
		
		Assert.assertEquals(assessmentService.addProject(assessment), false);
		
	}
	@Test
	public void displayQuestions() {
		
		Assessment assessment = new Assessment();
		List<Assessment>list = new ArrayList<>();
		list.add(assessment);
		when(assessmentDAO.fetchAssessments(anyInt())).thenReturn(list);
		
		Assert.assertEquals(assessmentService.displayAssessments(anyInt()),list);
		
	}
	@Test
	public void editAssessment() {
		
		Assessment assessment = new Assessment();
		assessment.setAssessment_type(4);
		when(assessmentDAO.editAssessment(assessment)).thenReturn("sucesss");
		
		Assert.assertEquals(assessmentService.editAssessment(assessment), "sucesss");
		
	}
	@Test
	public void editAssessment2() {
		
		Assessment assessment = new Assessment();
		assessment.setAssessment_type(1);
		when(assessmentDAO.editAssessment(assessment)).thenReturn("sucesss");
		
		Assert.assertEquals(assessmentService.editAssessment(assessment), "sucesss");
		
	}
	@Test
	public void deleteAssessment() {
		
		Assessment assessment = new Assessment();
		when(assessmentDAO.deleteAssessment(assessment)).thenReturn("sucesss");
		
		Assert.assertEquals(assessmentService.deleteAssessment(assessment), "sucesss");
		
	}
}
