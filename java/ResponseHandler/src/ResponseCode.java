public enum ResponseCode {
    INFO(100, 199),
    SUCCESS(200, 299),
    REDIRECT(300, 399),
    CLIENT_ERROR(400, 499),
    SERVER_ERROR(500, 599);

    private int min, max;

    ResponseCode(int min, int max){
        this.min = min;
        this.max = max;
    }

    public static ResponseCode checkHttpResponse(int response){
        ResponseCode res = null;
        ResponseCode[] responsesRange = values();
        for(ResponseCode rc : responsesRange) {
            res = (response >= rc.min && response <= rc.max) ? rc : null;
            if(res != null) break;
        }
        return res;
    }
}






