package com.wanted.aop.section02;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@Data 쓸 수 있는데 권장하진 않음
public class MemberDTO {

    private String email;
    private String password;
    private String name;
    private String phone;
    private String role;


}
