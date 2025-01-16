package bruno.correa.churchmanagementspringboot.controller;

import bruno.correa.churchmanagementspringboot.dto.response.UserResponseDTO;
import bruno.correa.churchmanagementspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private static final String FIND_ALL_USERS = "/api/v1/users";

    private final UserService service;

    @GetMapping(value = FIND_ALL_USERS, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        var response = service.findAll();
        return ResponseEntity.ok(response);
    }
}
