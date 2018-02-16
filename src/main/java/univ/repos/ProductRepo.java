package univ.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import univ.domain.Product;
import univ.domain.Teacher;

@RepositoryRestResource
public interface ProductRepo extends PagingAndSortingRepository<Product, Long> {
}
