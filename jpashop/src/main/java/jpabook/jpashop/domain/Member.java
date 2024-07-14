package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded   //내장타입
    private Address address;

    @OneToMany(mappedBy = "member")  //하나의 회원이 여러 개의 항목 주문
    private List<Order> orders = new ArrayList<>();
}
