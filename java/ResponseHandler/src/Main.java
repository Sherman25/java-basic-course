public class Main {
    public static void main(String[] args) {
        int[] responses = {50, 150, 250, 650};

        for(int response : responses) {
            ResponseCode code = ResponseCode.checkHttpResponse(response);
            System.out.printf("Response %s is %s response %n", response, (code != null) ? code : "illegal");
        }
    }
}
