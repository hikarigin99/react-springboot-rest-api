package com.example.gccoffee.repository;

import com.example.gccoffee.product.repository.ProductRepository;
import com.example.gccoffee.product.vo.Category;
import com.example.gccoffee.product.vo.Product;
import com.wix.mysql.EmbeddedMysql;
import com.wix.mysql.ScriptResolver;
import com.wix.mysql.config.Charset;
import com.wix.mysql.config.MysqldConfig;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.wix.mysql.distribution.Version.v8_0_11;
import static com.wix.mysql.EmbeddedMysql.anEmbeddedMysql;
import static com.wix.mysql.config.MysqldConfig.aMysqldConfig;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductJdbcRepositoryTest {

    static EmbeddedMysql embeddedMysql;

    @BeforeAll
    static void setUp() {
        MysqldConfig config = aMysqldConfig(v8_0_11)
                .withCharset(Charset.UTF8)
                .withPort(2230)
                .withUser("test", "test1234!")
                .withTimeZone("Asia/Seoul")
                .build();
        embeddedMysql = anEmbeddedMysql(config)
                .addSchema("test-order_mgmt", ScriptResolver.classPathScript("schema.sql"))
                .start();
    }

    @AfterAll
    static void cleanUp() {
        embeddedMysql.stop();
    }

    @Autowired
    ProductRepository repository;

    Product newProduct;

    @BeforeEach
    void setData() {
        newProduct = new Product(UUID.randomUUID(), "test-drink", Category.TEA, 1000L, "test", "test-url", LocalDateTime.now(), LocalDateTime.now());
        repository.insert(newProduct);
    }

    @AfterEach
    void clearData() {
        repository.deleteAll();
    }


    @Test
    @DisplayName("상품을 추가할 수 있다")
    void testInsert() {
        List<Product> all = repository.findAll();

        assertThat(all).isNotEmpty();
    }

    @Test
    @DisplayName("상품을 아이디로 조회할 수 있다.")
    void testFindById() {
        Optional<Product> product = repository.findById(newProduct.getProductId());
        assertThat(product).isPresent();
    }

    @Test
    @DisplayName("상품을 이름으로 조회할 수 있다.")
    void testFindByName() {
        Optional<Product> product = repository.findByName(newProduct.getProductName());
        assertThat(product).isPresent();
    }

    @Test
    @DisplayName("상품을 카테고리로 조회할 수 있다.")
    void testFindByCategory() {
        List<Product> product = repository.findByCategory(newProduct.getCategory());
        assertThat(product).isNotEmpty();
    }

    @Test
    @DisplayName("상품을 수정할 수 있다.")
    void testUpdate() {
        newProduct.setProductName("update_product");
        repository.update(newProduct);

        Optional<Product> product = repository.findById(newProduct.getProductId());

        assertThat(product).isNotEmpty();
        assertThat(product.get()).usingRecursiveComparison().ignoringFields("createdAt", "updatedAt").isEqualTo(newProduct);
    }

    @Test
    @DisplayName("상품을 전체 삭제할 수 있다.")
    void testDeleteAll() {
        repository.deleteAll();
        List<Product> all = repository.findAll();

        assertThat(all).isEmpty();
    }
}