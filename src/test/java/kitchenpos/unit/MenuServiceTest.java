package kitchenpos.unit;

//@SpringBootTest
//@Transactional
public class MenuServiceTest {

//	@Autowired
//	private MenuService menuService;
//
//	@BeforeEach
//	void setUp() {
//
//	}
//
//	@Test
//	@DisplayName("메뉴를 등록한다")
//	void createMenu() {
//		List<MenuProductRequest> menuProductRequests = new ArrayList<>();
//		MenuProductRequest menuProductRequest = new MenuProductRequest(1L, 1L);
//		menuProductRequests.add(menuProductRequest);
//		MenuRequest menuRequest = new MenuRequest("양념치킨", BigDecimal.valueOf(16_000), 1L, menuProductRequests);
//
//		MenuResponse menuResponse = menuService.create(menuRequest);
//		assertThat(menuResponse.getName()).isEqualTo("양념치킨");
//	}
//
//	@Test
//	@DisplayName("메뉴 등록 시 가격이 null 또는 0 미만이면 에러")
//	void givenPriceUnderZeroOrNullWhenCreateMenuThenError() {
//		List<MenuProductRequest> menuProductRequests = new ArrayList<>();
//		MenuProductRequest menuProductRequest = new MenuProductRequest(1L, 2L);
//		menuProductRequests.add(menuProductRequest);
//		MenuRequest menuRequest = new MenuRequest("양념치킨", BigDecimal.valueOf(-1), 1L, menuProductRequests);
//		assertThrows(IllegalArgumentException.class, () -> menuService.create(menuRequest));
//	}
//
//	@Test
//	@DisplayName("메뉴 목록을 조회한다")
//	void listMenu() {
//		List<MenuResponse> menuResponses = menuService.listMenus();
//		assertThat(menuResponses.size()).isEqualTo(6);
//	}
}