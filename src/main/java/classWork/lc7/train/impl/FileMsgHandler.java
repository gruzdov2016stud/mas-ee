package classWork.lc7.train.impl;


import classWork.lc7.train.MsgHandler;
import classWork.lc7.train.MyHandler;

import java.io.File;

@MyHandler(name ="file")
public class FileMsgHandler implements MsgHandler {
    private String n = "hello";
    @Override
    public void handle(String msg) {
        File f = new File("msg.txt");
        /** */
    }
}
