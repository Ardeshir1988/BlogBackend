package ir.ardeshirahouri.backendblog.dto;


import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class DashboardStatistics  {

    private Integer postQuantity;
    private Integer categoryQuantity;
    private Integer tagQuantity;
    private Integer totalView;
    DashboardStatistics(){}

    public DashboardStatistics(Integer postQuantity, Integer categoryQuantity, Integer tagQuantity, Integer totalView) {
        this.postQuantity = postQuantity;
        this.categoryQuantity = categoryQuantity;
        this.tagQuantity = tagQuantity;
        this.totalView = totalView;
    }
}
