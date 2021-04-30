package com.example.demo.repo;

import com.example.demo.Book;
import com.example.demo.model.Library;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryRepo {
    Optional<Library> findById(long id);
    Library save(Library library);
    Library findByIdAndDeletedAtIsNull(Long id);
    Library findByNameAndDeletedAtIsNull(String name);
    Library findByAddressAndDeletedAtIsNull(String address);
    Library findByPhoneNumberAndDeletedAtIsNull(String phoneNumber);
    Library findByCityAndDeletedAtIsNull(String city);
    Library findByStateAndDeletedAtIsNull(String state);
    List<Library> findAllByDeletedAtIsNull();
    List<Library> findAllByIdAndDeletedAtIsNull(long id);
}
