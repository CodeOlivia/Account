package com.example.account.dto;


import com.example.account.domain.Account;
import lombok.*;

import java.time.LocalDateTime;

//AccountService에서 account 엔티티의 일부, 혹은 그것보다 더 원할 수 있고 그 때마다 테이블에 대응하는
//Account클래스를 바꿀 수 없으니 서비스-컨트롤러에서 데이터를 연결해주는 Dto클래스를 따로 생성
//이 클래스는 기존 Account 클래스의 엔티티와 비슷하지만 간결, 딱 필요한 부분만 넣어둠
//수정이 필요하면 Dto를 수정

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    private Long userId;
    private String accountNumber;
    private Long balance;

    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;

    //Account 객체를 AccountDto로 변환
    public static AccountDto fromEntity(Account account) {
        return AccountDto.builder()
                .userId(account.getAccountUser().getId())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .registeredAt(account.getRegisteredAt())
                .unRegisteredAt(account.getUnRegisteredAt())
                .build();
    }
}
