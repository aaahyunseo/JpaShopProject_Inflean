package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    //상품 등록
    @Transactional
    //클래스로 부터의 트랜잭션 설정을 오버라이드하여 readOnl = false로 설정해준 것.
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    //상품 전체 조회
    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    //상품 단건 조회
    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }

    //상품 업데이트
    @Transactional
    public void updateItem(Long itemId,String name, int price, int stockQuantity){
        Item findItem = itemRepository.findOne(itemId);
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);
    }
}
