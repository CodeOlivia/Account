package com.example.account.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//클라이언트 - 컨트롤러 간의 응답에 필요한 몇 가지 데이터
public class AccountInfo {
    private String accountNumber;
    private Long balance;
}
