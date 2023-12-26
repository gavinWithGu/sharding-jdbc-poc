package com.shardingsphere.sharding.jpa.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

public class TableHintShardingAlgorithm implements HintShardingAlgorithm {

    @Override
    // availableTargetNames 表示可选择的表名，shardingValue为之前设置好的分表键值
    public Collection<String> doSharding(Collection availableTargetNames, HintShardingValue shardingValue) {
        
    	List<String> singletonList = new ArrayList<String>();
    	singletonList.add("tb_student_1");
    	singletonList.add("tb_student_2");
        return singletonList;
    }

}
