package demo.RestfulAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class UserProfile {
    private String id;
    private String name;
    private String phone;
    private String address;

}
