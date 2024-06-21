package com.cjp.ToDo.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cjp.ToDo.DTO.TaskInDto;
import com.cjp.ToDo.Entities.Task;
import com.cjp.ToDo.Entities.TaskStatus;
import com.cjp.ToDo.Exceptions.ToDoExceptions;
import com.cjp.ToDo.Mapped.TaskInDtoToTask;
import com.cjp.ToDo.Repository.TaskRepository;

@Service
public class TaskService {

	private final TaskRepository repository;
	private final TaskInDtoToTask mapper;
	
	public TaskService(TaskRepository repository, TaskInDtoToTask mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public Task createTask (TaskInDto taskInDto) {
		
		Task task = mapper.map(taskInDto);
		return this.repository.save(task);
		
	}
	
	public List<Task> findAll(){
		return this.repository.findAll();
	}
	
	public List<Task> findAllByTaskStatus(TaskStatus status){
		return this.repository.findAllByTaskStatus(status);
	}
	
	@Transactional
	public void updateTaskFinished(Long id) {
		Optional<Task> optionalTask = this.repository.findById(id);
		if (optionalTask.isEmpty()) {
			throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
		}
		this.repository.markTaskAsFinished(id);
	}
	
	public void deleteById(Long id) {
		Optional<Task> optionalTask = this.repository.findById(id);
		if (optionalTask.isEmpty()) {
			throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
		}		
		this.repository.deleteById(id);
	}
}
