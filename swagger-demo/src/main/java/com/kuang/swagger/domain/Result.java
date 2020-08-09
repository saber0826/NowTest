package com.kuang.swagger.domain;


public class Result {
  private int status;
  private String msg;
  private Object data;

  public Result() {
  }

  public Result(int status, String msg, Object data) {
    this.status = status;
    this.msg = msg;
    this.data = data;
  }

  public int getStatus() {
    return this.status;
  }

  public String getMsg() {
    return this.msg;
  }

  public Object getData() {
    return this.data;
  }

  public void setStatus(final int status) {
    this.status = status;
  }

  public void setMsg(final String msg) {
    this.msg = msg;
  }

  public void setData(final Object data) {
    this.data = data;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    } else if (!(o instanceof Result)) {
      return false;
    } else {
      Result other = (Result)o;
      if (!other.canEqual(this)) {
        return false;
      } else if (this.getStatus() != other.getStatus()) {
        return false;
      } else {
        Object this$msg = this.getMsg();
        Object other$msg = other.getMsg();
        if (this$msg == null) {
          if (other$msg != null) {
            return false;
          }
        } else if (!this$msg.equals(other$msg)) {
          return false;
        }

        Object this$data = this.getData();
        Object other$data = other.getData();
        if (this$data == null) {
          if (other$data != null) {
            return false;
          }
        } else if (!this$data.equals(other$data)) {
          return false;
        }

        return true;
      }
    }
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Result;
  }

  public int hashCode() {
    boolean PRIME = true;
    int result = 1;
     result = (result * 59) + this.getStatus();
    Object $msg = this.getMsg();
    result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
    Object $data = this.getData();
    result = result * 59 + ($data == null ? 43 : $data.hashCode());
    return result;
  }

  public String toString() {
    return "Result(status=" + this.getStatus() + ", msg=" + this.getMsg() + ", data=" + this.getData() + ")";
  }
}

