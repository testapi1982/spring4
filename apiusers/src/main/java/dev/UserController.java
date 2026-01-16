package dev;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserController(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @GetMapping(value = "/{version}/users", version = "1.0")
    public List<UserDTOv1> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toV1)
                .toList();
    }

    @GetMapping(value = "/{version}/users", version = "2.0")
    public List<UserDTOv2> findAllUsersV2() {
        return userRepository.findAll().stream()
                .map(userMapper::toV2)
                .toList();
    }

}
