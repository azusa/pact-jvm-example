package jp.fieldnotes.jjug.pact.provider.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="animals")
public class AnimalsEntity implements Serializable {

    @Id
    @Column(name="id", nullable=false)
    private Long id;

    @NotNull
    @Column(name="type", nullable=false)
    private String type;

    @NotNull
    @Column(name="name", nullable=false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
