package com.wxj.codebaselearn.algorithm;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO  echarts 饼图占比算法 最大余额算法
 * @date 2022/1/7 0007 8:54
 */
public class MaximumBalance {

    //测试
    //    var arr= [867623,60120,30966,72853,267099,207596,201185,253750,456895,43361]
    //    console.log(getPercentValue(arr,0,2))   ;

    // 测试方法  业务分布  饼图占比的算法：最大余额算法
   /* function getPercentValue (valueList, idx, precision) {
        // 判断是否为空
        if (!valueList[idx]) {
            return 0;
        }
        // 求和 2461448
        var sum = valueList.reduce(function (acc, val) {
            return acc + (isNaN(val) ? 0 : val);
        }, 0)
        if (sum === 0) {
            return 0;
        }
        // 10的2次幂是100，用于计算精度。
        var digits = Math.pow(10, precision);
        // 扩大比例100，
        var votesPerQuota = valueList.map(function (val) {
            return (isNaN(val) ? 0 : val) / sum * digits * 100;
        })
        // 总数，扩大比例意味的总数要扩大
        var targetSeats = digits * 100;
        // 再向下取值，组成数组
        var seats = votesPerQuota.map(function (votes) {
            return Math.floor(votes);
        })
        // 再新计算合计，用于判断与总数量是否相同，相同则占比会100%
        var currentSum = seats.reduce(function (acc, val) {
            return acc + val;
        }, 0)
        // 余数部分的数组：原先数组减去向下取值的数组，得到余数部分的数组
        var remainder = votesPerQuota.map(function (votes, idx) {
            return votes - seats[idx];
        })
        // 给最大最大的余额加1，凑个占比100%；
        while (currentSum < targetSeats) {
            //  找到下一个最大的余额，给其加1
            var max = Number.NEGATIVE_INFINITY;
            var maxId = null;
            for (var i = 0, len = remainder.length; i < len; ++i) {
                if (remainder[i] > max) {
                    max = remainder[i];
                    maxId = i;
                }
            }
            // 对最大项余额加1
            ++seats[maxId];
            // 已经增加最大余数加1，则下次判断就可以不需要再判断这个余额数。
            remainder[maxId] = 0;
            // 总的也要加1，为了判断是否总数是否相同，跳出循环。
            ++currentSum;
        }
        // 这时候的seats就会总数占比会100%
        return seats[idx] / digits
    }*/
}