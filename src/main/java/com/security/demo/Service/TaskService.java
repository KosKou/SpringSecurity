package com.security.demo.Service;

import com.security.demo.Entity.Task;
import com.security.demo.Entity.User;
import com.security.demo.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User user){
        task.setUser(user);
        taskRepository.save(task);
    }

    public List<Task> findUserTask(User user){
        return taskRepository.findByUser(user);
    }

    public void deleteTask(Long task) {
        taskRepository.deleteById(task);
    }
}
