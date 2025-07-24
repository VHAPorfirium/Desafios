package br.com.vhaporfiro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class TaskDto {

    private Long id;

    @NotBlank(message = "O campo tittulo é obrigatorio")
    @Size(min = 2, max = 20, message = "O campo titulo deve conter entre 2 e 20 caracteres.")
    private String title;

    @Size(max = 1000, message = "O campo descrição deve conter no maximo 1000 caracteres.")
    private String description;

    //@NotBlank(message = "O campo status é obrigatorio")
    private String status;

    private LocalDateTime createdAt;

    private LocalDateTime dueDate;

    public TaskDto() {}

    public TaskDto(String title, String description, String status, LocalDateTime createdAt, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "TaskDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", dueDate=" + dueDate +
                '}';
    }
}
