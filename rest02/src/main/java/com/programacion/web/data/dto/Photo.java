package com.programacion.web.data.dto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "photos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne( optional = false)
    @JoinColumn(name = "album_id", nullable = false,
            foreignKey = @ForeignKey(name = "photos_album_id_fkey"))
    private Album album;

    @Column(name = "title", columnDefinition = "text")
    private String title;

    @Column(name = "url", columnDefinition = "text")
    private String url;

    @Column(name = "thumbnail_url", columnDefinition = "text")
    private String thumbnailUrl;



}