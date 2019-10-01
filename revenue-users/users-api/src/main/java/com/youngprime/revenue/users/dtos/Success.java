package com.youngprime.revenue.users.dtos;

public class Success {

    private Integer status;
    private String code;
    private Object data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
