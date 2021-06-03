package com.mesakiiyui.dm.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity // This tells Hibernate to make a table out of this class
@ApiModel(description = "城市实体")
@Table(name="city")
public class City  implements Serializable {

    private static final long serialVersionUID = -6384426496619531976L;
    @Id
    @NotNull
    @ApiModelProperty(value = "主键", position = 0)
    @Min(1)
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @ApiModelProperty(value = "城市名称", position = 1)
    @Column(name = "Name")
    private String name;

    @ApiModelProperty(value = "城市代码", position = 2)
    @Column(name = "CountryCode")
    private String countryCode;

    @ApiModelProperty(value = "区域", position = 3)
    @Column(name = "District")
    private String district;

    @ApiModelProperty(value = "人口", position = 4)
    @Column(name = "Population")
    private Integer population;

}
