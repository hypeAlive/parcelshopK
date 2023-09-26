package com.gls.parcelshop;

import com.gls.parcelshop.model.Address;
import com.gls.parcelshop.model.DeliveryState;
import com.gls.parcelshop.model.Parcel;
import com.gls.parcelshop.repository.ParcelRepository;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AppStartupRunner implements ApplicationRunner {

    @Autowired
    private ParcelRepository parcelRepository;

    @Override
    public void run(ApplicationArguments args) {
        log.info("Your application started with option names : {}", args.getOptionNames());

        parcelRepository.saveAll(Arrays.asList(Parcel.builder()
                        .address(Address.builder()
                                .consignee("GLS")
                                .street("Kemperplatz")
                                .number("1")
                                .zip("10785")
                                .build())
                        .deliveryState(DeliveryState.OUT_FOR_DELIVERY)
                        .parcelNumber("1000")
                        .deliveryDate("20200421")
                        .build(),
                Parcel.builder()
                        .address(Address.builder()
                                .consignee("GLS")
                                .street("Kemperplatz")
                                .number("1")
                                .zip("10785")
                                .build())
                        .deliveryState(DeliveryState.OUT_FOR_DELIVERY)
                        .parcelNumber("1001")
                        .deliveryDate("20200421")
                        .build(),
                Parcel.builder()
                        .address(Address.builder()
                                .consignee("Max Mustermann")
                                .street("Weinbergsweg")
                                .number("2")
                                .zip("10119")
                                .build())
                        .deliveryState(DeliveryState.OUT_FOR_DELIVERY)
                        .parcelNumber("1002")
                        .deliveryDate("20200421")
                        .build(),
                Parcel.builder()
                        .address(Address.builder()
                                .consignee("Hans Meier")
                                .street("Weinbergsweg")
                                .number("3")
                                .zip("10119")
                                .build())
                        .deliveryState(DeliveryState.DELIVERED)
                        .parcelNumber("1003")
                        .deliveryDate("20200421")
                        .build(),
                Parcel.builder()
                        .address(Address.builder()
                                .consignee("GLS")
                                .street("Kemperplatz")
                                .number("1")
                                .zip("10785")
                                .build())
                        .deliveryState(DeliveryState.READY_FOR_DELIVERY)
                        .parcelNumber("1000")
                        .deliveryDate("20200420")
                        .build()));
    }
}
