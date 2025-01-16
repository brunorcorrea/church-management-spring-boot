package bruno.correa.churchmanagementspringboot.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestDTO {

    private String name;
    private String role;
    private LocalDate birthDate;
}
