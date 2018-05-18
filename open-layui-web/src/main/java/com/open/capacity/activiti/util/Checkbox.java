package com.open.capacity.activiti.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: [gitgeek]
 * @Date: [2018-05-17 21:18]
 * @Description: [ 复选框类 ]
 * @Version: [1.0.0]
 * @Copy: [com.zzg]
 */
@Getter
@Setter
public class Checkbox {
    private String id;
    private String name;
    /**默认未选择*/
    private boolean check=false;

}
