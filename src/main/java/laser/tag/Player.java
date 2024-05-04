package laser.tag;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "STUDENT")
public class Player {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;
}
