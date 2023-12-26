package com.shardingsphere.sharding.jpa.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

public class TablePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {

	private static List<String>tableNeedToBeSharded = new ArrayList<>();
	
	private static int table_total_count;
	
	static{
		tableNeedToBeSharded.add("student");
		table_total_count = 3;
	}
	
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {
        
        if(tableNeedToBeSharded.contains(shardingValue.getLogicTableName())) {
        	int value = shardingValue.getValue();
            return "tb_student_" + (table_total_count - value % table_total_count);
        }else {
        	return shardingValue.getLogicTableName();
        }
       
    }

}
