package desafio.crudclientes.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ClientDto(
        Long id,
        @NotBlank(message = "Campo obrigatório.")
        String name,
        Double income,
        @PastOrPresent(message = "Data maior que data de hoje.")
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