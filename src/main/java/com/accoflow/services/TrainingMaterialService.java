package com.accoflow.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.accoflow.dao.TrainingMaterialDAO;
import com.accoflow.models.TrainingMaterial;

@Service
public class TrainingMaterialService {

	@Autowired
	TrainingMaterialDAO trainingMaterialDAO;
	
	public String addFiles(MultipartFile[] filesArr,int trainerId) {
		return trainingMaterialDAO.addFiles(filesArr,trainerId);
	}
	
	public String editFiles(MultipartFile[] filesArr,int fileId) {
		return trainingMaterialDAO.editFiles(filesArr,fileId);
	}
	
	public String deleteFiles(int fileId) {
		return trainingMaterialDAO.deleteFiles(fileId);
	}
	
	
	public List<TrainingMaterial> getFiles() {
		return trainingMaterialDAO.getFiles();
	}
}
