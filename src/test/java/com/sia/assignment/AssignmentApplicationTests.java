package com.sia.assignment;

import com.sia.assignment.domain.Region;
import com.sia.assignment.dto.AreaRequestDto;
import com.sia.assignment.repository.RegionRepository;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.jupiter.api.*;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AssignmentApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RegionRepository regionRepository;

    @AfterEach
    void tearDown() {
        // releases resources after each test method
//        regionRepository.deleteAll();
    }

    @Test
    public void saveRegion() throws ParseException {
        String name = "서울시";
        String area = "POLYGON ((126.835 37.688, 127.155 37.702, 127.184 37.474, 126.821 37.454, 126.835 37.688))";
//        Polygon area = (Polygon) wktToGeometry("POLYGON ((126.835 37.688, 127.155 37.702, 127.184 37.474, 126.821 37.454, 126.835 37.688))");


        AreaRequestDto requestDto = new AreaRequestDto(name, area);
        Polygon polygon = (Polygon) wktToGeometry(requestDto.getArea());
        Region region = requestDto.toEntity(polygon);

        String url = "http://localhost:" + port + "/regions";

//        ResponseEntity<Region> response = restTemplate.postForEntity(url, region, Region.class);

    }

    private Geometry wktToGeometry(String wellKnownText) throws ParseException {
        WKTReader fromText = new WKTReader();
        Geometry geom = null;
        geom = fromText.read(wellKnownText);
        return geom;
    }


}
