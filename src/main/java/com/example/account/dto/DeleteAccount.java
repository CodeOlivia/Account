package com.example.account.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

public class DeleteAccount {

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Request {
        @NotNull(message = "사용자 아이디가 필요합니다.")
        @Min(1)
        private Long userId;

        @NotBlank
        @Size(min = 10, max = 10)
        private String accountNumber;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long userId;
        private String accountNumber;
        private LocalDateTime unRegisteredAt;

        public static Response from(AccountDto accountDto) {
            return Response.builder()
                    .userId(accountDto.getUserId())
                    .accountNumber(accountDto.getAccountNumber())
                    .unRegisteredAt(accountDto.getUnRegisteredAt())
                    .build();
        }
    }
}