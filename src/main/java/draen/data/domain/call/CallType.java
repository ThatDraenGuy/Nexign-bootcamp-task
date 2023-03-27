package draen.data.domain.call;

import draen.exceptions.ParseException;

public enum CallType {
    INCOMING,
    OUTGOING;

    public String getCode() {
        switch (this) {
            case INCOMING: return "02";
            case OUTGOING: return "01";
            default: return null;
        }
    }

    public static CallType fromCode(String code) throws ParseException {
        switch (code) {
            case "01": return CallType.OUTGOING;
            case "02": return CallType.INCOMING;
            default: throw new ParseException("Invalid call type!");
        }
    }
}
