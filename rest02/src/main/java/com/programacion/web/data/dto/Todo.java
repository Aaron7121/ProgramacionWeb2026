package com.programacion.web.data.dto;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "todos", schema = "public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "todos_user_id_fkey"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Column(name = "title", nullable = false, columnDefinition = "text")
    private String title;

    @Column(name = "completed", nullable = false)
    private boolean completed;


}