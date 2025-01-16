package bruno.correa.churchmanagementspringboot.service;

import bruno.correa.churchmanagementspringboot.domain.repository.UserRepository;
import bruno.correa.churchmanagementspringboot.dto.response.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<UserResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(user -> UserResponseDTO.builder()
                        .age(Period.between(user.getBirthDate().toLocalDate(), LocalDate.now()).getYears())
                        .name(user.getName())
                        .role(user.getRole().getName())
                        .build())
                .toList();
    }
}
