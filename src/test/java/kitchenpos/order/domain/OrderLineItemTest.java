package kitchenpos.order.domain;

import kitchenpos.common.domain.Name;
import kitchenpos.common.domain.Price;
import kitchenpos.common.domain.Quantity;
import kitchenpos.menu.domain.Menu;
import kitchenpos.menu.domain.MenuProduct;
import kitchenpos.menu.domain.MenuProducts;
import kitchenpos.menugroup.domain.MenuGroup;
import kitchenpos.product.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("주문 항목 테스트")
class OrderLineItemTest {

    private Product product;
    private MenuProducts menuProducts;
    private Menu menu;

    @BeforeEach
    void setUp() {
        product = Product.of("강정치킨", BigDecimal.valueOf(17_000));
        menuProducts = MenuProducts.of(Arrays.asList(MenuProduct.of(product, Quantity.of(2))));
        menu = Menu.of(Name.of("강정치킨_두마리_세트_메뉴"), Price.of(BigDecimal.valueOf(30_000)), MenuGroup.of("추천_메뉴_그룹"), menuProducts);
    }

    @DisplayName("주문 항목 생성 성공 테스트")
    @Test
    void instantiate_success() {
        // given
        Quantity quantity = Quantity.of(1);

        // when
        OrderLineItem orderLineItem = OrderLineItem.of(menu, quantity);

        // then
        assertAll(
                () -> assertThat(orderLineItem).isNotNull()
                , () -> assertThat(orderLineItem.getMenu()).isEqualTo(menu)
                , () -> assertThat(orderLineItem.getQuantity()).isEqualTo(quantity)
        );
    }
}