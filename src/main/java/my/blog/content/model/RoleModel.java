package my.blog.content.model;

import lombok.Getter;
import lombok.Setter;
import my.blog.content.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RoleModel extends BaseEntity {

    @NotNull
    @Size(max = 30)
    @Getter
    @Setter
    private String name;

    @NotNull
    @Min(value=1)
    @Max(value=999)
    @Getter
    @Setter
    private Integer list;// 排序

    @Getter
    @Setter
    private String info;

    @Getter
    @Setter
    private boolean system;// 是否系统自带
}
