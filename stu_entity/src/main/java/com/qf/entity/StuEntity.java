package com.qf.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_student")
public class StuEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer sid;
    private String sname;
    private String spwd;
    private Integer sage;
    private Integer cid;
    @TableField(exist = false)
    private ClassEntity cla;
}
