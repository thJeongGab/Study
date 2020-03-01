package com.jth.restapi.events;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder @NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class EventDto {

    @NotEmpty
    private String name;
    @NotNull
    private String description;
    @NotNull
    private LocalDateTime beginEnrollmentDateTime;
    @NotNull
    private LocalDateTime closeEnrollmentDateTime;
    @NotNull
    private LocalDateTime beginEventDateTime;
    @NotNull
    private LocalDateTime endEventDateTime;
    private String location;    // optional
    @Min(0)
    private int basePrice;      // optional
    @Min(0)
    private int maxPrice;       // optional
    @Min(0)
    private int limitOfEnrollment;

}
