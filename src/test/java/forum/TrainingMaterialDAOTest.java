package forum;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.Blob;
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
import org.springframework.web.multipart.MultipartFile;

import com.accoflow.dao.TrainingMaterialDAO;
import com.accoflow.models.TrainingMaterial;

public class TrainingMaterialDAOTest {
	
	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
	private TrainingMaterialDAO trainingMaterialDAO;
	
	@Before
	public void beforeTrainerService() {

		MockitoAnnotations.initMocks(this);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void displayGrads() {
		TrainingMaterial trainingMaterial = new TrainingMaterial();
		List<TrainingMaterial> list = new ArrayList<>();
		list.add(trainingMaterial);
		when(jdbcTemplate.query(anyString(),any(RowMapper.class))).thenReturn(list);
		Assert.assertEquals(list,trainingMaterialDAO.getFiles());
	}
	@Test
	public void addFiles() {
		Blob blob = null;
		MultipartFile[] filesArr = null;
		int trainerId = 0;
		when(jdbcTemplate.update("h1",1,blob,"h1","h1")).thenReturn(1);
		Assert.assertEquals("success",trainingMaterialDAO.addFiles(filesArr,trainerId));
	}
	@Test
	public void delete() {
		when(jdbcTemplate.update("h1",1)).thenReturn(1);
		Assert.assertEquals("sucess",trainingMaterialDAO.deleteFiles(1));
	}

}
