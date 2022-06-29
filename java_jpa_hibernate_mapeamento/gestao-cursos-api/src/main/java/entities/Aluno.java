package entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "aluno")
public class Aluno implements Serializable {

    @Serial
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column
    private String matricula;

    @Column
    @Temporal(TemporalType.DATE)
    private Date nascimento;

    @Column
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    private List<Telefone> telefones = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    private List<Endereco> enderecos = new ArrayList<>();

    @ManyToMany(mappedBy = "alunos")
    private List<Curso> cursos;

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", matricula='" + matricula + '\'' +
                ", nascimento=" + nascimento +
                ", email='" + email + '\'' +
                '}';
    }
}
