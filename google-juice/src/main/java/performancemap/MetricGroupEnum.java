package performancemap;

public enum MetricGroupEnum {

    POD("POD", "Pay on Delivery"),
    MAQ("MAQ", "Merchant Acquisition"),
    KYC("KYC", "Know Your Customer");

    private final String code;
    private final String description;

    MetricGroupEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public static MetricGroupEnum getValueByCode(String code) {
        if (code.isEmpty()) {
            return null;
        }
        for (MetricGroupEnum type : values()) {
            if (type.getCode().equalsIgnoreCase(code)) {
                return type;
            }
        }
        return null;
    }
}