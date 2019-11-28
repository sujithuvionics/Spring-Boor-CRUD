package com.sujith.unittestexample.util;

import com.sujith.unittestexample.model.ToDo;

public class PayloadValidator {
	
	public static boolean validateCreatePayload(ToDo toDo){
		if (toDo.getId() > 0){
			return false;
		}
		return true;
	}

}
