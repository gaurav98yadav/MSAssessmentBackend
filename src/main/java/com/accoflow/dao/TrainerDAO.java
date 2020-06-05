package com.accoflow.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.accoflow.constants.Queries;
import com.accoflow.models.Trainer;
import com.accoflow.rowmapper.TrainerMapper;

@Repository
public class TrainerDAO {
	
	@Autowired
   JdbcTemplate jdbcTemplate;
   public int addTrainer(Trainer trainer)
   {
	      List<Trainer> listAnswers = jdbcTemplate.query(Queries.FETCH_TRAINER_DETAILS, new Object[] {trainer.getTrainer_email()}, new TrainerMapper()); 
	      if(listAnswers.size()>0) {
               return listAnswers.get(0).getTrainer_id();
          }
	      jdbcTemplate.update(Queries.INSERT_TRAINER,trainer.getTrainer_name(),trainer.getTrainer_email(),trainer.getTrainer_photo());
	      return jdbcTemplate.queryForObject(Queries.FETCH_TRAINER_ID,new Object[] {trainer.getTrainer_email()},Integer.class);
   }
}
