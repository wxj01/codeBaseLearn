package com.wxj.codebaselearn.pool.sbpool;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wxj
 * @version 1.0
 * @description: TODO
 * @date 2021/8/13 0013 11:10
 */

@RestController
public class SbPoolController {

    @Resource
    private AsyncService asyncService;

    @GetMapping("/async")
    public void async(){
        asyncService.executeAsync();
    }



}