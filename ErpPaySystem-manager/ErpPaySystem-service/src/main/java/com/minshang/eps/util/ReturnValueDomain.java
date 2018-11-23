package com.minshang.eps.util;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class ReturnValueDomain<T> {
	
	  private boolean success;
	  private boolean fail;
	  private String resultcode = "SUCCESS";
	  private String resultdesc;
	  private T object;
	  private List<T> list;

	  public ReturnValueDomain()
	  {
	  }

	  public ReturnValueDomain(String resultcode, String resultdesc)
	  {
	    this.resultcode = resultcode;
	    this.resultdesc = resultdesc;
	  }



	  public String getResultcode() {
	    return this.resultcode;
	  }

	  public void setResultcode(String resultcode) {
	    this.resultcode = resultcode;
	  }

	  public String getResultdesc() {
	    return this.resultdesc;
	  }

	  public void setResultdesc(String resultdesc) {
	    this.resultdesc = resultdesc;
	  }


	  public T getObject() {
	    return this.object;
	  }

	  public void setObject(T object) {
	    this.object = object;
	  }


	  public boolean isSuccess() {
	    this.success = this.resultcode.equals("SUCCESS");
	    return this.success;
	  }

	  public void setSuccess(boolean success) {
	    this.success = success;
	  }

	  public boolean isFail() {
	    this.fail = (!this.resultcode.equals("SUCCESS"));
	    return this.fail;
	  }

	  public void setFail(boolean fail) {
	    this.fail = fail;
	  }

	  public List<T> getList() {
	    return this.list;
	  }

	  public void setList(List<T> list) {
	    this.list = list;
	  }

	  @JSONField(deserialize=false)
	  public ReturnValueDomain<T> setSuccess(String resultdesc) {
		this.success = true;
	    setResultcode("SUCCESS");
	    setResultdesc(resultdesc);

	    return this;
	  }
	  @JSONField(deserialize=false)
	  public ReturnValueDomain<T> setSuccess(String resultdesc, T object) {
	    this.object = object;
	    this.success = true;
	    setResultcode("SUCCESS");
	    setResultdesc(resultdesc);
	    return this;
	  }
	  @JSONField(deserialize=false)
	  public ReturnValueDomain<T> setFail(String resultdesc) {
	    setResultcode("FAIL");
	    setResultdesc(resultdesc);

	    return this;
	  }
	  @JSONField(deserialize=false)
	  public ReturnValueDomain<T> setFail(String resultdesc, T object) {
	    this.object = object;
	    setResultcode("FAIL");
	    setResultdesc(resultdesc);
	    return this;
	  }
	  @JSONField(deserialize=false)
	  public boolean hasSuccess() {
	    return this.resultcode.equals("SUCCESS");
	  }
	  @JSONField(deserialize=false)
	  public boolean hasFail() {
	    return !this.resultcode.equals("SUCCESS");
	  }
}
