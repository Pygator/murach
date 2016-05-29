package murach.enumeration;

public enum CustomerType {

    RETAIL,
    TRADE,
    COLLEGE;
    
    @Override
    public String toString() {
        switch (ordinal()) {
            case 0:
                return "Retail";
            case 1:
                return "Trade";
            case 2:
                return "College";
            default:
                return "";
        }
    }

}