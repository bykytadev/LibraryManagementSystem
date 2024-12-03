package com.sqc.academy.library.controllers;

import com.sqc.academy.library.dtos.request.UserRequestDTO;
import com.sqc.academy.library.dtos.response.ApiResponse;
import com.sqc.academy.library.dtos.response.JsonResponse;
import com.sqc.academy.library.dtos.response.PageResponse;
import com.sqc.academy.library.dtos.response.UserResponseDTO;
import com.sqc.academy.library.services.user.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {

    UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponseDTO>> create(
            @Valid @RequestBody UserRequestDTO request) {
        UserResponseDTO response = userService.create(request);
        return JsonResponse.created(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> getById(
            @PathVariable("id") String id) {
        UserResponseDTO response = userService.getById(id);
        return JsonResponse.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<UserResponseDTO>>> getAll(Pageable pageable) {
        Page<UserResponseDTO> page = userService.getAll(pageable);
        PageResponse<UserResponseDTO> response = PageResponse.from(page);
        return JsonResponse.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<UserResponseDTO>> update(
            @PathVariable("id") String id,
            @Valid @RequestBody UserRequestDTO request) {
        UserResponseDTO response = userService.update(id, request);
        return JsonResponse.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable("id") String id) {
        userService.delete(id);
        return JsonResponse.noContent();
    }
}