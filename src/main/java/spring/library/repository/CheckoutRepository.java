package spring.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.library.domain.Book;
import spring.library.domain.Checkout;

import java.util.List;
import java.util.Optional;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
    Optional<Checkout> findByBookAndIsReturned(Book book, boolean isReturned);

    @Query("select c from Checkout c join fetch c.book WHERE c.member.memberId = :memberId")
    List<Checkout> findByMemberIdFetchMember(Long memberId);
}
