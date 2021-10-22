package com.example.demo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name="favorite_comics")
public class Comic implements Serializable{
    @Column(name="id")
    @Id
    private int id;

    private int id_user;
    private String id_comic;
    private String title_comic;
}
