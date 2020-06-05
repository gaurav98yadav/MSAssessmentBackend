package com.accoflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.accoflow.models.TrainingMaterial;
import com.accoflow.services.TrainingMaterialService;

@RestController
@RequestMapping("/trainingMaterial")
public class TrainingMaterialController {

	@Autowired
	TrainingMaterialService trainingMaterialService;
	
	@PostMapping("/add")
	public String addFiles(@RequestParam("files[]") MultipartFile[] filesArr, @RequestParam("trainerId") int trainerId){
		return trainingMaterialService.addFiles(filesArr, trainerId);
	}
	
	@PostMapping("/edit")
	public String editFiles(@RequestParam("files[]") MultipartFile[] filesArr, @RequestParam("fileId") int fileId){
		return trainingMaterialService.editFiles(filesArr, fileId);
	}
	
	@PostMapping("/delete/{id}")
	public String deleteFiles(@PathVariable("id") int fileId){
		return trainingMaterialService.deleteFiles(fileId);
	}
		
	@GetMapping("/view")
	public List<TrainingMaterial> getFiles() {
		return trainingMaterialService.getFiles();
	}

}
