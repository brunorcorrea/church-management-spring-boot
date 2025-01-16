package bruno.correa.churchmanagementspringboot.domain.entity;

import lombok.Getter;

@Getter
public enum Role {

    MEMBER("Member", 1),
    PASTOR("Pastor", 2);

    private String name;
    private Integer order;

    Role(String name, Integer order) {}
}
