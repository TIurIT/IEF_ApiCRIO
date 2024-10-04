package com.crio.api.controllers.dto;

public record LoginResponse(String accessToken, Long expiresIn) {
}
