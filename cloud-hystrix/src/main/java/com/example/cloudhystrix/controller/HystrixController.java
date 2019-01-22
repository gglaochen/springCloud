    package com.example.cloudhystrix.controller;

    import com.example.cloudhystrix.vo.UserVO;
    import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
    import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
    import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;
    import org.springframework.web.client.RestTemplate;

    /**
     * @author:Administrator
     * @date:2019/1/21/021
     */
    @RestController
    @DefaultProperties(defaultFallback = "defaultFallBack") //定义该类整体的fallback方法
    public class HystrixController {
        @Autowired
        private RestTemplate restTemplate;


//        @HystrixCommand(fallbackMethod = "fallback",
//                    commandProperties={@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
                                                        //标注需要降级的方法和降级的方法fallback，fallback在本类中找，
                                                        // 并且参数和返回值必须和降级方法一致,延迟两秒则降级
    //    @HystrixCommand       //标注后不指定默认返回方法，就用调用类注解上的defaultFallBack,参数ignoreExceptions={RuntimeException.class}就不会对该异常进行降级
        @GetMapping("hi/{id}")
        @HystrixCommand(fallbackMethod  = "fallback")
        public UserVO getUserByID(@PathVariable("id") Integer userId, @RequestParam(defaultValue = "1") int number){
            if(number % 2 ==0){//基数的时候不让其访问服务,测试让基数错误访问多次，再用偶数时依然失败，因为已经熔断了该服务，熔断后走降级方法
                return new UserVO(null,"success",null);
            }
            UserVO userVo = restTemplate.getForObject("http://cloud-provider/user/"+userId, UserVO.class);
            return userVo;
        }
        /*
        降级处理方法
         */
        public UserVO fallback(Integer userId,int str){
            UserVO userVo = new UserVO();
            userVo.setUserName("系统繁忙，请稍后再试,,,,,");
            return userVo;//返回死数据
        }
        public UserVO defaultFallBack(Integer userId){
            UserVO userVo = new UserVO();
            userVo.setUserName("(默认)系统繁忙，请稍后再试,,,,,");
            return userVo;//返回死数据
        }
    }
