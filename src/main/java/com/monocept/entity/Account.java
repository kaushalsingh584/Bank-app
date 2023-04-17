package com.monocept.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_no")
	private Integer accountNo;
	private double balance = 1000;
	
	@OneToMany(cascade= CascadeType.ALL )
	@JoinColumn(name = "receiver_acc_no",referencedColumnName = "account_no")
	private List<Transaction> credit;
	
	@OneToMany(cascade= CascadeType.ALL )
	@JoinColumn(name = "sender_acc_no",referencedColumnName = "account_no")
	private List<Transaction> debit;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime created_at= LocalDateTime.now();

}
