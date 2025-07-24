package br.com.vhaporfiro.service;

import br.com.vhaporfiro.entities.Task;
import br.com.vhaporfiro.dto.TaskDto;
import br.com.vhaporfiro.entities.Task_Status;
import br.com.vhaporfiro.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    public TaskRepository taskRepository;

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Optional<Task> getById(Long Id){
        return taskRepository.findById(Id);
    }

    public Task createTask(TaskDto taskDto) {
        Task task = new Task();

        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());

        task.setStatus(Task_Status.AGUARDANDO);
        task.setCreatedAt(LocalDateTime.now());

        return taskRepository.save(task);
    }

    public Task updateTask(Long Id, TaskDto taskDatailsDto){
        Optional<Task> taskOptional = taskRepository.findById(Id);

        if (taskOptional.isPresent()) {
            Task existingTask = taskOptional.get();
            existingTask.setTitle(taskDatailsDto.getTitle());
            existingTask.setDescription(taskDatailsDto.getDescription());
            existingTask.setStatus(Task_Status.valueOf(taskDatailsDto.getStatus()));
            existingTask.setDueDate(taskDatailsDto.getDueDate());

            return taskRepository.save(existingTask);
        } else {
            return null;
        }
    }

    public void deleteById(Long Id) {
        taskRepository.deleteById(Id);
    }
}
