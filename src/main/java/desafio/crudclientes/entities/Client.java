package desafio.crudclientes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double income;
    private LocalDate birthDate;
    private Integer childer;

    public Client() {}

    public Client(Long id, String name, Double income, LocalDate birthDate, Integer childer) {
        this.id = id;
        this.name = name;
        this.income = income;
        this.birthDate = birthDate;
        this.childer = childer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChilder() {
        return childer;
    }

    public void setChilder(Integer childer) {
        this.childer = childer;
    }
}
