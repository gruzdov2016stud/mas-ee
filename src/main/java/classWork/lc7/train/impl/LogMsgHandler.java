package classWork.lc7.train.impl;

import classWork.lc7.train.MsgHandler;
import classWork.lc7.train.MyHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@MyHandler(name="log")
public class LogMsgHandler implements MsgHandler {
    private String n = "hello";
    @Override
    public void handle(String msg) {
        log.info(msg);
    }
}
