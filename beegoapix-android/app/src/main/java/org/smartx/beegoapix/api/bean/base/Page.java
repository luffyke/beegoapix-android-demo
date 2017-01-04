package org.smartx.beegoapix.api.bean.base;

/**
 * Created by kext on 16/8/11.
 */

public class Page {

    private Integer page;

    private Integer size = 10;

    private Integer totalSize;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }
}
