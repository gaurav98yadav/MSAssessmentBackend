package com.accoflow.rowmapper;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accoflow.models.TrainingMaterial;

public class FilesMapper implements RowMapper {
	

	@Override
	public TrainingMaterial mapRow(ResultSet rs, int rowNum) throws SQLException {
		        	
			TrainingMaterial trainingMaterial = new TrainingMaterial();
        	trainingMaterial.setFileId(rs.getInt("file_id"));
        	trainingMaterial.setTrainerId(rs.getInt("trainer_id"));
        	Blob blob = rs.getBlob("file");
        	int blobLength = (int) blob.length();  
        	trainingMaterial.setFile(blob.getBytes(1, blobLength));
        	trainingMaterial.setFileName(rs.getString("file_name"));   
        	trainingMaterial.setFileType(rs.getString("file_type"));
            return trainingMaterial;
        }
}
