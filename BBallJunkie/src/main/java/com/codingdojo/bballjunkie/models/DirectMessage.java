package com.codingdojo.bballjunkie.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity 
@Table(name="directMessages")
public class DirectMessage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Can't send an empty message")
	private String messagetext;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="senderId")
	private User sender;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="receiverId")
	private User receiver;
}
