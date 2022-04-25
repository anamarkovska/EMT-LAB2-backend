package emt.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;



@Data
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String continent;

    @OneToMany
    private List<Author> authors;

    public Country() {
    }
}