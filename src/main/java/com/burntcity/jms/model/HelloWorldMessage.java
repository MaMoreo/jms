package com.burntcity.jms.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelloWorldMessage implements Serializable{
	
	
	/**
	 * Serializable for versioning
	 */
	private static final long serialVersionUID = 4692047706213111836L;
	
	private UUID id;
	private String message;

}
