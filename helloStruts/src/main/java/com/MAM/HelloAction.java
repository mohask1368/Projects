package com.MAM;

import com.opensymphony.xwork2.Action;

public class HelloAction implements Action {

    String message ;

    @Override
    public String execute() throws Exception {
        setMessage("hello mohammad welcome to struts 2");
        return "success";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
