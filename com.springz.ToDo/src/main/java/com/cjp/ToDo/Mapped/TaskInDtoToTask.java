package com.cjp.ToDo.Mapped;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.cjp.ToDo.DTO.TaskInDto;
import com.cjp.ToDo.Entities.Task;
import com.cjp.ToDo.Entities.TaskStatus;

@Component
public class TaskInDtoToTask implements IMapper<TaskInDto, Task> {

	@Override
	public Task map(TaskInDto in) {
		Task task = new Task();
		task.setTittle(in.getTittle());
		task.setDescription(in.getDescription());
		task.setEta(in.getEta());
		task.setCreateDate(LocalDate.now());
		task.setFinished(false);
		task.setTaskStatus(TaskStatus.ON_TIME);
		
		return task;
	}
	

}
