package forum;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.accoflow.constants.Queries;
import com.accoflow.dao.AssessmentDAO;
import com.accoflow.models.Assessment;

public class AssessmentDAOTest {


		@Mock
		private JdbcTemplate jdbcTemplate;
		
		@InjectMocks
		private AssessmentDAO assessmentDAO;
	
		Assessment ass = new Assessment(1,1, 1, 1, "wow", "wow", "wow", 1, 1, 1, 1, "wow");
		Integer n=45;
		List<Assessment>list = new ArrayList<>();
		
		@Before
		public void beforeTrainerService() {
			ass.setAssessment_type(1);
			ass.setFinal_marks(100);
			ass.setTrainer_feedback("wow");
			ass.setTrainer_id(1);
			ass.setGrad_id(1);
			ass.setCourse("wow");
			ass.setTest_name("wow");
			list.add(ass);
			MockitoAnnotations.initMocks(this);
		}
		
		@Test
		public void quiz() {
		

			when(jdbcTemplate.update(Queries.INSERT_ASSSESSMENT,1,1,1,"wow",1,"wow","wow")).thenReturn(1);
			int totalQuiz=1;
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(totalQuiz);
			when(jdbcTemplate.update("hi",1,2,3)).thenReturn(1);
			ass.setGrad_id(1);
			Assert.assertEquals(true,assessmentDAO.quiz(ass));
		}
		@Test
		public void quiz3() {
		

			when(jdbcTemplate.update(Queries.INSERT_ASSSESSMENT,1,1,1,"wow",1,"wow","wow")).thenReturn(1);
			int totalQuiz=0;
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(totalQuiz);
			when(jdbcTemplate.update("hi",1,2,3)).thenReturn(1);
			ass.setGrad_id(1);
			Assert.assertEquals(true,assessmentDAO.quiz(ass));
		}
		@Test
		public void quiz4() {
		

			when(jdbcTemplate.update(Queries.INSERT_ASSSESSMENT,1,1,1,"wow",1,"wow","wow")).thenReturn(1);
			int totalMCQ=0;
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(totalMCQ);
			when(jdbcTemplate.update("hi",1,2,3)).thenReturn(1);
			ass.setGrad_id(1);
			Assert.assertEquals(true,assessmentDAO.mcq(ass));
		}
		@Test
		public void quiz5() {
		

			when(jdbcTemplate.update(Queries.INSERT_ASSSESSMENT,1,1,1,"wow",1,"wow","wow")).thenReturn(1);
			int totalMCQ=1;
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(totalMCQ);
			when(jdbcTemplate.update("hi",1,2,3)).thenReturn(1);
			ass.setGrad_id(1);
			Assert.assertEquals(true,assessmentDAO.mcq(ass));
		}
		@Test
		public void quiz6() {
		

			when(jdbcTemplate.update(Queries.INSERT_ASSSESSMENT,1,1,1,"wow",1,"wow","wow")).thenReturn(1);
			int totalQuiz=0;
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(totalQuiz);
			when(jdbcTemplate.update("hi",1,2,3)).thenReturn(1);
			ass.setGrad_id(1);
			Assert.assertEquals(true,assessmentDAO.assignment(ass));
		}
		@Test
		public void quiz7() {
		

			when(jdbcTemplate.update(Queries.INSERT_ASSSESSMENT,1,1,1,"wow",1,"wow","wow")).thenReturn(1);
			int totalQuiz=1;
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(totalQuiz);
			when(jdbcTemplate.update("hi",1,2,3)).thenReturn(1);
			ass.setGrad_id(1);
			Assert.assertEquals(true,assessmentDAO.assignment(ass));
		}
		@Test
		public void quiz8() {
			
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(1);
			when(jdbcTemplate.update(Queries.INSERT_ASSSESSMENT,1,1,1,"wow",1,"wow","wow")).thenReturn(1);
			int totalQuiz=0;
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(totalQuiz);
			when(jdbcTemplate.update("hi",1,2,3)).thenReturn(1);
			when(jdbcTemplate.update(Queries.INSERT_ASSSESSMENT,1,1,1,1)).thenReturn(1);
			ass.setGrad_id(1);
			Assert.assertEquals(true,assessmentDAO.project(ass));
		}
		@Test
		public void quiz9() {
		
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(1);
			when(jdbcTemplate.update(Queries.INSERT_ASSSESSMENT,1,1,1,"wow",1,"wow","wow")).thenReturn(1);
			int totalQuiz=1;
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(totalQuiz);
			when(jdbcTemplate.update("hi",1,2,3)).thenReturn(1);
			when(jdbcTemplate.update(Queries.INSERT_ASSSESSMENT,1,1,1,1)).thenReturn(1);
			ass.setGrad_id(1);
			Assert.assertEquals(true,assessmentDAO.project(ass));
		}
		@SuppressWarnings("unchecked")
		@Test
		public void quiz10() {
			ass.setAssessment_type(1);
			int old_marks=10;
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.update("h1",1,2)).thenReturn(1);
			Assert.assertEquals("snvcd",assessmentDAO.editAssessment(ass));

		}
		@Test
		public void quiz11() {
			ass.setAssessment_type(2);
			int old_marks=10;
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.update("h1",1,2)).thenReturn(1);
			Assert.assertEquals("success",assessmentDAO.editAssessment(ass));

		}
		@Test
		public void quiz12() {
			ass.setAssessment_type(3);
			int old_marks=10;
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.update("h1",1,2)).thenReturn(1);
			Assert.assertEquals("success",assessmentDAO.editAssessment(ass));
		}
		@Test
		public void quiz13() {
			ass.setAssessment_type(4);
			int old_marks=10;
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.update("h1",1,2)).thenReturn(1);
			when(jdbcTemplate.update("h1",1,2,3,4)).thenReturn(1);
			Assert.assertEquals("success",assessmentDAO.editAssessment(ass));
		}
		@Test
		public void quiz14() {
			ass.setAssessment_type(5);
			int old_marks=10;
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.update("h1",1,2)).thenReturn(1);
			Assert.assertEquals("fail",assessmentDAO.editAssessment(ass));
		}
		@Test
		public void quiz15() {
			ass.setAssessment_type(1);
			int old_marks=10;
			when(jdbcTemplate.update("h1",1)).thenReturn(1);
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.update("h1",1,2,3)).thenReturn(1);
			Assert.assertEquals("success",assessmentDAO.deleteAssessment(ass));
		}
		@Test
		public void quiz17() {
			ass.setAssessment_type(2);
			int old_marks=10;
			when(jdbcTemplate.update("h1",1)).thenReturn(1);
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.update("h1",1,2,3)).thenReturn(1);
			Assert.assertEquals("success",assessmentDAO.deleteAssessment(ass));
		}
		@Test
		public void quiz16() {
			ass.setAssessment_type(3);
			int old_marks=10;
			when(jdbcTemplate.update("h1",1)).thenReturn(1);
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.update("h1",1,2,3)).thenReturn(1);
			Assert.assertEquals("success",assessmentDAO.deleteAssessment(ass));
		}
		@Test
		public void quiz18() {
			ass.setAssessment_type(4);
			int old_marks=10;
			when(jdbcTemplate.update("h1",1)).thenReturn(1);
			when(jdbcTemplate.update("h1",1)).thenReturn(1);
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(old_marks);
			when(jdbcTemplate.update("h1",1,2,3)).thenReturn(1);
			Assert.assertEquals("success",assessmentDAO.deleteAssessment(ass));
		}
		@Test
		public void quiz19() {
			ass.setAssessment_type(5);
			int old_marks=10;
			when(jdbcTemplate.update("h1",1)).thenReturn(1);
			Assert.assertEquals("fail",assessmentDAO.deleteAssessment(ass));
		}
		@Test
		public void quiz20() {
			when(jdbcTemplate.query(anyString(),new Object[] {anyInt()},any(RowMapper.class))).thenReturn(list);
			Assert.assertEquals(list,assessmentDAO.fetchAssessments(1));
		}
		@Test
		public void quiz21() {
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenReturn(1);
			Assert.assertEquals(false,assessmentDAO.checkDuplicates(ass));
		}
		@Test(expected=EmptyResultDataAccessException.class)
		public void quiz22() {
			when(jdbcTemplate.queryForObject(anyString(),anyObject(), eq(Integer.class))).thenThrow(new EmptyResultDataAccessException(0));
			Assert.assertEquals(true,assessmentDAO.checkDuplicates(ass));
		}
		
		
		

		
}
