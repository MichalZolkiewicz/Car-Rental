package com.car.rental.controller;

import com.car.rental.domain.CarDto;
import com.car.rental.facade.CarFacade;
import com.google.gson.Gson;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(CarController.class)
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarFacade carFacade;

    @Test
    void shouldGetAllCars() throws Exception {
        CarDto carDto = CarDto.builder()
                .id(10L)
                .brand("test")
                .model("test")
                .price(1000.00)
                .consumption(5.0)
                .kilometersStart(100L)
                .build();

        List<CarDto> carDtoList = new ArrayList<>();
        carDtoList.add(carDto);

        when(carFacade.getAllCars()).thenReturn(carDtoList);

        mockMvc
              .perform(MockMvcRequestBuilders
                    .get("/v1/cars")
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].brand", Matchers.is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].model", Matchers.is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].price", Matchers.is(1000.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].consumption", Matchers.is(5.0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].kilometersStart", Matchers.is(100)));
    }

    @Test
    void shouldGetCar() throws Exception {
        CarDto carDto = CarDto.builder()
                .id(10L)
                .brand("test")
                .model("test")
                .price(1000.00)
                .consumption(5.0)
                .kilometersStart(100L)
                .build();



        when(carFacade.getCarDto(10)).thenReturn(carDto);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/cars/{carId}", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(10)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.brand", Matchers.is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.model", Matchers.is("test")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", Matchers.is(1000.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.consumption", Matchers.is(5.0)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.kilometersStart", Matchers.is(100)));
    }

    @Test
    void shouldAddCar() throws Exception {
        CarDto carDto = CarDto.builder()
                .id(10L)
                .brand("test")
                .model("test")
                .price(1000.00)
                .consumption(5.0)
                .kilometersStart(100L)
                .build();

        when(carFacade.saveCar(carDto)).thenReturn(carDto.getId());

        Gson gson = new Gson();
        String jsonContent = gson.toJson(carDto);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/cars")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shoudlDeleteCar() throws Exception {
        CarDto carDto = CarDto.builder()
                .id(10L)
                .brand("test")
                .model("test")
                .price(1000.00)
                .consumption(5.0)
                .kilometersStart(100L)
                .build();

        when(carFacade.saveCar(carDto)).thenReturn(carDto.getId());

        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/v1/cars/{carId}", 10)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldUpdateCarStatus() throws Exception {
        CarDto carDto = CarDto.builder()
                .id(10L)
                .brand("test")
                .model("test")
                .price(1000.00)
                .status("available")
                .consumption(5.0)
                .kilometersStart(100L)
                .build();

        when(carFacade.updateCarStatus(carDto.getId(), carDto.getStatus())).thenReturn(carDto.getId());

        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/cars/{carId}", 10)
                        .param("status", "available")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
