package com.wesew.admin.view;

/**
 * @author vladyslav.yemelianov
 */
public class ActualResultBuilder {

    public static ActualResult ok() {
        ActualResult res = new ActualResult();
        res.setStatus(ActualResult.Status.OK.getCode());
        return res;
    }

    public static ActualResult ok(Object data) {
        ActualResult res = new ActualResult();
        res.setStatus(ActualResult.Status.OK.getCode());
        res.setData(data);
        return res;
    }

    public static ActualResult ok(String data) {
        ActualResult res = new ActualResult();
        res.setStatus(ActualResult.Status.OK.getCode());
        res.setData(data);
        return res;
    }

    public static ActualResult error(String error) {
        ActualResult res = new ActualResult();
        res.setStatus(ActualResult.Status.ERROR.getCode());
        res.setError(error);
        return res;
    }

    public static ActualResult error() {
        ActualResult res = new ActualResult();
        res.setStatus(ActualResult.Status.ERROR.getCode());
        return res;
    }

    public static ActualResult error(Object error) {
        ActualResult res = new ActualResult();
        res.setStatus(ActualResult.Status.ERROR.getCode());
        res.setError(error);
        return res;
    }
}
