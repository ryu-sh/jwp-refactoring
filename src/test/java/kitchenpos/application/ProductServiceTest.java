package kitchenpos.application;

import kitchenpos.dao.ProductDao;
import kitchenpos.domain.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductDao productDao;

    @Autowired
    ProductService productService;

    @DisplayName("상품을 등록하자")
    @Test
    public void createProduct() throws Exception {
        //given
        String productName = "테스트상품";
        BigDecimal price = BigDecimal.valueOf(1000);

        Product product = new Product();
        product.setName(productName);
        product.setPrice(price);

        //when
        Product savedProduct = productService.create(product);

        //then
        assertNotNull(savedProduct.getId());
        assertThat(savedProduct.getName()).isEqualTo(productName);
        assertThat(savedProduct.getPrice()).isEqualByComparingTo(price);
    }

    @DisplayName("가격이 없는 상품은 등록할수 없다")
    @Test
    public void couldNotCreateProductNotExistPrice() throws Exception {
        //given
        String productName = "테스트상품";

        Product product = new Product();
        product.setName(productName);

        //when
        assertThatThrownBy(
                () -> productService.create(product)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가격이 0보다 작은 상품은 등록할수 없다")
    @Test
    public void couldNotCreateProductLessThanZeroPrice() throws Exception {
        //given
        String productName = "테스트상품";
        BigDecimal price = BigDecimal.valueOf(-1000);

        Product product = new Product();
        product.setName(productName);
        product.setPrice(price);

        //when
        assertThatThrownBy(
                () -> productService.create(product)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("상품 리스트를 출력해보자")
    @Test
    public void lists() throws Exception {
        //given
        String productName = "테스트상품";
        BigDecimal price = BigDecimal.valueOf(1000);

        Product product = new Product();
        product.setName(productName);
        product.setPrice(price);

        Product savedProduct = productDao.save(product);

        //when
        List<Product> products = productService.list();
        List<Long> findProductIds = products.stream()
                .map(findProduct -> findProduct.getId())
                .collect(Collectors.toList());

        //then
        assertNotNull(products);
        assertTrue(findProductIds.contains(savedProduct.getId()));
    }
}