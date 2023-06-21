package javase.day6.test.test1;

public class Results {
    private String statusMess;
    private Result result;

    public Results(String statusMess, Result result) {
        this.statusMess = statusMess;
        this.result = result;
    }

    public Results() {
    }

    public String getStatusMess() {
        return statusMess;
    }

    public void setStatusMess(String statusMess) {
        this.statusMess = statusMess;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Results{" +
                "statusMess='" + statusMess + '\'' +
                ", result=" + result +
                '}';
    }
}
