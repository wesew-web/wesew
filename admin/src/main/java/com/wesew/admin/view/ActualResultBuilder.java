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
        res.setData(data.toString());
        return res;
    }

    public static ActualResult ok(String data) {
        ActualResult res = new ActualResult();
        res.setStatus(ActualResult.Status.OK.getCode());
        res.setData(data);
        return res;
    }
}
