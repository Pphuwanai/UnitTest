package com.prior.base;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse<T> implements Serializable {
	private int code;
	private String message;
	private T result;
	
	public static <T> APIResponse<T> success(T result){
		APIResponse<T> response = new APIResponse<T>();
		response.setCode(200);
		response.setMessage("SUCCESS");
		response.setResult(result);
		
		return response;
	}
}
