package com.kiszka.BookStore.dbconnection;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookPaginationRepo extends PagingAndSortingRepository<Book,Integer> {
}
