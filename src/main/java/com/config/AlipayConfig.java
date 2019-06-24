package com.config;
import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    public static String app_id = "20181037";
    public static String merchant_private_key = "MIIEpAIBAAKCAQEAs7hCNS9T9W9mhPoJrVF/zNNZd7yRBRkT7g8zbjd/BpgZEQ0T" +
            "tNyJD9k0AgkYdcQ/k/2MhiRkRdHvQpzmDXlP4o5dL2tOu3FsSeM5j70PHXXSaK75" +
            "9V7JtU3f0tm9GoT0pxzQAE1xA+tebSWs9lRHPQsXXLzcjllmUkwD6Yax6n4fYRn0" +
            "qhcwcSU1SLtajH+gLrk+H53dfqBbTt3TkEzUE/im9oo5HjrEZz4sl7+VBgIXCgFI" +
            "eHHXPXc9sVpku3fbP0OrvH20ZYPuQrd7O5H/9RVxYOWKEcPutHRWYMhMV8BGh7Un" +
            "5Ormy9gcNw52GWoPNZ5XBT8khY6duPIyRD23MQIDAQABAoIBACJnibUoxEfd9aBL" +
            "RYL6cR7C7wOvA4wYSupt2oik8xpOD65l9HnRJiP0jrI9D4Or+AfaqAYd/VwoXkdA" +
            "RgIaUSKr4kbrofzcL8DNUP2lUblwDsGfjZZdePvOVqTEriDfhv5e06rbKGF5s2/t" +
            "oHjflWuoLebA+O//SUlD6BPSh0i+Xf6mbEwpXa/WW0D90uCoiPvOOkO5wa4tpHI7" +
            "j5Fphf04uw/cP6QU/YZ0qOoA5iwxHGRzprlNoxQYJgOFOWfbygdIPnShQjz9GPXM" +
            "qycd6Z4FDqUiW8Uy1fCqkm+PjgyQauaY1GkBJSlunvDPKeqcTFe2EtiWAqJuTPBm" +
            "w5Z4XeECgYEA4ta88JZqxR0GIkdVHO52LWEVd53L8hILxMEZU3FZUrEeAJidhH1G" +
            "aTSXoAv9Se6nyCByXVMMISDQaFCr74NnHwA8XSo6zd5dBRaz98UyJT2sn5SoorQO" +
            "j/hT1GX6p8p6I1V3su4fiBG6WVuVS/Eh7BrpjA2TBllqrKTeg+RsAUUCgYEAytLV" +
            "Q1xnSl7afdFtBI4sguqMmBEFbwmCDDYGvScM0dkQwgYdsAKuYBs40wLOFXHiMWpv" +
            "TsjAbH8ZyuVzjOhMcUG3aBm3BwxeaclC9A+iZnNdn8LUx4seEJgfTUAuIAo5X/tw" +
            "H0RNJFD+nZwNflpE+a6iIaJST7TgAZeSejwm/v0CgYEAsX+65L+u2IL3k8chkLv/" +
            "+U5oj+sH9Wmtj85R1PtzG8PAaFMDnvKwMA6ZPwFit4FqBK1vEBu1+A5HRfkqMQcv" +
            "oBB9K6Gp1gHT4/F57b1+mamC9HRM6NPgOUPlxOPvmXBU1mVAfuDaB41nthh14LDV" +
            "DH2alp7gly1Mzb9M5wPMh8kCgYEAkvARLr7n2dpEIjix6UXy+1lfR9+09w+FVsFh" +
            "OnHq+LBwUpBJu7UFjXzLOxviH2kk/LXmM8Z+mVuvXO3EO8Yjcz2v2MwgbAvK7oqv" +
            "Zc9Z0S0tG8vziSjBPDZpHvcrM20UyfOH9C7wUCoZfCeNIwfUxqp8rS9CwJoCW0Tr" +
            "CoE/oyUCgYBvsnWUCN0L83CeSK4koJEIgv8OjmeoRJfsnhO2nvNuW5egJHZN0rFS" +
            "xX0PSMfbF2Vgac1xuKqHON6JLAHbtBDnBozqtgcPuhgjjYhwIb1ZYtGnwIGpt+9F" +
            "n6TObHJA+8O8LQ3lGypihNcKnjM1paqGLqP04tlNPKE+7EZj9rv5Tg==";
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkVNC5KIpWMALZIG5efY4xo4ENBxedktxBkTXn6GzlhYavEipk5QP1slCVP875QmWIGfeZCJbORwMbGoJ67ja2HppItjlxFe40p8fsu5rG/vCFm6hLN2doeHfSvDhIdyIgIG5abNy9Qp4PiYJGRIAP4makonD45Cy+0cSbq9yEGw1g62aWey748TNo1unJKE86PpXwCm/Po6g7IIGFYuVEO2lO1GX/TGlfcBoNwU6bgE29pQ76VHG49/zoEe3UOLdo0bub9T9Xb+geDuzpubzRuJ9pNaUHetTJK+8Ve3Uvb8v0eU7Wgdw82HXCv0G5WGBmpfJqNCBAwEJlDK3NH3uHwIDAQAB";
    public static String return_url = "http://localhost:8080/popo_war_exploded/alipayNotifyNotice.action";
    public static String notify_url = "http://localhost:8080/popo_war_exploded/alipayReturnNotice.action";
    public static String sign_type = "RSA2";
    public static String charset = "utf-8";
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}
