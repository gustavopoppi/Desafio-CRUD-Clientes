package desafio.crudclientes.dtos;

import java.time.LocalDate;

public record ClientDto(
        Long id,
        String name,
        Double income,
        LocalDate birthDate,
        Integer childer
) {
}