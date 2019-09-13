package io;

import java.io.UnsupportedEncodingException;
/*
找出 E5 B1 8C 这3个十六进制对应UTF-8编码的汉字
uTF-8用三个字节存一个汉字，用一个字节存数字和字母
 */
public class UTFCode {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] c = new byte[3];
        c[0] = (byte) 0xE5;
        c[1] = (byte) 0xB1;
        c[2] = (byte) 0x8C;
        String s = new String(c, "UTF-8");
        System.out.println(s);
    }
}
