package com.accoflow.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.accoflow.constants.Queries;
import com.accoflow.models.TrainingMaterial;
import com.accoflow.rowmapper.FilesMapper;

@Repository
public class TrainingMaterialDAO{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String addFiles(MultipartFile[] filesArr, int trainerId){
		for(MultipartFile file : filesArr) {
			byte[] bytes = null;
			try {
				bytes = file.getBytes();
			} catch (IOException e1) {
				return "fail";
			}
		    Blob blob = null;
			try {
				blob = new javax.sql.rowset.serial.SerialBlob(bytes);
			} catch (SerialException e) {
				return "fail";
			} catch (SQLException e) {
				return "fail";
			}
		    String sql = "Insert  into training_material (trainer_id,file,file_name,file_type) values(?,?,?,?)";
		   jdbcTemplate.update(sql, trainerId, blob, file.getOriginalFilename(), file.getContentType());
		}
	      return "success";
	}
	public String editFiles(MultipartFile[] filesArr, int fileId){
		for(MultipartFile file : filesArr) {
			byte[] bytes = null;
			try {
				bytes = file.getBytes();
			} catch (IOException e1) {
				return "fail";
			}
		    Blob blob = null;
			try {
				blob = new javax.sql.rowset.serial.SerialBlob(bytes);
			} catch (SerialException e) {
				return "fail";
			} catch (SQLException e) {
				return "fail";
			}
		    String sql = "update training_material set file=?,file_name=?,file_type=? where file_id=?";
		   jdbcTemplate.update(sql, blob, file.getOriginalFilename(), file.getContentType(), fileId);
		}
	      return "success";
	}
	public String deleteFiles(int fileId){
		
		String sql = "Delete from training_material where file_id=?";
		jdbcTemplate.update(sql,fileId);
		return "success";
	}

	public List<TrainingMaterial> getFiles() {
		return jdbcTemplate.query(Queries.GET_FILES, new FilesMapper());
	}
}
