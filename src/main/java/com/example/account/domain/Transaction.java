package com.example.account.domain;


import com.example.account.type.TransactionResultType;
import com.example.account.type.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Transaction {
    @Id
    @GeneratedValue
    private Long id;

    //사용, 사용취소
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    //성공, 실패
    @Enumerated(EnumType.STRING)
    private TransactionResultType transactionResultType;

    @ManyToOne
    private Account account; //계좌
    private Long amount; //거래 금액
    private Long balanceSnapShot; //현재 잔액의 스냅샷

    private String transactionId; //거래 고유 id
    private LocalDateTime transactedAt; //거래 일시

    @CreatedDate
    private LocalDateTime createdAt;

    //수정일시
    @LastModifiedBy
    private LocalDateTime updatedAt;
}
