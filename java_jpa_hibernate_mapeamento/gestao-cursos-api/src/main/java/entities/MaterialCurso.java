package entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "material_curso")
public class MaterialCurso implements Serializable {

    @Serial
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String url;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "material")
    private Curso curso;

    @Override
    public String toString() {
        return "MaterialCurso{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
