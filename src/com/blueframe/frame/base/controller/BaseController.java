package com.blueframe.frame.base.controller;

import com.blueframe.frame.base.model.ReturnMessage;

public class BaseController {

	public ReturnMessage buildReturnMessage(String flag, String message) {
		return new ReturnMessage(message, flag);
	}
}
