package org.smartx.beegoapix.api;

import org.smartx.beegoapix.api.bean.base.State;

/**
 * Created by kext on 16/8/18.
 */

public class ApiException extends Exception {

    private State state;

    public ApiException() {
        super();
    }

    public ApiException(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
