package desafio.crudclientes.dtos;

import java.time.LocalDate;

public record ClientDto(
        Long id,
        String name,
        Double income,
        LocalDate birthDate,
        Integer children
) {
    public ClientDto(Long id, String name, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }
}