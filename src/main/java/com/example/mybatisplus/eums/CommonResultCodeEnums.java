package  com.example.mybatisplus.eums;

public enum CommonResultCodeEnums {

    SUCCESS("100200", "success"),
    FAILED("100500", "internal error"),
    THIRD_PART_ERROR("100501", "third part error"),
    VALIDATION_EXCEPTION("100502", "parameter is illegal");
    private String code;
    private String describe;

    CommonResultCodeEnums(String code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescribe() {
        return this.code;
    }
}
