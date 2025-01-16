package bruno.correa.churchmanagementspringboot.controller;

import bruno.correa.churchmanagementspringboot.dto.request.CreateUserRequestDTO;
import bruno.correa.churchmanagementspringboot.dto.response.UserResponseDTO;
import bruno.correa.churchmanagementspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private static final String BASE_URL = "/api/v1/users";
    private static final String BASE_PATH = "/{id}";
    private static final String FIND_ALL_USERS = BASE_URL;
    private static final String FIND_USER_BY_ID = BASE_URL + BASE_PATH;
    private static final String CREATE_USER = BASE_URL;

    private final UserService service;

    @GetMapping(value = FIND_ALL_USERS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        var response = service.findAll();

        return ResponseEntity.ok(response);
    }

    @PostMapping(value = CREATE_USER, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDTO> create(@RequestBody CreateUserRequestDTO request) {
        UserResponseDTO response = service.create(request);
        URI location = URI.create(FIND_USER_BY_ID.replace("{id}", String.valueOf(response.getId())));

        return ResponseEntity.created(location).body(response);
    }
}
