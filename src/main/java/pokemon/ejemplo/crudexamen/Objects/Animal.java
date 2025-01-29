package pokemon.ejemplo.crudexamen.Objects;

import com.sun.istack.Nullable;
import pokemon.ejemplo.crudexamen.Enums.Estado;
import pokemon.ejemplo.crudexamen.Enums.Temperamento;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "animales")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombreComun")
    private String nombreComun;

    @Column(name = "genero")
    private String genero;

    @Column(name = "peso")
    private float peso;

    @Column(name = "tamaño")
    private float size;

    @Column(name = "dieta")
    private String dieta;

    @Column(name = "precio")
    private float precio;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @Nullable
    @Column(name = "enfermedades")
    private String enfermedades;

    @Nullable
    @Column(name = "cuidados")
    private String cuidados;

    @Nullable
    @Column(name = "horasTrabajo")
    private Integer horasTrabajo;

    @Nullable
    @Enumerated(EnumType.STRING)
    @Column(name = "temperamento")
    private Temperamento temperamento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idParcela")
    private Parcela parcela;

    @ManyToMany(mappedBy = "animales")
    private List<Granjero> granjeros;

    public Animal() {

    }

    public Animal(String nombreComun, String genero, float peso, float size, float precio, String dieta, Estado estado,
                  Parcela parcela) {
        this.nombreComun = nombreComun;
        this.genero = genero;
        this.peso = peso;
        this.size = size;
        this.precio = precio;
        this.dieta = dieta;
        this.estado = estado;
        this.parcela = parcela;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Parcela getParcela() {
        return parcela;
    }

    public void setParcela(Parcela parcela) {
        this.parcela = parcela;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getCuidados() {
        return cuidados;
    }

    public void setCuidados(String cuidados) {
        this.cuidados = cuidados;
    }

    public Integer getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(int horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }

    public Temperamento getTemperamento() {
        return temperamento;
    }

    public void setTemperamento(Temperamento temperamento) {
        this.temperamento = temperamento;
    }

    @Override
    public String toString() {
        return getNombreComun();
    }
}