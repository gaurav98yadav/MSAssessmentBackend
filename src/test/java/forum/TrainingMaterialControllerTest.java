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
import org.springframework.web.multipart.MultipartFile;

import com.accoflow.controller.TrainingMaterialController;
import com.accoflow.models.TrainingMaterial;
import com.accoflow.services.TrainingMaterialService;

public class TrainingMaterialControllerTest {
	
	@InjectMocks
	TrainingMaterialController trainingMaterialService;
	@Mock
	TrainingMaterialService trainingMaterialDAO;
	
	
	 
	@Before
	public void beforeTrainerService() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void addFile() {
		
		MultipartFile[] files = new MultipartFile[10];
		when(trainingMaterialDAO.addFiles(files,1)).thenReturn("success");
			Assert.assertEquals(trainingMaterialService.addFiles(files,1), "success");
	}
	@Test
	public void getFiles() {
		
		TrainingMaterial trainingmaterial = new TrainingMaterial();
		List<TrainingMaterial>list = new ArrayList<>();
		list.add(trainingmaterial);
		when(trainingMaterialDAO.getFiles()).thenReturn(list);
		
		Assert.assertEquals(trainingMaterialService.getFiles(), list);
		
	}
	@Test
	public void getFiles2() {
		
		MultipartFile[] files = new MultipartFile[10];
		when(trainingMaterialDAO.editFiles(files,1)).thenReturn("success");
			Assert.assertEquals(trainingMaterialService.editFiles(files,1), "success");
				
	}
	@Test
	public void delete() {
		
		when(trainingMaterialDAO.deleteFiles(1)).thenReturn("success");
			Assert.assertEquals(trainingMaterialService.deleteFiles(1), "success");
				
	}
}
