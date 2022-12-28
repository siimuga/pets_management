package pets.pets_management.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "FUR_COLOR")
public class FurColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;
}