package pokemon.ejemplo.crudexamen.Objects;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "granjeros")
public class Granjero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombreApellidos")
    private String nombreApellidos;

    @Column(name = "email")
    private String email;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "password")
    private String password;

    @Column(name = "saldo")
    private float saldo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "granjeros_animales",
            //Hace referencia a la tabla intermediarias
            joinColumns = @JoinColumn(name = "idGranjero"),
            inverseJoinColumns = @JoinColumn(name = "idAnimal")
    )
    private List<Animal> animales;

    public Granjero() {
    }

    public Granjero(String nombreApellidos, String email, String password, String nombreUsuario, float saldo, List<Animal> animales) {
        this.nombreApellidos = nombreApellidos;
        this.email = email;
        this.password = password;
        this.nombreUsuario = nombreUsuario;
        this.saldo = saldo;
        this.animales = animales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(List<Animal> animales) {
        this.animales = animales;
    }

    @Override
    public String toString() {
        return "Granjero{" +
                "id=" + id +
                ", nombreApellidos='" + nombreApellidos + '\'' +
                ", email='" + email + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", password='" + password + '\'' +
                ", saldo=" + saldo +
                ", animales=" + animales +
                '}';
    }
}
