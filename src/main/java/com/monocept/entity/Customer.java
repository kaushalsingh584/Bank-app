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
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int Customerid;
	private String firstName;
	private String lastName;
	@Column(name = "total_balance")
	private double totalBalance;
	
	
	@OneToMany(cascade= CascadeType.ALL )
	@JoinColumn(name = "fk_customer_id",referencedColumnName = "customer_id")
	private List<Account> accounts;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime created_at= LocalDateTime.now();
}
