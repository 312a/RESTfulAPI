package demo.RestfulAPI.controller;

import demo.RestfulAPI.mapper.UserProfileMapper;
import demo.RestfulAPI.model.UserProfile;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestfulAPIController {

    private UserProfileMapper mapper;

//    private Map<String, UserProfile> userMap;

    public RestfulAPIController(UserProfileMapper mapper) {
        this.mapper = mapper;
    }

//    @PostConstruct
//    public void init() {
//        userMap = new HashMap<>();
//        userMap.put("1", new UserProfile("1","추진협","010-2807-4612","서울시 도봉구 쌍문동"));
//        userMap.put("2", new UserProfile("2","추추추","010-4561-4612","서울시 도봉구 방학동"));
//        userMap.put("3", new UserProfile("3","진진진","010-1234-4612","서울시 도봉구 창동"));
//    }

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable("id") String id) {
//        return userMap.get(id);
        return mapper.getUserProfile(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
//        return new ArrayList<UserProfile>(userMap.values());
        return mapper.getUserProfileList();
    }

    @PostMapping("/user/{id}")
    public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,
                                @RequestParam("phone")String phone, @RequestParam("address") String address) {

//        userMap.put(id,new UserProfile(id,name,phone,address));
        mapper.insertUserProfile(id, name, phone, address);
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name,
                                @RequestParam("phone")String phone, @RequestParam("address") String address) {

//        UserProfile userProfile = userMap.get(id);
//        userProfile.setName(name);
//        userProfile.setPhone(phone);
//        userProfile.setAddress(address);
        mapper.updateUserProfile(id, name, phone, address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable("id") String id){
//        userMap.remove(id);
        mapper.deleteUserProfile(id);
    }

}
