package org.seckill.exception;

public class SeckillCloseException extends SeckillException {
  public SeckillCloseException(String msg) {
    super(msg);
  }

  public SeckillCloseException(String msg, Throwable throwable) {
    super(msg, throwable);
  }
}
