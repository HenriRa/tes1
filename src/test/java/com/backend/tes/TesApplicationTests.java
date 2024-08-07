package com.backend.tes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class  TesApplicationTests {

	@Test
	void contextLoads() {
	}

}
