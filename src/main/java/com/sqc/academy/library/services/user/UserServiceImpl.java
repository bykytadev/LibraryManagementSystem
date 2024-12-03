package com.sqc.academy.library.services.user;

import com.sqc.academy.library.dtos.request.UserRequestDTO;
import com.sqc.academy.library.dtos.response.UserResponseDTO;
import com.sqc.academy.library.entities.User;
import com.sqc.academy.library.mappers.UserMapper;
import com.sqc.academy.library.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    @Transactional
    public UserResponseDTO create(UserRequestDTO request) {
        User user = userMapper.toEntity(request);
        return userMapper.toResponseDTO(userRepository.save(user));
    }

    @Override
    public UserResponseDTO getById(String id) {
        return userMapper.toResponseDTO(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    @Override
    public Page<UserResponseDTO> getAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(userMapper::toResponseDTO);
    }

    @Override
    @Transactional
    public UserResponseDTO update(String id, UserRequestDTO request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        return userMapper.toResponseDTO(userRepository.save(user));
    }

    @Override
    @Transactional
    public void delete(String id) {
        userRepository.deleteById(id);
    }
}