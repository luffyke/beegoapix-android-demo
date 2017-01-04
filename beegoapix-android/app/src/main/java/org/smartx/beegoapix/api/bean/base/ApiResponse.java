package org.smartx.beegoapix.api.bean.base;

/**
 * Created by kext on 16/8/11.
 */

public class ApiResponse<T> {

    public String id;

    public State state;

    public Page page;

    public User user;

    public T data;
}
