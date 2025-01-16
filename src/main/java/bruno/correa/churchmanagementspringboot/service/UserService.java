package bruno.correa.churchmanagementspringboot.service;

import bruno.correa.churchmanagementspringboot.domain.entity.Role;
import bruno.correa.churchmanagementspringboot.domain.entity.User;
import bruno.correa.churchmanagementspringboot.domain.repository.UserRepository;
import bruno.correa.churchmanagementspringboot.dto.request.CreateUserRequestDTO;
import bruno.correa.churchmanagementspringboot.dto.response.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<UserResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(user -> UserResponseDTO.builder()
                        .id(user.getId())
                        .age(user.getAge())
                        .name(user.getName())
                        .role(user.getRole().getName())
                        .build())
                .toList();
    }

    public UserResponseDTO create(CreateUserRequestDTO request) {
        User entity = User.builder()
                .name(request.getName())
                .birthDate(request.getBirthDate())
                .role(Role.valueOf(request.getRole()))
                .build();

        var createdUser = repository.save(entity);

        return UserResponseDTO.builder()
                .id(createdUser.getId())
                .name(createdUser.getName())
                .age(createdUser.getAge())
                .role(createdUser.getRole().name())
                .build();
    }
}
