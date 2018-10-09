package com.kaitait.webflux.Highway;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;


import reactor.core.Disposable;
import reactor.core.publisher.Flux;
@Service
public class  HighwayTraffic {

    private static Logger LOGGER = LoggerFactory.getLogger(HighwayTraffic.class);
    private static DecimalFormat plateFormatNumber = new DecimalFormat("0000");

    public HighwayTraffic() {
    }

    public Flux<Vehicle> flowTraffic() {
        LocalDateTime startTime = LocalDateTime.now();

        return Flux.<Vehicle>create(fluxSink -> {
            boolean inFrameTime = true;
            int index = 1;
            while (index <= 30000 && inFrameTime && !fluxSink.isCancelled() ) {
                fluxSink.next(HighwayUtilities.simulateTraffic());
                index++;

                long timeMinutesHighwayOpened = startTime.until(LocalDateTime.now(),
                        ChronoUnit.MILLIS);
                if (timeMinutesHighwayOpened > 30000) {
                    LOGGER.info("TrafficSimulator finish --> With timer");
                    inFrameTime = false;
                }
            }
        }).share();
    }

    private static String[] COLORS = { "Blue", "White", "Silver", "Black", "Metalic Green", "Orange", "Yellow" };
    private static String[] GAS_TYPE = { "Diesel", "Gasoline", "Gas", "Eletric", "Alcohol" };

    private static class HighwayUtilities {

        private static Vehicle simulateTraffic() {

            String carPlateNumber = RandomStringUtils.randomAlphanumeric(6, 10);


            Long weight = ThreadLocalRandom.current().nextLong(250L, 4500L);
            Integer speed = ThreadLocalRandom.current().nextInt(60, 175);

            String color = COLORS[ThreadLocalRandom.current().nextInt(0, 6)];
            Integer modelYear = ThreadLocalRandom.current().nextInt(1975, 2018);
            String gasType = GAS_TYPE[ThreadLocalRandom.current().nextInt(0, 4)];

            return new Vehicle(carPlateNumber, weight, speed, color, modelYear, gasType);
        }

    }

}
