package com.sqc.academy.library.services.user;

import com.sqc.academy.library.dtos.request.UserRequestDTO;
import com.sqc.academy.library.dtos.response.UserResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserResponseDTO create(UserRequestDTO request);

    UserResponseDTO getById(String id);

    Page<UserResponseDTO> getAll(Pageable pageable);

    UserResponseDTO update(String id, UserRequestDTO request);

    void delete(String id);
}