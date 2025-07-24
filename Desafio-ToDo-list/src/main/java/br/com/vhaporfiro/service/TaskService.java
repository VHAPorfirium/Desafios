package br.com.vhaporfiro.service;

import br.com.vhaporfiro.entities.Task;
import br.com.vhaporfiro.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Task creatTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long Id, Task taskDatails){
        Optional<Task> task = taskRepository.findById(Id);

        if (task.isPresent()) {
            Task existingTask = task.get();
            existingTask.setTitle(taskDatails.getTitle());
            existingTask.setDescription(taskDatails.getDescription());
            existingTask.setStatus(taskDatails.getStatus());
            return taskRepository.save(existingTask);
        }
        else {
            return null;
        }
    }

    public void deleteById(Long Id) {
        taskRepository.deleteById(Id);
    }
}
