package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery" , fetch = FetchType.LAZY)
    //order 테이블의 delivery에 의해서 매핑되었음.
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)    //꼭 STRING 사용하기! ORDINAL 사용 시 ENUM이 추가되면 인덱스가 밀림.
    private DeliveryStatus status;  //READY, COMP
}
