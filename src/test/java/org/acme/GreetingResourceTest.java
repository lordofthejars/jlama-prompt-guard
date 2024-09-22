package org.acme;


import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.io.IOException;


@QuarkusTest
class GreetingResourceTest {

    @Inject
    GreetingResource gr;

    @Test
    public void test() throws IOException {
        gr.hello();
    }

}