package com.orange.admin.pojo.common.bo;

/**
 *数字统计
 * @author 高晨
 */
public class GoodsCount {

    private Integer allCount;

    private Integer selloutCount;

    private Integer sellDownCount;

    private Integer sellupCount;

    private Integer sellCount;

    private Integer wantedCount;

    private Integer reportCount;



    public GoodsCount() {
    }

    public Integer getReportCount() {
        return reportCount;
    }

    public void setReportCount(Integer reportCount) {
        this.reportCount = reportCount;
    }

    public Integer getWantedCount() {
        return wantedCount;
    }

    public void setWantedCount(Integer wantedCount) {
        this.wantedCount = wantedCount;
    }

    public Integer getAllCount() {
        return allCount;
    }

    public void setAllCount(Integer allCount) {
        this.allCount = allCount;
    }

    public Integer getSelloutCount() {
        return selloutCount;
    }

    public void setSelloutCount(Integer selloutCount) {
        this.selloutCount = selloutCount;
    }

    public Integer getSellDownCount() {
        return sellDownCount;
    }

    public void setSellDownCount(Integer sellDownCount) {
        this.sellDownCount = sellDownCount;
    }

    public Integer getSellupCount() {
        return sellupCount;
    }

    @Override
    public String toString() {
        return "GoodCount{" +
                "allCount=" + allCount +
                ", selloutCount=" + selloutCount +
                ", sellDownCount=" + sellDownCount +
                ", sellupCount=" + sellupCount +
                ", sellCount=" + sellCount +
                '}';
    }

    public void setSellupCount(Integer sellupCount) {
        this.sellupCount = sellupCount;
    }

    public Integer getSellCount() {
        return sellCount;
    }

    public void setSellCount(Integer sellCount) {
        this.sellCount = sellCount;
    }
}
