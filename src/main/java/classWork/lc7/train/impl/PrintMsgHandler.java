package classWork.lc7.train.impl;

import classWork.lc7.train.MsgHandler;
import classWork.lc7.train.MyHandler;

@MyHandler(name = "Print")
public class PrintMsgHandler implements MsgHandler {
    private String n = "hello";
    @Override
    public void handle(String msg) {
        System.err.println(msg);
    }
}
