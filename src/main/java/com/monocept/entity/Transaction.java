package com.monocept.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private int transactionId;
	
	@Column(name = "sender_acc_no")
	private Integer senderAccNo;
	
	@Column(name = "receiver_acc_no")
	private Integer receiverAccNo;
	
	private double amount;
	
	@Column(name = "transaction_type")
	private String transactionType;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime created_at = LocalDateTime.now();
	
	
	
}
