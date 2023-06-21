package javase.day6.test.test1;

public enum Result {
    SUCCESS("200","一切正常"),ERROR("404","资源找不到");
    public String code;
    public String mess;

    Result(String code, String mess) {
        this.code = code;
        this.mess = mess;
    }

    //不用重写枚举类中toString方法


}
