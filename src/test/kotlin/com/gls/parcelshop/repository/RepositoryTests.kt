package com.gls.parcelshop.repository;

import com.gls.parcelshop.model.Address;
import com.gls.parcelshop.model.DeliveryState;
import com.gls.parcelshop.model.Parcel;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RepositoryTests {

    @Autowired
    private ParcelRepository parcelRepository;

    @BeforeEach
    void cleanup(){
        parcelRepository.deleteAll();
    }

    @Test
    void testCreateParcel() {
        parcelRepository.save(Parcel.builder()
                .address(createDefaultAddress())
                .parcelNumber("1000")
                .deliveryDate("20200421")
                .deliveryState(DeliveryState.OUT_FOR_DELIVERY)
                .build());

        List<Parcel> parcels = parcelRepository.findAll();
        Assertions.assertEquals(1, parcels.size());
    }

    private Address createDefaultAddress() {
        return Address.builder()
                .consignee("GLS")
                .street("Kemperplatz")
                .number("1")
                .zip("10785")
                .build();
    }
}
