package pokemon.ejemplo.crudexamen.Objects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parcela")
public class Parcela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "area")
    private float area;

    @Column(name = "ubicacion")
    private String ubicacion;

    @OneToMany(mappedBy = "parcela")
    private List<Animal> animales;

    public Parcela() {
    }

    public Parcela(float area, String ubicacion) {
        this.area = area;
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(List<Animal> animales) {
        this.animales = animales;
    }

    @Override
    public String toString() {
        return "Parcela{" +
                "id=" + id +
                ", area=" + area +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
