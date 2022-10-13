package vn.quangbui26.redis_spring_boot.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Component
public class BookCacheService {

    @CacheEvict(value = "books_list", allEntries = true)
    public void clearBookListCache(){
        System.out.println("clear book list cache");
    }

}
