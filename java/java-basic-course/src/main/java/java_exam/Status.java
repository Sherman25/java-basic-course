package java_exam;

public enum Status {
    SHORT(0, 10),
    MID(11, 20),
    LONG(21, 30);

    private int min, max;

    Status(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static Status getTextStatus(int length) {
        Status res = null;
        Status[] statuses = values();
        for(Status status : statuses) {
            res = (length >= status.min && length <= status.max) ? status : null;
            if(res != null) break;
        }
        return res;
    }
}
