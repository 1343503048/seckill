package org.seckill.exception;

public class RepeatKillException extends SeckillException {
  public RepeatKillException(String msg) {
    super(msg);
  }

  public RepeatKillException(String msg, Throwable throwable) {
    super(msg, throwable);
  }
}
