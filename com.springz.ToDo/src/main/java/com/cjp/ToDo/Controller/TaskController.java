package com.cjp.ToDo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cjp.ToDo.DTO.TaskInDto;
import com.cjp.ToDo.Entities.Task;
import com.cjp.ToDo.Entities.TaskStatus;
import com.cjp.ToDo.Service.TaskService;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {
	
	private final TaskService taskService;
	
	public TaskController (TaskService taskService) {
		this.taskService = taskService;
	}
	
	
	@PostMapping
	public Task createTask(@RequestBody TaskInDto taskInDto) {
		return this.taskService.createTask(taskInDto);
		
	}
	
	@GetMapping
	public List<Task> findAll() {
		return this.taskService.findAll();
		
	}
	
	@GetMapping("/{status}")
	public List<Task> findAllByStatus(@PathVariable("status") TaskStatus status) {
		return this.taskService.findAllByTaskStatus(status);
		
	}
	
	
	@PatchMapping("/{id}")
	public ResponseEntity<Void> markAsFinished(@PathVariable("id")Long id){
		this.taskService.updateTaskFinished(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable("id")Long id){
		this.taskService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	

	
	
}
